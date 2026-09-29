/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.customer.uota;

import de.audi.atip.hmi.model.ModelGroup;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.hmi.modelaccess.LabelModelApp;
import de.audi.atip.hmi.modelaccess.MetricsModelApp;
import de.audi.atip.i18n.Language;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.ByteSize;
import de.audi.atip.msg.MsgListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.customer.uota.AbstractPkgListRow;
import de.audi.tghu.swdl.app.customer.uota.AsiaMapIntegrationHandler;
import de.audi.tghu.swdl.app.customer.uota.BaseUpdateOverTheAirController$PackageComparator;
import de.audi.tghu.swdl.app.customer.uota.ByteSizeProvider;
import de.audi.tghu.swdl.app.customer.uota.DownloadPackageData;
import de.audi.tghu.swdl.app.customer.uota.GenericPkgRow;
import de.audi.tghu.swdl.app.customer.uota.IPopupListener;
import de.audi.tghu.swdl.app.customer.uota.IgnoredPackagesStorageContainer;
import de.audi.tghu.swdl.app.customer.uota.NaviDataPkgRow;
import de.audi.tghu.swdl.app.customer.uota.PkgNode;
import de.audi.tghu.swdl.app.customer.uota.SysProposalPkgRow;
import de.audi.tghu.swdl.app.customer.uota.UotaDSIListener;
import de.audi.tghu.swdl.app.customer.uota.UotaModelListener;
import de.audi.tghu.swdl.app.customer.uota.UotaPkgInfoWrapper;
import de.audi.tghu.swdl.app.customer.uota.UotaSpeedThresholdHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.uota.DSIUotA;
import org.dsi.ifc.uota.DSIUotAListener;
import org.dsi.ifc.uota.PackageInfo;

