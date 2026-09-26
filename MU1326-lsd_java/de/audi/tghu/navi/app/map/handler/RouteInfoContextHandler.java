/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.instances.MinorMap;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;

public class RouteInfoContextHandler
implements MapConsts,
IRouteInfoContextHandler {
    protected MapDataContainer container;
    protected volatile short[] manoeuvreViewsAvailable;
    protected volatile boolean mapInMapVisible;
    protected volatile boolean mapInMapUnfrozen;
    private MapManager mapManager;
    protected NavigationEnv env;
    protected final MapMain naviMap;
    private MinorMap naviMapInMap;
    protected volatile int requestedManeuverView = 255;
    protected volatile boolean requestedMapInMap = false;
    private volatile boolean requestedMapInMapOn = false;
    private volatile boolean requestedMapInMapOff = false;

    public RouteInfoContextHandler(MapManager mapManager, MapMain mapMain, NavigationEnv navigationEnv) {
        this.env = navigationEnv;
        this.mapManager = mapManager;
        this.naviMap = mapMain;
        this.container = mapMain != null ? mapMain.getMapDataContainer() : null;
    }

    @Override
    public void setMinorMap(MinorMap minorMap) {
        this.naviMapInMap = minorMap;
    }

    protected LogChannel getLogChannel() {
        return this.naviMap.getMapLogChannel();
    }

    private LogChannel getGuidanceLogChannel() {
        return this.naviMap.getMapGuidanceLogChannel();
    }

    protected static boolean isManeuverViewValid(int n) {
        boolean bl;
        switch (n) {
            case 1: 
            case 2: 
            case 3: 
            case 4: {
                bl = true;
                break;
            }
            default: {
                bl = false;
            }
        }
        return bl;
    }

    @Override
    public synchronized void cleanup() {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void handleCurrentRouteInfoContext() {
        IContext iContext = this.naviMap.getActiveContext();
        boolean bl = iContext.getRGActive();
        boolean bl2 = this.naviMap.getSetup().isMapInMapEnabled();
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#handleCurrentRouteInfoContext() - %1", (Object)new Buffer().append("rgActive").append(bl ? "[+]" : "[-]").append(", ").append("isMapInMapEnabled").append(bl2 ? "[+]" : "[-]").append(", ").append("sShowManeuverViews").append(this.container.sShowManeuverViews ? "[+]" : "[-]").append(", ").append("isCrossingViewEnabled").append(this.naviMap.getSetup().isCrossingViewEnabled() ? "[+]" : "[-]").append(", ").append("isRSERouteCalcMode").append(MapUtils.isRSERouteCalcMode(this.naviMap.getNavigationEnv().getFramework()) ? "[+]" : "[-]").append(", ").append("isManeuverViewRequested").append(this.isManeuverViewRequested() ? "[+]" : "[-]").append(", ").toString());
        }
        RouteInfoContextHandler routeInfoContextHandler = this;
        synchronized (routeInfoContextHandler) {
            if (bl || bl2) {
                int n = this.getFirstAvailableManeuverView(this.manoeuvreViewsAvailable);
                if (this.container.sShowManeuverViews && RouteInfoContextHandler.isManeuverViewValid(n) && this.naviMap.getSetup().isCrossingViewEnabled()) {
                    this.getLogChannel().log(14808325, "RouteInfoContextHandler#handleCurrentRouteInfoContext() - maneuverView should be requested");
                    int n2 = this.naviMap.getMVResponseManeuverView().getManoeuvreViewActive();
                    if (!this.isManeuverViewRequested() || n2 != n) {
                        this.requestManeuverView(n);
                    }
                } else if (this.isManeuverViewRequested()) {
                    this.fadeOutManeuverView();
                }
                if (this.container.sShowMapInMap && bl2 && !this.isManeuverViewRequested() && this.isMapInMapOperable()) {
                    this.getLogChannel().log(14808325, "RouteInfoContextHandler#handleCurrentRouteInfoContext() - map-in-map should be requested");
                    if (!(this.requestedMapInMap && this.mapInMapVisible && this.mapInMapUnfrozen)) {
                        this.requestMapInMap(0);
                    }
                } else if (this.requestedMapInMap) {
                    this.fadeOutMapInMap();
                }
            } else {
                this.requestedManeuverView = 255;
                this.requestedMapInMap = false;
            }
        }
        this.refreshDisplayContext();
        this.naviMap.getRouteInfo().show();
    }

    @Override
    public boolean isManeuverViewVisible() {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#isManeuverViewVisible() - sRequestedDisplayContextID: %3 , sVisibleDisplayContextID: %2, sDisplayContextAnimationRunning: %1", this.container.sDisplayContextAnimationRunning, (Object)MapUtils.contextToString(this.container.sVisibleDisplayContextID), (Object)MapUtils.contextToString(this.container.sRequestedDisplayContextID));
        }
        return this.container.sDisplayContextAnimationRunning && this.container.sRequestedDisplayContextID != 0 && this.container.sRequestedDisplayContextID != 6 || this.container.sVisibleDisplayContextID != 0 && this.container.sVisibleDisplayContextID != 6;
    }

    @Override
    public boolean isRouteInfoAllowedToFadeIn() {
        boolean bl;
        boolean bl2 = Util.isClusterKDKAvailable(this.env.getFramework()) ? true : (bl = (!this.isManeuverViewRequested() || this.naviMap.getMapDataContainer().sDisableKDKTemporarily) && !this.isManeuverViewVisible());
        boolean bl3 = !Util.isMapInMapAvailable(this.env.getFramework()) ? true : !this.requestedMapInMap && !this.isMapInMapVisible();
        return this.container.sVisibleDisplayContextID == 0 && bl && bl3;
    }

    @Override
    public void signalManeuverViewActive() {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#signalManeuverViewActive()");
        this.refreshDisplayContext();
    }

    @Override
    public synchronized void signalMapHidden() {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#signalMapHidden() ");
        this.fadeOutMapInMap();
    }

    @Override
    public void signalMapInMapInoperable() {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#signalMapInMapInoperable()");
        this.refreshDisplayContext();
    }

    @Override
    public void signalRouteInfoHidden() {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#signaRouteInfoHidden()");
        this.refreshDisplayContext();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateDisplayContext(int n) {
        if (this.getLogChannel().isInfo()) {
            this.getLogChannel().log(1078071040, "RouteInfoContextHandler#updateDisplayContext() - context: %1", (Object)new Buffer(100).append(MapUtils.contextToString(n)).append(", mapInMapUnfrozen: ").append(this.mapInMapUnfrozen).append(", mapInMapVisible: ").append(this.mapInMapVisible).append(", requestedMapInMap: ").append(this.requestedMapInMap));
        }
        RouteInfoContextHandler routeInfoContextHandler = this;
        synchronized (routeInfoContextHandler) {
            if (this.isManeuverViewActive() && (n == 0 || n == 6) && !this.isManeuverViewRequested()) {
                this.getLogChannel().log(1078071040, "RouteInfoContextHandler#updateDisplayContext() - hiding maneuver view");
                this.hideManeuverView();
            }
            if ((this.mapInMapUnfrozen || this.mapInMapVisible) && n != 6 && !this.requestedMapInMap) {
                this.getLogChannel().log(1078071040, "RouteInfoContextHandler#updateDisplayContext() - hiding map-in-map");
                this.notifyMapInMapOff();
            }
        }
        this.naviMap.getRouteInfo().show();
    }

    @Override
    public synchronized void updateDistanceToNextManeuver(String string) {
        boolean bl = this.isManeuverViewRequested();
        this.getGuidanceLogChannel().log(14808325, "RouteInfoContextHandler#updateDistanceToNextManeuver() - isManeuverViewRequested: %1, distString: %2 ", bl, (Object)string);
        if (bl) {
            this.naviMap.getMVRequest().getMVRequestManeuverView().setDistanceString(string);
        }
    }

    @Override
    public synchronized void updateManoeuvreViewsAvailable(short[] sArray) {
        int n = sArray == null ? 0 : sArray.length;
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#updateManoeuvreViewsAvailable() - length: %1", (long)n);
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#updateManoeuvreViewsAvailable() - maneuver: %1", (long)sArray[0]);
        this.manoeuvreViewsAvailable = sArray;
    }

    @Override
    public synchronized void updateMapInMapViewVisibleAndUnfrozen(boolean bl, boolean bl2) {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#updateMapInMapViewVisibleAndUnfrozen() - viewVisible: %1, viewUnfrozen: %2", bl, bl2);
        this.mapInMapUnfrozen = bl2;
        this.mapInMapVisible = bl;
        if (bl && bl2) {
            this.requestedMapInMapOn = false;
        } else if (!bl && !bl2) {
            this.requestedMapInMapOff = false;
        }
        if (this.container.sShowMapInMap && this.naviMap.getActiveContext() instanceof CtxShown) {
            this.handleCurrentRouteInfoContext();
        }
    }

    protected int computeDisplayContextID() {
        int n;
        boolean bl = this.isManeuverViewRequested();
        boolean bl2 = this.naviMap.getRouteInfo().isMixedListVisible();
        int n2 = this.naviMap.getMVResponseManeuverView().getManoeuvreViewActive();
        if (bl2) {
            n = 0;
        } else if (!bl) {
            n = this.requestedMapInMap && this.mapInMapVisible && this.mapInMapUnfrozen && this.naviMap.getMapDataContainer().sRGActive ? 6 : 0;
        } else {
            switch (n2) {
                case 1: {
                    n = 4;
                    break;
                }
                case 4: {
                    n = 3;
                    break;
                }
                case 2: {
                    n = 1;
                    break;
                }
                case 3: {
                    n = 2;
                    break;
                }
                default: {
                    n = 0;
                }
            }
        }
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#computeDisplayContextID() - %1", (Object)new Buffer(100).append("mixedListVisible=").append(bl2).append(", maneuverViewRequested=").append(bl).append(", manoeuvreViewActive=").append(n2).append(", requestedMapInMap=").append(this.requestedMapInMap).append(" => contextID=").append(n));
        return n;
    }

    protected synchronized void fadeOutManeuverView() {
        this.getLogChannel().log(14808325, "RouteInfoContextHandler#fadeOutManeuverView() ");
        this.requestedManeuverView = 255;
        this.hideManeuverView();
    }

    protected synchronized void fadeOutMapInMap() {
        this.getLogChannel().log(14808325, "RouteInfoContextHandler#fadeOutMapInMap() ");
        this.requestedMapInMap = false;
        this.notifyMapInMapOff();
    }

    protected int getFirstAvailableManeuverView(short[] sArray) {
        int n = sArray != null && sArray.length > 0 ? sArray[0] : 255;
        this.getLogChannel().log(14808325, "RouteInfoContextHandler#getAvailableManeuverView() - maneuverView = %1", (long)n);
        return n;
    }

    protected void hideManeuverView() {
        boolean bl = this.isManeuverViewActive();
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#hideManeuverView() - maneuverViewActiv = %1", bl);
        if (bl) {
            this.naviMap.getMVRequest().getMVRequestManeuverView().hideManoeuvreView();
        }
    }

    @Override
    public boolean isManeuverViewAvailable() {
        int n = this.getFirstAvailableManeuverView(this.manoeuvreViewsAvailable);
        return RouteInfoContextHandler.isManeuverViewValid(n);
    }

    protected boolean isManeuverViewActive() {
        return this.naviMap.getMVResponseManeuverView().getManoeuvreViewActive() != 255;
    }

    @Override
    public boolean isManeuverViewRequested() {
        return this.requestedManeuverView != 255;
    }

    private boolean isMapInMapVisible() {
        if (this.getLogChannel().isDebug()) {
            this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#isMapInMapVisible() - sVisibleDisplayContextID: %1", (Object)MapUtils.contextToString(this.container.sVisibleDisplayContextID));
        }
        return this.container.sDisplayContextAnimationRunning && this.container.sRequestedDisplayContextID == 6 || this.container.sVisibleDisplayContextID == 6;
    }

    protected synchronized void notifyMapInMapOff() {
        if (this.naviMapInMap == null) {
            this.getLogChannel().log(14808325, "RouteInfoContextHandler#notifyMapInMapOff() - no MapInMap");
            return;
        }
        boolean bl = this.isMapInMapOperable();
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#notifyMapInMapOff() - mapInMapOperable = %1", bl);
        this.requestedMapInMapOn = false;
        if (!this.requestedMapInMapOff && bl) {
            this.requestedMapInMapOff = true;
            this.naviMapInMap.hide();
        }
    }

    private synchronized void notifyMapInMapOn(int n) {
        if (this.naviMapInMap == null) {
            this.getLogChannel().log(14808325, "RouteInfoContextHandler#notifyMapInMapOff() - no MapInMap");
            return;
        }
        boolean bl = this.isMapInMapOperable();
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#notifyMapInMapOn() - mapInMapOperable = %1", bl);
        this.requestedMapInMapOff = false;
        if (!this.requestedMapInMapOn && bl) {
            this.requestedMapInMapOn = true;
            this.naviMapInMap.showMapInMap(n);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void refreshDisplayContext() {
        IRouteInfo iRouteInfo = this.naviMap.getRouteInfo();
        synchronized (iRouteInfo) {
            int n = this.computeDisplayContextID();
            this.naviMap.getActiveContext().switchDisplayContext(n);
        }
    }

    protected void requestManeuverView(int n) {
        this.getLogChannel().log(-2137614336, "RouteInfoContextHandler#requestManeuverView() - maneuverView: %1", (long)n);
        this.requestedManeuverView = n;
        this.naviMap.getActiveContext().refreshDistanceToNextManeuver();
        this.selectManeuverView(n);
    }

    protected void requestMapInMap(int n) {
        this.getLogChannel().log(14808325, "RouteInfoContextHandler#requestMapInMap() - mapmode=%1", (long)n);
        this.requestedMapInMap = true;
        this.notifyMapInMapOn(n);
    }

    protected void selectManeuverView(int n) {
        this.getLogChannel().log(14808325, "RouteInfoContextHandler#selectManeuverView( %1 )", (long)n);
        this.naviMap.getMVRequest().getMVRequestManeuverView().selectManoeuvreView(n, true);
    }

    protected boolean isMapInMapOperable() {
        return this.mapManager.isMapInMapOperable();
    }

    @Override
    public synchronized void updateDistanceToNextManeuver(int n, int n2) {
    }

    @Override
    public void fillModelsAccordingToLayerVisibility() {
    }

    @Override
    public boolean isOffroadModeActive() {
        return this.env.getChoiceModel(-1122236928).getValue() == 1;
    }

    @Override
    public void signalCompassHidden() {
    }
}

