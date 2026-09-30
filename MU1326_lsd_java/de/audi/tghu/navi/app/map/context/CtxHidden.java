/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.Context;
import de.audi.tghu.navi.app.map.instances.MapMain;
import de.audi.tghu.navi.app.util.LocationFormatter;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.NavLocationWgs84;

public class CtxHidden
extends Context {
    public CtxHidden(NavigationEnv navigationEnv, IconHandler iconHandler, AbstractMap abstractMap) {
        super(navigationEnv, abstractMap);
    }

    public void enterPrologue() {
        this.showMap(false);
        this.freezeMap();
        if (this.naviMap instanceof MapMain) {
            this.naviMap.getRouteInfoContextHandler().signalMapHidden();
        }
    }

    public void enterEpilogue() {
        this.unfreezeMap();
    }

    public void enter() {
        this.naviMap.cancelOverviewMapTimer();
        this.naviMap.getNaviInterface().addressbookMapActive(false);
        this.naviMap.getGuiInterface().openOrCloseZoomBar(false);
        this.naviMap.getGuiInterface().setSideBarRotaryIcon(2);
        this.getMap().hideRouteInfo();
        this.naviMap.getMVRequest().setEnableSoftZoom(false);
        this.naviMap.getMVRequest().setEnableSoftTilt(false);
        this.naviMap.getMVRequest().setEnableSoftJump(false);
        this.naviMap.getMVRequest().setEnableSoftRotation(false);
        this.getData().hkBackInCtxHidden = false;
    }

    public void enterMapScreen(int n) {
        this.getLogChannel().log(1000000, "CtxHidden#enterMapScreen() - keepContext: %1", (long)n);
        super.enterMapScreen(n);
        AbstractMap abstractMap = this.naviMap;
        if (this.getMap().getRouteCalculationHandler().isCalculatingAltRoutes() && this.getData().switchBackToCalculation) {
            abstractMap.switchToContext(5);
            return;
        }
        if (this.getMap().getRouteCalculationHandler().isRouteCalculationActive() && this.getData().switchBackToCalculation) {
            abstractMap.switchToContext(33);
            return;
        }
        if (n == 1) {
            abstractMap.switchToContext(this.getKeptContextIndex());
        } else {
            abstractMap.switchToAShownContext();
        }
    }

    public void updateXTRepresentation(NavLocation navLocation, String string) {
        super.updateXTRepresentation(navLocation, string);
        this.getLogChannel().log(1000000, "CtxHidden#updateXTRepresentation( %1 )", (Object)LocationFormatter.formatLocationShort(navLocation));
        this.naviMap.getNaviInterface().showMapDestination(navLocation, string);
    }

    protected void abortRouteCalculation() {
        this.naviMap.getRouteCalculationHandler().cancelTimer();
        if (this.container.isInVia) {
            this.abortRouteCalculation(false);
        }
    }

    protected void abortRouteCalculation(boolean bl) {
        this.getLogChannel().log(1000000, "CtxHidden#abortRouteCalculation( %1 )", bl);
        if (this.env.getFramework().isFrontMU()) {
            this.naviMap.getNaviInterface().stopRouteGuidance();
        }
        if (bl) {
            AbstractMap abstractMap = this.naviMap;
            abstractMap.forceContext(-1);
            abstractMap.switchToContext(3);
        }
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (this.naviMap.getmLastForcedContext() == 17 && !bl) {
            this.naviMap.getGuiInterface().setScrollOnRoutePressed(false);
            this.naviMap.forceContext(12);
        }
    }

    public void updateMapPosition(NavLocationWgs84 navLocationWgs84) {
        super.updateMapPosition(navLocationWgs84);
        if (this.getMap().getLastVisibleCID() == 12) {
            this.getLogChannel().log(10000000, "CtxHidden#updateMapPosition() - adjust saved position to %1", (Object)navLocationWgs84);
            this.container.sOldLocationAfterCrosshairMap = navLocationWgs84;
        }
    }

    public void updateManoeuvreViewsAvailable(short[] sArray) {
        this.getLogChannel().log(1000000, "CtxHidden#updateManoeuvreViewsAvailable() - sShowManeuverViews: %1", this.container.sShowManeuverViews);
        super.updateManoeuvreViewsAvailable(sArray);
        if (Util.isPorsche(this.env.getFramework()) || Util.isPorscheGen2(this.env.getFramework())) {
            this.naviMap.getRouteInfoContextHandler().handleCurrentRouteInfoContext();
        }
    }

    public void hkBackPressed() {
        super.hkBackPressed();
        this.getLogChannel().log(10000000, "CtxHidden#hkBackPressed() will set hkBackInHiddeenContext");
        this.getData().hkBackInCtxHidden = true;
    }
}

