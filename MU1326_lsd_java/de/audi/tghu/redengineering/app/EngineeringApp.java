/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.redengineering.app;

import de.audi.atip.hmi.HMIApplication;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.ScreenDebugInfoEvent;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.model.ListCell;
import de.audi.atip.hmi.model.TextListCell;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.power.PowerEventListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;
import de.audi.tghu.redengineering.app.AudioManagementHandler;
import de.audi.tghu.redengineering.app.BundlesInfo;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.redengineering.app.FSCViewer;
import de.audi.tghu.redengineering.app.LogAdapter;
import de.audi.tghu.redengineering.app.SystemInfo;
import de.audi.tghu.swdl.ude.IEApplication;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import org.osgi.framework.BundleContext;

public class EngineeringApp
implements HMIApplication,
MsgListener,
PowerEventListener,
ButtonListener,
TimerListener {
    private static final long UP_TIME_START = System.currentTimeMillis();
    private static final int MODULE_ID = 13;
    private final BundlesInfo bundlesInfo;
    private final SystemInfo systemInfo;
    private final FSCViewer fscViewer;
    public static boolean hmiActive;
    private Timer upTimeTimer;
    private Timer memPollTimer;
    private IEApplication udeApp;
    private final EngineeringEnv engineeringEnv;
    private final AudioManagementHandler audioMgmtHandler;

    protected EngineeringApp(BundleContext bundleContext, EngineeringEnv engineeringEnv, AudioManagementHandler audioManagementHandler) {
        this.engineeringEnv = engineeringEnv;
        this.audioMgmtHandler = audioManagementHandler;
        ListModelApp listModelApp = this.getHMIService().getListModel(1300001);
        this.bundlesInfo = new BundlesInfo(bundleContext, listModelApp);
        this.systemInfo = new SystemInfo(engineeringEnv, this);
        this.fscViewer = new FSCViewer(engineeringEnv);
        new LogAdapter(engineeringEnv);
        this.getHMIService().getListModel(1300003).setMaxRows(100);
        this.getHMIService().getListModel(1300003).setMaxColumns(3);
        this.getHMIService().getButtonModel(1300000).setButtonListener(this);
        this.getHMIService().getButtonModel(1300011).setButtonListener(this);
        this.getHMIService().getButtonModel(1300026).setButtonListener(this);
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    final AudioManagementHandler getAudioManagementHandler() {
        return this.audioMgmtHandler;
    }

    private final HMIService getHMIService() {
        return this.getEngineeringEnv().getHMIService();
    }

    private final LogChannel getLogMain() {
        return this.getEngineeringEnv().getLogMain();
    }

    public AbstractEngineeringTextFactory getTextFactory() {
        return this.getEngineeringEnv().getTextFactory();
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.upTimeTimer)) {
            long l = System.currentTimeMillis() - UP_TIME_START;
            long l2 = l / 1000L;
            long l3 = l2 / 60L;
            int n = (int)l3 / 60;
            l2 -= l3 * 60L;
            l3 -= (long)(n * 60);
            Buffer buffer = new Buffer(20);
            if (n == 0) {
                buffer.append("00");
            } else if (n < 10) {
                buffer.append('0');
                buffer.append(n);
            } else {
                buffer.append(n);
            }
            buffer.append(':');
            if (l3 == 0L) {
                buffer.append("00");
            } else if (l3 < 10L) {
                buffer.append('0');
                buffer.append(l3);
            } else {
                buffer.append(l3);
            }
            buffer.append(':');
            if (l2 < 10L) {
                buffer.append('0');
                buffer.append(l2);
            } else {
                buffer.append(l2);
            }
            String string = buffer.toString();
            this.getHMIService().getLabelModel(1300068).setText(string);
            this.getHMIService().getLabelModel(1300048).setText(string);
        } else if (timer.equals(this.memPollTimer)) {
            this.getEngineeringEnv().getDebugLabel().setText(this.systemInfo.updateSystemMemory());
        }
    }

    public int getId() {
        return 13;
    }

    public ButtonModelApp getVirtualButton(int n) {
        return null;
    }

    public void hmiActivated(int n) {
        this.getLogMain().log(1000000, "Engineering HMI activated");
        hmiActive = true;
        this.bundlesInfo.getCurrentBundleInfo(true);
        this.systemInfo.fillSwAuthorizationList();
        this.systemInfo.fillParameter();
    }

    public void hmiDeactivated(int n) {
        this.getLogMain().log(1000000, "Engineering HMI deactivated");
        hmiActive = false;
    }

    public BundlesInfo getBundlesInfo() {
        return this.bundlesInfo;
    }

    public SystemInfo getSystemInfo() {
        return this.systemInfo;
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 1300000: {
                this.getHMIService().getChoiceModel(112).setValue(0);
                break;
            }
            case 1300011: {
                break;
            }
            case 1300026: {
                this.installJXE();
                break;
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void popupHidden(int n, int n2) {
    }

    public void popupRemoved(int n, int n2) {
    }

    public void popupVisible(int n, int n2) {
    }

    public void screenFadedOut(int n, int n2) {
    }

    public void screenConnected(int n, int n2) {
    }

    public void processMsg(int n) {
        if (this.getEngineeringEnv().isRebootToDownload()) {
            return;
        }
        if (n == 3) {
            Object object;
            if (!this.getEngineeringEnv().isOfficialRelease()) {
                this.getHMIService().setUnsupportedDevelopmentBuild(true);
                object = new Buffer(500);
                ((Buffer)object).append(Formatter.LINE_SEPARATOR);
                ((Buffer)object).append("####################################################").append(Formatter.LINE_SEPARATOR);
                ((Buffer)object).append("#  e.solutions HMI - UNSUPPORTED DEVELOPMENT BUILD #").append(Formatter.LINE_SEPARATOR);
                ((Buffer)object).append("####################################################").append(Formatter.LINE_SEPARATOR);
                this.getEngineeringEnv().getLogBenchmark().log(1000, "%1", object);
            }
            if (this.getEngineeringEnv().isTarget() && (object = this.getEngineeringEnv().getTargetIntegrityInfo()) != null && ((Object)object).length > 0) {
                ScreenDebugInfoEvent screenDebugInfoEvent = new ScreenDebugInfoEvent(this.getHMIService().getRootWindow(0), (String[])object, 13);
                this.getHMIService().getEventDispatcher().postEvent(screenDebugInfoEvent);
            }
            object = this.getEngineeringEnv().getVersionInfo();
            int n2 = 0;
            ListCell[] listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantHMIVersion()), new TextListCell(object.getHMIVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantHMIVersion()).append(object.getHMIVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantTextToolVersion()), new TextListCell(object.getTextToolVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantTextToolVersion()).append(object.getTextToolVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantTextToolSDSVersion()), new TextListCell(object.getTextToolSDSVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantTextToolSDSVersion()).append(object.getTextToolSDSVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            if (this.getTextFactory().getTextConstantOptionDrawerVersion() != null) {
                listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantOptionDrawerVersion()), new TextListCell(object.getOptionDrawerVersion()), new IntegerListCell(n2++, 7)};
                listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantOptionDrawerVersion()).append(object.getOptionDrawerVersion()).toString());
                this.getHMIService().getListModel(1300003).addRow(listCellArray);
            }
            listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantDsiIfcVersion()), new TextListCell(object.getDsiIfcVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantDsiIfcVersion()).append(object.getDsiIfcVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantFrameworkVersion()), new TextListCell(object.getFrameworkVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantFrameworkVersion()).append(object.getFrameworkVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            listCellArray = new ListCell[]{new TextListCell(this.getTextFactory().getTextConstantKanziVersion()), new TextListCell(object.getKanziVersion()), new IntegerListCell(n2++, 7)};
            listCellArray[0] = new TextListCell(new StringBuffer().append(this.getTextFactory().getTextConstantKanziVersion()).append(object.getKanziVersion()).toString());
            this.getHMIService().getListModel(1300003).addRow(listCellArray);
            this.hmiActivated(-2);
        }
    }

    public final void startUpTimeTimer() {
        if (this.upTimeTimer == null) {
            this.upTimeTimer = new Timer("Uptime", 1000L, false, this);
        }
        this.upTimeTimer.restart();
    }

    public final void stopUpTimeTimer() {
        this.upTimeTimer.cancel();
        this.getHMIService().getLabelModel(1300068).setText("");
        this.getHMIService().getLabelModel(1300048).setText("");
    }

    public void enterREM(int n) {
        this.getEngineeringEnv().enterREM();
        if (!this.getEngineeringEnv().isRebootToDownload()) {
            this.getLogMain().log(10000000, "[EngineeringApp] enterREM(): mute audio");
            this.getAudioManagementHandler().muteAudio("enterREM", n);
        }
    }

    public void leaveREM(int n) {
        if (!this.getEngineeringEnv().isRebootToDownload()) {
            this.getLogMain().log(10000000, "[EngineeringApp] leaveREM(): unmute audio");
            this.getAudioManagementHandler().unmuteAudio("leaveREM", n);
        }
        this.getEngineeringEnv().leaveREM();
    }

    final void setRunMemPollTimer(boolean bl) {
        this.getLogMain().log(10000000, "setRunMemPollTimer: %1", bl);
        if (bl) {
            this.startMemPollTimer();
            this.getHMIService().getChoiceModel(1).setValue(1);
        } else {
            this.stopMemPollTimer();
            this.getHMIService().getChoiceModel(1).setValue(0);
        }
    }

    private final void startMemPollTimer() {
        if (this.memPollTimer == null) {
            this.memPollTimer = new Timer("MemoryPollTimer", 5000L, false, this);
        }
        if (this.systemInfo != null) {
            this.getEngineeringEnv().getDebugLabel().setText(this.systemInfo.updateSystemMemory());
        }
        this.memPollTimer.restart();
    }

    private final void stopMemPollTimer() {
        if (this.memPollTimer != null) {
            this.memPollTimer.cancel();
        }
        this.getEngineeringEnv().getDebugLabel().setText("");
    }

    public void screenHidden(int n, int n2) {
    }

    public void screenVisible(int n, int n2) {
    }

    public FSCViewer getFSCViewer() {
        return this.fscViewer;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void copyDirectory(File file, File file2) throws IOException {
        if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            String[] stringArray = file.list();
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                this.copyDirectory(new File(file, stringArray[i2]), new File(file2, stringArray[i2]));
            }
        } else {
            FileInputStream fileInputStream = new FileInputStream(file);
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                int n;
                byte[] byArray = new byte[1024];
                while ((n = ((InputStream)fileInputStream).read(byArray)) > 0) {
                    ((OutputStream)fileOutputStream).write(byArray, 0, n);
                }
            }
            finally {
                ((InputStream)fileInputStream).close();
                ((OutputStream)fileOutputStream).close();
            }
        }
    }

    private void installJXE() {
        File file = new File("/fs/sda0/lsd");
        File file2 = new File("/fs/sdb0/lsd");
        try {
            new ProcessExecuter("/mnt/app/eso/hmi/engdefs/scripts/activateDevelMode.sh").run();
            if (file.exists() && file.isDirectory()) {
                this.copyDirectory(file, new File("/eso/hmi/lsd"));
            } else if (file2.exists() && file2.isDirectory()) {
                this.copyDirectory(file2, new File("/eso/hmi/lsd"));
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
        if (n == 0) {
            this.systemInfo.pwrStateOnReached();
        }
        if (n == 2) {
            this.getHMIService().getChoiceModel(108).setValue(1);
        } else {
            this.getHMIService().getChoiceModel(108).setValue(0);
        }
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    public void notifyPowerTriggerAction(int n, int n2) {
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    public IEApplication getUdeApp() {
        return this.udeApp;
    }

    public void setUdeApp(IEApplication iEApplication) {
        this.udeApp = iEApplication;
    }

    private class ProcessReader
    implements Runnable {
        private final Process process;
        private final boolean error;

        public ProcessReader(Process process, boolean bl) {
            this.process = process;
            this.error = bl;
        }

        public void run() {
            InputStream inputStream = this.error ? this.process.getErrorStream() : this.process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String string;
                while ((string = bufferedReader.readLine()) != null) {
                    System.out.println(string);
                    Thread.sleep(1000L);
                    EngineeringApp.this.getHMIService().getLabelModel(147).setText(string);
                }
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
            catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
    }

    private class ProcessExecuter
    implements Runnable {
        private final String command;

        public ProcessExecuter(String string) {
            this.command = string;
        }

        public void run() {
            Runtime runtime = Runtime.getRuntime();
            try {
                Process process = runtime.exec(this.command);
                Thread thread = new Thread(new ProcessReader(process, true));
                thread.start();
                Thread thread2 = new Thread(new ProcessReader(process, false));
                thread2.start();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

