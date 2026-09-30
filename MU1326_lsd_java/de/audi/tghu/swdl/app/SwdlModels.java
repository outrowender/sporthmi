/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.hmi.IHMIServiceApp;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.menu.MenuModelApp;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.ListModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.hmi.modelaccess.RangeModelApp;
import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.hmi.modelaccess.SpellerModelApp;
import de.audi.tghu.swdl.app.SwdlEnv;

public class SwdlModels {
    private final SwdlEnv swdlEnv;

    public SwdlModels(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
        this.initProgressRange();
    }

    private void initProgressRange() {
        this.getCustomerProgressRange().setLimits(0, 100, 1);
        this.getDlProgressRangeModel().setLimits(0, 100, 1);
        this.getSummaryDownloadAndInstallProgressRange().setLimits(0, 100, 1);
    }

    public ButtonModelApp getCustomerOnlineUpdateInstallConfirmButton() {
        return this.getHMIService().getButtonModel(0x19F191);
    }

    public ButtonModelApp getCustomerInitCustomerUpdateButton() {
        return this.getHMIService().getButtonModel(1700231);
    }

    public ChoiceModelApp getCustomerInitCustomerUpdateButtonChoice() {
        return this.getHMIService().getChoiceModel(1700374);
    }

    public ChoiceModelApp getCustomerProgressStateChoice() {
        return this.getHMIService().getChoiceModel(107);
    }

    public ChoiceModelApp getCustomerPreselectedSourceChoice() {
        return this.getHMIService().getChoiceModel(1700261);
    }

    public ChoiceModelApp getCustomerSelectionSourceChoice() {
        return this.getHMIService().getChoiceModel(1700259);
    }

    public ListModelApp getCustomerSourceMediaList() {
        return this.getHMIService().getListModel(1700260);
    }

    public ChoiceModelApp getCustomerReadingMetaInfoStateChoice() {
        return this.getHMIService().getChoiceModel(1700257);
    }

    public ButtonModelApp getCustomerStartDownloadButton() {
        return this.getHMIService().getButtonModel(1700262);
    }

    public LabelModelApp getCustomerErrorLabel() {
        return this.getHMIService().getLabelModel(1700230);
    }

    public LabelModelApp getCustomerUpdateNameLabel() {
        return this.getHMIService().getLabelModel(1700266);
    }

    public LabelModelApp getCustomerUpdateVersionLabel() {
        return this.getHMIService().getLabelModel(1700271);
    }

    public LabelModelApp getCustomerUpdateDeviceLabel() {
        return this.getHMIService().getLabelModel(1700268);
    }

    public LabelModelApp getCustomerCurrentVersionLabel() {
        return this.getHMIService().getLabelModel(1700226);
    }

    public LabelModelApp getCustomerNewVersionLabel() {
        return this.getHMIService().getLabelModel(1700235);
    }

    public LabelModelApp getCustomerSummaryVersionLabel() {
        return this.getHMIService().getLabelModel(1700265);
    }

    public LabelModelApp getCustomerSummaryStatusLabel() {
        return this.getHMIService().getLabelModel(1700264);
    }

    public ButtonModelApp getCustomerStartUpdateAgainButton() {
        return this.getHMIService().getButtonModel(1700263);
    }

    public ButtonModelApp getCustomerStartUpdateCancelButton() {
        return this.getHMIService().getButtonModel(1700285);
    }

    public ButtonModelApp getCustomerAbortDownloadButton() {
        return this.getHMIService().getButtonModel(1700225);
    }

    public ButtonModelApp getCustomerAbortSelectionMediaButton() {
        return this.getHMIService().getButtonModel(1700224);
    }

    public ButtonModelApp getCustomerProgressRetryReadMediumButton() {
        return this.getHMIService().getButtonModel(0x19F19F);
    }

    public ChoiceModelApp getCustomerNaviDbChoice() {
        return this.getHMIService().getChoiceModel(1700269);
    }

