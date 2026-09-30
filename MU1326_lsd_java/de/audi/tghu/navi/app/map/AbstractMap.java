/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.maptmc.MapTmcService;
import de.audi.atip.interapp.navigation.previewmap.IPreviewMap;
import de.audi.atip.log.LogChannel;
import de.audi.atip.mmicombi.IViewSizeListener;
import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.command.CommandListManager;
import de.audi.tghu.command.ICommandListFactory;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.LocationSerializer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IContext;
import de.audi.tghu.navi.app.map.IMapContent;
import de.audi.tghu.navi.app.map.INaviInterface;
import de.audi.tghu.navi.app.map.ISatelliteMapsManager;
import de.audi.tghu.navi.app.map.MapConfig;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.MapInterface;
import de.audi.tghu.navi.app.map.MapManager;
import de.audi.tghu.navi.app.map.SatelliteMapsManager;
import de.audi.tghu.navi.app.map.command.MapCommandListFactory;
import de.audi.tghu.navi.app.map.command.MapCommandListSupplier;
import de.audi.tghu.navi.app.map.constants.SwitchContextEnum;
import de.audi.tghu.navi.app.map.context.CtxHidden;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.dsi.MVRequestGoogleCtrl;
import de.audi.tghu.navi.app.map.dsi.MVRequestManeuverView;
import de.audi.tghu.navi.app.map.dsi.MVRequestZoomEngine;
import de.audi.tghu.navi.app.map.dsi.MVResponseControl;
import de.audi.tghu.navi.app.map.dsi.MVResponseGoogleCtrl;
import de.audi.tghu.navi.app.map.dsi.MVResponseManeuverView;
import de.audi.tghu.navi.app.map.dsi.MVResponseZoomEngine;
import de.audi.tghu.navi.app.map.dsi.MapFlagHandler;
import de.audi.tghu.navi.app.map.dsi.MapResponseDispatcher;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler;
import de.audi.tghu.navi.app.map.event.IEventBroker;
import de.audi.tghu.navi.app.map.event.MapEventListener;
import de.audi.tghu.navi.app.map.gui.IMapTooltip;
import de.audi.tghu.navi.app.map.gui.ViewFactory;
import de.audi.tghu.navi.app.map.handler.IMapFlagHandler;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.IRouteInfoContextHandler;
import de.audi.tghu.navi.app.map.handler.ISetupHandler;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.ZoomEventListener;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapSelectionHandlerFactory;
import de.audi.tghu.navi.app.map.instances.ContextTimeline;
import de.audi.tghu.navi.app.map.instances.MapKombi;
import de.audi.tghu.navi.app.map.routecalc.IRouteCalculator;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.map.utils.NullFactory;
import de.audi.tghu.navi.app.util.addressformatting.ITooltipFormatter;
import de.audi.tghu.navi.app.util.addressformatting.TooltipFormatter;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.Formatter;
import java.util.HashMap;
import java.util.Iterator;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.DSIMapViewerManeuverView;
import org.dsi.ifc.map.DSIMapViewerZoomEngine;
import org.dsi.ifc.map.MapFlag;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class AbstractMap
implements MapConsts,
IViewSizeListener,
MapSelectionHandler.IMapSelectionListener,
MapEventListener,
IZoomHandler.IZoomHandlerEnv,
SpeedThresholdListener {
    protected final NavigationEnv env;
    protected final MapManager mapMgr;
    protected final MapConfig mapConfig;
    private IMapFlagHandler mapFlagHandler;
    private ISetupHandler setupHandler;
    protected ZoomHandler zoomHandler;
    protected final MapDataContainer mapDataContainer;
    private ISatelliteMapsManager satelliteMapsManager;
    protected MapSelectionHandler mapSelectionHandler;
    protected final INaviInterface naviInterface;
    protected GUIInterface guiInterface = null;
    protected final MapInterface mapInterface;
    protected MapSelectionHandlerFactory selectionHandlerFactory;
    protected MVRequest mvRequest;
    protected CommandListManager mapCommandListManager;
    protected MapResponseDispatcher mapResponseDispatcher;
    protected MapCommandListFactory commandListFactory;
    protected boolean mMapInitialized = false;
    protected LogChannel sMapLogChannel;
    protected LogChannel sMapGUILogChannel;
    protected LogChannel sMapDSILogChannel;
    protected LogChannel sMapGuidanceLogChannel;
    protected LogChannel sMapDSICtrlLogChannel;
    protected final HashMap mContext = new HashMap();
    protected ContextTimeline ctxTimeline = new ContextTimeline();
    protected volatile int mLastVisibleCtxInsideNaviMap = 0;
    protected volatile int mContextSwitchStatus = 0;
    protected int mLastForcedContext = -1;
    private final IconHandler iconHandler;
    private MapState lastState = null;
    private boolean isDeepSwitchingEnabled = false;
    public final LocationSerializer locationSerializer;
    protected ITooltipFormatter tooltipFormatter;
    static /* synthetic */ Class class$de$audi$tghu$navi$app$map$handler$ISetupHandler;

    protected AbstractMap(NavigationEnv navigationEnv, MapManager mapManager, MapConfig mapConfig, IconHandler iconHandler, MapInterface mapInterface, INaviInterface iNaviInterface, LocationSerializer locationSerializer, MapSelectionHandlerFactory mapSelectionHandlerFactory) {
        this.env = navigationEnv;
        this.mapMgr = mapManager;
        this.mapConfig = mapConfig;
        this.locationSerializer = locationSerializer;
        this.mapDataContainer = new MapDataContainer();
        this.mapInterface = mapInterface;
        this.naviInterface = iNaviInterface;
        this.iconHandler = iconHandler;
        this.selectionHandlerFactory = mapSelectionHandlerFactory;
        int n = mapConfig.getMapInstanceId();
        this.sMapLogChannel = MapUtils.getMapLogChannel(navigationEnv, n);
        this.sMapDSILogChannel = MapUtils.getMapDSILogChannel(navigationEnv, n);
        this.sMapGUILogChannel = MapUtils.getMapGUILogChannel(navigationEnv, n);
        this.sMapDSICtrlLogChannel = MapUtils.getMapDSICtrlLogChannel(navigationEnv, n);
        this.sMapGuidanceLogChannel = navigationEnv.getLogChannel("App.Map.Guidance");
        this.mvRequest = new MVRequest(this, mapConfig, navigationEnv);
        this.satelliteMapsManager = n == 0 ? this.createSatelliteMapsManager(navigationEnv, 400441, 0) : (n == 3 ? this.createSatelliteMapsManager(navigationEnv, 401374, 1) : new SatelliteMapsManager(navigationEnv, this, -1, 0));
        int[] nArray = mapConfig.getSupportedContextClsIds();
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            IContext iContext = null;
            int n2 = nArray[i2];
            iContext = this.getMapManager().getContextFactory().createContext(n2, this, iconHandler);
            if (iContext != null) {
                this.mContext.put(new Integer(n2), iContext);
                continue;
            }
            this.sMapLogChannel.log(10000, "AbstractMap#AbstractMap(): error - context object for ctxtype %1 not found", (long)n2);
        }
        this.sMapLogChannel.log(10000000, "AbstractMap[%1]#<init> - ctx = %2", (Object)this.getName(), (Object)MapUtils.toString(nArray));
        this.mapCommandListManager = new CommandListManager(new StringBuffer().append("MapCommandLists-").append(this.getName()).toString(), navigationEnv.getFramework(), MapUtils.getMapCommandLogChannel(navigationEnv, mapConfig.getMapInstanceId()), new MapCommandListSupplier(navigationEnv, this), null);
        this.mapResponseDispatcher = new MapResponseDispatcher(navigationEnv, this.mapCommandListManager, this, this.sMapDSILogChannel);
        this.commandListFactory = new MapCommandListFactory(this.mapCommandListManager, this.mapResponseDispatcher, navigationEnv, this);
        this.mapCommandListManager.start();
        this.zoomHandler = new ZoomHandler(this);
        this.mapSelectionHandler = mapSelectionHandlerFactory.createSelectionHandler(this, iNaviInterface);
        this.mapSelectionHandler.addListener(this);
        this.tooltipFormatter = new TooltipFormatter(navigationEnv, this);
        this.ctxTimeline.add(0, this.getCtx(0));
        try {
            navigationEnv.getFramework().getSysApp().registerSpeedThresholdListener(this, 1);
        }
        catch (Exception exception) {
            this.sMapLogChannel.log(10000, "AbstractMap[%1]#<init> - can NOT register SpeedThresholdListener. ERROR=%2", (Object)this.getName(), (Throwable)exception);
        }
    }

    public abstract String getName();

    protected void cleanup() {
        GUIInterface gUIInterface;
        Object object;
        Object object2;
        HashMap hashMap;
        ZoomHandler zoomHandler = this.zoomHandler;
        if (zoomHandler != null) {
            zoomHandler.cleanup();
        }
        if ((hashMap = this.mContext) != null) {
            object2 = hashMap.values();
            object = object2.iterator();
            while (object.hasNext()) {
                ((IContext)object.next()).cleanup();
            }
        }
        if ((object2 = this.mapCommandListManager) != null) {
            ((CommandListManager)object2).destroy();
        }
        if ((object = this.mvRequest) != null) {
            ((MVRequest)object).cleanup();
        }
        if ((gUIInterface = this.guiInterface) != null) {
            gUIInterface.cleanup();
        }
        try {
            this.env.getFramework().getSysApp().unregisterSpeedThresholdListener(this);
        }
        catch (Exception exception) {
            this.sMapLogChannel.log(10000, "AbstractMap[%1]#<cleanup> - can NOT unregister SpeedThresholdListener. ERROR=%2", (Object)this.getName(), (Throwable)exception);
        }
    }

    public MapManager getMapManager() {
        return this.mapMgr;
    }

    public void setGUIInterface(GUIInterface gUIInterface) {
        this.guiInterface = gUIInterface;
    }

    public MapConfig getMapConfig() {
        return this.mapConfig;
    }

    public CommandListManager getMapCommandListManager() {
        return this.mapCommandListManager;
    }

    public MapResponseDispatcher getMapResponseDispatcher() {
        return this.mapResponseDispatcher;
    }

    private ICommandListFactory getCommandListFactory() {
        return this.commandListFactory;
    }

    public boolean showETAandDistanceToNextStopover() {
        return true;
    }

    public CommandList createCommandList() {
        return this.getCommandListFactory().createCommandList(1);
    }

    public IContext getCtx(int n) {
        IContext iContext = (IContext)this.mContext.get(new Integer(n));
        if (iContext == null) {
            this.getMapLogChannel().log(10000, "%1#getCtx(): error - context object (id = %2) not found", (Object)this, (long)n);
            Buffer buffer = new Buffer();
            buffer.append("AbstractMap#getCtx(): context id = {");
            Iterator iterator = this.mContext.keySet().iterator();
            while (iterator.hasNext()) {
                buffer.append(iterator.next());
                buffer.append(" ");
            }
            buffer.append("}");
            this.getMapLogChannel().log(10000000, buffer.toString());
        }
        return iContext;
    }

    public IMapFlagHandler getMapFlagHandler() {
        if (this.mapFlagHandler == null) {
            this.mapFlagHandler = new MapFlagHandler(new IMapFlagHandler.IMapFlagHandlerEnv(){

                public AdbEntry[] getTops() {
                    return AbstractMap.this.mapDataContainer.sTopDestinations;
                }

                public NavLocation getHome() {
                    return AbstractMap.this.mapDataContainer.sHomeAddress;
                }

                public NavLocation getOffice() {
                    return AbstractMap.this.mapDataContainer.sOfficeAddress;
                }

                public MapPin[] getContextDependedPins() {
                    return AbstractMap.this.getActiveContext().getDynamicPins();
                }

                public boolean isFavoriteVisible(int n) {
                    return AbstractMap.this.getSetup().isFavoriteVisible(n);
                }

                public IFavorite[] getFavorites() {
                    return AbstractMap.this.naviInterface.getFavorites();
                }

                public MapDataContainer getMapDataContainer() {
                    return AbstractMap.this.mapDataContainer;
                }

                public void configureFlags(int n, MapFlag[] mapFlagArray) {
                    AbstractMap.this.getMVRequest().configureFlags(n, mapFlagArray);
                }

                public LogChannel getLogger() {
                    return AbstractMap.this.getMapLogChannel();
                }
            });
        }
        return this.mapFlagHandler;
    }

    public void setMapFlagHandler(IMapFlagHandler iMapFlagHandler) {
        this.mapFlagHandler = iMapFlagHandler;
    }

    public void setDSIMapZoomEngine(DSIMapViewerZoomEngine dSIMapViewerZoomEngine) {
        if (this.mvRequest.getMVRequestZoomEngine() != null) {
            this.mvRequest.getMVRequestZoomEngine().bind(dSIMapViewerZoomEngine);
        } else {
            this.getMapLogChannel().log(100000, "AbstractMap[%1]#setDSIMapZoomEngine() - no DSIMapZoomEngine", (Object)this.getName());
        }
    }

    public void setDSIMapManeuverView(DSIMapViewerManeuverView dSIMapViewerManeuverView) {
        if (this.mvRequest.getMVRequestManeuverView() != null) {
            this.mvRequest.getMVRequestManeuverView().bind(dSIMapViewerManeuverView);
        } else {
            this.getMapLogChannel().log(100000, "AbstractMap[%1]#getMVRequestManeuverView() - no MVRequestManeuverView", (Object)this.getName());
        }
    }

    public boolean allStdMapDSIsReceived() {
        try {
            return this.mvRequest.getMVRequestZoomEngine().isReady() && this.mvRequest.getMVRequestManeuverView().isReady() && this.mvRequest.getMVRequestStd().isReady();
        }
        catch (Exception exception) {
            this.getMapLogChannel().log(10000, "AbstractMap[%1]#allStdMapDSIsReceived() - %2", (Object)this.getName(), (Object)exception.getMessage());
            for (int i2 = 0; i2 < exception.getStackTrace().length; ++i2) {
                this.getMapLogChannel().log(10000, "    %1#%2()", (Object)exception.getStackTrace()[i2].getClassName(), (Object)exception.getStackTrace()[i2].getMethodName());
            }
            return false;
        }
    }

    public boolean allGEDSIsReceived() {
        return this.mapConfig.hasGoogleEarth() ? this.getMVRequest().getMVRequestGoogleCtrl().isReady() : false;
    }

    public abstract void initDSI();

    public void hide() {
        this.getMapLogChannel().log(100000, "AbstractMap[%1]#hide() - unexpected call", (Object)this.getName());
    }

    public void hideRouteInfo() {
        this.getMapLogChannel().log(100000000, "AbstractMap[%1]#hideRouteInfo()");
    }

    public void show() {
        this.getMapLogChannel().log(100000, "AbstractMap[%1]#show() - unexpected call", (Object)this.getName());
    }

    protected void mapNotInitialized() {
        this.mMapInitialized = false;
    }

    public void mapInitialized() {
        this.mMapInitialized = true;
    }

    public boolean isInitialized() {
        return this.mMapInitialized;
    }

    public LogChannel getMapLogChannel() {
        return this.sMapLogChannel;
    }

    public LogChannel getMapGUILogChannel() {
        return this.sMapGUILogChannel;
    }

    public final LogChannel getMapDSILogChannel() {
        return this.sMapDSILogChannel;
    }

    public LogChannel getMapDSICtrlLogChannel() {
        return this.sMapDSICtrlLogChannel;
    }

    public LogChannel getMapGuidanceLogChannel() {
        return this.sMapGuidanceLogChannel;
    }

    protected boolean isSwitchContextAllowed() {
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void forceSwitchToContext(int n, SwitchContextEnum switchContextEnum) {
        int n2 = n;
        this.sMapLogChannel.log(10000000, "AbstractMap#forceSwitchToContext() - Context = %1 Reson = %2", (Object)Integer.toString(n2), (Object)switchContextEnum.description);
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.isSwitchContextAllowed()) {
                switch (n2) {
                    case 11: {
                        this.sMapLogChannel.log(10000000, "AbstractMap#forceSwitchToContext():  cDestinationMap");
                        this.setSwitchBackToContext(11);
                        n2 = 8;
                        break;
                    }
                    case 10: {
                        this.sMapLogChannel.log(10000000, "AbstractMap#forceSwitchToContext():  cOverviewMap");
                        this.setSwitchBackToContext(10);
                        n2 = 8;
                        break;
                    }
                    case 8: {
                        this.setSwitchBackToContext(0);
                        break;
                    }
                }
            } else {
                this.sMapLogChannel.log(100000000, "AbstractMap#forceSwitchToContext(): else: ctx.setSwitchbackToOverviewMap( false )");
                this.setSwitchBackToContext(0);
            }
            this.beforeSwitch(this.ctxTimeline.activeCid, n2);
            this.ctxTimeline.add(n2, this.getCtx(n2));
            this.mContextSwitchStatus = 1;
            this.ctxTimeline.last.exit();
            if ((this.getMapDataContainer().isInNavi || this.getMapDataContainer().isInMap) && this.getCtx(this.ctxTimeline.activeCid) instanceof CtxShown) {
                this.mLastVisibleCtxInsideNaviMap = this.ctxTimeline.activeCid;
            }
            if (this.sMapLogChannel.isDebug2()) {
                this.sMapLogChannel.log(1000000, "**************************************************");
                this.sMapLogChannel.log(1000000, "CONTEXT %1 [%2]", (Object)this.getActiveContext().getClass().getName(), (Object)switchContextEnum.description);
                this.sMapLogChannel.log(1000000, "**************************************************");
            } else {
                this.sMapLogChannel.log(1000000, "*** CONTEXT %1 *** [%2]", (Object)this.getActiveContext().getClass().getName(), (Object)switchContextEnum.description);
            }
            this.mContextSwitchStatus = 2;
            try {
                this.ctxTimeline.active.enterPrologue();
                this.ctxTimeline.active.enter();
                this.ctxTimeline.active.enterEpilogue();
            }
            catch (Exception exception) {
                this.getMapLogChannel().log(10000, "AbstractMap#forceSwitchToContext() - %1", (Throwable)exception);
            }
            this.mContextSwitchStatus = 0;
            this.sMapLogChannel.log(10000000, "*** Activated CONTEXT %1 ***", (Object)this.getActiveContext().getClass().getName());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void forceSwitchToContext(int n, int n2, int n3) {
        this.forceSwitchToContext(n, SwitchContextEnum.NoReason);
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            this.ctxTimeline.active.touchScreenLongPressed(0, n2, n3);
        }
    }

    protected void beforeSwitch(int n, int n2) {
    }

    public Object getMutexSwitchToContext() {
        return this.mapMgr.getMutexSwitchToContext();
    }

    public void switchToContext(int n) {
        this.switchToContext(n, SwitchContextEnum.NoReason);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void switchToContext(int n, SwitchContextEnum switchContextEnum) {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.ctxTimeline.activeCid == n) {
                this.sMapLogChannel.log(1000000, "AbstractMap#switchToContext( %2 ) - context %2 already active, ignoring, reason:%1", (Object)switchContextEnum, (long)n);
                return;
            }
            this.forceSwitchToContext(n, switchContextEnum);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void switchToContext(int n, NavLocation navLocation) {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.ctxTimeline.activeCid == n) {
                this.sMapLogChannel.log(1000000, "AbstractMap#switchToContext(): context %1 already active, ignoring", (long)n);
                return;
            }
            this.forceSwitchToContext(n, navLocation.latitude, navLocation.longitude);
        }
    }

    protected int determineShownContext() {
        this.sMapLogChannel.log(1000000, "AbstractMap#determineShownContext - getSetupMapType(true) = %1, mForcedContext = %2", (long)this.getSetup().getMapType(true), (long)this.ctxTimeline.getIntention());
        int n = 6;
        block0 : switch (this.getSetup().getMapType(true)) {
            case 0: {
                n = 11;
                break;
            }
            case 1: 
            case 2: {
                n = 6;
                switch (this.getSetup().getAutoZoom(true)) {
                    case 0: {
                        n = 7;
                        break block0;
                    }
                    case 2: {
                        n = 6;
                        break block0;
                    }
                    case 1: {
                        n = 8;
                        break block0;
                    }
                }
                this.sMapLogChannel.log(10000, "AbstractMap#determineShownContext - invalid autozoom setting: %1", (long)this.getSetup().getAutoZoom());
                break;
            }
            case 3: {
                n = 10;
                if (this.getActiveContext().getRouteActiveOrRangeMapReady()) break;
                n = 7;
                break;
            }
            default: {
                this.sMapLogChannel.log(10000, "AbstractMap#determineShownContext - invalid map type: %1", (long)this.getSetup().getMapType(true));
            }
        }
        if (this.ctxTimeline.getIntention() != -1) {
            if (this.getMapDataContainer().viewSize == 1 && !MapUtils.isCtxAllowedInSmallStage(this.ctxTimeline.getIntention())) {
                this.getMapLogChannel().log(100000, "AbstractMap#determineShownContext() - can not enter crosshair mode in small stage");
            } else {
                n = this.ctxTimeline.getIntention();
            }
            this.ctxTimeline.clearIntention();
        }
        return n;
    }

    public void forceSwitchToAShownContext() {
        this.forceSwitchToContext(this.determineShownContext(), SwitchContextEnum.NoReason);
    }

    public void switchToAShownContext() {
        this.switchToContext(this.determineShownContext());
    }

    public void switchToHiddenContext() {
        this.switchToContext(3);
    }

    public void forceContext(int n) {
        this.sMapLogChannel.log(1000000, "AbstractMap#forceContext(%1)", (long)n);
        this.ctxTimeline.setIntention(n);
        this.mLastForcedContext = this.ctxTimeline.getIntention();
        if (n == -1) {
            if (this.guiInterface != null) {
                this.guiInterface.closeSidebarWithoutAnimation();
            } else {
                this.sMapGUILogChannel.log(10000, "AbstractMap[%1]#forceContext() - guiInterface is null", (Object)this.getName());
            }
        }
    }

    public abstract void forceHiddenContextRefresh();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void forceShownContextRefresh() {
        Object object = this.getMutexSwitchToContext();
        synchronized (object) {
            if (this.getActiveContext() instanceof CtxHidden) {
                this.sMapLogChannel.log(1000000, "AbstractMap#forceShownContextRefresh(): A hidden context is already active, ignoring");
                return;
            }
            int n = this.ctxTimeline.activeCid;
            this.forceSwitchToContext(3, SwitchContextEnum.ContextRefresh);
            this.forceSwitchToContext(n, SwitchContextEnum.ContextRefresh);
        }
    }

    public int getmLastForcedContext() {
        return this.mLastForcedContext;
    }

    public IContext getActiveContext() {
        return this.ctxTimeline.active;
    }

    public Context getActiveCtx() {
        try {
            return (Context)this.ctxTimeline.active;
        }
        catch (ClassCastException classCastException) {
            return null;
        }
    }

    public int getActiveContextIndex() {
        return this.ctxTimeline.activeCid;
    }

    public int getOldActiveContextIndex() {
        return this.ctxTimeline.lastCid;
    }

    public int getLastShownAndModifiedContextIndex() {
        return this.ctxTimeline.lastShownAndModifiedCid;
    }

    public MapDataContainer getMapDataContainer() {
        return this.mapDataContainer;
    }

    public IMapTooltip getMapTooltip() {
        return this.guiInterface;
    }

    public INaviInterface getNaviInterface() {
        return this.naviInterface;
    }

    public MapInterface getMapInterface() {
        return this.mapInterface;
    }

    public GUIInterface getGuiInterface() {
        return this.guiInterface;
    }

    public IRouteCalculator getRouteCalculationHandler() {
        return this.mapMgr.getRouteCalculationHandler();
    }

    public IRouteInfoContextHandler getRouteInfoContextHandler() {
        return this.mapMgr.getRouteInfoContextHandler();
    }

    public IMapRequest getMVRequest() {
        return this.mvRequest;
    }

    public MVResponseControl getMVResponseControl() {
        MVRequestControl mVRequestControl = this.getMVRequest().getMVRequestControlActive();
        if (mVRequestControl != null) {
            return mVRequestControl.getMVResponseControl();
        }
        this.sMapLogChannel.log(10000, "AbstractMap#getMVResponseControl() - not available");
        return null;
    }

    public MVResponseControl getMVResponseControlStd() {
        MVRequestControl mVRequestControl = this.getMVRequest().getMVRequestStd();
        if (mVRequestControl != null) {
            return mVRequestControl.getMVResponseControl();
        }
        this.sMapLogChannel.log(10000, "AbstractMap#getMVResponseControlStd() - not available");
        return null;
    }

    public MVResponseGoogleCtrl getMVResponseGoogleCtrl() {
        MVRequestGoogleCtrl mVRequestGoogleCtrl = this.getMVRequest().getMVRequestGoogleCtrl();
        if (mVRequestGoogleCtrl != null) {
            return mVRequestGoogleCtrl.getMVResponseGoogleCtrl();
        }
        this.sMapLogChannel.log(10000, "AbstractMap#getMVResponseGoogleCtrl() - not available");
        return null;
    }

    public MVResponseManeuverView getMVResponseManeuverView() {
        MVRequestManeuverView mVRequestManeuverView = this.getMVRequest().getMVRequestManeuverView();
        if (mVRequestManeuverView != null) {
            return mVRequestManeuverView.getResponserManeuverView();
        }
        this.sMapLogChannel.log(10000, "AbstractMap#getMVResponseManeuverView() - not available");
        return null;
    }

    public MVResponseZoomEngine getMVResponseZoomEngine() {
        MVRequestZoomEngine mVRequestZoomEngine = this.getMVRequest().getMVRequestZoomEngine();
        if (mVRequestZoomEngine != null) {
            return mVRequestZoomEngine.getResponserZoomEngine();
        }
        this.sMapLogChannel.log(10000, "AbstractMap#getMVResponseZoomEngine() - not available");
        return null;
    }

    public MapTmcService getTMCMap() {
        return (MapTmcService)((Object)this.getCtx(18));
    }

    public void restartOverviewMapTimer() {
        this.getZoomHandler().startOverviewMapSwitchBackTimer(true);
    }

    public void cancelOverviewMapTimer() {
        this.sMapLogChannel.log(1000000, "AbstractMap#cancelOverviewMapTimer()");
        this.getZoomHandler().stopOverviewMapSwitchBackTimer();
    }

    protected boolean isStdMapInitiated() {
        return false;
    }

    protected boolean isGEInitiated() {
        return false;
    }

    private String printDSIStatus() {
        MVRequestControl mVRequestControl;
        Buffer buffer = new Buffer(300);
        if (this.getMVRequest().getMVRequestStd() != null) {
            mVRequestControl = this.getMVRequest().getMVRequestStd();
            buffer.append("mMapControlReady[").append(mVRequestControl.getID()).append("]=").append(mVRequestControl.isReady()).append(Formatter.LINE_SEPARATOR);
        }
        if (this.getMapConfig().hasGoogleEarth() && this.getMVRequest().getMVRequestGoogleCtrl() != null) {
            mVRequestControl = this.getMVRequest().getMVRequestGoogleCtrl();
            buffer.append("mMapControlReady[").append(mVRequestControl.getID()).append("]=").append(mVRequestControl.isReady()).append(Formatter.LINE_SEPARATOR);
        }
        if (this.getMapConfig().hasZoomEngine()) {
            buffer.append("mZoomEngineReady=").append(this.mvRequest.getMVRequestZoomEngine().isReady()).append(Formatter.LINE_SEPARATOR);
        }
        if (this.getMapConfig().hasManeuverView()) {
            buffer.append("mManeuverViewReady=").append(this.mvRequest.getMVRequestManeuverView().isReady()).append(Formatter.LINE_SEPARATOR);
        }
        if (this.getMapConfig().hasGoogleEarth()) {
            buffer.append("mGoogleCtrlReady=").append(this.mvRequest.getMVRequestGoogleCtrl().isReady()).append(Formatter.LINE_SEPARATOR);
        }
        buffer.append("mStdMapInitiated=").append(this.isStdMapInitiated()).append(Formatter.LINE_SEPARATOR);
        if (this.getMapConfig().hasGoogleEarth()) {
            buffer.append("mGEInitiated=").append(this.isGEInitiated()).append(Formatter.LINE_SEPARATOR);
            buffer.append("mGoogleDataStatus=").append(this.getMVResponseGoogleCtrl().getGoogleDataStatus()).append(Formatter.LINE_SEPARATOR);
        }
        return buffer.toString();
    }

    private String printContextSwitchStatus() {
        Buffer buffer = new Buffer(200);
        buffer.append("mContextSwitchStatus=").append(this.mContextSwitchStatus).append(Formatter.LINE_SEPARATOR);
        buffer.append("mOldActiveContext=").append(this.ctxTimeline.lastCid).append(Formatter.LINE_SEPARATOR);
        buffer.append("mActiveContext=").append(this.ctxTimeline.activeCid).append(Formatter.LINE_SEPARATOR);
        return buffer.toString();
    }

    public ISetupHandler getSetup() {
        if (this.setupHandler == null) {
            this.getMapLogChannel().log(10000, "AbstractMap[%1]#getSetup() - no setup handler", (Object)this.getName());
            this.setupHandler = (ISetupHandler)NullFactory.create(class$de$audi$tghu$navi$app$map$handler$ISetupHandler == null ? (class$de$audi$tghu$navi$app$map$handler$ISetupHandler = AbstractMap.class$("de.audi.tghu.navi.app.map.handler.ISetupHandler")) : class$de$audi$tghu$navi$app$map$handler$ISetupHandler, this.getMapLogChannel(), null);
        }
        return this.setupHandler;
    }

    public void setSetupHandler(ISetupHandler iSetupHandler) {
        this.setupHandler = iSetupHandler;
    }

    protected void setZoomHandler(ZoomHandler zoomHandler) {
        this.zoomHandler = zoomHandler;
    }

    public IZoomHandler getZoomHandler() {
        return this.zoomHandler;
    }

    public ZoomEventListener getZoomEventListener() {
        return this.zoomHandler;
    }

    public MVRequestControl getMainRequestCtl() {
        return this.getMVRequest().getMVRequestStd();
    }

    public NavigationEnv getNavigationEnv() {
        return this.env;
    }

    public int getCurrentMapStyle() {
        int n = this.getSetup().getMapRepresentation();
        switch (n) {
            case 0: {
                return 0;
            }
            case 2: 
            case 3: {
                return 2;
            }
        }
        this.getMapLogChannel().log(100000, "AbstractMap[%1]#getCurrentMapStyle(): Unknown mapRepresentation: %2", (Object)this.getName(), (long)n);
        return 0;
    }

    public int getCurrentViewType() {
        return this.getMVResponseControl().getCurrentViewType();
    }

    public boolean getDayNightView() {
        return this.getMVResponseControl().getDayNightView();
    }

    public NavLocationWgs84 getMapPosition() {
        return this.getMVResponseControl().getMapPosition();
    }

    public int getMapRepresentation() {
        return this.getSetup().getMapRepresentation();
    }

    public int getMapType() {
        return this.getSetup().getMapType();
    }

    public int getZoomEngineState() {
        int n = -1;
        n = this.getMapConfig().hasZoomEngine() ? this.getMVResponseZoomEngine().getZoomEngineState() : 0;
        this.getMapLogChannel().log(100000000, "AbstractMap[%1]#getZoomEngineState() state = %2 (off=0, auto=2, maneuver=3)", (Object)this.getName(), (long)n);
        return n;
    }

    public void setSwitchBackToContext(int n) {
        switch (n) {
            case 0: 
            case 10: 
            case 11: {
                this.mapDataContainer.sSwitchBackToContext = n;
                this.getMapLogChannel().log(10000000, "AbstractMap[%1]#setSwitchBackToContext( %2 )", (Object)this.getName(), (long)n);
                break;
            }
            default: {
                this.getMapLogChannel().log(10000, "AbstractMap[%1]#setSwitchBackToContext( %2 ) - invalid value", (Object)this.getName(), (long)n);
            }
        }
    }

    public int getSwitchBackToContext() {
        return this.mapDataContainer.sSwitchBackToContext;
    }

    public String getStartupState() {
        Buffer buffer = new Buffer();
        buffer.append("==== ").append(this.getName()).append(" ====").append(Formatter.LINE_SEPARATOR);
        buffer.append("Active map context: ").append(this.getActiveContextIndex()).append(Formatter.LINE_SEPARATOR);
        MVResponseControl mVResponseControl = this.getMainRequestCtl().getMVResponseControl();
        boolean bl = mVResponseControl.getMapReady();
        buffer.append("Map ready: ").append(bl).append(Formatter.LINE_SEPARATOR);
        float[] fArray = mVResponseControl.getZoomList();
        buffer.append("Map zoom list length: ").append(fArray != null ? String.valueOf(fArray.length) : "NULL").append(Formatter.LINE_SEPARATOR);
        boolean bl2 = mVResponseControl.getViewVisible();
        buffer.append("Map view visible: ").append(bl2).append(Formatter.LINE_SEPARATOR);
        boolean bl3 = mVResponseControl.getViewFreeze();
        buffer.append("Map view freeze: ").append(bl3).append(Formatter.LINE_SEPARATOR);
        if (bl && fArray != null) {
            buffer.append("Conclusion: Map is ready").append(Formatter.LINE_SEPARATOR);
        } else {
            buffer.append("Conclusion: Map is NOT READY").append(Formatter.LINE_SEPARATOR);
        }
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append(this.printDSIStatus());
        buffer.append(Formatter.LINE_SEPARATOR);
        buffer.append(this.printContextSwitchStatus());
        return buffer.toString();
    }

    public boolean isMapMain() {
        return this == this.getMapManager().getMapMain();
    }

    public boolean isMapMinor() {
        return this == this.getMapManager().getMinorMap();
    }

    public boolean isMapKombiFPK() {
        return this == this.getMapManager().getMapKombiFPK();
    }

    public boolean isMapKombiMOST() {
        return this == this.getMapManager().getMapKombiMOST();
    }

    public boolean isMapKombi() {
        return this instanceof MapKombi;
    }

    protected abstract ChoiceModelApp getActiveRendererChoice();

    public IconHandler getIconHandler() {
        return this.iconHandler;
    }

    public int getLastVisibleCID() {
        return this.ctxTimeline.lastVisibleCid;
    }

    public int getLastCtxShownID() {
        return this.ctxTimeline.lastShownCid;
    }

    public int getLastVisibleCtxInsideNaviMap() {
        return this.mLastVisibleCtxInsideNaviMap;
    }

    public boolean isSdsDialogActive() {
        return this.getMapManager().getSdsController().isSDSActive();
    }

    public void backupMapState() {
        if (this.lastState == null) {
            this.lastState = new MapState();
        }
        this.lastState.zoomlevel = this.getZoomHandler().getZoom();
        this.lastState.pins = this.getMapFlagHandler().getPins();
        this.lastState.mapOrientation = this.getMVResponseControl().getMapOrientation();
        if (this.getMapPosition() != null) {
            this.lastState.position = new NavLocationWgs84(this.getMapPosition().getLongitude(), this.getMapPosition().getLatitude());
        }
        this.sMapLogChannel.log(10000000, "AbstractMap#backupMapState() - %1", (Object)this.lastState);
    }

    public MapState getLastMapState() {
        return this.lastState;
    }

    public void showPreviewMap() {
    }

    public void setEnableDeepSwitching(boolean bl) {
        this.sMapLogChannel.log(10000000, "AbstractMap[%2]#setEnableDeepSwitching( %1 )", bl, (Object)this.getName());
        this.isDeepSwitchingEnabled = bl;
    }

    public boolean isDeepSwitchingEnabled() {
        return this.isDeepSwitchingEnabled;
    }

    public ViewFactory getViews() {
        return this.mapMgr.getViews();
    }

    public void viewSizeChanged(int n) {
    }

    public void postSwitchRenderer() {
        this.sMapLogChannel.log(10000000, "AbstractMap[%1]#postSwitchRenderer( )", (Object)this.getName());
        if (this.mapDataContainer.sMapContentList != null) {
            this.mapDataContainer.sMapContentList.onChangedMapRenderer();
        }
    }

    public IMapContent getMapContentHandler() {
        return this.mapDataContainer.sMapContentList;
    }

    public MapSelectionHandler getMapSelectionHandler() {
        return this.mapSelectionHandler;
    }

    public void onSelectionChanged(MapItemSelectionInfo mapItemSelectionInfo) {
        if (this.getActiveContext() instanceof MapSelectionHandler.IMapSelectionListener) {
            try {
                ((MapSelectionHandler.IMapSelectionListener)((Object)this.getActiveContext())).onSelectionChanged(mapItemSelectionInfo);
            }
            catch (Exception exception) {
                this.getMapLogChannel().log(100000, "AbstractMap#onSelectionChanged() - %1", (Throwable)exception);
            }
        } else {
            this.getMapLogChannel().log(100000, "AbstractMap#onSelectionChanged() - unexpected call, CID = %1", (long)this.getActiveContextIndex());
        }
    }

    public void show(int n) {
        this.getMapLogChannel().log(10000000, "AbstractMap[%1]#show( %2 )", (Object)this.getName(), (long)n);
        this.mapDataContainer.iShowTrigger = n;
    }

    public int getShowTrigger(boolean bl) {
        if (bl) {
            int n = this.mapDataContainer.iShowTrigger;
            this.mapDataContainer.iShowTrigger = -1;
            return n;
        }
        return this.mapDataContainer.iShowTrigger;
    }

    public void clearShowTrigger() {
        this.getMapLogChannel().log(10000000, "AbstractMap[%1]#clearShowTrigger() - trigger : %2", (Object)this.getName(), (long)this.mapDataContainer.iShowTrigger);
        this.mapDataContainer.iShowTrigger = -1;
    }

    public void onEvent(int n) {
        this.getMapLogChannel().log(100000000, "AbstractMap[%1]#onEvent( %2 )", (Object)this.getName(), (long)n);
        this.getActiveContext().onEvent(n);
    }

    public void onEvent(int n, Object object) {
        this.getMapLogChannel().log(100000000, "AbstractMap[%2]#onEvent( %3 ) - %1", object, (Object)this.getName(), (long)n);
        this.getActiveContext().onEvent(n, object);
    }

    public void fireMapEvent(int n, int n2) {
        this.getMapManager().getMapEventDispatcher().fireEvent(n, n2);
    }

    public int getNavMapMagnificationRange() {
        return 400476;
    }

    public int getContextSwitchStatus() {
        return this.mContextSwitchStatus;
    }

    public ITooltipFormatter getTooltipFormatter() {
        return this.tooltipFormatter;
    }

    public void clearForcedCrosshairCtx() {
        if (this.ctxTimeline.getIntention() == 12) {
            this.getMapLogChannel().log(10000000, "AbstractMap[%1]#clearForcedCrosshairCtx()", (Object)this.getName());
            this.ctxTimeline.clearIntention();
        }
    }

    public void showRouteBriefing(int n) {
    }

    public ContextTimeline getCtxTimeline() {
        return this.ctxTimeline;
    }

    public void showLocInMainMap(NavLocation navLocation, int n) {
    }

    public void showTMCInMainMap(TmcMessage tmcMessage) {
    }

    public void onEvent(int n, int n2) {
    }

    public IRouteInfo.IRouteInfoHandlerEnv getRouteInfoEnv() {
        return new IRouteInfo.IRouteInfoHandlerEnv(){

            public void updateDestDistance(int n) {
                AbstractMap.this.getActiveContext().updateDestDistance(n);
            }

            public boolean showETAandDistanceToNextStopover() {
                return AbstractMap.this.showETAandDistanceToNextStopover();
            }

            public boolean isInMap() {
                return AbstractMap.this.getMapDataContainer().isInMap;
            }

            public boolean isRouteInfoEnabled() {
                return AbstractMap.this.getSetup().isRouteInfoEnabled();
            }

            public boolean supportsAdditionalInfo() {
                return AbstractMap.this.getActiveContext().supportsAdditionalInfo();
            }

            public boolean isRouteInfoAllowedToFadeIn() {
                return AbstractMap.this.getRouteInfoContextHandler().isRouteInfoAllowedToFadeIn();
            }

            public void automaticOrientateMap() {
                AbstractMap.this.getActiveContext().automaticOrientateMap();
            }

            public INaviInterface getNaviInterface() {
                return AbstractMap.this.naviInterface;
            }

            public GUIInterface getGuiInterface() {
                return AbstractMap.this.getGuiInterface();
            }
        };
    }

    public IRouteCalculator.IRouteCalcEnv getRouteCalcEnv() {
        return new IRouteCalculator.IRouteCalcEnv(){

            public void switchToContext(int n) {
                AbstractMap.this.switchToContext(n);
            }

            public void switchToContext(int n, SwitchContextEnum switchContextEnum) {
                AbstractMap.this.switchToContext(n, switchContextEnum);
            }

            public void switchToAShownContext() {
                AbstractMap.this.switchToAShownContext();
            }

            public void showRouteBriefing(int n) {
                AbstractMap.this.showRouteBriefing(n);
            }

            public void onFiredRGAutoStartTimer() {
                this.getActiveContext().onFiredRGAutoStartTimer();
            }

            public void onEvent(int n) {
                AbstractMap.this.onEvent(n);
            }

            public ViewFactory getViews() {
                return AbstractMap.this.getViews();
            }

            public NavigationEnv getNavigationEnv() {
                return AbstractMap.this.getNavigationEnv();
            }

            public INaviInterface getNaviInterface() {
                return AbstractMap.this.getNaviInterface();
            }

            public IEventBroker getMapEventDispatcher() {
                return AbstractMap.this.mapMgr.getMapEventDispatcher();
            }

            public MapDataContainer getMapDataContainer() {
                return AbstractMap.this.mapDataContainer;
            }

            public MVRequest getMVRequest() {
                return AbstractMap.this.mvRequest;
            }

            public int getActiveContextIndex() {
                return AbstractMap.this.getActiveContextIndex();
            }

            public IContext getActiveContext() {
                return AbstractMap.this.getActiveContext();
            }

            public IPreviewMap getPreviewMapHandler() {
                return AbstractMap.this.getMapManager().getPreviewMapHandler();
            }

            public int getActiveNaviOrMapContext() {
                return this.getMapDataContainer().activeNaviOrMapContext;
            }

            public int getActiveTab() {
                return this.getMapDataContainer().currentNavTab;
            }

            public int getLastSelectedRouteIndex() {
                return AbstractMap.this.getMapManager().getRouteManager().getLastSelectedRouteIndex();
            }

            public Object getMutexSwitchToContext() {
                return AbstractMap.this.getMutexSwitchToContext();
            }

            public boolean isInNavigation() {
                return this.getMapDataContainer().isInNavi;
            }

            public ISatelliteMapsManager getSatelliteManager() {
                return AbstractMap.this.getSatellitemapsManager();
            }
        };
    }

    public IZoomHandler.IZoomHandlerEnv getZoomHandlerEnv() {
        return this;
    }

    public boolean isMapEnablingSoftTiltDesired() {
        return true;
    }

    public void focusPredictiveNavigationRoute(int n) {
    }

    public void enterAlternativeRoutes() {
    }

    public void exceedsUpperThreshold(int n) {
        if (n == 1) {
            this.getMapInterface().setCarMoving(true);
            this.getActiveContext().exceedsUpperThreshold(n);
        }
    }

    public void belowLowerThreshold(int n) {
        if (n == 1) {
            this.getMapInterface().setCarMoving(false);
            this.getActiveContext().belowLowerThreshold(n);
        }
    }

    public void updateLockingState(boolean bl) {
        this.getActiveContext().updateLockingState(bl);
    }

    public ISatelliteMapsManager getSatellitemapsManager() {
        return this.satelliteMapsManager;
    }

    protected SatelliteMapsManager createSatelliteMapsManager(NavigationEnv navigationEnv, int n, int n2) {
        return new SatelliteMapsManager(navigationEnv, this, n, n2);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    public static class MapState {
        public float zoomlevel = -1.0f;
        public int mapOrientation = 2;
        public NavLocationWgs84 position = null;
        public boolean showPOI = false;
        public boolean showTMC = false;
        public MapPin[] pins = null;

        public String toString() {
            Buffer buffer = new Buffer(150);
            buffer.append("zoomLevel:").append(this.zoomlevel).append(", position:").append(this.position).append(", showPOI:").append(this.showPOI).append(", showTMC:").append(this.showTMC).append(", mapOrientation:").append(this.mapOrientation);
            return buffer.toString();
        }
    }
}

