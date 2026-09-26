/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.ude;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.redengineering.app.AbstractEngineeringTextFactory;
import de.audi.tghu.redengineering.app.EngineeringApp;
import de.audi.tghu.redengineering.app.EngineeringEnv;
import de.audi.tghu.swdl.ude.IEApp;
import de.audi.tghu.swdl.ude.IEApplication$ImportOrExportButtonListener;
import de.audi.tghu.swdl.ude.IEApplication$RebootTimerListener;
import de.audi.tghu.swdl.ude.IEApplication$SDorUSBChoiceListener;
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
        IEApplication$ImportOrExportButtonListener iEApplication$ImportOrExportButtonListener = new IEApplication$ImportOrExportButtonListener(this, null);
        this.getButtonModel(1557533440).setButtonListener(iEApplication$ImportOrExportButtonListener);
        this.getButtonModel(1540756224).setButtonListener(iEApplication$ImportOrExportButtonListener);
        IEApplication$SDorUSBChoiceListener iEApplication$SDorUSBChoiceListener = new IEApplication$SDorUSBChoiceListener(this, null);
        this.getChoiceModel(1624642304).setChoiceListener(iEApplication$SDorUSBChoiceListener);
        this.getChoiceModel(1591087872).setChoiceListener(iEApplication$SDorUSBChoiceListener);
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
        this.getLogUDE().log(-2137614336, "[IEApplication.addClient] %1", (Object)iEClient);
        if (iEClient != null) {
            this.clientList.add(iEClient);
        }
    }

    protected void removeClient(IEClient iEClient) {
        this.getLogUDE().log(-2137614336, "[IEApplication.removeClient] %1", (Object)iEClient);
        if (iEClient != null && this.clientList.contains(iEClient)) {
            this.clientList.remove(iEClient);
        }
    }

    @Override
    public LogChannel getLogChannel() {
        return this.getLogUDE();
    }

    private final AbstractEngineeringTextFactory getTextFactory() {
        return this.engApp.getTextFactory();
    }

    @Override
    public void mountFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.mountFinished] success:%1", bl);
        if (bl) {
            this.runExport();
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantExportFailed());
        }
    }

    private void runExport() {
        this.getLogUDE().log(-2137614336, "[IEApplication.runExport]");
        new ExportTask(this, this.clientList.listIterator()).start();
    }

    private void runImport() {
        this.getLogUDE().log(-2137614336, "[IEApplication.runImport]");
        new ImportTask(this, this.clientList.listIterator()).start();
    }

    @Override
    public void exportFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "IEApplication::exportFinished(%1)", bl);
        if (bl) {
            ZipTask zipTask = new ZipTask(this);
            this.execute(zipTask);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantExportFailed());
        }
    }

    @Override
    public void importFinished(boolean bl) {
        String string;
        this.getLogUDE().log(-2137614336, "[IEApplication.importFinished] success:%1", bl);
        String string2 = string = bl ? this.getTextFactory().getTextConstantImportFailed() : this.getTextFactory().getTextConstantImportFinishedSuccessfull();
        if (bl) {
            this.cleanupTask.add(IEClient.FILE_ZIP_DEC);
            this.cleanupTask.add(IEClient.FILE_ZIP_ENC);
        }
        this.showResultAndCleanup(bl, string);
        if (bl) {
            new Timer("RebootTimer", 0, true, new IEApplication$RebootTimerListener(this, null)).start();
        }
    }

    @Override
    public void unzipFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.unzipFinished] success:%1", bl);
        if (bl) {
            this.runImport();
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantUnzippingFailedImportFailed());
        }
    }

    @Override
    public void zipFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.zipFinished] success:%1", bl);
        if (bl) {
            this.encHandler.encrypt(IEClient.FILE_ZIP);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantZippingFailedExportFailed());
        }
    }

    @Override
    public void decryptionFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.decryptionFinished] success:%1", bl);
        if (bl) {
            UnzipTask unzipTask = new UnzipTask(this, IEClient.FILE_ZIP_DEC, IEClient.WORKING_DIR);
            this.execute(unzipTask);
        } else {
            this.showResultAndCleanup(false, this.getTextFactory().getTextConstantDecryptionFailedInportFailed());
        }
    }

    @Override
    public void encryptionFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.encryptionFinished] success:%1", bl);
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

    @Override
    public void copyFinished(boolean bl) {
        this.getLogUDE().log(-2137614336, "[IEApplication.copyFinished] success:%1", bl);
        if (this.isExportSelected()) {
            String string = bl ? this.getTextFactory().getTextConstantExportFinishedSuccessfull() : this.getTextFactory().getTextConstantCopyFailedExportFailed();
            this.showResultAndCleanup(bl, string);
        }
    }

    @Override
    public List getFiles() {
        ArrayList arrayList = new ArrayList(this.clientList.size());
        Iterator iterator = this.clientList.iterator();
        while (iterator.hasNext()) {
            IEClient iEClient = (IEClient)iterator.next();
            File file = iEClient.getFile();
            this.getLogUDE().log(-2137614336, "[IEApplication.getFiles] %1 %2", (Object)iEClient, (Object)file);
            if (file == null || !file.exists()) continue;
            arrayList.add(file);
        }
        return arrayList;
    }

    private void triggerExport() {
        this.getLogUDE().log(-2137614336, "[IEApplication.triggerExport]");
        this.execute(new MountTask(this));
    }

    private void triggerImport() {
        this.getLogUDE().log(-2137614336, "[IEApplication.triggerImport]");
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

    @Override
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
        int n2 = bl ? -2137614336 : 10000;
        this.getLogUDE().log(n2, "[IEApplication.showResultScreen] success:%1 %2", bl, (Object)string);
        if (this.isImportSelected()) {
            n = bl ? 0 : 2;
        } else {
            n = bl ? 1 : 3;
            this.cleanupTask.add(IEClient.FILE_ZIP);
            this.cleanupTask.add(IEClient.FILE_ZIP_ENC);
        }
        this.execute(this.cleanupTask);
        this.getChoiceModel(1574310656).setValue(n);
        this.getChoiceModel(1574310656).setStatus(1);
    }

    private void execute(Runnable runnable) {
        this.getLogUDE().log(-2137614336, "[IEApplication.execute] %1", (Object)runnable);
        this.getEngineeringEnv().executeInUtilThread(runnable);
    }

    public File getMedium() {
        File file = new File("/fs");
        String string = this.medium == 1 ? "sd" : "usb";
        this.getLogUDE().log(-2137614336, "[IEApplication.getMedium] Searching %1 for dirs starting with '%2'", (Object)file, (Object)string);
        File[] fileArray = file.listFiles();
        if (fileArray == null) {
            this.getLogUDE().log(10000, "[IEApplication.getMedium] Directory %1 not found!", (Object)file);
            return null;
        }
        for (int i2 = 0; i2 < fileArray.length; ++i2) {
            File file2 = fileArray[i2];
            if (!file2.getName().startsWith(string)) continue;
            if (!file2.isDirectory()) {
                this.getLogUDE().log(-1601830656, "[IEApplication.getMedium] %1 is not a directory!", (Object)file2);
                continue;
            }
            this.getLogUDE().log(-2137614336, "[IEApplication.getMedium] Found %1", (Object)file2);
            return file2;
        }
        this.getLogUDE().log(10000, "IEApplication::getMedium() - No matching dir '%1' found in %2! ", (Object)string, (Object)file);
        return null;
    }

    private boolean isExportSelected() {
        return this.getChoiceModel(1607865088).getValue() == 1;
    }

    private boolean isImportSelected() {
        return this.getChoiceModel(1607865088).getValue() == 0;
    }

    static /* synthetic */ LogChannel access$300(IEApplication iEApplication) {
        return iEApplication.getLogUDE();
    }

    static /* synthetic */ int access$402(IEApplication iEApplication, int n) {
        iEApplication.medium = n;
        return iEApplication.medium;
    }

    static /* synthetic */ boolean access$500(IEApplication iEApplication) {
        return iEApplication.isExportSelected();
    }

    static /* synthetic */ void access$600(IEApplication iEApplication) {
        iEApplication.triggerExport();
    }

    static /* synthetic */ void access$700(IEApplication iEApplication) {
        iEApplication.triggerImport();
    }

    static /* synthetic */ EngineeringEnv access$800(IEApplication iEApplication) {
        return iEApplication.getEngineeringEnv();
    }
}

