/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.NaviOnlineService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.favorite.IFavorite;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.AbstractMapContext;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.MapConsts;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.constants.PropertyEnum;
import de.audi.tghu.navi.app.map.context.State;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.handler.IDrawerStateHandler;
import de.audi.tghu.navi.app.map.handler.IRouteInfo;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.selection.MapItemSelectionInfo;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.map.utils.MapPin;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.BapManeuverDescriptor;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.tmc.TmcMessage;

public abstract class Context
extends AbstractMapContext
implements MapConsts {
    protected final NavigationEnv env;
    private final LogChannel sLogChannel;
    private final LogChannel sLogChannelGuidance;
    protected final AbstractMap naviMap;
    public final MapDataContainer container;

    public Context(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        this.env = navigationEnv;
        this.naviMap = abstractMap;
        this.container = abstractMap.getMapDataContainer();
        this.sLogChannel = abstractMap.getMapLogChannel();
        this.sLogChannelGuidance = abstractMap.getMapGuidanceLogChannel();
        if (abstractMap instanceof MapMain) {
            if (this.container.gridMaskDelayTimer == null) {
                this.container.gridMaskDelayTimer = new GridMaskDelayTimer();
            }
            if (this.container.gridMaskWatchdogTimer == null) {
                this.container.gridMaskWatchdogTimer = new GridMaskWatchdogTimer();
            }
        }
    }

    protected final int getCID() {
        if (this.naviMap != null) {
            return this.naviMap.getActiveContextIndex();
        }
        return 0;
    }

    public void cleanup() {
        GridMaskWatchdogTimer gridMaskWatchdogTimer;
        GridMaskDelayTimer gridMaskDelayTimer = this.getGridMaskDelayTimer();
        if (gridMaskDelayTimer != null) {
            gridMaskDelayTimer.cancel();
        }
        if ((gridMaskWatchdogTimer = this.getGridMaskWatchdogTimer()) != null) {
            gridMaskWatchdogTimer.cancel();
        }
        try {
            this.getGUI().setGridMaskVisible(false);
        }
        catch (Exception exception) {
            this.getLogChannel().log(10000, "Context#cleanup() - ERROR=%1 ", (Throwable)exception);
        }
    }

    protected LogChannel getLogChannel() {
        return this.sLogChannel;
    }

    protected LogChannel getLogChannelGuidance() {
        return this.sLogChannelGuidance;
    }

    public void enterPrologue() {
    }

    public void enterEpilogue() {
    }

    public void exit() {
    }

    public void navigationEntered() {
        if (this.getMap().getRouteCalculationHandler().isRouteCalculationActive()) {
            this.getLogChannel().log(10000000, "Context#navigationEntered(): Route calculation was active");
            if (this.naviMap.getRouteCalculationHandler().isMatchingRoutesFound()) {
                this.getLogChannel().log(10000000, "Context#navigationEntered(): ...and match already found");
                if (this.naviMap.getRouteCalculationHandler().isCalculatingAltRoutes()) {
                    this.getLogChannel().log(10000000, "Context#navigationEntered(): ...and alt. routes active; switching to cAltRoutesSelection");
                    this.naviMap.switchToContext(5);
                } else {
                    this.getLogChannel().log(10000000, "Context#navigationEntered(): ...no alt. routes active, switching to normal map");
                    this.naviMap.switchToAShownContext();
                }
            } else {
                this.getLogChannel().log(10000000, "Context#navigationEntered(): ...and no match found");
                if (this.naviMap.getRouteCalculationHandler().isCalculatingAltRoutes()) {
                    this.naviMap.switchToContext(5);
                } else {
                    this.naviMap.switchToContext(33);
                }
            }
        }
    }

    public void enterNavSetup() {
    }

    public void exitNavSetup() {
    }

    public void exitMapContentList() {
        this.container.sMapContentList.setPOIVisibility(true);
    }

    public void enterMapScreen(int n) {
    }

    public void exitMapScreen() {
    }

    protected void exitMapBlockInRoute(int n) {
    }

    public void storeKeptContextIndex(int n) {
        this.getLogChannel().log(10000000, "Context#storeKeptContextIndex() - new context: %1", (long)n);
        this.container.sKeptContext = n;
    }

    protected int getKeptContextIndex() {
        return this.container.sKeptContext;
    }

    void startCalculatedRoute() {
    }

    public void screenHidden() {
        this.getLogChannel().log(10000000, "Context[%1]#screenHidden()", (long)this.getCID());
    }

    public void screenVisible() {
        this.getLogChannel().log(10000000, "Context[%1]#screenVisible()", (long)this.getCID());
    }

    public void requestPreferredViewType() {
    }

    private boolean getDayNightView() {
        return this.naviMap.getDayNightView();
    }

    public void setRequestedVisibility(boolean bl) {
        this.container.sRequestedVisibility = bl;
    }

    boolean getRequestedVisibility() {
        return this.container.sRequestedVisibility;
    }

    public void showMap(boolean bl) {
        this.showMap(bl, 1);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void showMap(boolean bl, int n) {
        Context context = this;
        synchronized (context) {
            int n2 = this.getSDSDialogActive() || this.isDrawerOpen() ? 2 : n;
            boolean bl2 = this.getRequestedVisibility();
            if (this.getLogChannel().isDebug()) {
                Buffer buffer = new Buffer(100);
                buffer.append("on: ").append(bl);
                buffer.append(", frameRateMode: ").append(n);
                buffer.append(", requestedVisibility: ").append(bl2);
                buffer.append(", isSdsDialogActive: ").append(this.getSDSDialogActive());
                this.getLogChannel().log(10000000, "Context#showMap() - %1 ", (Object)buffer);
            }
            if (bl) {
                this.naviMap.getMVRequest().setFrameRateMode(n2);
            }
            this.naviMap.getMVRequest().viewSetVisible(bl);
        }
    }

    public void updateViewFreeze(boolean bl) {
    }

    public void setRequestedFreeze(boolean bl) {
        this.container.sRequestedFreeze = bl;
        if (bl && this.naviMap.isMapMain()) {
            this.naviMap.getNaviInterface().updateMapFreeze(true);
        }
    }

    protected boolean getRequestedFreeze() {
        return this.container.sRequestedFreeze;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void freezeMap(boolean bl) {
        Context context = this;
        synchronized (context) {
            if (this.getRequestedFreeze() != bl) {
                this.naviMap.getMVRequest().viewFreeze(bl);
            }
        }
    }

    public void freezeMap() {
        this.getLogChannel().log(100000000, "Context#freezeMap()");
        this.freezeMap(true);
    }

    protected void unfreezeMap() {
        if (this.container.sFrozenLevel <= 0) {
            this.freezeMap(false);
        } else {
            this.getLogChannel().log(10000000, "Context#unfreezeMap() - sFrozenLevel: %1", (long)this.container.sFrozenLevel);
        }
    }

    public void freezeMapLevel1() {
        this.getLogChannel().log(10000000, "Context#freezeMapLevel1()");
        this.freezeMap(true);
        this.container.sFrozenLevel = 1;
    }

    public void unfreezeMapLevel1() {
        this.getLogChannel().log(10000000, "Context#unfreezeMapLevel1()");
        this.container.sFrozenLevel = 0;
        this.freezeMap(false);
    }

    public void setSDSDialogActive(boolean bl) {
        this.container.sSDSDialogActive = bl;
    }

    protected boolean isDrawerOpen() {
        if (!this.naviMap.isMapMain()) {
            return false;
        }
        IDrawerStateHandler iDrawerStateHandler = this.getMap().getMapManager().getDrawerStateHandler();
        if (iDrawerStateHandler != null) {
            return iDrawerStateHandler.isDrawerOpen();
        }
        return false;
    }

    public boolean getSDSDialogActive() {
        return this.container.sSDSDialogActive;
    }

    public void sdsSetZoomLevel(int n) {
        this.getZoomHandler().setUserRequestedZoomIndex(n);
        this.sdsChangedZoom();
    }

    protected void sdsChangedZoom() {
    }

    public void sdsChangedMapType() {
    }

    public void displayCurrentRoute() {
    }

    public void setEnterInMapLocation(NavLocation navLocation, boolean bl, boolean bl2, IFavorite iFavorite, boolean bl3) {
        this.getLogChannel().log(10000000, "Context#setEnterInMapLocation() - loc: %2, restoreZoom: %1 ", bl, (Object)LocationFormatter.formatLocationShort(navLocation));
        this.container.sEnterInMapLocation = navLocation;
        this.container.sForceUseEnterInMapLocation = true;
        this.container.sForceUseEnterInMapRestoreZoom = bl;
        this.container.sEnterInMapShowPin = bl2;
        this.container.sEnterInMapFavorite = iFavorite;
        this.container.sEnterInMapHidePois = bl3;
    }

    public NavLocation getEnterInMapLocation() {
        return this.container.sEnterInMapLocation;
    }

    public void setPicNavMapLocation(NavLocation navLocation, boolean bl, int n, ResourceLocator resourceLocator) {
        this.container.sPicNavMapLocation = navLocation;
        this.container.sPicNavMapFilterId = n;
        this.container.sPicNavMapShowPicNavIcons = bl;
        this.setPicNavMapTooltipLocator(resourceLocator);
    }

    protected void setPicNavMapTooltipLocator(ResourceLocator resourceLocator) {
        this.container.sPicNavMapTooltipLocator = resourceLocator;
    }

    public boolean getManoeuvreZoomDisabledWithReturn() {
        this.getLogChannel().log(100000000, "Context#getManoeuvreZoomDisabledWithReturn( %1 )", this.container.sManoeuvreZoomDisabledWithReturn);
        return this.container.sManoeuvreZoomDisabledWithReturn;
    }

    public void updateManoeuvreViewsAvailable(short[] sArray) {
        this.getLogChannel().log(1000000, "Context#updateManoeuvreViewsAvailable()");
        this.naviMap.getRouteInfoContextHandler().updateManoeuvreViewsAvailable(sArray);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setVisibleDisplayContextID(int n) {
        this.getLogChannel().log(10000000, "Context#setVisibleDisplayContextID( %1 )", (Object)MapUtils.contextToString(n));
        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
        synchronized (iRouteInfo) {
            this.container.sDisplayContextAnimationRunning = false;
            this.container.sVisibleDisplayContextID = n;
        }
    }

    protected int getVisibleDisplayContextID() {
        return this.container.sVisibleDisplayContextID;
    }

    public void updateDistanceToNextManeuver(int n) {
        this.container.sDistanceToNextManeuver = n;
        this.refreshDistanceToNextManeuver();
    }

    public int getDistanceToNextManeuver() {
        this.getLogChannelGuidance().log(100000000, "Context#getDistanceToNextManeuver( %1 )", (long)this.container.sDistanceToNextManeuver);
        return this.container.sDistanceToNextManeuver;
    }

    private void setCurrentDistToNextManeuver(String string) {
        this.container.sDistString = string;
    }

    public String getDistString() {
        return this.container.sDistString;
    }

    public void refreshDistanceToNextManeuver() {
        int n = this.getDistanceToNextManeuver();
        Buffer buffer = new Buffer();
        if (n > 30) {
            buffer.append(this.env.getTranslatedText(16, "in"));
            buffer.append("|");
            buffer.append(Util.formatDistance(n, 5, 2));
        }
        String string = buffer.toString();
        this.getLogChannelGuidance().log(100000000, "Context#refreshDistanceToNextManeuver() - distStr = %1", (Object)string);
        this.setCurrentDistToNextManeuver(string);
        this.naviMap.getRouteInfoContextHandler().updateDistanceToNextManeuver(string);
        this.naviMap.getRouteInfoContextHandler().updateDistanceToNextManeuver(n, 5);
    }

    public void initAdditionalInfos() {
    }

    public boolean supportsAdditionalInfo() {
        return false;
    }

    protected TmcMessage getTmcMessage() {
        return this.container.sTmcMessage;
    }

    public void updateTmcMessagesAhead(TmcMessage[] tmcMessageArray) {
        this.container.sTMCMessageAhead = tmcMessageArray;
    }

    protected TmcMessage[] getTMCMessageAhead() {
        return this.container.sTMCMessageAhead;
    }

    public void rbGetIDOfSelectedSegmentResult(long l) {
    }

    public void rbGetRRDToSelectedSegmentResult(long l, int n) {
    }

    public void setOnlineResultFlags(OnlinePOIResultList onlinePOIResultList) {
        this.container.sOnlinePOIResultList = onlinePOIResultList;
    }

    public void setWeatherOverlaysData(int n, NaviOnlineService.NaviOnlineMapOverlay[] naviOnlineMapOverlayArray, int n2) {
        this.container.weatherSetId = n;
        this.container.weatherData = naviOnlineMapOverlayArray;
        this.container.weatherDelayInMillisBetweenImages = n2;
    }

    public void setRemoteHMIResultFlags(OnlinePOIResultList onlinePOIResultList) {
        this.container.sRemoteHMIResultList = onlinePOIResultList;
    }

    public OnlinePOIResultList getOnlinePOIResultList() {
        return null;
    }

    public void updateAvailableLayers(LayerProperty[] layerPropertyArray) {
        this.container.sMapContentList.updateAvailableLayers(layerPropertyArray);
    }

    public void updateGoogleDataStatus(int n) {
        boolean bl = n == 3;
        boolean bl2 = bl || n == 2;
        this.naviMap.getNaviInterface().googleEarthUpdateStatusCompleted(3, bl2);
        Util.logStartupEvent(this.env.getFramework(), new Buffer().append("[Startup] Context#updateGoogleDataStatus() - googleDataStatus: ").append(n).append(" (renderer recommended: ").append(bl).append(", map: ").append(this.naviMap.getName()).append(')'));
    }

    public void updateVisibleLayers(int[] nArray) {
        this.container.sMapContentList.updateVisibleLayers(nArray);
    }

    public void refreshRoutes() {
    }

    public void switchToMap() {
    }

    public void updateRgActive(boolean bl) {
        this.container.sRGActive = bl;
        if (this.naviMap.getActiveContextIndex() == 17 && !bl) {
            this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
            this.naviMap.switchToContext(12);
        }
        if (!bl) {
            this.container.oldBapManoeuvreState = -1;
            this.container.actualBapManoeuvreState = -1;
            this.container.zoomTempDeactivated = false;
        }
        this.handleManeuverZoomEngineOnOff();
        this.refreshPositionOfLeftDrawerButton();
    }

    public boolean getRGActive() {
        return this.container.sRGActive;
    }

    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
    }

    public boolean getRouteActiveOrRangeMapReady() {
        return this.getRGActive() || this.getMap().getRouteCalculationHandler().isRouteCalculationNotIdle() || this.isRangeMapReadyToShow();
    }

    public void stopoverHasBeenPassed() {
    }

    protected void enableAutomaticRouteDiversion(boolean bl) {
        this.container.sRCCIEnabled = bl;
    }

    protected boolean getAutomaticRouteDiversion() {
        return this.container.sRCCIEnabled;
    }

    public void showTMC(boolean bl) {
    }

    public void showSpeedAndFlowFreeflow(boolean bl) {
    }

    public void showSpeedAndFlowFreeflow(boolean bl, boolean bl2) {
    }

    public void showSpeedAndFlowCongestions(boolean bl) {
    }

    public void showSpeedAndFlowCongestions(boolean bl, boolean bl2) {
    }

    public void setSpeedAndFlowRoadClass(int n) {
    }

    public void setLandmarksVisible(boolean bl) {
    }

    public void setCityModelMode(int n) {
    }

    public void showBrandIcons(int n) {
    }

    public void showPictureNavigationIcons(boolean bl) {
    }

    public void showWeatherIcons(boolean bl) {
    }

    public void setNightDesign(int n) {
        this.container.sDisplayNightDesign = n;
    }

    public int getNightDesign() {
        return this.container.sDisplayNightDesign;
    }

    public void joystick(int n, int n2) {
        this.getLogChannel().log(10000000, "Context#joystick(): modelID: %1, direction: %2", (long)n, (long)n2);
        if (n == 401688 && n2 == 0) {
            this.env.fireModelEvent(n, 0);
        }
    }

    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
    }

    public void touchScreenMoved(int n, int n2, int n3, int n4, int n5) {
    }

    public void touchScreenPressed(int n, int n2, int n3) {
    }

    public void touchScreenLongPressed(int n, int n2, int n3) {
    }

    public void touchScreenReleased(int n, int n2, int n3) {
    }

    public void touchScreenDoubleClick(int n, int n2, int n3) {
    }

    public void touchScreenPinch(int n, float f2, int n2, int n3) {
    }

    public void touchScreenRotate(int n, short s) {
    }

    public void itemReleased(int n, int n2) {
    }

    public void itemFocused(int n, int n2) {
    }

    public void itemSelected(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(10000000, "Context[%1]#itemSelected( %2, %3 )", (long)this.naviMap.getActiveContextIndex(), (long)n, (long)n2);
        switch (n) {
            case 400478: {
                if (n2 == 1) {
                    this.getMapMain().getRouteInfo().setMixedListVisible(true);
                    break;
                }
                if (n2 != 2) break;
                this.getMapMain().getRouteInfo().setMixedListVisible(false);
                this.naviMap.getRouteInfoContextHandler().signalRouteInfoHidden();
                break;
            }
            case 168: {
                int n5 = MapUtils.hmiServiceIDToContext(n2, n4, this.env);
                if (n4 == 0) {
                    this.getLogChannel().log(1000000, "Context#itemSelected() - NAV_MAP_DISPLAY_CONTROLLER_CHOICE: contextID: %1, terminal: MAIN", (long)n5);
                    this.setVisibleDisplayContextID(n5);
                } else {
                    if (n4 == 1) {
                        this.getLogChannel().log(1000000, "Context#itemSelected() - NAV_MAP_DISPLAY_CONTROLLER_CHOICE: contextID: %1, terminal: CLUSTER", (long)n5);
                        return;
                    }
                    this.getLogChannel().log(1000000, "Context#itemSelected() - NAV_MAP_DISPLAY_CONTROLLER_CHOICE: contextID: %1, terminal: %2", (long)n5, (long)n4);
                    this.setVisibleDisplayContextID(n5);
                }
                this.naviMap.getRouteInfoContextHandler().updateDisplayContext(n5);
                this.setVisibleArea();
                break;
            }
        }
    }

    public void keyPressed(int n, int n2) {
        this.getLogChannel().log(10000000, "Context[%1]#keyPressed( %2, %3)", (long)this.getCID(), (long)n, (long)n2);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        CommandList commandList = null;
        switch (n) {
            case 400785: {
                this.naviMap.getMapManager().getFunctionCounter().incCounter(26);
                commandList = this.naviMap.getNaviInterface().getPOICategoryManager().fetchPOICategories(0);
                commandList.execute("Context#keyPressed()");
                gUIInterface.fireModelEvent(n);
                break;
            }
            case 401816: {
                this.naviMap.getMapManager().restoreBackupMapRepresentationForStandardMap();
                gUIInterface.fireModelEvent(n);
                break;
            }
        }
    }

    public void keyReleased(int n, int n2) {
        this.getLogChannel().log(100000000, "Context[%1]#keyReleased( %2, %3 )", (long)this.getCID(), (long)n, (long)n2);
    }

    public void keyTyped(int n, int n2) {
        this.getLogChannel().log(100000000, "Context[%1]#keyTyped( %2, %3 )", (long)this.getCID(), (long)n, (long)n2);
    }

    public void increment(int n, int n2) {
    }

    public void incrementGesture(int n) {
    }

    protected int getMixedListOffset() {
        if (this.getRGActive() && !this.naviMap.getMapInterface().isInAltRoutesSelection()) {
            if (this.getSetup().isRouteInfoEnabled() || this.getSetup().isMapInMapEnabled()) {
                return this.naviMap.getGuiInterface().getMixedListOffset();
            }
            if (this.getSetup().isCrossingViewEnabled() && this.naviMap.getRouteInfoContextHandler().isManeuverViewVisible()) {
                return this.naviMap.getGuiInterface().getMixedListOffset();
            }
        }
        if (Util.isClusterMMI(this.env.getFramework()) && this.naviMap.getActiveContextIndex() == 10) {
            return this.naviMap.getGuiInterface().getMixedListOffset();
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void switchDisplayContext(int n) {
        this.getLogChannel().log(1000000, "Context#switchDisplayContext() - context: %1 ", (long)n);
        this.container.sRequestedDisplayContextID = n;
        if (!this.container.sSwitchDisplayContextImmediately && this.getRequestedFreeze()) {
            this.getLogChannel().log(1000000, "Context#switchDisplayContext(): map is still frozen, NOT switching Display context");
            return;
        }
        int n2 = MapUtils.contextToHMIServiceID(n, this.naviMap.getSatellitemapsManager().getActiveRendererID(), 0, this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(168);
        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
        synchronized (iRouteInfo) {
            int n3 = choiceModelApp.getValue();
            if (n2 != n3) {
                if (this.getLogChannel().isInfo()) {
                    String string = MapUtils.contextToString(n);
                    this.getLogChannel().log(1000000, "Context#switchDisplayContext(): switching to %1 display context", (Object)string);
                    this.getLogChannel().log(1000000, "Context#switchDisplayContext(): %1 -> %2", (long)n3, (long)n2);
                }
                this.container.sDisplayContextAnimationRunning = true;
                choiceModelApp.setValue(n2);
            }
        }
    }

    private GridMaskDelayTimer getGridMaskDelayTimer() {
        return (GridMaskDelayTimer)this.container.gridMaskDelayTimer;
    }

    private GridMaskWatchdogTimer getGridMaskWatchdogTimer() {
        return (GridMaskWatchdogTimer)this.container.gridMaskWatchdogTimer;
    }

    public void setGridMaskVisible(boolean bl) {
        this.setGridMaskVisible(bl, false, false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void setGridMaskVisible(boolean bl, boolean bl2, boolean bl3) {
        if (!this.naviMap.isMapMain()) {
            return;
        }
        this.getLogChannel().log(100000, "Context#setGridMaskVisible(%1) - useWatchdogTimer: %2, longDelay: %3 ", bl, bl2, bl3);
        MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            GridMaskDelayTimer gridMaskDelayTimer = this.getGridMaskDelayTimer();
            GridMaskWatchdogTimer gridMaskWatchdogTimer = this.getGridMaskWatchdogTimer();
            if (gridMaskDelayTimer != null && gridMaskWatchdogTimer != null) {
                if (bl) {
                    gridMaskDelayTimer.cancel();
                    this.getGUI().setGridMaskVisible(true);
                    gridMaskWatchdogTimer.restart(bl3);
                } else if (bl2) {
                    gridMaskDelayTimer.cancel();
                    gridMaskWatchdogTimer.restart(bl3);
                } else {
                    gridMaskWatchdogTimer.cancel();
                    gridMaskDelayTimer.restart();
                }
            } else {
                this.getLogChannel().log(10000, "Context#setGridMaskVisible() - grid mask timer not initialized - gridMaskDelayTimer: %1, gridMaskWatchdogTimer: %2", (Object)gridMaskDelayTimer, (Object)gridMaskWatchdogTimer);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void switchDisplayContextKombi(int n) {
        this.getLogChannel().log(1000000, "Context#switchDisplayContextKombi() - context: %1 ", (long)n);
        int n2 = MapUtils.contextToHMIServiceID(n, this.naviMap.getSatellitemapsManager().getActiveRendererID(), 1, this.env);
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(1, 168);
        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
        synchronized (iRouteInfo) {
            int n3 = choiceModelApp.getValue();
            if (n2 != n3) {
                if (this.getLogChannel().isInfo()) {
                    String string = MapUtils.contextToString(n);
                    this.getLogChannel().log(1000000, "Context#switchDisplayContextKombi(): switching to %1 display context", (Object)string);
                    this.getLogChannel().log(1000000, "Context#switchDisplayContextKombi(): %1 -> %2", (long)n3, (long)n2);
                }
                choiceModelApp.setValue(n2);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void adaptDisplayContext(int n) {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(n, 168);
        int n2 = choiceModelApp.getValue();
        int n3 = MapUtils.hmiServiceIDToContext(n2, n, this.env);
        int n4 = MapUtils.contextToHMIServiceID(n3, this.naviMap.getSatellitemapsManager().getActiveRendererID(), n, this.env);
        this.getLogChannel().log(10000000, "Context#adaptDisplayContext( %1 ), adaptedHMIServiceID: %2, currentHMIServiceID: %3", (long)n, (long)n4, (long)n2);
        IRouteInfo iRouteInfo = this.getMapMain().getRouteInfo();
        synchronized (iRouteInfo) {
            if (n4 != n2) {
                if (this.getLogChannel().isInfo()) {
                    this.getLogChannel().log(1000000, "Context#adaptDisplayContext(): switching from %2 -> %3 (%1)", (Object)MapUtils.contextToString(n3), (long)n2, (long)n4);
                }
                this.container.sDisplayContextAnimationRunning = true;
                choiceModelApp.setValue(n4);
            }
        }
    }

    protected void setVisibleArea() {
    }

    public void onChangedDayNightView(int n) {
        if (this.getMap().isMapKombi()) {
            this.getMap().getNaviInterface().getClusterService().applySetupHandlerSettings();
        }
    }

    public void onChangedOrientation(int n) {
        this.getLogChannel().log(1000000, "Context[%1]#onChangedOrientation: setupOrientation = %2", (long)this.getMap().getActiveContextIndex(), (long)n);
        if (this.getSetup().getMapType() == 1) {
            this.naviMap.getGuiInterface().refreshMapType(MapUtils.convertMapTypeIndex(1, n, this.env));
        }
    }

    public void onChangedPanorama(boolean bl) {
    }

    protected boolean enableDisableOrientation() {
        boolean bl = true;
        int n = this.getSetupMapType();
        if (n == 2 || n == 0 || n == 3) {
            bl = false;
        }
        this.getLogChannel().log(10000000, "Context#enableDisableOrientation() - orientation = %1", bl);
        this.naviMap.getGuiInterface().enableOrientation(bl);
        return bl;
    }

    public void activateOrientationAccordingToSetup() {
        boolean bl = this.enableDisableOrientation();
        if (bl) {
            int n = this.getSetupOrientation();
            if (n != 0 && this.naviMap.getMVResponseControl().getZoomListIndex() >= this.retrieveZoomListIndex(100000.0f)) {
                n = 0;
            }
            switch (n) {
                case 1: {
                    this.naviMap.getMVRequest().setOrientation(0);
                    break;
                }
                case 0: {
                    this.naviMap.getMVRequest().setOrientation(2);
                    break;
                }
            }
        }
    }

    private void switchDayColors(boolean bl) {
        if (bl) {
            this.naviMap.getMVRequest().setDayView();
        } else {
            this.naviMap.getMVRequest().setNightView();
        }
        this.setNaviOnlineServiceDayNightView(!bl);
    }

    private void setNaviOnlineServiceDayNightView(boolean bl) {
        if (!this.naviMap.isMapMain()) {
            return;
        }
        if (this.naviMap.getNaviInterface().getNaviOnlineService() == null || this.naviMap.getNaviInterface().getNaviOnlineService().getMapStateService() == null) {
            this.getLogChannel().log(100000, "Context#setNaviOnlineServiceDayNightView( %1 ) - Unable to inform NaviOnlineService about day/night view change!", bl);
            return;
        }
        this.getLogChannel().log(100000000, "Context#setNaviOnlineServiceDayNightView( %1 )", bl);
        this.naviMap.getNaviInterface().getNaviOnlineService().getMapStateService().onDayNightViewChanged(bl);
    }

    protected boolean calculateMapColorAccordingToSetup() {
        int n = this.getSetupDayNightView();
        this.getLogChannel().log(10000000, "Context#calculateMapColorAccordingToSetup() - mapColor: %1", (long)n);
        if (n == 0) {
            return true;
        }
        if (n == 1) {
            return false;
        }
        if (n == 2) {
            int n2 = this.getNightDesign();
            if (n2 == 0) {
                return true;
            }
            if (n2 == 1) {
                return false;
            }
            boolean bl = this.getDayNightView();
            this.getLogChannel().log(100000, "Context#calculateMapColorAccordingToSetup() - unknown night design mode: %2, keep current mode (true=day/night=false): %1", bl, (long)n2);
            return bl;
        }
        this.getLogChannel().log(100000, "Context#calculateMapColorAccordingToSetup() - unknown day/night mode type: %1", (long)n);
        return true;
    }

    public void switchDayNight() {
        int n = this.getSetupDayNightView();
        this.getLogChannel().log(10000000, "Context#switchDayNight() - mapColor: %1", (long)n);
        switch (n) {
            case 0: {
                this.switchDayColors(true);
                break;
            }
            case 1: {
                this.switchDayColors(false);
                break;
            }
            case 2: {
                this.switchMapAccordingToNightDesign();
                break;
            }
            default: {
                this.getLogChannel().log(10000, "Context#switchDayNight() - unknown day/night mode type: %1", (long)n);
            }
        }
    }

    protected void switchMapRepresentation() {
        int n = this.getMapRepresentation();
        this.getLogChannel().log(10000000, "Context#switchMapRepresentation() - mapRepresentation: %1", (long)n);
        boolean bl = this.getSetupSpeedAndFlowCongestions();
        boolean bl2 = this.getSetupSpeedAndFlowFreeflow();
        this.naviMap.getMVRequest().showSpeedAndFlowCongestions(bl);
        this.naviMap.getMVRequest().showSpeedAndFlowFreeflow(bl2);
        switch (n) {
            case 0: {
                if (Util.isPorscheGen2(this.env.getFramework()) && !Util.isHURegionAsia()) {
                    this.naviMap.getMVRequest().setTrafficMapStyle(true);
                    break;
                }
                this.naviMap.getMVRequest().setTrafficMapStyle(false);
                break;
            }
            case 2: 
            case 3: {
                if (!(Util.isHURegionNAR() || Util.isHURegionAsia() || Util.isPorsche(this.env.getFramework()))) {
                    this.naviMap.getMVRequest().setTrafficMapStyle(true);
                }
                if (!Util.isPorscheGen2(this.env.getFramework())) break;
                this.naviMap.getMVRequest().setTrafficMapStyle(true);
                break;
            }
            case 1: {
                if (Util.isPorscheGen2(this.env.getFramework())) {
                    this.naviMap.getMVRequest().setTrafficMapStyle(true);
                    break;
                }
                this.naviMap.getMVRequest().setTrafficMapStyle(false);
                break;
            }
            default: {
                this.getLogChannel().log(10000, "Context#switchMapRepresentation(): Setup: Map representation: Wrong representation type!");
            }
        }
    }

    protected void switchMapAccordingToNightDesign() {
        if (this.getSetupDayNightView() == 2) {
            int n = this.getNightDesign();
            switch (n) {
                case 1: {
                    this.switchDayColors(false);
                    break;
                }
                case 0: {
                    this.switchDayColors(true);
                    break;
                }
                default: {
                    this.getLogChannel().log(100000, "Context#switchMapAccordingToNightDesign() - unknown night design mode: %1 - use day mode as default", (long)n);
                    this.switchDayColors(true);
                }
            }
        }
    }

    protected void switchMobilityHorizonAccordingToSetup() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework())) {
            boolean bl = this.isRangeMapReadyToShow();
            this.getLogChannel().log(10000000, "Context#switchMobilityHorizonAccordingToSetup() - enable = %1", bl);
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.setMobilityHorizonVisibility(bl);
        }
    }

    public void onChangedSetup(int n, int n2) {
    }

    public void onChangedMapType(int n, int n2) {
        boolean bl;
        this.getLogChannel().log(1000000, "Context[%1]#onChangedMapType: setupMapType = %2", (long)this.getMap().getActiveContextIndex(), (long)n);
        this.naviMap.getGuiInterface().refreshMapType(MapUtils.convertMapTypeIndex(n, this.getSetupOrientation(), this.env));
        if (this.naviMap.getActiveContextIndex() == 2) {
            return;
        }
        if (this.getMapRepresentation() == 3) {
            return;
        }
        boolean bl2 = bl = n2 != 0 && n == 0 || n2 == 0 && n != 0;
        if (bl) {
            this.onChangedAutoZoom(this.getSetupAutoZoom());
        }
    }

    public void onChangedAutoZoom(int n) {
        if (!this.getMap().getMapConfig().hasZoomEngine()) {
            this.getLogChannel().log(100000, "Context[%2]#onChangedAutoZoom() - %1 has no ZoomEngine.", (Object)this.getMap().getName(), (long)this.getMap().getActiveContextIndex());
            return;
        }
        boolean bl = this.naviMap.getSetup().isManeuverZoomDependendOnAutoZoom();
        if (bl) {
            this.handleAutoZoomEngineOnOff();
            this.handleManeuverZoomEngineOnOff();
        } else {
            this.handleAutoZoomEngineOnOff();
        }
    }

    public void onChangedIntersectionZoom(int n, boolean bl) {
        if (!this.getMap().getMapConfig().hasZoomEngine()) {
            this.getLogChannel().log(100000, "Context[%2]#onChangedIntersectionZoom() - %1 has no ZoomEngine.", (Object)this.getMap().getName(), (long)this.getMap().getActiveContextIndex());
            return;
        }
        this.handleManeuverZoomEngineOnOff();
    }

    public void onChangedAdditionalInfos(int n) {
        if (this.naviMap.isMapMain()) {
            this.naviMap.getMapInterface().enableRouteInfoComplete(MapUtils.isRouteInfoComplete(n, Util.isClusterMMI(this.env.getFramework()), Util.isHURegionNAR()));
        }
        this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
        this.refreshPositionOfLeftDrawerButton();
    }

    protected void backupPOIVisibilityAndHideAllPOIs() {
        this.naviMap.getMVRequest().setGeneralPoiVisibility(false);
    }

    public void onChangedMapRepresentation(int n, int n2) {
        this.getLogChannel().log(1000000, "Context#onChangedMapRepresentation(): mapRepresentation: %1, active context: %2", (long)n, (long)this.naviMap.getActiveContextIndex());
        if (this.naviMap.getActiveContextIndex() == 2) {
            this.naviMap.getGuiInterface().refreshMapRepresentation();
            return;
        }
        this.naviMap.getGuiInterface().refreshMapRepresentation();
        this.switchMapRepresentation();
        this.naviMap.getMapManager().getSatelliteMapsMediator().onMapRepresentationChanged(n, n2);
        if (Util.isPorsche(this.env.getFramework())) {
            this.applyClusterSettings();
        } else {
            if ((n == 3 || n2 == 3) && this.getSetupMapType() != 0 && this.getSetupMapType() != 3) {
                this.onChangedAutoZoom(this.getSetupAutoZoom());
            }
            if (this.getMap().isMapKombi()) {
                this.applyClusterSettings();
            }
        }
    }

    private void applyClusterSettings() {
        this.getMap().getNaviInterface().getClusterService().applySetupHandlerSettings();
        this.getMap().getNaviInterface().getClusterService().updateOnlineNavigationState();
    }

    public String toString() {
        return this.getClass().getName();
    }

    public void automaticOrientateMap() {
    }

    public void adjustCarPosition() {
    }

    protected void handleAutoZoomEngineOnOff() {
        if (!this.getMapConfig().hasZoomEngine()) {
            this.getLogChannel().log(100000, "Context#handleAutoZoomEngineOnOff() - %1 has no ZoomEngine", (Object)this.getMap().getName());
            return;
        }
        this.getLogChannel().log(10000000, "Context#handleAutoZoomEngineOnOff()");
        int n = this.getSetupAutoZoom();
        this.switchAutoZoomOnOff(n);
    }

    public void switchAutoZoomOnOff(int n) {
        int n2 = this.env.getFramework().getSysConstManager().getSysConst(4445);
        if (n2 == 1) {
            if (this.container.sRGActive) {
                if (n == 0) {
                    this.getZoomHandler().autoZoomEnable(true);
                    this.getZoomHandler().manoeuvreZoomEnable(true);
                } else {
                    this.getZoomHandler().autoZoomEnable(false);
                }
                if (!MapUtils.isCtxCrosshairMap(this.naviMap.getActiveContextIndex())) {
                    this.naviMap.switchToAShownContext();
                }
            } else {
                this.getZoomHandler().autoZoomEnable(false);
                this.getZoomHandler().manoeuvreZoomEnable(false);
            }
        } else {
            this.getZoomHandler().autoZoomEnable(n == 0);
        }
    }

    protected void handleManeuverZoomEngineOnOff() {
        if (!this.getMapConfig().hasZoomEngine()) {
            this.getLogChannel().log(100000, "Context#handleManeuverZoomEngineOnOff() - %1 has no ZoomEngine", (Object)this.getMap().getName());
            return;
        }
        int n = this.getSetupAutoZoom();
        int n2 = this.env.getFramework().getSysConstManager().getSysConst(4445);
        if (n2 == 0) {
            if (this.container.sRGActive && n == 0 || n == 1) {
                this.getZoomHandler().manoeuvreZoomEnable(true);
            } else {
                this.getZoomHandler().manoeuvreZoomEnable(false);
            }
        } else if (this.container.sRGActive) {
            if (n == 0) {
                this.getZoomHandler().autoZoomEnable(true);
                this.getZoomHandler().manoeuvreZoomEnable(true);
            } else if (this.getMap().getSetup().getIntersectionZoom() == 0) {
                this.getZoomHandler().manoeuvreZoomEnable(true);
            } else if (this.getMap().getSetup().getIntersectionZoom() == 2 && n == 2) {
                this.getZoomHandler().autoZoomEnable(false);
                this.getZoomHandler().manoeuvreZoomEnable(false);
            } else if (n == 2 && this.getMap().getSetup().getIntersectionZoom() == 0) {
                this.getZoomHandler().autoZoomEnable(false);
            }
        } else {
            this.getZoomHandler().autoZoomEnable(false);
            this.getZoomHandler().manoeuvreZoomEnable(false);
        }
    }

    public void signalNaviNotOperable() {
        this.getLogChannel().log(1000000, "Context#signalNaviNotOperable()");
        this.naviMap.forceContext(-1);
        this.naviMap.switchToHiddenContext();
        this.storeKeptContextIndex(0);
    }

    public void setIsInVia(boolean bl) {
        this.getLogChannel().log(10000000, "Context#setIsInVia( %1 )", bl);
        this.container.isInVia = bl;
    }

    protected MapMain getMapMain() {
        if (this.naviMap instanceof MapMain) {
            return (MapMain)this.naviMap;
        }
        this.getLogChannel().log(100000, "Context#getMapMain() - should not be used by a context, which belongs to MapInMap.");
        return this.naviMap.getMapManager().getMapMain();
    }

    protected AbstractMap getMap() {
        return this.naviMap;
    }

    public boolean isUserZoomEnabled() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateViewScreenViewPort(Rect rect) {
        this.getLogChannel().log(10000000, "Context[%2]#updateViewScreenViewPort() - viewScreenViewPort: %1", (Object)rect, (long)this.getCID());
        MVRequestControl mVRequestControl = this.naviMap.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            if (this.naviMap.isMapMain()) {
                boolean bl = !MapUtils.isRectEqual(rect, this.getGUI().getMapSize());
                this.setGridMaskVisible(false, bl, false);
            }
        }
    }

    public MapPin[] getDynamicPins() {
        return new MapPin[0];
    }

    private void refreshPositionOfLeftDrawerButton() {
        if (this.container.sRGActive || this.getSetupAdditionalInfos() == 2) {
            this.getViews().getMainMapView().setLeftSideVisible(true);
        } else {
            this.getViews().getMainMapView().setLeftSideVisible(false);
        }
    }

    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
    }

    public void updateDestDistance(int n) {
        this.container.distToNextDest = n;
    }

    public void viewSizeChanged(int n) {
        if (n == this.getData().viewSize) {
            this.getLogChannel().log(10000000, "Context[%1]#viewSizeChanged( %2 ) - no change needed", (long)this.getCID(), (long)n);
            return;
        }
        if (n == 1) {
            this.getLogChannel().log(1000000, "Context[%1]#viewSizeChanged( %2 ) - change to small size", (long)this.getCID(), (long)n);
        } else if (n == 2) {
            this.getLogChannel().log(1000000, "Context[%1]#viewSizeChanged( %2 ) - change to large size", (long)this.getCID(), (long)n);
        } else {
            this.getLogChannel().log(100000, "Context[%1]#viewSizeChanged( %2 ) - invalid value", (long)this.getCID(), (long)n);
            return;
        }
        this.getData().viewSize = n;
    }

    public void setBackgroundRenderingMode(boolean bl) {
    }

    public void indicateTrafficEventNoticeMap(TmcMessage tmcMessage, NavRectangle navRectangle, int n) {
        this.getLogChannel().log(10000000, "Context#indicateTrafficEventNoticeMap() - message is(%1), NavRectangle is(%2), soundID is(%3)", (Object)tmcMessage, (Object)navRectangle, (long)n);
        this.container.trafficNoticeMessage = tmcMessage;
        this.container.trafficNoticeRectangle = navRectangle;
        this.container.trafficNoticeSoundID = n;
    }

    public void updateBapManeuverState(int n) {
        this.getLogChannel().log(10000000, "Context#updateBapManeuverState(%1)", (long)n);
        this.container.oldBapManoeuvreState = this.container.actualBapManoeuvreState;
        this.container.actualBapManoeuvreState = n;
        if (this.maneuverPassed()) {
            this.container.zoomTempDeactivated = false;
        }
    }

    protected boolean maneuverPassed() {
        this.getLogChannel().log(100000000, "Context#maneuverPassed()");
        return this.container.oldBapManoeuvreState >= this.container.actualBapManoeuvreState;
    }

    public void updateBapManeuverDescriptor(BapManeuverDescriptor[] bapManeuverDescriptorArray) {
    }

    public void hkBackPressed() {
    }

    public void onFiredRGAutoStartTimer() {
        this.getLogChannel().log(10000000, "Context[%1]#onFiredRGAutoStartTimer()", (long)this.getCID());
        this.getRouteCalcHandler().startRG(0);
    }

    public void resolvedSelectedValue(MapItemSelectionInfo mapItemSelectionInfo) {
    }

    public final void onEvent(int n) {
        this.getLogChannel().log(100000000, "Context[%1]#onEvent( %2 )", (long)this.getCID(), (long)n);
        this.onEvent(n, null);
    }

    public void onEvent(int n, Object object) {
        this.getLogChannel().log(10000000, "Context[%2]#onEvent( %3 ) - %1, dropped", object, (long)this.getCID(), (long)n);
    }

    public void updateMobilityHorizonStatus(int n) {
        this.container.mobilityHorizonStatus = n;
        switch (n) {
            case 3: {
                this.getLogChannel().log(10000, "Context#updateMobilityHorizonStatus( %1 ) - ERROR: Range map database defect!", (long)n);
                break;
            }
            case 2: {
                this.getLogChannel().log(10000, "Context#updateMobilityHorizonStatus( %1 ) - ERROR: Range map database not found!", (long)n);
                break;
            }
            case 99: {
                this.getLogChannel().log(10000, "Context#updateMobilityHorizonStatus( %1 ) - ERROR: Unknown range map failure!", (long)n);
                break;
            }
            case 6: {
                this.getLogChannel().log(100000, "Context#updateMobilityHorizonStatus( %1 ) - Not enough energy for showing range map!", (long)n);
                break;
            }
            case 0: {
                this.getLogChannel().log(100000, "Context#updateMobilityHorizonStatus( %1 ) - Range map not (yet) ready!", (long)n);
                break;
            }
            default: {
                this.getLogChannel().log(100000, "Context#updateMobilityHorizonStatus( unknown status )");
            }
        }
    }

    public boolean isRangeMapReadyToShow() {
        return Util.isRangeMapDisplayPresent(this.env.getFramework()) && this.naviMap.isMapMain() && this.naviMap.getSetup().getMapRepresentation() == 3 && MapUtils.isRangeMapStatusOk(this.container.mobilityHorizonStatus);
    }

    public void setRangeMapDefaultZoomLevel() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework()) && this.naviMap.isMapMain() && this.naviMap.getSetup().getMapRepresentation() == 3) {
            this.getLogChannel().log(100000000, "Context#setRangeMapDefaultZoomLevel()");
            IZoomHandler iZoomHandler = this.naviMap.getZoomHandler();
            int n = iZoomHandler.getZoomListIndex(15000.0f);
            this.naviMap.getMapDataContainer().fUserZoomLevel = iZoomHandler.getZoomLevel(n) / 100.0f;
            this.getSetup().setSavedZoomListIndex(iZoomHandler.getZoomListIndex(15000.0f), false);
        }
    }

    protected boolean isSetupWeatherIconVisible() {
        return Util.isWeatherOnMapPresent(this.env.getFramework()) ? this.getSetup().isWeatherIconVisible(0) : false;
    }

    public void setOperatorCallResultLocation(NavLocationWgs84 navLocationWgs84) {
        this.getLogChannel().log(10000000, "Context#setLocationInMapForOperatorCall() - location: %1", (Object)navLocationWgs84);
        this.container.operatorCallResultLocation = navLocationWgs84;
    }

    private boolean isInitializationContextActive(AbstractMap abstractMap) {
        int n = 100000000;
        if (Util.isPorsche(this.env.getFramework())) {
            n = 100000;
        }
        if (abstractMap == null) {
            this.getLogChannel().log(n, "Context#isInitializationContextActive() - map is null");
            return true;
        }
        boolean bl = abstractMap.getActiveContextIndex() == 0 || abstractMap.getActiveContextIndex() == 2 || abstractMap.getActiveContextIndex() == 1;
        this.getLogChannel().log(n, "Context#isInitializationContextActive() isMapMain: %1  isInitializing: %2", abstractMap.isMapMain(), bl);
        this.getLogChannel().log(n, "Context#isInitializationContextActive() contextIndex: %1  ", (long)abstractMap.getActiveContextIndex());
        return bl;
    }

    protected int getSetupDayNightView() {
        int n = 10000000;
        if (Util.isPorsche(this.env.getFramework())) {
            n = 10000;
        }
        int n2 = this.getMapMain().getSetup().getDayNightView();
        int n3 = State.StateData.getDefaultDayNightView();
        AbstractMap abstractMap = this.getMap().getMapManager().getMapKombi();
        if (abstractMap == null) {
            this.getLogChannel().log(n, "Context#getSetupDayNightView() - getMapKombi() is NULL, therfore no SETUP of the Kombi! setUpMapMainDN: %1", (long)n2);
        } else {
            n3 = abstractMap.getSetup().getDayNightView();
            if (this.isInitializationContextActive(abstractMap) || this.isInitializationContextActive(this.getMapMain())) {
                this.getLogChannel().log(n, "Context#getSetupDayNightView()  setups not intialized yet - currently stored settings setupMapMainDN: %1 setupMapKombiDN: %2", (long)n2, (long)n3);
            } else if (n3 != n2) {
                this.getLogChannel().log(n, "Context#getSetupDayNightView() stored settings differ - mapMain: %1 mapKombi: %2", (long)n2, (long)n3);
            }
        }
        return this.getMap().isMapKombi() ? n3 : n2;
    }

    public void informTENMPopupPosition(int n, int n2, int n3, int n4) {
        this.getLogChannel().log(100000000, "Context#informTENMPopupPosition() - TENM popup info: [%1]", (Object)new Rect(n, n2, n3, n4));
    }

    public boolean inIntersectionZoomState() {
        if ((this.container.actualBapManoeuvreState == 2 || this.container.actualBapManoeuvreState == 3 || this.container.actualBapManoeuvreState == 4) && this.getRGActive()) {
            this.getLogChannel().log(100000000, "Context#inIntersectionZoomState() -- TRUE");
            return true;
        }
        this.getLogChannel().log(100000000, "Context#inIntersectionZoomState() -- FALSE");
        return false;
    }

    public void updateCurrentViewType(int n) {
        this.getLogChannel().log(10000000, "Context#updateCurrentViewType( %1 )", (long)n);
        if (this.getGUI() != null) {
            this.getGUI().updateStateIndicator(PropertyEnum.MapViewType, n);
        }
    }

    public void recalculateVisibleArea() {
    }

    public void updateLockingState(boolean bl) {
        if (bl) {
            if (Util.isLockFeatureNavMapAdvancedMapEnabled(this.env)) {
                if (this.getSetup().getMapRepresentation() == 1) {
                    this.getLogChannel().log(10000000, "Context#updateLockingState -> SatMap change to Standard");
                    this.naviMap.getMapInterface().setGoogleTempDisabled(true);
                    this.naviMap.getMapManager().setMapRepresentation(0, false, false);
                }
                this.naviMap.getGuiInterface().setGoogleSettingVisible(false);
                this.naviMap.getMapInterface().refreshMapContent();
            }
        } else if (Util.isLockFeatureNavMapAdvancedMapEnabled(this.env)) {
            if (this.naviMap.getMapInterface().isGoogleTempDisabled()) {
                this.getLogChannel().log(10000000, "Context#updateLockingState -> Change back to SatMap");
                this.naviMap.getMapInterface().setGoogleTempDisabled(false);
                this.naviMap.getMapManager().setMapRepresentation(1, false, false);
            }
            this.naviMap.getGuiInterface().setGoogleSettingVisible(true);
            this.naviMap.getMapInterface().refreshMapContent();
        }
        super.updateLockingState(bl);
    }

    private final class GridMaskDelayTimer
    implements TimerListener {
        private final Timer mTimer = new Timer("GridMaskDelayTimer", 200L, true, this);

        GridMaskDelayTimer() {
        }

        private void restart() {
            Context.this.getLogChannel().log(1000000, "Context#GridMaskDelayTimer#restart(): timer restarted");
            this.mTimer.restart();
        }

        private void cancel() {
            Context.this.getLogChannel().log(1000000, "Context#GridMaskDelayTimer#cancel(): timer cancelled");
            this.mTimer.cancel();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Context.this.getLogChannel().log(1000000, "Context#GridMaskDelayTimer#fireTimer(): timer fired");
            MVRequestControl mVRequestControl = Context.this.naviMap.getMVRequest().getMVRequestControlActive();
            synchronized (mVRequestControl) {
                GridMaskWatchdogTimer gridMaskWatchdogTimer = Context.this.getGridMaskWatchdogTimer();
                if (gridMaskWatchdogTimer != null) {
                    gridMaskWatchdogTimer.cancel();
                }
                Context.this.getGUI().setGridMaskVisible(false);
            }
        }

        public void cancelTimer(Timer timer) {
        }
    }

    private final class GridMaskWatchdogTimer
    implements TimerListener {
        public static final long DEFAULT_DELAY = 3000L;
        public static final long LONG_DELAY = 10000L;
        private final Timer mTimer = new Timer("GridMaskWatchdogTimer", 3000L, true, this);

        GridMaskWatchdogTimer() {
        }

        private void restart(boolean bl) {
            Context.this.getLogChannel().log(1000000, "Context#GridMaskWatchdogTimer#restart(): timer restarted,  longDelay: %1 ", bl);
            if (!bl && this.mTimer.isRunning() && this.mTimer.getDelay() == 10000L) {
                Context.this.getLogChannel().log(1000000, "Context#GridMaskWatchdogTimer#restart(): timer still running with long delay - restart with long delay ");
                bl = true;
            }
            long l = bl ? 10000L : 3000L;
            this.mTimer.setDelay(l);
            this.mTimer.restart();
        }

        private void cancel() {
            Context.this.getLogChannel().log(1000000, "Context#GridMaskWatchdogTimer#cancel(): timer cancelled");
            this.mTimer.cancel();
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Context.this.getLogChannel().log(100000, "Context#GridMaskWatchdogTimer#fireTimer() - delay: %1 s -> Hide grid mask!", timer.getDelay() / 1000L);
            MVRequestControl mVRequestControl = Context.this.naviMap.getMVRequest().getMVRequestControlActive();
            synchronized (mVRequestControl) {
                GridMaskDelayTimer gridMaskDelayTimer = Context.this.getGridMaskDelayTimer();
                if (gridMaskDelayTimer != null) {
                    gridMaskDelayTimer.cancel();
                }
                Context.this.getGUI().setGridMaskVisible(false);
                Rect rect = Context.this.naviMap.getMVRequest().getPendingScreenViewport();
                if (rect != null) {
                    Context.this.getLogChannel().log(100000, "Context#GridMaskWatchdogTimer#fireTimer() - fake updateViewScreenViewPort for pendingViewPort: %1", (Object)rect);
                    Context.this.naviMap.getMVResponseControl().updateViewScreenViewPort(rect, 1);
                }
            }
        }

        public void cancelTimer(Timer timer) {
        }
    }
}

