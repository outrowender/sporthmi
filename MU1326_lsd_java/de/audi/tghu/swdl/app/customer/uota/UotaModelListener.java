/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$1;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$10;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$11;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$12;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$13;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$14;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$15;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$16;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$17;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$18;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$19;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$2;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$20;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$21;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$22;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$23;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$24;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$25;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$26;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$27;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$28;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$29;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$3;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$30;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$4;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$5;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$6;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$7;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$8;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener$9;

class UotaModelListener {
    private final BaseUpdateOverTheAirController uotaController;

    UotaModelListener(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.uotaController = baseUpdateOverTheAirController;
    }

    void registerModelListeners() {
        this.getLogUota().log(1078071040, "[UotaModelListener].registerModelListeners(): Registering model listeners");
        this.registerPkgSelectionModelListeners();
        this.registerCountrySelectionModelListeners();
        this.registerCountryRegionsSelectionModelListeners();
        this.registerDownloadConfirmationMoldelListeners();
        this.registerDownloadProgressModelListerns();
        this.registerDownloadProgressAbortModelListeners();
        this.registerDownloadErrorPopupsModelListeners();
        this.registerNewNaviUpdateAvailablePopupModelListeners();
        this.registerSysProposalPopupModelListeners();
        this.registerNewNaviUpdateNoLicensePopupModelListeners();
        this.registerSysProposalPopupSelectionModelListener();
        this.registerSysProposalDisclaimerPopupModelListener();
        this.registerMoreCountriesButtonListener();
        this.registerCancelOnlineUpdateButtonListener();
        this.registerWaitOnlineUpdateServiceButtonListener();
        this.registerNoOnlineDataConfirmButtonListener();
        this.registerPPOISummaryConfirmListener();
        this.registerDestinationPopupListener();
    }

