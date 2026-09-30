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
    public static final int MAPSCALE_MAXIMUM = 65534;
    public static final int SUPPORTED_MAP_TYPE_NONE = 0;
    public static final int SUPPORTED_MAP_TYPE_DESTINATION_MAP = 1;
    public static final int SUPPORTED_MAP_TYPE_POSITION2D_MAP = 2;
    public static final int SUPPORTED_MAP_TYPE_POSITION3D_MAP = 4;
    public static final int SUPPORTED_MAP_TYPE_OVERVIEW_MAP = 8;
    public static final int SUPPORTED_MAP_VIEW_NONE = 0;
    public static final int SUPPORTED_MAP_VIEW_STANDARD_MAP = 1;
    public static final int SUPPORTED_MAP_VIEW_GOOGLE_EARTH_MAP = 2;
    public static final int SUPPORTED_MAP_VIEW_TRAFFIC_MAP = 4;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_NONE = 0;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_INTERSECTION_ZOOM = 1;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_COMPASS = 2;
    public static final int SUPPORTED_SUPPLEMENTARY_MAP_VIEW_3_1_BOX = 4;
    public static final int VOICE_GUIDANCE_ON_FULL_AVAILABLE = 1;
    public static final int VOICE_GUIDANCE_ON_REDUCED_AVAILABLE = 2;
    public static final int VOICE_GUIDANCE_ON_TRAFFIC_AVAILABLE = 4;

    public void showInitializingScreen();

    public void hideInitializingScreen();

    public void updateCompassInfo(int var1, int var2);

    public void updateRGStatus(int var1);

    public void updateActiveRGType(int var1);

    public void updateDistanceToNextManeuver(int var1, int var2, boolean var3, int var4);

    public void updateCurrentPositionInfo(String var1);

    public void updateTurnToInfo(String var1, String var2);

    public void updateDistanceToDestination(int var1, int var2, boolean var3);

    public void updateTimeToDestination(int var1, int var2, long var3);

    public void updateManeuverDescriptor(CombiBAPNaviManeuverDescriptor[] var1);

    public void updateLaneGuidance(boolean var1, CombiBAPNaviLaneGuidanceData[] var2);

    public void updateTMCInfoMessages(CombiBAPTMCInfoMessage[] var1);

    public void updateLastDestinationsList(CombiBAPDestinationListEntry[] var1);

    public void updateFavoriteDestinationsList(CombiBAPDestinationListEntry[] var1);

    public void updateHomeAddress(CombiBAPNaviDestination var1);

    public void routeGuidanceActDeactResult(int var1);

    public void repeatLastNavAnnouncementResult(int var1);

    public void updateVoiceGuidanceState(int var1);

    public void updateInfoStates(int var1);

    public void updateTrafficBlockIndication(int var1);

    public void updateMapColor(int var1);

    public void updateMapType(int var1, int var2);

    public void updateSupportedMapTypes(boolean var1, int var2);

    public void updateMapView(int var1, int var2);

    public void updateSupportedMapViews(int var1, int var2);

    public void updateMapVisibility(boolean var1, boolean var2);

    public void updateMapOrientation(int var1);

    public void updateMapScale(int var1, boolean var2, int var3, int var4, boolean var5);

    public void updateDestinationInfo(CombiBAPDestinationInfo var1);

    public void updateAltitude(int var1, int var2);

    public void updateOnlineNavigationState(int var1, int var2, int var3);

    public void updateExitView(int var1, int var2);

    public void updateSemidynamicRouteGuidance(CombiBAPSemiDynamicRouteInfo var1);

    public void poiSearchResult(int var1, int var2);

    public void updatePOIListSize(int var1);

    public void updateFSGSetup(int var1, boolean var2);

    public void updateMapPresentation(boolean var1, boolean var2, boolean var3);

    public void updateManeuverState(int var1);

    public void updateEtcStatus(EtcStatus var1);
}

