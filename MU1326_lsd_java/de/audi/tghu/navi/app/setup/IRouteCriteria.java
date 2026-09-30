/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.setup;

import org.dsi.ifc.navigation.RouteOptions;

public interface IRouteCriteria {
    public static final int OPTION_IGNORE = 0;
    public static final int OPTION_WITH = 1;
    public static final int OPTION_AVOID = 2;
    public static final int OPTION_AUTO = 3;
    public static final int OPTION_MANUAL = 4;
    public static final int OPTION_ON = 5;
    public static final int OPTION_OFF = 6;
    public static final int OPTION_AVOID_EXCEPT = 7;

    public void setValuesFromObject(IRouteCriteria var1);

    public RouteOptions[] getRouteOptions(boolean var1);

    public int getTrafficRerouting();

    public void setTrafficRerouting(int var1);

    public int getFreeways();

    public void setFreeways(int var1);

    public int getTollRoads();

    public void setTollRoads(int var1);

    public int getFerries();

    public void setFerries(int var1);

    public int getMotorrail();

    public void setMotorrail(int var1);

    public int getTimeRestrictedRoads();

    public void setTimeRestrictedRoads(int var1);

    public int getSeasonRestricted();

    public void setSeasonRestricted(int var1);

    public int getTrailer();

    public void setTrailer(int var1);

    public int getVignettes();

    public void setVignettes(int var1);

    public int[] getVignetteCountries();

    public void setVignetteCountries(int[] var1);

    public void setRouteOption(int var1);

    public void setTunnels(int var1);

    public int getTunnels();

    public void setHovLanes(int var1);

    public int getHovLanes();

    public void setUnpaved(int var1);

    public int getUnpaved();

    public void setIpd(int var1);

    public int getIpd();
}