    public ChoiceModelApp getCustomerDownloadingStateChoice() {
        return this.getHMIService().getChoiceModel(1700229);
    }

    public RangeModelApp getCustomerProgressRange() {
        return this.getHMIService().getRangeModel(4034);
    }

    public RangeModelApp getSummaryDownloadAndInstallProgressRange() {
        return this.getHMIService().getRangeModel(4268);
    }

    public void updateCustomerProgress(int n) {
        this.getCustomerProgressRange().setValue(n);
        this.getSummaryDownloadAndInstallProgressRange().setValue(n);
    }

    public LabelModelApp getCustomerDisk1Label() {
        return this.getHMIService().getLabelModel(1700250);
    }

    public LabelModelApp getCustomerDisk2Label() {
        return this.getHMIService().getLabelModel(1700251);
    }

    public ButtonModelApp getCustomerInterruptContinueButton() {
        return this.getHMIService().getButtonModel(1700233);
    }

    public ButtonModelApp getCustomerInterruptAbortButton() {
        return this.getHMIService().getButtonModel(1700232);
    }

    public LabelModelApp getCustomerProgressInterruptedLabel() {
        return this.getHMIService().getLabelModel(1700253);
    }

    public ChoiceModelApp getCustomerUpdateAgainRequestChoice() {
        return this.getHMIService().getChoiceModel(1700267);
    }

    public LabelModelApp getCustomerSoftwareVersionLabel() {
        return this.getHMIService().getLabelModel(1100169);
    }

    public LabelModelApp getCustomerNavDatabaseVersionLevel() {
        return this.getHMIService().getLabelModel(1100168);
    }

    public LabelModelApp getCustomerProgressErrorLabel() {
        return this.getHMIService().getLabelModel(1700252);
    }

    public ButtonModelApp getCustomerProgressErrorAbortButton() {
        return this.getHMIService().getButtonModel(0x19F199);
    }

    public ButtonModelApp getCustomerProgressErrorRetryButton() {
        return this.getHMIService().getButtonModel(1700254);
    }

    public ButtonModelApp getResetDriverButton() {
        return this.getHMIService().getButtonModel(1700272);
    }

    public ChoiceModelApp getCustomerUpdateNewModelChoice() {
        return this.getHMIService().getChoiceModel(1700279);
    }

    public LabelModelApp getCustomerUpdateProcessTextLabel() {
        return this.getHMIService().getLabelModel(1700280);
    }

    public ButtonModelApp getCustomerSummarySuccessConfirmButton() {
        return this.getHMIService().getButtonModel(1700290);
    }

    public ChoiceModelApp getSelectionLayoutChoice() {
        return this.getHMIService().getChoiceModel(1700312);
    }

    public ChoiceModelApp getShowDowngradeWarningChoice() {
        return this.getHMIService().getChoiceModel(1700313);
    }

    public ButtonModelApp getSwdlDowngradeContinueButtonModel() {
        return this.getHMIService().getButtonModel(1700314);
    }

    private final IHMIServiceApp getHMIService() {
        return this.swdlEnv.getHMIService();
    }

    public ChoiceModelApp getCustDlDisabledChoice(int n) {
        return this.getHMIService().getChoiceModel(n, 390);
    }

    public ChoiceModelApp getSwdlInProgressChoice() {
        return this.getHMIService().getChoiceModel(392);
    }

    ChoiceModelApp getModuleSelect() {
        return this.getHMIService().getChoiceModel(1700096);
    }

    ChoiceModelApp getAppBlSelect() {
        return this.getHMIService().getChoiceModel(1700046);
    }

    public ChoiceModelApp getNaviUpdateRunning() {
        return this.getHMIService().getChoiceModel(238);
    }

    public ChoiceModelApp getStartDownloadDisabled() {
        return this.getHMIService().getChoiceModel(0, 219);
    }

    LabelModelApp getLameClientsLabel() {
        return this.getHMIService().getLabelModel(1700082);
    }

    ChoiceModelApp getDevicesReadyChoice() {
        return this.getHMIService().getChoiceModel(1700060);
    }

