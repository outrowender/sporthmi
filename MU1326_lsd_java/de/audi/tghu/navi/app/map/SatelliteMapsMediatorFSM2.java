/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ResourceLocatorModelApp;
import de.audi.atip.interapp.icon.RenderingInfo;
import de.audi.atip.interapp.icon.RenderingInfoProvider;
import de.audi.atip.job.JobLogger;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.cluster.ClusterService;
import de.audi.tghu.navi.app.map.ISatelliteMapsGUI;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.ISatelliteMapsMediatorFSM;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class SatelliteMapsMediatorFSM2
implements ISatelliteMapsMediatorFSM,
RenderingInfoProvider.SatelliteMapsLogoCallback {
    private final LogChannel logger;
    protected static final String STANDARD_MAP_ACTIVE_STATE = "STANDARD_MAP_ACTIVE_STATE";
    protected static final String SATELLITE_MAP_ACTIVE_STATE = "SATELLITE_MAP_ACTIVE_STATE";
    protected static final String TRAFFIC_MAP_ACTIVE_STATE = "TRAFFIC_MAP_ACTIVE_STATE";
    protected static final String TRAFFIC_MAP_ACTIVE_STATE_SAT_BLOCKED = "TRAFFIC_MAP_ACTIVE_STATE_SAT_BLOCKED";
    protected static final String STANDARD_MAP_ACTIVE_STATE_SAT_BLOCKED = "STANDARD_MAP_ACTIVE_STATE_SAT_BLOCKED";
    protected static final String SATELLITE_MAP_ACTIVE_STATE_SAT_BLOCKED = "SATELLITE_MAP_ACTIVE_STATE_SAT_BLOCKED";
    private SatelliteMapState standardmapActiveState = new StandardmapActiveState("STANDARD_MAP_ACTIVE_STATE");
    private SatelliteMapState satellitemapActiveState = new SatellitemapActiveState("SATELLITE_MAP_ACTIVE_STATE");
    private SatelliteMapState trafficmapActiveState = new TrafficMapActiveState("TRAFFIC_MAP_ACTIVE_STATE");
    private SatelliteMapState trafficmapActiveStateSATBlocked = new TrafficmapActiveStateSATBlocked("TRAFFIC_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private SatelliteMapState standardmapActiveStateSATBlocked = new StandardmapActiveStateSATBlocked("STANDARD_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private SatelliteMapState satellitemapActiveStateSATBlocked = new SatellitemapActiveStateSATBlocked("SATELLITE_MAP_ACTIVE_STATE_SAT_BLOCKED");
    private static final String SATELLITE_NAV_DISPATCHER = "SatelliteMapsDispatcher";
    private SatelliteMapState currentState = this.standardmapActiveState;
    private ISatelliteMapsManager satelliteMapManager;
    private IconHandler satelliteLogos;
    private final DispatcherBase dispatcher;
    private boolean inProductiveMode;
    private NavigationEnv env;
    private ISatelliteMapsGUI gui;
    private int terminal;
    public static final int MAP_STYLE_STD = 0;
    public static final int MAP_STYLE_SATMAPS = 1;
    public static final int SATMAPS_NOT_ACTIVE = 0;
    public static final int SATMAPS_ACTIVE = 100;
    private int lastConfirmedMapStyle = 0;
    private boolean hasProviderChanged = true;

    public SatelliteMapsMediatorFSM2(NavigationEnv navigationEnv, LogChannel logChannel, ISatelliteMapsManager iSatelliteMapsManager, boolean bl, int n, int n2, IconHandler iconHandler) {
        this.logger = logChannel;
        this.satelliteMapManager = iSatelliteMapsManager;
        this.env = navigationEnv;
        this.dispatcher = navigationEnv.getFramework().getDispatcherManager().createDispatcher(new StringBuffer().append(SATELLITE_NAV_DISPATCHER).append(n).toString(), new JobLogger(logChannel));
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

    private void changeState(SatelliteMapState satelliteMapState) {
        this.logger.log(10000000, "SatelliteMapsMediatorFSM2#changeState() from: %1 to: %2 ", (Object)this.currentState.getName(), (Object)satelliteMapState.getName());
        if (satelliteMapState == this.currentState) {
            return;
        }
        this.currentState.exit();
        this.currentState = satelliteMapState;
        this.currentState.enter();
    }

    private void switchMapStyleAtMapDSI(int n) {
        this.logger.log(10000000, "SatelliteMapsMediatorStatemachine2#switchMapStyleAtMapDSI() ");
        this.satelliteMapManager.changeMapStyle(n);
    }

    private void setSatelliteMapsCopyRightLogo(boolean bl) {
        this.logger.log(10000000, "SatelliteMapsMediatorStatemachine2#setSatelliteMapsCopyRightLogo() show %1 ", bl);
        if (bl && this.inProductiveMode && this.satelliteMapManager.getMap().getActiveContext() instanceof IVisibleContext) {
            this.satelliteMapManager.setCopyrightPosition(this.gui.getCopyRightLogoPosition((IVisibleContext)this.satelliteMapManager.getMap().getActiveContext(), this.terminal), 0, 5);
        }
    }

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
            this.logger.log(1000000, "SatelliteMapsMediatorFSM2#notifyClusterAboutSatMapsState() inTestMode");
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
        return SATELLITE_MAP_ACTIVE_STATE.equals(this.currentState.getName()) && this.currentState.isConfirmed();
    }

    public boolean isSatelliteMapsActive() {
        return SATELLITE_MAP_ACTIVE_STATE.equals(this.currentState.getName());
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

    public void updatemapStyle(final int n) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatelliteMapsMediatorFSM2#updatemapStyle() dispatched %1 ", (long)n);
                    SatelliteMapsMediatorFSM2.this.updateMapStyleInternal(n);
                }
            });
        } else {
            this.logger.log(10000000, "SatelliteMapsMediatorFSM2#updatemapStyle() %1 ", (long)n);
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

    public void setBlockingBit(final boolean bl) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatelliteMapsMediatorFSM2#setBlockingBit() dispacthed  %1 ", bl);
                    SatelliteMapsMediatorFSM2.this.currentState.setBlockingBit(bl);
                }
            });
        } else {
            this.currentState.setBlockingBit(bl);
        }
    }

    public void setMapStyle(final int n, final boolean bl) {
        if (this.inProductiveMode) {
            this.dispatcher.execute(new Runnable(){

                public void run() {
                    SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatelliteMapsMediatorFSM2#togglemapStyle() dispacthed  %1 ", (long)n);
                    SatelliteMapsMediatorFSM2.this.setBlockingBit(bl);
                    SatelliteMapsMediatorFSM2.this.setMapStyle(n);
                }
            });
        } else {
            this.logger.log(10000000, "SatelliteMapsMediatorFSM2#togglemapStyle() %1 ", (long)n);
            this.setBlockingBit(bl);
            this.setMapStyle(n);
        }
    }

    public void cleanUp() {
        this.logger.log(1000000, "SatelliteMapsMediatorFSM2#cleanUp()");
        this.dispatcher.stop();
    }

    public void renderingInformationForSatelliteLogo(RenderingInfo renderingInfo) {
        int n = -1;
        if (renderingInfo != null && renderingInfo.isValid()) {
            n = renderingInfo.getResourceId();
        } else {
            this.logger.log(100000, "SatelliteMapsMediatorFSM2#renderingInformationForSatelliteLogo - RenderingInfo is null; Satellite Provider Change or error on navcore ");
        }
        this.updateSatelliteMapsLogos(n);
    }

    private void updateSatelliteMapsLogos(int n) {
        if (n == 0x60000011) {
            this.logger.log(1000000, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.gui.getSatelliteMapResourceLocator(402788).setResourceLocator(n, ResourceLocatorModelApp.UNDEFINED_URI);
            this.gui.getSatelliteMapChoiceModel(402787).setValue(n);
        } else if (n == 1610612755) {
            this.hasProviderChanged = false;
            this.logger.log(1000000, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.notifyClusterAboutSatMapsState(this.hasProviderChanged);
        } else if (n == -1) {
            this.hasProviderChanged = true;
            this.logger.log(1000000, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - resourceID: %1. Update satellite logo", (long)n);
            this.notifyClusterAboutSatMapsState(this.hasProviderChanged);
        } else {
            this.logger.log(1000000, "SatelliteMapsMediatorFSM2#updateSatelliteMapsLogos - do nothing for resource ID: %1", (long)n);
        }
    }

    public void setRenderingInfoProvider(RenderingInfoProvider renderingInfoProvider) {
        this.logger.log(1000000, "SatelliteMapsMediatorFSM#setRenderingInfoProvider - setting rendInfoProv ");
        if (renderingInfoProvider != null) {
            renderingInfoProvider.setSatMapCallback(this);
        } else {
            this.logger.log(10000, "SatelliteMapsMediatorFSM#setRenderingInfoProvider - PROVIDER IS NULL");
        }
    }

    protected class SatelliteMapState {
        private final String statename;
        protected final String CLASS_NAME = Util.getClassNameFromPackageName(this.getClass());

        public SatelliteMapState(String string) {
            this.statename = string;
        }

        void enter() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#enter()", (Object)this.CLASS_NAME);
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#activateSatellite()", (Object)this.CLASS_NAME);
        }

        void activateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#activateStandard()", (Object)this.CLASS_NAME);
        }

        void activateTraffic() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#activateTraffic()", (Object)this.CLASS_NAME);
        }

        void updateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#updateSatellite()", (Object)this.CLASS_NAME);
        }

        void updateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#updateStandard()", (Object)this.CLASS_NAME);
        }

        boolean isConfirmed() {
            return false;
        }

        void exit() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#exit()", (Object)this.CLASS_NAME);
        }

        String getName() {
            return this.statename;
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#setBlockingBit()", (Object)this.CLASS_NAME);
        }

        public void updateTraffic() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "%1#updateTraffic()", (Object)this.CLASS_NAME);
        }
    }

    private class TrafficMapActiveState
    extends SatelliteMapState {
        public TrafficMapActiveState(String string) {
            super(string);
        }

        void enter() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficMapActiveState#enter()");
            SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(2);
            SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
            SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficMapActiveState#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveState);
        }

        void activateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficMapActiveState#activateStandard()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveState);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficMapActiveState#setBlockingBit() blocked %1", bl);
            if (bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveStateSATBlocked);
            }
        }
    }

    private class StandardmapActiveState
    extends SatelliteMapState {
        public StandardmapActiveState(String string) {
            super(string);
        }

        void enter() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#enter()");
            SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(0);
            SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
            SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveState);
        }

        void activateTraffic() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveState);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#updateBlockingBit()  blocked %1", bl);
            if (bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveStateSATBlocked);
            }
        }
    }

    private class SatellitemapActiveState
    extends SatelliteMapState {
        boolean confirmed;
        private boolean waitForStandardMapStyleUpdateBeforeSwitchToSatMaps;

        public SatellitemapActiveState(String string) {
            super(string);
            this.confirmed = false;
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
        }

        void enter() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#enter()");
            this.performConsistencyChecksForFastToggleAndSwitchToSatMap();
        }

        private void performConsistencyChecksForFastToggleAndSwitchToSatMap() {
            if (SatelliteMapsMediatorFSM2.this.lastConfirmedMapStyle == 1) {
                this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = true;
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#enter() satellite was already confirmed - ensure consistency and wait for standard");
                SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(0);
            } else {
                this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
                if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                    SatelliteMapsMediatorFSM2.this.gui.showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
                }
                SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(1);
                SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
                SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
                SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
            }
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#activateSatellite() confirmed %1", this.confirmed);
            if (this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps) {
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#activateSatellite() do not apply sat maps still wait for standard");
                return;
            }
            if (!this.confirmed) {
                if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                    SatelliteMapsMediatorFSM2.this.gui.showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
                }
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#activateSatellite() reapply settings as not yet confirmed");
                SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(1);
                SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
                SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
                SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
            }
        }

        void activateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#activateStandard()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveState);
        }

        void activateTraffic() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveState);
        }

        void updateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateSatellite()");
            this.confirmed = true;
            if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                int n = SatelliteMapsMediatorFSM2.this.satelliteLogos.resolveTargetIcon(204);
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateSatellite() - resourceID for map main colored icon is : %1", (long)n);
                SatelliteMapsMediatorFSM2.this.updateSatelliteMapsLogos(n);
                int n2 = SatelliteMapsMediatorFSM2.this.satelliteLogos.resolveTargetIcon(206);
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateSatellite() - resourceID for map kombi colored icon is : %1", (long)n2);
                SatelliteMapsMediatorFSM2.this.updateSatelliteMapsLogos(n2);
            }
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
            SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(1);
            if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                SatelliteMapsMediatorFSM2.this.gui.redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
            }
            SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
        }

        void updateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateStandard()");
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateStandard() was sat maps confirmed %1 waitfor standard", this.confirmed, this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps);
            if (this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps) {
                SatelliteMapsMediatorFSM2.this.logger.log(100000, "SatellitemapActiveState#updateStandard()  - we had to wait wait for standard - arrived");
                this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
                if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                    SatelliteMapsMediatorFSM2.this.gui.showFunctionCurrentlyNotAvailableHelpTextWithTimeout();
                }
                SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(1);
                SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
                SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
                SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(false);
            }
            if (this.confirmed) {
                SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#updateStandard() sat maps was confirmed show Deactivatipon Popup");
                this.confirmed = false;
                SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
                SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
                if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                    SatelliteMapsMediatorFSM2.this.gui.redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
                    SatelliteMapsMediatorFSM2.this.gui.showFunctionCurrentlyNotAvailableHelpText();
                }
            }
            SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveState#setBlockingBit() blocked %1", bl);
            if (bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveStateSATBlocked);
            }
        }

        boolean isConfirmed() {
            return this.confirmed;
        }

        void exit() {
            super.exit();
            if (SatelliteMapsMediatorFSM2.this.terminal == 0) {
                SatelliteMapsMediatorFSM2.this.gui.redrawFunctionCurrentlyNotAvailableHelpTextWithTimeout();
            }
            this.waitForStandardMapStyleUpdateBeforeSwitchToSatMaps = false;
            this.confirmed = false;
        }
    }

    private class TrafficmapActiveStateSATBlocked
    extends SatelliteMapState {
        public TrafficmapActiveStateSATBlocked(String string) {
            super(string);
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficmapActiveStateSATBlocked#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveStateSATBlocked);
        }

        void activateStandard() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficmapActiveStateSATBlocked#activateStandard()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveStateSATBlocked);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "TrafficmapActiveStateSATBlocked#setBlockingBit()  blocked %1", bl);
            if (!bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveState);
            }
        }
    }

    private class StandardmapActiveStateSATBlocked
    extends SatelliteMapState {
        public StandardmapActiveStateSATBlocked(String string) {
            super(string);
        }

        void activateSatellite() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveStateSATBloccked#activateSatellite()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveStateSATBlocked);
        }

        void activateTraffic() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveStateSATBlocked#activateTraffic()");
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveStateSATBlocked);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "StandardmapActiveState#setBlockingBit()  blocked %1", bl);
            if (!bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveState);
            }
        }
    }

    private class SatellitemapActiveStateSATBlocked
    extends SatelliteMapState {
        public SatellitemapActiveStateSATBlocked(String string) {
            super(string);
        }

        void enter() {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveStateSATBlocked#enter()");
            SatelliteMapsMediatorFSM2.this.switchMapStyleAtMapDSI(0);
            SatelliteMapsMediatorFSM2.this.setLogosAccordingToSetup();
            SatelliteMapsMediatorFSM2.this.env.getChoiceModel(400441).setValue(0);
            SatelliteMapsMediatorFSM2.this.notifyClusterAboutSatMapsState(SatelliteMapsMediatorFSM2.this.hasProviderChanged);
        }

        void activateStandard() {
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.standardmapActiveStateSATBlocked);
        }

        void activateTraffic() {
            SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.trafficmapActiveStateSATBlocked);
        }

        public void setBlockingBit(boolean bl) {
            SatelliteMapsMediatorFSM2.this.logger.log(10000000, "SatellitemapActiveStateSATBlocked#setBlockingBit() blocked %1", bl);
            if (!bl) {
                SatelliteMapsMediatorFSM2.this.changeState(SatelliteMapsMediatorFSM2.this.satellitemapActiveState);
            }
        }
    }
}

