/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSListEntry;
import org.dsi.ifc.global.NavLocation;

public interface SDSHandler {
    public static final int MAX_SDS_POI_RESULTS = 20;
    public static final int DEST_CONTEXT_NONE = 0;
    public static final int DEST_CONTEXT_ADB = 1;
    public static final int DEST_CONTEXT_FAVORITE = 2;
    public static final int DEST_CONTEXT_NAV_DEST_FORM = 3;
    public static final int DEST_CONTEXT_LAST_DEST = 4;
    public static final int DEST_CONTEXT_MAP_INPUT = 5;
    public static final int DEST_CONTEXT_FUEL_FEATURE = 6;
    public static final int DEST_CONTEXT_ONLINE_DEST = 7;
    public static final int DEST_CONTEXT_RSE = 8;
    public static final int DEST_CONTEXT_ROUTE_PLAN = 9;
    public static final int DEST_CONTEXT_ROUTE_LIST = 10;
    public static final int DEST_CONTEXT_PIC_NAV = 11;
    public static final int FAV_TYPE_HOME = 0;
    public static final int FAV_TYPE_OFFICE = 1;
    public static final int FAV_TYPE_OTHER = 2;

    public boolean isProcessingActive();

    public void setGuidanceMode(byte var1);

    public void checkRouteGuidance();

    public byte fillNaviPickList(SDSListEntry[] var1);

    public byte fillNaviFavoritePickList(SDSListEntry[] var1);

    public byte fillLastDestinationPickList(SDSListEntry[] var1);

    public void requestPostCodeFormat();

    public void reduceRouteToFinalDestination();

    public void triggerPOIReturn();

    public void enterNavDestForm();

    public void exitNavDestForm();

    public boolean isInNavDestForm();

    public void enterNavDestFormMainScreen();

    public void exitNavDestFormMainScreen();

    public boolean isInNavDestFormMainScreen();

    public void storeNavigateToDestination(NavLocation var1);

    public NavLocation getNavigateToDestination();

    public NaviService.NaviInfoDetails getAddressDetails(byte var1);

    public NaviService.NaviInfoDetails getNaviInfo(boolean var1);

    public void alternativeRoutesScreenEntered();

    public void flushPOIPickListGroup();

    public void setDestinationContext(int var1);

    public void setLastDestinationByIndex(long var1);

    public void setFavoriteDestinationByListIndex(int var1);

    public void setFavoriteDestinationByUniqueId(long var1);

    public void dialDetailsNumber();
}

