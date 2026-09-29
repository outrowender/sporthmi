/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.storagecache;

public interface CacheEventListener {
    public static final String APP_ID_ONLINE_TRAFFIC;
    public static final String APP_ID_TRAFFICLIGHT;
    public static final String APP_ID_GOOGLE_EARTH;
    public static final String APP_ID_SATELLITEMAPS_EB;
    public static final String APP_ID_SATELLITEMAPS_AW;
    public static final String APP_ID_WEATHER_IN_MAP;
    public static final String APP_ID_POI_ONLINE;
    public static final String APP_ID_PRESET_LAYOUT;
    public static final String APP_ID_DEST_IMPORT;
    public static final String APP_ID_DICTATION;
    public static final String APP_ID_HOTSPOT;
    public static final String APP_ID_CORE;
    public static final String APP_ID_GRACENOTE;
    public static final String APP_ID_UOTA;
    public static final String APP_ID_OPERATORCALL;
    public static final String APP_ID_OPERATORCALL_TOKEN_ID_POICALL;
    public static final String APP_ID_UOTA_TOKEN_ID_PPOI;
    public static final String APP_ID_UOTA_TOKEN_ID_NAVDATA;
    public static final String APP_ID_ONLINE_TRAFFIC_TOKEN_ID_OT;
    public static final String APP_ID_TRAFFICLIGHT_TOKEN_ID_TL;
    public static final String APP_ID_GOOGLE_EARTH_TOKEN_ID_GE;
    public static final String APP_ID_SATELLITEMAPS_TOKEN_ID_EB;
    public static final String APP_ID_SATELLITEMAPS_TOKEN_ID_AW;
    public static final String APP_ID_WEATHER_IN_MAP_TOKEN_ID_WEATHER;
    public static final String APP_ID_POI_ONLINE_TOKEN_ID_HAPTIC;
    public static final String APP_ID_POI_ONLINE_TOKEN_ID_SDS;
    public static final String APP_ID_DEST_IMPORT_TOKEN_ID_DI;
    public static final String APP_ID_DICTATION_TOKEN_ID_DICT;
    public static final String APP_ID_GRACENOTE_TOKEN_ID_GN;

    default public String[] getServiceIDs() {
    }

    default public String[] getTokens(String string) {
    }

    default public void updateToken(String string, String string2, Object object) {
    }
}

