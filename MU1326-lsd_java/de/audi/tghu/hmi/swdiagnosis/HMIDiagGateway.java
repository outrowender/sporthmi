/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.swdiagnosis;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.RSEJointEvent;
import de.audi.atip.hmi.event.ScreenShotEvent;
import de.audi.atip.hmi.event.ShowScreenEvent;
import de.audi.atip.hmi.model.AbstractModel;
import de.audi.atip.hmi.model.IntegerListCell;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.view.IGUIManager;
import de.audi.atip.hmi.view.IWidgetDiagnosis;
import de.audi.atip.hmi.view.Screen;
import de.audi.atip.hmi.view.WidgetInfoDiag;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.ActionProxyStatistics;
import de.audi.atip.util.ModelStatistics;
import de.audi.atip.util.Util;
import de.audi.tghu.fwhmi.FwHMI;
import de.audi.tghu.hmi.swdiagnosis.HMIDiagGateway$1;
import de.audi.tghu.hmi.swdiagnosis.HMIDiagGateway$2;
import de.esolutions.fw.util.commons.Buffer;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.HashMap;

public class HMIDiagGateway
extends AbstractSwDiagnosis {
    private static int screenShowInterval = 2000;
    protected final FwHMI fwHMI;
    private final LogChannel logDiashow;
    private int currentScreen = -1;
    private String[] currentErrors = null;
    private HashMap cmdDescriptionMap = null;

    public HMIDiagGateway(FwHMI fwHMI) {
        this.fwHMI = fwHMI;
        this.logDiashow = fwHMI.getFramework().getLogChannel("Ext.Diashow");
    }

    @Override
    public int getId() {
        return 102;
    }

    @Override
    public String getName() {
        return "FwHMI";
    }

    protected final IFrameworkAccess getFramework() {
        return this.fwHMI.getFramework();
    }

    protected final long getMonotonicTime() {
        return this.getFramework().getMonotonicTime();
    }

    public Object getReleaseLabel() {
        return System.getProperty("ReleaseLabel");
    }

    public Object getCurrentScreenData() {
        return this.fwHMI.getCurrentScreenData();
    }

    public Object getCurrentConnectedScreenData() {
        return this.fwHMI.getCurrentConnectedScreenData();
    }

    public Object getCurrentKeypanelType() {
        return Util.createInteger(this.fwHMI.getHMITerminal(0).getKbdService().getCurrentKeyboardType());
    }

    public Object getCurrentPopupId() {
        return new Integer(this.fwHMI.getCurrentPopup());
    }

    public Object getEventQueueSize() {
        return new Integer(this.fwHMI.getEventDispatcherAdmin().getStatisticData()[0]);
    }

    public Object getEventStatistic() {
        if (AbstractModel.statistics != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            AbstractModel.statistics.dump(printStream);
            printStream.flush();
            return byteArrayOutputStream.toString();
        }
        return "EventStatistic not active!";
    }

    public Object getCriticalModelCalls() {
        if (AbstractModel.statistics != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            AbstractModel.statistics.dumpCriticalMethodCalls(printStream);
            ActionProxyStatistics.getInstance().dumpCriticalMethodCalls(printStream);
            printStream.flush();
            return byteArrayOutputStream.toString();
        }
        return "EventStatistic not active!";
    }

    public Object getEventQueueHistory() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        this.fwHMI.getEventDispatcherAdmin().dump(printStream);
        printStream.flush();
        return byteArrayOutputStream.toString();
    }

    public Object getEventQueueContent() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        this.fwHMI.getEventDispatcherAdmin().dumpEventQueue(printStream);
        printStream.flush();
        return byteArrayOutputStream.toString();
    }

    public Object getWidgetInfosOfCurrentScreen() {
        Screen screen = this.fwHMI.getRootWindow(0).getCurrentScreen();
        Buffer buffer = new Buffer(16384);
        if (screen instanceof IWidgetDiagnosis) {
            WidgetInfoDiag.generateWidgetInfoXML(screen, buffer, 1, null);
        }
        return buffer.toString();
    }

    public Object getModelIDsOfCurrentScreen() {
        Screen screen = this.fwHMI.getRootWindow(0).getCurrentScreen();
        int[] nArray = screen.getViewIDs();
        Buffer buffer = new Buffer(200);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            buffer.append(nArray[i2]);
            buffer.append(',');
        }
        return buffer.toString();
    }

    public Object getCurrentScreenId() {
        return new Integer(this.fwHMI.getRootWindow(0).getCurrentScreen().getID());
    }

    public void cmdEventStatisticStart() {
        AbstractModel.statistics = new ModelStatistics();
    }

    public void cmdEventStatisticStop() {
        AbstractModel.statistics = null;
    }

    public void cmdEventStatisticReset() {
        if (AbstractModel.statistics != null) {
            AbstractModel.statistics.reset();
        }
    }

    public void cmdShowScreen(int n) {
        this.doShowScreen(n, 0, 0);
    }

    public void cmdShowScreen(int n, int n2) {
        this.doShowScreen(n, n2, 0);
    }

    public void cmdShowScreenForTerminal(int n, int n2) {
        this.doShowScreen(n, 0, n2);
    }

    private void doShowScreen(int n, int n2, int n3) {
        System.gc();
        ShowScreenEvent showScreenEvent = new ShowScreenEvent(this.fwHMI.getRootWindow(n3), 0);
        showScreenEvent.setScreenId(n);
        showScreenEvent.setTerminalId(n3);
        showScreenEvent.setColorScheme(n2);
        this.fwHMI.getEventDispatcher().postEvent(showScreenEvent);
    }

    public void cmdReloadScreen() {
        try {
            int n = this.fwHMI.getCurrentScreenID();
            this.cmdShowScreen(1);
            Thread.sleep(0);
            this.cmdClearScreenCache();
            this.cmdShowScreen(n);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void cmdClearScreenCache() {
        this.fwHMI.getHMITerminal(0).getScreenCache().clear();
    }

    public void cmdShowScreenCombi(int n) {
        System.gc();
        ShowScreenEvent showScreenEvent = new ShowScreenEvent(this.fwHMI.getRootWindow(1), 0);
        showScreenEvent.setScreenId(n);
        this.fwHMI.getEventDispatcher().postEvent(showScreenEvent);
    }

    public void cmdDiashowMarkAsFlawed(String string) {
        this.diashowMarkCurrentAsFlawed(string);
    }

    public void cmdDiashowAutomaticInterval(int n) {
        screenShowInterval = n;
    }

    public void cmdDiashowAutomaticEnableScreenshots(boolean bl, String string, boolean bl2) {
        if (bl) {
            if (screenShowInterval < 3000) {
                screenShowInterval = 3000;
            }
        } else {
            screenShowInterval = 500;
        }
    }

    public void cmdDiashowManualComplete() {
    }

    public void cmdTakeScreenshot(String string, boolean bl) {
        this.logDiashow.log(-2137614336, "Taking screenshot and saving to %1 ...", (Object)string);
        if (string == null || string.length() == 0) {
            string = this.fwHMI.getFramework().isTarget() ? "/mnt/ota/system/logs/" : "C:\\temp\\";
        }
        if (bl) {
            ScreenShotEvent screenShotEvent = new ScreenShotEvent((ATIPEventListener)this.fwHMI.getRootWindow(0), string);
            this.fwHMI.getEventDispatcher().postEvent(screenShotEvent);
        } else {
            String string2 = new StringBuffer().append(string).append("screen_").append(this.fwHMI.getCurrentScreenID()).append(".png").toString();
            this.fwHMI.takeScreenshot(0, string2);
        }
    }

    public void cmdFireSDSEvent(int n, int n2) {
        this.fwHMI.fireSDSEvent(2, n, n2, new int[0]);
    }

    public void cmdShowFullScreenFeedback(int n) {
        this.fwHMI.showVisualFeedback(n, null, 0);
    }

    public void cmdShowTextFeedback(String string, int n) {
        this.fwHMI.showVisualFeedback(n, string, 0);
    }

    public void cmdReadAnimationParameters(String string) {
        if (string == null || string.length() == 0) {
            string = this.fwHMI.getFramework().isTarget() ? "/fs/sda0/animConfigFile" : "C:\\temp\\animConfigFile";
        }
        this.fwHMI.getHMITerminal(0).getIAnimationController().readAnimationParametersFromFile(string);
    }

    public void cmdSetJointState(int n) {
        this.fwHMI.getEventDispatcher().postEvent(new RSEJointEvent(this.fwHMI.getRootWindow(5), n));
    }

    public void cmdPopupShow(int n) {
        this.fwHMI.showPopup(n);
    }

    public void cmdPopupHide(int n) {
        this.fwHMI.removePopup(n);
    }

    public void cmdPartialPopupShow(int n) {
        this.fwHMI.showPartialPopup(0, n);
    }

    public void cmdPartialPopupHide(int n) {
        this.fwHMI.removePartialPopup(0, n);
    }

    public void cmdTouchPadPressed(int n, int n2) {
        this.sendTouchEvent(10904, 0, n, n2, null);
    }

    public void cmdTouchPadReleased() {
        this.sendTouchEvent(10905, 0, 32000, 32000, null);
    }

    public void cmdTouchPadCharactersRecognized(String string) {
        if (string.startsWith("\"")) {
            string = string.substring(1);
        } else if (string.equalsIgnoreCase("\\b")) {
            string = "\b";
        }
        this.sendTouchEvent(10908, 0, 32000, 32000, string);
    }

    public void cmdTouchPadKeyTurned(String string, String string2, int n) {
        int n2 = "y".equals(string) ? 65 : 64;
        int n3 = "r".equals(string2) ? 0 : 1;
        this.fwHMI.fireWheelButtonEvent(10403, this.fwHMI.getFramework().getMonotonicTime(), n2, n3, n, 0);
    }

    public void cmdTouchpadMovedAbs(int n, int n2) {
        this.sendTouchEvent(10911, 0, n, n2, null);
    }

    public void cmdTouchpadMovedRel(int n, int n2) {
        this.sendTouchEvent(10912, 0, n, n2, null);
    }

    public void cmdGestureScreenPressed(int n, int n2) {
        this.sendGestureEvent(10902, n, n2);
    }

    public void cmdGestureScreenReleased(int n, int n2) {
        this.sendGestureEvent(10903, n, n2);
    }

    public void cmdGestureScreenMoved(int n, int n2) {
        this.sendGestureEvent(10904, n, n2);
    }

    public void cmdGestureScreenFlicked(int n, int n2) {
        this.sendGestureEvent(10905, n, n2);
    }

    public void cmdTouchCharRecognized(String string) {
        int[] nArray = new int[string.length()];
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            nArray[i2] = nArray.length - i2;
        }
        this.sendTouchEvent(10910, 0, 0, string, nArray);
    }

    public void cmdTouchScreenTyped(int n, int n2) {
        new HMIDiagGateway$1(this, n, n2).start();
    }

    public void cmdTouchScreenTypedWithMove(int n, int n2, int n3, int n4) {
        new HMIDiagGateway$2(this, n, n2, n3, n4).start();
    }

    private void sendGestureEvent(int n, int n2, int n3) {
        this.fwHMI.fireGestureEvent(n, this.getMonotonicTime(), n2, n3, 0);
    }

    public void cmdTouchpadFingerTraceFadeIn() {
        int n = 51266;
        int n2 = 63;
        this.sendTouchEvent(10904, 0, 100, n, null);
        this.pause(50);
        for (int i2 = 0; i2 < 15; ++i2) {
            this.sendTouchEvent(10911, 0, 100, n += n2 * 8257, null);
            this.pause(50);
        }
        this.sendTouchEvent(10905, 0, 100, n += n2 * 8257, null);
        this.pause(50);
        this.pause(300);
        this.sendTouchEvent(10908, 0, 32000, 32000, "ASC");
    }

    private void sendTouchEvent(int n, int n2, int n3, String string, int[] nArray) {
        this.fwHMI.fireTouchEvent(n, this.getMonotonicTime(), 0, n2, n3, string, nArray, 0);
    }

    public void cmdTouchpadInputSequenceMIB2(String string) {
        if (string != null && string.length() > 0) {
            if (string.startsWith("\\b")) {
                string = "\b";
            } else if (string.startsWith("\\s")) {
                string = " ";
            }
            for (int i2 = 0; i2 < string.length(); ++i2) {
                this.sendFingerTraceSequence();
                this.pause(300);
                this.sendTouchEvent(10908, 0, 32000, 32000, string.substring(i2, i2 + 1));
            }
        } else {
            this.sendFingerTraceSequence();
            this.pause(300);
            this.sendTouchEvent(10908, 0, 32000, 32000, "");
        }
    }

    public void cmdTouchpadInputWithAlternativesMIB2(String string) {
        if (string != null) {
            Buffer buffer = new Buffer();
            for (int i2 = 0; i2 < string.length(); ++i2) {
                if (string.charAt(i2) == '\\') {
                    if (i2 == string.length() - 1) {
                        throw new IllegalArgumentException("\\ must be followed by b or u");
                    }
                    if (string.charAt(i2 + 1) == 'b') {
                        buffer.append('\b');
                        ++i2;
                        continue;
                    }
                    if (string.charAt(i2 + 1) != 'u') continue;
                    if (string.length() - i2 < 6) {
                        throw new IllegalArgumentException("\\u must be followed by at least 4 characters.");
                    }
                    String string2 = string.substring(i2 + 2, i2 + 6);
                    int n = Integer.parseInt(string2, 16);
                    if (n > -65536) {
                        throw new IllegalArgumentException(new StringBuffer().append("Invalid unicode value ").append(string2).toString());
                    }
                    buffer.append((char)n);
                    i2 += 5;
                    continue;
                }
                buffer.append(string.charAt(i2));
            }
            this.sendFingerTraceSequence();
            this.pause(300);
            this.sendTouchEvent(10908, 0, 32000, 32000, buffer.toString());
        } else {
            this.sendFingerTraceSequence();
            this.pause(300);
            this.sendTouchEvent(10908, 0, 32000, 32000, "");
        }
    }

    private void sendFingerTraceSequence() {
        int n = 1014;
        int n2 = 10;
        this.sendTouchEvent(10904, 0, n2, n2, null);
        this.sendTouchEvent(10911, 0, n2, n, null);
        this.sendTouchEvent(10911, 0, n, n, null);
        this.sendTouchEvent(10911, 0, n, n2, null);
        this.sendTouchEvent(10905, 0, n2, n2, null);
        for (int i2 = 1; i2 < 6; ++i2) {
            this.sendTouchEvent(10904, 0, n2 + i2 * 200, n2 + 10, null);
            this.sendTouchEvent(10911, 0, n2 + i2 * 200, n - 50, null);
            this.sendTouchEvent(10905, 0, n2 + i2 * 200, n - 10, null);
            this.pause(20);
        }
    }

    protected void pause(int n) {
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void cmdDumpGlyphCache(String string) {
        IGUIManager iGUIManager = this.fwHMI.getTerminalRegistry().getTerminal(0).getGUIManager();
        iGUIManager.dumpGlyphCache(string);
    }

    protected void sendTouchEvent(int n, int n2, int n3, int n4, String string) {
        if (n != 10908) {
            this.fwHMI.fireTouchEvent(n, this.getMonotonicTime(), n2, n3, n4, 1, 0);
        } else {
            this.fwHMI.fireTouchEvent(n, this.getMonotonicTime(), n2, n3, n4, string, null, 0);
        }
    }

    @Override
    protected String getCommandName(Method method) {
        String string;
        if (this.cmdDescriptionMap == null) {
            this.initCmdDescriptions();
        }
        if (this.cmdDescriptionMap.containsKey(string = method.getName())) {
            return (String)this.cmdDescriptionMap.get(string);
        }
        return super.getCommandName(method);
    }

    private void initCmdDescriptions() {
        this.cmdDescriptionMap = new HashMap();
    }

    public void cmdEntDrawerAudioSourceList(String string) {
        if (string != null) {
            int n = 0;
            int n2 = 0;
            while (n < string.length()) {
                int n3 = string.indexOf(124, n);
                int n4 = n3 = n3 == -1 && n < string.length() ? string.length() : n3;
                if (n3 == -1) break;
                int n5 = 0;
                try {
                    n5 = Integer.parseInt(string.substring(n, n3).trim());
                    ListModelApp listModelApp = this.fwHMI.getListModel(538);
                    if (listModelApp != null) {
                        try {
                            listModelApp.setCell(0, n2, new IntegerListCell(n5, -129));
                        }
                        catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    }
                    ++n2;
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
                n = n3 + 1;
            }
        }
    }

    private void diashowMarkCurrentAsFlawed(String string) {
        this.logDiashow.log(-2137614336, "Kommentar %1 \u00fcbernommen.", (Object)string);
        if (this.currentErrors != null) {
            this.currentErrors[this.currentScreen] = string;
        }
    }
}

