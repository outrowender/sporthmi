/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.utils;

import de.audi.atip.metrics.DateMetric;
import de.audi.tghu.navi.app.IconHandler;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.map.routeinfo.RouteInfoHelper;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.trafficregulation.RoadClassSpeedInfo;

public interface MixedListRow$IRouteInfoEnv {
    public static final int POI_ICON_MAX_CELLS;
    public static final int POI_ICON_MAX_COMMON;
    public static final int POI_ICON_MAX_ASIA;
    public static final int TRAFFIC_DELAY_MINIMUM;
    public static final int DEST_TYPE_NONE;
    public static final int DEST_TYPE_DESTINATION;
    public static final int DEST_TYPE_STOPOVER;

    default public RoadClassSpeedInfo[] getSpeedInfo() {
    }

    default public int getSpeedUnitForCountry(String string) {
    }

    default public IconHandler getIconHandler() {
    }

    default public int getRouteLength() {
    }

    default public NavLocation getCurrentDestination() {
    }

    default public String getTranslatedText(int n) {
    }

    default public String formatDistStr(long l) {
    }

    default public String getDestName(int n) {
    }

    default public DateMetric getRTTMetric() {
    }

    default public NavigationEnv getNavigationEnv() {
    }

    default public NavLocation getLocationOfDestination(int n) {
    }

    default public RouteInfoHelper getHelper() {
    }
}

