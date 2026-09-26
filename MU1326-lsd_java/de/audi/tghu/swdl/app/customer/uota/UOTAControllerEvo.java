/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;

public final class UOTAControllerEvo
extends BaseUpdateOverTheAirController {
    public UOTAControllerEvo(SwdlEnv swdlEnv) {
        super(swdlEnv);
    }

    @Override
    protected void showServerErrorPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showServerErrorPopup(): showing POPUP_SETTINGS_POPUP_ONLINE_UPDATE_SERVER_FAILURE_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1326442240);
    }

    @Override
    protected void hideServerErrorPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].hideServerErrorPopup(): hide POPUP_SETTINGS_POPUP_ONLINE_UPDATE_SERVER_FAILURE_ID!");
        this.getSwdlEnv().getHMIService().removePopup(-1326442240);
    }

    @Override
    protected void showNoDataPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showNoDataPopup(): showing POPUP_SETTINGS_POPUP_ONLINE_UPDATE_NO_DATA_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1343219456);
    }

    @Override
    protected void showAccessFailurePopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showAccessFailurePopup(): showing POPUP_SETTINGS_POPUP_ONLINE_UPDATE_ACCESS_FAILURE_ID!");
    }

    @Override
    protected void showNewNaviUpdateAvailableWithLicensePopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showNewNaviUpdateAvailableWithLicensePopup(): showing POPUP_SETTINGS_POPUP_NAVI_NEW_DATA_AVAILABLE_LICENCE_AVAILABLE_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1510991616);
    }

    @Override
    protected void showNewNaviUpdateAvailableNoLicensePopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showNewNaviUpdateAvailableNoLicensePopup(): showing POPUP_SETTINGS_POPUP_NAVI_NEW_DATA_AVAILABLE_LICENCE_NOT_AVAILABLE_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1494214400);
    }

    @Override
    protected void showUpdateSystemProposalPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateSystemProposalPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1276110592);
    }

    @Override
    protected void showUpdateDestinationPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateDestinationPopup(): showing POPUP_SETTINGS_POPUP_NAVI_NEW_DATA_AVAILABLE_LICENCE_DESTINATION_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1259333376);
    }

    @Override
    protected void showUpdateDestinationConfirmationPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateDestinationPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL_DESTINATION_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1209001728);
    }

    @Override
    protected void showUotaSummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUotaSummaryPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_NAV_DB_SUMMARY_UOTA_SUCCESSFUL_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1242556160);
    }

    @Override
    protected void showUotaPPOISummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUotaPPOIPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_PPOI_SUMMARY_UOTA_SUCCESSFUL_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1225778944);
    }

    @Override
    protected void hideUotaPPOISummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].hideUotaPPOISummaryPopup(): removing POPUP_SETTINGS_POPUP_UPDATE_PPOI_SUMMARY_UOTA_SUCCESSFUL_ID!");
        this.getSwdlEnv().getHMIService().removePopup(-1225778944);
    }

    @Override
    protected void showSystemProposalDisclaimerPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showSystemProposalDisclaimerPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_SYSTEM_PROPOSAL_DISCLAIMER_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1292887808);
    }

    @Override
    protected void showGeneralUpdatesAvailablePopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showGeneralUpdatesAvailablePopup(): showing POPUP_SETTINGS_POPUP_GEN_NEW_DATA_AVAILABLE_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1460659968);
    }

    @Override
    protected void showDownloadErrorPopup(boolean bl) {
        if (bl) {
            this.getLogUota().log(1078071040, "[UOTAControllerEvo].showDownloadErrorPopup(): showing POPUP_SETTINGS_ONLINE_UPDATE_FAILURE_RETRY_POSSIBLE_ID!");
            this.getSwdlEnv().getHMIService().showPopup(-1410328320);
        } else {
            this.getLogUota().log(1078071040, "[UOTAControllerEvo].showDownloadErrorPopup(): showing POPUP_SETTINGS_ONLINE_UPDATE_FAILURE_ID!");
            this.getSwdlEnv().getHMIService().showPopup(-1393551104);
        }
    }

    @Override
    protected void showSourceConfirmationPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showSourceConfirmationPopup(): showing POPUP_SETTINGS_POPUP_UPDATE_SOURCE_CONFIRMATION_ID!");
        this.getSwdlEnv().getHMIService().showPopup(-1427105536);
    }

    @Override
    protected void hideSwdlSummaryPopups() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].hideSwdlSummaryPopups(): Removing all SWDL summary popups");
        this.getLogUota().log(-2137614336, "[UOTAControllerEvo].hideSwdlSummaryPopups(): hiding POPUP_SETTINGSUPDATESUMMARYFAILURE_ID!");
        this.getSwdlEnv().getHMIService().removePopup(-1561323264);
        this.getLogUota().log(-2137614336, "[UOTAControllerEvo].hideSwdlSummaryPopups(): hiding POPUP_SETTINGSUPDATESUMMARYSUCCESSFUL_ID!");
        this.getSwdlEnv().getHMIService().removePopup(-1544546048);
    }

    @Override
    public void popupHidden(int n) {
        this.getLogUota().log(14808325, "[UOTAControllerEvo].popupHidden(%1)", (long)n);
    }

    @Override
    public void popupRemoved(int n) {
        this.getLogUota().log(-2137614336, "[UOTAControllerEvo].popupRemoved(%1)", (long)n);
        switch (n) {
            case 1700005: 
            case 1700006: 
            case 1700019: 
            case 1700020: 
            case 1700023: {
                if (this.isPopupButtonPressed()) break;
                this.getLogUota().log(-2137614336, "[UOTAControllerEvo].popupRemoved(%1): leave pop-up without confiramtion, use default action -> Cancel.", (long)n);
                this.ignoreUpdatesAvailablePopup(true);
                break;
            }
            case 1700018: {
                if (this.isPopupButtonPressed()) break;
                this.getLogUota().log(-2137614336, "[UOTAControllerEvo].popupRemoved(%1): leave pop-up without confiramtion, use default action -> Cancel.", (long)n);
                if (this.isUotaDestinationSelectionActive() || this.isUotaSysProposalSelectionActive()) {
                    this.ignoreUpdatesAvailablePopup(true);
                    break;
                }
                this.ignoreUpdatesAvailablePopup(false);
                this.cleanupPackageHierarchy();
                this.resetUotaState();
                this.getSwdlEnv().getCustomerDLState().leaveCustomerUpdate();
                break;
            }
            case 1700016: {
                if (this.isPopupButtonPressed()) break;
                if (this.isDownloadActive() || this.isDownloadWaitForConnection()) {
                    this.getLogUota().log(-2137614336, "[UOTAControllerEvo].popupRemoved(%1): leave pop-up without confiramtion, use default action -> Wait.", (long)n);
                    this.setDownloadState(11);
                    break;
                }
                this.getLogUota().log(-2137614336, "[UOTAControllerEvo].popupRemoved(%1): leave pop-up without confiramtion, use default action -> Cancel.", (long)n);
                this.abortDownload();
                this.resetUotaState();
                this.getSwdlEnv().getCustomerDLState().leaveCustomerUpdate();
                break;
            }
            default: {
                this.getLogUota().log(14808325, "[UOTAControllerEvo].popupRemoved(%1): not UOTA pop-up", (long)n);
            }
        }
        this.setPopupButtonPressed(false);
    }

    @Override
    public void popupVisible(int n) {
        this.getLogUota().log(14808325, "[UOTAControllerEvo].popupVisible(%1)", (long)n);
    }
}

