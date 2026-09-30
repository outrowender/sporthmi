/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.routecalc;

import de.audi.tghu.navi.app.map.routecalc.RcsBase;
import de.audi.tghu.navi.app.map.routecalc.RouteCalcSM;
import de.audi.tghu.navi.app.map.utils.MapUtils;
import org.dsi.ifc.global.NavSegmentID;
import org.dsi.ifc.map.AvailableRoute;
import org.dsi.ifc.navigation.CalculatedRouteListElement;

public class RcsWaitForActivation
extends RcsBase {
    RcsWaitForActivation(RouteCalcSM routeCalcSM) {
        super(routeCalcSM, "RcsWaitForActivation");
    }

    public void updateRgActive(boolean bl) {
        super.updateRgActive(bl);
        if (bl) {
            this.checkFinish();
        } else {
            this.getLogger().log(10000, "RcsWaitForActivation#updateRgActive( %1 ) - invalid", bl);
            this.goTo(0);
        }
    }

    public void updateAvailableRoutes(AvailableRoute[] availableRouteArray, int n) {
        super.updateAvailableRoutes(availableRouteArray, n);
        this.checkFinish();
    }

    public void updateRgCalculatedRoutes(CalculatedRouteListElement[] calculatedRouteListElementArray) {
        super.updateRgCalculatedRoutes(calculatedRouteListElementArray);
        this.checkFinish();
    }

    private void checkFinish() {
        NavSegmentID navSegmentID = null;
        NavSegmentID navSegmentID2 = null;
        if (this.data.mCalculatedRouteListElement != null && this.data.mCalculatedRouteListElement.length > 0) {
            navSegmentID = this.data.mCalculatedRouteListElement[0].getSegmentIDList();
        }
        if (this.data.sAvailableRoutes[this.getActiveRendererID()] != null && this.data.sAvailableRoutes[this.getActiveRendererID()].length > 0) {
            navSegmentID2 = this.data.sAvailableRoutes[this.getActiveRendererID()][0].getNavSegmentID();
        }
        if (this.data.isRGActive && navSegmentID != null && navSegmentID2 != null && MapUtils.isEqual(navSegmentID, navSegmentID2)) {
            this.getLogger().log(10000000, "RcsWaitForActivation#checkFinish() - ready (rgActive=%1, Calculated=%2, Available=%3)", this.data.isRGActive, (Object)navSegmentID, (Object)navSegmentID2);
            this.goTo(7);
        } else {
            this.getLogger().log(10000000, "RcsWaitForActivation#checkFinish() - waiting... (rgActive=%1, Calculated=%2, Available=%3)", this.data.isRGActive, (Object)navSegmentID, (Object)navSegmentID2);
        }
    }

    public void setSelectedRouteIndex(int n) {
        this.data.iRouteIndex = n;
    }

    public int getValue4Model() {
        return 5;
    }
}

