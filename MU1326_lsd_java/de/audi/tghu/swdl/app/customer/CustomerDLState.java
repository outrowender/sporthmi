/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer;

import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;

public class CustomerDLState
implements TimerListener {
    public static final int ERROR_OK;
    public static final int ERROR_SWDL_NOT_READY;
    public static final int PROGRESS_NONE;
    public static final int PROGRESS_SELECTION;
    public static final int PROGRESS_SELECTION_DONE;
    public static final int PROGRESS_DOWNLOADING;
    public static final int PROGRESS_SUMMARY;
    public static final int PROGRESS_RESTART;
    public static final int PROGRESS_ABORT_MEDIA_SELECTION_PRESSED;
    public static final int PROGRESS_CHECK_START_DOWNLOAD;
    public static final int PROGRESS_CANCEL_DOWNLOAD_PRESSED;
    private static final String CLASSNAME;
    private final LogChannel log;
    private boolean cancelRequested = false;
    private volatile boolean selectingSourceMedium = false;
    private volatile boolean selectingRelease = false;
    private volatile boolean selectingDevices = false;
    private boolean custDownloadStarted = false;
    private boolean isCustDownloadStateUpdated = false;
    private boolean isCustomerUpdateHasFocus = false;
    private final Timer cancelDoneTimer = new Timer("Cancel Customer Swdl Selection", 0, true, this);
    private final HMISwitcher hmiSwitcher;
    private final SwdlModels swdlModels;
    private final SwdlEnv swdlEnv;
    private int error = 0;
    private int terminalID = 0;
    private final SwdlDSIHandlerSelection swdlDSISelectionHandler;

    public CustomerDLState(SwdlEnv swdlEnv, HMISwitcher hMISwitcher, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        this.hmiSwitcher = hMISwitcher;
        this.swdlEnv = swdlEnv;
        this.swdlModels = swdlEnv.getSwdlModels();
        this.swdlDSISelectionHandler = swdlDSIHandlerSelection;
        this.log = swdlEnv.getLogCustomer();
        this.reset();
    }

    private final SwdlModels getSwdlModels() {
        return this.swdlModels;
    }

    private final HMISwitcher getHmiSwitcher() {
        return this.hmiSwitcher;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private void reset() {
        this.cancelRequested = false;
        this.selectingSourceMedium = false;
        this.selectingRelease = false;
    }

    public boolean isSwdlActive() {
        return this.getSwdlEnv().isCustomerDownloadActive() || this.getSwdlEnv().isEngineeringDownloadActive();
    }

    public boolean isCancelRequested() {
        this.log.log(1078071040, "%1 isCancelRequested(): %2", (Object)"[CustomerDLState]", (Object)this.cancelRequested);
        return this.cancelRequested;
    }

    public void startSelectingSourceMedium(int n) {
        this.selectingSourceMedium = true;
    }

    public void doneSelectingSourceMedium() {
        this.selectingSourceMedium = false;
    }

    public boolean isSelectingSourceMedium() {
        return this.selectingSourceMedium;
    }

    public void startSelectingRelease() {
        this.selectingRelease = true;
    }

    public void doneSelectingRelease() {
        this.selectingRelease = false;
    }

    public boolean isSelectingRelease() {
        return this.selectingRelease;
    }

    public void startSelectingDevices() {
        this.log.log(-2137614336, "%1 startSelectingDevices()", (Object)"[CustomerDLState]");
        this.selectingDevices = true;
    }

    public void doneSelectingDevices() {
        this.log.log(-2137614336, "%1 doneSelectingDevices()", (Object)"[CustomerDLState]");
        this.selectingDevices = false;
    }

    public boolean isSelectingDevices() {
        return this.selectingDevices;
    }

    public void requestCancel() {
        this.log.log(1078071040, "%1 requestCancel()", (Object)"[CustomerDLState]");
        this.cancelRequested = true;
        if (this.selectingRelease) {
            this.getHmiSwitcher().getSelectionManager().leaveReadingMetainfo();
            this.doneSelectingRelease();
        }
        if (this.selectingSourceMedium) {
            this.getHmiSwitcher().getSelectionManager().leaveReadingReleases();
            this.doneSelectingSourceMedium();
        }
        this.doneSelectingDevices();
        this.cancelDoneTimer.restart();
    }

    public void cancelDone() {
        this.log.log(1078071040, "%1 cancelDone()", (Object)"[CustomerDLState]");
        if (this.cancelRequested) {
            this.cancelRequested = false;
            this.cancelDoneTimer.cancel();
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.log.log(1078071040, "%1 cancelDone() Timer expired!", (Object)"[CustomerDLState]");
        this.cancelDone();
    }

    public void setLanguage(Language language) {
        this.getSwdlEnv().getLogMain().log(1078071040, "CustomerDLState.setLanguage(language=%1)", (Object)language);
        this.getHmiSwitcher().getVersionInfoController().setLanguage(language);
    }

    public int getErrorCode() {
        return this.error;
    }

    public void setErrorCode(int n) {
        this.error = n;
    }

    public void fireEnterCustomerUpdate(int n) {
        this.getSwdlModels().getCustomerInitCustomerUpdateButton().fireEvent(n);
    }

    public void startCustomerUpdate(boolean bl, int n) {
        if (this.getSwdlModels().getCustomerProgressStateChoice().getValue() == 2 || this.getSwdlModels().getCustomerProgressStateChoice().getValue() == 1) {
            this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.startCustomerUpdate(%1): reset customer update", (long)n);
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
            this.abortSelection(n);
            return;
        }
        this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.startCustomerUpdate(%1)", (long)n);
        if (this.isSwdlActive()) {
            this.getSwdlEnv().getLogMain().log(10000, "CustomerDLState.startCustomerUpdate: An update is already active! No new update can be started! (reboot=%1,terminalID=%2)", bl, (long)n);
        } else {
            this.terminalID = n;
            this.setErrorCode(0);
            this.getHmiSwitcher().initCustomerUpdate(0, bl, n);
        }
        this.isCustomerUpdateHasFocus = true;
        if (n == 3) {
            this.getSwdlModels().getCustDlDisabledChoice(4).setValue(1);
        } else if (n == 4) {
            this.getSwdlModels().getCustDlDisabledChoice(3).setValue(1);
        }
    }

    public void updateCustDownloadState(boolean bl) {
        if (!this.isCustDownloadStateUpdated) {
            this.getSwdlEnv().getLogHMI().log(1078071040, "CustomerDLState.updateCustDownloadState(custDownloadActive=%1)", (Object)bl);
            if (bl) {
                this.getSwdlEnv().getSwdlModels().getCustomerUpdateAgainRequestChoice().setValue(1);
                this.getHmiSwitcher().initCustomerUpdate(-1, true, this.terminalID);
            }
            if (!this.custDownloadStarted) {
                this.custDownloadStarted = true;
                if (bl) {
                    this.getSwdlEnv().getBulkCopyAccess().setInitialBulkCopyClientState(3);
                } else {
                    this.getSwdlEnv().getBulkCopyAccess().setInitialBulkCopyClientState(4);
                }
            }
            this.isCustDownloadStateUpdated = true;
        }
    }

    public void downloadCompleted(int n) {
        this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.downloadCompleted(errorCode=%1)", (long)n);
        this.setErrorCode(n);
    }

    public void abortSelection(int n) {
        this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.abortSelection()");
        if (this.getSwdlEnv().getHMISwitcher().getUOTAController().isUotaEntered()) {
            this.getSwdlEnv().getHMISwitcher().getUOTAController().abortUotaSequence();
        } else if (this.getSwdlModels().getCustomerProgressStateChoice().getValue() != 2) {
            this.requestCancel();
        }
    }

    private void customerUpdateDone() {
        this.customerUpdateDone(true);
    }

    private void customerUpdateDone(boolean bl) {
        this.swdlEnv.getLogHMI().log(-2137614336, "CustomerDLState.customerUpdateDone(%1)", bl);
        if (bl) {
            this.getHmiSwitcher().releaseSwdlFocus();
        }
        this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
        this.getSwdlModels().getCustDlDisabledChoice(3).setValue(0);
        this.getSwdlModels().getCustDlDisabledChoice(4).setValue(0);
        this.getSwdlEnv().sendMessage(9);
        this.getSwdlEnv().setCustomerDownloadActive(false);
        this.getSwdlEnv().getBulkCopyAccess().bulkCopyUnlock();
        this.getSwdlEnv().updateCustomerDownloadState(0, 0);
        this.getSwdlModels().getStartDownloadButton().setStatus(1);
        this.getSwdlEnv().setCustProgressIconVisible(false);
        if (!this.getSwdlEnv().getHMISwitcher().getUOTAController().isMapIntegrationInProgress()) {
            this.getSwdlModels().updateCustomerProgress(0);
        }
        this.getSwdlEnv().removeCustomerDLState();
        this.downloadCompleted(0);
        this.terminalID = 0;
    }

    public void requestCustDownloadCancel(int n) {
        this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.requestCustDownloadCancel()");
        this.getSwdlEnv().getVariantAppSystem().cancelCustomerDownload(n);
    }

    public void leaveCustomerUpdate() {
        this.leaveCustomerUpdate(this.terminalID);
    }

    public void startCustomerOnlineUpdate(boolean bl, int n) {
        if (this.isSwdlActive()) {
            this.getSwdlEnv().getLogMain().log(10000, "CustomerDLState.startCustomerOnlineUpdate: An update is already active! No new update can be started! (reboot=%1, terminalID=%2)", bl, (long)n);
        } else {
            this.terminalID = n;
            this.setErrorCode(0);
            this.getHmiSwitcher().initCustomerUpdate(0, bl, n);
            this.getSwdlEnv().getVariantAppSystem().jumpToCustomerDownload(n);
        }
    }

    private void leaveCustomerUpdateInternal(int n) {
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
        int n2 = this.getSwdlModels().getCustomerProgressStateChoice().getValue();
        this.swdlEnv.getLogHMI().log(-2137614336, "CustomerDLState.leaveCustomerUpdateInternal(terminalID=%1), currentProgressState=%2, currentUotaState=%3", (long)n, (long)n2, (long)baseUpdateOverTheAirController.getUotaState());
        if (baseUpdateOverTheAirController.isDownloadWaitForConnection()) {
            this.swdlEnv.getLogHMI().log(-2137614336, "CustomerDLState.leaveCustomerUpdateInternal: UOTA download waits for connection - do nothing");
            return;
        }
        switch (n2) {
            case 3: 
            case 7: {
                break;
            }
            case 5: {
                this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
                this.swdlDSISelectionHandler.resetDownloadIsStartedFlag();
                this.getHmiSwitcher().getSelectionManager().doCheckStartDownload();
                break;
            }
            case 4: 
            case 8: {
                this.getHmiSwitcher().getProgressManager().custDownloadLeaveProgress(n);
                this.getHmiSwitcher().getProgressManager().swdlProgressExit();
                this.swdlDSISelectionHandler.abortVersionUpload();
                this.getSwdlEnv().sendMessage(7);
                this.customerUpdateDone();
                this.getHmiSwitcher().getVersionInfoController().readVersionInfo(this.getSwdlEnv().getCurrentHmiLanguage());
                break;
            }
            default: {
                if (baseUpdateOverTheAirController.isDownloadActive() || baseUpdateOverTheAirController.isWaitForPDD() || baseUpdateOverTheAirController.isInstallActive()) {
                    this.swdlEnv.getLogHMI().log(-2137614336, "CustomerDLState.leaveCustomerUpdateInternal: UOTA download, selection or installing active - do nothing");
                    break;
                }
                if (!baseUpdateOverTheAirController.isInstallActive() && baseUpdateOverTheAirController.isUotaEntered()) {
                    this.getHmiSwitcher().getProgressManager().custDownloadLeaveProgress(n);
                    if (baseUpdateOverTheAirController.isLeavingSWDL() || baseUpdateOverTheAirController.isUotaSelectionActive()) {
                        this.getHmiSwitcher().getProgressManager().swdlProgressExit();
                        this.getSwdlEnv().sendMessage(7);
                        this.customerUpdateDone();
                        this.getHmiSwitcher().getVersionInfoController().readVersionInfo(this.getSwdlEnv().getCurrentHmiLanguage());
                    }
                    if (baseUpdateOverTheAirController.isDownloadRequested()) break;
                    if (baseUpdateOverTheAirController.isUotaPackagesRequested()) {
                        baseUpdateOverTheAirController.abortUotaSequence();
                        this.customerUpdateDone();
                    }
                    baseUpdateOverTheAirController.resetUotaState();
                    baseUpdateOverTheAirController.cancelProcessUotaPackages(true);
                    break;
                }
                if (this.getSwdlEnv().isCustomerDownloadActive()) {
                    this.customerUpdateDone();
                    break;
                }
                this.customerUpdateDone(false);
            }
        }
    }

    public void leaveCustomerUpdate(int n) {
        this.getSwdlEnv().getLogCustomer().log(1078071040, "CustomerDLState.leaveCustomerUpdate(terminalID=%1)", (long)n);
        this.leaveCustomerUpdateInternal(n);
        this.isCustomerUpdateHasFocus = false;
    }

    public void leaveCustomerUpdatePopups(int n, int n2) {
        this.getSwdlEnv().getLogHMI().log(1078071040, "CustomerDLState.leaveCustomerUpdatePopups(terminalID=%1, popupID=%2)", (long)n, (long)n2);
        switch (n2) {
            case 2: {
                this.getHmiSwitcher().getProgressManager().continueProgressInterrupt();
                this.getSwdlEnv().setCustProgressIconVisible(true);
                return;
            }
        }
        this.leaveCustomerUpdateInternal(n);
    }

    public boolean isCustomerUpdateHasFocus() {
        return this.isCustomerUpdateHasFocus;
    }
}

