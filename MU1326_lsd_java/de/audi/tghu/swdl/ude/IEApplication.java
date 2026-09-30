/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEClient;
import de.audi.tghu.swdl.ude.IEStorage;
import de.audi.tghu.swdl.ude.handler.AddressbookHandler;
import de.audi.tghu.swdl.ude.handler.BrowserBookmarkHandler;
import de.audi.tghu.swdl.ude.handler.BrowserHandler;
import de.audi.tghu.swdl.ude.handler.HMINaviHandler;
import de.audi.tghu.swdl.ude.handler.NaviHandler;
import de.audi.tghu.swdl.ude.handler.SoundHandler;
import de.audi.tghu.swdl.ude.handler.enc.EncryptionHandler;
import de.audi.tghu.swdl.ude.tasks.CleanupTask;
import de.audi.tghu.swdl.ude.tasks.CopyTask;
import de.audi.tghu.swdl.ude.tasks.ExportTask;
import de.audi.tghu.swdl.ude.tasks.ImportTask;
import de.audi.tghu.swdl.ude.tasks.MountTask;
import de.audi.tghu.swdl.ude.tasks.UnzipTask;
import de.audi.tghu.swdl.ude.tasks.ZipTask;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IEApplication
implements IEApp {
    private final EngineeringEnv engineeringEnv;
    private final EngineeringApp engApp;
    private final CleanupTask cleanupTask;
    private final List clientList = new LinkedList();
    protected final SoundHandler soundHandler;
    protected final NaviHandler naviHandler;
    protected final HMINaviHandler hmiNaviHandler;
    protected final EncryptionHandler encHandler;
    protected final BrowserHandler[] browserHandlers;
    protected final BrowserBookmarkHandler[] browserBookmarkHandlers;
    public final AddressbookHandler addressbookHandler;
    private int medium = 1;

    protected IEApplication(EngineeringApp engineeringApp, EngineeringEnv engineeringEnv) {
        int n;
        this.engineeringEnv = engineeringEnv;
        this.engApp = engineeringApp;
        this.hmiNaviHandler = new HMINaviHandler(new IEStorage(engineeringEnv.getStorageMgr()), this.getLogUDE());
        this.encHandler = new EncryptionHandler(this);
        this.addressbookHandler = new AddressbookHandler(this.getLogUDE());
        this.naviHandler = new NaviHandler(this.getLogUDE());
        this.soundHandler = new SoundHandler(this.getLogUDE());
        this.cleanupTask = new CleanupTask(this);
        this.browserHandlers = new BrowserHandler[7];
        for (n = 0; n < this.browserHandlers.length; ++n) {
            this.browserHandlers[n] = new BrowserHandler(n, this.getLogUDE());
        }
        this.browserBookmarkHandlers = new BrowserBookmarkHandler[7];
        for (n = 0; n < this.browserBookmarkHandlers.length; ++n) {
            this.browserBookmarkHandlers[n] = new BrowserBookmarkHandler(n, this.getLogUDE());
        }
        ImportOrExportButtonListener importOrExportButtonListener = new ImportOrExportButtonListener();
        this.getButtonModel(1300060).setButtonListener(importOrExportButtonListener);
        this.getButtonModel(1300059).setButtonListener(importOrExportButtonListener);
        SDorUSBChoiceListener sDorUSBChoiceListener = new SDorUSBChoiceListener();
        this.getChoiceModel(1300064).setChoiceListener(sDorUSBChoiceListener);
        this.getChoiceModel(1300062).setChoiceListener(sDorUSBChoiceListener);
    }

    private final LogChannel getLogUDE() {
        return this.getEngineeringEnv().getLogUDE();
    }

    private final EngineeringEnv getEngineeringEnv() {
        return this.engineeringEnv;
    }

    private final IHMIServiceApp getHMIService() {
        return this.getEngineeringEnv().getHMIService();
    }

    protected void addClient(IEClient iEClient) {
        this.getLogUDE().log(10000000, "[IEApplication.addClient] %1", (Object)iEClient);
        if (iEClient != null) {
            this.clientList.add(iEClient);
        }
    }

    protected void removeClient(IEClient iEClient) {
        this.getLogUDE().log(10000000, "[IEApplication.removeClient] %1", (Object)iEClient);
        if (iEClient != null && this.clientList.contains(iEClient)) {
            this.clientList.remove(iEClient);
        }
    }

    public LogChannel getLogChannel() {
        return this.getLogUDE();
    }

    private final AbstractEngineeringTextFactory getTextFactory() {
        return this.engApp.getTextFactory();
    }

    public void mountFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.mountFinished] success:%1", bl);
        if (bl) {
            this.runExport();
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantExportFailed());
        }
    }

    private void runExport() {
        this.getLogUDE().log(10000000, "[IEApplication.runExport]");
        new ExportTask(this, this.clientList.listIterator()).start();
    }

    private void runImport() {
        this.getLogUDE().log(10000000, "[IEApplication.runImport]");
        new ImportTask(this, this.clientList.listIterator()).start();
    }

    public void exportFinished(boolean bl) {
        this.getLogUDE().log(10000000, "IEApplication::exportFinished(%1)", bl);
        if (bl) {
            ZipTask zipTask = new ZipTask(this);
            this.execute(zipTask);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantExportFailed());
        }
    }

    public void importFinished(boolean bl) {
        String string;
        this.getLogUDE().log(10000000, "[IEApplication.importFinished] success:%1", bl);
        String string2 = string = bl ? this.getTextFactory().getTextConstantImportFailed() : this.getTextFactory().getTextConstantImportFinishedSuccessfull();
        if (bl) {
            this.cleanupTask.add(IEClient.FILE_ZIP_DEC);
            this.cleanupTask.add(IEClient.FILE_ZIP_ENC);
        }
        this.showResultAndCleanup(bl, string);
        if (bl) {
            new Timer("RebootTimer", 3000L, true, new RebootTimerListener()).start();
        }
    }

    public void unzipFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.unzipFinished] success:%1", bl);
        if (bl) {
            this.runImport();
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantUnzippingFailedImportFailed());
        }
    }

    public void zipFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.zipFinished] success:%1", bl);
        if (bl) {
            this.encHandler.encrypt(IEClient.FILE_ZIP);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantZippingFailedExportFailed());
        }
    }

    public void decryptionFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.decryptionFinished] success:%1", bl);
        if (bl) {
            UnzipTask unzipTask = new UnzipTask(this, IEClient.FILE_ZIP_DEC, IEClient.WORKING_DIR);
            this.execute(unzipTask);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantDecryptionFailedInportFailed());
        }
    }

    public void encryptionFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.encryptionFinished] success:%1", bl);
        if (bl) {
            File file = this.getMedium();
            if (file != null) {
                CopyTask copyTask = new CopyTask(this, IEClient.FILE_ZIP_ENC, file);
                this.execute(copyTask);
            } else {
                this.showResultAndCleanup(false, this.getTextFactory().getTextConstantNoMediumUsbSdFoundExportFailed());
            }
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantEncryptionFailedExportFailed());
        }
    }

    public void copyFinished(boolean bl) {
        this.getLogUDE().log(10000000, "[IEApplication.copyFinished] success:%1", bl);
        if (this.isExportSelected()) {
            String string = bl ? this.getTextFactory().getTextConstantExportFinishedSuccessfull() : this.getTextFactory().getTextConstantCopyFailedExportFailed();
            this.showResultAndCleanup(bl, string);
        }
    }

    public List getFiles() {
        ArrayList arrayList = new ArrayList(this.clientList.size());
        Iterator iterator = this.clientList.iterator();
        while (iterator.hasNext()) {
            IEClient iEClient = (IEClient)iterator.next();
            File file = iEClient.getFile();
            this.getLogUDE().log(10000000, "[IEApplication.getFiles] %1 %2", (Object)iEClient, (Object)file);
            if (file == null || !file.exists()) continue;
            arrayList.add(file);
        }
        return arrayList;
    }

    private void triggerExport() {
        this.getLogUDE().log(10000000, "[IEApplication.triggerExport]");
        this.execute(new MountTask(this));
    }

    private void triggerImport() {
        this.getLogUDE().log(10000000, "[IEApplication.triggerImport]");
        File file = this.getMedium();
        if (file == null) {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantNoMediumUsbSdFoundImportNotPossible());
            return;
        }
        File file2 = new File(file, "ude_aes.enc");
        CopyTask copyTask = new CopyTask(this, file2, IEClient.WORKING_DIR);
        copyTask.run();
        this.encHandler.decrypt(IEClient.FILE_ZIP_ENC);
    }

    public CleanupTask getCleanupTask() {
        return this.cleanupTask;
    }

    public ButtonModelApp getButtonModel(int n) {
        return this.getHMIService().getButtonModel(n);
    }

    public ChoiceModelApp getChoiceModel(int n) {
        return this.getHMIService().getChoiceModel(n);
    }

    public SpellerModelApp getSpellerModel(int n) {
        return this.getHMIService().getSpellerModel(n);
    }

    private void showResultAndCleanup(boolean bl, String string) {
        int n;
        int n2 = bl ? 10000000 : 10000;
        this.getLogUDE().log(n2, "[IEApplication.showResultScreen] success:%1 %2", bl, (Object)string);
        if (this.isImportSelected()) {
            n = bl ? 0 : 2;
        } else {
            n = bl ? 1 : 3;
            this.cleanupTask.add(IEClient.FILE_ZIP);
            this.cleanupTask.add(IEClient.FILE_ZIP_ENC);
        }
        this.execute(this.cleanupTask);
        this.getChoiceModel(1300061).setValue(n);
        this.getChoiceModel(1300061).setStatus(1);
    }

    private void execute(Runnable runnable) {
        this.getLogUDE().log(10000000, "[IEApplication.execute] %1", (Object)runnable);
        this.getEngineeringEnv().executeInUtilThread(runnable);
    }

    public File getMedium() {
        File file = new File("/fs");
        String string = this.medium == 1 ? "sd" : "usb";
        this.getLogUDE().log(10000000, "[IEApplication.getMedium] Searching %1 for dirs starting with '%2'", (Object)file, (Object)string);
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            this.getLogUDE().log(10000, "[IEApplication.getMedium] Directory %1 not found!", (Object)file);
            return null;
        }
        for (int i2 = 0; i2 < fileArray.length; ++i2) {
            File file2 = fileArray[i2];
            if (!file2.getName().startsWith(string)) continue;
            if (!file2.isDirectory()) {
                this.getLogUDE().log(100000, "[IEApplication.getMedium] %1 is not a directory!", (Object)file2);
                continue;
            }
            this.getLogUDE().log(10000000, "[IEApplication.getMedium] Found %1", (Object)file2);
            return file2;
        }
        this.getLogUDE().log(10000, "IEApplication::getMedium() - No matching dir '%1' found in %2! ", (Object)string, (Object)file);
        return null;
    }

    private boolean isExportSelected() {
        return this.getChoiceModel(1300063).getValue() == 1;
    }

    private boolean isImportSelected() {
        return this.getChoiceModel(1300063).getValue() == 0;
    }

    private class RebootTimerListener
    extends DefaultTimerListener {
        private RebootTimerListener() {
        }

        public void fireTimer(Timer timer) {
            IEApplication.this.getEngineeringEnv().getLogUDE().log(1000000, "[RebootTimerListener.fireTimer] trigger reboot");
            IEApplication.this.getEngineeringEnv().rebootSystem();
        }
    }

    private class SDorUSBChoiceListener
    extends DefaultChoiceListener {
        private SDorUSBChoiceListener() {
        }

        public void itemSelected(int n, int n2, int n3, int n4) {
            switch (n) {
                case 1300064: {
                    IEApplication.this.getLogUDE().log(10000000, "[IEApplication.itemSelected] model:%1 -> USB", (long)n);
                    IEApplication.this.medium = 0;
                    break;
                }
                case 1300062: {
                    IEApplication.this.getLogUDE().log(10000000, "[IEApplication.itemSelected] model:%1 -> SD", (long)n);
                    IEApplication.this.medium = 1;
                    break;
                }
                default: {
                    IEApplication.this.getLogUDE().log(10000, "[IEApplication.itemSelected] Unknown model %1! ", (long)n);
                    return;
                }
            }
            IEApplication.this.getChoiceModel(1300061).setStatus(0);
            IEApplication.this.getChoiceModel(1300064).fireEvent(n4);
            IEClient.WORKING_DIR.mkdirs();
            if (IEApplication.this.isExportSelected()) {
                IEApplication.this.triggerExport();
            } else {
                IEApplication.this.triggerImport();
            }
        }
    }

    private class ImportOrExportButtonListener
    extends DefaultButtonListener {
        private ImportOrExportButtonListener() {
        }

        public void keyTyped(int n, int n2, int n3) {
            switch (n) {
                case 1300060: {
                    IEApplication.this.getLogUDE().log(10000000, "[IEApplication.keyTyped] model:%1 -> IMPORT", (long)n);
                    IEApplication.this.getChoiceModel(1300063).setValue(0);
                    IEApplication.this.getButtonModel(1300060).fireEvent(n3);
                    break;
                }
                case 1300059: {
                    IEApplication.this.getLogUDE().log(10000000, "[IEApplication.keyTyped] model:%1 -> EXPORT", (long)n);
                    IEApplication.this.getChoiceModel(1300063).setValue(1);
                    IEApplication.this.getButtonModel(1300059).fireEvent(n3);
                    break;
                }
                default: {
                    IEApplication.this.getLogUDE().log(10000, "[IEApplication.keyTyped] Unknown model %1!", (long)n);
                }
            }
        }
    }
}