    public ChoiceModelApp getDSIisAvailableChoice() {
        return this.getHMIService().getChoiceModel(391);
    }

    public ChoiceModelApp getSwdlMapIntegrationInProgressChoice() {
        return this.getHMIService().getChoiceModel(4468);
    }

    ChoiceModelApp getRSESwdlJoinedChoice() {
        return this.getHMIService().getChoiceModel(1700042);
    }

    public ChoiceModelApp getSwdlDownloadStartedChoice() {
        return this.getHMIService().getChoiceModel(1700061);
    }

    public LabelModelApp getRebootCountdown() {
        return this.getHMIService().getLabelModel(1700124);
    }

    public ButtonModelApp getSelectAllButton() {
        return this.getHMIService().getButtonModel(1700221);
    }

    public ButtonModelApp getSelectNoneButton() {
        return this.getHMIService().getButtonModel(1700222);
    }

    public ChoiceModelApp getSelectAllSyncChoice() {
        return this.getHMIService().getChoiceModel(1700330);
    }

    public ChoiceModelApp getSelectNoneSyncChoice() {
        return this.getHMIService().getChoiceModel(1700331);
    }

    public ButtonModelApp getDeviceSelectButton() {
        return this.getHMIService().getButtonModel(1700057);
    }

    public ButtonModelApp getModuleSelectButton() {
        return this.getHMIService().getButtonModel(1700097);
    }

    public LabelModelApp getMessageLabel() {
        return this.getHMIService().getLabelModel(1700094);
    }

    public ChoiceModelApp getUserDefinedChoice() {
        return this.getHMIService().getChoiceModel(1700171);
    }

    public ButtonModelApp getIgnoreBusyDeviceButton() {
        return this.getHMIService().getButtonModel(1700067);
    }

    public SpellerModelApp getIpSpeller() {
        return this.getHMIService().getIPSpellerModel(1700081);
    }

    public SpellerModelApp getFsPathSpeller() {
        return this.getHMIService().getSpellerModel(1700107);
    }

    public LabelModelApp getSelectIpAddressLabel() {
        return this.getHMIService().getLabelModel(1700134);
    }

    public LabelModelApp getSelectNetworkPathLabel() {
        return this.getHMIService().getLabelModel(1700139);
    }

    public LabelModelApp getIncompDevLabel() {
        return this.getHMIService().getLabelModel(1700075);
    }

    public LabelModelApp getDeviceListLabel() {
        return this.getHMIService().getLabelModel(1700055);
    }

    public LabelModelApp getDeviceLabel() {
        return this.getHMIService().getLabelModel(1700052);
    }

    public LabelModelApp getModuleLabel() {
        return this.getHMIService().getLabelModel(1700095);
    }

    public LabelModelApp getFileDetailsLabel() {
        return this.getHMIService().getLabelModel(1700160);
    }

    public LabelModelApp getSelectedLanguageUpdateLabel() {
        return this.getHMIService().getLabelModel(1700144);
    }

    public LabelModelApp getUpdatedDeviceLabel() {
        return this.getHMIService().getLabelModel(1700170);
    }

    public ListModelApp getDeviceList() {
        return this.getHMIService().getListModel(1700133);
    }

    public ListModelApp getModuleList() {
        return this.getHMIService().getListModel(1700138);
    }

    public ListModelApp getFileList() {
        return this.getHMIService().getListModel(1700132);
    }

    public ListModelApp getLanguageList() {
        return this.getHMIService().getListModel(1700136);
    }

    public LabelModelApp getDeviceErrorsLabel() {
        return this.getHMIService().getLabelModel(1700054);
    }

    public ButtonModelApp getSelectLanguageButton() {
        return this.getHMIService().getButtonModel(1700135);
    }

    public ButtonModelApp getShowErrorsButton() {
        return this.getHMIService().getButtonModel(1700153);
    }

    public ChoiceModelApp getNoExclusiveBoloUpdateChoice() {
        return this.getHMIService().getChoiceModel(1700108);
    }

