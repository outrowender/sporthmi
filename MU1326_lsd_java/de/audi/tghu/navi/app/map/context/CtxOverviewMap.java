/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.GUIInterface;
import de.audi.tghu.navi.app.map.IsViewSizeDepended;
import de.audi.tghu.navi.app.map.context.CtxShown;
import de.audi.tghu.navi.app.map.dsi.IMapRequest;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.map.Rect;

public class CtxOverviewMap
extends CtxShown
implements IsViewSizeDepended {
    public CtxOverviewMap(NavigationEnv navigationEnv, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public synchronized void cleanup() {
        super.cleanup();
    }

    public void enter() {
        super.enter();
        GUIInterface gUIInterface = this.naviMap.getGuiInterface();
        gUIInterface.switchToNormalSidebar();
        int n = gUIInterface.getSidebarState();
        if (n != 3) {
            gUIInterface.closeSidebarWithoutAnimation();
        }
        gUIInterface.enableOrientation(false);
        IMapRequest iMapRequest = this.naviMap.getMVRequest();
        Rect rect = this.getVisibleArea();
        int n2 = rect.kordX + (rect.diffX >> 1);
        int n3 = rect.kordY + (rect.diffY >> 1);
        this.setHotPoint(n2, n3);
        iMapRequest.setViewType(0);
        iMapRequest.setOrientation(2);
        if (this.getRGActive() || this.getMap().getRouteCalculationHandler().isRouteCalculationNotIdle()) {
            iMapRequest.setMode(0);
        } else if (this.isRangeMapReadyToShow()) {
            iMapRequest.setMobilityHorizonZoomMode(1);
            iMapRequest.setMode(14);
        } else {
            this.getLogChannel().log(100000, "CtxOverviewMap#enter - neither RG is active nor range map ready!");
        }
        this.initAdditionalInfos();
        if (this.getRGActive()) {
            this.setAutoZoomIcon(true);
        }
        AbstractMap abstractMap = this.naviMap;
        int n4 = this.getZoomEngineState();
        int n5 = this.getSetupAutoZoom();
        this.getLogChannel().log(100000000, "CtxOverviewMap#enter - sManoeuvreZoomDisabledWithReturn( %1 )", this.container.sManoeuvreZoomDisabledWithReturn);
        this.getLogChannel().log(100000000, "CtxOverviewMap#enter - ZoomEngineState( %1 ), SetupAutoZoom( %2 )", (long)n4, (long)n5);
        if (!(this.container.sManoeuvreZoomDisabledWithReturn || n4 != 3 || n5 != 1 && n5 != 0 || Util.isPorscheGen2(this.env.getFramework()))) {
            abstractMap.setSwitchBackToContext(10);
            abstractMap.switchToContext(8);
        }
        this.container.sForceRestoreUserZoomLevel = false;
        this.refreshCarPositionForZoomEngine();
    }

    public void exit() {
        super.exit();
        this.refreshAutoZoomIcon();
        this.setSoftZoom(false);
    }

    private void refreshAutoZoomIcon() {
        int n = this.naviMap.getActiveContextIndex();
        if (n == 7 && (this.getSetupAutoZoom() != 0 || this.getZoomEngineState() != 2 || this.container.sAutozoomTemporarilyDisabled)) {
            this.setAutoZoomIcon(false);
        } else if (n == 8 && (this.getSetupAutoZoom() != 1 || this.getZoomEngineState() != 3 || this.container.sManoeuvreZoomDisabledWithReturn)) {
            this.setAutoZoomIcon(false);
        } else if (n != 10) {
            this.setAutoZoomIcon(false);
        }
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        this.setAutoZoomIcon(bl);
        if (!this.getRouteActiveOrRangeMapReady()) {
            this.naviMap.switchToContext(7);
        } else {
            this.naviMap.forceShownContextRefresh();
        }
    }

    public void updateRgRouteCalculationState(int n) {
        super.updateRgRouteCalculationState(n);
        if (!this.getRouteActiveOrRangeMapReady()) {
            this.naviMap.switchToContext(7);
        } else {
            this.naviMap.forceShownContextRefresh();
        }
    }

    public void initAdditionalInfos() {
        super.initAdditionalInfos();
        this.setVisibleArea();
        this.centerCarPosition();
    }

    public void updateManoeuvreViewActive(int n) {
        super.updateManoeuvreViewActive(n);
        this.getLogChannel().log(10000000, "CtxOverviewMap#updateManoeuvreViewActive( %1 )", (long)n);
        this.setVisibleArea();
    }

    public void updateZoomEngineState(int n) {
        super.updateZoomEngineState(n);
        int n2 = this.getSetupAutoZoom();
        this.getLogChannel().log(10000000, "CtxOverviewMap#updateZoomEngineState - setupAutoZoom = %1", (long)n2);
        if (n2 == 1 || n2 == 0) {
            this.getLogChannel().log(100000000, "CtxOverviewMap#updateZoomEngineState - zoomEngineState = %1", (long)n);
            if (n == 3) {
                this.container.sManoeuvreZoomDisabledWithReturn = false;
            }
        }
    }

    public void updateRecommendedZoom(float f2) {
        super.updateRecommendedZoom(f2);
        int n = this.getSetupAutoZoom();
        this.getLogChannel().log(10000000, "CtxOverviewMap#updateRecommendedZoom - setupAutoZoom = %1", (long)n);
        if (n == 1 || n == 0) {
            int n2 = this.getZoomEngineState();
            this.getLogChannel().log(100000000, "CtxOverviewMap#updateRecommendedZoom - zoomEngineState = %1", (long)n2);
            if (!this.container.sManoeuvreZoomDisabledWithReturn && n2 == 3) {
                AbstractMap abstractMap = this.naviMap;
                abstractMap.switchToContext(8);
                abstractMap.setSwitchBackToContext(10);
            }
        }
    }

    protected void onDDSClicked() {
        this.getLogChannel().log(10000000, "CtxOverview#onDDSClicked()");
        this.getZoomHandler().stopOverviewMapSwitchBackTimer();
        this.getMap().setSwitchBackToContext(10);
        this.getMap().switchToContext(12);
    }

    public boolean supportsAdditionalInfo() {
        return true;
    }

    public void updateViewFreeze(boolean bl) {
        super.updateViewFreeze(bl);
        if (this.naviMap.getActiveContextIndex() == 10 && !bl) {
            this.setSoftZoom(true);
        }
    }

    protected void setAutoZoomIcon(boolean bl) {
        this.getLogChannel().log(10000000, "CtxOverviewMap#setAutoZoomIcon( %1 )", bl);
        if (bl) {
            this.naviMap.getGuiInterface().setSideBarRotaryIcon(3);
        } else {
            this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        }
    }

    protected void setSoftZoom(boolean bl) {
        this.getLogChannel().log(10000000, "CtxOverviewMap#setSoftZoom( %1 )", bl);
        this.naviMap.getMVRequest().setEnableSoftZoomConditional(bl);
    }

    public void automaticOrientateMap() {
        this.setVisibleArea();
    }

    public void updateMobilityHorizonStatus(int n) {
        super.updateMobilityHorizonStatus(n);
        if (!this.getRouteActiveOrRangeMapReady()) {
            this.naviMap.switchToContext(7);
        } else {
            this.naviMap.forceShownContextRefresh();
        }
    }
}

