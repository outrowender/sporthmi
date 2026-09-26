/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.engineering.fsc.IFSCServiceListener;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractDriverResetHandler;
import de.audi.tghu.swdl.app.customer.CustomerDLState;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractSelectionManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.AbstractCustomerProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import de.audi.tghu.swdl.app.list.SwdlListHandlerMedium;
import de.audi.tghu.swdl.app.list.SwdlListItemMedium;

public class CustomerSelectionManager
extends AbstractSelectionManager
implements IFSCServiceListener,
ButtonListener,
TimerListener {
    private static final String CLASSNAME;
    static final String[] EMPTYSTRINGARRAY;
    static final long FEC_IMPORT_TIMEOUT;
    private final int terminalID;
    private final SwdlListHandlerMedium swdlSourceMediumList;
    private boolean isFECImportActive = false;
    private final AbstractCustomerProgressManager customerProgressManager;
    private final AbstractDriverResetHandler driverResetHandler;
    private Timer fecImportTimer;
    private int fecMediumId;
    static final int ERROR_TYPE_WRONG_DATA;
    static final int ERROR_TYPE_NO_DATA;
    static final int ERROR_TYPE_DATA_NOT_ACTIVATED;

    public CustomerSelectionManager(SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, CustomerDeviceInfoManager customerDeviceInfoManager, AbstractCustomerProgressManager abstractCustomerProgressManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection, AbstractDriverResetHandler abstractDriverResetHandler) {
        super(swdlEnv, abstractPopupManager, customerDeviceInfoManager, swdlDSIHandlerSelection, swdlDSIHandlerDeviceInfo);
        this.customerProgressManager = abstractCustomerProgressManager;
        this.driverResetHandler = abstractDriverResetHandler;
        this.terminalID = 0;
        this.getLogHMI().log(-2137614336, "%1 <init>", (Object)"[CustomerSelectionManager]");
        this.swdlSourceMediumList = new SwdlListHandlerMedium(this.getSwdlEnv(), this, this.getSwdlModels().getCustomerSourceMediaList());
        this.getSwdlModels().getCustomerInitCustomerUpdateButton().setButtonListener(this);
        this.getSwdlModels().getCustomerOnlineUpdateInstallConfirmButton().setButtonListener(this);
        this.getSwdlModels().getResetDriverButton().setButtonListener(this);
    }

    private final AbstractCustomerProgressManager getCustomerProgressManager() {
        return this.customerProgressManager;
    }

    CustomerDLState getCustomerDlState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    @Override
    public void updateSourceMediaList(int[] nArray) {
        this.getLogHMI().log(1078071040, "%1 <- updateSourceMediaList( %2 ) ", (Object)"[CustomerSelectionManager]", (Object)nArray);
        this.swdlSourceMediumList.updateList(nArray);
        this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
        this.getSwdlModels().getCustomerInitCustomerUpdateButton().setStatus(1);
    }

    @Override
    public void updateAvailableMedia(byte by) {
        this.getLogHMI().log(1078071040, "%1 <- updateAvailableMedia( %2 ) ", (Object)"[CustomerSelectionManager]", (long)by);
        this.swdlSourceMediumList.updateAvailableMedia(by);
    }

    @Override
    public void doSelectSourceMedium(int n) {
        this.getLogHMI().log(1078071040, "%1 -> doSelectSourceMedium() ", (Object)"[CustomerSelectionManager]");
        SwdlListItemMedium swdlListItemMedium = (SwdlListItemMedium)this.swdlSourceMediumList.getEntry(n);
        this.getSwdlModels().getCustomerOrOnlineChoiceModel().setValue(0);
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getSwdlModels().getCustomerReadingMetaInfoStateChoice());
        this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(0);
        this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(0);
        modelGroup.flush();
        modelGroup.removeAll();
        this.getSwdlModels().getCustomerProgressStateChoice().setValue(1);
        this.getCustomerDlState().startSelectingSourceMedium(swdlListItemMedium.getId());
        this.checkFSCImport(swdlListItemMedium.getId());
        this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(swdlListItemMedium.getId());
    }

    @Override
    public synchronized void importFSCDone(int n) {
        this.getLogHMI().log(1078071040, "%1 -> importFSCDone(%3), isFECImportActive=%2 ", (Object)"[CustomerSelectionManager]", (Object)this.isFECImportActive, (long)n);
        this.cancelTimer(this.fecImportTimer);
        if (this.isFECImportActive) {
            this.getLogHMI().log(-2137614336, "[%1.importFSCDone()] call doSetMedium(%2) ", (Object)"[CustomerSelectionManager]", (long)n);
            this.isFECImportActive = false;
            this.getSelectionDSIHandler().doSetMedium(n);
        }
    }

    private final void checkFSCImport(int n) {
        if (null != this.getSwdlEnv().getFscService()) {
            this.getLogHMI().log(-2137614336, "[%1.doSelectSourceMedium(%2)] call startFSCImport ", (Object)"[CustomerSelectionManager]", (long)n);
            this.isFECImportActive = true;
            this.getSwdlEnv().getFscService().setFscServiceListener(this);
            this.getSwdlEnv().getFscService().startFSCImport(n);
            this.fecMediumId = n;
            this.fecImportTimer = new Timer("FECImportTimer", 0, true, this);
            this.fecImportTimer.restart();
        } else {
            this.getLogHMI().log(-2137614336, "[%1.doSelectSourceMedium(%2)] call doSetMedium ", (Object)"[CustomerSelectionManager]", (long)n);
            this.getSelectionDSIHandler().doSetMedium(n);
            this.isFECImportActive = false;
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        if (this.fecImportTimer != null && this.fecImportTimer.equals(timer)) {
            this.getLogHMI().log(10000, "%1 importing of FEC is timed out, call importFSCDone(%2)", (Object)"[CustomerSelectionManager]", (long)this.fecMediumId);
            this.importFSCDone(this.fecMediumId);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        if (timer != null && timer.equals(this.fecImportTimer)) {
            this.getLogHMI().log(-2137614336, "%1 cancel FEC import timer", (Object)"[CustomerSelectionManager]");
            timer.cancel();
            timer = null;
        }
    }

    @Override
    public void preSelectSourceMedium(int n) {
        this.getLogHMI().log(1078071040, "%1 preSelectSourceMedium( %2 ) ", (Object)"[CustomerSelectionManager]", (long)n);
        this.getSwdlModels().getCustomerPreselectedSourceChoice().setValue(n);
        if (n > 0) {
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(n);
            this.getCustomerDlState().startSelectingSourceMedium(n);
            this.checkFSCImport(n);
            if (this.isFECImportActive) {
                this.getSwdlModels().getCustomerUpdateProcessTextLabel().setStatus(0);
            }
        } else {
            this.doGetSourceMedia();
        }
    }

    private void selectionError(String string, int n) {
        this.getLogHMI().log(1078071040, "%1 selectionError(%2, %3)", (Object)"[CustomerSelectionManager]", (Object)string, (long)n);
        this.getSwdlModels().getCustomerErrorLabel().setText(string);
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getSwdlModels().getCustomerReadingMetaInfoStateChoice());
        switch (n) {
            case 1: {
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(2);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
                break;
            }
            case 2: {
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(3);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
                break;
            }
            default: {
                this.getLogHMI().log(1078071040, "%1 selectionError(): state=%2, value%3", (Object)"[CustomerSelectionManager]", 1L, -1L);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setStatus(1);
                this.getSwdlModels().getCustomerReadingMetaInfoStateChoice().setValue(-1);
            }
        }
        modelGroup.flush();
        modelGroup.removeAll();
        this.getLogHMI().log(-2137614336, "%1 selectionError(): showPopupCompatibilityCheckFailure and release WaitSync mediator", (Object)"[CustomerSelectionManager]");
        this.getCustomerProgressManager().showPopupCompatibilityCheckFailure();
        this.getLogHMI().log(-2137614336, "%1 selectionError(): abort media selection! ", (Object)"[CustomerSelectionManager]");
        this.getCustomerProgressManager().custDownloadLeaveProgress(this.getSwdlEnv().getTerminalId());
        this.getCustomerProgressManager().swdlProgressExit();
        this.getSwdlModels().getCustomerStartDownloadButton().setStatus(1);
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
        if (baseUpdateOverTheAirController.isInstallActive()) {
            baseUpdateOverTheAirController.resumeUota(1, false);
        }
    }

    @Override
    public void updateReleaseList(String[] stringArray, String string, int n) {
        this.getLogHMI().log(1078071040, "%1 updateReleaseList( %2, %3, %4 ) ", (Object)"[CustomerSelectionManager]", (Object)stringArray, (Object)string, (long)n);
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
        if (this.getCustomerDlState().isSelectingSourceMedium() || baseUpdateOverTheAirController.isInstallActive()) {
            this.getCustomerDlState().doneSelectingSourceMedium();
            if (this.getCustomerDlState().isCancelRequested()) {
                this.getLogHMI().log(-1601830656, "%1 cancel download is requested!", (Object)"[CustomerSelectionManager]");
                this.getCustomerDlState().cancelDone();
            } else if (n == 1) {
                if (stringArray.length == 1) {
                    this.doSelectRelease(0);
                } else if (stringArray.length == 0) {
                    this.getLogHMI().log(10000, "%1 no fitting release found on update medium! ", (Object)"[CustomerSelectionManager]");
                    String string2 = this.getTextFactory().getSelectionErrorNoFittingText();
                    this.selectionError(string2, 1);
                } else {
                    this.getLogHMI().log(10000, "%1 more than one release found ( %2 ) ! ", (Object)"[CustomerSelectionManager]", (long)stringArray.length);
                    String string3 = this.getTextFactory().getSelectionErrorMoreThanOneText();
                    this.selectionError(string3, 0);
                }
            } else {
                int n2;
                this.getLogHMI().log(10000, "%1 could not read release list ( %2 ) ! ", (Object)"[CustomerSelectionManager]", (long)n);
                switch (n) {
                    case 2: 
                    case 3: 
                    case 7: 
                    case 8: 
                    case 14: {
                        n2 = 1;
                        break;
                    }
                    case 4: 
                    case 5: 
                    case 6: 
                    case 9: 
                    case 10: 
                    case 13: 
                    case 15: {
                        n2 = 0;
                        break;
                    }
                    default: {
                        n2 = 0;
                    }
                }
                this.selectionError(string, n2);
            }
        } else {
            this.getLogHMI().log(10000, "%1 ignore unexpected updateReleaseList!", (Object)"[CustomerSelectionManager]");
        }
    }

    @Override
    public void doSelectRelease(int n) {
        this.getLogHMI().log(1078071040, "%1 -> doSelectRelease( %2 ) ", (Object)"[CustomerSelectionManager]", (long)n);
        this.getCustomerDlState().startSelectingRelease();
        this.getSelectionDSIHandler().doSetRelease(n);
    }

    @Override
    public void updateReleaseResult(String string, int n) {
        this.getLogHMI().log(1078071040, "%1 <- updateReleaseResult( %2, %3 ) ", (Object)"[CustomerSelectionManager]", (Object)string, (long)n);
        if (this.getCustomerDlState().isSelectingRelease()) {
            this.getCustomerDlState().doneSelectingRelease();
            if (this.getCustomerDlState().isCancelRequested()) {
                this.getLogHMI().log(-1601830656, "%1 cancel download is requested!", (Object)"[CustomerSelectionManager]");
                this.getCustomerDlState().cancelDone();
            } else if (n > 0) {
                this.doSetInstallationType(true);
                this.getDeviceInfoManager().doGetDevices(1, null, true);
            } else {
                this.getLogHMI().log(10000, "%1 could not read metainfo ( %2 ) ! ", (Object)"[CustomerSelectionManager]", (long)n);
                this.selectionError(string, 1);
            }
        } else {
            this.getLogHMI().log(10000, "%1 ignore unexpected updateReleaseResult!", (Object)"[CustomerSelectionManager]");
        }
    }

    @Override
    public void updateConsistency(int n, boolean bl, String string, int n2) {
        if (this.getLogHMI().isDebug()) {
            this.getLogHMI().log(-2137614336, "%1 updateConsistencyx( %2, %3, %4 ) ", (Object)"[CustomerSelectionManager]", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (Object)new StringBuffer().append(string).append(" ").append(n2).toString());
        }
        if (bl) {
            this.getSelectionDSIHandler().doGetIncompatibleDevices();
        } else {
            this.getLogHMI().log(-2137614336, "%1 updateConsistency: download impossible due to consistency problem! ", (Object)"[CustomerSelectionManager]");
            String string2 = this.getTextFactory().getSelectionErrorUpdateInconsistentText();
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(2);
            this.selectionError(string2, 0);
        }
    }

    @Override
    public void updateIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        this.getLogHMI().log(-2137614336, "%1 updateIncompatibleDevices( %2, %3 ) ", (Object)"[CustomerSelectionManager]", (Object)stringArray, (Object)stringArray2);
        if (stringArray == null || stringArray.length == 0) {
            this.getSwdlEnv().getLogMain().log(1078071040, "%1 readyForCustomerUpdate()", (Object)"[CustomerSelectionManager]");
            this.getSwdlEnv().sendMessage(5);
            this.getCustomerProgressManager().swdlProgressEntered();
            this.getSelectionDSIHandler().startDownload();
            if (!this.getSwdlEnv().getHMISwitcher().getUOTAController().isUotaEntered()) {
                if (this.terminalID == -2) {
                    this.getCustomerProgressManager().showCustDownloadInfoPopup(this.getSwdlEnv().getTerminalId());
                } else {
                    this.getCustomerProgressManager().showCustDownloadInfoPopup(this.terminalID);
                }
            }
            this.getLogHMI().log(-2137614336, "%1 selectionError: release WaitSync mediator", (Object)"[CustomerSelectionManager]");
            this.getSwdlModels().getCustomerStartDownloadButton().setStatus(1);
        } else {
            this.getLogHMI().log(-2137614336, "%1 updateIncompatibleDevices: download canceled due to incompatible device! ", (Object)"[CustomerSelectionManager]");
            String string = this.getTextFactory().getSelectionErrorIncompDevicesText();
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(2);
            this.selectionError(string, 0);
        }
    }

    @Override
    public void removeSwdlDataDir() {
    }

    private final CustomerDLState getCustomerDLState() {
        return this.getSwdlEnv().getCustomerDLState();
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1078071040, "CustomerSelectionManager.keyTyped(modelID=%1, terminalID=%2)", (long)n, (long)n3);
        if (this.getSwdlModels().getCustomerOnlineUpdateInstallConfirmButton().getID() == n) {
            this.getCustomerDLState().startCustomerOnlineUpdate(false, n3);
        } else if (this.getSwdlModels().getCustomerInitCustomerUpdateButton().getID() == n) {
            if (!this.getSwdlEnv().isCustomerDownloadActive()) {
                this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(0);
                this.getSwdlModels().getCustomerInitCustomerUpdateButton().setStatus(0);
            }
            this.getSwdlModels().getUotaExcludeNavdataChoiceModel().setValue(0);
            this.getCustomerDlState().fireEnterCustomerUpdate(n3);
        } else if (this.getSwdlModels().getResetDriverButton().getID() == n) {
            if (this.getCustomerDLState().isSwdlActive()) {
                this.getSwdlEnv().getLogMain().log(10000, "CustomerSelectionManager.resetDriver: An update is already active! No reset driver can be started! (terminalID=%1)", (long)n3);
            } else {
                this.driverResetHandler.resetDriver(n3);
            }
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    static {
        EMPTYSTRINGARRAY = new String[0];
    }
}

