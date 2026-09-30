/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storagecache;

public interface CacheEventListener {
    public static final String APP_ID_ONLINE_TRAFFIC = "service_dsi_onlinetraffic";
    public static final String APP_ID_TRAFFICLIGHT = "service_trafficlight";
    public static final String APP_ID_GOOGLE_EARTH = "service_dsi_satellitemaps";
    public static final String APP_ID_SATELLITEMAPS_EB = "ebnav";
    public static final String APP_ID_SATELLITEMAPS_AW = "awnavicore";
    public static final String APP_ID_WEATHER_IN_MAP = "weatherinmaponlineservice";
    public static final String APP_ID_POI_ONLINE = "service_dsi_poi";
    public static final String APP_ID_PRESET_LAYOUT = "service_dsi_presetlayout";
    public static final String APP_ID_DEST_IMPORT = "service_dsi_destimport";
    public static final String APP_ID_DICTATION = "dictation";
    public static final String APP_ID_HOTSPOT = "hotspotwlan";
    public static final String APP_ID_CORE = "service_core";
    public static final String APP_ID_GRACENOTE = "online_metadata_service_app";
    public static final String APP_ID_UOTA = "UpdateOverTheAir";
    public static final String APP_ID_OPERATORCALL = "service_dsi_operatorcall";
    public static final String APP_ID_OPERATORCALL_TOKEN_ID_POICALL = "poicall";
    public static final String APP_ID_UOTA_TOKEN_ID_PPOI = "lic_uota_ppoi";
    public static final String APP_ID_UOTA_TOKEN_ID_NAVDATA = "lic_uota_nav";
    public static final String APP_ID_ONLINE_TRAFFIC_TOKEN_ID_OT = "lic_traffic";
    public static final String APP_ID_TRAFFICLIGHT_TOKEN_ID_TL = "trafficlightsinfo_v1";
    public static final String APP_ID_GOOGLE_EARTH_TOKEN_ID_GE = "satellitemaps";
    public static final String APP_ID_SATELLITEMAPS_TOKEN_ID_EB = "satellitemaps_eb";
    public static final String APP_ID_SATELLITEMAPS_TOKEN_ID_AW = "satellitemaps";
    public static final String APP_ID_WEATHER_IN_MAP_TOKEN_ID_WEATHER = "weatherGrid";
    public static final String APP_ID_POI_ONLINE_TOKEN_ID_HAPTIC = "poi_haptic";
    public static final String APP_ID_POI_ONLINE_TOKEN_ID_SDS = "poi_sds";
    public static final String APP_ID_DEST_IMPORT_TOKEN_ID_DI = "zieleinspeisung";
    public static final String APP_ID_DICTATION_TOKEN_ID_DICT = "dictation";
    public static final String APP_ID_GRACENOTE_TOKEN_ID_GN = "gracenote";

    public String[] getServiceIDs();

    public String[] getTokens(String var1);

    public void updateToken(String var1, String var2, Object var3);
}