    private void registerPkgSelectionModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerPkgSelectionModelListeners(): Registering model listeners for package selection screen");
        this.getSwdlModels().getStartDownloadButtonModel().setButtonListener(new UotaModelListener$1(this));
        this.getSwdlModels().getAbortDownloadButtonModel().setButtonListener(new UotaModelListener$2(this));
        this.getSwdlModels().getPackagesListModel().setListener(new UotaModelListener$3(this));
    }

    private void registerCountrySelectionModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerCountrySelectionModelListeners(): Registering model listeners for country selection screen");
        this.getSwdlModels().getNaviCountriesListModel().setListener(new UotaModelListener$4(this));
        this.getSwdlModels().getNaviToggleCountriesChoiceModel().setChoiceListener(new UotaModelListener$5(this));
    }

    private void registerSysProposalPopupSelectionModelListener() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerSysProposalPopupSelectionModelListener(): Registering model listeners for system proposal pop-up");
        this.getSwdlModels().getSysProposalListModel().setListener(new UotaModelListener$6(this));
    }

    private void registerCountryRegionsSelectionModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerCountryRegionsSelectionModelListeners(): Registering model listeners for region selection screen");
        this.getSwdlModels().getNaviRegionsListModel().setListener(new UotaModelListener$7(this));
        this.getSwdlModels().getNaviToggleRegionsChoiceModel().setChoiceListener(new UotaModelListener$8(this));
    }

    private void registerDownloadConfirmationMoldelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerDownloadConfirmationMoldelListeners(): Registering model listeners for download confirmation screen");
        this.getSwdlModels().getConfirmDlStartButtonModel().setButtonListener(new UotaModelListener$9(this));
        this.getSwdlModels().getConfirmDlAbortButtonModel().setButtonListener(new UotaModelListener$10(this));
    }

    private void registerDownloadProgressModelListerns() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerDownloadProgressModelListerns(): Registering model listeners for download progress screen");
        this.getSwdlModels().getDlProgressAbortDownloadButtonModel().setButtonListener(new UotaModelListener$11(this));
    }

    private void registerDownloadProgressAbortModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerDownloadProgressAbortModelListeners(): Registering model listeners for download progress abort screen");
        this.getSwdlModels().getAbortDlConfirmButtonModel().setButtonListener(new UotaModelListener$12(this));
        this.getSwdlModels().getAbortDlCancelButtonModel().setButtonListener(new UotaModelListener$13(this));
    }

    private void registerDownloadErrorPopupsModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerDownloadErrorPopupsModelListeners(): Registering model listeners for download error pop-ups");
        this.getSwdlModels().getDlProgressErrorRetryButtonModel().setButtonListener(new UotaModelListener$14(this));
        this.getSwdlModels().getDlProgressErrorAbortButtonModel().setButtonListener(new UotaModelListener$15(this));
    }

    private void registerSysProposalDisclaimerPopupModelListener() {
        this.getSwdlModels().getSysProposalDisclaimerPopupStartDownloadButtonModel().setButtonListener(new UotaModelListener$16(this));
        this.getSwdlModels().getSysProposalDisclaimerPopupCancelButtonModel().setButtonListener(new UotaModelListener$17(this));
        this.getSwdlModels().getUotaDisclaimerBackButton().setButtonListener(new UotaModelListener$18(this));
    }

    private void registerSysProposalPopupModelListeners() {
        this.getSwdlModels().getSysProposalPopupStartDisclaimerButtonModel().setButtonListener(new UotaModelListener$19(this));
        this.getSwdlModels().getSysProposalPopupCancelButtonModel().setButtonListener(new UotaModelListener$20(this));
    }

    private void registerMoreCountriesButtonListener() {
        this.getSwdlModels().getMoreCountriesButtonModel().setButtonListener(new UotaModelListener$21(this));
    }

    private void registerNewNaviUpdateAvailablePopupModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerNewNaviUpdatePopupModelListeners(): Registering model listeners for new navi update pop-ups");
        this.getSwdlModels().getNaviPopupLicenseDownloadButtonModel().setButtonListener(new UotaModelListener$22(this));
        this.getSwdlModels().getNaviPopupLicenseIgnoreButtonModel().setButtonListener(new UotaModelListener$23(this));
    }

    private void registerNewNaviUpdateNoLicensePopupModelListeners() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerNewNaviUpdateNoLicensePopupModelListeners(): Registering model listeners for new navi update pop-ups (no license)");
        this.getSwdlModels().getNaviPopupNoLicenseOkButtonModel().setButtonListener(new UotaModelListener$24(this));
    }

    private void registerCancelOnlineUpdateButtonListener() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerCancelOnlineUpdateButtonListener()");
        ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(-1074718464);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new UotaModelListener$25(this, buttonModelApp));
        }
    }

    private void registerNoOnlineDataConfirmButtonListener() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerNoOnlineDataConfirmButtonListener()");
        ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(250747136);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new UotaModelListener$26(this, buttonModelApp));
        }
    }

    private void registerWaitOnlineUpdateServiceButtonListener() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerWaitOnlineUpdateServiceButtonListener()");
        ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(166861056);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new UotaModelListener$27(this, buttonModelApp));
        }
    }

    private void registerPPOISummaryConfirmListener() {
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerPPOISummaryConfirmButtonListener()");
        ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(317856000);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new UotaModelListener$28(this, buttonModelApp));
        }
    }

    private void registerDestinationPopupListener() {
        ButtonModelApp buttonModelApp;
        this.getLogUota().log(-2137614336, "[UotaModelListener].registerDestinationPopupListener()");
        ButtonModelApp buttonModelApp2 = this.getSwdlModels().getUotaDestinationSwitchToUotaButtonModel();
        if (buttonModelApp2 != null) {
            buttonModelApp2.setButtonListener(new UotaModelListener$29(this, buttonModelApp2));
        }
        if ((buttonModelApp = this.getSwdlModels().getUotaDestinationStartDownloadButtonModel()) != null) {
            buttonModelApp.setButtonListener(new UotaModelListener$30(this, buttonModelApp));
        }
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.uotaController.getLogUota();
    }

    private SwdlModels getSwdlModels() {
        return this.uotaController.getSwdlModels();
    }

    static /* synthetic */ LogChannel access$000(UotaModelListener uotaModelListener) {
        return uotaModelListener.getLogUota();
    }

    static /* synthetic */ BaseUpdateOverTheAirController access$100(UotaModelListener uotaModelListener) {
        return uotaModelListener.getUotaController();
    }

    static /* synthetic */ SwdlModels access$200(UotaModelListener uotaModelListener) {
        return uotaModelListener.getSwdlModels();
    }
}

