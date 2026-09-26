/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.metrics.DateMetric;

public interface NaviServiceListener {
    public static final int ATTRVALIDFLAG_INVALID;
    public static final int ATTRVALIDFLAG_VALID;
    public static final int INVALID_TS_QUERY_ID;

    default public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    default public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    default public void updateDestinationCountryCode(String string, String string2) {
    }

    default public void updateDestinationStateCode(String string, String string2) {
    }

    default public void updateFullyOperableStateChanged(boolean bl) {
    }

    default public void responseSetLocation(byte by) {
    }

    default public void responseSetOneShotData(byte by) {
    }

    default public void responseSetLocationPart(byte by) {
    }

    default public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
    }

    default public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
    }

    default public void responseSetSpelledLocationPart(byte by) {
    }

    default public void responseValidateSpelledStreetName(byte by) {
    }

    default public void responseStartDestinationInput(byte by) {
    }

    default public void responseTriggerAddressInputReturn(byte by) {
    }

    default public void responseStartPoiSearchByName(byte by) {
    }

    default public void responseFinishDestinationInput(byte by, byte by2) {
    }

    default public void responsePrepareRouteGuidance(byte by, byte by2) {
    }

    default public void responseCheckRouteGuidance(byte by) {
    }

    default public void responseSetRouteOptionCalcType(byte by) {
    }

    default public void responseSetDestination(byte by) {
    }

    default public void responseSetRouteOptionDynamic(byte by) {
    }

    default public void responseTriggerRouteGuidance(byte by) {
    }

    default public void responseReduceRouteToFinalDestination(byte by) {
    }

    default public void responseBlockRoute(byte by) {
    }

    default public void responseUnblockRoute(byte by) {
    }

    default public void responsePostCodeFormat(byte by, boolean bl) {
    }

    default public void responseSelectPOI(byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
    }

    default public void responseSelectPOIbyListIndex(byte by) {
    }

    default public void responseSelectTopPOI(byte by) {
    }

    default public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
    }

    default public void responseStopRouteGuidance(byte by) {
    }

    default public void responseStartRouteGuidance(byte by) {
    }

    default public void responseCalculateAlternativeRoutes(byte by) {
    }

    default public void responseSelectAlternativeRoute(byte by) {
    }

    default public void responseAddSelectedDestinationAtIndex(byte by) {
    }

    default public void responseSetLastDestination(byte by) {
    }

    default public void responseSetFavoriteDestination(byte by) {
    }

    default public void responseIntelliDestination(byte by) {
    }

    default public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
    }

    default public void responseDialDetailsNumber(byte by) {
    }

    default public void responseMapCodeResult(byte by) {
    }

    default public void responseTelephoneNumberResult(byte by) {
    }

    default public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
    }

    default public void updateRgActive(boolean bl) {
    }

    default public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
    }
}