public class BaseUpdateOverTheAirController
implements MsgListener,
IPopupListener,
TimerListener {
    public static final int BACKEND_UOTA_SESSION_ID;
    public static final int HMI_UOTA_SESSION_ID;
    public static final int STATE_REQUESTING_PACKAGES;
    public static final int STATE_LEAVING_SWDL;
    public static final int STATE_DOWNLOAD_ERROR;
    public static final int STATE_INSTALL_ACTIVE;
    public static final int STATE_DOWNLOAD_ACTIVE;
    public static final int STATE_DOWNLOAD_WAIT_FOR_PDD;
    public static final int STATE_DOWNLOAD_SELECTION;
    public static final int STATE_DOWNLOAD_NOT_ACTIVE;
    public static final int STATE_SYS_PROPOSAL_POPUP_IS_REQUESTED;
    public static final int STATE_SYS_PROPOSAL_POPUP_SELECTION;
    public static final int STATE_ADDITIONAL_DOWNLOAD_SELECTION;
    public static final int STATE_DOWNLOAD_WAIT_FOR_CONNECTION;
    public static final int STATE_DESTINATION_POPUP_IS_REQUESTED;
    public static final int STATE_DESTINATION_POPUP_SELECTION;
    public static final int STATE_DOWNLOAD_FINISHED;
    public static final int STATE_DOWNLOAD_REQUESTED;
    private static final int PROGRESS_PART_DOWNLOADING;
    private static final int PROGRESS_PART_INSTALLING;
    private static final int PROGRESS_PART_MERGING;
    static final int MAX_SYS_PROPOSAL_PRIO;
    static final int MIN_SYS_PROPOSAL_PRIO;
    static final long TIMEOUT;
    private static final int MAX_NUMBER_OF_PROPOSAL_PACKAGES;
    private static final int FILTER_TYPE_PPOI;
    private static final int FILTER_TYPE_NAVDATA;
    private static final int FILTER_TYPE_NAVDATA_AND_PPOI;
    private static final int FILTER_TYPE_EMPTY;
    static final String[] PACKAGE_TYPE_FILTER_LIST;
    static int PACKAGE_TYPE_INDEX;
    static final int UOTA_MEDIUM_ID;
    static final int PROGRESS_RANGE_MIN_VALUE;
    static final int PROGRESS_RANGE_MAX_VALUE;
    static final int PROGRESS_RANGE_STEP;
    static final int STATE_UPDATE_PACKAGES_READ_OK;
    static final int STATE_UPDATE_PACKAGES_READ_ERROR;
    static final int STATE_UPDATE_PACKAGES_DEFAULT;
    static final int CHOICE_SELECTED;
    static final int CHOICE_NOT_SELECTED;
    private final SwdlEnv swdlEnv;
    private final SwdlModels swdlModels;
    private final LogChannel logUota;
    private final LogChannel logDSI;
    private final DSIUotAListener dsiUotaListener;
    private final AsiaMapIntegrationHandler asiaMapIntegrationHandler;
    private final UotaSpeedThresholdHandler speedThresholdPopuphandler;
    private volatile DSIUotA dsi;
    private volatile String serverName = null;
    private volatile boolean serverNameResponse = false;
    private volatile PkgNode rootNode = null;
    private volatile boolean serviceReady = false;
    private volatile IgnoredPackagesStorageContainer ignoredPkgContainer;
    private volatile boolean isInstallError = false;
    private volatile boolean isLastPackageDownloaded = false;
    private volatile boolean isGuidanceStarted;
    private volatile boolean isSummaryPopupConfirmed = true;
    private volatile boolean isNavPackageSelected = false;
    private volatile boolean isPopupButtonPressed = false;
    private volatile boolean isFirstUotaStateReceived;
    private volatile UotaPkgInfoWrapper[] proposalPackages;
    private volatile UotaPkgInfoWrapper[] downloadPackages;
    private volatile HashMap pkgNodeMapping;
    private volatile int totalNumberOfUpdatePackages = 0;
    private volatile int numberOfCurrentDownloadPackage = 0;
    private volatile boolean isMapIntegrationInProgress = false;
    private volatile boolean isPPOIInstalling = false;
    private volatile boolean isUotaUpdate = false;
    private volatile int numberOfCurrentUpdatePackage = 0;
    private volatile UotaPkgInfoWrapper destinationProposalPkg = null;
    private final HashSet selectedPackages = new HashSet();
    private List waitingForSelectionResponseQueue;
    private volatile long firstSelectableSysProposalListRowId;
    private volatile int lastInstallingProgress = 0;
    private Timer waitAutoSelectionTimer = new Timer("waitAutoSelectionTimer", 0, true, this);
    private Timer waitUotaClientTimer = null;

    public BaseUpdateOverTheAirController(SwdlEnv swdlEnv) {
        this.swdlEnv = swdlEnv;
        this.swdlModels = swdlEnv.getSwdlModels();
        this.logDSI = swdlEnv.getLogDSI();
        this.logUota = swdlEnv.getLogUota();
        this.waitingForSelectionResponseQueue = Collections.synchronizedList(new ArrayList(0));
        this.firstSelectableSysProposalListRowId = -1L;
        if (!this.isUotaEnabled() && !this.getSwdlEnv().isSimulator()) {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].<init>: UOTA feature is disabled!");
            this.dsiUotaListener = null;
            this.speedThresholdPopuphandler = null;
            this.asiaMapIntegrationHandler = !this.getSwdlEnv().isSimulator() && this.getSwdlEnv().isUotaNavDBMergeProcessNeeded() ? new AsiaMapIntegrationHandler(this.logDSI, this) : null;
            this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
            return;
        }
        if (!this.getSwdlEnv().isRebootToDownload()) {
            this.isFirstUotaStateReceived = this.getSwdlModels().getSwdlInProgressChoice().getValue() > 0;
            this.cleanupProgressInfo();
            this.cleanupPackageHierarchy();
            this.dsiUotaListener = new UotaDSIListener(this);
            this.waitUotaClientTimer = new Timer("waitUotaClientTimer", 0, true, this);
            this.waitUotaClientTimer.start();
            this.asiaMapIntegrationHandler = this.getSwdlEnv().isUotaNavDBMergeProcessNeeded() ? new AsiaMapIntegrationHandler(this.logDSI, this) : null;
            int n = swdlEnv.getUotaPackageTypeFilter();
            if (n >= 0 && n < PACKAGE_TYPE_FILTER_LIST.length) {
                PACKAGE_TYPE_INDEX = n;
            } else {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].<init>: incorrect config parameter UOTA_PKG_FILTER=%1, it may be 0..%2", (long)n, (long)(PACKAGE_TYPE_FILTER_LIST.length - 1));
            }
            this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(this.getSwdlEnv().isSimulator() ? 1 : 0);
            new UotaModelListener(this).registerModelListeners();
            this.speedThresholdPopuphandler = new UotaSpeedThresholdHandler(this);
            swdlEnv.registerSpeedThresholdListener(this.speedThresholdPopuphandler, 1);
        } else {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].<init>:  do not initialize Uota because of MMI_STATE_ON_SWDL");
            this.dsiUotaListener = null;
            this.asiaMapIntegrationHandler = null;
            this.speedThresholdPopuphandler = null;
        }
        this.isGuidanceStarted = false;
        this.resetExcludeNavdataPackages();
    }

    final void cleanupPackageHierarchy() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].cleanupPackageHierarchy()");
        this.rootNode = null;
        this.proposalPackages = null;
        this.destinationProposalPkg = null;
        this.pkgNodeMapping = null;
        this.getSwdlModels().getPackagesListModel().removeAll();
        this.getSwdlModels().getNaviCountriesListModel().removeAll();
        this.getSwdlModels().getNaviRegionsListModel().removeAll();
        this.getSwdlModels().getSysProposalListModel().removeAll();
    }

    final void cleanupDownloadPackageData() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].cleanupDownloadPackageData()");
        this.downloadPackages = null;
        this.setTotalNumberOfUpdatePackages(0);
        this.setNumberOfCurrentUpdatePackage(0);
    }

    private void cleanupProgressInfo() {
        if (!this.isMapIntegrationInProgress()) {
            this.getSwdlModels().updateUotaDownloadProgress(0);
        }
        this.getSwdlModels().getDlProgressLabelModel().setText(null);
        this.getSwdlModels().getDlProgressLabelModel().setStatus(1);
    }

    public final void setDSI(DSIUotA dSIUotA) {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].setDSI()");
        if (!this.isUotaEnabled()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].setDSI(): UOTA feature is not enabled!");
            return;
        }
        this.dsi = dSIUotA;
        if (null != dSIUotA) {
            this.waitUotaClientTimer.cancel();
            this.waitUotaClientTimer = null;
            String string = this.getSwdlEnv().getCurrentHmiLanguage();
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].setDSI() -> setLanguage(%1)", (Object)string);
            dSIUotA.setLanguage(string);
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].setDSI() -> setNotifications(): Enabling ATTR_DOWNLOADSTATE, ATTR_DOWNLOADPROGRESS, ATTR_SERVCIEREADY notifications");
            dSIUotA.setNotification(new int[]{1, 2, 4}, (DSIListener)this.dsiUotaListener);
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].setDSI() -> enable final popup confirmation");
            dSIUotA.setFeature("DSIUotA/feature/final-popup-confirmation", true);
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].setDSI() -> enable update package info notification");
            dSIUotA.setFeature("DSIUotA/feature/customer-download-details", true);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].setDSI(): DSIUotA set to null!");
            if (this.isUotaEntered()) {
                this.downloadError(true, false);
            }
            this.serverName = null;
            this.serverNameResponse = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public final void startUota() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].startUota()");
        if (!this.isUotaEnabled()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].startUota(): UOTA is disabled!");
            return;
        }
        this.cancelProcessUotaPackages(true);
        this.getSwdlModels().getCustomerOrOnlineChoiceModel().setValue(1);
        if (this.isDownloadWaitForConnection()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].startUota(): wait for connection, do not restart UOtA!");
            return;
        }
        if (this.isUotaPackagesRequested()) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].startUota(): -> repeat request getUpdatePackages(%1,%2)", (Object)this.serverName, (Object)this.getPackageFilter());
            this.dsi.getUpdatePackages(1, this.serverName, this.getPackageFilter());
            return;
        }
        this.getSpeedThresholdPopuphandler().cleanUpPopupRequests();
        DSIUotAListener dSIUotAListener = this.dsiUotaListener;
        synchronized (dSIUotAListener) {
            this.cleanupPackageHierarchy();
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(10);
            this.setReadingMetaDataInfoState(0, 0);
            DSIUotA dSIUotA = this.getDSI();
            if (null == dSIUotA) {
                this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].startUota(): Null DSIUotA; nothing to do!");
                this.setReadingMetaDataInfoState(3, -2);
                return;
            }
            if (!this.serviceReady) {
                this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].startUota(): Service not ready, cannot enter UOTA!");
                this.setReadingMetaDataInfoState(3, -2);
                return;
            }
            if (this.serverNameResponse && null != this.serverName) {
                this.getSpeedThresholdPopuphandler().cleanUpPopupRequests();
                this.setDownloadState(6);
                this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].startUota(): -> getUpdatePackages(%1,%2)", (Object)this.serverName, (Object)this.getPackageFilter());
                dSIUotA.getUpdatePackages(1, this.serverName, this.getPackageFilter());
            } else {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].startUota(): Null serverName; cannot request the packages list!");
                this.setReadingMetaDataInfoState(3, -2);
            }
        }
    }

    public final boolean equalsDSI(Object object) {
        return object instanceof DSIUotA && object.equals(this.getDSI());
    }

    public final void setLanguage(Language language) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setLanguage(%1)", (Object)language);
        if (!this.isUotaEnabled()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].setLanguage(): UOTA is disabled!");
            return;
        }
        DSIUotA dSIUotA = this.getDSI();
        if (null != dSIUotA) {
            String string = language.getLanguageCode();
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController] -> setLanguage(%1)", (Object)string);
            dSIUotA.setLanguage(string);
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].setLanguage(): Null DSI; nothing to do!");
        }
    }

    public final void resumeUota(int n, boolean bl) {
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray;
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].resumeUota(%2,%1)", bl, (long)n);
        if (!this.isUotaEnabled()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].resumeUota(): UOTA is disabled!");
            return;
        }
        this.isInstallError = n == 1;
        this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(10);
        this.cleanupProgressInfo();
        this.getSwdlModels().getCustomerPreselectedSourceChoice().setValue(0);
        this.getSwdlEnv().getHMISwitcher().getSelectionManager().getSelectionDSIHandler().abortVersionUpload();
        this.getSwdlEnv().getHMISwitcher().releaseSwdlFocus();
        DSIUotA dSIUotA = this.getDSI();
        if (null != dSIUotA) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController] -> customerDownloadFinished(%1,%2)", bl, (long)n);
            dSIUotA.customerDownloadFinished(1, n, bl);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].customerDownloadFinished(): Null DSI; nothing to do!");
        }
        if (this.isInstallError && this.isInstallActive()) {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].resumeUota(): reset download!");
            this.resetUotaState();
            this.getSwdlEnv().getCustomerDLState().leaveCustomerUpdate();
            this.leaveCustomerUpdateContext();
        }
        if (this.getHierarchyRoot() != null && (uotaPkgInfoWrapperArray = this.getHierarchyRoot().getAllPackageInfos()) != null) {
            for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
                if (null == uotaPkgInfoWrapperArray[i2] || !uotaPkgInfoWrapperArray[i2].isSelected()) continue;
                this.getUserIgnoredPackagesContainer().updateLastInstalledReleaseVersion(uotaPkgInfoWrapperArray[i2].getReleaseVersion());
                break;
            }
        }
    }

    private void getSysProposalPackages(UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray, boolean bl) {
        int n;
        this.proposalPackages = null;
        ArrayList arrayList = new ArrayList(uotaPkgInfoWrapperArray.length);
        for (n = 0; n < uotaPkgInfoWrapperArray.length; ++n) {
            if ((!uotaPkgInfoWrapperArray[n].isValid() || !bl || uotaPkgInfoWrapperArray[n].isHidden() || uotaPkgInfoWrapperArray[n].isAutoSelected()) && (bl || !uotaPkgInfoWrapperArray[n].isSelectable())) continue;
            arrayList.add(uotaPkgInfoWrapperArray[n]);
        }
        if (!arrayList.isEmpty()) {
            Object object;
            Collections.sort(arrayList, new BaseUpdateOverTheAirController$PackageComparator(this));
            this.proposalPackages = new UotaPkgInfoWrapper[Math.min(Math.min(this.swdlEnv.getUotaUpdateRegionCount(), 3), arrayList.size())];
            n = 0;
            Object object2 = arrayList.iterator();
            while (object2.hasNext()) {
                object = (UotaPkgInfoWrapper)object2.next();
                if (((UotaPkgInfoWrapper)object).getPriority() >= 1000 && ((UotaPkgInfoWrapper)object).getPriority() <= 2000) {
                    this.proposalPackages[n++] = object;
                    this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages() add to proposal list %1", (Object)((UotaPkgInfoWrapper)object).getDisplayString((byte)1));
                }
                if (n != this.proposalPackages.length) continue;
                break;
            }
            if (n < this.proposalPackages.length) {
                object2 = new UotaPkgInfoWrapper[n];
                for (int i2 = 0; i2 < ((UotaPkgInfoWrapper[])object2).length; ++i2) {
                    object2[i2] = this.proposalPackages[i2];
                }
                this.proposalPackages = object2;
            }
            if (this.swdlEnv.isUotaUpdateRegionCountRestricted() && this.proposalPackages != null && this.proposalPackages.length > 0) {
                this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages(): Check restriction of regions allowed for UOTA.");
                object2 = this.getUserIgnoredPackagesContainer().getPVersionOfInstalledPackages();
                if (!"-1".equals(object2)) {
                    object = this.proposalPackages[0].getReleaseVersion();
                    this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages(): system propose packages of version %1", object);
                    if (((String)object2).equals(object)) {
                        int n2 = this.getUserIgnoredPackagesContainer().getNumberOfInstalledPackages((String)object);
                        if (bl) {
                            this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages(): normalize the list of proposal packages for the Recomended Region screen!");
                            List list = Arrays.asList(this.getUserIgnoredPackagesContainer().getInstalledPackageIDs());
                            ArrayList arrayList2 = new ArrayList(list);
                            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray2 = new UotaPkgInfoWrapper[Math.min(this.swdlEnv.getUotaUpdateRegionCount(), this.proposalPackages.length)];
                            for (int i3 = 0; i3 < uotaPkgInfoWrapperArray2.length; ++i3) {
                                UotaPkgInfoWrapper uotaPkgInfoWrapper = this.proposalPackages[i3];
                                if (arrayList2.contains(uotaPkgInfoWrapper.getPkgId()) && !uotaPkgInfoWrapper.isUpToDate()) {
                                    uotaPkgInfoWrapper.setDisplayAsSelected(true);
                                }
                                uotaPkgInfoWrapperArray2[i3] = uotaPkgInfoWrapper;
                            }
                            this.proposalPackages = uotaPkgInfoWrapperArray2;
                        } else {
                            if (n2 >= this.swdlEnv.getUotaUpdateRegionCount()) {
                                this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages(): allowed number of installed packages is already exceeded, do not show pop-up!");
                                this.proposalPackages = null;
                                return;
                            }
                            ArrayList arrayList3 = new ArrayList();
                            List list = Arrays.asList(this.getUserIgnoredPackagesContainer().getInstalledPackageIDs());
                            ArrayList arrayList4 = new ArrayList(list);
                            for (int i4 = 0; i4 < this.proposalPackages.length; ++i4) {
                                UotaPkgInfoWrapper uotaPkgInfoWrapper = this.proposalPackages[i4];
                                if (arrayList4.contains(uotaPkgInfoWrapper.getPkgId()) || uotaPkgInfoWrapper.isUpToDate()) continue;
                                arrayList3.add(uotaPkgInfoWrapper);
                            }
                            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray3 = new UotaPkgInfoWrapper[Math.min(this.swdlEnv.getUotaUpdateRegionCount() - n2, arrayList3.size())];
                            System.arraycopy((Object)arrayList3.toArray(), 0, (Object)uotaPkgInfoWrapperArray3, 0, uotaPkgInfoWrapperArray3.length);
                            this.proposalPackages = uotaPkgInfoWrapperArray3;
                        }
                    } else if (((String)object2).compareTo((String)object) > 0) {
                        this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].getSysProposalPackages(): Package(s) of a new release is(are) already installed!");
                        this.proposalPackages = null;
                        return;
                    }
                }
                this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].getSysProposalPackages(): A system proposal packages will be shown");
            }
        } else {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].getSysProposalPackages(): No packages to propose!");
        }
    }

    void showSystemProposalPackagesAvailablePopup(UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup()");
        if (!this.isUotaUpdateLicensed()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): Do not show pop-up because Uota isn't licensed!");
            return;
        }
        if (this.isUotaPackagesRequested() || this.isUotaSelectionActive() || !this.isUotaSysProposalPopupRequested()) {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): Uota is entered or no system proposal pop-up requested, ignoring pop-up", (Object)uotaPkgInfoWrapperArray);
            return;
        }
        if (null == uotaPkgInfoWrapperArray || 0 == uotaPkgInfoWrapperArray.length) {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): No new update packages!");
            return;
        }
        IgnoredPackagesStorageContainer ignoredPackagesStorageContainer = this.getUserIgnoredPackagesContainer();
        this.getSysProposalPackages(uotaPkgInfoWrapperArray, false);
        this.handleNewPackagesResult(this.rootNode);
        if (this.isNewProposalPackageAvailable()) {
            if (ignoredPackagesStorageContainer.isReleaseIgnoredByUser(this.proposalPackages[0])) {
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): The release was ignored by user: %1", (Object)this.proposalPackages[0].getReleaseVersion());
                if (this.checkProposalPackagesWithoutLicense()) {
                    this.showNaviUpdateAvailablePopup();
                    return;
                }
                this.cleanupPackageHierarchy();
                this.resetUotaState();
                return;
            }
            if (ignoredPackagesStorageContainer.isHighestReleaseAlreadyIsntalled(this.proposalPackages[0])) {
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): At least one package from this release is already installed per OTA: %1", (Object)this.proposalPackages[0].getReleaseVersion());
                if (this.checkProposalPackagesWithoutLicense()) {
                    this.showNaviUpdateAvailablePopup();
                    return;
                }
                this.cleanupPackageHierarchy();
                this.resetUotaState();
                return;
            }
            this.showNaviUpdateAvailablePopup();
        } else if (this.checkProposalPackagesWithoutLicense()) {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): show new release without lizense pup-up.");
            this.showNaviUpdateAvailablePopup();
        } else {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): Could not find a valid update package to show pop-ups!");
            this.resetUotaState();
            this.cleanupPackageHierarchy();
        }
    }

    void showDestinationProposalPackagesAvailablePopup(UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].showDestinationProposalPackagesAvailablePopup()");
        this.destinationProposalPkg = null;
        long l = 0L;
        long l2 = 0L;
        long l3 = 0L;
        if (!this.isUotaUpdateLicensed()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].showSystemProposalPackagesAvailablePopup(): Do not show pop-up because Uota isn't licensed!");
            return;
        }
        for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
            if (uotaPkgInfoWrapperArray[i2].getType() == 0) {
                if (!this.getUserIgnoredPackagesContainer().isUpdatePackageIgnoredByUser(uotaPkgInfoWrapperArray[i2])) {
                    this.destinationProposalPkg = uotaPkgInfoWrapperArray[i2];
                    l3 = uotaPkgInfoWrapperArray[i2].getSize();
                    l += l3;
                    this.addSelectedPackage(i2);
                    continue;
                }
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController]: package %1 version %2 is ignored by user!", (Object)uotaPkgInfoWrapperArray[i2].getLastName(), (Object)uotaPkgInfoWrapperArray[i2].getDisplayString((byte)0));
                continue;
            }
            l2 += uotaPkgInfoWrapperArray[i2].getSize();
            l += uotaPkgInfoWrapperArray[i2].getSize();
            this.addSelectedPackage(i2);
        }
        if (this.destinationProposalPkg != null && l3 != 0L) {
            this.getSwdlModels().getUotaDestinationComponentLabelModel().setText(this.destinationProposalPkg.getLastName());
            this.getSwdlModels().getConfirmDlSizeMetricsModel().setMetric(ByteSizeProvider.getByteSize(l));
            this.getSwdlModels().getDestinationPkgSizeMetricsModel().setMetric(ByteSizeProvider.getByteSize(l3));
            this.setRequiredPackageSize(l2);
            this.getSwdlModels().getNaviPopupLicenseNewVersionLabelModel().setText(this.destinationProposalPkg.getDisplayVersion(0));
            this.showUpdateDestinationPopup();
            this.setDownloadState(13);
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showDestinationProposalPackagesAvailablePopup(): no valid business packge found!");
            this.destinationProposalPkg = null;
            this.cleanupDownloadPackageNumbers();
            this.setDownloadState(0);
            this.cleanupPackageHierarchy();
        }
    }

    boolean isUotaUpdateAllowed(boolean bl) {
        if (!(this.getSwdlEnv().isRebootToDownload() || this.getSwdlEnv().isEngineeringDownloadActive() || this.getSwdlEnv().isResetDriverActiv())) {
            if (bl && !this.isServiceReady()) {
                return false;
            }
            return this.getSwdlModels().getCustDlDisabledChoice(0).getValue() == 0;
        }
        return false;
    }

    boolean isUotaUpdateLicensed() {
        return !this.getSwdlEnv().isUotaLecensingAlowed() || this.getSwdlModels().getNaviUpdateLicensedModel().getValue() > 0;
    }

    private void showNaviUpdateAvailablePopup() {
        this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].showNaviUpdateAvailablePopup(): suggest %1 region(s)", (long)this.proposalPackages.length);
        if (null != this.proposalPackages && this.proposalPackages.length > 0) {
            this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(10);
            if (this.proposalPackages[0].isLicenseAvailable()) {
                this.getSwdlModels().getNaviPopupLicenseNewVersionLabelModel().setText(this.proposalPackages[0].getDisplayVersion(0));
                this.showNewNaviUpdateAvailableWithLicensePopup();
            } else if (this.getSwdlEnv().showUotaSysProposalWithoutLicense()) {
                this.getSwdlModels().getNaviPopupNoLicenseNewVersionLabelModel().setText(this.proposalPackages[0].getDisplayVersion(0));
                this.showNewNaviUpdateAvailableNoLicensePopup();
            } else {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].showNaviUpdateAvailablePopup(): showing of proposal packages without license isn't allowed.");
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showNaviUpdateAvailablePopup(): no proposal packages are available");
        }
    }

    void ignoreUpdatesAvailablePopup(boolean bl) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].ignoreUpdatesAvailablePopup(cleanup=%1)", bl);
        if (this.isUotaDestinationSelectionActive()) {
            this.storeDestinationPackage();
        } else if (this.isNavPackageSelected || bl) {
            this.getLogUota().log(-2137614336, "ignoreUpdatesAvailablePopup(): no navDB packages selected and no proposal pop-ups was displayed, do not store ignore version", bl);
            this.storeProposalPackageRelease();
            this.isNavPackageSelected = false;
        }
        if (bl) {
            this.cleanupPackageHierarchy();
            this.setDownloadState(0);
        }
    }

    void getSwdlSourcePath() {
        DSIUotA dSIUotA;
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].getSwdlSourcePath()");
        if (!this.isUotaEnabled()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].getSwdlSourcePath(): UOTA is disabled!");
        }
        if (null != (dSIUotA = this.getDSI())) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].getSwdlSourcePath() -> getAttribute(%1)", 1L);
            dSIUotA.getAttribute(1, 1);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].getSwdlSourcePath(): Null DSI; noting to do!");
        }
    }

    final void setDownloadState(int n) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setDownloadState(%1)", (long)n);
        if (2 == n && 2 != this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue()) {
            if (3 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue()) {
                this.storeLastInstallingProgress();
            }
            if (this.isServiceReady()) {
                if (14 != this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue() && 3 != this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue()) {
                    this.showSourceConfirmationPopup();
                }
            } else {
                this.getSwdlModels().getDlProgressTypeChoiceModel().setValue(4);
                this.getSwdlModels().getCustomerSelectionSourceChoice().setValue(10);
            }
        }
        this.getSwdlModels().getOnlineUpdateStateChoiceModel().setValue(n);
    }

    public final void resetUotaState() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].resetUotaState()");
        if (!this.isLeavingSWDL()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].resetUotaState(): Unexpected reset of state!");
        }
        this.setDownloadState(0);
    }

    final void resetUotaDestinationRequestState() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].resetUotaDestinationRequestState()");
        if (this.isUotaDestinationPopupRequested()) {
            this.setDownloadState(0);
        }
    }

    final void resetUotaPackagesRequestState() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].resetUotaRequestState()");
        if (this.isUotaPackagesRequested()) {
            this.setDownloadState(0);
        }
    }

    public final void cancelProcessUotaPackages(boolean bl) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].cancelProcessUotaPackages(%1)", bl);
        UotaPkgInfoWrapper.cancelProcessPackages(bl);
    }

    void setReadingMetaDataInfoState(int n, int n2) {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].setReadingMetaDataInfoState(%1,%2)", (long)n, (long)n2);
        ChoiceModelApp choiceModelApp = this.getSwdlModels().getCustomerReadingMetaInfoStateChoice();
        ModelGroup modelGroup = new ModelGroup();
        modelGroup.add(choiceModelApp);
        choiceModelApp.setStatus(n);
        choiceModelApp.setValue(n2);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    void startDownload() {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].startDownload()");
        if (!(this.isUotaSelectionActive() || this.isUotaSysProposalSelectionActive() || this.isUotaDestinationSelectionActive())) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].startDownload(): UOTA not in expected state (expected STATE_DOWNLOAD_SELECTION, actual %1)!", (long)this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue());
            return;
        }
        this.cleanupProgressInfo();
        DSIUotA dSIUotA = this.getDSI();
        if (null != dSIUotA) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController] -> startDownload(%1)", 1L);
            this.setDownloadState(15);
            dSIUotA.startDownload(1);
            this.ignoreUpdatesAvailablePopup(false);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].startDownload(): Null DSI; noting to do!");
        }
    }

    void restartDownload() {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].restartDownload()");
        if (!this.isUotaError()) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].restartDownload(): UOTA not in expected state (expected STATE_DOWNLOAD_ERROR, actual %1)!", (long)this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue());
            return;
        }
        DSIUotA dSIUotA = this.getDSI();
        if (null != dSIUotA) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].restartDownload() -> triggerAction(%1, ACTION_RESTART_DOWNLOAD, null)", 1L);
            dSIUotA.triggerAction(1, 2, null);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].restartDownload(): Null DSI; noting to do!");
        }
    }

    void abortDownload() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].abortDownload()");
        if (!(this.isDownloadActive() || this.isUotaError() || this.isDownloadWaitForConnection() || this.isWaitForPDD() || this.isUotaDestinationPopupRequested())) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].abortDownload(): UOTA state not in (STATE_DOWNLOAD_ACTIVE, STATE_DOWNLOAD_ERROR), actual %1)!", (long)this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue());
            this.cleanupPackageHierarchy();
            this.cleanupDownloadPackageNumbers();
            this.resetUotaState();
            return;
        }
        this.abortUotaSequence();
    }

    public void abortUotaSequence() {
        DSIUotA dSIUotA = this.getDSI();
        if (null != dSIUotA) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController] -> abortUotaSequence()");
            this.cleanupPackageHierarchy();
            this.cleanupDownloadPackageNumbers();
            dSIUotA.abortDownload(1);
        } else {
            this.getLogDSI().log(10000, "[BaseUpdateOverTheAirController].abortUotaSequence(): Null DSI; noting to do!");
        }
    }

    void downloadFinished(String string) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].downloadFinished(%1)", (Object)string);
        if (null != string) {
            this.setDownloadState(3);
            this.getSwdlModels().updateCustomerProgress(this.installingProgress2CrossProgress(0));
            if (this.getSwdlEnv().isSimulator()) {
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].downloadFinished(): !Simulation! starting installing downloaded packages from MEDIUM_SD_2!");
                this.getSwdlEnv().getHMISwitcher().getSelectionManager().preSelectSourceMedium(5);
            } else if (this.getSwdlEnv().getHMISwitcher().getSelectionManager().getSelectionDSIHandler() != null) {
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].downloadFinished(): Starting installing downloaded packages from MEDIUM_OTA!");
                this.getSwdlEnv().getHMISwitcher().getSelectionManager().getSelectionDSIHandler().doStoreFsPath(string);
                this.getSwdlEnv().getHMISwitcher().initCustomerUpdate(7, false, this.getSwdlEnv().getTerminalId());
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].downloadFinished(): Failed to get the SWDL source path; cannot trigger install");
            this.downloadError(true, false);
        }
    }

    void downloadError(boolean bl, boolean bl2) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].downloadError(%1)", bl);
        if (!this.isDownloadActive()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].downloadError(%1): State changed to error while not downloading - ignored", bl);
            return;
        }
        this.setDownloadState(4);
        if (bl) {
            this.showDownloadErrorPopup(bl2);
        }
    }

    void storeLastInstallingProgress() {
        this.lastInstallingProgress = this.getSwdlModels().getCustomerProgressRange().getValue();
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].storeLastInstallingProgress(): %1", (long)this.lastInstallingProgress);
    }

    int getStoredInstallingProgress() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].getStoredInstallingProgress(): %1", (long)this.lastInstallingProgress);
        int n = this.lastInstallingProgress;
        this.lastInstallingProgress = 0;
        return n;
    }

    private final boolean isUotaUpdate() {
        if (this.isUotaUpdate) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].isUotaUpdate(): true");
            return true;
        }
        String string = this.getSwdlEnv().getStorageManager().getString(257, 5003, "0");
        try {
            int n = Integer.parseInt(string);
            boolean bl = 7 == n || 10 == n;
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].isUotaUpdate(): %1", bl);
            return bl;
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
    }

    private final boolean isNavDBUpdate() {
        return 1 == this.getSwdlEnv().getStorageManager().getInt(257, 4, 0);
    }

    public final int installingProgress2CrossProgress(int n) {
        return this.updateProgress2CrossProgress(n, 1, this.getNumberOfCurrentUpdatePackage(), this.getTotalNumberOfUpdatePackages(true));
    }

    private final int mapIntegrationProgress2CrossProgress(int n) {
        return this.updateProgress2CrossProgress(n, 2, 0, 0);
    }

    final int downloadProgress2CrossProgress(int n, int n2) {
        return this.updateProgress2CrossProgress(n, 0, n2 + 1, this.getTotalNumberOfUpdatePackages(true));
    }

    final int downloadProgress2CrossProgress(int n) {
        return this.downloadProgress2CrossProgress(n, this.getNumberOfCurrentDownloadPackage());
    }

    private final int updateProgress2CrossProgress(int n, int n2, int n3, int n4) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].packageProgress2CrossProgress(prog=%1,part=%2,pkg=%3)", (long)n, (long)n2, (long)n3);
        float f2 = n;
        if (n2 >= 0 && n2 <= 2) {
            float f3 = this.getSwdlEnv().getUotaProgressDownloadPartPercentage();
            float f4 = this.getSwdlEnv().getUotaProgressMapintegrationPartPercentage();
            int n5 = 51266 - f3 - f4;
            if (this.isPPOIUpdate(n3 - 1)) {
                if (this.isUotaUpdate()) {
                    switch (n2) {
                        case 0: {
                            float f5 = f3 / 51266;
                            f2 *= f5;
                            break;
                        }
                        case 1: {
                            float f6 = (f4 + n5) / 51266;
                            f2 *= f6;
                            break;
                        }
                        default: {
                            break;
                        }
                    }
                }
            } else if (!this.isUotaUpdate() || n3 > 0 && n3 <= n4 || 2 == n2) {
                switch (n2) {
                    case 0: {
                        float f7 = f3 / (float)n4 / 51266;
                        f2 = f2 * f7 + (float)(n3 - 1) * (f3 / (float)n4);
                        break;
                    }
                    case 1: {
                        if (!this.isNavDBUpdate()) {
                            f4 = 0.0f;
                        }
                        if (!this.isUotaUpdate()) {
                            return n;
                        }
                        int n6 = n5 / (float)n4 / 51266;
                        f2 = f2 * n6 + (float)(n3 - 1) * (n5 / (float)n4);
                        if (!this.isUotaUpdate()) break;
                        f2 += f3;
                        break;
                    }
                    case 2: {
                        if (!this.isUotaUpdate()) {
                            return n;
                        }
                        float f8 = f4 / 51266;
                        f2 = f2 * f8 + (51266 - f4);
                        break;
                    }
                }
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].packageProgress2CrossProgress(): unsupported customer update progress part", (long)n, (long)n2);
        }
        return Math.round(f2);
    }

    void updateDownloadProgress(boolean bl, String string, int n, int n2) {
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray;
        this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].updateDownloadProgress(%1,%2,type=%3)", bl, (Object)Integer.toString(n), (Object)Integer.toString(n2));
        LabelModelApp labelModelApp = this.getSwdlModels().getDlProgressLabelModel();
        if (bl) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Connection lost!");
            labelModelApp.setStatus(2);
            return;
        }
        PkgNode pkgNode = this.rootNode;
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray2 = uotaPkgInfoWrapperArray = null != pkgNode ? pkgNode.getAllPackageInfos() : null;
        if (null == uotaPkgInfoWrapperArray && !this.isDownloadActive() && !this.isWaitForPDD()) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Left download progress!");
            return;
        }
        long l = -1L;
        switch (n2) {
            case 1: {
                int n3;
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Download progress not localized: type = %2, info = %1", (Object)string, (long)n2);
                try {
                    int n4 = string.lastIndexOf(124);
                    n3 = string.indexOf(61);
                    int n5 = string.indexOf(61, n4);
                    int n6 = 1;
                    if (n4 < 0) {
                        l = 0;
                        if (n3 > 0) {
                            n6 = Integer.parseInt(string.substring(n3 + 1).trim());
                            this.setNumberOfCurrentDownloadPackage(n6);
                            this.getSwdlModels().getCurrentDownloadPackageLabelModel().setText(Integer.toString(n6 + 1));
                        }
                    } else if (n3 > 0 && n4 > n3 && n5 > n4) {
                        l = Long.parseLong(string.substring(n5 + 1));
                        n6 = Integer.parseInt(string.substring(n3 + 1, n4));
                        this.setNumberOfCurrentDownloadPackage(n6);
                        this.getSwdlModels().getCurrentDownloadPackageLabelModel().setText(Integer.toString(n6 + 1));
                    } else {
                        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Unexpected progress text format for download (%1)", (Object)string);
                        n2 = 0;
                        break;
                    }
                    this.isLastPackageDownloaded = this.totalNumberOfUpdatePackages == n6 + 1 && 100 == n;
                    string = "";
                    n = this.downloadProgress2CrossProgress(n, n6);
                }
                catch (NumberFormatException numberFormatException) {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Failed to parse download speed (%1)", (Object)string);
                    n2 = 0;
                    break;
                }
                this.getSwdlEnv().setCustProgressIconVisible(true);
                break;
            }
            case 3: 
            case 4: 
            case 5: {
                if (!this.isWaitForPDD()) {
                    this.getSwdlEnv().setCustProgressIconVisible(true);
                }
            }
            case 2: {
                int n3;
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Progress not localized: type = %2, info = %1", (Object)string, (long)n2);
                if (this.isWaitForPDD()) {
                    if (n < 0) break;
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].updateDownloadProgress(): ignore set process text because of WAIT_FOR_PDD");
                    n2 = 6;
                    break;
                }
                try {
                    int n7 = string.indexOf(61);
                    if (n7 <= 0) {
                        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Failed to parse packageIndex (%1)", (Object)string);
                        n2 = 0;
                        break;
                    }
                    string = string.substring(n7 + 1);
                    n3 = Integer.parseInt(string);
                    n = this.downloadProgress2CrossProgress(n, n3);
                    this.isLastPackageDownloaded = this.totalNumberOfUpdatePackages == n3 + 1 && n2 != 4;
                    this.setNumberOfCurrentDownloadPackage(n3);
                    this.getSwdlModels().getCurrentDownloadPackageLabelModel().setText(Integer.toString(n3 + 1));
                    String[] stringArray = null;
                    if (null != this.downloadPackages && 0 != this.downloadPackages.length) {
                        stringArray = this.downloadPackages[n3].getUniqueNames();
                    }
                    if (null == stringArray || 0 == stringArray.length) {
                        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Missing hierarchy info for pkg index %1", (long)n3);
                        n2 = 0;
                        break;
                    }
                    string = this.downloadPackages[n3].getLastName();
                }
                catch (NumberFormatException numberFormatException) {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Failed to parse packageIndex (%1)", (Object)string);
                    n2 = 0;
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Invalid packageIndex (%1)", (Object)string);
                    n2 = 0;
                }
                break;
            }
            case 0: {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Progress already localized: %1", (Object)string);
                break;
            }
            default: {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Unknown progress type: %1", (long)n2);
                n2 = 0;
            }
        }
        ModelGroup modelGroup = new ModelGroup();
        ChoiceModelApp choiceModelApp = this.getSwdlModels().getDlProgressTypeChoiceModel();
        modelGroup.add(labelModelApp);
        modelGroup.add(choiceModelApp);
        if (0L <= l && 1 == n2) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].updateDownloadProgress(): Set current download speed to %1 bytes/s", l);
            this.setDownloadSpeed(modelGroup, l);
        }
        this.getSwdlModels().updateUotaDownloadProgress(n);
        labelModelApp.setStatus(1);
        labelModelApp.setText(string);
        choiceModelApp.setValue(n2);
        modelGroup.flush();
        modelGroup.removeAll();
    }

    private void clearDownloadSize() {
        this.getSwdlModels().getConfirmDlSizeMetricsModel().setMetric(ByteSizeProvider.getByteSize(0L));
        this.setRequiredPackageSize(0L);
    }

    void calculateAndSetDownloadSize() {
        MetricsModelApp metricsModelApp = this.getSwdlModels().getConfirmDlSizeMetricsModel();
        MetricsModelApp metricsModelApp2 = this.getSwdlModels().getRequiredPackageSizeMetricsModel();
        this.clearDownloadSize();
        long l = this.rootNode.getSize();
        long l2 = this.rootNode.calqulateRequiredPackagesSize();
        metricsModelApp.setStatus(0);
        metricsModelApp2.setStatus(0);
        if (0L < l) {
            if (this.getLogUota().isDebug()) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].calculateAndSetDownloadSize(): Calculated download size: %1[%2] bytes", l, l2);
            }
            metricsModelApp.setMetric(ByteSizeProvider.getByteSize(l));
            metricsModelApp.setStatus(1);
            this.setRequiredPackageSize(l2);
        } else {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].calculateAndSetDownloadSize(): Calculated download size is 0 bytes!");
        }
        metricsModelApp2.setStatus(1);
        metricsModelApp.setStatus(1);
    }

    protected void handleNewPackagesResult(PkgNode pkgNode) {
        if (this.isDownloadActive()) {
            this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].handleNewPackagesResult(): UOTA download is active, package hierarchy is not needed");
            return;
        }
        if (!(this.isUotaPackagesRequested() || this.isUotaSysProposalPopupRequested() || this.isUotaDestinationPopupRequested())) {
            this.getLogUota().log(-1601830656, "[BaseUpdateOverTheAirController].handleNewPackagesResult(): UOTA screens entered, but packages were not requested by HMI - ignoring response!");
            return;
        }
        this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].handleNewPackagesResult(): received the requested new packages > creating the package hierarchy");
        this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(0);
        this.buildPkgHierarchy();
        if (!this.checkNewPackages()) {
            this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
            return;
        }
        if (this.getSwdlEnv().isUotaUpdateRegionCountRestricted() && this.isNewRelease()) {
            this.getUserIgnoredPackagesContainer().updateInstalledPackageIds("");
        }
        if (!this.isUotaSysProposalPopupRequested()) {
            this.setDownloadState(1);
            this.getSysProposalPackages(pkgNode.getAllPackageInfos(), true);
        } else {
            this.setDownloadState(9);
        }
        if (pkgNode.isHierarchyBuilt()) {
            if (this.isUotaSysProposalPopupRequested()) {
                this.buildSysProposalRows();
            } else {
                if (!pkgNode.buildRows(true)) {
                    if (this.isUotaSelectionActive()) {
                        this.showNoDataPopup();
                    }
                    this.resetUotaState();
                    this.cleanupPackageHierarchy();
                    this.setReadingMetaDataInfoState(3, -2);
                    this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
                    return;
                }
                this.getSwdlModels().getStartDownloadButtonModel().setStatus(this.getHierarchyRoot().getSelectedCount() > 0 ? 1 : 0);
                this.setReadingMetaDataInfoState(1, 2);
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].handleNewPackagesResult(): Failed to build the package hierarchy!");
            this.setReadingMetaDataInfoState(2, -2);
        }
        this.getSwdlModels().getOnlineUpdateAvailableChoiceModel().setValue(1);
    }

    void buildDownloadPackages(PackageInfo[] packageInfoArray) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].buildDownloadPackages(): build %1 download packages", (long)packageInfoArray.length);
        if (packageInfoArray != null && packageInfoArray.length > 0) {
            this.downloadPackages = new UotaPkgInfoWrapper[packageInfoArray.length];
            for (int i2 = 0; i2 < packageInfoArray.length; ++i2) {
                this.downloadPackages[i2] = new UotaPkgInfoWrapper(packageInfoArray[i2], 1, this.logUota);
                if (!this.isPackageSizeHidden()) continue;
                this.downloadPackages[i2].setHidePackageSize();
            }
        }
    }

    void storeUpdatePackageIdForResctriction(int n) {
        if (this.getSwdlEnv().isUotaUpdateRegionCountRestricted()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].storeUpdatePackageIdForResctriction(%1)", (long)n);
            if (null != this.downloadPackages) {
                if (n < this.downloadPackages.length) {
                    UotaPkgInfoWrapper uotaPkgInfoWrapper = this.downloadPackages[n];
                    if (null != uotaPkgInfoWrapper) {
                        if (uotaPkgInfoWrapper.isRestrictionAllowed()) {
                            this.getUserIgnoredPackagesContainer().updateInstalledPackageIds(uotaPkgInfoWrapper.getPkgId());
                        }
                    } else {
                        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].storeUpdatePackageIdForResctriction(): package with index=%1 is null!", (long)n);
                    }
                } else {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].storeUpdatePackageIdForResctriction(): incorrect package index %1, only %2 package(s) is(are) available!", (long)n, (long)this.downloadPackages.length);
                }
            } else {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].storeUpdatePackageIdForResctriction(): no download packages are available!");
            }
        }
    }

    boolean isPackageSizeHidden() {
        return this.swdlEnv.isUotaUpdateRegionCountRestricted();
    }

    void buildPkgHierarchy() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].buildPkgHierarchy()");
        try {
            for (int i2 = 0; i2 < this.rootNode.getAllPackageInfos().length; ++i2) {
                this.rootNode.addPkg(i2);
            }
            this.rootNode.setTogglingState();
            if (this.getLogUota().isDebug2()) {
                this.rootNode.dumpState();
            }
        }
        catch (Exception exception) {
            this.cleanupPackageHierarchy();
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].buildPkgHierarchy(): Failed to create pkg hierarchy!", (Throwable)exception);
        }
    }

    private boolean checkNewPackages() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].checkNewPackages()");
        if (!this.rootNode.hasNewPackages(this.rootNode)) {
            if (this.isUotaPackagesRequested() && this.rootNode.hasAnyPackages(this.rootNode)) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].checkNewPackages(): No new packages found, but at least one up to date package is available!");
                return true;
            }
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].checkNewPackages(): No new packages found!");
            this.setDownloadState(0);
            return false;
        }
        return true;
    }

    private boolean isNewRelease() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].checkNewRelease()");
        if (null == this.rootNode) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].checkNewRelease(): Missing root node!");
        } else {
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray;
            String string = this.getUserIgnoredPackagesContainer().getPVersionOfInstalledPackages();
            if (!"-1".equals(string) && null != (uotaPkgInfoWrapperArray = this.rootNode.getAllPackageInfos())) {
                for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
                    if (!uotaPkgInfoWrapperArray[i2].isLicenseAvailable() || uotaPkgInfoWrapperArray[i2].isPPOI() || uotaPkgInfoWrapperArray[i2].isSystemPackage() || uotaPkgInfoWrapperArray[i2].isHidden() || "INVALID".equals(uotaPkgInfoWrapperArray[i2].getReleaseVersion()) || string.compareTo(uotaPkgInfoWrapperArray[i2].getReleaseVersion()) >= 0) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private int getNumberOfAlreadySelectedBusinessPackages() {
        int n = 0;
        if (null == this.rootNode) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].getNumberOfAlreadySelectedBusinessPackages(): Missing root node!");
            return n;
        }
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.rootNode.getAllPackageInfos();
        if (null != uotaPkgInfoWrapperArray) {
            Iterator iterator = this.selectedPackages.iterator();
            while (iterator.hasNext()) {
                UotaPkgInfoWrapper uotaPkgInfoWrapper;
                Integer n2 = (Integer)iterator.next();
                if (null == n2 || null == (uotaPkgInfoWrapper = uotaPkgInfoWrapperArray[n2]) || !uotaPkgInfoWrapper.isSelected() || !uotaPkgInfoWrapper.isRestrictionAllowed()) continue;
                ++n;
            }
        }
        return n;
    }

    private String getReleaseVersionOfAlreadySelectedPackages() {
        String string = "-1";
        if (null == this.rootNode) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].getReleaseVersionOfAlreadySelectedPackages(): Missing root node!");
            return string;
        }
        UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.rootNode.getAllPackageInfos();
        if (null != uotaPkgInfoWrapperArray) {
            Iterator iterator = this.selectedPackages.iterator();
            while (iterator.hasNext()) {
                UotaPkgInfoWrapper uotaPkgInfoWrapper;
                Integer n = (Integer)iterator.next();
                if (null == n || null == (uotaPkgInfoWrapper = uotaPkgInfoWrapperArray[n]) || !uotaPkgInfoWrapper.isRestrictionAllowed()) continue;
                string = uotaPkgInfoWrapper.getReleaseVersion();
                break;
            }
        }
        return string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void buildSysProposalRows() {
        this.waitingForSelectionResponseQueue.clear();
        this.firstSelectableSysProposalListRowId = -1L;
        if (null != this.proposalPackages && this.proposalPackages.length > 0 && null != this.pkgNodeMapping) {
            Object object;
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].buildSysProposalRows()");
            BaseListModelApp baseListModelApp = this.getSwdlModels().getSysProposalListModel();
            baseListModelApp.setStatus(0);
            baseListModelApp.removeAll();
            int n = -129;
            int n2 = this.getNumberOfAlreadySelectedBusinessPackages();
            if (this.swdlEnv.isUotaUpdateRegionCountRestricted()) {
                n = this.swdlEnv.getUotaUpdateRegionCount() - n2 - this.getUserIgnoredPackagesContainer().getNumberOfInstalledPackages(this.proposalPackages[0].getReleaseVersion());
            }
            for (int i2 = 0; i2 < this.proposalPackages.length; ++i2) {
                object = (PkgNode)this.pkgNodeMapping.get(this.proposalPackages[i2].getPkgId());
                if (null == object) continue;
                if (n <= 0) {
                    if (((PkgNode)object).isSelected() && n2 > 0) {
                        ((PkgNode)object).setAllowedForSelection(true);
                    } else {
                        ((PkgNode)object).setAllowedForSelection(false);
                    }
                } else if (this.swdlEnv.preselectUOTASysProposals() && !((PkgNode)object).isSelected() && ((PkgNode)object).isSelectable()) {
                    this.waitingForSelectionResponseQueue.add(new Integer(((PkgNode)object).getIndex()));
                }
                AbstractPkgListRow abstractPkgListRow = ((PkgNode)object).getSysProposalRow();
                if (null != abstractPkgListRow) {
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].buildSysProposalRows() - Adding row to Proposal List: %1", (Object)abstractPkgListRow);
                    baseListModelApp.append(abstractPkgListRow);
                    if (this.getSwdlEnv().preselectUOTASysProposals() && this.firstSelectableSysProposalListRowId == -1L && ((PkgNode)object).isSelectable()) {
                        this.firstSelectableSysProposalListRowId = abstractPkgListRow.getUniqueID();
                    }
                }
                if (!((PkgNode)object).isSelectable()) continue;
                --n;
            }
            this.setRequiredPackageSize(0L);
            if (!this.waitingForSelectionResponseQueue.isEmpty()) {
                if (null != this.dsi) {
                    List list = this.waitingForSelectionResponseQueue;
                    synchronized (list) {
                        object = this.waitingForSelectionResponseQueue.iterator();
                        while (object.hasNext()) {
                            int n3 = (Integer)object.next();
                            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].buildSysProposalRows():  -> toggleSelection(%1)", (long)n3);
                            this.dsi.toggleSelection(1, n3);
                        }
                    }
                    this.waitAutoSelectionTimer.restart();
                }
            } else {
                baseListModelApp.setStatus(1);
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].buildSysProposalRows(): list of sys proposal packages is empty");
        }
    }

    private void setRequiredPackageSize(long l) {
        if (l < 0L) {
            l = 0L;
        }
        this.getSwdlModels().getRequiredPackageSizeMetricsModel().setMetric(ByteSizeProvider.getByteSize(l));
        this.getSwdlModels().getRequiredPackagesCheckboxChoiceModel().setValue(l > 0L ? 1 : 0);
    }

    void setBaseListsStatus(int n) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setBaseListsStatus(%1)", (long)n);
        this.getSwdlModels().getPackagesListModel().setStatus(n);
        this.getSwdlModels().getNaviCountriesListModel().setStatus(n);
        this.getSwdlModels().getNaviRegionsListModel().setStatus(n);
        this.getSwdlModels().getSysProposalListModel().setStatus(n);
    }

    protected void packageSelected(AbstractPkgListRow abstractPkgListRow, BaseListModelApp baseListModelApp, int n) {
        if (null != abstractPkgListRow) {
            int n2 = abstractPkgListRow.getPkgIndex();
            if (abstractPkgListRow.isPkgGroup()) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].packageSelected(%1): Group selected; trigger list event!", (long)n2);
                PkgNode pkgNode = abstractPkgListRow.getNode();
                boolean bl = true;
                if (abstractPkgListRow instanceof GenericPkgRow) {
                    boolean bl2 = ((GenericPkgRow)abstractPkgListRow).isSystemPackage();
                    this.getLogDSI().log(-2137614336, "[BaseUOTAChoiceListener].itemSelected(): System package: %1", bl2);
                    this.getSwdlModels().isSystemPackageSelectedChoiceModel().setValue(bl2 ? 1 : 0);
                    if (!bl2) {
                        if (this.swdlEnv.isUotaUpdateRegionCountRestricted()) {
                            String string = pkgNode.getPackageInfo() != null ? pkgNode.getPackageInfo().getReleaseVersion() : "";
                            bl = this.swdlEnv.getUotaUpdateRegionCount() - this.getNumberOfAlreadySelectedBusinessPackages() - this.getUserIgnoredPackagesContainer().getNumberOfInstalledPackages(string) > 0;
                        }
                        this.buildSysProposalRows();
                    }
                } else {
                    this.getSwdlModels().isSystemPackageSelectedChoiceModel().setValue(0);
                }
                pkgNode.buildRows(bl);
                this.toggleSelection(null);
                baseListModelApp.fireEvent(n);
            } else {
                if (!abstractPkgListRow.isSelectable() || !abstractPkgListRow.getNode().isAllowedForSelection()) {
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].packageSelected(%1): Ignoring selection event for non-selectable package!", (long)n2);
                    return;
                }
                DSIUotA dSIUotA = this.getDSI();
                if (null != dSIUotA) {
                    this.setBaseListsStatus(0);
                    this.getLogDSI().log(1078071040, "[BaseUpdateOverTheAirController].packageSelected(): preselect -> toggleSelection(%1)", (long)n2);
                    dSIUotA.toggleSelection(1, n2);
                } else {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].packageSelected(): Null DSI, nothing to do!");
                }
            }
        }
    }

    void toggleRowSelection(AbstractPkgListRow abstractPkgListRow) {
        int[] nArray;
        PkgNode pkgNode;
        if (null != abstractPkgListRow && null != (pkgNode = abstractPkgListRow.getNode().getParent()) && null != (nArray = pkgNode.getToggleList())) {
            DSIUotA dSIUotA = this.getDSI();
            if (null != dSIUotA) {
                this.setBaseListsStatus(0);
                this.getLogDSI().log(-2137614336, "[BaseUOTAChoiceListener].itemSelected() -> setSelection(%1)", (Object)nArray);
                dSIUotA.setSelection(1, nArray);
            } else {
                this.getLogDSI().log(10000, "[BaseUOTAChoiceListener].itemSelected(): Null DSI; nothing to do!");
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void toggleSelection(int[] nArray) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].toggleSelection(): additional info = %1", (Object)nArray);
        PkgNode pkgNode = this.rootNode;
        if (null == pkgNode) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].toggleSelection(): Missing hierarchy!");
            return;
        }
        if (null != nArray) {
            List list = this.waitingForSelectionResponseQueue;
            synchronized (list) {
                if (!this.isWaitingForSelectionEmpty()) {
                    for (int i2 = this.waitingForSelectionResponseQueue.size() - 1; i2 >= 0; --i2) {
                        int n = (Integer)this.waitingForSelectionResponseQueue.get(i2);
                        if ((nArray[n] & 1) != 1) continue;
                        this.waitingForSelectionResponseQueue.remove(i2);
                    }
                    if (this.waitingForSelectionResponseQueue.isEmpty()) {
                        this.getSwdlModels().getSysProposalListModel().setStatus(1);
                    }
                }
                if (!this.isWaitingForSelectionEmpty()) {
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].toggleSelection(): some nodes are not selected yet, ignore this toogle response!");
                    return;
                }
                this.selectedPackages.clear();
                this.totalNumberOfUpdatePackages = 0;
                pkgNode.toggleSelection(nArray);
                pkgNode.setTogglingState();
            }
        }
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].toggleSelection(): %1 package(s) is/are selected", (long)this.selectedPackages.size());
        this.changeToggleSelectionStatus(this.getSwdlModels().getNaviCountriesListModel(), this.getSwdlModels().getNaviToggleCountriesChoiceModel());
        this.changeToggleSelectionStatus(this.getSwdlModels().getNaviRegionsListModel(), this.getSwdlModels().getNaviToggleRegionsChoiceModel());
        this.calculateAndSetDownloadSize();
        if (this.swdlEnv.isUotaUpdateRegionCountRestricted() && null != nArray) {
            boolean bl = this.checkSelectionRestriction();
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].toggleSelection():toggleRestriction(%1)", bl);
            pkgNode.toggleRestriction(bl);
        }
    }

    void setFocusToSysProposalItem() {
        if (this.swdlEnv.preselectUOTASysProposals() && this.swdlEnv.isUotaNavDBMergeProcessNeeded()) {
            if (this.firstSelectableSysProposalListRowId != -1L) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setFocusToSysProposalItem(): %1", this.firstSelectableSysProposalListRowId);
                this.getSwdlModels().getNaviCountriesMenuModel().setFocusedItem(this.getSwdlModels().getNaviCountriesListModel().getID(), FocusAdvice.KEEP_POSITION, this.firstSelectableSysProposalListRowId);
                this.firstSelectableSysProposalListRowId = -1L;
            } else {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setFocusToSysProposalItem(): reset focused item");
                this.getSwdlModels().getNaviCountriesMenuModel().resetFocusedItem();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    boolean isWaitingForSelectionEmpty() {
        List list = this.waitingForSelectionResponseQueue;
        synchronized (list) {
            return this.waitingForSelectionResponseQueue.isEmpty();
        }
    }

    protected boolean checkSelectionRestriction() {
        int n = this.getUserIgnoredPackagesContainer().getNumberOfInstalledPackages();
        String string = this.getReleaseVersionOfAlreadySelectedPackages();
        if (!"-1".equals(string)) {
            n = this.getUserIgnoredPackagesContainer().getNumberOfInstalledPackages(string);
        }
        return this.getNumberOfAlreadySelectedBusinessPackages() >= this.swdlEnv.getUotaUpdateRegionCount() - n;
    }

    private void changeToggleSelectionStatus(BaseListModelApp baseListModelApp, ChoiceModelApp choiceModelApp) {
        PkgNode pkgNode;
        AbstractPkgListRow abstractPkgListRow;
        if (null != choiceModelApp && null != baseListModelApp && 0 != baseListModelApp.getLength() && null != (abstractPkgListRow = (AbstractPkgListRow)baseListModelApp.getRow(0)) && null != (pkgNode = abstractPkgListRow.getNode().getParent())) {
            this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].changeToggleSelectionStatus(): Set toggling status for model %1 to %2", (long)choiceModelApp.getID(), (long)pkgNode.getToggling());
            choiceModelApp.setValue(pkgNode.getToggling());
        }
    }

    BaseListModelApp getListModelForLevel(int n) {
        switch (n) {
            case 1: {
                return this.getSwdlModels().getPackagesListModel();
            }
            case 2: {
                return this.getSwdlModels().getNaviCountriesListModel();
            }
        }
        throw new IllegalArgumentException(new StringBuffer().append("IllegalLevel-").append(n).toString());
    }

    void startNewGuidance(NavLocationWgs84[] navLocationWgs84Array) {
        if (this.getSwdlEnv().isUotaTravelCaseAllowed()) {
            if (this.isUotaUpdateAllowed(true) && !this.isUotaEntered() && null != this.dsi && null != navLocationWgs84Array && navLocationWgs84Array.length > 0) {
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].startNewGuidance(lon=%1,lat=%2)", (long)navLocationWgs84Array[0].longitude, (long)navLocationWgs84Array[0].latitude);
                this.isGuidanceStarted = true;
                this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController] -> getUpdatePackagesForDestinations(%1)", (long)navLocationWgs84Array.length);
                this.dsi.getUpdatePackagesForDestinations(1, navLocationWgs84Array, 0);
                this.setDownloadState(12);
            } else if (null == this.dsi) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].startNewGuidance(): dsi is null, ignore this!");
            } else if (null == navLocationWgs84Array || navLocationWgs84Array.length == 0) {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].startNewGuidance(): incorrect locations, ignore this!");
            } else {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].startNewGuidance(): new UotA is not allowed at this time, ignore this!");
            }
        } else {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].startNewGuidance(): the travel case is not allowed for this region");
        }
    }

    void cancelLastGuidance() {
        if (this.getSwdlEnv().isUotaTravelCaseAllowed()) {
            this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].cancelLastGuidance()");
            if (this.isGuidanceStarted) {
                if (null != this.speedThresholdPopuphandler) {
                    this.speedThresholdPopuphandler.cleanUpDestinationPopupRequest();
                }
                this.getSwdlModels().getUotaDestinationComponentLabelModel().setText("");
                this.clearDownloadSize();
                if (this.isUotaDestinationPopupRequested()) {
                    this.abortDownload();
                }
            } else {
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].cancelLastGuidance: no guidance is active.");
            }
        }
    }

    void mapIntegrationStarted() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].mapIntegrationStarted()");
        this.isMapIntegrationInProgress = true;
        this.getSwdlModels().getSwdlMapIntegrationInProgressChoice().setValue(1);
        this.getSwdlEnv().setCustProgressIconVisible(true);
        if (!this.isUotaEnabled() || this.isFirstUotaStateReceived()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].mapIntegrationStarted(): lock BulkCopy");
            this.getSwdlEnv().getBulkCopyAccess().bulkCopyLock();
        }
    }

    void mapIntegrationIdle() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].mapIntegrationIdle()");
        this.getSwdlModels().getSwdlMapIntegrationInProgressChoice().setValue(0);
        if (!this.isUotaEnabled() || this.isFirstUotaStateReceived() && 1 != this.getUotaState() && 4 != this.getUotaState()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].mapIntegrationIdle(): unlock BulkCopy");
            this.getSwdlEnv().getBulkCopyAccess().bulkCopyUnlock();
        }
        this.isMapIntegrationInProgress = false;
        this.getSwdlEnv().setCustProgressIconVisible(false);
        this.getSwdlModels().updateCustomerProgress(0);
    }

    void mapIntegrationProgressChanged(int n) {
        if (this.isMapIntegrationInProgress) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].mapIntegrationProgressChanged(%1)", (long)n);
            this.getSwdlModels().updateCustomerProgress(this.mapIntegrationProgress2CrossProgress(n));
        }
    }

    public final boolean isMapIntegrationInProgress() {
        return this.isMapIntegrationInProgress;
    }

    public boolean isPPOIUpdate(int n) {
        boolean bl = false;
        if (n >= 0 && this.downloadPackages != null && this.downloadPackages.length > n && this.downloadPackages[n] != null) {
            bl = this.downloadPackages[n].isPPOI();
        }
        return this.isPPOIInstalling || bl;
    }

    void setPPOIInstalling(boolean bl) {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].setPPOIInstalling(%1)", bl);
        this.isPPOIInstalling = bl;
    }

    public void setUotaUpdate(boolean bl) {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].setUotaUpdate(%1)", bl);
        this.isUotaUpdate = bl;
    }

    void cleanUpPopupRequests() {
        this.getLogDSI().log(-2137614336, "[BaseUpdateOverTheAirController].cleanUpPoprupRequests()");
        this.speedThresholdPopuphandler.cleanUpDestinationPopupRequest();
        this.resetUotaDestinationRequestState();
        this.speedThresholdPopuphandler.cleanUpSysProposalPopupRequest();
        if (this.isUotaSysProposalPopupRequested()) {
            this.resetUotaState();
        }
        this.clearDownloadSize();
        this.cleanupPackageHierarchy();
    }

    public final boolean isDSIAvailable() {
        return null != this.getDSI();
    }

    synchronized IgnoredPackagesStorageContainer getUserIgnoredPackagesContainer() {
        return null == this.ignoredPkgContainer ? (this.ignoredPkgContainer = new IgnoredPackagesStorageContainer(this)) : this.ignoredPkgContainer;
    }

    protected void showNoDataPopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showNoDataPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showAccessFailurePopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showAccessFailurePopup(): NOT IMPLEMENTED!!!");
    }

    protected void showServerErrorPopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showServerErrorPopup(): NOT IMPLEMENTED!!!");
    }

    protected void hideServerErrorPopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].hideServerErrorPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showSourceConfirmationPopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showSourceConfirmationPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showDownloadErrorPopup(boolean bl) {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showDownloadErrorPopup(%1): NOT IMPLEMENTED!!!", bl);
    }

    protected void showNewNaviUpdateAvailableWithLicensePopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showNewNaviUpdateAvailableWithLicensePopup(): NOT IMPLEMENTED!!!");
    }

    protected void showNewNaviUpdateAvailableNoLicensePopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showNewNaviUpdateAvailableWithLicensePopup(): NOT IMPLEMENTED!!!");
    }

    protected void showUpdateSystemProposalPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateSystemProposalPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showUpdateDestinationPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateDestinationPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showUpdateDestinationConfirmationPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUpdateDestinationConfirmationPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showSystemProposalDisclaimerPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showSystemProposalDisclaimerPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showUotaSummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUotaSummaryPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showUotaPPOISummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].showUotaPPOIPopup(): NOT IMPLEMENTED!!!");
    }

    protected void hideUotaPPOISummaryPopup() {
        this.getLogUota().log(1078071040, "[UOTAControllerEvo].hideUotaPPOISummaryPopup(): NOT IMPLEMENTED!!!");
    }

    protected void showGeneralUpdatesAvailablePopup() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].showGeneralUpdatesAvailablePopup(): NOT IMPLEMENTED!!!");
    }

    protected void hideSwdlSummaryPopups() {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].hideSwdlSummaryPopups(): NOT IMPLEMENTED!!!");
        this.getSwdlEnv().getHMIService().removeCurrentPopup(this.getSwdlEnv().getTerminalId());
    }

    public final DSIUotAListener getUotaDSIListener() {
        return this.dsiUotaListener;
    }

    public final AsiaMapIntegrationHandler getMapIntegrationDSIHandler() {
        return this.asiaMapIntegrationHandler;
    }

    public boolean isLastPackageDownloaded() {
        return this.isInstallActive() && this.isLastPackageDownloaded;
    }

    DSIUotA getDSI() {
        return this.dsi;
    }

    UotaSpeedThresholdHandler getSpeedThresholdPopuphandler() {
        return this.speedThresholdPopuphandler;
    }

    final long getKombiTime() {
        return this.getSwdlEnv().getKombiTime();
    }

    final String getServerName() {
        return this.serverName;
    }

    protected SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    protected SwdlModels getSwdlModels() {
        return this.swdlModels;
    }

    private boolean hasHMIFocus() {
        return this.getSwdlEnv().getCustomerDLState().isCustomerUpdateHasFocus();
    }

    public final boolean isCustomerDownloadProgressActive() {
        return 3 == this.getSwdlModels().getCustomerProgressStateChoice().getValue();
    }

    public final int getUotaState() {
        return this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaPackagesRequested() {
        return 6 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaEntered() {
        return 0 != this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaSelectionActive() {
        return 1 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaSysProposalSelectionActive() {
        return 9 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaDestinationSelectionActive() {
        return 13 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaSysProposalPopupRequested() {
        return 8 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaDestinationPopupRequested() {
        return 12 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isDownloadActive() {
        return 2 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isDownloadRequested() {
        return 15 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isWaitForPDD() {
        return 7 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isDownloadWaitForConnection() {
        return 11 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isInstallActive() {
        return 3 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isUotaError() {
        return 4 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    public final boolean isLeavingSWDL() {
        return 5 == this.getSwdlModels().getOnlineUpdateStateChoiceModel().getValue();
    }

    boolean isFirstUotaStateReceived() {
        return this.isFirstUotaStateReceived;
    }

    void setFirstUotaStateReceived() {
        this.isFirstUotaStateReceived = true;
    }

    boolean isServiceReady() {
        return this.serviceReady;
    }

    boolean isInstallError() {
        return this.isInstallError;
    }

    PkgNode getHierarchyRoot() {
        return this.rootNode;
    }

    void setServiceReady(boolean bl) {
        this.serviceReady = bl;
    }

    void setServerNameResponse(boolean bl) {
        this.serverNameResponse = bl;
    }

    boolean isServerNameResponse() {
        return this.serverNameResponse;
    }

    void setServerName(String string) {
        this.serverName = string;
    }

    void setHierarchyRoot(PkgNode pkgNode) {
        this.rootNode = pkgNode;
    }

    private boolean isUotaEnabled() {
        return this.getSwdlEnv().isUpdateOverTheAirFeatureEnabled();
    }

    protected LogChannel getLogUota() {
        return this.logUota;
    }

    protected LogChannel getLogDSI() {
        return this.logDSI;
    }

    private int getDynamicFilterTypeIndex() {
        boolean bl;
        boolean bl2 = bl = this.getSwdlModels().getUotaExcludeNavdataChoiceModel().getValue() == 1;
        if (this.swdlEnv.getHMIService().getChoiceModel(-501538048) != null) {
            if (0 == this.swdlEnv.getHMIService().getChoiceModel(-501538048).getValue()) {
                if (bl) {
                    return 0;
                }
                return PACKAGE_TYPE_INDEX;
            }
            switch (PACKAGE_TYPE_INDEX) {
                case 0: {
                    return 3;
                }
                case 1: {
                    return 1;
                }
                case 2: {
                    return 1;
                }
            }
            return PACKAGE_TYPE_INDEX;
        }
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].getDynamicFilterTypeIndex(): choice model 2300898 is not available!");
        return PACKAGE_TYPE_INDEX;
    }

    public final void resetExcludeNavdataPackages() {
        this.getSwdlModels().getUotaExcludeNavdataChoiceModel().setValue(0);
    }

    String getPackageFilter() {
        return PACKAGE_TYPE_FILTER_LIST[this.getDynamicFilterTypeIndex()];
    }

    void addSelectedPackage(int n) {
        if (n > -1 && !this.selectedPackages.contains(new Integer(n))) {
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray;
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].addSelectedPackage(index=%1)", (long)n);
            this.selectedPackages.add(new Integer(n));
            this.totalNumberOfUpdatePackages = this.selectedPackages.size();
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray2 = uotaPkgInfoWrapperArray = null != this.rootNode ? this.rootNode.getAllPackageInfos() : null;
            if (null != uotaPkgInfoWrapperArray && n <= uotaPkgInfoWrapperArray.length) {
                this.isNavPackageSelected = !uotaPkgInfoWrapperArray[n].isSystemPackage() && !uotaPkgInfoWrapperArray[n].isPPOI();
            }
        }
    }

    int getNumberOfCurrentDownloadPackage() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].getNumberOfCurrentDownloadPackage(): %1", (long)this.numberOfCurrentDownloadPackage);
        return this.numberOfCurrentDownloadPackage;
    }

    void setNumberOfCurrentDownloadPackage(int n) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setNumberOfCurrentDownloadPackage(%1):%2", (Object)Integer.toString(n), (Object)(this.downloadPackages != null && this.downloadPackages.length > n ? this.downloadPackages[n].getLastName() : ""));
        this.numberOfCurrentDownloadPackage = n;
    }

    int getTotalNumberOfUpdatePackages(boolean bl) {
        int n = this.totalNumberOfUpdatePackages;
        if (bl) {
            if (null == this.rootNode) {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].getTotalNumberOfInstallingPackages(): Missing root node!");
                return n;
            }
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.rootNode.getAllPackageInfos();
            if (null != uotaPkgInfoWrapperArray && !this.selectedPackages.isEmpty()) {
                n = 0;
                Iterator iterator = this.selectedPackages.iterator();
                while (iterator.hasNext()) {
                    UotaPkgInfoWrapper uotaPkgInfoWrapper;
                    Integer n2 = (Integer)iterator.next();
                    if (null == n2 || null == (uotaPkgInfoWrapper = uotaPkgInfoWrapperArray[n2]) || uotaPkgInfoWrapper.isPPOI()) continue;
                    ++n;
                }
            }
        }
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].getTotalNumberOfUpdatePackages(): %1", (long)n);
        return n;
    }

    void setTotalNumberOfUpdatePackages(int n) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setTotalNumberOfUpdatePackages(%1)", (long)n);
        this.totalNumberOfUpdatePackages = n;
    }

    int getNumberOfCurrentUpdatePackage() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].getNumberOfCurrentUpdatePackage(): %1", (long)this.numberOfCurrentUpdatePackage);
        return this.numberOfCurrentUpdatePackage;
    }

    void setNumberOfCurrentUpdatePackage(int n) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].setNumberOfCurrentUpdatePackage(%1)", (long)n);
        this.numberOfCurrentUpdatePackage = n;
    }

    DownloadPackageData getDownloadPackageData() {
        return new DownloadPackageData(this.downloadPackages, this.logUota);
    }

    void storeDestinationPackage() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].storeDestinationPackage()");
        if (null != this.destinationProposalPkg && this.destinationProposalPkg.isValid() && this.destinationProposalPkg.getReleaseVersion().length() > 0) {
            this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].ignoreUpdatesAvailablePopup(): Adding package %1 version %2 to the ignore list!", (Object)this.destinationProposalPkg.getLastName(), (Object)this.destinationProposalPkg.getReleaseVersion());
            this.getUserIgnoredPackagesContainer().addToIgnoreList(this.destinationProposalPkg);
            this.getUserIgnoredPackagesContainer().storeIgnoredPackagesToPersistence();
        }
    }

    void storeProposalPackageRelease() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].storeProposalPackageRelease()");
        boolean bl = false;
        if (null != this.proposalPackages && this.proposalPackages.length > 0) {
            for (int i2 = 0; i2 < this.proposalPackages.length; ++i2) {
                if (null == this.proposalPackages[i2] || !this.proposalPackages[i2].isValid() || this.proposalPackages[i2].getReleaseVersion().length() <= 0) continue;
                if (!bl) {
                    this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].storeProposalPackageRelease(): Adding release %1 version to the ignore list!", (Object)this.proposalPackages[i2].getReleaseVersion());
                    this.getUserIgnoredPackagesContainer().addReleaseVersionToIgnoreList(this.proposalPackages[i2].getReleaseVersion(), this.proposalPackages[i2].isLicenseAvailable());
                    bl = true;
                }
                if (!this.proposalPackages[i2].isLicenseAvailable()) continue;
                this.getLogUota().log(1078071040, "[BaseUpdateOverTheAirController].storeProposalPackageRelease(): Adding package %1 version %2 to the ignore list!", (Object)this.proposalPackages[i2].getLastName(), (Object)this.proposalPackages[i2].getReleaseVersion());
                this.getUserIgnoredPackagesContainer().addToIgnoreList(this.proposalPackages[i2]);
            }
            this.getUserIgnoredPackagesContainer().storeIgnoredPackagesToPersistence();
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].leaveUpdatesAvailablePopup(): no update packages available");
        }
    }

    public boolean isSummaryPopupConfirmed() {
        return this.isSummaryPopupConfirmed;
    }

    boolean setSummaryPopupConfirmed(boolean bl) {
        this.isSummaryPopupConfirmed = bl;
        return this.isSummaryPopupConfirmed;
    }

    boolean isPopupButtonPressed() {
        return this.isPopupButtonPressed;
    }

    void setPopupButtonPressed(boolean bl) {
        this.isPopupButtonPressed = bl;
    }

    void cleanupDownloadPackageNumbers() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].cleanupDownloadPackageNumbers()");
        this.selectedPackages.clear();
        this.setNumberOfCurrentDownloadPackage(0);
    }

    boolean isLastPackageUpdated() {
        if (this.downloadPackages != null) {
            return this.getNumberOfCurrentUpdatePackage() == this.downloadPackages.length;
        }
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].isLastPackageUpdated(): download packages are not defined!");
        return false;
    }

    public void testFinalPopupTrigger() {
        this.dsiUotaListener.triggerAction(1, 0, 4, "");
    }

    public void confirmSummaryPopup() {
        if (null == this.getDSI()) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].confirmSummaryPopup(): DSI is null, do nothing");
        } else {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].confirmSummaryPopup()");
            this.getDSI().triggerAction(1, 5, "");
            this.isSummaryPopupConfirmed = true;
        }
    }

    private void leaveCustomerUpdateContext() {
        int n = this.getSwdlModels().getLeaveCustomerUpdateChoiceModel().getValue();
        int n2 = n == 0 ? 1 : 0;
        this.getSwdlModels().getLeaveCustomerUpdateChoiceModel().setValue(n2);
    }

    PkgNode getPackageNodeByPackageInfo(UotaPkgInfoWrapper uotaPkgInfoWrapper) {
        if (null != this.pkgNodeMapping) {
            return (PkgNode)this.pkgNodeMapping.get(uotaPkgInfoWrapper.getPkgId());
        }
        return null;
    }

    void mapPackageNode(String string, PkgNode pkgNode) {
        if (this.pkgNodeMapping == null) {
            this.pkgNodeMapping = new HashMap(52);
        }
        if (null != pkgNode) {
            if (pkgNode.isLeaf()) {
                this.pkgNodeMapping.put(string, pkgNode);
                this.getLogUota().log(14808325, "[BaseUpdateOverTheAirController].mapPackageNode(): %1 -> %2", (Object)string, (Object)pkgNode.getDisplayName());
            } else {
                this.getLogUota().log(14808325, "[BaseUpdateOverTheAirController].mapPackageNode(): package is not selectable, skip this.");
            }
        } else {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].mapPackageNode(): package node or package info is undefined, do nothing.");
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean checkProposalPackagesWithoutLicense() {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].checkProposalPackagesWithoutLicense()");
        if (null != this.rootNode) {
            String string = "";
            UotaPkgInfoWrapper uotaPkgInfoWrapper = null;
            UotaPkgInfoWrapper[] uotaPkgInfoWrapperArray = this.rootNode.getAllPackageInfos();
            if (null != uotaPkgInfoWrapperArray) {
                for (int i2 = 0; i2 < uotaPkgInfoWrapperArray.length; ++i2) {
                    UotaPkgInfoWrapper uotaPkgInfoWrapper2 = uotaPkgInfoWrapperArray[i2];
                    if (null == uotaPkgInfoWrapper2 || uotaPkgInfoWrapper2.isSystemPackage() || uotaPkgInfoWrapper2.isPPOI() || null == uotaPkgInfoWrapper2.getReleaseVersion() || string.compareTo(uotaPkgInfoWrapper2.getReleaseVersion()) >= 0 || uotaPkgInfoWrapper2.isLicenseAvailable() || this.getUserIgnoredPackagesContainer().isReleaseIgnoredByUser(uotaPkgInfoWrapper2)) continue;
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController]: not ignored package without license found %2", (Object)uotaPkgInfoWrapper2.getDisplayVersion(0));
                    string = uotaPkgInfoWrapper2.getReleaseVersion();
                    uotaPkgInfoWrapper = uotaPkgInfoWrapper2;
                }
            } else {
                this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].checkProposalPackagesWithoutLicense(): getAllPackageInfos of the root is null");
            }
            if (string.length() > 0) {
                if (this.proposalPackages != null && this.proposalPackages.length > 0) {
                    if (null == uotaPkgInfoWrapper.getReleaseVersion() || string.compareTo(this.proposalPackages[0].getReleaseVersion()) <= 0) return false;
                    this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController]: ignore %1 and propose a release without license %2", (Object)this.proposalPackages[0].getDisplayVersion(0), (Object)uotaPkgInfoWrapper.getDisplayVersion(0));
                    this.proposalPackages = new UotaPkgInfoWrapper[1];
                    this.proposalPackages[0] = uotaPkgInfoWrapper;
                    return true;
                }
                this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController]: propose a release without license %1", (Object)uotaPkgInfoWrapper.getDisplayVersion(0));
                this.proposalPackages = new UotaPkgInfoWrapper[1];
                this.proposalPackages[0] = uotaPkgInfoWrapper;
                return true;
            }
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController]: no packages without license found.");
            return false;
        } else {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].checkProposalPackagesWithoutLicense(): root is null, nothing to check!");
        }
        return false;
    }

    private boolean isNewProposalPackageAvailable() {
        if (this.proposalPackages != null) {
            for (int i2 = 0; i2 < this.proposalPackages.length; ++i2) {
                if (this.proposalPackages[i2].isUpToDate()) continue;
                return true;
            }
        }
        return false;
    }

    void setDownloadSpeed(ModelGroup modelGroup, long l) {
        MetricsModelApp metricsModelApp = this.getSwdlModels().getDlProgressDlSpeedMetricsModel();
        modelGroup.add(metricsModelApp);
        ByteSize byteSize = new ByteSize(l, 1, false);
        metricsModelApp.setMetric(byteSize);
    }

    protected SysProposalPkgRow getSysProposalPackageRow(PkgNode pkgNode) {
        return new SysProposalPkgRow(pkgNode);
    }

    protected EvoListRow getNaviDataPackageRow(PkgNode pkgNode) {
        return new NaviDataPkgRow(pkgNode);
    }

    protected EvoListRow getGenericPackageRow(PkgNode pkgNode) {
        return new GenericPkgRow(pkgNode);
    }

    @Override
    public void processMsg(int n) {
        if (23 == n) {
            this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController].processMsg(): Reset Nav memory settings!");
            this.abortDownload();
            this.speedThresholdPopuphandler.cleanUpPopupRequests();
            this.getUserIgnoredPackagesContainer().cleanupIgnoredPackages();
            this.getUserIgnoredPackagesContainer().cleanUpAlreadyInstalledHighestRelease();
        }
    }

    int compareSysProposalPackages(Object object, Object object2) {
        return -129;
    }

    @Override
    public void popupHidden(int n) {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].popupHidden(): NOT IMPLEMENTED!!!");
    }

    @Override
    public void popupRemoved(int n) {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].popupHidden(): NOT IMPLEMENTED!!!");
    }

    @Override
    public void popupVisible(int n) {
        this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].popupHidden(): NOT IMPLEMENTED!!!");
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        if (timer.equals(this.waitAutoSelectionTimer)) {
            List list = this.waitingForSelectionResponseQueue;
            synchronized (list) {
                if (!this.isWaitingForSelectionEmpty()) {
                    this.getLogUota().log(10000, "[BaseUpdateOverTheAirController] cancel waiting for preselection of system proposal(s)!");
                    this.waitingForSelectionResponseQueue.clear();
                }
            }
        } else if (timer.equals(this.waitUotaClientTimer)) {
            this.getLogUota().log(10000, "[BaseUpdateOverTheAirController].fireTimer(waitUotaClientTimer): disable the UotA functionality!");
            this.getSwdlEnv().setUpdateOverTheAirNotAvailable();
            this.getSwdlModels().getCustomerInitCustomerUpdateButtonChoice().setValue(1);
            this.getSwdlEnv().getBulkCopyAccess().bulkCopyUnlock();
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.getLogUota().log(-2137614336, "[BaseUpdateOverTheAirController] cancel timer %1", (Object)timer);
    }

    static {
        PACKAGE_TYPE_FILTER_LIST = new String[]{"ppoi", "navdata", "navdata,ppoi", ""};
        PACKAGE_TYPE_INDEX = 2;
    }
}