    public ButtonModelApp getCheckStartDownloadButton() {
        return this.getHMIService().getButtonModel(1700051);
    }

    public ChoiceModelApp getSummmaryOkChoice() {
        return this.getHMIService().getChoiceModel(1700161);
    }

    public ChoiceModelApp getDeviceStatusEnteredChoice() {
        return this.getHMIService().getChoiceModel(1700059);
    }

    public ListModelApp getHistoryList() {
        return this.getHMIService().getListModel(1700169);
    }

    public ListModelApp getUnusualEventList() {
        return this.getHMIService().getListModel(1700167);
    }

    public LabelModelApp getLogReleaseNameLabel() {
        return this.getHMIService().getLabelModel(1700087);
    }

    public LabelModelApp getHistoryGeneralInfoLabel() {
        return this.getHMIService().getLabelModel(1700086);
    }

    public LabelModelApp getHistorySignatureLabel() {
        return this.getHMIService().getLabelModel(1700329);
    }

    public LabelModelApp getHistoryUnusualEventLabel() {
        return this.getHMIService().getLabelModel(1700168);
    }

    public ButtonModelApp getDeviceSelectionButton() {
        return this.getHMIService().getButtonModel(1700083);
    }

    public ButtonModelApp getDeviceSummaryButton() {
        return this.getHMIService().getButtonModel(1700084);
    }

    public ButtonModelApp getGeneralInfoButton() {
        return this.getHMIService().getButtonModel(1700085);
    }

    public ButtonModelApp getUnusualEventsButton() {
        return this.getHMIService().getButtonModel(1700090);
    }

    public ListModelApp getSubUpdatesList() {
        return this.getHMIService().getListModel(1700088);
    }

    public ChoiceModelApp getLogSequentialStepCountChoice() {
        return this.getHMIService().getChoiceModel(1700089);
    }

    public LabelModelApp getProgressLabel() {
        return this.getHMIService().getLabelModel(1700120);
    }

    ListModelApp getIncompDevList() {
        return this.getHMIService().getListModel(1700074);
    }

    public ListModelApp getProgressList() {
        return this.getHMIService().getListModel(0x19F119);
    }

    public LabelModelApp getProgressDetailLabel() {
        return this.getHMIService().getLabelModel(1700122);
    }

    public LabelModelApp getLostDevicesLabel() {
        return this.getHMIService().getLabelModel(1700174);
    }

    public LabelModelApp getInterruptCountdownLabel() {
        return this.getHMIService().getLabelModel(1700080);
    }

    public ButtonModelApp getSummaryRetryButton() {
        return this.getHMIService().getButtonModel(1700162);
    }

    public ButtonModelApp getSummaryContinueButton() {
        return this.getHMIService().getButtonModel(1700159);
    }

    public ButtonModelApp getConfirmSummaryChangedButton() {
        return this.getHMIService().getButtonModel(1700158);
    }

    public ButtonModelApp getRsuUserAbortButton() {
        return this.getHMIService().getButtonModel(1700131);
    }

    public ChoiceModelApp getMediumChoice() {
        return this.getHMIService().getChoiceModel(1700311);
    }

    public ListModelApp getMediaList() {
        return this.getHMIService().getListModel(1700145);
    }

    public ChoiceModelApp getSelectMediumStateChoice() {
        return this.getHMIService().getChoiceModel(1700137);
    }

    public LabelModelApp getReleaseLabel() {
        return this.getHMIService().getLabelModel(1700125);
    }

    public ListModelApp getReleaseList() {
        return this.getHMIService().getListModel(1700140);
    }

    public ChoiceModelApp getSelectReleaseStateChoice() {
        return this.getHMIService().getChoiceModel(1700141);
    }

    public LabelModelApp getVersionUploadResultLabel() {
        return this.getHMIService().getLabelModel(1700173);
    }

    public ButtonModelApp getStatusDeviceSelectButton() {
        return this.getHMIService().getButtonModel(1700157);
    }

