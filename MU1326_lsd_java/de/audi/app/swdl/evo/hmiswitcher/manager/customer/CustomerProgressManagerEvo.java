/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.swdl.evo.hmiswitcher.manager.customer;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.AbstractCustDownloadActionProxy;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.AbstractCustomerProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.customer.CustomerDeviceInfoManager;

public class CustomerProgressManagerEvo
extends AbstractCustomerProgressManager {
    public CustomerProgressManagerEvo(AbstractCustDownloadActionProxy abstractCustDownloadActionProxy, SwdlEnv swdlEnv, AbstractPopupManager abstractPopupManager, CustomerDeviceInfoManager customerDeviceInfoManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(abstractCustDownloadActionProxy, swdlEnv, abstractPopupManager, customerDeviceInfoManager, swdlDSIHandlerProgress);
    }

    @Override
    protected void removePopupUpdateRestart() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Remove pop-up POPUP_SETTINGSUPDATESOURCEDATAOKSTART!");
        this.getHMIService().removePopup(-1427105536);
    }

    @Override
    protected void showPopupUpdateFailure() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGSUPDATESUMMARYFAILURE!");
        this.getHMIService().showPopup(-1561323264);
    }

    @Override
    public void showPopupUpdateSuccessful() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGSUPDATESUMMARYSUCCESSFUL!");
        this.getHMIService().showPopup(-1544546048);
    }

    @Override
    protected void showPopupUpdateInterrupted() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGSUPDATEINTERRUPTSD!");
        this.getHMIService().showPopup(-1578100480);
    }

    @Override
    protected void showPopupUpdateRestart() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGSUPDATESOURCEDATAOKSTART!");
        this.getHMIService().showPopup(-1427105536);
    }

    @Override
    public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
        this.getSwdlEnv().getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGSUPDATESOURCEDATAOKSTART!");
        this.getSwdlEnv().getHMIService().showPopup(-1427105536);
    }

    @Override
    public void custDownloadLeaveProgress(int n) {
        this.getSwdlEnv().getLogHMI().log(1078071040, "CustomerProgressManagerEvo: The event SMEvent.DL_CUST_LEAVE_PROGRESS is fired! (terminal=%1)", (long)n);
        this.getSwdlEnv().getHMIService().fireSMEvent(n, -437249792);
        this.getSwdlEnv().getLogHMI().log(1078071040, "CustomerProgressManagerEvo: removePartialPopup (terminal=%1, PARTIAL_POPUP_UPDATE_SOURCE_CONFIRMATION)", (long)n);
    }

    @Override
    public void showCustDownloadInfoPopup(int n) {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Show pop-up SETTINGS_POPUP_UPDATE_SOURCE_CONFIRMATION!");
        this.getHMIService().showPopup(-1427105536);
    }

    @Override
    protected void showPopupCompatibilityCheckFailure() {
        this.getLogHMI().log(1078071040, "CustomerProgressManagerEvo: Activate pop-up POPUP_SETTINGS_UPDATE_SOURCE_INCOMPATIBLE_DATA_ID!");
        this.getHMIService().showPopup(-1443882752);
    }
}

