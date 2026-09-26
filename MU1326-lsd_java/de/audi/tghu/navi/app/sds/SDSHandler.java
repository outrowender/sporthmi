/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sds;

import de.audi.atip.interapp.NaviService$NaviInfoDetails;
import de.audi.atip.interapp.SDSListEntry;
import org.dsi.ifc.global.NavLocation;

public interface SDSHandler {
    public static final int MAX_SDS_POI_RESULTS;
    public static final int DEST_CONTEXT_NONE;
    public static final int DEST_CONTEXT_ADB;
    public static final int DEST_CONTEXT_FAVORITE;
    public static final int DEST_CONTEXT_NAV_DEST_FORM;
    public static final int DEST_CONTEXT_LAST_DEST;
    public static final int DEST_CONTEXT_MAP_INPUT;
    public static final int DEST_CONTEXT_FUEL_FEATURE;
    public static final int DEST_CONTEXT_ONLINE_DEST;
    public static final int DEST_CONTEXT_RSE;
    public static final int DEST_CONTEXT_ROUTE_PLAN;
    public static final int DEST_CONTEXT_ROUTE_LIST;
    public static final int DEST_CONTEXT_PIC_NAV;
    public static final int FAV_TYPE_HOME;
    public static final int FAV_TYPE_OFFICE;
    public static final int FAV_TYPE_OTHER;

    default public boolean isProcessingActive() {
    }

    default public void setGuidanceMode(byte by) {
    }

    default public void checkRouteGuidance() {
    }

    default public byte fillNaviPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillNaviFavoritePickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public byte fillLastDestinationPickList(SDSListEntry[] sDSListEntryArray) {
    }

    default public void requestPostCodeFormat() {
    }

    default public void reduceRouteToFinalDestination() {
    }

    default public void triggerPOIReturn() {
    }

    default public void enterNavDestForm() {
    }

    default public void exitNavDestForm() {
    }

    default public boolean isInNavDestForm() {
    }

    default public void enterNavDestFormMainScreen() {
    }

    default public void exitNavDestFormMainScreen() {
    }

    default public boolean isInNavDestFormMainScreen() {
    }

    default public void storeNavigateToDestination(NavLocation navLocation) {
    }

    default public NavLocation getNavigateToDestination() {
    }

    default public NaviService$NaviInfoDetails getAddressDetails(byte by) {
    }

    default public NaviService$NaviInfoDetails getNaviInfo(boolean bl) {
    }

    default public void alternativeRoutesScreenEntered() {
    }

    default public void flushPOIPickListGroup() {
    }

    default public void setDestinationContext(int n) {
    }

    default public void setLastDestinationByIndex(long l) {
    }

    default public void setFavoriteDestinationByListIndex(int n) {
    }

    default public void setFavoriteDestinationByUniqueId(long l) {
    }

    default public void dialDetailsNumber() {
    }
}

