/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxCrosshairMap;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.utils.MapEnv;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.PosPosition;
import org.dsi.ifc.navigation.RouteDestination;

public class CtxRubberBand
extends CtxCrosshairMap {
    protected static final boolean SHOW_SPECIAL_MARKER;
    protected static final boolean SET_MARKER_AT_MIDDLE;
    public static final int DS_NOT_DRAGGED;
    public static final int DS_DRAGGING;
    public static final int DS_DRAG_FINISHED;
    protected int sDragState = 0;
    private NavLocationWgs84 lastDragRoutePosition = null;
    private boolean canSetRubberbandPoint = true;
    protected NavLocationWgs84 sentRubberbandPoint = null;
    protected final Object waitingForRubberBandMutex = new Object();
    protected boolean waitingForRubberBandPointUpdate;
    protected boolean refreshDragPointPending;
    public static final int MARKER_SIZE_X;
    public static final int MARKER_SIZE_Y;
    public static final int MARKER_HOTPOINT_X;
    public static final int MARKER_HOTPOINT_Y;

    public CtxRubberBand(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        this.getLogChannel().log(-2137614336, "CtxRubberBand#enter() - delete trigger : %1", (long)this.getMap().getShowTrigger(true));
        this.getLogChannel().log(1078071040, "CtxRubberBand#enter() - state : %1", (long)this.getRbbState());
        this.waitingForRubberBandPointUpdate = false;
        this.refreshDragPointPending = true;
        IMapRequest iMapRequest = this.getMap().getMVRequest();
        if (!MapEnv.enableSoftAnimationForRubberband) {
            iMapRequest.setEnableSoftJump(false);
            iMapRequest.setEnableSoftRotation(false);
            iMapRequest.setEnableSoftTilt(false);
            iMapRequest.setEnableSoftZoom(false);
            iMapRequest.setEnableSoftZoomConditional(false);
        }
        iMapRequest.setMode(2);
        iMapRequest.rbSelectAlternativeRoute(0);
        iMapRequest.setRotation((short)0);
        iMapRequest.setOrientation(2);
        iMapRequest.setViewType(0);
        this.backupPOIVisibilityAndHideAllPOIs();
        if (this.getMap().getMapDataContainer().rubberbandViewPort != null) {
            this.setViewPort(this.getMap().getMapDataContainer().rubberbandViewPort);
            this.showMarker();
        } else {
            PosPosition posPosition = this.getMap().getNaviInterface().getVehicle().getPosition();
            NavLocation navLocation = Util.getLocationFromGeoPos(posPosition.longitude, posPosition.latitude);
            NavLocation navLocation2 = null;
            RouteDestination[] routeDestinationArray = this.getMap().getNaviInterface().getRoute().getRoutelist();
            for (int i2 = 0; i2 < routeDestinationArray.length; ++i2) {
                if (routeDestinationArray[i2].destinationType != 1) continue;
                navLocation2 = routeDestinationArray[i2].routeLocation;
                break;
            }
            if (navLocation2 != null && navLocation2.isPositionValid()) {
                iMapRequest.setMapViewportByLD(navLocation, navLocation2, 0);
            }
            this.getViews().getRubberbandView().update(-1, -1L, -1, -1L);
            this.hideMarker();
        }
        if (this.getRouteCalcHandler().isCalculatingRubberband()) {
            this.env.getButtonModel(-115276288).setStatus(0);
        } else if (this.getRouteCalcHandler().isRubberbandReady()) {
            this.env.getButtonModel(-115276288).setStatus(1);
        } else {
            this.sDragState = 0;
            this.canSetRubberbandPoint = true;
            this.sentRubberbandPoint = null;
            this.env.getButtonModel(-115276288).setStatus(0);
            this.prepareRubberband();
        }
        this.naviMap.clearForcedCrosshairCtx();
    }

    protected int getRbbState() {
        return this.getRouteCalcHandler().getRubberbandState();
    }

    protected void prepareRubberband() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#prepareRubberband()");
        this.getRouteCalcHandler().prepareRubberband(false, (int)this.getMap().getNaviInterface().getRoute().getIndexOfCurrentDestination());
    }

    @Override
    public void exit() {
        this.waitingForRubberBandPointUpdate = false;
        this.refreshDragPointPending = false;
        this.sDragState = 0;
        super.exit();
        this.getLogChannel().log(-2137614336, "CtxRubberBand#exit() - state : %1", (long)this.getRbbState());
        if (this.getRbbState() == 7 || this.getRbbState() == 8) {
            this.getMap().getMapDataContainer().enterRbbFromRightDrawer = false;
        } else {
            this.getLogChannel().log(1078071040, "CtxRubberBand#exit() - user has not confirmed or canceled explicitly. isInMap=%1", this.getMap().getMapDataContainer().isInMap);
            if (this.getRouteCalcHandler().isBaseRouteReconstructable()) {
                this.getMap().clearShowTrigger();
                this.getMap().switchToContext(33);
            }
            this.getRouteCalcHandler().cancel();
        }
        this.getMap().getMVRequest().rbSelectAlternativeRoute(-1);
        this.hideMarker();
        this.getGUI().setTopBarVisible(false);
    }

    @Override
    protected void onDDSClicked() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#onDDSClicked() - state:%1", (long)this.getRbbState());
        switch (this.getRbbState()) {
            case 4: 
            case 5: 
            case 6: {
                this.getGUI().fireModelEvent(-115276288);
                this.finishRubberband();
                this.getMap().switchToAShownContext();
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onDDSClicked() - Done");
                break;
            }
            default: {
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onDDSClicked() - ignore", (long)this.getRbbState());
            }
        }
    }

    protected void leaveRubberband() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#leaveRubberband()");
        this.getMap().getMapDataContainer().enterRbbFromRightDrawer = false;
        if (this.getRouteCalcHandler().isBaseRouteReconstructable()) {
            this.getMap().clearShowTrigger();
            this.getMap().switchToContext(33);
            this.cancelRubberband();
        } else {
            this.getMap().switchToAShownContext();
        }
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#onHKBackClicked()");
        this.checkAndFireBackEvent();
        this.leaveRubberband();
    }

    public void checkAndFireBackEvent() {
        if (this.getMap().getMapDataContainer().enterRbbFromRightDrawer) {
            this.getGUI().fireHKBackEvent();
            this.getMap().getMapDataContainer().enterRbbFromRightDrawer = false;
        }
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        if (this.getLogChannel().isDebug2()) {
            this.getLogChannel().log(14808325, "CtxRubberBand#touchPadPositionMoved()");
        }
        int n6 = n2;
        n2 = 0;
        if (this.getRbbState() == 3 || this.getRbbState() == 4) {
            this.sDragState = 1;
            if (n6 == 1) {
                this.naviMap.getMVRequest().dragRoute((short)(n2 - n4), (short)(n3 - n5));
            } else {
                this.naviMap.getMVRequest().dragRoute((short)(n4 - n2), (short)(n5 - n3));
            }
        } else {
            this.getLogChannel().log(-2137614336, "CtxRubberBand#touchPadPositionMoved() - rbbState = %1, ignored", (long)this.getRbbState());
        }
    }

    protected void setRubberbandPoint(NavLocationWgs84 navLocationWgs84) {
        if (navLocationWgs84 == null) {
            this.getLogChannel().log(-1601830656, "CtxRubberBand#setRubberbandPosition( null )");
            return;
        }
        if (!this.canSetRubberbandPoint) {
            this.getLogChannel().log(-1601830656, "CtxRubberBand#setRubberbandPosition() - canSetRubberbandPoint = false");
            return;
        }
        if (MapUtils.almostEquals(navLocationWgs84, this.sentRubberbandPoint)) {
            this.getLogChannel().log(-2137614336, "CtxRubberBand#setRubberbandPosition() - almost the same, %1, %2", (Object)navLocationWgs84, (Object)this.sentRubberbandPoint);
            return;
        }
        this.getLogChannel().log(1078071040, "CtxRubberBand#setRubberbandPosition() - setRubberbandPosition : %1", (Object)navLocationWgs84);
        this.sentRubberbandPoint = navLocationWgs84;
        this.getRouteCalcHandler().setRubberbandPoint(navLocationWgs84);
    }

    protected void afterRubberbandStarted() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#afterRubberbandStarted()");
        this.env.getButtonModel(-115276288).setStatus(1);
    }

    public void finishRubberband() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#finishRubberband()");
        this.getMap().getMVRequest().setDragRouteMarker(0);
        this.getRouteCalcHandler().startRubberbandRG();
    }

    public void cancelRubberband() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#cancelRubberband( )");
        this.getMap().getMVRequest().setDragRouteMarker(0);
        this.getRouteCalcHandler().cancel();
    }

    @Override
    public void updateDragRoutePosition(NavLocationWgs84 navLocationWgs84) {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#updateDragRoutePosition( %1 )", (Object)navLocationWgs84);
        super.updateDragRoutePosition(navLocationWgs84);
        this.lastDragRoutePosition = navLocationWgs84;
        if (this.sDragState != 0) {
            this.setRubberbandPoint(this.lastDragRoutePosition);
        } else {
            this.getLogChannel().log(1078071040, "CtxRubberBand#updateDragRoutePosition() - ignore the first call");
        }
    }

    protected void refreshDragPoint() {
        NavLocationWgs84 navLocationWgs84 = this.getRouteCalcHandler().getRubberbandPoint();
        this.getLogChannel().log(-2137614336, "CtxRubberBand#refreshDragPoint() - %1", (Object)navLocationWgs84);
        if (navLocationWgs84 != null) {
            this.getMap().getMVRequest().startRouteDragging(navLocationWgs84);
        }
    }

    @Override
    protected void requestInfoForPosition(boolean bl) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void scrollMapStop(boolean bl) {
        super.scrollMapStop(false);
        if (this.sDragState == 0) {
            return;
        }
        this.getLogChannel().log(1078071040, "CtxRubberBand#scrollMapStop( %1 ) - finger leaves, adjust pointer", bl);
        this.sDragState = 2;
        Object object = this.waitingForRubberBandMutex;
        synchronized (object) {
            this.getLogChannel().log(-2137614336, "CtxRubberBand#scrollMapStop - waiting for rubberband point update, waitingForRubberBandPointUpdate:(%1)", this.waitingForRubberBandPointUpdate);
            if (this.waitingForRubberBandPointUpdate) {
                this.refreshDragPointPending = true;
            } else {
                this.refreshDragPoint();
            }
        }
    }

    @Override
    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        if (calculatedRouteListElementArray == null || calculatedRouteListElementArray.length == 0) {
            this.getLogChannel().log(-2137614336, "CtxRubberBand#updateRgCalculatedRoutes() - empty");
            return;
        }
        if (!MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[0])) {
            this.getLogChannel().log(14808325, "CtxRubberBand#updateRgCalculatedRoutes() - %1", (Object)calculatedRouteListElementArray[0]);
            return;
        }
        this.getLogChannel().log(1078071040, "CtxRubberBand#updateRgCalculatedRoutes() - %1", (Object)calculatedRouteListElementArray[0]);
        if (!this.canSetRubberbandPoint) {
            this.canSetRubberbandPoint = true;
            this.setRubberbandPoint(this.lastDragRoutePosition);
        }
        if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0 && MapUtils.isCRLElementCalculated(calculatedRouteListElementArray[0])) {
            if (this.sDragState == 0) {
                this.getViews().getRubberbandView().update((int)calculatedRouteListElementArray[0].distance / 1000, calculatedRouteListElementArray[0].etaWithSpeedAndFlow, (int)calculatedRouteListElementArray[0].distance / 1000, calculatedRouteListElementArray[0].etaWithSpeedAndFlow);
            } else {
                this.getViews().getRubberbandView().updateDraggedRoute((int)calculatedRouteListElementArray[0].distance / 1000, calculatedRouteListElementArray[0].etaWithSpeedAndFlow);
            }
        }
    }

    @Override
    public void incrementGesture(int n) {
    }

    protected int getRubberBandBaseList() {
        return -1256258048;
    }

    protected void setViewPort(NavRectangle navRectangle) {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#setViewPort() - %1", (Object)navRectangle);
        IMapRequest iMapRequest = this.getMap().getMVRequest();
        iMapRequest.viewFreeze(true);
        iMapRequest.setMapViewPortByWGS84Rectangle(navRectangle, -1);
        iMapRequest.viewFreeze(false);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onEvent(int n, Object object) {
        switch (n) {
            case 204: {
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onEvent( %1 ) - rubberband is prepared", (long)n);
                this.setViewPort(this.getMap().getMapDataContainer().rubberbandViewPort);
                break;
            }
            case 205: {
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onEvent( %1 ) - rubberband is starting", (long)n);
                this.getMap().getMVRequest().startRouteDragging(this.getRouteCalcHandler().getRubberbandPoint());
                this.showMarker();
                break;
            }
            case 206: {
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onEvent( %1 ) - rubberband is ready", (long)n);
                this.afterRubberbandStarted();
                break;
            }
            case 210: {
                Object object2 = this.waitingForRubberBandMutex;
                synchronized (object2) {
                    this.waitingForRubberBandPointUpdate = true;
                    break;
                }
            }
            case 208: 
            case 209: {
                this.getLogChannel().log(-2137614336, "CtxRubberBand#onEvent(%1), refreshDragPointPending: (%2), sDragState:(%3)- rubberband point changed or timeout while waiting for update", (Object)Integer.toString(n), (Object)Boolean.toString(this.refreshDragPointPending), (Object)Integer.toString(this.sDragState));
                Object object3 = this.waitingForRubberBandMutex;
                synchronized (object3) {
                    this.waitingForRubberBandPointUpdate = false;
                    if (this.sDragState == 2 && this.getRbbState() == 4) {
                        this.refreshDragPointPending = false;
                        this.refreshDragPoint();
                    }
                    break;
                }
            }
            default: {
                this.getLogChannel().log(-1601830656, "CtxRubberBand#onEvent() - unknown evtId:%1", (long)n);
            }
        }
    }

    private void showMarker() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#showMarker()");
        this.getMap().getMVRequest().setDragRouteMarker(1);
    }

    private void hideMarker() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#hideMarker()");
        this.getMap().getMVRequest().setDragRouteMarker(0);
    }

    @Override
    public void enterMapScreen(int n) {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#enterMapScreen( %1 ) - ignore", (long)n);
    }

    @Override
    public void setSDSDialogActive(boolean bl) {
        boolean bl2 = this.getSDSDialogActive();
        this.getLogChannel().log(-2137614336, "CtxRubberBand#setSDSDialogActive() - active: %1, wasActive: %2 ", bl, bl2);
        super.setSDSDialogActive(bl);
        if (!bl2 && bl) {
            this.naviMap.switchToAShownContext();
        }
    }

    @Override
    protected void onHKSelectionClicked() {
        this.getLogChannel().log(-2137614336, "CtxRubberBand#onHKSelectionClicked()");
        this.leaveRubberband();
    }

    @Override
    protected void updateCrossHairsBoundingBox() {
        Rect rect = this.getVisibleArea();
        rect.kordX += 10;
        rect.kordY += 10;
        rect.diffX -= 40;
        rect.diffY -= 40;
        this.naviMap.getMVRequest().setScrollByCrossHairsBoundingBox(rect);
    }
}

