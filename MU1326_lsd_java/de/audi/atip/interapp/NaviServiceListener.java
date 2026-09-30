/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.metrics.DateMetric;

public interface NaviServiceListener {
    public static final int ATTRVALIDFLAG_INVALID = 0;
    public static final int ATTRVALIDFLAG_VALID = 1;
    public static final int INVALID_TS_QUERY_ID = -1;

    public void updateFavoriteDestinations(SDSListEntry[] var1);

    public void updateLastDestinations(SDSListEntry[] var1);

    public void updateDestinationCountryCode(String var1, String var2);

    public void updateDestinationStateCode(String var1, String var2);

    public void updateFullyOperableStateChanged(boolean var1);

    public void responseSetLocation(byte var1);

    public void responseSetOneShotData(byte var1);

    public void responseSetLocationPart(byte var1);

    public void responseQueryLocationPartListLength(byte var1, long var2, String[] var4);

    public void responseQuerySpelledLocationPartResultList(byte var1, String[] var2, Object[] var3);

    public void responseSetSpelledLocationPart(byte var1);

    public void responseValidateSpelledStreetName(byte var1);

    public void responseStartDestinationInput(byte var1);

    public void responseTriggerAddressInputReturn(byte var1);

    public void responseStartPoiSearchByName(byte var1);

    public void responseFinishDestinationInput(byte var1, byte var2);

    public void responsePrepareRouteGuidance(byte var1, byte var2);

    public void responseCheckRouteGuidance(byte var1);

    public void responseSetRouteOptionCalcType(byte var1);

    public void responseSetDestination(byte var1);

    public void responseSetRouteOptionDynamic(byte var1);

    public void responseTriggerRouteGuidance(byte var1);

    public void responseReduceRouteToFinalDestination(byte var1);

    public void responseBlockRoute(byte var1);

    public void responseUnblockRoute(byte var1);

    public void responsePostCodeFormat(byte var1, boolean var2);

    public void responseSelectPOI(byte var1, NaviService.POISDSListEntry[] var2);

    public void responseSelectPOIbyListIndex(byte var1);

    public void responseSelectTopPOI(byte var1);

    public void responseCurrentSpeedLimit(byte var1, int var2, byte var3);

    public void responseStopRouteGuidance(byte var1);

    public void responseStartRouteGuidance(byte var1);

    public void responseCalculateAlternativeRoutes(byte var1);

    public void responseSelectAlternativeRoute(byte var1);

    public void responseAddSelectedDestinationAtIndex(byte var1);

    public void responseSetLastDestination(byte var1);

    public void responseSetFavoriteDestination(byte var1);

    public void responseIntelliDestination(byte var1);

    public void updateResponseStartTrufflesSearch(byte var1, int var2, boolean var3, int var4);

    public void responseDialDetailsNumber(byte var1);

    public void responseMapCodeResult(byte var1);

    public void responseTelephoneNumberResult(byte var1);

    public void updateTrafficSituation(boolean var1, DateMetric var2, int var3, long var4, int var6);

    public void updateRgActive(boolean var1);

    public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte var1, boolean var2);

    public static class Stub
    implements NaviServiceListener {
        public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
        }

        public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
        }

        public void updateDestinationCountryCode(String string, String string2) {
        }

        public void updateDestinationStateCode(String string, String string2) {
        }

        public void updateFullyOperableStateChanged(boolean bl) {
        }

        public void responseSetLocation(byte by) {
        }

        public void responseSetOneShotData(byte by) {
        }

        public void responseSetLocationPart(byte by) {
        }

        public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
        }

        public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
        }

        public void responseSetSpelledLocationPart(byte by) {
        }

        public void responseValidateSpelledStreetName(byte by) {
        }

        public void responseStartDestinationInput(byte by) {
        }

        public void responseTriggerAddressInputReturn(byte by) {
        }

        public void responseStartPoiSearchByName(byte by) {
        }

        public void responseFinishDestinationInput(byte by, byte by2) {
        }

        public void responsePrepareRouteGuidance(byte by, byte by2) {
        }

        public void responseCheckRouteGuidance(byte by) {
        }

        public void responseSetRouteOptionCalcType(byte by) {
        }

        public void responseSetDestination(byte by) {
        }

        public void responseSetRouteOptionDynamic(byte by) {
        }

        public void responseTriggerRouteGuidance(byte by) {
        }

        public void responseReduceRouteToFinalDestination(byte by) {
        }

        public void responseBlockRoute(byte by) {
        }

        public void responseUnblockRoute(byte by) {
        }

        public void responsePostCodeFormat(byte by, boolean bl) {
        }

        public void responseSelectPOI(byte by, NaviService.POISDSListEntry[] pOISDSListEntryArray) {
        }

        public void responseSelectPOIbyListIndex(byte by) {
        }

        public void responseSelectTopPOI(byte by) {
        }

        public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
        }

        public void responseStopRouteGuidance(byte by) {
        }

        public void responseStartRouteGuidance(byte by) {
        }

        public void responseCalculateAlternativeRoutes(byte by) {
        }

        public void responseSelectAlternativeRoute(byte by) {
        }

        public void responseAddSelectedDestinationAtIndex(byte by) {
        }

        public void responseSetLastDestination(byte by) {
        }

        public void responseSetFavoriteDestination(byte by) {
        }

        public void responseIntelliDestination(byte by) {
        }

        public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
        }

        public void responseDialDetailsNumber(byte by) {
        }

        public void responseMapCodeResult(byte by) {
        }

        public void responseTelephoneNumberResult(byte by) {
        }

        public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
        }

        public void updateRgActive(boolean bl) {
        }

        public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
        }
    }
}

