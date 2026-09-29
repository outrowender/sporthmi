/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.handler;

import de.audi.tghu.navi.app.map.utils.MapPin;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.map.PosInfo;

public interface IPosInfoParser {
    public static final int UNKOWN;
    public static final int DONE;
    public static final int Resolve_OnlineResult;
    public static final int Resolve_TMC;
    public static final int Resolve_PicNav;
    public static final int Resolve_XT;
    public static final int Resolve_GEOnboardPOI;
    public static final int Resolve_Favorite;
    public static final int Resolve;
    public static final int Resolve_BuildListPOI;

    default public String getDescription() {
    }

    default public PosInfo getPosInfo() {
    }

    default public String getUrl() {
    }

    default public ResourceLocator getPicNavLocator() {
    }

    default public boolean hasStackedPOIIndex() {
    }

    default public boolean hasPicNavIndex() {
    }

    default public MapPin getMapPin() {
    }

    default public NavLocation getHomeOrOffice() {
    }

    default public void setActiveInfoListIndex(int n) {
    }

    default public int getActiveInfoListIndex() {
    }

    default public int parseInfoList(PosInfo[] posInfoArray) {
    }

    default public int parseInfoListForTmcMessages(PosInfo[] posInfoArray) {
    }

    default public boolean isRouteSegment() {
    }

    default public long getRouteSegmentIndex() {
    }

    default public NavLocation getResolvedOnlineNavLocation() {
    }
}

