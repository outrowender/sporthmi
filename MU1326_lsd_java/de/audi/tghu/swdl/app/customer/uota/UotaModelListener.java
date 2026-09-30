/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.listener.DefaultChoiceListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import java.util.Map;

class UotaModelListener {
    private final BaseUpdateOverTheAirController uotaController;

    UotaModelListener(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.uotaController = baseUpdateOverTheAirController;
    }

    void registerModelListeners() {
        this.getLogUota().log(1000000, "[UotaModelListener].registerModelListeners(): Registering model listeners");
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
        this.getLogUota().log(10000000, "[UotaModelListener].registerPkgSelectionModelListeners(): Registering model listeners for package selection screen");
        this.getSwdlModels().getStartDownloadButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.StartDownloadButtonListener].keyTyped(): Package selection done!");
                UotaModelListener.this.getUotaController().calculateAndSetDownloadSize();
                UotaModelListener.this.getSwdlModels().getUotaDisclaimerTypeChoiceModel().setValue(0);
                UotaModelListener.this.getSwdlModels().getStartDownloadButtonModel().fireEvent(n3);
                UotaModelListener.this.getUotaController().showSystemProposalDisclaimerPopup();
            }
        });
        this.getSwdlModels().getAbortDownloadButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.AbortDownloadButtonListener].keyTyped(): Download aborted!");
                UotaModelListener.this.getUotaController().cleanupPackageHierarchy();
                UotaModelListener.this.getUotaController().setDownloadState(0);
                UotaModelListener.this.getSwdlModels().getAbortDownloadButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getPackagesListModel().setListener(new DefaultBaseListModelListener(){

            public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.PackagesListListener].itemSelected(): Package selected: %1", (Object)evoListRow);
                UotaModelListener.this.getUotaController().packageSelected((AbstractPkgListRow)evoListRow, UotaModelListener.this.getSwdlModels().getPackagesListModel(), n4);
            }
        });
    }

    private void registerCountrySelectionModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerCountrySelectionModelListeners(): Registering model listeners for country selection screen");
        this.getSwdlModels().getNaviCountriesListModel().setListener(new DefaultBaseListModelListener(){

            public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviCountriesListListener].itemSelected(): Country selected: %1", (Object)evoListRow);
                AbstractPkgListRow abstractPkgListRow = (AbstractPkgListRow)evoListRow;
                UotaModelListener.this.getSwdlModels().getSelectedCountryLabelModel().setText(abstractPkgListRow.getNode().getDisplayName());
                UotaModelListener.this.getUotaController().packageSelected(abstractPkgListRow, UotaModelListener.this.getSwdlModels().getNaviCountriesListModel(), n4);
            }

            public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
                Map map;
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviCountriesListListener].itemFocused(): Country focused: %1", (Object)evoListRow);
                AbstractPkgListRow abstractPkgListRow = (AbstractPkgListRow)evoListRow;
                UotaPkgInfoWrapper uotaPkgInfoWrapper = null;
                PkgNode pkgNode = abstractPkgListRow.getNode();
                while (null != pkgNode && null == (uotaPkgInfoWrapper = pkgNode.getPackageInfo()) && null != (map = abstractPkgListRow.getNode().getChildNodes()) && !map.isEmpty()) {
                    pkgNode = (PkgNode)map.values().iterator().next();
                }
                if (null == uotaPkgInfoWrapper) {
                    UotaModelListener.this.getLogUota().log(10000, "[UotaModelListener.NaviCountriesListListener].itemFocused(): Could not find package info for country focused: %1", (Object)evoListRow);
                }
            }
        });
        this.getSwdlModels().getNaviToggleCountriesChoiceModel().setChoiceListener(new DefaultChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviToggleCountriesChoiceListener].itemSelected(): Countries selection toggled!");
                UotaModelListener.this.getUotaController().toggleRowSelection((AbstractPkgListRow)UotaModelListener.this.getSwdlModels().getNaviCountriesListModel().getRow(0));
            }
        });
    }

    private void registerSysProposalPopupSelectionModelListener() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerSysProposalPopupSelectionModelListener(): Registering model listeners for system proposal pop-up");
        this.getSwdlModels().getSysProposalListModel().setListener(new DefaultBaseListModelListener(){

            public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.SysProposalListListener].itemSelected(): region selected: %1", (Object)evoListRow);
                UotaModelListener.this.getUotaController().packageSelected((AbstractPkgListRow)evoListRow, UotaModelListener.this.getSwdlModels().getSysProposalListModel(), n4);
            }
        });
    }

    private void registerCountryRegionsSelectionModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerCountryRegionsSelectionModelListeners(): Registering model listeners for region selection screen");
        this.getSwdlModels().getNaviRegionsListModel().setListener(new DefaultBaseListModelListener(){

            public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviRegionsListListener].itemSelected(): Region selected: %1", (Object)evoListRow);
                UotaModelListener.this.getUotaController().packageSelected((AbstractPkgListRow)evoListRow, UotaModelListener.this.getSwdlModels().getNaviRegionsListModel(), n4);
            }

            public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
            }
        });
        this.getSwdlModels().getNaviToggleRegionsChoiceModel().setChoiceListener(new DefaultChoiceListener(){

            public void itemSelected(int n, int n2, int n3, int n4) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviToggleRegionsChoiceListener].itemSelected(): Regions selection toggled!");
                UotaModelListener.this.getUotaController().toggleRowSelection((AbstractPkgListRow)UotaModelListener.this.getSwdlModels().getNaviRegionsListModel().getRow(0));
            }
        });
    }

    private void registerDownloadConfirmationMoldelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerDownloadConfirmationMoldelListeners(): Registering model listeners for download confirmation screen");
        this.getSwdlModels().getConfirmDlStartButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(1000000, "[UotaModelListener.ConfirmDlStartButtonListener].keyTyped(): Start download confirmed!");
                UotaModelListener.this.getUotaController().startDownload();
                UotaModelListener.this.getSwdlModels().getConfirmDlStartButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getConfirmDlAbortButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.ConfirmDlAbortButtonListener].keyTyped(): Download aborted!");
                UotaModelListener.this.getUotaController().setDownloadState(0);
                UotaModelListener.this.getUotaController().cleanupPackageHierarchy();
                UotaModelListener.this.getSwdlModels().getConfirmDlAbortButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerDownloadProgressModelListerns() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerDownloadProgressModelListerns(): Registering model listeners for download progress screen");
        this.getSwdlModels().getDlProgressAbortDownloadButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.DlProgressAbortDownloadButtonListener].keyTyped(): Download abort requested!");
                UotaModelListener.this.getSwdlModels().getDlProgressAbortDownloadButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerDownloadProgressAbortModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerDownloadProgressAbortModelListeners(): Registering model listeners for download progress abort screen");
        this.getSwdlModels().getAbortDlConfirmButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.AbortDlConfirmButtonListener].keyTyped(): Download abort confirmed!");
                UotaModelListener.this.getUotaController().abortDownload();
                UotaModelListener.this.getSwdlModels().getAbortDlConfirmButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getAbortDlCancelButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.AbortDlCancelButtonListener].keyTyped(): Download abort canceled!");
                UotaModelListener.this.getSwdlModels().getAbortDlCancelButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerDownloadErrorPopupsModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerDownloadErrorPopupsModelListeners(): Registering model listeners for download error pop-ups");
        this.getSwdlModels().getDlProgressErrorRetryButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.DlProgressErrorRetryButtonListener].keyTyped(): Retry triggered after download error!");
                if (UotaModelListener.this.getUotaController().isUotaError()) {
                    UotaModelListener.this.getUotaController().restartDownload();
                } else {
                    UotaModelListener.this.getLogUota().log(100000, "[UotaModelListener.DlProgressErrorRetryButtonListener].keyTyped(): DownloadOTA is not active, cannot retry download!");
                }
                UotaModelListener.this.getSwdlModels().getDlProgressErrorRetryButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getDlProgressErrorAbortButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.DlProgressErrorAbortButtonListener].keyTyped(): Download canceled after error!");
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getUotaController().abortDownload();
                UotaModelListener.this.getSwdlModels().getDlProgressErrorAbortButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerSysProposalDisclaimerPopupModelListener() {
        this.getSwdlModels().getSysProposalDisclaimerPopupStartDownloadButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.SysProposalDisclaimerPopupStartDownloadButtonModel].keyTyped(): start download system proposals!");
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getUotaController().startDownload();
                UotaModelListener.this.getSwdlModels().getSysProposalDisclaimerPopupStartDownloadButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getSysProposalDisclaimerPopupCancelButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.SysProposalDisclaimerPopupCancelButtonModel].keyTyped(): cancel system proposal!");
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                if (UotaModelListener.this.getUotaController().isUotaDestinationSelectionActive() || UotaModelListener.this.getUotaController().isUotaSysProposalSelectionActive()) {
                    UotaModelListener.this.getUotaController().ignoreUpdatesAvailablePopup(true);
                } else {
                    UotaModelListener.this.getUotaController().ignoreUpdatesAvailablePopup(false);
                    UotaModelListener.this.getUotaController().cleanupPackageHierarchy();
                    UotaModelListener.this.getUotaController().setDownloadState(0);
                }
                UotaModelListener.this.getSwdlModels().getSysProposalDisclaimerPopupCancelButtonModel().fireEvent(n3);
            }
        });
        this.getSwdlModels().getUotaDisclaimerBackButton().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                if (UotaModelListener.this.getSwdlModels().getUotaDisclaimerTypeChoiceModel().getValue() == 0) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.UotaDisclaimerBackButton].keyTyped(): returnt to the package screen!");
                    UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                    UotaModelListener.this.getSwdlModels().getUotaDisclaimerBackButton().fireEvent(n3);
                } else {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.UotaDisclaimerBackButton].keyTyped(): it's not a manual Uota, fire cancel event");
                    UotaModelListener.this.getSwdlModels().getSysProposalDisclaimerPopupCancelButtonModel().fireEvent(n3);
                }
            }
        });
    }

    private void registerSysProposalPopupModelListeners() {
        this.getSwdlModels().getSysProposalPopupStartDisclaimerButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.SysProposalPopupStartDisclaimerButtonListener].keyTyped(): system proposal disclaimer pop-up requested!");
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getUotaController().calculateAndSetDownloadSize();
                UotaModelListener.this.getSwdlModels().getUotaDisclaimerTypeChoiceModel().setValue(1);
                UotaModelListener.this.getSwdlModels().getSysProposalPopupStartDisclaimerButtonModel().fireEvent(n3);
                UotaModelListener.this.getUotaController().showSystemProposalDisclaimerPopup();
            }
        });
        this.getSwdlModels().getSysProposalPopupCancelButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.SysProposalPopupCancelButtonListener].keyTyped(): system proposal disclaimer pop-up requested!");
                UotaModelListener.this.getUotaController().ignoreUpdatesAvailablePopup(true);
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getSwdlModels().getSysProposalPopupCancelButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerMoreCountriesButtonListener() {
        this.getSwdlModels().getMoreCountriesButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.getMoreCountriesButtonListener].keyTyped(): additional countries screen requested!");
                UotaModelListener.this.getUotaController().setFocusToSysProposalItem();
                UotaModelListener.this.getSwdlModels().getMoreCountriesButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerNewNaviUpdateAvailablePopupModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerNewNaviUpdatePopupModelListeners(): Registering model listeners for new navi update pop-ups");
        this.getSwdlModels().getNaviPopupLicenseDownloadButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviPopupLicenseDownloadButtonListener].keyTyped(): system proposal component selection pop-up requested!");
                UotaModelListener.this.getSwdlModels().getNaviPopupLicenseDownloadButtonModel().fireEvent(n3);
                UotaModelListener.this.getUotaController().buildSysProposalRows();
                UotaModelListener.this.getUotaController().setDownloadState(9);
                UotaModelListener.this.getSwdlModels().getSysProposalPopupStartDisclaimerButtonModel().setStatus(0);
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getUotaController().showUpdateSystemProposalPopup();
            }
        });
        this.getSwdlModels().getNaviPopupLicenseIgnoreButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviPopupLicenseIgnoreButtonListener].keyTyped(): ignore selected!");
                UotaModelListener.this.getUotaController().ignoreUpdatesAvailablePopup(true);
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getSwdlModels().getNaviPopupLicenseIgnoreButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerNewNaviUpdateNoLicensePopupModelListeners() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerNewNaviUpdateNoLicensePopupModelListeners(): Registering model listeners for new navi update pop-ups (no license)");
        this.getSwdlModels().getNaviPopupNoLicenseOkButtonModel().setButtonListener(new DefaultButtonListener(){

            public void keyTyped(int n, int n2, int n3) {
                UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NaviPopupNoLicenseOkButtonListener].keyTyped(): Closing pop-up!");
                UotaModelListener.this.getUotaController().ignoreUpdatesAvailablePopup(true);
                UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                UotaModelListener.this.getSwdlModels().getNaviPopupNoLicenseOkButtonModel().fireEvent(n3);
            }
        });
    }

    private void registerCancelOnlineUpdateButtonListener() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerCancelOnlineUpdateButtonListener()");
        final ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(1700287);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.CancelOnlineUpdateButtonListener].keyTyped(): cancel download, hide pop-up!");
                    UotaModelListener.this.getUotaController().abortDownload();
                    UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                    buttonModelApp.fireEvent(n3);
                }
            });
        }
    }

    private void registerNoOnlineDataConfirmButtonListener() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerNoOnlineDataConfirmButtonListener()");
        final ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(1700366);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.NoOnlineDataConfirmButtonListener].keyTyped(): cancel download, hide pop-up!");
                    UotaModelListener.this.getUotaController().abortDownload();
                    buttonModelApp.fireEvent(n3);
                }
            });
        }
    }

    private void registerWaitOnlineUpdateServiceButtonListener() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerWaitOnlineUpdateServiceButtonListener()");
        final ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(1700361);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.WaitOnlineUpdateServiceButtonListener].keyTyped(): wait for online update service, hide pop-up!");
                    UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                    UotaModelListener.this.getUotaController().setDownloadState(11);
                    buttonModelApp.fireEvent(n3);
                }
            });
        }
    }

    private void registerPPOISummaryConfirmListener() {
        this.getLogUota().log(10000000, "[UotaModelListener].registerPPOISummaryConfirmButtonListener()");
        final ButtonModelApp buttonModelApp = this.getUotaController().getSwdlEnv().getHMIService().getButtonModel(1700370);
        if (buttonModelApp != null) {
            buttonModelApp.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.PPOISummaryPopupConfirmButtonListener].keyTyped():");
                    UotaModelListener.this.getSwdlModels().getCustomerProgressStateChoice().setValue(0);
                    UotaModelListener.this.getUotaController().confirmSummaryPopup();
                    if (UotaModelListener.this.getUotaController().isLastPackageUpdated()) {
                        UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.PPOISummaryPopupConfirmButtonListener].keyTyped(): last update package, fire button event!");
                        buttonModelApp.fireEvent(n3);
                    } else {
                        UotaModelListener.this.getUotaController().hideUotaPPOISummaryPopup();
                    }
                }
            });
        }
    }

    private void registerDestinationPopupListener() {
        ButtonModelApp buttonModelApp;
        this.getLogUota().log(10000000, "[UotaModelListener].registerDestinationPopupListener()");
        final ButtonModelApp buttonModelApp2 = this.getSwdlModels().getUotaDestinationSwitchToUotaButtonModel();
        if (buttonModelApp2 != null) {
            buttonModelApp2.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.DestinationSwitchToUotaButtonListener].keyTyped():");
                    UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                    UotaModelListener.this.getUotaController().showUpdateDestinationConfirmationPopup();
                    buttonModelApp2.fireEvent(n3);
                }
            });
        }
        if ((buttonModelApp = this.getSwdlModels().getUotaDestinationStartDownloadButtonModel()) != null) {
            buttonModelApp.setButtonListener(new DefaultButtonListener(){

                public void keyTyped(int n, int n2, int n3) {
                    UotaModelListener.this.getLogUota().log(10000000, "[UotaModelListener.DestinationStartDownloadButtonListener].keyTyped():");
                    UotaModelListener.this.getUotaController().setPopupButtonPressed(true);
                    UotaModelListener.this.getSwdlModels().getUotaDisclaimerTypeChoiceModel().setValue(2);
                    UotaModelListener.this.getUotaController().showSystemProposalDisclaimerPopup();
                    buttonModelApp.fireEvent(n3);
                }
            });
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
}

