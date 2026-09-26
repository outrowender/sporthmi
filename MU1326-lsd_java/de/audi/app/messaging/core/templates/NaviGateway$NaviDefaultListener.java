/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.templates.NaviGateway;
import de.audi.app.messaging.core.templates.NaviGateway$1;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.atip.metrics.DateMetric;

class NaviGateway$NaviDefaultListener
implements NaviServiceListener {
    private final /* synthetic */ NaviGateway this$0;

    private NaviGateway$NaviDefaultListener(NaviGateway naviGateway) {
        this.this$0 = naviGateway;
    }

    @Override
    public void updateFavoriteDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    @Override
    public void updateLastDestinations(SDSListEntry[] sDSListEntryArray) {
    }

    @Override
    public void updateDestinationCountryCode(String string, String string2) {
    }

    @Override
    public void updateDestinationStateCode(String string, String string2) {
    }

    @Override
    public void updateFullyOperableStateChanged(boolean bl) {
    }

    @Override
    public void responseSetLocation(byte by) {
    }

    @Override
    public void responseSetOneShotData(byte by) {
    }

    @Override
    public void responseSetLocationPart(byte by) {
    }

    @Override
    public void responseQueryLocationPartListLength(byte by, long l, String[] stringArray) {
    }

    @Override
    public void responseQuerySpelledLocationPartResultList(byte by, String[] stringArray, Object[] objectArray) {
    }

    @Override
    public void responseSetSpelledLocationPart(byte by) {
    }

    @Override
    public void responseValidateSpelledStreetName(byte by) {
    }

    @Override
    public void responseStartDestinationInput(byte by) {
    }

    @Override
    public void responseTriggerAddressInputReturn(byte by) {
    }

    @Override
    public void responseStartPoiSearchByName(byte by) {
    }

    @Override
    public void responseFinishDestinationInput(byte by, byte by2) {
    }

    @Override
    public void responsePrepareRouteGuidance(byte by, byte by2) {
    }

    @Override
    public void responseCheckRouteGuidance(byte by) {
    }

    @Override
    public void responseSetRouteOptionCalcType(byte by) {
    }

    @Override
    public void responseSetDestination(byte by) {
    }

    @Override
    public void responseSetRouteOptionDynamic(byte by) {
    }

    @Override
    public void responseTriggerRouteGuidance(byte by) {
    }

    @Override
    public void responseReduceRouteToFinalDestination(byte by) {
    }

    @Override
    public void responseBlockRoute(byte by) {
    }

    @Override
    public void responseUnblockRoute(byte by) {
    }

    @Override
    public void responsePostCodeFormat(byte by, boolean bl) {
    }

    @Override
    public void responseSelectPOI(byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
    }

    @Override
    public void responseSelectPOIbyListIndex(byte by) {
    }

    @Override
    public void responseSelectTopPOI(byte by) {
    }

    @Override
    public void responseCurrentSpeedLimit(byte by, int n, byte by2) {
    }

    @Override
    public void responseStopRouteGuidance(byte by) {
    }

    @Override
    public void responseStartRouteGuidance(byte by) {
    }

    @Override
    public void responseCalculateAlternativeRoutes(byte by) {
    }

    @Override
    public void responseSelectAlternativeRoute(byte by) {
    }

    @Override
    public void responseAddSelectedDestinationAtIndex(byte by) {
    }

    @Override
    public void responseSetLastDestination(byte by) {
    }

    @Override
    public void responseSetFavoriteDestination(byte by) {
    }

    @Override
    public void responseIntelliDestination(byte by) {
    }

    @Override
    public void updateResponseStartTrufflesSearch(byte by, int n, boolean bl, int n2) {
    }

    @Override
    public void responseDialDetailsNumber(byte by) {
    }

    @Override
    public void responseMapCodeResult(byte by) {
    }

    @Override
    public void responseTelephoneNumberResult(byte by) {
    }

    @Override
    public void updateTrafficSituation(boolean bl, DateMetric dateMetric, int n, long l, int n2) {
    }

    @Override
    public void updateRgActive(boolean bl) {
        this.this$0.toggleRouteGuidance(bl);
    }

    @Override
    public void responseSynchronizeSpeechCountryWithCurrentLDResult(byte by, boolean bl) {
    }

    /* synthetic */ NaviGateway$NaviDefaultListener(NaviGateway naviGateway, NaviGateway$1 naviGateway$1) {
        this(naviGateway);
    }
}

