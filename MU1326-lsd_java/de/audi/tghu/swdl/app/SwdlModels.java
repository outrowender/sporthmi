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
        return this.getHMIService().getButtonModel(-1846470400);
    }

    public ButtonModelApp getCustomerInitCustomerUpdateButton() {
        return this.getHMIService().getButtonModel(-2014242560);
    }

    public ChoiceModelApp getCustomerInitCustomerUpdateButtonChoice() {
        return this.getHMIService().getChoiceModel(384964864);
    }

    public ChoiceModelApp getCustomerProgressStateChoice() {
        return this.getHMIService().getChoiceModel(107);
    }

    public ChoiceModelApp getCustomerPreselectedSourceChoice() {
        return this.getHMIService().getChoiceModel(-1510926080);
    }

    public ChoiceModelApp getCustomerSelectionSourceChoice() {
        return this.getHMIService().getChoiceModel(-1544480512);
    }

    public ListModelApp getCustomerSourceMediaList() {
        return this.getHMIService().getListModel(-1527703296);
    }

    public ChoiceModelApp getCustomerReadingMetaInfoStateChoice() {
        return this.getHMIService().getChoiceModel(-1578034944);
    }

    public ButtonModelApp getCustomerStartDownloadButton() {
        return this.getHMIService().getButtonModel(-1494148864);
    }

    public LabelModelApp getCustomerErrorLabel() {
        return this.getHMIService().getLabelModel(-2031019776);
    }

    public LabelModelApp getCustomerUpdateNameLabel() {
        return this.getHMIService().getLabelModel(-1427040000);
    }

    public LabelModelApp getCustomerUpdateVersionLabel() {
        return this.getHMIService().getLabelModel(-1343153920);
    }

    public LabelModelApp getCustomerUpdateDeviceLabel() {
        return this.getHMIService().getLabelModel(-1393485568);
    }

    public LabelModelApp getCustomerCurrentVersionLabel() {
        return this.getHMIService().getLabelModel(-2098128640);
    }

    public LabelModelApp getCustomerNewVersionLabel() {
        return this.getHMIService().getLabelModel(-1947133696);
    }

    public LabelModelApp getCustomerSummaryVersionLabel() {
        return this.getHMIService().getLabelModel(-1443817216);
    }

    public LabelModelApp getCustomerSummaryStatusLabel() {
        return this.getHMIService().getLabelModel(-1460594432);
    }

    public ButtonModelApp getCustomerStartUpdateAgainButton() {
        return this.getHMIService().getButtonModel(-1477371648);
    }

    public ButtonModelApp getCustomerStartUpdateCancelButton() {
        return this.getHMIService().getButtonModel(-1108272896);
    }

    public ButtonModelApp getCustomerAbortDownloadButton() {
        return this.getHMIService().getButtonModel(-2114905856);
    }

    public ButtonModelApp getCustomerAbortSelectionMediaButton() {
        return this.getHMIService().getButtonModel(-2131683072);
    }

    public ButtonModelApp getCustomerProgressRetryReadMediumButton() {
        return this.getHMIService().getButtonModel(-1611589376);
    }

    public ChoiceModelApp getCustomerNaviDbChoice() {
        return this.getHMIService().getChoiceModel(-1376708352);
    }

    public ChoiceModelApp getCustomerDownloadingStateChoice() {
        return this.getHMIService().getChoiceModel(-2047796992);
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
        return this.getHMIService().getLabelModel(-1695475456);
    }

    public LabelModelApp getCustomerDisk2Label() {
        return this.getHMIService().getLabelModel(-1678698240);
    }

    public ButtonModelApp getCustomerInterruptContinueButton() {
        return this.getHMIService().getButtonModel(-1980688128);
    }

    public ButtonModelApp getCustomerInterruptAbortButton() {
        return this.getHMIService().getButtonModel(-1997465344);
    }

    public LabelModelApp getCustomerProgressInterruptedLabel() {
        return this.getHMIService().getLabelModel(-1645143808);
    }

    public ChoiceModelApp getCustomerUpdateAgainRequestChoice() {
        return this.getHMIService().getChoiceModel(-1410262784);
    }

    public LabelModelApp getCustomerSoftwareVersionLabel() {
        return this.getHMIService().getLabelModel(-1983311872);
    }

    public LabelModelApp getCustomerNavDatabaseVersionLevel() {
        return this.getHMIService().getLabelModel(-2000089088);
    }

    public LabelModelApp getCustomerProgressErrorLabel() {
        return this.getHMIService().getLabelModel(-1661921024);
    }

    public ButtonModelApp getCustomerProgressErrorAbortButton() {
        return this.getHMIService().getButtonModel(-1712252672);
    }

    public ButtonModelApp getCustomerProgressErrorRetryButton() {
        return this.getHMIService().getButtonModel(-1628366592);
    }

    public ButtonModelApp getResetDriverButton() {
        return this.getHMIService().getButtonModel(-1326376704);
    }

    public ChoiceModelApp getCustomerUpdateNewModelChoice() {
        return this.getHMIService().getChoiceModel(-1208936192);
    }

    public LabelModelApp getCustomerUpdateProcessTextLabel() {
        return this.getHMIService().getLabelModel(-1192158976);
    }

    public ButtonModelApp getCustomerSummarySuccessConfirmButton() {
        return this.getHMIService().getButtonModel(-1024386816);
    }

    public ChoiceModelApp getSelectionLayoutChoice() {
        return this.getHMIService().getChoiceModel(-655288064);
    }

    public ChoiceModelApp getShowDowngradeWarningChoice() {
        return this.getHMIService().getChoiceModel(-638510848);
    }

    public ButtonModelApp getSwdlDowngradeContinueButtonModel() {
        return this.getHMIService().getButtonModel(-621733632);
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
        return this.getHMIService().getChoiceModel(15800576);
    }

    ChoiceModelApp getAppBlSelect() {
        return this.getHMIService().getChoiceModel(-823125760);
    }

    public ChoiceModelApp getNaviUpdateRunning() {
        return this.getHMIService().getChoiceModel(238);
    }

    public ChoiceModelApp getStartDownloadDisabled() {
        return this.getHMIService().getChoiceModel(0, 219);
    }

    LabelModelApp getLameClientsLabel() {
        return this.getHMIService().getLabelModel(-219145984);
    }

    ChoiceModelApp getDevicesReadyChoice() {
        return this.getHMIService().getChoiceModel(-588244736);
    }

    public ChoiceModelApp getDSIisAvailableChoice() {
        return this.getHMIService().getChoiceModel(391);
    }

    public ChoiceModelApp getSwdlMapIntegrationInProgressChoice() {
        return this.getHMIService().getChoiceModel(4468);
    }

    ChoiceModelApp getRSESwdlJoinedChoice() {
        return this.getHMIService().getChoiceModel(-890234624);
    }

    public ChoiceModelApp getSwdlDownloadStartedChoice() {
        return this.getHMIService().getChoiceModel(-571467520);
    }

    public LabelModelApp getRebootCountdown() {
        return this.getHMIService().getLabelModel(485562624);
    }

    public ButtonModelApp getSelectAllButton() {
        return this.getHMIService().getButtonModel(2112952576);
    }

    public ButtonModelApp getSelectNoneButton() {
        return this.getHMIService().getButtonModel(2129729792);
    }

    public ChoiceModelApp getSelectAllSyncChoice() {
        return this.getHMIService().getChoiceModel(-353298176);
    }

    public ChoiceModelApp getSelectNoneSyncChoice() {
        return this.getHMIService().getChoiceModel(-336520960);
    }

    public ButtonModelApp getDeviceSelectButton() {
        return this.getHMIService().getButtonModel(-638576384);
    }

    public ButtonModelApp getModuleSelectButton() {
        return this.getHMIService().getButtonModel(32577792);
    }

    public LabelModelApp getMessageLabel() {
        return this.getHMIService().getLabelModel(-17819392);
    }

    public ChoiceModelApp getUserDefinedChoice() {
        return this.getHMIService().getChoiceModel(1274091776);
    }

    public ButtonModelApp getIgnoreBusyDeviceButton() {
        return this.getHMIService().getButtonModel(-470804224);
    }

    public SpellerModelApp getIpSpeller() {
        return this.getHMIService().getIPSpellerModel(-235923200);
    }

    public SpellerModelApp getFsPathSpeller() {
        return this.getHMIService().getSpellerModel(200349952);
    }

    public LabelModelApp getSelectIpAddressLabel() {
        return this.getHMIService().getLabelModel(653334784);
    }

    public LabelModelApp getSelectNetworkPathLabel() {
        return this.getHMIService().getLabelModel(737220864);
    }

    public LabelModelApp getIncompDevLabel() {
        return this.getHMIService().getLabelModel(-336586496);
    }

    public LabelModelApp getDeviceListLabel() {
        return this.getHMIService().getLabelModel(-672130816);
    }

    public LabelModelApp getDeviceLabel() {
        return this.getHMIService().getLabelModel(-722462464);
    }

    public LabelModelApp getModuleLabel() {
        return this.getHMIService().getLabelModel(-1042176);
    }

    public LabelModelApp getFileDetailsLabel() {
        return this.getHMIService().getLabelModel(1089542400);
    }

    public LabelModelApp getSelectedLanguageUpdateLabel() {
        return this.getHMIService().getLabelModel(821106944);
    }

    public LabelModelApp getUpdatedDeviceLabel() {
        return this.getHMIService().getLabelModel(1257314560);
    }

    public ListModelApp getDeviceList() {
        return this.getHMIService().getListModel(636557568);
    }

    public ListModelApp getModuleList() {
        return this.getHMIService().getListModel(720443648);
    }

    public ListModelApp getFileList() {
        return this.getHMIService().getListModel(619780352);
    }

    public ListModelApp getLanguageList() {
        return this.getHMIService().getListModel(686889216);
    }

    public LabelModelApp getDeviceErrorsLabel() {
        return this.getHMIService().getLabelModel(-688908032);
    }

    public ButtonModelApp getSelectLanguageButton() {
        return this.getHMIService().getButtonModel(670112000);
    }

    public ButtonModelApp getShowErrorsButton() {
        return this.getHMIService().getButtonModel(972101888);
    }

    public ChoiceModelApp getNoExclusiveBoloUpdateChoice() {
        return this.getHMIService().getChoiceModel(217127168);
    }

    public ButtonModelApp getCheckStartDownloadButton() {
        return this.getHMIService().getButtonModel(-739239680);
    }

    public ChoiceModelApp getSummmaryOkChoice() {
        return this.getHMIService().getChoiceModel(1106319616);
    }

    public ChoiceModelApp getDeviceStatusEnteredChoice() {
        return this.getHMIService().getChoiceModel(-605021952);
    }

    public ListModelApp getHistoryList() {
        return this.getHMIService().getListModel(1240537344);
    }

    public ListModelApp getUnusualEventList() {
        return this.getHMIService().getListModel(1206982912);
    }

    public LabelModelApp getLogReleaseNameLabel() {
        return this.getHMIService().getLabelModel(-135259904);
    }

    public LabelModelApp getHistoryGeneralInfoLabel() {
        return this.getHMIService().getLabelModel(-152037120);
    }

    public LabelModelApp getHistorySignatureLabel() {
        return this.getHMIService().getLabelModel(-370075392);
    }

    public LabelModelApp getHistoryUnusualEventLabel() {
        return this.getHMIService().getLabelModel(1223760128);
    }

    public ButtonModelApp getDeviceSelectionButton() {
        return this.getHMIService().getButtonModel(-202368768);
    }

    public ButtonModelApp getDeviceSummaryButton() {
        return this.getHMIService().getButtonModel(-185591552);
    }

    public ButtonModelApp getGeneralInfoButton() {
        return this.getHMIService().getButtonModel(-168814336);
    }

    public ButtonModelApp getUnusualEventsButton() {
        return this.getHMIService().getButtonModel(-84928256);
    }

    public ListModelApp getSubUpdatesList() {
        return this.getHMIService().getListModel(-118482688);
    }

    public ChoiceModelApp getLogSequentialStepCountChoice() {
        return this.getHMIService().getChoiceModel(-101705472);
    }

    public LabelModelApp getProgressLabel() {
        return this.getHMIService().getLabelModel(418453760);
    }

    ListModelApp getIncompDevList() {
        return this.getHMIService().getListModel(-353363712);
    }

    public ListModelApp getProgressList() {
        return this.getHMIService().getListModel(435230976);
    }

    public LabelModelApp getProgressDetailLabel() {
        return this.getHMIService().getLabelModel(452008192);
    }

    public LabelModelApp getLostDevicesLabel() {
        return this.getHMIService().getLabelModel(1324423424);
    }

    public LabelModelApp getInterruptCountdownLabel() {
        return this.getHMIService().getLabelModel(-252700416);
    }

    public ButtonModelApp getSummaryRetryButton() {
        return this.getHMIService().getButtonModel(1123096832);
    }

    public ButtonModelApp getSummaryContinueButton() {
        return this.getHMIService().getButtonModel(1072765184);
    }

    public ButtonModelApp getConfirmSummaryChangedButton() {
        return this.getHMIService().getButtonModel(1055987968);
    }

    public ButtonModelApp getRsuUserAbortButton() {
        return this.getHMIService().getButtonModel(603003136);
    }

    public ChoiceModelApp getMediumChoice() {
        return this.getHMIService().getChoiceModel(-672065280);
    }

    public ListModelApp getMediaList() {
        return this.getHMIService().getListModel(837884160);
    }

    public ChoiceModelApp getSelectMediumStateChoice() {
        return this.getHMIService().getChoiceModel(703666432);
    }

    public LabelModelApp getReleaseLabel() {
        return this.getHMIService().getLabelModel(502339840);
    }

    public ListModelApp getReleaseList() {
        return this.getHMIService().getListModel(753998080);
    }

    public ChoiceModelApp getSelectReleaseStateChoice() {
        return this.getHMIService().getChoiceModel(770775296);
    }

    public LabelModelApp getVersionUploadResultLabel() {
        return this.getHMIService().getLabelModel(1307646208);
    }

    public ButtonModelApp getStatusDeviceSelectButton() {
        return this.getHMIService().getButtonModel(1039210752);
    }

    public ButtonModelApp getRestartVersionComparisonButton() {
        return this.getHMIService().getButtonModel(1290868992);
    }

    public ButtonModelApp getAbortVersionComparisonButton() {
        return this.getHMIService().getButtonModel(1022433536);
    }

    public ButtonModelApp getAbortReadMetaInfoButton() {
        return this.getHMIService().getButtonModel(-856680192);
    }

    public ButtonModelApp getAbortReadReleaseButton() {
        return this.getHMIService().getButtonModel(-839902976);
    }

    public ButtonModelApp getSelectUpdateStandardButton() {
        return this.getHMIService().getButtonModel(787552512);
    }

    public ButtonModelApp getSelectUpdateUserDefinedButton() {
        return this.getHMIService().getButtonModel(804329728);
    }

    public ButtonModelApp getStartDownloadButton() {
        return this.getHMIService().getButtonModel(1005656320);
    }

    public ButtonModelApp getAbortDownloadButton() {
        return this.getHMIService().getButtonModel(-873457408);
    }

    public ChoiceModelApp getIncompatibleUpdatesChoice() {
        return this.getHMIService().getChoiceModel(-319809280);
    }

    public LabelModelApp getInconsistentUpdateErrorLabel() {
        return this.getHMIService().getLabelModel(-303032064);
    }

    public ButtonModelApp getRSUSelectDownloadMediaSelectButton() {
        return this.getHMIService().getButtonModel(569448704);
    }

    public ButtonModelApp getRSUSelectDownloadMediaAbortButton() {
        return this.getHMIService().getButtonModel(535894272);
    }

    public ButtonModelApp getMUAbortMediaSelectAtRSU() {
        return this.getHMIService().getButtonModel(586225920);
    }

    public ChoiceModelApp getNetworkMediumAvailableChoice() {
        return this.getHMIService().getChoiceModel(183572736);
    }

    public ChoiceModelApp getPopupActionChoice() {
        return this.getHMIService().getChoiceModel(233904384);
    }

    public ChoiceModelApp getPopupSkipDeviceChoice() {
        return this.getHMIService().getChoiceModel(368122112);
    }

    public ChoiceModelApp getPopupInterruptChoice() {
        return this.getHMIService().getChoiceModel(284236032);
    }

    public ChoiceModelApp getPopupRetryChoice() {
        return this.getHMIService().getChoiceModel(317790464);
    }

    public ChoiceModelApp getPopupCancelChoice() {
        return this.getHMIService().getChoiceModel(250681600);
    }

    public ChoiceModelApp getPopupContinueChoice() {
        return this.getHMIService().getChoiceModel(267458816);
    }

    public ChoiceModelApp getPopupOkChoice() {
        return this.getHMIService().getChoiceModel(301013248);
    }

    public ChoiceModelApp getPopupSelectChoice() {
        return this.getHMIService().getChoiceModel(334567680);
    }

    public LabelModelApp getPopupSubtitle() {
        return this.getHMIService().getLabelModel(384899328);
    }

    public LabelModelApp getPopupTextLabel() {
        return this.getHMIService().getLabelModel(401676544);
    }

    LabelModelApp getRestartAppLabel() {
        return this.getHMIService().getLabelModel(519117056);
    }

    public BaseListModelApp getDevicesListModel() {
        return this.getHMIService().getBaseListModel(-1309599488);
    }

    public ChoiceModelApp getOnlineUpdateStateChoiceModel() {
        return this.getHMIService().getChoiceModel(3849);
    }

    public ChoiceModelApp getOnlineUpdateAvailableChoiceModel() {
        return this.getHMIService().getChoiceModel(-1896802048);
    }

    public ChoiceModelApp getStartDownloadButtonStateChoiceModel() {
        return this.getHMIService().getChoiceModel(-1225713408);
    }

    public BaseListModelApp getPackagesListModel() {
        return this.getHMIService().getBaseListModel(-1829693184);
    }

    public ButtonModelApp getStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-1745807104);
    }

    public ButtonModelApp getStartSysProposalDownloadButton() {
        return this.getHMIService().getButtonModel(-101639936);
    }

    public ButtonModelApp getAbortDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-1913579264);
    }

    public MetricsModelApp getConfirmDlSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(-1276045056);
    }

    public MetricsModelApp getDestinationPkgSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(502405376);
    }

    public ButtonModelApp getConfirmDlStartButtonModel() {
        return this.getHMIService().getButtonModel(-1259267840);
    }

    public ButtonModelApp getConfirmDlAbortButtonModel() {
        return this.getHMIService().getButtonModel(-1292822272);
    }

    public RangeModelApp getDlProgressRangeModel() {
        return this.getHMIService().getRangeModel(-1812915968);
    }

    public void updateUotaDownloadProgress(int n) {
        this.getDlProgressRangeModel().setValue(n);
        this.getSummaryDownloadAndInstallProgressRange().setValue(n);
    }

    public LabelModelApp getDlProgressLabelModel() {
        return this.getHMIService().getLabelModel(-1796138752);
    }

    public ChoiceModelApp getDlProgressTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(-403629824);
    }

    public MetricsModelApp getDlProgressDlSpeedMetricsModel() {
        return this.getHMIService().getMetricsModel(-235857664);
    }

    public ButtonModelApp getDlProgressAbortDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-1242490624);
    }

    public ButtonModelApp getAbortDlConfirmButtonModel() {
        return this.getHMIService().getButtonModel(-1158604544);
    }

    public ButtonModelApp getAbortDlCancelButtonModel() {
        return this.getHMIService().getButtonModel(-1141827328);
    }

    public ChoiceModelApp getDlProgressErrorShowPopUpChoiceModel() {
        return this.getHMIService().getChoiceModel(-1007609600);
    }

    public ButtonModelApp getDlProgressErrorRetryButtonModel() {
        return this.getHMIService().getButtonModel(-1057941248);
    }

    public ButtonModelApp getDlProgressErrorAbortButtonModel() {
        return this.getHMIService().getButtonModel(-1074718464);
    }

    public BaseListModelApp getNaviCountriesListModel() {
        return this.getHMIService().getBaseListModel(-839837440);
    }

    public MenuModelApp getNaviCountriesMenuModel() {
        return this.getHMIService().getMenuModel(-252634880);
    }

    public ChoiceModelApp getNaviToggleCountriesChoiceModel() {
        return this.getHMIService().getChoiceModel(-722396928);
    }

    public ResourceLocatorModelApp getNaviMapPreviewResourceLocatorModel() {
        return this.getHMIService().getResourceLocatorModel(-286189312);
    }

    public BaseListModelApp getSysProposalListModel() {
        return this.getHMIService().getBaseListModel(-84862720);
    }

    public BaseListModelApp getNaviRegionsListModel() {
        return this.getHMIService().getBaseListModel(-755951360);
    }

    public MenuModelApp getNaviRegionsMenuModel() {
        return this.getHMIService().getMenuModel(-269412096);
    }

    public ChoiceModelApp getNaviToggleRegionsChoiceModel() {
        return this.getHMIService().getChoiceModel(-705619712);
    }

    public LabelModelApp getSelectedCountryLabelModel() {
        return this.getHMIService().getLabelModel(-806283008);
    }

    public ButtonModelApp getNaviPopupLicenseDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-940500736);
    }

    public ButtonModelApp getSysProposalPopupStartDisclaimerButtonModel() {
        return this.getHMIService().getButtonModel(-101639936);
    }

    public ButtonModelApp getSysProposalPopupCancelButtonModel() {
        return this.getHMIService().getButtonModel(-34531072);
    }

    public ButtonModelApp getSysProposalDisclaimerPopupStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-118417152);
    }

    public ButtonModelApp getSysProposalDisclaimerPopupCancelButtonModel() {
        return this.getHMIService().getButtonModel(-17753856);
    }

    public ButtonModelApp getNaviPopupLicenseRemindLaterButtonModel() {
        return this.getHMIService().getButtonModel(-168748800);
    }

    public ButtonModelApp getNaviPopupLicenseIgnoreButtonModel() {
        return this.getHMIService().getButtonModel(-185526016);
    }

    public LabelModelApp getNaviPopupLicenseNewVersionLabelModel() {
        return this.getHMIService().getLabelModel(-923723520);
    }

    public ButtonModelApp getNaviPopupNoLicenseOkButtonModel() {
        return this.getHMIService().getButtonModel(-856614656);
    }

    public LabelModelApp getNaviPopupNoLicenseNewVersionLabelModel() {
        return this.getHMIService().getLabelModel(-873391872);
    }

    public ButtonModelApp getGenUpdPopupDownloadButtonModel() {
        return this.getHMIService().getButtonModel(-453961472);
    }

    public ButtonModelApp getGenUpdPopupRemindLaterButtonModel() {
        return this.getHMIService().getButtonModel(-202303232);
    }

    public ButtonModelApp getGenUpdPopupIgnoreButtonModel() {
        return this.getHMIService().getButtonModel(-219080448);
    }

    public MetricsModelApp getRequiredPackageSizeMetricsModel() {
        return this.getHMIService().getMetricsModel(-68085504);
    }

    public ChoiceModelApp getRequiredPackagesCheckboxChoiceModel() {
        return this.getHMIService().getChoiceModel(552737024);
    }

    public ButtonModelApp getMoreCountriesButtonModel() {
        return this.getHMIService().getButtonModel(116529408);
    }

    public LabelModelApp getCurrentDownloadPackageLabelModel() {
        return this.getHMIService().getLabelModel(133306624);
    }

    public LabelModelApp getTotalDownloadPackagesLabelModel() {
        return this.getHMIService().getLabelModel(150083840);
    }

    public LabelModelApp getUotaDestinationComponentLabelModel() {
        return this.getHMIService().getLabelModel(82974976);
    }

    public ChoiceModelApp isSystemPackageSelectedChoiceModel() {
        return this.getHMIService().getChoiceModel(217192704);
    }

    public ChoiceModelApp getCustomerDLProgressTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(267524352);
    }

    public LabelModelApp getCustomerUpdateProgressTimeoutLabelModel() {
        return this.getHMIService().getLabelModel(301078784);
    }

    public ChoiceModelApp getCustomerUpdateProgressTimeoutChoiceModel() {
        return this.getHMIService().getChoiceModel(284301568);
    }

    public LabelModelApp getUotaSummaryCountriesLabelModel() {
        return this.getHMIService().getLabelModel(233969920);
    }

    public LabelModelApp getUotaSummaryComponentsLabelModel() {
        return this.getHMIService().getLabelModel(569514240);
    }

    public LabelModelApp getUotaSummaryComponentsVersionLabelModel() {
        return this.getHMIService().getLabelModel(-1947133696);
    }

    public ButtonModelApp getUotaDestinationSwitchToUotaButtonModel() {
        return this.getHMIService().getButtonModel(351410432);
    }

    public ButtonModelApp getUotaDestinationStartDownloadButtonModel() {
        return this.getHMIService().getButtonModel(368187648);
    }

    public ChoiceModelApp getLeaveCustomerUpdateChoiceModel() {
        return this.getHMIService().getChoiceModel(485628160);
    }

    public ChoiceModelApp getUotaDisclaimerTypeChoiceModel() {
        return this.getHMIService().getChoiceModel(519182592);
    }

    public ButtonModelApp getUotaDisclaimerBackButton() {
        return this.getHMIService().getButtonModel(535959808);
    }

    public ChoiceModelApp getCustomerOrOnlineChoiceModel() {
        return this.getHMIService().getChoiceModel(586291456);
    }

    public ChoiceModelApp getUotaExcludeNavdataChoiceModel() {
        return this.getHMIService().getChoiceModel(603068672);
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