    public ButtonModelApp getRestartVersionComparisonButton() {
        return this.getHMIService().getButtonModel(1700172);
    }

    public ButtonModelApp getAbortVersionComparisonButton() {
        return this.getHMIService().getButtonModel(1700156);
    }

    public ButtonModelApp getAbortReadMetaInfoButton() {
        return this.getHMIService().getButtonModel(1700044);
    }

    public ButtonModelApp getAbortReadReleaseButton() {
        return this.getHMIService().getButtonModel(1700045);
    }

    public ButtonModelApp getSelectUpdateStandardButton() {
        return this.getHMIService().getButtonModel(1700142);
    }

    public ButtonModelApp getSelectUpdateUserDefinedButton() {
        return this.getHMIService().getButtonModel(1700143);
    }

    public ButtonModelApp getStartDownloadButton() {
        return this.getHMIService().getButtonModel(1700155);
    }

    public ButtonModelApp getAbortDownloadButton() {
        return this.getHMIService().getButtonModel(1700043);
    }

    public ChoiceModelApp getIncompatibleUpdatesChoice() {
        return this.getHMIService().getChoiceModel(1700076);
    }

    public LabelModelApp getInconsistentUpdateErrorLabel() {
        return this.getHMIService().getLabelModel(1700077);
    }

    public ButtonModelApp getRSUSelectDownloadMediaSelectButton() {
        return this.getHMIService().getButtonModel(1700129);
    }

    public ButtonModelApp getRSUSelectDownloadMediaAbortButton() {
        return this.getHMIService().getButtonModel(0x19F11F);
    }

    public ButtonModelApp getMUAbortMediaSelectAtRSU() {
        return this.getHMIService().getButtonModel(1700130);
    }

    public ChoiceModelApp getNetworkMediumAvailableChoice() {
        return this.getHMIService().getChoiceModel(1700106);
    }

    public ChoiceModelApp getPopupActionChoice() {
        return this.getHMIService().getChoiceModel(1700109);
    }

    public ChoiceModelApp getPopupSkipDeviceChoice() {
        return this.getHMIService().getChoiceModel(1700117);
    }

    public ChoiceModelApp getPopupInterruptChoice() {
        return this.getHMIService().getChoiceModel(1700112);
    }

    public ChoiceModelApp getPopupRetryChoice() {
        return this.getHMIService().getChoiceModel(1700114);
    }

    public ChoiceModelApp getPopupCancelChoice() {
        return this.getHMIService().getChoiceModel(1700110);
    }

    public ChoiceModelApp getPopupContinueChoice() {
        return this.getHMIService().getChoiceModel(1700111);
    }

    public ChoiceModelApp getPopupOkChoice() {
        return this.getHMIService().getChoiceModel(0x19F111);
    }

    public ChoiceModelApp getPopupSelectChoice() {
        return this.getHMIService().getChoiceModel(1700115);
    }

    public LabelModelApp getPopupSubtitle() {
        return this.getHMIService().getLabelModel(1700118);
    }

    public LabelModelApp getPopupTextLabel() {
        return this.getHMIService().getLabelModel(1700119);
    }

    LabelModelApp getRestartAppLabel() {
        return this.getHMIService().getLabelModel(1700126);
    }

    public BaseListModelApp getDevicesListModel() {
        return this.getHMIService().getBaseListModel(1700273);
    }

    public ChoiceModelApp getOnlineUpdateStateChoiceModel() {
        return this.getHMIService().getChoiceModel(3849);
    }

    public ChoiceModelApp getOnlineUpdateAvailableChoiceModel() {
        return this.getHMIService().getChoiceModel(1700238);
    }

    public ChoiceModelApp getStartDownloadButtonStateChoiceModel() {
        return this.getHMIService().getChoiceModel(1700278);
    }

    public BaseListModelApp getPackagesListModel() {
        return this.getHMIService().getBaseListModel(1700242);
    }

