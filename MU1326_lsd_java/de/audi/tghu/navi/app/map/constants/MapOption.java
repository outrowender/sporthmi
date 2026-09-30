/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.constants;

public class MapOption {
    public static final int S_AutoZoom = 0;
    public static final int S_Color = 1;
    public static final int S_3DBuilding = 2;
    public static final int S_3DLandmarks = 3;
    public static final int S_Type = 4;
    public static final int S_Orientation = 5;
    public static final int S_SpeedAndFlow = 6;
    public static final int S_OnlineTraffic = 7;
    public static final int S_RoadClass = 8;
    public static final int S_BrandIconStyle = 9;
    public static final int S_CrossingView = 10;
    public static final int S_TmcSymbols = 11;
    public static final int S_WeatherIcons = 12;
    public static final int S_Range = 13;
    public static final int S_PicNav = 14;
    public static final int S_Google3DCityModel = 15;
    public static final int S_Pois = 16;
    public static final int S_PoiCategories = 17;
    public static final int S_TrafficEventNoticeMap = 18;
    public static final int S_UncrowdedRoad = 19;
    public static final int S_Favorites = 20;
    public static final int S_EtaMode = 21;
    public static final int C_TypeAndOrientation = 22;
    public static final int C_TrafficFlow = 23;
    public static final int C_Style = 24;
    public static final int C_AdditionalInfo = 25;
    public static final int MaxCount = 26;
    public static final String Unknown = "Unknown";
    private static String[] names = new String[26];

    public static String getName(int n) {
        if (n < 0 || names.length <= n) {
            return Unknown;
        }
        return names[n];
    }

    static {
        MapOption.names[0] = "AutoZoom";
        MapOption.names[1] = "Color";
        MapOption.names[2] = "3DBuilding";
        MapOption.names[3] = "3DLandmarks";
        MapOption.names[4] = "Type";
        MapOption.names[5] = "Orientation";
        MapOption.names[6] = "SpeedAndFlow";
        MapOption.names[7] = "OnlineTraffic";
        MapOption.names[8] = "RoadClass";
        MapOption.names[9] = "BrandIconStyle";
        MapOption.names[10] = "CrossingView";
        MapOption.names[11] = "TmcSymbols";
        MapOption.names[12] = "WeatherIcons";
        MapOption.names[13] = "Range";
        MapOption.names[14] = "PicNav";
        MapOption.names[15] = "Google3DCityModel";
        MapOption.names[16] = "Pois";
        MapOption.names[17] = "PoiCategories";
        MapOption.names[18] = "TrafficEventNoticeMap";
        MapOption.names[19] = "UncrowdedRoad";
        MapOption.names[20] = "Favorites";
        MapOption.names[21] = "EtaMode";
        MapOption.names[22] = "TypeAndOrientation";
        MapOption.names[23] = "TrafficFlow";
        MapOption.names[24] = "Style";
        MapOption.names[25] = "AdditionalInfo";
    }
}

