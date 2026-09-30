/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.engineering;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.list.ISwdlListItem;
import de.audi.tghu.swdl.app.list.SwdlListHandlerDevice;
import de.audi.tghu.swdl.app.list.SwdlListHandlerFile;
import de.audi.tghu.swdl.app.list.SwdlListHandlerModule;
import de.audi.tghu.swdl.app.list.SwdlListItemDevice;
import de.audi.tghu.swdl.app.list.SwdlListItemFile;
import de.audi.tghu.swdl.app.list.SwdlListItemModule;

public abstract class AbstractEngineeringDeviceInfoManager
extends AbstractDeviceInfoManager
implements ButtonListener {
    private static final int DEVICE_SELECTION_SCREEN = 0;
    private static final int MODULE_SELECTION_SCREEN = 1;
    private static final int FILE_SELECTION_SCREEN = 2;
    private final Object syncGetModules = new Object();
    private int currentDeviceId = -1;
    private static final String[] EMPTYSTRINGARRAY = new String[0];
    private static final int[] EMPTYINTARRAY = new int[0];
    private SwdlListHandlerDevice swdlDeviceList;
    private SwdlListHandlerModule swdlModuleList;
    private SwdlListHandlerFile swdlFileList;
    private int currentDeviceIndex = 0;
    private volatile SwdlListItemDevice currentDevice;
    private volatile SwdlListItemModule currentModule;
    private volatile SwdlListItemFile currentFile;
    private int currentSelectionScreen = 0;
    private final SwdlDSIHandlerSelection selectionDSIHandler;
    private boolean moduleDowngradeDetectionProgress = false;

    public AbstractEngineeringDeviceInfoManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerDeviceInfo);
        this.selectionDSIHandler = swdlDSIHandlerSelection;
        this.swdlDeviceList = new SwdlListHandlerDevice(this.getSwdlEnv(), this, this.getSwdlModels().getDeviceList());
        this.swdlModuleList = new SwdlListHandlerModule(this.getSwdlEnv(), this, this.getSwdlModels().getModuleList());
        this.swdlFileList = new SwdlListHandlerFile(this.getSwdlEnv(), this, this.getSwdlModels().getFileList());
        this.getSwdlModels().getSelectLanguageButton().setButtonListener(this);
        this.getSwdlModels().getShowErrorsButton().setButtonListener(this);
        this.getSwdlModels().getSelectAllButton().setButtonListener(this);
        this.getSwdlModels().getSelectNoneButton().setButtonListener(this);
        this.getSwdlModels().getConfirmSummaryChangedButton().setButtonListener(this);
    }

    private final SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.selectionDSIHandler;
    }

    public int getCurrentDeviceId() {
        if (this.moduleDowngradeDetectionProgress) {
            return this.currentDeviceId;
        }
        if (this.currentDevice != null) {
            return this.currentDevice.getId();
        }
        return -1;
    }

    private void setCurrentDeviceId(int n) {
        this.currentDeviceId = n;
    }

    public int[] getAllDeviceIds() {
        int[] nArray = new int[this.swdlDeviceList.getEntries().length];
        for (int i2 = 0; i2 < this.swdlDeviceList.getEntries().length; ++i2) {
            nArray[i2] = this.swdlDeviceList.getEntries()[i2].getId();
        }
        return nArray;
    }

    public int getCurrentModuleId() {
        int n = -1;
        if (this.currentModule != null) {
            n = this.currentModule.getId();
        }
        return n;
    }

    public boolean isStandardSelection() {
        return !this.getSelectionDSIHandler().isUserDefinedMode();
    }

    private int getSelectionScreen() {
        return this.currentSelectionScreen;
    }

    private void setSelectionScreen(int n) {
        String string;
        switch (n) {
            case 1: {
                string = "MODULE_SELECTION_SCREEN";
                break;
            }
            case 2: {
                string = "FILE_SELECTION_SCREEN";
                break;
            }
            default: {
                string = "DEVICE_SELECTION_SCREEN";
            }
        }
        this.getSwdlEnv().getLogMain().log(10000000, "AbstractEngineeringDeviceInfoManager.setSelectionScreen(screen=%1)", (Object)string);
        this.currentSelectionScreen = n;
    }

    private void setCurrentDevice(SwdlListItemDevice swdlListItemDevice) {
        this.currentDevice = swdlListItemDevice;
    }

    private void setCurrentModule(SwdlListItemModule swdlListItemModule) {
        this.currentModule = swdlListItemModule;
    }

    private void setCurrentFile(SwdlListItemFile swdlListItemFile) {
        this.currentFile = swdlListItemFile;
    }

    void resetCursorPosition() {
        this.currentDeviceIndex = 0;
    }

    public void doGetDevices(int n, String string, boolean bl) {
        this.setSelectionScreen(0);
        this.getSwdlEnv().getLogMain().log(10000000, "AbstractEngineeringDeviceInfoManager.doGetDevices(%3, %1, %2)", (Object)string, (Object)(bl ? "true" : "false"), (long)n);
        super.doGetDevices(n, string, bl);
        this.getSwdlModels().getDeviceListLabel().setText(this.getTextFactory().getLabelForAccessType(n, string));
        this.getSwdlModels().getUpdatedDeviceLabel().setText("");
        if (bl) {
            this.getSwdlEnv().getLogMain().log(10000000, "doGetDevices, clear lists!");
            this.swdlDeviceList.reset();
            this.swdlModuleList.reset();
            this.swdlFileList.reset();
            this.updateDeviceList(EMPTYSTRINGARRAY, EMPTYINTARRAY, false);
        }
        this.swdlDeviceList.getList().setStatus(0);
        this.getDeviceInfoDSIHandler().doGetDevices();
    }

    public void checkModulesDowngrade() {
        this.getSwdlEnv().getLogMain().log(1000000, "[AbstractEngineeringDeviceInfoManager] checkModulesDowngrade()");
        this.moduleDowngradeDetectionProgress = true;
        if (this.swdlDeviceList != null) {
            ISwdlListItem[] iSwdlListItemArray = this.swdlDeviceList.getEntries();
            if (iSwdlListItemArray != null && iSwdlListItemArray.length > 0) {
                for (int i2 = 0; i2 < iSwdlListItemArray.length && this.getSwdlModels().getShowDowngradeWarningChoice().getValue() == 0; ++i2) {
                    this.setCurrentDeviceId(iSwdlListItemArray[i2].getId());
                    this.doGetModulesAndWait(iSwdlListItemArray[i2].getId());
                }
            }
        } else {
            this.getSwdlEnv().getLogMain().log(10000, "[AbstractEngineeringDeviceInfoManager] checkModulesDowngrade(): the list of devices is not defined!");
        }
        this.moduleDowngradeDetectionProgress = false;
    }

    public void doGetModules(int n) {
        this.setSelectionScreen(1);
        this.swdlModuleList.getList().setStatus(0);
        this.getDeviceInfoDSIHandler().doGetModules(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void doGetModulesAndWait(int n) {
        this.getSwdlEnv().getLogMain().log(10000000, "[SwdlDSIHandlerDeviceInfo] -> doGetModulesAndWait(%1)", (long)n);
        Object object = this.syncGetModules;
        synchronized (object) {
            this.getDeviceInfoDSIHandler().doGetModules(n);
            try {
                this.syncGetModules.wait(2000L);
            }
            catch (InterruptedException interruptedException) {
                Thread.interrupted();
                this.getSwdlEnv().getLogMain().log(10000000, "doGetModulesAndWait(%1): waiting of modules was interrupted", (long)n);
            }
        }
    }

    private boolean isSelected(int n) {
        return n == 1 || n == 5;
    }

    private boolean isUpdateNeeded(int n) {
        return this.isSelected(n) || n == 6;
    }

    private boolean isUnselected(int n) {
        return n == 2 || n == 5 || n == 14;
    }

    private boolean hasErrorButMayBeSelected(int n) {
        return n == 6 || n == 7 || n == 8 || n == 9 || n == 10 || n == 11 || n == 12 || n == 13 || n == 15;
    }

    private boolean isDowngrade(int n) {
        return n == 14;
    }

    private boolean isUpdateNotNeeded(int n) {
        return this.isUnselected(n) || n == 14;
    }

    private boolean isRetryNeeded(int n) {
        return n == 3;
    }

    public void clearSelectedEntry() {
        this.currentDeviceIndex = -1;
        this.swdlDeviceList.setSelectedEntry(this.currentDeviceIndex);
    }

    private void enableSelectAllButton(boolean bl) {
        if (bl && !this.isStandardSelection()) {
            this.getSwdlModels().getSelectAllButton().setStatus(1);
        } else {
            this.getSwdlModels().getSelectAllButton().setStatus(0);
        }
        this.getSwdlEnv().getLogMain().log(10000000, "[AbstractEngineeringDeviceInfoManager] enableSelectAllButton(%1): release waitsync mediator", bl);
        this.getSwdlModels().getSelectAllSyncChoice().setStatus(1);
    }

    private void enableSelectNoneButton(boolean bl) {
        if (bl && !this.isStandardSelection()) {
            this.getSwdlModels().getSelectNoneButton().setStatus(1);
        } else {
            this.getSwdlModels().getSelectNoneButton().setStatus(0);
        }
        this.getSwdlEnv().getLogMain().log(10000000, "[AbstractEngineeringDeviceInfoManager] enableSelectNoneButton(%1): release waitsync mediator", bl);
        this.getSwdlModels().getSelectNoneSyncChoice().setStatus(1);
    }

    public void updateDeviceList(String[] stringArray, int[] nArray, boolean bl) {
        this.swdlDeviceList.updateList(stringArray, nArray);
        this.swdlDeviceList.setSelectedEntry(this.currentDeviceIndex);
        this.getSwdlEnv().getLogMain().log(100000, "Check if Download is needed!");
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = false;
        boolean bl5 = false;
        boolean bl6 = false;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            bl2 |= this.isUpdateNeeded(nArray[i2]);
            bl3 |= this.isRetryNeeded(nArray[i2]);
            bl4 |= this.isUnselected(nArray[i2]) || this.hasErrorButMayBeSelected(nArray[i2]);
            bl5 |= this.isSelected(nArray[i2]);
            bl6 |= this.isDowngrade(nArray[i2]);
        }
        if (bl2) {
            this.getSwdlEnv().getLogMain().log(100000, "At least one device needs to be updated!");
            this.getSwdlModels().getCheckStartDownloadButton().setStatus(1);
        } else {
            this.getSwdlEnv().getLogMain().log(100000, "No Device needs to be updated!");
            this.getSwdlModels().getCheckStartDownloadButton().setStatus(0);
        }
        this.enableSelectNoneButton(bl5);
        this.enableSelectAllButton(bl4);
        if (this.getAccessType() == 2 && bl3) {
            this.getSwdlEnv().getLogMain().log(100000, "At least one device needs a retry!");
            this.getSwdlModels().getSummmaryOkChoice().setValue(0);
        } else {
            this.getSwdlEnv().getLogMain().log(100000, "No Device needs a retry!");
            this.getSwdlModels().getSummmaryOkChoice().setValue(1);
        }
        this.getSwdlModels().getShowDowngradeWarningChoice().setValue(bl6 ? 1 : 0);
        this.getSwdlEnv().getLogMain().log(10000000, "updateDeviceList(%1) isDowngradeDetected=%2", (Object)nArray, (Object)bl6);
        if (bl) {
            this.getSwdlEnv().getLogMain().log(10000000, "updateDeviceList(%1) release WaitSync mediator", (Object)nArray);
            this.swdlDeviceList.getList().setStatus(1);
            this.getSwdlModels().getConfirmSummaryChangedButton().setStatus(1);
        }
    }

    public void doSelectDevice(int n) {
        this.setSelectionScreen(1);
        this.currentDeviceIndex = n;
        this.setCurrentDevice((SwdlListItemDevice)this.swdlDeviceList.getEntry(n));
        this.swdlDeviceList.setSelectedEntry(n);
        this.setCurrentModule(null);
        this.setCurrentFile(null);
        this.getSwdlModels().getDeviceLabel().setText(this.currentDevice.getExpandedName());
        this.swdlModuleList.setBase(this.currentDevice);
        this.updateModuleList(new String[0], new int[0], new short[0]);
        if (this.getAccessType() != 1) {
            this.getDeviceInfoDSIHandler().doGetModules(this.currentDevice.getId());
        }
    }

    public void updateModuleList(String[] stringArray, int[] nArray, short[] sArray) {
        if (this.moduleDowngradeDetectionProgress) {
            this.checkModulesDowngrade(stringArray, nArray);
        } else {
            this.getSwdlEnv().getLogMain().log(10000000, "updateModuleList(modules=%1,additionalInfo=%2,hwIndex=%3)", (Object)stringArray, (Object)nArray, (Object)sArray);
            this.swdlModuleList.updateList(stringArray, nArray, sArray);
            this.swdlModuleList.getList().setStatus(1);
            this.getSwdlModels().getConfirmSummaryChangedButton().setStatus(1);
            if (nArray.length > 0) {
                boolean bl = true;
                boolean bl2 = true;
                boolean bl3 = false;
                boolean bl4 = false;
                for (int i2 = 0; i2 < nArray.length; ++i2) {
                    bl &= this.isUpdateNeeded(nArray[i2]);
                    bl2 &= this.isUpdateNotNeeded(nArray[i2]);
                    bl3 |= this.isUnselected(nArray[i2]) || this.hasErrorButMayBeSelected(nArray[i2]);
                    bl4 |= this.isSelected(nArray[i2]);
                }
                if (bl) {
                    this.getSwdlEnv().getLogMain().log(1000000, "All modules are selected for update -> set selection to NONE, also for files");
                } else if (bl2) {
                    this.getSwdlEnv().getLogMain().log(1000000, "None modules are selected for update -> set selection to ALL, also for files");
                }
                this.enableSelectNoneButton(bl4);
                this.enableSelectAllButton(bl3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void checkModulesDowngrade(String[] stringArray, int[] nArray) {
        this.getSwdlEnv().getLogMain().log(10000000, "checkModulesDowngrade(modules=%1,additionalInfo=%2): Modules downgrade detection", (Object)stringArray, (Object)nArray);
        if (nArray.length > 0) {
            boolean bl = false;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                if (!(bl |= this.isDowngrade(nArray[i2]))) continue;
                this.getSwdlModels().getShowDowngradeWarningChoice().setValue(1);
                break;
            }
        } else {
            this.getSwdlEnv().getLogMain().log(10000, "[AbstractEngineeringDeviceInfoManager] module downgrade detection: additional info for modules is empty!");
        }
        Object object = this.syncGetModules;
        synchronized (object) {
            this.syncGetModules.notifyAll();
        }
    }

    public void doSelectModule(int n) {
        this.setSelectionScreen(2);
        this.setCurrentModule((SwdlListItemModule)this.swdlModuleList.getEntry(n));
        this.getSwdlEnv().getLogMain().log(10000000, "AbstractEngineeringDeviceInfoManager.doSelectModule(module=%1)", (long)n);
        this.setCurrentFile(null);
        this.getSwdlModels().getModuleLabel().setText(this.currentModule.getName());
        this.swdlFileList.setBase(this.currentModule);
        this.updateFileList(new String[0]);
        this.getDeviceInfoDSIHandler().queryIsDataModule(this.currentDevice.getId(), this.currentModule.getId());
    }

    public void setIsNoExclusiveBoloUpdate(boolean bl) {
        if (this.currentModule != null) {
            this.currentModule.setIsNoExclusiveBoloUpdate(bl);
            this.getSwdlModels().getNoExclusiveBoloUpdateChoice().setValue(bl ? 1 : 0);
        } else {
            this.getSwdlEnv().getLogMain().log(100000, "Ignoring setIsNoExclusiveBoloUpdate() call! No module selected!");
        }
    }

    public void setIsDataModule(boolean bl) {
        if (this.currentModule != null) {
            if (!bl) {
                this.updateFileList(new String[]{this.getTextFactory().getTextConstantDeviceInfo7(), this.getTextFactory().getTextConstantDeviceInfo6()});
                if (this.getDeviceInfoDSIHandler().getAccessType() == 1) {
                    this.getDeviceInfoDSIHandler().queryIsNoExclusiveBoloUpdate(this.currentDevice.getId(), this.currentModule.getId());
                }
            }
        } else {
            this.getSwdlEnv().getLogMain().log(100000, "Ignoring setIsDataModule() call! No module selected!");
        }
    }

    public void updateFileList(String[] stringArray) {
        this.swdlFileList.updateList(stringArray);
        this.swdlFileList.getList().setStatus(1);
        this.getSwdlModels().getConfirmSummaryChangedButton().setStatus(1);
    }

    public void doSelectFile(int n) {
        this.getSwdlEnv().getLogMain().log(10000000, "AbstractEngineeringDeviceInfoManager.doSelectFile(file=%1)", (long)n);
        this.setCurrentFile((SwdlListItemFile)this.swdlFileList.getEntry(n));
        if (this.checkAccessType(1)) {
            if (!this.isStandardSelection()) {
                this.getDeviceInfoDSIHandler().doToggleSelection(this.currentDevice.getId(), this.currentModule.getId(), (short)this.currentFile.getId());
            }
        } else if (!this.checkAccessType(3)) {
            this.getDeviceInfoDSIHandler().doGetFileDetails(this.currentDevice.getId(), this.currentModule.getId(), (short)this.currentFile.getId());
        }
    }

    public void doGetFileInfos() {
        this.setSelectionScreen(2);
        this.swdlFileList.getList().setStatus(0);
        this.getDeviceInfoDSIHandler().doGetVersions(this.currentDevice.getId(), this.currentModule.getId());
        if (this.getSwdlModels().getDeviceStatusEnteredChoice().getStatus() != 1) {
            this.getDeviceInfoDSIHandler().doGetTargetVersions(this.currentDevice.getId(), this.currentModule.getId());
            this.getDeviceInfoDSIHandler().doGetAdditionalInfo(this.currentDevice.getId(), this.currentModule.getId());
        }
    }

    public void setTargetVersions(long[] lArray) {
        this.swdlFileList.setTargetVersions(lArray);
    }

    public void setVersions(long[] lArray) {
        this.swdlFileList.setVersions(lArray);
    }

    public void updateFileDetails(String string) {
        this.getLogHMI().log(10000000, "updateFileDetails(%1)", (Object)string);
        this.getSwdlModels().getFileDetailsLabel().setText(string);
    }

    public void setAdditionalInfo(int[] nArray) {
        boolean bl;
        for (bl = false; bl < nArray.length; bl += 1) {
            SwdlListItemFile swdlListItemFile = this.swdlFileList.getSwdlFile(bl ? 1 : 0);
            if (swdlListItemFile == null) continue;
            swdlListItemFile.setAdditionalInfo(nArray[bl]);
        }
        this.swdlFileList.updateList();
        if (nArray.length > 0) {
            bl = false;
            boolean bl2 = false;
            for (int i2 = 0; i2 < nArray.length; ++i2) {
                bl2 |= this.isSelected(nArray[i2]);
                bl |= this.isUnselected(nArray[i2]);
            }
            if (!bl) {
                this.getSwdlEnv().getLogMain().log(1000000, "All files are selected for update");
            } else if (!bl) {
                this.getSwdlEnv().getLogMain().log(1000000, "All files are excluded from update");
            }
            this.enableSelectNoneButton(bl2);
            this.enableSelectAllButton(bl);
        } else {
            this.enableSelectNoneButton(false);
        }
    }

    public void updateErrors(String string) {
        this.getLogHMI().log(10000000, "updateErrors(%1)", (Object)string);
        this.getSwdlModels().getDeviceErrorsLabel().setText(string);
    }

    public void updateSummary(String string) {
        String string2 = this.getSwdlModels().getUpdatedDeviceLabel().getText();
        if (string2.length() == 0) {
            this.getSwdlModels().getUpdatedDeviceLabel().setText(string);
        } else {
            this.getSwdlModels().getUpdatedDeviceLabel().setText(string2 + "," + string);
        }
        this.showSummaryChanged(this.getSwdlEnv().getTerminalId());
    }

    public void leaveSummaryChanged() {
        this.getSwdlModels().getUpdatedDeviceLabel().setText("");
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogHMI().log(100000000, "ignore keyPressed(%1) Event!", (long)n);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.getLogHMI().log(100000000, "ignore keyReleased(%1) Event!", (long)n);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1000000, "keyTyped(%1,%2)", (long)n, (long)n2);
        if (n == 1700221 || n == 1700222) {
            if (this.isStandardSelection()) {
                this.getLogHMI().log(1000000, "standard mode is selected -> do not change selection");
            } else {
                boolean bl = n == 1700221;
                ButtonModelApp buttonModelApp = bl ? this.getSwdlModels().getSelectAllButton() : this.getSwdlModels().getSelectNoneButton();
                this.getSwdlEnv().getLogMain().log(10000000, "Disable CheckStartDownloadButton");
                this.getSwdlModels().getCheckStartDownloadButton().setStatus(0);
                buttonModelApp.setStatus(0);
                if (bl) {
                    this.getSwdlEnv().getLogMain().log(10000000, "[AbstractEngineeringDeviceInfoManager] keyPressed(): enter waitsync mediator for swdlSelectAllButton");
                    this.getSwdlModels().getSelectAllSyncChoice().setStatus(0);
                } else {
                    this.getSwdlEnv().getLogMain().log(10000000, "[AbstractEngineeringDeviceInfoManager] keyPressed(): enter waitsync mediator for swdlSelectNoneButton");
                    this.getSwdlModels().getSelectNoneSyncChoice().setStatus(0);
                }
                buttonModelApp.fireEvent(n3);
                switch (this.getSelectionScreen()) {
                    case 0: {
                        int[] nArray = this.getAllDeviceIds();
                        if (null != nArray) {
                            for (int i2 = 0; i2 < nArray.length; ++i2) {
                                this.getDeviceInfoDSIHandler().doSetDeviceSelection(nArray[i2], bl ? 1 : 0);
                            }
                        } else {
                            this.getLogHMI().log(10000, "getAllDeviceIds() returned null!");
                        }
                        this.doGetDevices(1, null, false);
                        break;
                    }
                    case 1: {
                        this.getDeviceInfoDSIHandler().doSetDeviceSelection(this.getCurrentDeviceId(), bl ? 1 : 0);
                        this.doGetModules(this.currentDevice.getId());
                        break;
                    }
                    case 2: {
                        this.swdlFileList.setSelection(bl ? 1 : 0);
                        break;
                    }
                    default: {
                        this.getLogHMI().log(10000000, "ignore keyPressed(%1) Event!", (long)n);
                        break;
                    }
                }
            }
        } else if (n == 1700153) {
            this.getDeviceInfoDSIHandler().doGetErrors(this.currentDevice.getId());
            this.getSwdlModels().getShowErrorsButton().fireEvent(n3);
        } else if (n == 1700158) {
            this.getSwdlModels().getConfirmSummaryChangedButton().setStatus(0);
            this.getSwdlModels().getConfirmSummaryChangedButton().fireEvent(n3);
            switch (this.getSelectionScreen()) {
                case 1: {
                    this.doGetModules(this.currentDevice.getId());
                    break;
                }
                case 2: {
                    this.doGetFileInfos();
                    break;
                }
                default: {
                    this.doGetDevices(2, null, true);
                }
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected abstract void showSummaryChanged(int var1);
}

