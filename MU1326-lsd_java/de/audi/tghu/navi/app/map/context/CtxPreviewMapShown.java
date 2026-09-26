/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CTags$HasZoomArea;
import de.audi.tghu.navi.app.map.context.CtxShownReduced;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.Point;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.ViewPort;

public class CtxPreviewMapShown
extends CtxShownReduced
implements CTags$HasZoomArea {
    protected Rect mVisibleArea = null;

    public CtxPreviewMapShown(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enterPrologue() {
        super.enterPrologue();
    }

    @Override
    public void enterEpilogue() {
        super.enterEpilogue();
    }

    @Override
    public void enter() {
        this.doEnter();
    }

    private void doEnter() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework())) {
            this.switchMobilityHorizonAccordingToSetup();
        }
        this.naviMap.cancelOverviewMapTimer();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        boolean bl = this.calculateMapColorAccordingToSetup();
        if (bl) {
            iMapRequest.setDayView();
        } else {
            iMapRequest.setNightView();
        }
        iMapRequest.setViewType(0);
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        int n = this.container.sPreviewMapWidth;
        int n2 = this.container.sPreviewMapHeight;
        if (this.container.sPreviewMapWidth <= 0 || this.container.sPreviewMapHeight <= 0) {
            n = gUIInterface.getScreenWidthPreviewMap();
            n2 = gUIInterface.getScreenHeightPreviewMap();
        }
        Rect rect = this.getVisibleArea();
        Rect rect2 = new Rect(0, 0, n, n2);
        int n3 = (rect.diffX >> 1) + rect.kordX;
        int n4 = (rect.diffY >> 1) + rect.kordY;
        iMapRequest.setViewPortBorder(1);
        this.getZoomHandler().setZoomAreaWithGridMask(rect, rect2);
        this.setHotPoint(n3, n4);
        iMapRequest.setCarPosition(new Point(n3, n4));
        iMapRequest.showTMCMessages(false);
        iMapRequest.setGeneralPoiVisibility(false);
        iMapRequest.setOrientation(2);
        iMapRequest.setCityModelMode(0);
        iMapRequest.setLandmarksVisible(false);
        iMapRequest.setPictureNavigationIconVisibility(this.getSetupPicNavIcons(), -1);
        iMapRequest.setWeatherVisualization(false);
        iMapRequest.setEnableSoftZoom(false);
        iMapRequest.setEnableSoftRotation(false);
        iMapRequest.setEnableSoftTilt(false);
        iMapRequest.setEnableSoftJump(false);
        this.getMapFlagHandler().refresh(true, false);
    }

    @Override
    public void exit() {
        super.exit();
    }

    @Override
    public void updateViewFreeze(boolean bl) {
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
    }

    @Override
    public void updateZoomList(float[] fArray, int n, float[] fArray2) {
        this.getLogChannel().log(-2137614336, "CtxPreviewMapShown#updateZoomList() - zoomList.length: %1, zoomListBefore.length: %2, zoomListIndex: %3", (long)(fArray != null ? fArray.length : 0), (long)(fArray2 != null ? fArray2.length : 0), (long)n);
        super.updateZoomList(fArray, n, fArray2);
        this.getMap().getMapManager().getPreviewMapHandler().refreshLastRequestedState(3);
    }

    @Override
    public void updateViewPort(ViewPort viewPort) {
    }

    @Override
    public void updateCurrentViewType(int n) {
    }

    @Override
    public void updateViewVisible(boolean bl) {
    }

    @Override
    public void updateMapMode(int n) {
    }

    @Override
    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
    }

    @Override
    public void updateMapOrientation(int n) {
    }

    @Override
    public void updateCarPosition(Point point) {
    }

    @Override
    public void updateTmcVisible(boolean bl) {
    }

    @Override
    public Rect getVisibleArea() {
        GUIInterface gUIInterface = this.getMap().getGuiInterface();
        int n = gUIInterface.getVisibleOffsetXPreviewMap();
        int n2 = gUIInterface.getVisibleOffsetYPreviewMap();
        int n3 = gUIInterface.getVisibleWidthPreviewMap();
        int n4 = gUIInterface.getVisibleHeightPreviewMap();
        this.mVisibleArea = new Rect(n, n2, n3, n4);
        return this.mVisibleArea;
    }

    @Override
    protected void switchMobilityHorizonAccordingToSetup() {
        if (Util.isRangeMapDisplayPresent(this.env.getFramework())) {
            this.naviMap.getMVRequest().setMobilityHorizonVisibility(false);
        }
    }
}

