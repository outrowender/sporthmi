/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.constants;

public class MapOption {
    public static final int S_AutoZoom;
    public static final int S_Color;
    public static final int S_3DBuilding;
    public static final int S_3DLandmarks;
    public static final int S_Type;
    public static final int S_Orientation;
    public static final int S_SpeedAndFlow;
    public static final int S_OnlineTraffic;
    public static final int S_RoadClass;
    public static final int S_BrandIconStyle;
    public static final int S_CrossingView;
    public static final int S_TmcSymbols;
    public static final int S_WeatherIcons;
    public static final int S_Range;
    public static final int S_PicNav;
    public static final int S_Google3DCityModel;
    public static final int S_Pois;
    public static final int S_PoiCategories;
    public static final int S_TrafficEventNoticeMap;
    public static final int S_UncrowdedRoad;
    public static final int S_Favorites;
    public static final int S_EtaMode;
    public static final int C_TypeAndOrientation;
    public static final int C_TrafficFlow;
    public static final int C_Style;
    public static final int C_AdditionalInfo;
    public static final int MaxCount;
    public static final String Unknown;
    private static String[] names;

    public static String getName(int n) {
        if (n < 0 || names.length <= n) {
            return "Unknown";
        }
        return names[n];
    }

    static {
        names = new String[26];
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

