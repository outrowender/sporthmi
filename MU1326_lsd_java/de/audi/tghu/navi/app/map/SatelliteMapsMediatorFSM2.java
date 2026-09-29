/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.interapp.icon.RenderingInfoProvider$SatelliteMapsLogoCallback;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.ISatelliteMapsMediatorFSM;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$1;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$2;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$3;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatelliteMapState;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatellitemapActiveState;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$SatellitemapActiveStateSATBlocked;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$StandardmapActiveState;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$StandardmapActiveStateSATBlocked;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$TrafficMapActiveState;
import de.audi.tghu.navi.app.map.SatelliteMapsMediatorFSM2$TrafficmapActiveStateSATBlocked;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class SatelliteMapsMediatorFSM2
implements ISatelliteMapsMediatorFSM,
RenderingInfoProvider$SatelliteMapsLogoCallback {
    private final LogChannel logger;
    protected static final String STANDARD_MAP_ACTIVE_STATE;
    protected static final String SATELLITE_MAP_ACTIVE_STATE;
    protected static final String TRAFFIC_MAP_ACTIVE_STATE;
    protected static final String TRAFFIC_MAP_ACTIVE_STATE_SAT_BLOCKED;
    protected static final String STANDARD_MAP_ACTIVE_STATE_SAT_BLOCKED;
    protected static final String SATELLITE_MAP_ACTIVE_STATE_SAT_BLOCKED;
    private SatelliteMapsMediatorFSM2$SatelliteMapState standardmapActiveState = new SatelliteMapsMediatorFSM2$StandardmapActiveState(this, "STANDARD_MAP_ACTIVE_STATE");
    private SatelliteMapsMediatorFSM2$SatelliteMapState satellitemapActiveState = new SatelliteMapsMediatorFSM2$SatellitemapActiveState(this, "SATELLITE_MAP_ACTIVE_STATE");
    private SatelliteMapsMediatorFSM2$SatelliteMapState trafficmapActiveState = new SatelliteMapsMediatorFSM2$TrafficMapActiveState(this, "TRAFFIC_MAP_ACTIVE_STATE");
    private SatelliteMapsMediatorFSM2$SatelliteMapState trafficmapActiveStateSATBlocked = new SatelliteMapsMediatorFSM2$TrafficmapActiveStateSATBlocked(this, "TRAFFIC_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private SatelliteMapsMediatorFSM2$SatelliteMapState standardmapActiveStateSATBlocked = new SatelliteMapsMediatorFSM2$StandardmapActiveStateSATBlocked(this, "STANDARD_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private SatelliteMapsMediatorFSM2$SatelliteMapState satellitemapActiveStateSATBlocked = new SatelliteMapsMediatorFSM2$SatellitemapActiveStateSATBlocked(this, "SATELLITE_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private static final String SATELLITE_NAV_DISPATCHER;
    private SatelliteMapsMediatorFSM2$SatelliteMapState currentState = this.standardmapActiveState;
    private ISatelliteMapsManager satelliteMapManager;
    private IconHandler satelliteLogos;
    private final DispatcherBase dispatcher;
    private boolean inProductiveMode;
    private NavigationEnv env;
    private ISatelliteMapsGUI gui;
    private int terminal;
    public static final int MAP_STYLE_STD;
    public static final int MAP_STYLE_SATMAPS;
    public static final int SATMAPS_NOT_ACTIVE;
    public static final int SATMAPS_ACTIVE;
    private int lastConfirmedMapStyle = 0;
    private boolean hasProviderChanged = true;

    public SatelliteMapsMediatorFSM2(NavigationEnv navigationEnv, LogChannel logChannel, ISatelliteMapsManager iSatelliteMapsManager, boolean bl, int n, int n2, IconHandler iconHandler) {
        this.logger = logChannel;
        this.satelliteMapManager = iSatelliteMapsManager;
        this.env = navigationEnv;
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher(new StringBuffer().append("SatelliteMapsDispatcher").append(n).toString(), new JobLogger(logChannel));
        this.dispatcher.start();
        this.inProductiveMode = bl;
        this.terminal = n2;
        this.satelliteLogos = iconHandler;
        this.gui = ISatelliteMapsGUI.NULL_GUI;
    }

    public SatelliteMapsMediatorFSM2(NavigationEnv navigationEnv, LogChannel logChannel, ISatelliteMapsManager iSatelliteMapsManager, ISatelliteMapsGUI iSatelliteMapsGUI, boolean bl, int n, int n2, IconHandler iconHandler) {
        this(navigationEnv, logChannel, iSatelliteMapsManager, bl, n, n2, iconHandler);
        this.gui = iSatelliteMapsGUI;
    }

    protected String getCurrentStateName() {
        return this.currentState.getName();
    }

    private void changeState(SatelliteMapsMediatorFSM2$SatelliteMapState satelliteMapsMediatorFSM2$SatelliteMapState) {
        this.logger.log(-2137614336, "SatelliteMapsMediatorFSM2#changeState() from: %1 to: %2 ", (Object)this.currentState.getName(), (Object)satelliteMapsMediatorFSM2$SatelliteMapState.getName());
        if (satelliteMapsMediatorFSM2$SatelliteMapState == this.currentState) {
            return;
        }
        this.currentState.exit();
        this.currentState = satelliteMapsMediatorFSM2$SatelliteMapState;
        this.currentState.enter();
    }

    private void switchMapStyleAtMapDSI(int n) {
        this.logger.log(-2137614336, "SatelliteMapsMediatorStatemachine2#switchMapStyleAtMapDSI() ");
        this.satelliteMapManager.changeMapStyle(n);
    }

    private void setSatelliteMapsCopyRightLogo(boolean bl) {
        this.logger.log(-2137614336, "SatelliteMapsMediatorStatemachine2#setSatelliteMapsCopyRightLogo() show %1 ", bl);
        if (bl && this.inProductiveMode && this.satelliteMapManager.getMap().getActiveContext() instanceof IVisibleContext) {
            this.satelliteMapManager.setCopyrightPosition(this.gui.getCopyRightLogoPosition((IVisibleContext)this.satelliteMapManager.getMap().getActiveContext(), this.terminal), 0, 5);
        }
    }

    @Override
    public void setLogosAccordingToSetup() {
        if (this.isSatelliteMapsConfirmed()) {
            this.gui.setSatelliteMapsProviderLogo(true);
            this.setSatelliteMapsCopyRightLogo(true);
        } else {
            this.gui.setSatelliteMapsProviderLogo(false);
            this.setSatelliteMapsCopyRightLogo(false);
        }
    }

    private void notifyClusterAboutSatMapsState(boolean bl) {
        ClusterService clusterService;
        if (!this.inProductiveMode) {
            this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#notifyClusterAboutSatMapsState() inTestMode");
            return;
        }
        if (this.terminal == 0 && (clusterService = this.satelliteMapManager.getMap().getNaviInterface().getClusterService()) != null) {
            clusterService.setProviderChangeFlag(bl);
            if (bl) {
                clusterService.updateOnlineNavigationState();
            } else if (this.isSatelliteMapsConfirmed()) {
                clusterService.updateOnlineNavigationState();
            }
        }
    }

    public boolean isSatelliteMapsConfirmed() {
        return "SATELLITE_MAP_ACTIVE_STATE".equals(this.currentState.getName()) && this.currentState.isConfirmed();
    }

    @Override
    public boolean isSatelliteMapsActive() {
        return "SATELLITE_MAP_ACTIVE_STATE".equals(this.currentState.getName());
    }

    private void setMapStyle(int n) {
        if (n == 0) {
            this.currentState.activateStandard();
        } else if (n == 1) {
            this.currentState.activateSatellite();
        } else if (n == 2) {
            this.currentState.activateTraffic();
        } else {
            this.logger.log(10000, "SatelliteMapsMediatorFSM2#setmapStyle() received invalid map style %1 ", (long)n);
            this.currentState.activateStandard();
        }
    }

    @Override
    public void updatemapStyle(int n) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new SatelliteMapsMediatorFSM2$1(this, n));
        } else {
            this.logger.log(-2137614336, "SatelliteMapsMediatorFSM2#updatemapStyle() %1 ", (long)n);
            this.updateMapStyleInternal(n);
        }
    }

    private void updateMapStyleInternal(int n) {
        this.lastConfirmedMapStyle = n;
        if (n == 0) {
            this.currentState.updateStandard();
        } else if (n == 1) {
            this.currentState.updateSatellite();
        } else if (n == 2) {
            this.currentState.updateTraffic();
        } else {
            this.changeState(this.standardmapActiveState);
            this.switchMapStyleAtMapDSI(0);
        }
    }

    public void setBlockingBit(boolean bl) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new SatelliteMapsMediatorFSM2$2(this, bl));
        } else {
            this.currentState.setBlockingBit(bl);
        }
    }

    @Override
    public void setMapStyle(int n, boolean bl) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new SatelliteMapsMediatorFSM2$3(this, n, bl));
        } else {
            this.logger.log(-2137614336, "SatelliteMapsMediatorFSM2#togglemapStyle() %1 ", (long)n);
            this.setBlockingBit(bl);
            this.setMapStyle(n);
        }
    }

    @Override
    public void cleanUp() {
        this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#cleanUp()");
        this.dispatcher.stop();
    }

    @Override
    public void renderingInformationForSatelliteLogo(RenderingInfo renderingInfo) {
        int n = -1;
        if (renderingInfo != null && renderingInfo.isValid()) {
            n = renderingInfo.getResourceId();
        } else {
            this.logger.log(-1601830656, "SatelliteMapsMediatorFSM2#renderingInformationForSatelliteLogo - RenderingInfo is null; Satellite Provider Change or error on navcore ");
        }
        this.updateSatelliteMapsLogos(n);
    }

    private void updateSatelliteMapsLogos(int n) {
        if (n == 0x11000060) {
            this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.gui.getSatelliteMapResourceLocator(1680147968).setResourceLocator(n, ResourceLocatorModelApp.UNDEFINED_URI);
            this.gui.getSatelliteMapChoiceModel(1663370752).setValue(n);
        } else if (n == 318767200) {
            this.hasProviderChanged = false;
            this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.notifyClusterAboutSatMapsState(this.hasProviderChanged);
        } else if (n == -1) {
            this.hasProviderChanged = true;
            this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.notifyClusterAboutSatMapsState(this.hasProviderChanged);
        } else {
            this.logger.log(1078071040, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - do nothing for resource ID: %1", (long)n);
        }
    }

    @Override
    public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.logger.log(1078071040, "SatelliteMapsMediatorFSM#setRenderingInfoProvider - setting rendInfoProv ");
        if (renderingInfoProvider != null) {
            renderingInfoProvider.setSatMapCallback(this);
        } else {
            this.logger.log(10000, "SatelliteMapsMediatorFSM#setRenderingInfoProvider - PROVIDER IS NULL");
        }
    }

    static /* synthetic */ LogChannel access$000(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.logger;
    }

    static /* synthetic */ void access$100(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n) {
        satelliteMapsMediatorFSM2.switchMapStyleAtMapDSI(n);
    }

    static /* synthetic */ NavigationEnv access$200(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.env;
    }

    static /* synthetic */ boolean access$300(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.hasProviderChanged;
    }

    static /* synthetic */ void access$400(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, boolean bl) {
        satelliteMapsMediatorFSM2.notifyClusterAboutSatMapsState(bl);
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$500(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.satellitemapActiveState;
    }

    static /* synthetic */ void access$600(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, SatelliteMapsMediatorFSM2$SatelliteMapState satelliteMapState) {
        satelliteMapsMediatorFSM2.changeState(satelliteMapState);
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$700(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.trafficmapActiveState;
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$800(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.standardmapActiveStateSATBlocked;
    }

    static /* synthetic */ int access$900(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.lastConfirmedMapStyle;
    }

    static /* synthetic */ int access$1000(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.terminal;
    }

    static /* synthetic */ ISatelliteMapsGUI access$1100(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.gui;
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$1200(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.standardmapActiveState;
    }

    static /* synthetic */ IconHandler access$1300(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.satelliteLogos;
    }

    static /* synthetic */ void access$1400(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n) {
        satelliteMapsMediatorFSM2.updateSatelliteMapsLogos(n);
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$1500(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.satellitemapActiveStateSATBlocked;
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$1600(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.trafficmapActiveStateSATBlocked;
    }

    static /* synthetic */ void access$1700(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n) {
        satelliteMapsMediatorFSM2.updateMapStyleInternal(n);
    }

    static /* synthetic */ SatelliteMapsMediatorFSM2$SatelliteMapState access$1800(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2) {
        return satelliteMapsMediatorFSM2.currentState;
    }

    static /* synthetic */ void access$1900(SatelliteMapsMediatorFSM2 satelliteMapsMediatorFSM2, int n) {
        satelliteMapsMediatorFSM2.setMapStyle(n);
    }
}

