/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;

public interface IPosInfoParser {
    public static final int UNKOWN = -1;
    public static final int DONE = 0;
    public static final int Resolve_OnlineResult = 1;
    public static final int Resolve_TMC = 2;
    public static final int Resolve_PicNav = 3;
    public static final int Resolve_XT = 4;
    public static final int Resolve_GEOnboardPOI = 5;
    public static final int Resolve_Favorite = 6;
    public static final int Resolve = 7;
    public static final int Resolve_BuildListPOI = 8;

    public String getDescription();

    public PosInfo getPosInfo();

    public String getUrl();

    public ResourceLocator getPicNavLocator();

    public boolean hasStackedPOIIndex();

    public boolean hasPicNavIndex();

    public MapPin getMapPin();

    public NavLocation getHomeOrOffice();

    public void setActiveInfoListIndex(int var1);

    public int getActiveInfoListIndex();

    public int parseInfoList(PosInfo[] var1);

    public int parseInfoListForTmcMessages(PosInfo[] var1);

    public boolean isRouteSegment();

    public long getRouteSegmentIndex();

    public NavLocation getResolvedOnlineNavLocation();
}

