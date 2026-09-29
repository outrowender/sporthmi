/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.ByteSize;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController;
import de.audi.tghu.swdl.app.customer.uota.DownloadPackageData;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import java.util.ArrayList;
import java.util.StringTokenizer;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.uota.DSIUotAListener;
import org.dsi.ifc.uota.PackageInfo;

class UotaDSIListener
implements DSIUotAListener {
    private final BaseUpdateOverTheAirController uotaController;
    private static final String NAME_MARKER;
    private static final String CATEGORY_MARKER;
    private static final String INDEX_MARKER;
    private static final String CUSTOMER_DETAILS_DELIMETERS;

    UotaDSIListener(BaseUpdateOverTheAirController baseUpdateOverTheAirController) {
        this.uotaController = baseUpdateOverTheAirController;
    }

    @Override
    public void updateDownloadState(int n, int n2, int n3) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- updateDownloadState(%1,%2,%3)", (long)n, (long)n2, (long)n3);
        if (1 != n3) {
            this.getLogDSI().log(-1601830656, "[UotaDSIListener].updateDownloadState(%1): Update with invalid flag", (long)n3);
            return;
        }
        if (!this.getUotaController().isFirstUotaStateReceived()) {
            if (1 != n2 && 4 != n2 && !this.getUotaController().isMapIntegrationInProgress()) {
                this.getLogDSI().log(-2137614336, "[UotaDSIListener].updateDownloadState(): Unlock BulkCopy", (long)n3);
                this.getSwdlEnv().getBulkCopyAccess().bulkCopyUnlock();
            }
            this.getUotaController().setFirstUotaStateReceived();
        }
        switch (n2) {
            case 1: {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_ACTIVE)");
                if (this.getUotaController().isUotaUpdateAllowed(false)) {
                    if (this.getUotaController().isInstallActive()) {
                        this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): Installation done and more packages needed to be downloaded - fireing event to enter UOTA download progress!");
                        this.getUotaController().setDownloadState(2);
                        this.getUotaController().hideSwdlSummaryPopups();
                        this.getSwdlModels().getConfirmDlStartButtonModel().fireEvent(this.getSwdlEnv().getTerminalId());
                        break;
                    }
                    this.getUotaController().setDownloadState(2);
                    break;
                }
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): Customer DL isn't allowed. Abort download!");
                this.getUotaController().abortDownload();
                break;
            }
            case 4: {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_WAIT_FOR_PDD)");
                if (this.getUotaController().isDownloadActive() || !this.getUotaController().isUotaEntered()) {
                    int n4 = this.getUotaController().getStoredInstallingProgress();
                    if (n4 > 0) {
                        this.getSwdlModels().updateUotaDownloadProgress(n4);
                    } else {
                        this.getSwdlModels().updateUotaDownloadProgress(this.getUotaController().downloadProgress2CrossProgress(100));
                    }
                    this.getUotaController().setDownloadState(7);
                    this.getSwdlModels().getOnlineUpdateStateChoiceModel().setValue(7);
                    this.getSwdlModels().getDlProgressTypeChoiceModel().setValue(6);
                }
                this.getSwdlEnv().setCustProgressIconVisible(false);
                break;
            }
            case 2: {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_FINISHED)");
                if (this.getUotaController().isCustomerDownloadProgressActive()) {
                    this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): Customer SWDL progress detected - setting UOTA state to STATE_INSTALL_ACTIVE!");
                    this.getUotaController().setDownloadState(3);
                    break;
                }
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): No customer SWDL progress detected - setting UOTA state to STATE_DOWNLOAD_FINISHED!");
                this.getUotaController().setDownloadState(14);
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): getting the source path");
                this.getUotaController().getSwdlSourcePath();
                this.getSwdlEnv().setCustProgressIconVisible(false);
                break;
            }
            case 0: {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_NOT_ACTIVE)");
                if (this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().getValue() == 0) {
                    this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
                }
                if (this.getUotaController().isInstallActive() && !this.getUotaController().isInstallError()) {
                    this.getUotaController().setDownloadState(5);
                    this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(): Installation done and no more packages to download - leaving customer update!");
                    this.getUotaController().hideSwdlSummaryPopups();
                    this.getUotaController().cleanupPackageHierarchy();
                    this.getUotaController().cleanupDownloadPackageNumbers();
                    break;
                }
                this.getUotaController().setDownloadState(0);
                this.getUotaController().cleanupPackageHierarchy();
                this.getUotaController().cleanupDownloadPackageNumbers();
                if (this.getSwdlModels().getCustomerProgressStateChoice().getValue() != 3) {
                    this.getSwdlEnv().setCustProgressIconVisible(false);
                }
                this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(this.getUotaController().isUotaUpdateAllowed(true) ? 1 : 0);
                break;
            }
            case 3: {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_ERROR_CANCELED_BY_USER): Download canceled by user!");
                if (this.getUotaController().isDownloadActive() || this.getUotaController().isDownloadWaitForConnection()) {
                    this.getUotaController().setDownloadState(5);
                    this.getUotaController().hideSwdlSummaryPopups();
                    this.getUotaController().cleanupPackageHierarchy();
                    this.getUotaController().cleanupDownloadPackageNumbers();
                } else {
                    this.getUotaController().cleanupPackageHierarchy();
                    this.getUotaController().cleanupDownloadPackageNumbers();
                }
                this.getSwdlEnv().setCustProgressIconVisible(false);
                break;
            }
            case 13: {
                if (this.getUotaController().isWaitForPDD()) {
                    this.getLogDSI().log(-2137614336, "[UotaDSIListener].updateDownloadState(STATE_ERROR_CONNECTION_FAILURE): current state is wait for PDD, ignore connection failure!");
                    break;
                }
                this.getLogDSI().log(-1601830656, "[UotaDSIListener].updateDownloadState(STATE_ERROR_CONNECTION_FAILURE): connection failure!");
                this.getUotaController().updateDownloadProgress(true, null, -1, -1);
                if (!this.getUotaController().isDownloadActive()) break;
                this.getUotaController().showServerErrorPopup();
                break;
            }
            case 12: {
                this.getLogDSI().log(10000, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_ERROR_RETRY_POSSIBLE): download state error - retry possible!");
                this.getUotaController().downloadError(true, true);
                break;
            }
            case 10: {
                this.getLogDSI().log(10000, "[UotaDSIListener].updateDownloadState(STATE_ERROR): Download error - retry not possible!", (long)n2);
                this.getUotaController().downloadError(true, false);
                this.getUotaController().cleanupPackageHierarchy();
                this.getUotaController().cleanupDownloadPackageNumbers();
                this.getSwdlEnv().setCustProgressIconVisible(false);
                break;
            }
            case 11: {
                this.getLogDSI().log(10000, "[UotaDSIListener].updateDownloadState(STATE_DOWNLOAD_ERROR): Download error - retry not possible!", (long)n2);
                this.getUotaController().downloadError(true, false);
                break;
            }
            default: {
                this.getLogDSI().log(10000, "[UotaDSIListener].updateDownloadState(%1): Unknown download state!", (long)n2);
                this.getUotaController().downloadError(true, false);
            }
        }
    }

    @Override
    public void updateDownloadProgress(int n, int n2, int n3, String string, int n4) {
        if (1 != n4) {
            this.getLogDSI().log(-1601830656, "[UotaDSIListener].updateDownloadProgress(%1): Update with invalid flag", (long)n4);
            return;
        }
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- updateDownloadProgress(%1,%2,%3)", (long)n, (long)n2, (long)n3);
        if (!this.getUotaController().isDownloadActive() && !this.getUotaController().isWaitForPDD()) {
            this.getLogUota().log(-1601830656, "[UotaDSIListener].updateDownloadProgress(): Ignoring update, no active download");
            return;
        }
        if (this.getUotaController().isWaitForPDD()) {
            n3 = this.getUotaController().downloadProgress2CrossProgress(n3);
        }
        this.getUotaController().updateDownloadProgress(false, string, n3, n2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void getServerList(int n, String[] stringArray) {
        this.getLogDSI().log(1078071040, "[UotaDSIListener] <- getServerList(%2,%1)", (Object)stringArray, (long)n);
        String string = System.getProperty("UotaServerName");
        UotaDSIListener uotaDSIListener = this;
        synchronized (uotaDSIListener) {
            if (0 == n) {
                if (null != stringArray && 0 != stringArray.length) {
                    if (null != string) {
                        for (int i2 = 0; i2 < stringArray.length; ++i2) {
                            if (!string.equals(stringArray[i2])) continue;
                            this.getUotaController().setServerName(string);
                            this.getLogDSI().log(-1601830656, "[UotaDSIListener].getServerList(): Using the test server name: %1!", (Object)this.getUotaController().getServerName());
                            break;
                        }
                        this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
                    } else {
                        if (stringArray.length > 1) {
                            this.getLogDSI().log(-1601830656, "[UotaDSIListener].getServerList(%1): More than one server returned. Using the first in the list!", (Object)stringArray);
                        } else {
                            this.getLogDSI().log(1078071040, "[UotaDSIListener].getServerList(): Using the only server in the list: %1!", (Object)stringArray[0]);
                        }
                        this.getUotaController().setServerName(stringArray[0]);
                        this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
                    }
                } else {
                    this.getLogDSI().log(10000, "[UotaDSIListener].getServerList(): Empty server name list!");
                }
            } else {
                this.getLogDSI().log(10000, "[UotaDSIListener].getServerList(%1): Error while reading server names", (long)n);
            }
            this.getUotaController().setServerNameResponse(true);
            super.notifyAll();
        }
    }

    @Override
    public synchronized void getUpdatePackages(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        Object object;
        if (!this.getSwdlEnv().isUpdateOverTheAirFeatureEnabled()) {
            this.getLogDSI().log(10000, "[UotaDSIListener].getUpdatePackages(): UOTA is not allowed, ignore this!");
            return;
        }
        boolean bl = n == 0;
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- getUpdatePackages(%1,%2,%3...)", (long)n, (long)n2, (long)(null == packageInfoArray ? 0 : packageInfoArray.length));
        if (this.getUotaController().isDownloadActive() || this.getUotaController().isWaitForPDD() || (this.getUotaController().isUotaEntered() || !this.getUotaController().isServiceReady()) && bl) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].getUpdatePackages() build download packages!");
            this.getUotaController().setTotalNumberOfUpdatePackages(packageInfoArray.length);
            this.getSwdlModels().getTotalDownloadPackagesLabelModel().setText(Integer.toString(packageInfoArray.length));
            this.getUotaController().buildDownloadPackages(packageInfoArray);
            return;
        }
        int n3 = this.getSwdlModels().getCustomerProgressStateChoice().getValue();
        if (!this.getUotaController().isUotaUpdateAllowed(false) || n3 != 0 && n3 != 6) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] ignore getUpdatePackages() because the UOtA is not allowed now!");
            this.getUotaController().resetUotaPackagesRequestState();
            return;
        }
        if (bl && this.getUotaController().isUotaEntered()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] ignore system proposal because the customer UOTA is entered!");
            return;
        }
        if (bl && (object = this.getSwdlModels().getCustomerReadingMetaInfoStateChoice()).getStatus() == 0) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] ignore system proposal because the customer UOTA reads metadata!");
            return;
        }
        if (this.getUotaController().isUotaDestinationPopupRequested()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] reset destination pop-up!");
            this.getUotaController().cleanUpPopupRequests();
        } else if (this.getUotaController().isUotaSysProposalPopupRequested()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] reset system proposal pop-up!");
            this.getUotaController().cleanUpPopupRequests();
        } else if (this.getUotaController().isUotaDestinationSelectionActive() || this.getUotaController().isUotaSysProposalSelectionActive()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener] ignore response getUpdatePackages() because the UOtA destination/proposal pop-up is shown!");
            return;
        }
        this.getUotaController().cancelProcessUotaPackages(false);
        if (0 == n2) {
            if (null != packageInfoArray && 0 != packageInfoArray.length) {
                object = new PkgNode(this.getUotaController(), packageInfoArray, nArray);
                this.getUotaController().setHierarchyRoot((PkgNode)object);
                if (((PkgNode)object).isCancelled()) {
                    this.getUotaController().cleanupPackageHierarchy();
                    return;
                }
                if (!this.getUotaController().isUotaEntered()) {
                    this.getLogDSI().log(1078071040, "[UotaDSIListener].getUpdatePackages(): UOTA is not entered, showing new packages popup!");
                    this.getUotaController().setDownloadState(8);
                    this.getUotaController().getSpeedThresholdPopuphandler().requestSysProposalInfoPopup(0, ((PkgNode)object).getAllPackageInfos());
                    return;
                }
                this.getUotaController().handleNewPackagesResult((PkgNode)object);
            } else {
                this.getLogDSI().log(-1601830656, "[UotaDSIListener].getUpdatePackages(): Empty list of update packages returned!");
                this.handleNoPackagesResult(2);
            }
        } else {
            this.getLogDSI().log(10000, "[UotaDSIListener].getUpdatePackages(%1): Error while reading the update packages", (long)n2);
            this.handleNoPackagesResult(3);
        }
    }

    @Override
    public void toggleSelection(int n, int n2, int[] nArray) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- toggleSelection(%1,%2...)", (long)n, (long)n2);
        if (!this.getUotaController().isUotaSelectionActive() && !this.getUotaController().isUotaSysProposalSelectionActive()) {
            this.getLogUota().log(-1601830656, "[UotaDSIListener].toggleSelection(): Package selection stage has passed, ignoring selection status!");
            return;
        }
        if (0 == n2) {
            this.getLogUota().log(-2137614336, "[UotaDSIListener].toggleSelection(): Changing selection status");
            if (null != nArray) {
                this.getUotaController().toggleSelection(nArray);
                if (this.getUotaController().isWaitingForSelectionEmpty()) {
                    if (this.getUotaController().isUotaSysProposalSelectionActive()) {
                        this.getSwdlModels().getStartSysProposalDownloadButton().setStatus(this.getUotaController().getHierarchyRoot().getSelectedCount() > 0 ? 1 : 0);
                    } else {
                        this.getSwdlModels().getStartDownloadButtonModel().setStatus(this.getUotaController().getHierarchyRoot().getSelectedCount() > 0 ? 1 : 0);
                    }
                    this.getLogUota().log(-2137614336, "[UotaDSIListener].toggleSelection(): Selection changed");
                    this.getUotaController().setBaseListsStatus(1);
                }
            } else {
                this.getLogDSI().log(10000, "[UotaDSIListener].toggleSelection(): null additional info!");
            }
        } else if (5 == n2) {
            this.getLogDSI().log(10000, "[UotaDSIListener].toggleSelection(%1): service not available -> selection isn' possible", (long)n2);
            this.getUotaController().showServerErrorPopup();
        } else {
            this.getLogDSI().log(10000, "[UotaDSIListener].toggleSelection(%1): Error while changing selection!", (long)n2);
            this.getUotaController().setBaseListsStatus(2);
        }
    }

    @Override
    public void startDownload(int n, int n2) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- startDownload(%1,%2)", (long)n, (long)n2);
        if (0 == n2) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].startDownload(): Download started");
            if (this.getUotaController().isUotaDestinationSelectionActive()) {
                this.getUotaController().storeDestinationPackage();
            }
            this.getUotaController().setDownloadState(2);
        } else {
            this.getLogDSI().log(10000, "[UotaDSIListener].startDownload(%1): Failed to start download", (long)n2);
            this.getUotaController().downloadError(true, false);
        }
    }

    @Override
    public void attributeResult(int n, int n2, int n3, String string) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- attributeResult(%2,%1,%3)", (Object)string, (long)n2, (long)n3);
        if (0 == n2) {
            if (1 == n3) {
                this.getUotaController().downloadFinished(string);
            } else {
                this.getLogDSI().log(-1601830656, "[UotaDSIListener].attributeResult(%1): Unknown attribute", (long)n3);
                this.getUotaController().downloadFinished(null);
            }
        } else {
            this.getLogDSI().log(10000, "[UotaDSIListener].attributeResult(%1,%2): Error while getting attribute", (long)n3, (long)n2);
            this.getUotaController().downloadFinished(null);
        }
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        this.getLogDSI().log(10000, "[UotaDSIListener] <- asyncException(%2,%1,%3)", (Object)string, (long)n, (long)n2);
    }

    @Override
    public void triggerAction(int n, int n2, int n3, String string) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- triggerAction(%1, %2,options=%3)", (Object)Integer.toString(n), (Object)Integer.toString(n3), (Object)string);
        if (0 == n2) {
            if (4 == n3) {
                Object object;
                this.getLogDSI().log(-2137614336, "[UotaDSIListener].triggerAction(): showSummaryUota(containsErrorDevices=false)");
                DownloadPackageData downloadPackageData = this.getUotaController().getDownloadPackageData();
                if (null != string && string.length() > 0) {
                    try {
                        object = string.substring(string.lastIndexOf(61) + 1);
                        this.getUotaController().setNumberOfCurrentUpdatePackage(Integer.parseInt((String)object));
                    }
                    catch (Exception exception) {
                        this.getLogDSI().log(10000, "[UotaDSIListener].triggerAction(): no package index found or the index has an incorect format!");
                    }
                }
                if (downloadPackageData.isPPOIPackage(this.getUotaController().getNumberOfCurrentUpdatePackage() - 1)) {
                    object = this.getSwdlModels().getCustomerUpdateVersionLabel();
                    this.getUotaController().setSummaryPopupConfirmed(false);
                    object.setText(downloadPackageData.getPackageVersion(this.getUotaController().getNumberOfCurrentUpdatePackage() - 1));
                    this.getSwdlEnv().getHMISwitcher().switchToCustomerHmi(this.getSwdlEnv().getTerminalId());
                    this.getUotaController().showUotaPPOISummaryPopup();
                    if (this.getUotaController().isLastPackageUpdated()) {
                        this.getUotaController().cleanupDownloadPackageData();
                    }
                } else {
                    object = this.getSwdlModels().getCustomerUpdateVersionLabel();
                    LabelModelApp labelModelApp = this.getSwdlModels().getUotaSummaryCountriesLabelModel();
                    LabelModelApp labelModelApp2 = this.getSwdlModels().getUotaSummaryComponentsLabelModel();
                    LabelModelApp labelModelApp3 = this.getSwdlModels().getUotaSummaryComponentsVersionLabelModel();
                    String string2 = downloadPackageData.getPackageNames("navdata");
                    labelModelApp.setText(string2);
                    if (this.getSwdlEnv().isUotaNavDBMergeProcessNeeded()) {
                        this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(string2);
                    }
                    if (labelModelApp.getText().length() > 0) {
                        String string3 = downloadPackageData.getPackageVersions("navdata");
                        object.setText(string3);
                        if (this.getSwdlEnv().isUotaNavDBMergeProcessNeeded()) {
                            this.getSwdlModels().getCustomerUpdateVersionLabel().setText(string3);
                        }
                    } else {
                        object.setText("");
                    }
                    labelModelApp2.setText(downloadPackageData.getPackageNames("system"));
                    if (labelModelApp2.getText().length() > 0) {
                        labelModelApp3.setText(downloadPackageData.getPackageVersions("system"));
                    } else {
                        labelModelApp3.setText("");
                    }
                    this.getUotaController().setSummaryPopupConfirmed(false);
                    this.getSwdlEnv().getHMISwitcher().switchToCustomerHmi(this.getSwdlEnv().getTerminalId());
                    this.getUotaController().showUotaSummaryPopup();
                    this.getUotaController().cleanupDownloadPackageData();
                }
            } else if (6 == n3) {
                this.getLogDSI().log(-2137614336, "[UotaDSIListener].triggerAction(): details: %1", (Object)string);
                if (null != string && string.length() > 0) {
                    String string4 = "";
                    String string5 = "";
                    String string6 = "";
                    StringTokenizer stringTokenizer = new StringTokenizer(string, ":=|");
                    while (stringTokenizer.hasMoreTokens()) {
                        String string7 = stringTokenizer.nextToken().trim();
                        if ("name".equalsIgnoreCase(string7)) {
                            string5 = stringTokenizer.nextToken().trim();
                        }
                        if ("category".equalsIgnoreCase(string7) && stringTokenizer.hasMoreTokens()) {
                            string4 = stringTokenizer.nextToken().trim();
                        }
                        if (!"index".equalsIgnoreCase(string7) || !stringTokenizer.hasMoreTokens()) continue;
                        string6 = stringTokenizer.nextToken().trim();
                    }
                    if (string5.length() > 0 && string4.length() > 0 && string6.length() > 0) {
                        this.getLogDSI().log(-2137614336, "[UotaDSIListener].triggerAction(): name=%1, category=%2, index=%3", (Object)string5, (Object)string4, (Object)string6);
                        this.getSwdlModels().getCustomerUpdateNameLabel().setText(string5);
                        this.getSwdlModels().getCustomerUpdateDeviceLabel().setText(string5);
                        this.getSwdlModels().getCustomerDLProgressTypeChoiceModel().setValue(0);
                        this.getSwdlModels().getDlProgressTypeChoiceModel().setValue(0);
                        this.getUotaController().setPPOIInstalling("ppoi".equalsIgnoreCase(string4));
                        this.getUotaController().setUotaUpdate(true);
                        try {
                            int n4 = Integer.parseInt(string6);
                            this.getUotaController().setNumberOfCurrentUpdatePackage(n4 + 1);
                            this.getSwdlModels().getCustomerSummaryVersionLabel().setText("");
                            this.getSwdlModels().getCurrentDownloadPackageLabelModel().setText(Integer.toString(this.getUotaController().getNumberOfCurrentUpdatePackage()));
                            this.getSwdlModels().getTotalDownloadPackagesLabelModel().setText(Integer.toString(this.getUotaController().getTotalNumberOfUpdatePackages(false)));
                            this.getLogDSI().log(-2137614336, "[UotaDSIListener].triggerAction(): pkg=%1, from=%2", (Object)this.getSwdlModels().getCurrentDownloadPackageLabelModel().getText(), (Object)this.getSwdlModels().getTotalDownloadPackagesLabelModel().getText());
                            this.getUotaController().storeUpdatePackageIdForResctriction(n4);
                        }
                        catch (NumberFormatException numberFormatException) {
                            this.getLogDSI().log(10000, "[UotaDSIListener].triggerAction(): incorrect number format of package index '%1'", (Object)string6);
                        }
                    } else {
                        this.getLogDSI().log(10000, "[UotaDSIListener].triggerAction(): invalid package details: %1", (Object)string);
                    }
                }
            }
        }
    }

    @Override
    public void updatePackagesAvailable(int n, int n2) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- updatePackagesAvailable(%1,%2)", (long)n, (long)n2);
    }

    @Override
    public void featureResult(String string, int n, boolean bl) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- featureResult(%1,%2)", bl, (Object)string);
    }

    @Override
    public void updateServcieReady(int n, boolean bl, int n2) {
        this.getLogDSI().log(-2137614336, "[UotaDSIListener] <- updateServcieReady(%1,%2)", bl, (long)n2);
        if (1 != n2) {
            this.getLogDSI().log(-1601830656, "[UotaDSIListener].updateServcieReady(%1): Service ready updated with invalid flag; ignored", (long)n2);
            return;
        }
        this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
        if (bl) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): UOTA service is ready!");
            if (this.getUotaController().isWaitForPDD()) {
                this.getLogDSI().log(-2137614336, "[UotaDSIListener].updateServcieReady(): the state id wait for PDD, enable OnlineUpdate button!");
                this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
            }
            if (this.getUotaController().isDownloadWaitForConnection() || this.getUotaController().isDownloadActive()) {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): hide popup and wait for download progress!");
                this.getUotaController().hideServerErrorPopup();
                this.getUotaController().setPopupButtonPressed(true);
                if (this.getUotaController().isDownloadActive()) {
                    this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(10);
                }
                this.getUotaController().setDownloadState(2);
                this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
            }
            if (this.getUotaController().isUotaPackagesRequested()) {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): hide popup and start Uota!");
                this.getUotaController().hideServerErrorPopup();
                this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
                this.getUotaController().startUota();
            } else {
                DSIUotA dSIUotA = this.getDSI();
                if (null != dSIUotA) {
                    String string = this.getSwdlEnv().getCurrentHmiLanguage();
                    this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): -> setLanguage(%1)", (Object)string);
                    dSIUotA.setLanguage(string);
                    this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): -> getServerList()");
                    dSIUotA.getServerList();
                } else {
                    this.getLogDSI().log(10000, "[UotaDSIListener].updateServcieReady(): Null DSI; noting to do!");
                }
            }
        } else if (this.getUotaController().isWaitForPDD()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): waiting for PDD, no server connection is needed; disable Online Update button");
            this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(0);
        } else if (this.getUotaController().isUotaPackagesRequested() || this.getUotaController().isUotaSelectionActive() || this.getUotaController().isUotaSysProposalSelectionActive()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): without service it is not possible to get the list of packages or select/deselect a package, show warning pop-up!");
            this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(0);
            this.getUotaController().showServerErrorPopup();
        } else if (this.getUotaController().isServiceReady()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): UOTA service is NOT ready!");
            if (this.getUotaController().isDownloadActive()) {
                this.getUotaController().setDownloadState(11);
                this.getSwdlModels().getDlProgressDlSpeedMetricsModel().setMetric(new ByteSize(0L, 0, false));
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): popup will be shown automatically!");
                this.getUotaController().showServerErrorPopup();
            } else {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].updateServcieReady(): no server connection is needed; disable Online Update button");
            }
            this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(0);
        }
        this.getUotaController().setServiceReady(bl);
    }

    private void handleNoPackagesResult(int n) {
        if (this.getUotaController().isUotaPackagesRequested()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].handleNoPackagesResult(): Update packages are requested by the HMI > show 'access failure' error screen");
            this.getUotaController().setDownloadState(0);
            if (n == 2) {
                this.getUotaController().showNoDataPopup();
            } else {
                this.getUotaController().setReadingMetaDataInfoState(n, -2);
                this.getUotaController().showAccessFailurePopup();
            }
        } else if (this.getUotaController().isDownloadActive()) {
            this.getLogDSI().log(1078071040, "[UotaDSIListener].handleNoPackagesResult(): Update packages not requested by the HMI > show 'no data' pop-up");
            this.getUotaController().setDownloadState(4);
            this.getUotaController().showNoDataPopup();
        }
    }

    @Override
    public void getUpdatePackagesForDestinations(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
        if (!this.getSwdlEnv().isUpdateOverTheAirFeatureEnabled()) {
            this.getLogDSI().log(10000, "[UotaDSIListener].getUpdatePackagesForDestinations(): UOTA is not allowed, ignore this!");
            return;
        }
        this.getLogDSI().log(1078071040, "[UotaDSIListener] <- getUpdatePackagesForDestinations(%1,%2,%3)", (long)n, (long)n2, (long)packageInfoArray.length);
        if (0 == n2) {
            int n3 = this.getSwdlModels().getCustomerProgressStateChoice().getValue();
            if (!this.getUotaController().isUotaUpdateAllowed(false) || n3 != 0 && n3 != 6) {
                this.getLogDSI().log(1078071040, "[UotaDSIListener].getUpdatePackagesForDestinations(): Uota is not allowed now, ignore this.");
                this.getUotaController().resetUotaDestinationRequestState();
                return;
            }
            if (null != packageInfoArray && 0 != packageInfoArray.length && packageInfoArray.length == nArray.length) {
                Object object;
                ArrayList arrayList = new ArrayList(4);
                ArrayList arrayList2 = new ArrayList(4);
                for (int i2 = 0; i2 < packageInfoArray.length; ++i2) {
                    if (0 == (1 & nArray[i2]) || 0 != (2 & nArray[i2]) || ((UotaPkgInfoWrapper)(object = new UotaPkgInfoWrapper(packageInfoArray[i2], nArray[i2], this.getLogUota()))).isSysProposalPackage()) continue;
                    arrayList.add(object);
                    arrayList2.add(packageInfoArray[i2]);
                }
                if (!arrayList.isEmpty()) {
                    UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = new UotaPkgInfoWrapper[arrayList.size()];
                    object = new PackageInfo[arrayList2.size()];
                    int[] nArray2 = new int[arrayList2.size()];
                    for (int i3 = 0; i3 < arrayList.size(); ++i3) {
                        uotaPkgInfoWrapperArray[i3] = (UotaPkgInfoWrapper)arrayList.get(i3);
                        object[i3] = (PackageInfo)arrayList2.get(i3);
                        nArray2[i3] = uotaPkgInfoWrapperArray[i3].getSelectionStatus();
                    }
                    PkgNode pkgNode = new PkgNode(this.getUotaController(), (PackageInfo[])object, nArray2);
                    this.getUotaController().setHierarchyRoot(pkgNode);
                    this.getUotaController().handleNewPackagesResult(pkgNode);
                    if (pkgNode.hasNewPackages(pkgNode)) {
                        this.getUotaController().getSpeedThresholdPopuphandler().requestSysProposalInfoPopup(1, uotaPkgInfoWrapperArray);
                    }
                    return;
                }
                this.getLogDSI().log(10000, "[UotaDSIListener].getUpdatePackagesForDestinations(): the list of selected packages is empty!");
            } else {
                this.getLogDSI().log(-1601830656, "[UotaDSIListener].getUpdatePackagesForDestinations(): Empty list of update packages returned!");
            }
        } else {
            this.getLogDSI().log(10000, "[UotaDSIListener].getUpdatePackagesForDestinations(%1): Error while reading the update packages", (long)n2);
        }
        this.getUotaController().resetUotaDestinationRequestState();
    }

    private BaseUpdateOverTheAirController getUotaController() {
        return this.uotaController;
    }

    private LogChannel getLogUota() {
        return this.getUotaController().getLogUota();
    }

    private LogChannel getLogDSI() {
        return this.getUotaController().getLogDSI();
    }

    private SwdlModels getSwdlModels() {
        return this.getUotaController().getSwdlModels();
    }

    private SwdlEnv getSwdlEnv() {
        return this.getUotaController().getSwdlEnv();
    }

    private DSIUotA getDSI() {
        return this.getUotaController().getDSI();
    }

    @Override
    public void getUpdatePackagesViaApp(int n, int n2, PackageInfo[] packageInfoArray, int[] nArray) {
    }

    @Override
    public void abortDownload(int n, int n2) {
    }

    @Override
    public void customerDownloadFinished(int n, int n2) {
    }
}

