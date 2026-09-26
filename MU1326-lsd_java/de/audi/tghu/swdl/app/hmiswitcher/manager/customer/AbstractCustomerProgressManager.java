/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.customer;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractCustDownloadActionProxy;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public abstract class AbstractCustomerProgressManager
extends AbstractProgressManager
implements ButtonListener {
    private static final String CLASSNAME;
    private static final int PROGRESS_TYPE_PROGRESS;
    private static final int PROGRESS_TYPE_TIMEOUT;
    private static final int PROGRESS_STEP_PREPARE;
    private static final int PROGRESS_STEP_INSTALL;
    private static final int PROGRESS_STEP_FINALIZE;
    private static final String PREPARE_TIMEOUT_MARKER;
    private static final String FINALIZE_MARKER;
    private int currentPopup = -1;
    private String currentPopupId = null;
    private boolean interruptScreenEntered = false;
    private boolean abortRequestedByUser = false;
    private boolean isUOTAUpdate = false;
    private final CustomerDeviceInfoManager customerDeviceInfoManager;

    public AbstractCustomerProgressManager(AbstractCustDownloadActionProxy abstractCustDownloadActionProxy, SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, CustomerDeviceInfoManager customerDeviceInfoManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerProgress);
        this.customerDeviceInfoManager = customerDeviceInfoManager;
        this.getSwdlModels().getCustomerInterruptContinueButton().setButtonListener(this);
        this.getSwdlModels().getCustomerInterruptAbortButton().setButtonListener(this);
        this.getSwdlModels().getCustomerStartUpdateAgainButton().setButtonListener(this);
        this.getSwdlModels().getCustomerStartUpdateCancelButton().setButtonListener(this);
        this.getSwdlModels().getCustomerSummarySuccessConfirmButton().setButtonListener(this);
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(this.getSwdlModels().getCustomerDownloadingStateChoice());
        this.getSwdlModels().getCustomerDownloadingStateChoice().setValue(0);
        this.getSwdlModels().getCustomerDownloadingStateChoice().setStatus(0);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private final CustomerDeviceInfoManager getCustomerDeviceInfoManager() {
        return this.customerDeviceInfoManager;
    }

    @Override
    public void keyPressed(int n, int n2, int n3) {
    }

    @Override
    public void keyReleased(int n, int n2, int n3) {
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1078071040, "%1 keyTyped( %2 ) ", (Object)"[AbstractCustomerProgressManager]", (long)n);
        if (n == this.getSwdlModels().getCustomerInterruptContinueButton().getID()) {
            this.getProgressDSIHandler().doHandleUserSelection(this.currentPopup, this.currentPopupId, 3);
            this.interruptScreenEntered = false;
            this.getSwdlModels().getCustomerInterruptContinueButton().fireEvent(-1);
        } else if (n == this.getSwdlModels().getCustomerInterruptAbortButton().getID()) {
            this.getSwdlModels().getCustomerProgressRange().setValue(0);
            this.getProgressDSIHandler().doHandleUserSelection(this.currentPopup, this.currentPopupId, 2);
            this.interruptScreenEntered = false;
            this.abortRequestedByUser = true;
            this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(0);
            this.getSwdlModels().getCustomerInterruptAbortButton().fireEvent(-1);
        } else if (n == this.getSwdlModels().getCustomerStartUpdateAgainButton().getID()) {
            this.getLogHMI().log(-2137614336, "%1 -- start update again! ", (Object)"[AbstractCustomerProgressManager]");
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(5);
            this.getSwdlModels().getCustomerStartUpdateAgainButton().fireEvent(n3);
        } else if (n == this.getSwdlModels().getCustomerStartUpdateCancelButton().getID()) {
            this.getLogHMI().log(-2137614336, "%1 -- user cancels the update! ", (Object)"[AbstractCustomerProgressManager]");
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
            if (this.isUOTAUpdate) {
                this.getSwdlEnv().getHMISwitcher().getUOTAController().resumeUota(1, false);
            } else {
                this.getSwdlModels().getCustomerProgressStateChoice().setValue(8);
                this.getSwdlModels().getCustomerStartUpdateCancelButton().fireEvent(n3);
            }
        } else if (n == this.getSwdlModels().getCustomerSummarySuccessConfirmButton().getID()) {
            this.getLogHMI().log(-2137614336, "%1 -- user confirms the successful %2 update! ", (Object)"[AbstractCustomerProgressManager]", (Object)(this.isUOTAUpdate ? "UOTA" : "customer"));
            if (this.isUOTAUpdate || !this.getSwdlEnv().getHMISwitcher().getUOTAController().isSummaryPopupConfirmed()) {
                this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
                this.getSwdlEnv().getHMISwitcher().getUOTAController().confirmSummaryPopup();
                this.getSwdlModels().getCustomerSummarySuccessConfirmButton().fireEvent(n3);
            } else {
                this.getSwdlModels().getCustomerSummarySuccessConfirmButton().fireEvent(n3);
            }
        } else {
            this.getLogHMI().log(1078071040, "%1 ignore unexpected event( modelID: %2 ) ", (Object)"[AbstractCustomerProgressManager]", (long)n);
        }
    }

    @Override
    public void keyLongTyped(int n, int n2, int n3) {
    }

    @Override
    public void switchUotaProgressState(boolean bl) {
        this.isUOTAUpdate = true;
        this.getLogHMI().log(1078071040, "%1 switchUotaProgressState(%2)", (Object)"[AbstractCustomerProgressManager]", (Object)bl);
        this.removePopupUpdateRestart();
        BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
        if (bl) {
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(4);
            this.showPopupUpdateFailure();
        } else {
            baseUpdateOverTheAirController.resumeUota(0, true);
        }
    }

    @Override
    public void showSummaryUota(boolean bl) {
        this.isUOTAUpdate = true;
        this.getLogHMI().log(1078071040, "%1 showSummary(%2)", (Object)"[AbstractCustomerProgressManager]", (Object)bl);
        this.removePopupUpdateRestart();
        this.getSwdlModels().getCustomerProgressStateChoice().setValue(4);
        if (bl) {
            this.showPopupUpdateFailure();
        } else {
            BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
            if (baseUpdateOverTheAirController.isLastPackageDownloaded()) {
                baseUpdateOverTheAirController.resumeUota(0, false);
            } else {
                baseUpdateOverTheAirController.resumeUota(0, true);
            }
        }
    }

    protected void showSummary(boolean bl) {
        this.isUOTAUpdate = false;
        this.getLogHMI().log(1078071040, "%1 showSummary(%2)", (Object)"[AbstractCustomerProgressManager]", (Object)bl);
        this.getSwdlModels().getCustomerUpdateAgainRequestChoice().setValue(bl ? 1 : 0);
        this.removePopupUpdateRestart();
        if (!this.abortRequestedByUser) {
            if (bl) {
                this.getLogHMI().log(-2137614336, "%1 show summary popup (failure)", (Object)"[AbstractCustomerProgressManager]");
                this.showPopupUpdateFailure();
            } else {
                this.getLogHMI().log(-2137614336, "%1 show summary popup (success)", (Object)"[AbstractCustomerProgressManager]");
                this.showPopupUpdateSuccessful();
            }
        } else {
            this.getLogHMI().log(-2137614336, "%1 do not show any summary popup because of previous user 'abort'-interaction", (Object)"[AbstractCustomerProgressManager]");
            this.abortRequestedByUser = false;
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(4);
            this.getSwdlEnv().getCustomerDLState().leaveCustomerUpdate();
        }
        this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
    }

    private void showInterruptScreen(String string) {
        this.getLogHMI().log(1078071040, "%1 showInterruptScreen(%2): interruptScreenEntered=%3", (Object)"[AbstractCustomerProgressManager]", (Object)string, (Object)this.interruptScreenEntered);
        if (!this.interruptScreenEntered) {
            this.interruptScreenEntered = true;
            this.getSwdlModels().getCustomerProgressInterruptedLabel().setText(string);
            this.removePopupUpdateRestart();
            this.showPopupUpdateInterrupted();
            this.getSwdlEnv().updateCustomerDownloadState(2, this.getSwdlModels().getCustomerProgressRange().getValue());
        }
    }

    @Override
    public void updateGeneralProgress(GeneralProgress generalProgress) {
        this.getLogHMI().log(1078071040, "%1 updateGeneralProgress: %2", (Object)"[AbstractCustomerProgressManager]", (Object)generalProgress);
    }

    @Override
    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        if (deviceOverviewProgressArray.length >= 1) {
            int n;
            int n2 = n = deviceOverviewProgressArray[0].getValue();
            this.getLogHMI().log(1078071040, "%1 updateDevicesOverviewProgress: %2 %3", (Object)"[AbstractCustomerProgressManager]", (Object)deviceOverviewProgressArray[0].getFileName(), (long)n);
            BaseUpdateOverTheAirController baseUpdateOverTheAirController = this.getSwdlEnv().getHMISwitcher().getUOTAController();
            if (!baseUpdateOverTheAirController.isInstallActive()) {
                this.getSwdlModels().getCurrentDownloadPackageLabelModel().setText("1");
                this.getSwdlModels().getTotalDownloadPackagesLabelModel().setText("1");
                baseUpdateOverTheAirController.setUotaUpdate(false);
            }
            if (2 == deviceOverviewProgressArray[0].getType()) {
                if (deviceOverviewProgressArray[0].getFileName().endsWith("_Prepare")) {
                    n2 = baseUpdateOverTheAirController.installingProgress2CrossProgress(0);
                    this.getLogHMI().log(-2137614336, "%1 updateDevicesOverviewProgress: Prepare", (Object)"[AbstractCustomerProgressManager]");
                    this.getSwdlModels().getCustomerDLProgressTypeChoiceModel().setValue(1);
                    this.getSwdlModels().updateCustomerProgress(n2);
                } else if (deviceOverviewProgressArray[0].getFileName().endsWith("_Finalize")) {
                    n2 = baseUpdateOverTheAirController.installingProgress2CrossProgress(100);
                    this.getLogHMI().log(-2137614336, "%1 updateDevicesOverviewProgress: Finalize", (Object)"[AbstractCustomerProgressManager]");
                    this.getSwdlModels().getCustomerDLProgressTypeChoiceModel().setValue(3);
                    this.getSwdlModels().updateCustomerProgress(n2);
                }
                this.getSwdlModels().getCustomerUpdateProgressTimeoutChoiceModel().setValue(1);
                this.getSwdlModels().getCustomerUpdateProgressTimeoutLabelModel().setText(Integer.toString(n));
            } else {
                this.getSwdlModels().getCustomerUpdateProgressTimeoutChoiceModel().setValue(0);
                this.getSwdlModels().getCustomerDLProgressTypeChoiceModel().setValue(2);
                this.getSwdlModels().updateCustomerProgress(baseUpdateOverTheAirController.installingProgress2CrossProgress(n));
                if (n < 100) {
                    this.getSwdlModels().getCustomerUpdateProcessTextLabel().setStatus(1);
                } else {
                    this.getSwdlModels().getCustomerUpdateProcessTextLabel().setText("");
                }
            }
            this.getSwdlEnv().updateCustomerDownloadState(1, n2);
        } else {
            this.getLogHMI().log(1078071040, "%1 updateDevicesOverviewProgress()", (Object)"[AbstractCustomerProgressManager]");
        }
    }

    @Override
    public void selectForDetails(String string) {
    }

    @Override
    public void updateStaticProgressDetails(int n, int n2, short s, String string) {
    }

    @Override
    public void updateDynamicProgressDetails(String string, byte by) {
    }

    @Override
    public void updateLostDevices(String[] stringArray) {
    }

    @Override
    public void triggerPanel(int n) {
        boolean bl = false;
        switch (n) {
            case 0: {
                this.getLogHMI().log(-2137614336, "%1 triggerPanel(): No trigger panel to activate!", (Object)"[AbstractCustomerProgressManager]");
                break;
            }
            case 1: {
                this.getLogHMI().log(-2137614336, "%1 triggerPanel(): Trigger reboot panel", (Object)"[AbstractCustomerProgressManager]");
                this.getSwdlModels().getRebootCountdown().setText("");
                this.showPopupUpdateRestart();
                this.getPopupManager().disablePopups();
                this.getPopupManager().removeAllPopups();
                this.startRebootCountdown();
                bl = true;
                break;
            }
            case 2: {
                this.getLogHMI().log(-2137614336, "%1 triggerPanel(): Trigger summary panel", (Object)"[AbstractCustomerProgressManager]");
                this.getProgressDSIHandler().stopProgressUpdates();
                this.getCustomerDeviceInfoManager().doGetDevices(2, null, true);
                this.getSwdlModels().getCustomerProgressStateChoice().setValue(4);
                bl = true;
                break;
            }
            default: {
                this.getLogHMI().log(-2137614336, "%1 triggerPanel(): ignore triggerPanel(%2) Event!", (Object)"[AbstractCustomerProgressManager]", (long)n);
            }
        }
        if (bl) {
            this.getSwdlEnv().setCustProgressIconVisible(false);
        }
    }

    @Override
    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.getLogHMI().log(1078071040, "%1 indicatePopUp(popUp=%2, id=%3, errorCode=%4)", (Object)"[AbstractCustomerProgressManager]", (Object)new Integer(n), (Object)string, (long)n2);
        this.currentPopup = n;
        this.currentPopupId = string;
        boolean bl = false;
        switch (n) {
            case 5: {
                this.getProgressDSIHandler().doHandleUserSelection(n, string, 5);
                break;
            }
            case 6: {
                this.getProgressDSIHandler().doHandleUserSelection(n, string, 6);
                break;
            }
            case 7: {
                this.showInterruptScreen("\n".concat(this.getTextFactory().getTextConstantCustProgressPleaseInsert()));
                bl = true;
                break;
            }
            case 8: {
                break;
            }
            case 2: 
            case 3: 
            case 10: {
                String string3 = this.getTextFactory().getTextConstantPopupMessage14();
                String[] stringArray = new String[]{string, this.getSwdlEnv().getTextFactory().getFileErrorText(n2), Integer.toString(n2), Integer.toString(n3)};
                this.showInterruptScreen(StringUtilities.formatMessage(string3, stringArray));
                bl = true;
                break;
            }
            case 4: 
            case 9: 
            case 11: {
                this.getProgressDSIHandler().doHandleUserSelection(n, string, 2);
                bl = true;
                break;
            }
        }
        if (bl) {
            this.getSwdlEnv().setCustProgressIconVisible(false);
        }
    }

    @Override
    public void indicateDismissPopUp(int n, String string) {
    }

    @Override
    public boolean swdlProgressEntered() {
        ChoiceModelApp choiceModelApp;
        this.getSwdlEnv().getLogMain().log(1078071040, "%1 swdlProgressEntered()", (Object)"[AbstractCustomerProgressManager]");
        boolean bl = true;
        ChoiceModelApp choiceModelApp2 = this.getSwdlModels().getCustomerNaviDbChoice();
        if (null != choiceModelApp2 && 1 == choiceModelApp2.getValue() && null != (choiceModelApp = this.getSwdlModels().getNaviUpdateRunning())) {
            choiceModelApp.setValue(1);
        }
        this.getSwdlEnv().setCustProgressIconVisible(true);
        if (this.getSwdlModels().getCustomerProgressStateChoice().getValue() >= 3 && this.getSwdlModels().getCustomerProgressStateChoice().getValue() != 7) {
            this.getSwdlEnv().getLogMain().log(1078071040, "%1 ... reentering a download in progress", (Object)"[AbstractCustomerProgressManager]");
            bl = false;
        } else {
            this.getSwdlEnv().getLogMain().log(1078071040, "%1 Intialize a new customer download!", (Object)"[AbstractCustomerProgressManager]");
            int n = this.getSwdlEnv().getHMISwitcher().getUOTAController().installingProgress2CrossProgress(0);
            this.getSwdlModels().updateCustomerProgress(n);
            this.getSwdlEnv().updateCustomerDownloadState(1, n);
            this.getSwdlModels().getCustomerProgressStateChoice().setValue(3);
            this.getProgressDSIHandler().startProgressUpdates();
        }
        return bl;
    }

    @Override
    public void swdlProgressExit() {
        this.getSwdlEnv().getLogMain().log(1078071040, "%1 swdlProgressExit()", (Object)"[AbstractCustomerProgressManager]");
        ChoiceModelApp choiceModelApp = this.getSwdlModels().getNaviUpdateRunning();
        if (null != choiceModelApp) {
            choiceModelApp.setValue(0);
        }
    }

    @Override
    public void swdlProgressDetailEntered() {
    }

    @Override
    public void swdlProgressDetailExit() {
    }

    @Override
    public void swdlStartWaitLostDevices() {
    }

    @Override
    public void swdlStopWaitLostDevices() {
    }

    @Override
    public void swdlSummaryEntered() {
        this.getSwdlEnv().getLogMain().log(1000, "%1 swdlSummaryEntered()", (Object)"[AbstractCustomerProgressManager]");
    }

    public void abortProgressInterrupt() {
        if (this.interruptScreenEntered) {
            this.interruptScreenEntered = false;
            this.getSwdlEnv().getLogMain().log(1078071040, "%1 CustomerUpdateActionProxy: abortProgressInterrupt()", (Object)"[AbstractCustomerProgressManager]");
            this.abortRequestedByUser = true;
            this.getProgressDSIHandler().doHandleUserSelection(this.currentPopup, this.currentPopupId, 2);
        }
    }

    @Override
    public void continueProgressInterrupt() {
        if (this.abortRequestedByUser) {
            this.abortProgressInterrupt();
        } else if (this.interruptScreenEntered) {
            this.interruptScreenEntered = false;
            this.getSwdlEnv().getLogMain().log(1078071040, "%1 CustomerUpdateActionProxy: continueProgressInterrupt()", (Object)"[AbstractCustomerProgressManager]");
            this.getProgressDSIHandler().doHandleUserSelection(this.currentPopup, this.currentPopupId, 3);
        }
    }

    protected abstract void showPopupUpdateFailure() {
    }

    @Override
    public abstract void showPopupUpdateSuccessful() {
    }

    protected abstract void removePopupUpdateRestart() {
    }

    protected abstract void showPopupUpdateInterrupted() {
    }

    protected abstract void showPopupUpdateRestart() {
    }

    protected abstract void showPopupCompatibilityCheckFailure() {
    }

    @Override
    public abstract void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    @Override
    public abstract void custDownloadLeaveProgress(int n) {
    }

    @Override
    public abstract void showCustDownloadInfoPopup(int n) {
    }
}

