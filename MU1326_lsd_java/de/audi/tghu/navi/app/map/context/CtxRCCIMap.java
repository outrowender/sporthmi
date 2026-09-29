/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.context.CtxMultiRouteBase;
import de.audi.tghu.navi.app.map.context.CtxRCCIMap$1;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.map.dsi.ZoomHandler;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RgRouteCostChangeInformation;
import org.dsi.ifc.navigation.RouteSectionInfo;

public class CtxRCCIMap
extends CtxMultiRouteBase {
    public static final String DEFAULT_INCL_TRAFFIC_OFFSET;
    protected Timer screenSwitchDelayer;
    private static final int SCREEN_SWITCH_DELAY;

    public CtxRCCIMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
        this.setTimer();
    }

    @Override
    public void enter() {
        this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap = 1;
        this.getViews().getSemidynRGView().setSelectedDetour(1);
        super.enter();
        this.backupPOIVisibilityAndHideAllPOIs();
        this.naviMap.getNaviInterface().alternativeRoutesScreenEntered();
        Rect rect = this.getVisibleArea();
        int n = rect.kordX + rect.diffX / 2;
        int n2 = rect.kordY + rect.diffY / 2;
        this.setHotPoint(n, n2);
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#enter() - request large view size");
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().requestLargeViewSize(10);
        this.restartScreenSwitchDelayer();
        this.getViews().getSemidynRGView().focusRoute(1);
        this.getViews().getMainMapView().setOptionIconVisible(false);
        this.getMap().getNaviInterface().triggerUpdateRcci();
    }

    @Override
    protected int getMapMode() {
        return 7;
    }

    @Override
    public void exit() {
        super.exit();
        this.naviMap.getMVRequest().setVisibleRoutes(new NavSegmentID[0]);
        this.naviMap.getGuiInterface().hideToolTip();
        this.naviMap.getNaviInterface().getViewSizeChangeHandler().unrequestLargeViewSize(10);
        this.cancelScreenSwitchDelayer();
        this.getViews().getMainMapView().setOptionIconVisible(true);
    }

    @Override
    public void refreshSidebarData() {
        RgRouteCostChangeInformation rgRouteCostChangeInformation = this.getMap().getRouteCalculationHandler().getRgRCCI();
        if (rgRouteCostChangeInformation != null && rgRouteCostChangeInformation.getOldRoute() != null) {
            CalculatedRouteListElement[] calculatedRouteListElementArray = new CalculatedRouteListElement[rgRouteCostChangeInformation.getNewRoute() != null ? 2 : 1];
            calculatedRouteListElementArray[0] = rgRouteCostChangeInformation.getOldRoute();
            if (rgRouteCostChangeInformation.getNewRoute() != null) {
                calculatedRouteListElementArray[1] = rgRouteCostChangeInformation.getNewRoute();
            }
            if (calculatedRouteListElementArray != null && calculatedRouteListElementArray.length > 0) {
                this.naviMap.getGuiInterface().drawAlternativeRoutesSelectionUI(calculatedRouteListElementArray);
            }
        } else {
            this.getLogChannel().log(-2137614336, "CtxRCCIMap#refreshSidebarData: ignored - empty list!");
        }
    }

    @Override
    public void updateRgRouteCostChangeInformation(RgRouteCostChangeInformation rgRouteCostChangeInformation) {
        if (rgRouteCostChangeInformation.getNewRoute() != null && rgRouteCostChangeInformation.newRouteRecommended) {
            this.getLogChannel().log(-2137614336, "CtxRCCIMap#updateRgRouteCostChangeInformation() - has new route");
            this.refreshSidebarData();
            this.refreshRouteOptions();
        } else {
            this.getLogChannel().log(1078071040, "CtxRCCIMap#updateRgRouteCostChangeInformation() - new route does not exist any more");
            this.leaveContext();
        }
    }

    @Override
    public void rgStartGuidanceCalculatedRouteByUIDResult(NavSegmentID navSegmentID, int n) {
        super.rgStartGuidanceCalculatedRouteByUIDResult(navSegmentID, n);
        if (!this.naviMap.getMapDataContainer().isInMap) {
            this.getLogChannel().log(1078071040, "CtxRCCIMap#rgStartGuidanceCalculatedRouteByUIDResult(): not in map, switching to hidden context");
            this.naviMap.switchToContext(3);
        } else {
            this.getLogChannel().log(1078071040, "CtxRCCIMap#rgStartGuidanceCalculatedRouteByUIDResult(): switching to shown context");
            this.naviMap.switchToAShownContext();
        }
    }

    private void leaveContext() {
        this.getLogChannel().log(1078071040, "CtxRCCIMap#leaveContext() - trigger was : %1", (long)this.getMap().getMapDataContainer().sRcciEnterTrigger);
        switch (this.getMap().getMapDataContainer().sRcciEnterTrigger) {
            case 401399: {
                break;
            }
            default: {
                this.getGUI().fireModelEvent(1813906944);
            }
        }
        this.getMap().getRouteCalculationHandler().startRGByUID(0);
    }

    @Override
    protected void onHKBackClicked() {
        this.getLogChannel().log(1078071040, "CtxRCCIMap#onHKBackClicked()");
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap == 2) {
            this.getViews().getSemidynRGView().focusRoute(1);
            return;
        }
        this.leaveContext();
    }

    @Override
    protected void onHKSelectionClicked() {
        super.onHKSelectionClicked();
        this.getLogChannel().log(1078071040, "CtxRCCIMap#onHKSelectionClicked()");
        this.getMap().getRouteCalculationHandler().startRGByUID(0);
        this.getMap().switchToAShownContext();
        this.getMap().getNaviInterface().abortSDSSession();
    }

    @Override
    public void itemFocused(int n, int n2) {
        if (n2 == 0 || n2 == 1) {
            this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap = n2;
            super.itemFocused(n, n2);
        } else if (n2 == 2) {
            this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap = n2;
            this.refreshRouteOptions();
        } else {
            this.getLogChannel().log(10000, "CtxRCCIMap#itemFocused() - invalid index");
            return;
        }
        this.restartScreenSwitchDelayer();
    }

    private int getNumberOfDetours() {
        RouteSectionInfo[] routeSectionInfoArray = this.naviMap.getRouteCalculationHandler().getRgRCCI().getDetours();
        if (routeSectionInfoArray == null || routeSectionInfoArray.length == 0) {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#getNumberOfDetours() - detours: %1", (Object)routeSectionInfoArray);
            return 0;
        }
        return routeSectionInfoArray.length;
    }

    private RouteSectionInfo getSelectedDetour() {
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap != 2) {
            return null;
        }
        RouteSectionInfo[] routeSectionInfoArray = this.naviMap.getRouteCalculationHandler().getRgRCCI().getDetours();
        if (routeSectionInfoArray == null) {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#getSelectedDetour() - detours: %1", (Object)routeSectionInfoArray);
            return null;
        }
        int n = this.getViews().getSemidynRGView().getIndexOfSelectedDetour();
        if (n < 0 || n >= routeSectionInfoArray.length) {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#getSelectedDetour() - detours: %1, indexOfSelectedDetour: %2", (Object)routeSectionInfoArray, (long)n);
            return null;
        }
        return routeSectionInfoArray[n];
    }

    @Override
    public void refreshRouteOptions() {
        long l;
        RgRouteCostChangeInformation rgRouteCostChangeInformation = this.naviMap.getRouteCalculationHandler().getRgRCCI();
        long l2 = 0L;
        long l3 = 0L;
        if (rgRouteCostChangeInformation == null) {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#refreshRouteOptions() - no rcci");
            return;
        }
        CalculatedRouteListElement calculatedRouteListElement = rgRouteCostChangeInformation.getNewRoute();
        CalculatedRouteListElement calculatedRouteListElement2 = rgRouteCostChangeInformation.getOldRoute();
        long l4 = l2 = calculatedRouteListElement2.getEtaWithSpeedAndFlowStatus() == 2 ? -1L : calculatedRouteListElement2.getEtaWithSpeedAndFlow() - calculatedRouteListElement2.getEta();
        if (calculatedRouteListElement != null) {
            l3 = l2 < 0L || calculatedRouteListElement.getEtaWithSpeedAndFlowStatus() == 2 ? -1L : calculatedRouteListElement2.getEtaWithSpeedAndFlow() - calculatedRouteListElement.getEtaWithSpeedAndFlow();
        }
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#refreshRouteOptions() - delay: %1, saving: %2, selectedItem: %3", l2, l3, (long)this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap);
        RouteSectionInfo routeSectionInfo = this.getSelectedDetour();
        int n = this.getNumberOfDetours();
        this.getViews().getSemidynRGView().setNumberOfDetours(n);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        if (routeSectionInfo != null) {
            iMapRequest.viewFreeze(true);
            if (iMapRequest.getMVRequestControlActive().getMode() != 2) {
                iMapRequest.setMode(2);
            }
            if (calculatedRouteListElement != null && calculatedRouteListElement2 != null) {
                iMapRequest.setVisibleRoutes(new NavSegmentID[]{calculatedRouteListElement2.getSegmentIDList(), calculatedRouteListElement.getSegmentIDList()});
            }
            iMapRequest.rbSelectAlternativeRoute(Math.min(1, this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap));
            iMapRequest.setMapViewPortByWGS84Rectangle(routeSectionInfo.boundingRectangle, this.naviMap.getZoomHandler().getZoomListIndex(ZoomHandler.PREVIEWMAP_DEFAULT_ZOOMLEVEL));
            iMapRequest.viewFreeze(false);
            l = (long)this.naviMap.getNaviInterface().getRouteManager().getTripDataAuto().distanceToFinalDestination - routeSectionInfo.getStartDistanceToDestination();
        } else {
            if (iMapRequest.getMVRequestControlActive().getMode() != this.getMapMode()) {
                iMapRequest.viewFreeze(true);
                iMapRequest.setMode(this.getMapMode());
                iMapRequest.setVisibleRoutes(new NavSegmentID[0]);
                iMapRequest.rbSelectAlternativeRoute(Math.min(1, this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap));
                iMapRequest.viewFreeze(false);
            }
            l = -1L;
        }
        this.getViews().getSemidynRGView().showSDRSTooltip(l2, l3, this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap, n, this.getViews().getSemidynRGView().getSelectedDetour(), l);
    }

    public int getRgRouteCalculationState() {
        return 2;
    }

    @Override
    protected void onDDSClicked() {
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap == 2) {
            return;
        }
        super.onDDSClicked();
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#onDDSClicked()");
        this.env.getListModel(1125910016).fireEvent(0);
        this.onRouteSelected(this.getMap().getRouteCalculationHandler().getSelectedRouteIndex());
    }

    @Override
    protected void onRouteSelected(int n) {
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#onRouteSelected( %1 )", (long)n);
        this.getMap().getRouteCalculationHandler().startRGByUID(n);
    }

    @Override
    public void viewSizeChanged(int n) {
        if (n == 1) {
            this.getLogChannel().log(-2137614336, "CtxRCCIMap#viewSizeChanged( small )");
            this.leaveContext();
        }
        super.viewSizeChanged(n);
    }

    @Override
    protected void restartScreenSwitchDelayer() {
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#restartScreenSwitchDelayer()");
        this.screenSwitchDelayer.restart();
    }

    @Override
    protected void cancelScreenSwitchDelayer() {
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#cancelScreenSwitchDelayer()");
        this.screenSwitchDelayer.cancel();
    }

    protected void setTimer() {
        this.screenSwitchDelayer = new Timer("ScreenSwitchDelayer", 0, true, new CtxRCCIMap$1(this));
    }

    @Override
    public void increment(int n, int n2) {
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#increment() - modelID: %1, steps: %2", (long)n, (long)n2);
        if (n == -752679424) {
            this.getViews().getSemidynRGView().incrementSelectedDetour(n2);
            this.refreshRouteOptions();
        } else {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#increment() - unknown model ID: %1", (long)n);
        }
        this.restartScreenSwitchDelayer();
    }

    @Override
    public void touchPadPositionMoved(int n, int n2, int n3, int n4, int n5) {
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap != 2) {
            return;
        }
        if (this.container.sScrollByCrossHairsEnabled) {
            this.container.sScrollByCrossHairsEnabled = false;
            this.naviMap.getMVRequest().setScrollByCrossHairs(false);
        }
        if (this.container.sJoystickIdle) {
            this.getLogChannel().log(1078071040, "CtxRCCIMap#touchPadPositionMoved() - start scrolling");
            this.container.sJoystickIdle = false;
        }
        this.naviMap.getMVRequest().dragMap((short)n4, (short)n5);
        this.restartScreenSwitchDelayer();
    }

    @Override
    public void joystick(int n, int n2) {
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap != 2) {
            return;
        }
        if (n != 404817408) {
            this.getLogChannel().log(-2137614336, "CtxRCCIMap#joystick( modelID = %1, dir = %2 )", (long)n, (long)n2);
        }
        if (n2 >= 0 && !this.getSDSDialogActive()) {
            this.scrollMapStart(n2);
        } else {
            this.scrollMapStop(n != 0);
        }
    }

    protected void scrollMapStart(int n) {
        this.getLogChannel().log(-1601830656, "CtxRCCIMap#scrollMapStart( %1 )", (long)n);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        if (n < 0 || n > 359) {
            this.getLogChannel().log(-1601830656, "CtxRCCIMap#scrollMapStart() - Invalid direction: %1", (long)n);
            return;
        }
        this.cancelScreenSwitchDelayer();
        iMapRequest.startScrollToDirection(n);
        this.container.sScrollToDirectionActive = true;
        this.container.sJoystickIdle = false;
        this.container.sMapScrollDir = n;
    }

    protected void scrollMapStop(boolean bl) {
        this.getLogChannel().log(-2137614336, "CtxRCCIMap#scrollMapStop( %1 )", bl);
        if (!this.container.sJoystickIdle) {
            IMapRequest iMapRequest = this.naviMap.getMVRequest();
            iMapRequest.stopScrollToDirection();
            this.container.sScrollToDirectionActive = false;
        }
        this.container.sJoystickIdle = true;
        this.container.sMapScrollDir = -1;
        this.restartScreenSwitchDelayer();
    }

    @Override
    public void touchScreenPinch(int n, float f2, int n2, int n3) {
        if (this.naviMap.getMapDataContainer().selectedItemCtxRCCIMap != 2) {
            return;
        }
        this.getZoomHandler().pinchZoom(f2);
    }

    static /* synthetic */ LogChannel access$000(CtxRCCIMap ctxRCCIMap) {
        return ctxRCCIMap.getLogChannel();
    }

    static /* synthetic */ void access$100(CtxRCCIMap ctxRCCIMap) {
        ctxRCCIMap.leaveContext();
    }
}

