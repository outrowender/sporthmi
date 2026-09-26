/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public class CtxPositionMap
extends CtxShown {
    protected boolean isUserZoomRequested = false;

    public CtxPositionMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    @Override
    public void enter() {
        super.enter();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.switchToNormalSidebar();
        int n = gUIInterface.getSidebarState();
        if (n != 3) {
            gUIInterface.closeSidebarWithoutAnimation();
        }
        this.requestPreferredViewType();
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        iMapRequest.setMode(1);
        this.initZoomLevel();
        this.initAdditionalInfos();
        this.getLogChannel().log(-2137614336, "CtxPositionMap#enter() - getSetupMapType() = %2, getRGActive() = %1", this.naviMap.getActiveContext().getRGActive(), (long)this.getSetupMapType());
        if (this.getSetupMapType() == 3 && !this.naviMap.getActiveContext().getRGActive()) {
            gUIInterface.enableOrientation(false);
        }
        this.container.sFocusedPosition = this.getMap().getNaviInterface().getVehicle().getVehicleLocation();
    }

    @Override
    public void exit() {
        super.exit();
        this.getLogChannel().log(-2137614336, "CtxPositionMap#exit() - userZoomLevel = %1m", (Object)Float.toString(this.container.fUserZoomLevel));
        this.automaticOrientateMap();
    }

    @Override
    public void enterEpilogue() {
        AbstractMap abstractMap = this.naviMap;
        if (abstractMap.getActiveContextIndex() != 7 && abstractMap.getActiveContextIndex() != 8) {
            this.showMap(true);
            this.unfreezeMap();
        }
    }

    @Override
    public void initAdditionalInfos() {
        super.initAdditionalInfos();
        this.initOrientationAndHotPoint();
    }

    private void initZoomLevel() {
        int n = this.naviMap.getActiveContextIndex();
        int n2 = this.naviMap.getOldActiveContextIndex();
        if (this.container.fUserZoomLevel < 0.0f) {
            try {
                this.container.fUserZoomLevel = this.getZoomHandler().getZoomList()[this.getSetup().getSavedZoomListIndex()] / 51266;
                this.getLogChannel().log(-2137614336, "CtxPositionMap#initZoomLevel() - use saved zoom : %1m", (double)this.container.fUserZoomLevel);
            }
            catch (Exception exception) {
                this.container.fUserZoomLevel = 61505;
                this.getLogChannel().log(-2137614336, "CtxPositionMap#initZoomLevel() - use preseted zoom : %1m", (double)this.container.fUserZoomLevel);
            }
        }
        this.getLogChannel().log(-2137614336, "CtxPositionMap#initZoomLevel() - Ctx[%2] -> Ctx[%3], savedZoomLevel = %1", (Object)Float.toString(this.container.fUserZoomLevel), (long)n2, (long)n);
        if (n != 7 && n != 8 && n2 != 10 && n2 != 22) {
            if (this.container.fUserZoomLevel > 0.0f) {
                this.getZoomHandler().setZoomLevel(this.container.fUserZoomLevel);
            } else {
                this.getZoomHandler().setZoom(this.getSetup().getSavedZoomListIndex());
            }
        }
    }

    @Override
    public void onChangedOrientation(int n) {
        super.onChangedOrientation(n);
        this.initOrientationAndHotPoint();
    }

    protected void initOrientationAndHotPoint() {
        this.enableDisableOrientation();
        this.automaticOrientateMap();
    }

    @Override
    public void updateMapOrientation(int n) {
        super.updateMapOrientation(n);
        if (n != 2 && this.naviMap.getSetup().getMapRepresentation() != 3 && this.naviMap.getMVResponseControl().getZoomListIndex() < this.retrieveZoomListIndex(5292871)) {
            this.centerCarPositionLowerPart();
        } else {
            this.adjustCarPosition();
        }
    }

    @Override
    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (this.getRouteActiveOrRangeMapReady() && this.getSetupMapType() == 3) {
            this.naviMap.switchToContext(10);
            return;
        }
        this.initOrientationAndHotPoint();
    }

    @Override
    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (this.getRouteActiveOrRangeMapReady() && this.getSetupMapType() == 3) {
            this.naviMap.switchToContext(10);
            return;
        }
        this.initOrientationAndHotPoint();
    }

    @Override
    public void updateMobilityHorizonStatus(int n) {
        super.updateMobilityHorizonStatus(n);
        if (this.getRouteActiveOrRangeMapReady() && this.getSetupMapType() == 3) {
            this.naviMap.switchToContext(10);
        }
    }

    @Override
    public void updateZoomListIndex(int n) {
        super.updateZoomListIndex(n);
        if (this.getCID() != 8 && this.getCID() != 7) {
            this.getSetup().setSavedZoomListIndex(n, true);
        }
        this.automaticOrientateMap();
    }

    @Override
    public void updateManoeuvreViewActive(int n) {
        super.updateManoeuvreViewActive(n);
        this.getLogChannel().log(-2137614336, "CtxPositionMap#updateManoeuvreViewActive( %1 )", (long)n);
        this.automaticOrientateMap();
    }

    protected boolean calculateAutomaticOrientation() {
        int n = this.getSetupMapType();
        if (n == 2) {
            return false;
        }
        if (n == 0 || n == 3) {
            return true;
        }
        return this.getSetupOrientation() == 0;
    }

    protected boolean calculateHardOrientation() {
        return this.getZoomHandler().getZoom() >= this.container.sOrientationThresholdPM;
    }

    protected void centerHotPointAndOrientateMap(boolean bl) {
        if (bl) {
            this.centerCarPosition();
            this.naviMap.getMVRequest().setOrientation(2);
        } else {
            if (this.naviMap.getSetup().getMapRepresentation() != 3) {
                this.centerCarPositionLowerPart();
            } else {
                this.centerCarPosition();
            }
            this.naviMap.getMVRequest().setOrientation(0);
        }
    }

    @Override
    public void automaticOrientateMap() {
        boolean bl = this.calculateAutomaticOrientation() || this.calculateHardOrientation();
        this.centerHotPointAndOrientateMap(bl);
    }

    @Override
    protected void sdsChangedZoom() {
        super.sdsChangedZoom();
        this.naviMap.restartOverviewMapTimer();
    }

    @Override
    public void sdsChangedMapType() {
        super.sdsChangedMapType();
        AbstractMap abstractMap = this.naviMap;
        if (abstractMap.getActiveContextIndex() != 7 && abstractMap.getActiveContextIndex() != 8 && abstractMap.getOldActiveContextIndex() == 10) {
            this.initZoomLevel();
        }
    }

    @Override
    public void increment(int n, int n2) {
        super.increment(n, n2);
        this.isUserZoomRequested = true;
        this.naviMap.restartOverviewMapTimer();
    }

    @Override
    public void incrementGesture(int n) {
        super.incrementGesture(n);
        this.container.fUserZoomLevel = n / 100;
        this.getSetup().setSavedZoomListIndex(this.getZoomHandler().getZoomListIndex(this.container.fUserZoomLevel), true);
    }

    @Override
    public void keyTyped(int n, int n2) {
        super.keyTyped(n, n2);
        this.naviMap.restartOverviewMapTimer();
    }

    @Override
    public boolean supportsAdditionalInfo() {
        return true;
    }

    @Override
    protected void onDDSClicked() {
        this.getMap().switchToContext(12);
    }

    protected void centerCarPositionLowerPart() {
        this.getLogChannel().log(-2137614336, "CtxPositionMap#centerCarPositionLowerPart()");
        int n = 0;
        Rect rect = this.getVisibleArea();
        int n2 = Util.isClusterMapFPK(this.env.getFramework()) ? this.getGUI().getLayout().getMapOffsetTop() : 0;
        n = this.getSetupMapType() == 2 ? rect.kordY + (int)(1365985855 * (float)(rect.diffY + n2)) + 1 : rect.kordY + (int)(-512080833 * (float)(rect.diffY + n2)) + 1;
        if (Util.isClusterMMI(this.env.getFramework())) {
            n += 24;
        }
        this.setCarPosition(rect.kordX + (rect.diffX >> 1), n);
    }

    @Override
    public void setRangeMapDefaultZoomLevel() {
        super.setRangeMapDefaultZoomLevel();
        if (Util.isRangeMapDisplayPresent(this.env.getFramework()) && this.naviMap.isMapMain() && this.naviMap.getSetup().getMapRepresentation() == 3) {
            this.getLogChannel().log(14808325, "CtxPositionMap#setRangeMapDefaultZoomLevel()");
            this.getZoomHandler().setZoomLevel(6318662);
        }
    }

    @Override
    protected void onHKBackClicked() {
        if (this.getMap().getOldActiveContextIndex() == 10) {
            this.getLogChannel().log(-2137614336, "CtxPositionMap#onHKBackClicked() - switch back to overview map");
            this.getMap().switchToContext(10);
        } else {
            super.onHKBackClicked();
        }
    }

    @Override
    protected void hideBetterRoutePopup() {
        this.getGUI().hidePopupBetterRouteAvailable();
    }
}

