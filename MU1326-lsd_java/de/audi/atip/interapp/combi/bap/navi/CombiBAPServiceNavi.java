/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.bap.navi;

import de.audi.atip.interapp.combi.bap.CombiBAPService;
import de.audi.atip.interapp.combi.bap.audio.data.CombiBAPTMCInfoMessage;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationInfo;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPDestinationListEntry;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviDestination;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviLaneGuidanceData;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPNaviManeuverDescriptor;
import de.audi.atip.interapp.combi.bap.navi.data.CombiBAPSemiDynamicRouteInfo;
import de.audi.atip.interapp.combi.bap.navi.data.EtcStatus;

public interface CombiBAPServiceNavi
extends CombiBAPService {
    public static final int MAPSCALE_MAXIMUM;
    public static final int SUPPORTED_MAP_TYPE_NONE;
    public static final int SUPPORTED_MAP_TYPE_DESTINATION_MAP;
    public static final int SUPPORTED_MAP_TYPE_POSITION2D_MAP;
    public static final int SUPPORTED_MAP_TYPE_POSITION3D_MAP;
    public static final int SUPPORTED_MAP_TYPE_OVERVIEW_MAP;
    public static final int SUPPORTED_MAP_VIEW_NONE;
    public static final int SUPPORTED_MAP_VIEW_STANDARD_MAP;
    public static final int SUPPORTED_MAP_VIEW_GOOGLE_EARTH_MAP;
    public static final int SUPPORTED_MAP_VIEW_TRAFFIC_MAP;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_NONE;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_COMPASS;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_3_1_BOX;
    public static final int VOICE_GUIDANCE_ON_FULL_AVAILABLE;
    public static final int VOICE_GUIDANCE_ON_REDUCED_AVAILABLE;
    public static final int VOICE_GUIDANCE_ON_TRAFFIC_AVAILABLE;

    default public void showInitializingScreen() {
    }

    default public void hideInitializingScreen() {
    }

    default public void updateCompassInfo(int n, int n2) {
    }

    default public void updateRGStatus(int n) {
    }

    default public void updateActiveRGType(int n) {
    }

    default public void updateDistanceToNextManeuver(int n, int n2, boolean bl, int n3) {
    }

    default public void updateCurrentPositionInfo(String string) {
    }

    default public void updateTurnToInfo(String string, String string2) {
    }

    default public void updateDistanceToDestination(int n, int n2, boolean bl) {
    }

    default public void updateTimeToDestination(int n, int n2, long l) {
    }

    default public void updateManeuverDescriptor(CombiBAPNaviManeuverDescriptor[] combiBAPNaviManeuverDescriptorArray) {
    }

    default public void updateLaneGuidance(boolean bl, CombiBAPNaviLaneGuidanceData[] combiBAPNaviLaneGuidanceDataArray) {
    }

    default public void updateTMCInfoMessages(CombiBAPTMCInfoMessage[] combiBAPTMCInfoMessageArray) {
    }

    default public void updateLastDestinationsList(CombiBAPDestinationListEntry[] combiBAPDestinationListEntryArray) {
    }

    default public void updateFavoriteDestinationsList(CombiBAPDestinationListEntry[] combiBAPDestinationListEntryArray) {
    }

    default public void updateHomeAddress(CombiBAPNaviDestination combiBAPNaviDestination) {
    }

    default public void routeGuidanceActDeactResult(int n) {
    }

    default public void repeatLastNavAnnouncementResult(int n) {
    }

    default public void updateVoiceGuidanceState(int n) {
    }

    default public void updateInfoStates(int n) {
    }

    default public void updateTrafficBlockIndication(int n) {
    }

    default public void updateMapColor(int n) {
    }

    default public void updateMapType(int n, int n2) {
    }

    default public void updateSupportedMapTypes(boolean bl, int n) {
    }

    default public void updateMapView(int n, int n2) {
    }

    default public void updateSupportedMapViews(int n, int n2) {
    }

    default public void updateMapVisibility(boolean bl, boolean bl2) {
    }

    default public void updateMapOrientation(int n) {
    }

    default public void updateMapScale(int n, boolean bl, int n2, int n3, boolean bl2) {
    }

    default public void updateDestinationInfo(CombiBAPDestinationInfo combiBAPDestinationInfo) {
    }

    default public void updateAltitude(int n, int n2) {
    }

    default public void updateOnlineNavigationState(int n, int n2, int n3) {
    }

    default public void updateExitView(int n, int n2) {
    }

    default public void updateSemidynamicRouteGuidance(CombiBAPSemiDynamicRouteInfo combiBAPSemiDynamicRouteInfo) {
    }

    default public void poiSearchResult(int n, int n2) {
    }

    default public void updatePOIListSize(int n) {
    }

    default public void updateFSGSetup(int n, boolean bl) {
    }

    default public void updateMapPresentation(boolean bl, boolean bl2, boolean bl3) {
    }

    default public void updateManeuverState(int n) {
    }

    default public void updateEtcStatus(EtcStatus etcStatus) {
    }
}

