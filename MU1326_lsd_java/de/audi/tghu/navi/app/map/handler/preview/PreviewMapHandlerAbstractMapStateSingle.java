/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler.preview;

import de.audi.atip.interapp.navigation.previewmap.gui.GuiModelAccessForPreviewMapDetailScreen;
import de.audi.atip.interapp.navigation.previewmap.gui.GuiTooltipInformationContainer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.IVisibleContext;
import de.audi.tghu.navi.app.map.MapDataContainer;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.MVRequestControl;
import de.audi.tghu.navi.app.map.handler.IZoomHandler;
import de.audi.tghu.navi.app.map.handler.NullPreviewMapCallback;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstract;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapHandlerAbstractMapStateSingle$PreviewMapState;
import de.audi.tghu.navi.app.map.handler.preview.PreviewMapUtils;
import de.audi.tghu.navi.app.map.handler.preview.gui.GuiPreviewMapLayout;
import de.audi.tghu.navi.app.map.handler.preview.states.PreviewMapStateAbstract;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.Rect;

public abstract class PreviewMapHandlerAbstractMapStateSingle
extends PreviewMapHandlerAbstract {
    protected PreviewMapHandlerAbstractMapStateSingle$PreviewMapState backupStateCurrent;
    private int restoreMapContext = -1;
    private PreviewMapHandlerAbstractMapStateSingle$PreviewMapState restorePreviewMapState;
    protected boolean storeFocusForEnterOnce = false;
    private boolean ignoreForBackupState = false;

    protected PreviewMapHandlerAbstractMapStateSingle(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void setStoreFocusForEnterOnce(boolean bl) {
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#setStoreFocusForEnterOnce( %1 ) ", bl);
        if (!this.isPreviewMapOperable()) {
            this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setStoreFocusForEnterOnce() - preview map not operable!");
            return;
        }
        this.storeFocusForEnterOnce = bl;
    }

    public void previewMapScreenEnteringExecute(int n, int n2, int n3, int n4, boolean bl) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#enterPreviewMapScreenExecute() - width: %1, height: %2, ignoreForBackupState: %3", (long)n, (long)n2, bl);
        if (n3 != 0 || n4 != 0) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#enterPreviewMapScreenExecute() - offX: %1, offY: %2", (long)n3, (long)n4);
        }
        if (!this.isPreviewMapOperable()) {
            this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#enterPreviewMapScreenExecute() - preview map not operable!");
            return;
        }
        int n5 = this.mapForPreview.getActiveContextIndex();
        if (!this.ignoreForBackupState) {
            if (this.mapForPreview.getMapDataContainer().isInMap || this.mapForPreview.getMapDataContainer().isInMapMain()) {
                this.setRestoreMapContext(0, null);
                this.mapForPreview.getMapInterface().previewMapEntered();
            } else if (MapUtils.isPreviewMapContext(n5)) {
                this.setRestoreMapContext(1, this.backupStateCurrent);
            } else {
                this.setRestoreMapContext(-1, null);
            }
        }
        this.ignoreForBackupState = bl;
        MapDataContainer mapDataContainer = this.mapForPreview.getMapDataContainer();
        if (Util.isClusterMMI(this.mapForPreview.getNavigationEnv().getFramework())) {
            mapDataContainer.sPreviewMapWidth = 0;
            mapDataContainer.sPreviewMapHeight = 0;
            mapDataContainer.sPreviewMapOffsetX = 0;
            mapDataContainer.sPreviewMapOffsetY = 0;
        } else {
            mapDataContainer.sPreviewMapWidth = n;
            mapDataContainer.sPreviewMapHeight = n2;
            mapDataContainer.sPreviewMapOffsetX = n3;
            mapDataContainer.sPreviewMapOffsetY = n4;
        }
        this.mapForPreview.showPreviewMap();
        if (this.backupStateCurrent != null) {
            if (this.storeFocusForEnterOnce || !this.backupStateCurrent.previewMapWasReady) {
                this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#enterPreviewMapScreenExecute() - previewmap was not ready while last focus request: %1", !this.backupStateCurrent.previewMapWasReady);
                this.backupStateCurrent.apply(this);
            }
            this.storeFocusForEnterOnce = false;
        }
        if (this.previewMapListHandler != null) {
            this.previewMapListHandler.onPreviewMapEntered();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void previewMapScreenExited() {
        int n = this.getRestoreMapContext();
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewMapScreenExited() - restoreContext: %1 ", (long)n);
        if (n == 0) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#previewMapScreenExited() - restore main map context");
            this.showGridMask();
            this.mapForPreview.getMapInterface().previewMapLeft();
        } else if (n == 1) {
            this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#previewMapScreenExited() - restore state and stay in preview map context");
            if (this.restorePreviewMapState != null) {
                this.restorePreviewMapState.apply(this);
            }
        } else {
            this.showGridMask();
            Object object = this.mapForPreview.getMutexSwitchToContext();
            synchronized (object) {
                if (this.isPreviewMapReady()) {
                    try {
                        this.mapForPreview.switchToHiddenContext();
                    }
                    catch (Exception exception) {
                        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewMapScreenExited: Exception %1", (Throwable)exception);
                    }
                } else {
                    this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#previewMapScreenExited() - preview map not ready!");
                }
            }
        }
        if (this.previewMapListHandler != null) {
            this.previewMapListHandler.onPreviewMapLeft();
        }
        this.deregisterPreviewMapCallback();
        this.setRestoreMapContext(-1, null);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void showGridMask() {
        MVRequestControl mVRequestControl = this.mapForPreview.getMVRequest().getMVRequestControlActive();
        synchronized (mVRequestControl) {
            if (this.mapForPreview.getActiveContext() instanceof CtxShown && MapUtils.isRectEqual(this.mapForPreview.getGuiInterface().getMapSize(), this.mapForPreview.getMVResponseControl().getViewScreenViewPort())) {
                this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#showGridMask() - currently in CtxShown and already in fullscreen - ignore ");
                return;
            }
            this.mapForPreview.getActiveCtx().setGridMaskVisible(true);
        }
    }

    private void deregisterPreviewMapCallback() {
        this.previewMapListHandler = new NullPreviewMapCallback(this.logger);
    }

    @Override
    public void setPreviewRoadSegment(int n, int n2, int n3, int n4, long l, long l2, int n5, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewRoadSegment() - xLeft:%1, xRight:%2, yBottom:%3", (long)n, (long)n2, (long)n3);
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewRoadSegment() - yUp:%1, startDistance:%2, endDistance:%3", (long)n4, l, l2);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.mapForPreview.getMVRequest().highlightRouteBasedOnLength(l, l2, 1);
            this.setPreviewMapModeAndFrameRate(2);
            object = new NavRectangle();
            ((NavRectangle)object).xLeft = n;
            ((NavRectangle)object).xRight = n2;
            ((NavRectangle)object).yBottom = n3;
            ((NavRectangle)object).yUp = n4;
            int n6 = this.mapForPreview.getZoomHandler().getZoomListIndex(51266);
            this.mapForPreview.getMVRequest().setMapViewPortByWGS84Rectangle((NavRectangle)object, n6);
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#setPreviewRoadSegment() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 1;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).xLeft = n;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).xRight = n2;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).yBottom = n3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).yUp = n4;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).startDistance = l;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).endDistance = l2;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    @Override
    public void setPreviewTrafficInfoTmcEvent(long l, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewTMCEvent() - messageId: %1", l);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.previewMapEventVisibilities.ensureTMCVisibility(new long[]{l}, false);
            this.mapFreeze();
            this.setPreviewMapModeAndFrameRate(2);
            this.mapUnfreezeLevel1();
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
            this.mapForPreview.getMVRequest().goToTMCMessage(l);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvent() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.tmcEvent = l;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 4;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    @Override
    public synchronized void setPreviewTrafficInfoTmcEvents(long[] lArray, NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewTMCEvents() - number of events: %2, rectangle: %1", (Object)navRectangle, lArray == null ? 0L : (long)lArray.length);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            if (lArray != null && lArray.length != 0 && Util.isNavRectangleValid(navRectangle)) {
                this.previewMapEventVisibilities.ensureTMCVisibility(lArray, false);
                this.setPreviewMapModeAndFrameRate(2);
                object = Util.getLocationFromGeoPos(navRectangle.getXLeft(), navRectangle.getYUp());
                NavLocation navLocation = Util.getLocationFromGeoPos(navRectangle.getXRight(), navRectangle.getYBottom());
                int n2 = this.getTmcMinZoomIndex();
                this.mapForPreview.getMVRequest().setMapViewportByLD((NavLocation)object, navLocation, n2);
                this.mapForPreview.getGuiInterface().showPreviewMap(true);
            } else {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#setPreviewTMCEvents() - could not calculate rectangle => hide preview map instead");
                this.hidePreviewMap();
            }
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#setPreviewTMCEvents() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).messageIds = lArray;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).rectangle = navRectangle;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    @Override
    public synchronized void setPreviewTrafficInfoTmcEventsForRouteList(NavRectangle navRectangle, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewTMCEventsForRouteList( %1 )", (Object)navRectangle);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            if (Util.isNavRectangleValid(navRectangle)) {
                this.mapForPreview.getMVRequest().showTMCMessages(true);
                this.setPreviewMapModeAndFrameRate(2);
                object = Util.getLocationFromGeoPos(navRectangle.getXLeft(), navRectangle.getYUp());
                NavLocation navLocation = Util.getLocationFromGeoPos(navRectangle.getXRight(), navRectangle.getYBottom());
                int n2 = this.mapForPreview.getZoomHandler().getZoomListIndex(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
                this.mapForPreview.getMVRequest().setMapViewportByLD((NavLocation)object, navLocation, n2);
                this.mapForPreview.getGuiInterface().showPreviewMap(true);
            } else {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEventsForRouteList() - could not calculate rectangle => hide preview map instead");
                this.hidePreviewMap();
            }
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEventsForRouteList() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).rectangle = navRectangle;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    private int getRestoreMapContext() {
        return this.restoreMapContext;
    }

    private void setRestoreMapContext(int n, PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setRestoreMapContext() - restoreMapContext: %2 [-1:None, 0:MapMain, 1:PreviewMap], restoreState: %1 ", (Object)previewMapHandlerAbstractMapStateSingle$PreviewMapState, (long)n);
        this.restoreMapContext = n;
        this.restorePreviewMapState = previewMapHandlerAbstractMapStateSingle$PreviewMapState;
    }

    @Override
    public void setPreviewAreaAroundCCP(int n) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewAreaAroundCCP()");
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.setPreviewMapModeAndFrameRate(1);
            this.mapForPreview.getZoomHandler().setZoomLevel(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewAreaAroundCCP() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 0;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    public void setPreviewRoadSegment(int n, int n2, int n3, int n4, long l, long l2) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewRoadSegment() - xLeft:%1, xRight:%2, yBottom:%3", (long)n, (long)n2, (long)n3);
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewRoadSegment() - yUp:%1, startDistance:%2, endDistance:%3", (long)n4, l, l2);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.mapForPreview.getMVRequest().highlightRouteBasedOnLength(l, l2, 1);
            this.setPreviewMapModeAndFrameRate(2);
            object = new NavRectangle();
            ((NavRectangle)object).xLeft = n;
            ((NavRectangle)object).xRight = n2;
            ((NavRectangle)object).yBottom = n3;
            ((NavRectangle)object).yUp = n4;
            int n5 = this.mapForPreview.getZoomHandler().getZoomListIndex(51266);
            this.mapForPreview.getMVRequest().setMapViewPortByWGS84Rectangle((NavRectangle)object, n5);
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewRoadSegment() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 1;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).xLeft = n;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).xRight = n2;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).yBottom = n3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).yUp = n4;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).startDistance = l;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).endDistance = l2;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    public void setPreviewTMCEvent(long l) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvent() - messageId: %1", l);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.previewMapEventVisibilities.ensureTMCVisibility(new long[]{l}, false);
            this.mapFreeze();
            this.setPreviewMapModeAndFrameRate(2);
            this.mapUnfreezeLevel1();
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
            this.mapForPreview.getMVRequest().goToTMCMessage(l);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvent() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.tmcEvent = l;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 4;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    public synchronized void setPreviewTMCEvents(long[] lArray, NavRectangle navRectangle) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvents() - number of events: %2, rectangle: %1", (Object)navRectangle, lArray == null ? 0L : (long)lArray.length);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.previewMapEventVisibilities.resetEventVisibilities();
            if (lArray != null && lArray.length != 0 && Util.isNavRectangleValid(navRectangle)) {
                this.previewMapEventVisibilities.ensureTMCVisibility(lArray, false);
                this.setPreviewMapModeAndFrameRate(2);
                object = Util.getLocationFromGeoPos(navRectangle.getXLeft(), navRectangle.getYUp());
                NavLocation navLocation = Util.getLocationFromGeoPos(navRectangle.getXRight(), navRectangle.getYBottom());
                int n = this.getTmcMinZoomIndex();
                this.mapForPreview.getMVRequest().setMapViewportByLD((NavLocation)object, navLocation, n);
                this.mapForPreview.getGuiInterface().showPreviewMap(true);
            } else {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvents() - could not calculate rectangle => hide preview map instead");
                this.hidePreviewMap();
            }
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEvents() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).messageIds = lArray;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).rectangle = navRectangle;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    public synchronized void setPreviewTMCEventsForRouteList(NavRectangle navRectangle) {
        Object object;
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEventsForRouteList( %1 )", (Object)navRectangle);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            if (Util.isNavRectangleValid(navRectangle)) {
                this.mapForPreview.getMVRequest().showTMCMessages(true);
                this.setPreviewMapModeAndFrameRate(2);
                object = Util.getLocationFromGeoPos(navRectangle.getXLeft(), navRectangle.getYUp());
                NavLocation navLocation = Util.getLocationFromGeoPos(navRectangle.getXRight(), navRectangle.getYBottom());
                int n = this.mapForPreview.getZoomHandler().getZoomListIndex(IZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL);
                this.mapForPreview.getMVRequest().setMapViewportByLD((NavLocation)object, navLocation, n);
                this.mapForPreview.getGuiInterface().showPreviewMap(true);
            } else {
                this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEventsForRouteList() - could not calculate rectangle => hide preview map instead");
                this.hidePreviewMap();
            }
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewTMCEventsForRouteList() - preview map currently not active!");
        }
        object = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).previewMapState = 3;
        ((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object).rectangle = navRectangle;
        this.storeNewBackupStateAsCurrent((PreviewMapHandlerAbstractMapStateSingle$PreviewMapState)object, bl);
    }

    protected int getTmcMinZoomIndex() {
        if (Util.isHURegionNAR()) {
            return this.mapForPreview.getZoomHandler().getZoomListIndex(51267);
        }
        return this.mapForPreview.getZoomHandler().getZoomListIndex(8403781);
    }

    @Override
    public void setPreviewPredictiveNavigationRoute(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#setPreviewPredictiveNavigationRoute() - route ID: %1 ", (Object)navSegmentID);
        this.setPreviewPredictiveNavigationRoutes(new NavSegmentID[]{navSegmentID}, n, guiModelAccessForPreviewMapDetailScreen, guiTooltipInformationContainer);
    }

    @Override
    public void setPreviewPredictiveNavigationRoutes(NavSegmentID[] navSegmentIDArray, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilitiesPredictiveNav();
            this.mapFreeze();
            this.setPreviewMapModeAndFrameRate(16);
            this.mapForPreview.getMVRequest().setVisibleRoutes(navSegmentIDArray);
            this.mapUnfreezeLevel1();
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewPredictiveNavigationRoute() - preview map currently not active!");
        }
        this.createAndStoreSelenaPreviewMapState(navSegmentIDArray, bl);
    }

    protected void createAndStoreSelenaPreviewMapState(NavSegmentID[] navSegmentIDArray, boolean bl) {
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 7;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.routeId = navSegmentIDArray;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    @Override
    public void setPreviewRouteOffroad(NavSegmentID navSegmentID, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewOffroadRoute() - route ID: %1 ", (Object)navSegmentID);
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            this.mapFreeze();
            this.setPreviewMapModeAndFrameRate(10);
            this.mapForPreview.getMVRequest().setVisibleRoutes(new NavSegmentID[]{navSegmentID});
            this.mapUnfreezeLevel1();
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewOffroadRoute() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 8;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.routeId = new NavSegmentID[]{navSegmentID};
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    @Override
    public void setPreviewRoute(boolean bl, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewRoute() - completeRoute: %1 ", bl);
        boolean bl2 = this.isPreviewMapReady();
        if (bl2) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            if (this.mapForPreview.getNavigationEnv().getContainer().isRgActive()) {
                if (bl) {
                    this.setPreviewMapModeAndFrameRate(10);
                } else {
                    this.setPreviewMapModeAndFrameRate(0);
                }
            } else {
                this.setPreviewAreaAroundCCP(-1);
            }
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewRoute() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 2;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.completeRoute = bl;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl2);
    }

    @Override
    public void setPreviewRoute(boolean bl, boolean bl2, int n, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewRoute() - completeRoute: %1 rgActive: %2 ", bl, bl2);
        boolean bl3 = this.isPreviewMapReady();
        if (bl3) {
            this.getPreviewMapEventVisibilities().resetEventVisibilities();
            if (bl2) {
                if (bl) {
                    this.setPreviewMapModeAndFrameRate(10);
                } else {
                    this.setPreviewMapModeAndFrameRate(0);
                }
            } else {
                this.setPreviewAreaAroundCCP(-1);
            }
            this.mapForPreview.getGuiInterface().showPreviewMap(true);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#previewRoute() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 2;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.completeRoute = bl;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl3);
    }

    @Override
    public void setPreviewRouteEvent(NavLocation navLocation, int n, int n2, GuiModelAccessForPreviewMapDetailScreen guiModelAccessForPreviewMapDetailScreen, GuiTooltipInformationContainer guiTooltipInformationContainer) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#previewRouteEvent() - NOT YET IMPLEMENTED");
    }

    @Override
    public void hidePreviewMap() {
        super.hidePreviewMap();
        boolean bl = this.isPreviewMapReady();
        if (bl) {
            this.mapForPreview.getActiveCtx().showMap(false);
        } else {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#hidePreviewMap() - preview map currently not active!");
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 9;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl);
    }

    @Override
    public void setPreviewMapModeAndFrameRate(int n) {
        this.logger.log(14808325, "PreviewMapHandlerAbstractMapStateSingle#showPreviewMap() - mode: %1 ", (long)n);
        this.mapForPreview.getMVRequest().setMode(n);
        this.mapForPreview.getActiveCtx().showMap(true, 2);
    }

    protected void storeNewBackupStateAsCurrent(PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState, boolean bl) {
        this.logger.log(14808325, "PreviewMapHandlerAbstractMapStateSingle#storeNewBackupStateAsCurrent() - state: %1 ", (Object)previewMapHandlerAbstractMapStateSingle$PreviewMapState);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapWasReady = bl;
        this.backupStateCurrent = previewMapHandlerAbstractMapStateSingle$PreviewMapState;
    }

    private boolean focus(NavLocationWgs84[] navLocationWgs84Array, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs84, int n, float f2) {
        int n2;
        int n3;
        int n4 = navLocationWgs84Array == null ? 0 : navLocationWgs84Array.length;
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#focus() - number of locations: %1, forSDS: %2, centerOnPivot: %3, pivot: %4", (Object)new Integer(n4), (Object)new Boolean(bl), (Object)new Boolean(bl3), (Object)navLocationWgs84);
        this.logger.log(-2137614336, "PreviewMapHandlerAbstractMapStateSingle#focus() - pivotStyle: %1", (long)n);
        if (!this.isPreviewMapReady()) {
            this.logger.log(-1601830656, "PreviewMapHandlerAbstractMapStateSingle#focus() - preview map currently not active!");
            return false;
        }
        if (navLocationWgs84Array == null) {
            navLocationWgs84Array = new NavLocationWgs84[]{};
        }
        NavLocationWgs84[] navLocationWgs84Array2 = navLocationWgs84Array;
        if (navLocationWgs84 != null) {
            n3 = n == 29 ? navLocationWgs84Array.length : navLocationWgs84Array.length + 1;
            navLocationWgs84Array2 = new NavLocationWgs84[navLocationWgs84Array.length + 1];
            System.arraycopy((Object)navLocationWgs84Array, 0, (Object)navLocationWgs84Array2, 0, navLocationWgs84Array.length);
            navLocationWgs84Array2[navLocationWgs84Array.length] = navLocationWgs84;
        } else {
            n3 = navLocationWgs84Array.length;
        }
        int[] nArray = new int[navLocationWgs84Array2.length];
        for (n2 = 0; n2 < navLocationWgs84Array.length; ++n2) {
            nArray[n2] = PreviewMapUtils.getMapStyleType(navLocationWgs84Array.length, n2, bl, bl2);
        }
        if (navLocationWgs84 != null) {
            nArray[navLocationWgs84Array.length] = n;
        }
        if (navLocationWgs84Array2.length == 0) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#focus() - no locations available => hide preview map instead");
            this.hidePreviewMap();
            return true;
        }
        n2 = -1;
        if (navLocationWgs84Array2.length == 1) {
            n2 = this.mapForPreview.getZoomHandler().getZoomListIndex(f2);
        }
        this.getPreviewMapEventVisibilities().resetEventVisibilities();
        NavRectangle navRectangle = PreviewMapUtils.calculateMapSection(this.logger, navLocationWgs84Array2, navLocationWgs84, bl3);
        if (navRectangle == null || !Util.isNavRectangleValid(navRectangle)) {
            this.logger.log(10000, "PreviewMapHandlerAbstractMapStateSingle#focus() - could not calculate a rectangle or all locations were invalid => hide preview map instead");
            this.hidePreviewMap();
            return true;
        }
        this.mapFreeze();
        if (Util.isHURegionAsia()) {
            this.setPreviewMapModeAndFrameRate(10);
            if (this.mapForPreview.getActiveContext() instanceof IVisibleContext) {
                Rect rect = ((IVisibleContext)this.mapForPreview.getActiveContext()).getVisibleArea();
                this.mapForPreview.getMVRequest().setZoomArea(rect);
            }
        }
        this.setPreviewMapModeAndFrameRate(2);
        this.mapForPreview.getMVRequest().setMapViewPortByWGS84Rectangle(navRectangle, n2);
        this.mapUnfreezeLevel1();
        this.mapForPreview.getGuiInterface().showPreviewMap(true);
        this.setFlagsInMap(navLocationWgs84Array2, nArray, n3);
        return true;
    }

    protected void focusOnPOIsAndCreateNewPreviewMapState(NavLocation[] navLocationArray, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs84, int n, float f2) {
        boolean bl4 = this.focus(Util.navLocationsToWgs84(navLocationArray), bl, bl2, bl3, navLocationWgs84, n, f2);
        if (bl4) {
            this.getPreviewMapEventVisibilities().ensurePOIVisibility(navLocationArray, false);
        }
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.pois = navLocationArray;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.forSdsShowNumberedMapPins = bl;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.forTourShowNumberedMapPins = bl2;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.centerOnPivot = bl3;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.locationPivotOrCcpWgs84 = navLocationWgs84;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.pivotStyle = n;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 5;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.defaultZoomLevel = f2;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl4);
    }

    protected void focusOnLocationAndCreateNewPreviewMapStateAsCurrent(NavLocationWgs84 navLocationWgs84, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs842, int n, float f2) {
        NavLocationWgs84[] navLocationWgs84Array = navLocationWgs84 == null ? null : new NavLocationWgs84[]{navLocationWgs84};
        this.focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(navLocationWgs84Array, bl, bl2, bl3, navLocationWgs842, n, f2);
    }

    protected void focusOnLocationsAndCreateNewPreviewMapStateAsCurrent(NavLocationWgs84[] navLocationWgs84Array, boolean bl, boolean bl2, boolean bl3, NavLocationWgs84 navLocationWgs84, int n, float f2) {
        boolean bl4 = this.focus(navLocationWgs84Array, bl, bl2, bl3, navLocationWgs84, n, f2);
        PreviewMapHandlerAbstractMapStateSingle$PreviewMapState previewMapHandlerAbstractMapStateSingle$PreviewMapState = new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.locations = navLocationWgs84Array;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.forSdsShowNumberedMapPins = bl;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.forTourShowNumberedMapPins = bl2;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.centerOnPivot = bl3;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.locationPivotOrCcpWgs84 = navLocationWgs84;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.pivotStyle = n;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.previewMapState = 6;
        previewMapHandlerAbstractMapStateSingle$PreviewMapState.defaultZoomLevel = f2;
        this.storeNewBackupStateAsCurrent(previewMapHandlerAbstractMapStateSingle$PreviewMapState, bl4);
    }

    @Override
    public void refreshLastRequestedState(int n) {
        this.logger.log(1078071040, "PreviewMapHandlerAbstractMapStateSingle#refreshLastRequestedState()");
        if (this.backupStateCurrent != null) {
            this.backupStateCurrent.apply(this);
        }
    }

    protected PreviewMapHandlerAbstractMapStateSingle$PreviewMapState getPreviewMapState() {
        return new PreviewMapHandlerAbstractMapStateSingle$PreviewMapState(this);
    }

    public void setPreviewLocationConcierge(NavLocationWgs84 navLocationWgs84, String string, String string2) {
    }

    public void setPreviewLocationTpeg(NavLocation navLocation) {
    }

    @Override
    public void callbackByMapContextOnEnteringMapPreview() {
    }

    @Override
    public void callbackByMapContextOnEnteringMapFullscreen() {
    }

    public void setFlagApplicationContextFavoritesNavi(boolean bl) {
    }

    public void setPreviewPOIsOnboardFromTourListOrRouteList(NavLocation[] navLocationArray) {
    }

    public void setPreviewLocationFromTourList(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public GuiPreviewMapLayout getGuiPreviewMapLayoutCurrent() {
        return null;
    }

    @Override
    protected PreviewMapStateAbstract getPreviewMapStateCurrent() {
        return null;
    }

    @Override
    protected int getPreviewMapLayoutIdCurrent() {
        return -1;
    }

    @Override
    public int getPreviewMapClientIdLast() {
        return -1;
    }

    @Override
    protected void setPreviewMapMode(int n) {
    }
}

