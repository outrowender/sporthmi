/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.komonavinfo;

import org.dsi.ifc.base.DSIBase;

public interface DSIKOMONavInfo
extends DSIBase {
    public static final String VERSION = "2.11.10";
    public static final int RP_SETCURRENTSTREETRESULT = 2000;
    public static final int RP_SETTURNTOSTREETRESULT = 2001;
    public static final int RP_SETCITYNAMERESULT = 2002;
    public static final int RP_SETSEMIDYNROUTERESULT = 2003;
    public static final int RP_SETTRAFFICOFFSETRESULT = 2004;
    public static final int RP_SETRGSELECTRESULT = 2005;
    public static final int RP_SETCAPABILITIESRESULT = 2006;
    public static final int RP_SETMAPSCALERESULT = 2007;
    public static final int RT_SETDISTANCETONEXTMANEUVER = 1000;
    public static final int RT_SETETA = 1001;
    public static final int RT_SETCURRENTSTREET = 1002;
    public static final int RT_SETTURNTOSTREET = 1003;
    public static final int RT_SETCITYNAME = 1004;
    public static final int RT_SETDISTANCETODESTINATION = 1005;
    public static final int RT_SETSEMIDYNROUTE = 1006;
    public static final int RT_SETTRAFFICOFFSET = 1007;
    public static final int RT_SETRTT = 1008;
    public static final int RT_SETRGSELECT = 1009;
    public static final int RT_SETCAPABILITIES = 1010;
    public static final int RT_SETMAPSCALE = 1011;
    public static final int RT_SETMAPSCALERESULT = 1012;
    public static final int IN_SETMAPSCALE = 3001;
    public static final int DISTANCEUNIT_MILES = 0;
    public static final int DISTANCEUNIT_METERS = 1;
    public static final int DISTANCEUNIT_KILOMETERS = 2;
    public static final int DISTANCEUNIT_YARDS = 3;
    public static final int DISTANCEUNIT_FEEDS = 4;
    public static final int DISTANCEUNIT_QUARTERMILE = 5;
    public static final int TIMEFORMAT_24HFORMAT = 0;
    public static final int TIMEFORMAT_12HFORMAT = 1;
    public static final int RGMODE_RGI = 0;
    public static final int RGMODE_KDK = 1;
    public static final int RGMODE_COMPASS = 2;
    public static final int RGMODE_MAP = 3;
    public static final int NAVINFORESULTCODE_OK = 0;
    public static final int NAVINFORESULTCODE_ERROR = 1;
    public static final int NAVINFORESULTCODE_UNSUPPORTED = 2;
    public static final int AUTOZOOM_OFF = 0;
    public static final int AUTOZOOM_ON = 1;
    public static final int AUTOZOOM_ONINTERSECTION = 2;
    public static final int AUTOZOOM_NOTSUPPORTED = 15;
    public static final int SCALE_INVALID = 0;
    public static final int SCALE_MINIMUM = 65533;
    public static final int SCALE_MAXIMUM = 65534;
    public static final int SCALE_INNIT_UNKNOWN = 65535;
    public static final int MAPSCALEUNIT_METER = 0;
    public static final int MAPSCALEUNIT_KILOMETER = 1;
    public static final int MAPSCALEUNIT_YARD = 2;
    public static final int MAPSCALEUNIT_FEET = 3;
    public static final int MAPSCALEUNIT_MILE_UK_US = 4;
    public static final int MAPSCALEUNIT_QUARTERMILE = 5;
    public static final int MAPSCALEUNIT_KILOMETER_HUNDREDTHSTEPS = 6;
    public static final int MAPSCALEUNIT_MILE_HUNDREDTHSTEPS = 7;
    public static final int MAPSCALEUNIT_NOTSUPPORTED_NOINFO = 255;

    public void setDistanceToNextManeuver(long var1, int var3, boolean var4);

    public void setETA(int var1, short var2, short var3, short var4, boolean var5, boolean var6);

    public void setCurrentStreet(String var1);

    public void setTurnToStreet(String var1, String var2);

    public void setCityName(String var1);

    public void setDistanceToDestination(long var1, int var3, boolean var4);

    public void setSemiDynRoute(boolean var1);

    public void setTrafficOffset(int var1, short var2, short var3, short var4, boolean var5);

    public void setRTT(short var1, short var2, boolean var3);

    public void setRgSelect(int var1);

    public void setCapabilities(boolean[] var1);

    public void setMapScale(int var1, int var2, boolean[] var3, int var4, int var5, int var6);

    public void setMapScaleResult(int var1, int var2, boolean[] var3, int var4, int var5, boolean[] var6, boolean var7);
}

