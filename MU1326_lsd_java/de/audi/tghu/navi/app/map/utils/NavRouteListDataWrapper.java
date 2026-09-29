/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.util.StringUtilities;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.navigation.NavRouteListData;

public class NavRouteListDataWrapper {
    private final NavRouteListData navRoute;
    private String content = null;

    public NavRouteListDataWrapper(NavRouteListData navRouteListData) {
        this.navRoute = navRouteListData;
    }

    public String toString() {
        if (this.content == null) {
            this.content = NavRouteListDataWrapper.toShortString(this.navRoute);
        }
        return this.content;
    }

    public static String toShortString(NavRouteListData navRouteListData) {
        Buffer buffer = new Buffer();
        buffer.append("NavRouteListData(");
        buffer.append("startDistance=").append(navRouteListData.startDistance);
        buffer.append(",endDistance=").append(navRouteListData.endDistance);
        buffer.append(",remainingTravelTime=").append(navRouteListData.remainingTravelTime);
        if (navRouteListData.timeLagToNextDest > 0) {
            buffer.append(",timeLagToNextDest=").append(navRouteListData.timeLagToNextDest);
        }
        if (!StringUtilities.isNullOrEmpty(navRouteListData.streetname)) {
            buffer.append(",streetname=").append(navRouteListData.streetname);
        }
        if (navRouteListData.motorwayLength > 0L) {
            buffer.append(",motorwayLength=").append(navRouteListData.motorwayLength);
        }
        if (navRouteListData.tollLength > 0L) {
            buffer.append(",tollLength=").append(navRouteListData.tollLength);
        }
        if (navRouteListData.tollCostAmount > 0L) {
            buffer.append(",tollCostAmount=").append(navRouteListData.tollCostAmount);
        }
        if (navRouteListData.tollCostCurrency > 0) {
            buffer.append(",tollCostCurrency=").append(navRouteListData.tollCostCurrency);
        }
        if (navRouteListData.tunnelOnWay) {
            buffer.append(",tunnelOnWay");
        }
        if (navRouteListData.ferryOnWay) {
            buffer.append(",ferryOnWay");
        }
        if (navRouteListData.timeRestricted) {
            buffer.append(",timeRestricted");
        }
        if (navRouteListData.carTrainOnWay) {
            buffer.append(",carTrainOnWay");
        }
        if (navRouteListData.seasonalRestricted) {
            buffer.append(",seasonalRestricted");
        }
        if (navRouteListData.vignetteNeededOnWay) {
            buffer.append(",vignetteNeededOnWay");
        }
        if (navRouteListData.remainingTravelTimeStatus != 1) {
            buffer.append(",remainingTravelTimeStatus=").append(navRouteListData.remainingTravelTimeStatus);
        }
        buffer.append(')');
        return buffer.toString();
    }
}

