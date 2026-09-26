/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.instances;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.HasRouteInfo;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IGUIFactory;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.IRouteInfo$IRouteInfoHandlerEnv;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.impl.MapContentSyncHandler;
import de.audi.tghu.navi.app.map.instances.MapMain$1;
import de.audi.tghu.navi.app.map.instances.MapMain$2;
import de.audi.tghu.navi.app.map.instances.MapMain$3;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHandler;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavSegmentID;

public class MapMain
extends AbstractMap
implements HasRouteInfo {
    protected IRouteInfo routeInfo = null;
    private boolean bStdMapInitiated = false;
    private boolean bGEInitiated = false;

    public MapMain(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, IGUIFactory iGUIFactory, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        super(navigationEnv, mapManager, mapConfig, iconHandler, mapInterface, iNaviInterface, locationSerializer, mapSelectionHandlerFactory);
        this.setGUIInterface(iGUIFactory.createGUIMain(navigationEnv, this));
        this.initializeRouteInfoHandler(navigationEnv, iconHandler, this.getRouteInfoEnv());
        if (this.mapDataContainer.sMapContentList == null) {
            this.mapDataContainer.sMapContentList = this.createMapContentSyncHandler(navigationEnv, iconHandler);
            iNaviInterface.getPOICategoryManager().registerObserver(this.mapDataContainer.sMapContentList);
        }
        try {
            BaseListModelApp baseListModelApp = navigationEnv.getBaseListModel(-316799488);
            baseListModelApp.removeAll();
            if (this.getZoomHandler().getZoomList() == null) {
                float[] fArray = this.getZoomHandler().getZoomList();
                for (int i2 = 0; i2 < fArray.length; ++i2) {
                    EvoListRow evoListRow = new EvoListRow(i2, 1);
                    evoListRow.setLong(0, (long)fArray[i2]);
                    baseListModelApp.append(evoListRow);
                }
            }
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.createOptMenuRubberbandListener();
        this.createShowAltRouteListener();
        this.createDDSEnterListener();
    }

    protected MapContentSyncHandler createMapContentSyncHandler(NavigationEnv navigationEnv, IconHandler iconHandler) {
        return new MapContentSyncHandler(navigationEnv, iconHandler, this, this.getViews().createMapContentViewMain(), this.getViews().createAsiaMapContentView());
    }

    protected void createDDSEnterListener() {
        this.getViews().getRouteBriefingView().setDDSEnterListener(new MapMain$1(this));
    }

    protected void createShowAltRouteListener() {
        this.getViews().getMainMapView().setShowAltRouteListener(new MapMain$2(this));
    }

    protected void createOptMenuRubberbandListener() {
        this.getViews().getMainMapView().addOptMenuRubberbandListener(new MapMain$3(this));
    }

    protected void initializeRouteInfoHandler(NavigationEnv navigationEnv, IconHandler iconHandler, IRouteInfo$IRouteInfoHandlerEnv iRouteInfo$IRouteInfoHandlerEnv) {
        this.routeInfo = new RouteInfoHandler(navigationEnv, iconHandler, this.getRouteInfoEnv());
    }

    @Override
    public void mapInitialized() {
        super.mapInitialized();
        this.getNaviInterface().mapInitialized(true);
    }

    @Override
    public void mapNotInitialized() {
        super.mapNotInitialized();
        this.getNaviInterface().mapInitialized(false);
    }

    @Override
    public String getName() {
        return "MapMain";
    }

    @Override
    protected boolean isSwitchContextAllowed() {
        IContext iContext = this.getActiveContext();
        int n = this.getSetup().getAutoZoom(true);
        return !iContext.getManoeuvreZoomDisabledWithReturn() && this.getZoomEngineState() == 3 && (n == 1 || n == 0);
    }

    @Override
    public IRouteInfo getRouteInfo() {
        return this.routeInfo;
    }

    @Override
    public void hideRouteInfo() {
        this.getMapLogChannel().log(14808325, "MapMain#hideRouteInfo()");
        this.getRouteInfo().hide();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void initDSI() {
        boolean bl = false;
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.allStdMapDSIsReceived()) {
                if (!this.bStdMapInitiated) {
                    this.sMapLogChannel.log(1078071040, "MapMain#init() - all StdMap DSIs received. Starting initialization...");
                    this.bStdMapInitiated = true;
                    this.switchToContext(1);
                }
            } else if (this.bStdMapInitiated) {
                this.sMapLogChannel.log(-1601830656, "MapMain#init() - StdMap DSIs failed! StdMap is not operable any more!");
                this.bStdMapInitiated = false;
                this.getMVRequest().getMVRequestStd().setOperable(false);
                this.switchToContext(0);
                bl = true;
                super.mapNotInitialized();
            }
        }
        if (bl) {
            this.getNaviInterface().mapInitialized(false);
        }
        object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.mapConfig.hasGoogleEarth()) {
                boolean bl2 = this.allGEDSIsReceived();
                this.naviInterface.googleEarthUpdateStatusCompleted(0, bl2);
                if (bl2) {
                    if (!this.bGEInitiated) {
                        this.sMapLogChannel.log(1078071040, "MapMain#init() - all GE DSIs received. Starting initialization...");
                        Util.logStartupEvent(this.env.getFramework(), "[Startup] MapMain#initDSI() - all GE DSIs received. Starting initialization...");
                        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("MapMain#initDSI() - Google Earth map enabled in setup: ").append(this.getMapRepresentation() == 1));
                        this.bGEInitiated = true;
                    }
                } else if (this.bGEInitiated) {
                    this.sMapLogChannel.log(-1601830656, "MapMain#init() - GE DSIs failed! GE is not operable any more!");
                    this.bGEInitiated = false;
                    this.getMVRequest().getMVRequestGoogleCtrl().setOperable(false);
                }
            }
        }
    }

    @Override
    public boolean isStdMapInitiated() {
        return this.bStdMapInitiated;
    }

    @Override
    protected boolean isGEInitiated() {
        return this.bGEInitiated;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void hideMapInMapPictureDest() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            int n = this.getActiveContextIndex();
            this.getMapLogChannel().log(-2137614336, "MapMain#hideMapInMapPictureDest() - activeContext: %1", (long)n);
            if (n == 27) {
                this.switchToContext(3);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void forceHiddenContextRefresh() {
        this.sMapLogChannel.log(1078071040, "MapMain#forceHiddenContextRefresh()");
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            this.forceSwitchToAShownContext();
            this.forceSwitchToContext(3, SwitchContextEnum.ContextRefresh);
        }
    }

    @Override
    protected void beforeSwitch(int n, int n2) {
        this.setScreen(n2);
    }

    public void setScreen(int n) {
        switch (n) {
            case 5: {
                this.getGuiInterface().switchToRouteSelectionSidebar(0);
                this.getGuiInterface().switchMapScreen(1);
                break;
            }
            case 33: {
                this.getGuiInterface().switchToRouteSelectionSidebar(-1);
                this.getGuiInterface().switchMapScreen(1);
                break;
            }
            case 20: {
                this.getGuiInterface().switchMapScreen(2);
                break;
            }
            case 34: {
                this.getGuiInterface().switchMapScreen(3);
                break;
            }
            case 18: {
                this.getGuiInterface().switchMapScreen(6);
                break;
            }
            case 12: 
            case 13: 
            case 39: {
                this.getGuiInterface().switchMapScreen(4);
                break;
            }
            case 15: 
            case 28: 
            case 37: {
                this.getGuiInterface().switchMapScreen(4);
                break;
            }
            case 30: {
                if (!this.getMapDataContainer().isInMap) break;
                this.getMapLogChannel().log(-1601830656, "MapMain#switchToContext() - still in map screen, cound not switch to previewmap");
                return;
            }
            case 3: {
                break;
            }
            default: {
                this.getGuiInterface().switchMapScreen(0);
            }
        }
    }

    @Override
    protected ChoiceModelApp getActiveRendererChoice() {
        return this.env.getChoiceModel(958137856);
    }

    @Override
    public void showPreviewMap() {
        if (!Util.isPreviewMapPresent(this.env.getFramework())) {
            this.sMapLogChannel.log(14808325, "MapMain#showPreviewMap() - Preview map not available! ");
            return;
        }
        if (!this.getNaviInterface().getOperationManager().isFullyOperable()) {
            this.sMapLogChannel.log(-1601830656, "MapMain#showPreviewMap() - Navi not operable! ");
            return;
        }
        int n = this.getLastVisibleCID();
        boolean bl = !MapUtils.isPreviewMapContext(n);
        this.sMapLogChannel.log(-2137614336, "MapMain#showPreviewMap() - isBackupMapStateRequired: %1 (lastVisibleCID=%2)", bl, (long)n);
        if (bl) {
            this.backupMapState();
        }
        this.switchToContext(30);
    }

    @Override
    public void hide() {
        this.sMapLogChannel.log(-2137614336, "MapMain#hide()");
    }

    public void calculateAlternativeRoutes(boolean bl) {
        if (!this.getMapDataContainer().sRGActive) {
            this.getMapLogChannel().log(-1601830656, "MapMain#calculateAlternativeRoutes() - rgActive = false. Alternative route will not be calculated.");
            return;
        }
        this.getMapLogChannel().log(-2137614336, "MapMain#calculateAlternativeRoutes()");
        this.getRouteCalculationHandler().onStartRouteCalculation(false, bl, null);
        this.getRouteCalculationHandler().calculateAlternativeRoutes();
        this.getNaviInterface().calculateAlternativeRoutes();
        this.switchToContext(5);
    }

    @Override
    public void viewSizeChanged(int n) {
        this.getMapLogChannel().log(-2137614336, "MapMain#viewSizeChanged() - newViewSize: %1 ", (long)n);
        this.getActiveCtx().viewSizeChanged(n);
    }

    @Override
    protected int determineShownContext() {
        this.sMapLogChannel.log(1078071040, "MapMain#determineShownContext - getSetupMapType() = %1, mForcedContext = %2", (long)this.getSetup().getMapType(true), (long)this.ctxTimeline.getIntention());
        int n = 6;
        if (this.getShowTrigger(true) == 1) {
            this.getMapLogChannel().log(-1601830656, "MapMain#determineShownContext() - triggered by [show in map]");
            n = 13;
            return n;
        }
        if (this.getRouteCalculationHandler().isRGAboutToBeStarted()) {
            n = this.getRouteCalculationHandler().isSingleRoute() ? 33 : 5;
            this.ctxTimeline.clearIntention();
        } else if (this.ctxTimeline.getIntention() != -1) {
            if (this.getMapDataContainer().viewSize == 1 && !MapUtils.isCtxAllowedInSmallStage(this.ctxTimeline.getIntention())) {
                this.getMapLogChannel().log(-1601830656, "MapMain#determineShownContext() - can not enter crosshair mode in small stage");
            } else {
                n = this.ctxTimeline.getIntention();
            }
            this.ctxTimeline.clearIntention();
        } else {
            n = MapUtils.isRSERouteCalcMode(this.env.getFramework()) ? 22 : super.determineShownContext();
        }
        return n;
    }

    public int determineContext(int n) {
        int n2 = this.getActiveContextIndex();
        int n3 = this.getLastCtxShownID();
        this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - active CID: %2, last shown CID: %3", (long)n, (long)n2, (long)n3);
        int n4 = -1;
        switch (n) {
            case 1: {
                return 13;
            }
            case 2: {
                if (this.getMapDataContainer().isInNavi) {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show online map inside navi");
                } else {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show online map outside navi");
                }
                return 15;
            }
            case 3: {
                if (this.getMapDataContainer().isInNavi) {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show remoteHMI map inside navi");
                } else {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show remoteHMI map outside navi");
                }
                return 28;
            }
            case 8: {
                if (this.getMapDataContainer().isInNavi) {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show operator call map inside navi");
                } else {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - show operator call map outside navi");
                }
                return 37;
            }
            case 4: {
                return 34;
            }
            case 6: {
                return 18;
            }
        }
        IRouteCalculator iRouteCalculator = this.getRouteCalculationHandler();
        if (n2 == 20 && iRouteCalculator.hasBetterRoute()) {
            this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - already in SDRG screen", (long)n);
            return 20;
        }
        if (iRouteCalculator.isCalculatingSingleRoute() && iRouteCalculator.getWaitForAvailableRoute()) {
            this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - single route calculating", (long)n);
            return 33;
        }
        if (iRouteCalculator.isRGAboutToBeStarted() || (iRouteCalculator.isCalculatingSingleRoute() || iRouteCalculator.isCalculatingAltRoutes()) && iRouteCalculator.getWaitForAvailableRoute()) {
            this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - route calculating", (long)n);
            return this.getRouteCalculationHandler().isSingleRoute() ? 33 : 5;
        }
        if (!this.getMapDataContainer().isInMap && this.getLastVisibleCtxInsideNaviMap() != 0 && this.getLastVisibleCtxInsideNaviMap() != 34) {
            this.getMapLogChannel().log(-2137614336, "MapMain#determineContext() - restore last visible ctx inside navi map");
            return this.getLastVisibleCtxInsideNaviMap();
        }
        if (MapUtils.isPreviewMapContext(n2) || MapUtils.isHiddenContext(n2)) {
            switch (n3) {
                case 15: 
                case 18: 
                case 28: 
                case 33: 
                case 34: 
                case 36: {
                    break;
                }
                case 5: {
                    if (!this.getRouteCalculationHandler().isCalculatingAltRoutes()) break;
                    return n3;
                }
                default: {
                    this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - restore last context", (long)n);
                    return n3;
                }
            }
        }
        if (n4 == -1) {
            this.getMapLogChannel().log(-2137614336, "MapMain#determineContext( %1 ) - according to settings", (long)n);
            int n5 = this.ctxTimeline.getIntention();
            n4 = this.determineShownContext();
            this.ctxTimeline.setIntention(n5);
        }
        return n4;
    }

    @Override
    public void switchToHiddenContext() {
        if (this.getRouteCalculationHandler().isRouteCalculationActive()) {
            this.switchToContext(this.getRouteCalculationHandler().isSingleRoute() ? 33 : 5);
        }
        super.switchToHiddenContext();
    }

    @Override
    public void forceSwitchToContext(int n, SwitchContextEnum switchContextEnum) {
        super.forceSwitchToContext(n, switchContextEnum);
        this.fireMapEvent(102, this.getActiveContextIndex());
    }

    @Override
    public void showRouteBriefing(int n) {
        this.getMapLogChannel().log(-2137614336, "MapMain#showRouteBriefing( %1 )", (long)n);
        this.forceContext(-1);
        this.forceSwitchToContext(n == 3 ? 5 : 33, SwitchContextEnum.ShowRouteBriefing);
    }

    public void showPredictiveNavigationRoutes(NavSegmentID[] navSegmentIDArray) {
    }

    public void previewPredictiveNavigationRoute(NavSegmentID navSegmentID) {
    }

    @Override
    public void enterAlternativeRoutes() {
        this.getMapDataContainer().enterAltRoutesFromRightDrawer = true;
        this.getRouteCalculationHandler().setCalcFurtherAltRoutes(true);
        this.calculateAlternativeRoutes(true);
    }
}