    public ButtonModelApp getStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700247);
    }

    public ButtonModelApp getStartSysProposalDownloadButton() {
        return this.getHMIService().getButtonModel(0x19F1F9);
    }

    public ButtonModelApp getAbortDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700237);
    }

    public MetricsModelApp getConfirmDlSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(1700275);
    }

    public MetricsModelApp getDestinationPkgSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(1700381);
    }

    public ButtonModelApp getConfirmDlStartButtonModel() {
        return this.getHMIService().getButtonModel(1700276);
    }

    public ButtonModelApp getConfirmDlAbortButtonModel() {
        return this.getHMIService().getButtonModel(1700274);
    }

    public RangeModelApp getDlProgressRangeModel() {
        return this.getHMIService().getRangeModel(1700243);
    }

    public void updateUotaDownloadProgress(int n) {
        this.getDlProgressRangeModel().setValue(n);
        this.getSummaryDownloadAndInstallProgressRange().setValue(n);
    }

    public LabelModelApp getDlProgressLabelModel() {
        return this.getHMIService().getLabelModel(1700244);
    }

    public ChoiceModelApp getDlProgressTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(1700327);
    }

    public MetricsModelApp getDlProgressDlSpeedMetricsModel() {
        return this.getHMIService().getMetricsModel(0x19F1F1);
    }

    public ButtonModelApp getDlProgressAbortDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700277);
    }

    public ButtonModelApp getAbortDlConfirmButtonModel() {
        return this.getHMIService().getButtonModel(1700282);
    }

    public ButtonModelApp getAbortDlCancelButtonModel() {
        return this.getHMIService().getButtonModel(1700283);
    }

    public ChoiceModelApp getDlProgressErrorShowPopUpChoiceModel() {
        return this.getHMIService().getChoiceModel(1700291);
    }

    public ButtonModelApp getDlProgressErrorRetryButtonModel() {
        return this.getHMIService().getButtonModel(1700288);
    }

    public ButtonModelApp getDlProgressErrorAbortButtonModel() {
        return this.getHMIService().getButtonModel(1700287);
    }

    public BaseListModelApp getNaviCountriesListModel() {
        return this.getHMIService().getBaseListModel(1700301);
    }

    public MenuModelApp getNaviCountriesMenuModel() {
        return this.getHMIService().getMenuModel(1700336);
    }

    public ChoiceModelApp getNaviToggleCountriesChoiceModel() {
        return this.getHMIService().getChoiceModel(1700308);
    }

    public ResourceLocatorModelApp getNaviMapPreviewResourceLocatorModel() {
        return this.getHMIService().getResourceLocatorModel(1700334);
    }

    public BaseListModelApp getSysProposalListModel() {
        return this.getHMIService().getBaseListModel(1700346);
    }

    public BaseListModelApp getNaviRegionsListModel() {
        return this.getHMIService().getBaseListModel(1700306);
    }

    public MenuModelApp getNaviRegionsMenuModel() {
        return this.getHMIService().getMenuModel(1700335);
    }

    public ChoiceModelApp getNaviToggleRegionsChoiceModel() {
        return this.getHMIService().getChoiceModel(1700309);
    }

    public LabelModelApp getSelectedCountryLabelModel() {
        return this.getHMIService().getLabelModel(1700303);
    }

    public ButtonModelApp getNaviPopupLicenseDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700295);
    }

    public ButtonModelApp getSysProposalPopupStartDisclaimerButtonModel() {
        return this.getHMIService().getButtonModel(0x19F1F9);
    }

    public ButtonModelApp getSysProposalPopupCancelButtonModel() {
        return this.getHMIService().getButtonModel(1700349);
    }

    public ButtonModelApp getSysProposalDisclaimerPopupStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700344);
    }

    public ButtonModelApp getSysProposalDisclaimerPopupCancelButtonModel() {
        return this.getHMIService().getButtonModel(1700350);
    }

    public ButtonModelApp getNaviPopupLicenseRemindLaterButtonModel() {
        return this.getHMIService().getButtonModel(1700341);
    }

    public ButtonModelApp getNaviPopupLicenseIgnoreButtonModel() {
        return this.getHMIService().getButtonModel(1700340);
    }

    public LabelModelApp getNaviPopupLicenseNewVersionLabelModel() {
        return this.getHMIService().getLabelModel(1700296);
    }

    public ButtonModelApp getNaviPopupNoLicenseOkButtonModel() {
        return this.getHMIService().getButtonModel(1700300);
    }

    public LabelModelApp getNaviPopupNoLicenseNewVersionLabelModel() {
        return this.getHMIService().getLabelModel(1700299);
    }

    public ButtonModelApp getGenUpdPopupDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700324);
    }

    public ButtonModelApp getGenUpdPopupRemindLaterButtonModel() {
        return this.getHMIService().getButtonModel(1700339);
    }

    public ButtonModelApp getGenUpdPopupIgnoreButtonModel() {
        return this.getHMIService().getButtonModel(1700338);
    }

    public MetricsModelApp getRequiredPackageSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(1700347);
    }

    public ChoiceModelApp getRequiredPackagesCheckboxChoiceModel() {
        return this.getHMIService().getChoiceModel(1700384);
    }

    public ButtonModelApp getMoreCountriesButtonModel() {
        return this.getHMIService().getButtonModel(1700358);
    }

    public LabelModelApp getCurrentDownloadPackageLabelModel() {
        return this.getHMIService().getLabelModel(1700359);
    }

    public LabelModelApp getTotalDownloadPackagesLabelModel() {
        return this.getHMIService().getLabelModel(1700360);
    }

    public LabelModelApp getUotaDestinationComponentLabelModel() {
        return this.getHMIService().getLabelModel(1700356);
    }

    public ChoiceModelApp isSystemPackageSelectedChoiceModel() {
        return this.getHMIService().getChoiceModel(1700364);
    }

    public ChoiceModelApp getCustomerDLProgressTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(1700367);
    }

    public LabelModelApp getCustomerUpdateProgressTimeoutLabelModel() {
        return this.getHMIService().getLabelModel(1700369);
    }

    public ChoiceModelApp getCustomerUpdateProgressTimeoutChoiceModel() {
        return this.getHMIService().getChoiceModel(1700368);
    }

    public LabelModelApp getUotaSummaryCountriesLabelModel() {
        return this.getHMIService().getLabelModel(1700365);
    }

    public LabelModelApp getUotaSummaryComponentsLabelModel() {
        return this.getHMIService().getLabelModel(1700385);
    }

    public LabelModelApp getUotaSummaryComponentsVersionLabelModel() {
        return this.getHMIService().getLabelModel(1700235);
    }

    public ButtonModelApp getUotaDestinationSwitchToUotaButtonModel() {
        return this.getHMIService().getButtonModel(1700372);
    }

    public ButtonModelApp getUotaDestinationStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(1700373);
    }

    public ChoiceModelApp getLeaveCustomerUpdateChoiceModel() {
        return this.getHMIService().getChoiceModel(1700380);
    }

    public ChoiceModelApp getUotaDisclaimerTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(1700382);
    }

    public ButtonModelApp getUotaDisclaimerBackButton() {
        return this.getHMIService().getButtonModel(1700383);
    }

    public ChoiceModelApp getCustomerOrOnlineChoiceModel() {
        return this.getHMIService().getChoiceModel(1700386);
    }

    public ChoiceModelApp getUotaExcludeNavdataChoiceModel() {
        return this.getHMIService().getChoiceModel(1700387);
    }

    public ChoiceModelApp getNaviUpdateLicensedModel() {
        return this.getHMIService().getChoiceModel(4657);
    }

    public LabelModelApp getBoardBookVersionInfoLabelModel() {
        return this.getHMIService().getLabelModel(3847);
    }

    public LabelModelApp getPhoneDriverVersionInfoLabelModel() {
        return this.getHMIService().getLabelModel(3852);
    }
}

