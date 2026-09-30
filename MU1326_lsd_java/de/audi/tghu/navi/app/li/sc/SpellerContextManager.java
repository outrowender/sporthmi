/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.li.sc;

import de.audi.tghu.navi.app.li.sc.POISpellerContext;
import de.audi.tghu.navi.app.li.sc.SpellerContext;
import de.esolutions.fw.util.commons.Buffer;

public class SpellerContextManager {
    public static final int CTX_ERROR = -2;
    public static final int CTX_NONE = -1;
    public static final int CTX_DEFAULT = 0;
    public static final int CTX_STREETFIRST = 1;
    public static final int CTX_STREETREFINEMENT = 2;
    public static final int CTX_ZIPCENTER = 3;
    public static final int CTX_POI_SDS_RESULT_LIST_SCREEN = 4;
    public static final int CTX_POIPARENTCHILD = 5;
    public static final int CTX_HOUSENUMBER_FIRST = 6;
    public static final int CTX_JUNCTION_FIRST = 7;
    public static final int CTX_POI_MAIN_SCREEN = 8;
    public static final int CTX_POI_RESULT_SCREEN_WITH_SPELLER = 9;
    public static final int CTX_POI_RESULT_SCREEN_NO_SPELLER = 10;
    public static final int CTX_POI_RESULT_SCREEN_WITH_MATCHSPELLER = 11;
    public static final int CTX_POI_CLASS_SCREEN = 12;
    public static final int CTX_POI_CATEGORY_SCREEN = 13;
    public static final int CTX_POI_BRAND_SCREEN = 14;
    public static final int CTX_POI_BRAND_RESULT_SCREEN_NO_SPELLER = 15;
    public static final int CTX_POI_PARKING_NEAR_DESTINATION = 16;
    public static final int CTX_POI_SEARCH_AREA_CITY_SCREEN = 17;
    public static final int CTX_POI_DETAIL_SCREEN = 18;
    public static final int CTX_DI_EU_MAIN_SCREEN = 19;
    public static final int CTX_DI_EU_COUNTRY_SCREEN = 20;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN = 21;
    public static final int CTX_DI_EU_STREET_SCREEN = 22;
    public static final int CTX_DI_EU_HOUSENUMBER_SCREEN = 23;
    public static final int CTX_DI_EU_JUNCTION_SCREEN = 24;
    public static final int CTX_DI_EU_REFINEMENT_SCREEN = 25;
    public static final int CTX_DI_CN_MAIN_SCREEN = 26;
    public static final int CTX_DI_CN_CITY_ZIP_SCREEN = 27;
    public static final int CTX_DI_CN_LOCATION_SCREEN = 28;
    public static final int CTX_DI_CN_STREET_SCREEN = 29;
    public static final int CTX_DI_CN_HOUSENUMBER_SCREEN = 30;
    public static final int CTX_DI_CN_INTERSECTION_SCREEN = 31;
    public static final int CTX_DI_JP_MAIN_SCREEN = 32;
    public static final int CTX_DI_JP_PREFECTURE_SCREEN = 33;
    public static final int CTX_DI_JP_CITY_SCREEN = 34;
    public static final int CTX_DI_JP_FACILITY_SCREEN = 35;
    public static final int CTX_DI_JP_PLACENAME_SCREEN = 36;
    public static final int CTX_DI_JP_CHOME_SCREEN = 37;
    public static final int CTX_DI_JP_HOUSENUMBER_SCREEN = 38;
    public static final int CTX_DI_JP_WARD_SCREEN = 39;
    public static final int CTX_DI_KR_MAIN_SCREEN = 40;
    public static final int CTX_DI_KR_PROVINCE_SCREEN = 41;
    public static final int CTX_DI_KR_CITY_SCREEN = 42;
    public static final int CTX_DI_KR_WARD_SCREEN = 43;
    public static final int CTX_DI_KR_FACILITY_SCREEN = 44;
    public static final int CTX_DI_KR_VILLAGESTREET_SCREEN = 45;
    public static final int CTX_DI_KR_TOWNSTREET_SCREEN = 46;
    public static final int CTX_DI_KR_NUMBER_SCREEN = 47;
    public static final int CTX_DI_EU_MAIN_SCREEN_FOR_ONLINE = 48;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN_FOR_ONLINE = 49;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN_HISTORY = 50;
    public static final int CTX_DI_EU_AUTOSELECT_AFTER_CHAR_ADDED = 51;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN_AUTOSELECT = 52;
    public static final int CTX_DI_EU_STREET_FOLLOW_INTERSECTION_SCREEN = 53;
    public static final int CTX_POI_MAP_STACK = 54;
    public static final int CTX_POI_PARKING_ALONG_ROUTE = 55;
    public static final int CTX_DI_EU_STREET_SCREEN_SELECTED = 56;
    public static final int CTX_DI_NAR_MAIN_SCREEN = 57;
    public static final int CTX_DI_NAR_COUNTRY_SCREEN = 58;
    public static final int CTX_DI_NAR_CITY_SCREEN = 59;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN_FOR_ONLINE = 60;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN_HISTORY_ELEMENT_SELECTED = 61;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN_AUTOSELECT = 62;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN = 63;
    public static final int CTX_DI_NAR_STREET_SCREEN = 64;
    public static final int CTX_DI_NAR_STREET_FIRST_SCREEN = 65;
    public static final int CTX_DI_NAR_STREET_SCREEN_SELECTED = 66;
    public static final int CTX_DI_MAP_CODE_SCREEN = 67;
    public static final int CTX_DI_TELEPHONE_NUMBER_SCREEN = 68;
    public static final int CTX_DI_NAR_CITY_ZIP_REFINEMENT_SCREEN_SELECTED = 69;
    public static final int CTX_DI_NAR_HOUSENUMBER_SCREEN = 70;
    public static final int CTX_DI_NAR_INTERSECTION_SCREEN = 71;
    public static final int CTX_DI_NAR_STREET_REFINEMENT_SCREEN_SELECTED = 72;
    public static final int CTX_POI_FUEL_WARNING = 73;
    public static final int CTX_DI_NAR_HOUSENUMBER_FIRST_SCREEN = 74;
    public static final int CTX_DI_EU_MAIN_SCREEN_FOR_REMOTE_HMI = 75;
    public static final int CTX_DI_NAR_MAIN_SCREEN_FOR_ONLINE = 76;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN_FOR_REMOTE_HMI = 77;
    public static final int CTX_DI_CN_MAIN_SCREEN_FOR_ONLINE = 78;
    public static final int CTX_DI_JP_MAIN_SCREEN_FOR_ONLINE = 79;
    public static final int CTX_DI_KR_MAIN_SCREEN_FOR_ONLINE = 80;
    public static final int CTX_DI_CN_MAIN_SCREEN_FOR_REMOTE_HMI = 81;
    public static final int CTX_DI_JP_MAIN_SCREEN_FOR_REMOTE_HMI = 82;
    public static final int CTX_DI_KR_MAIN_SCREEN_FOR_REMOTE_HMI = 83;
    public static final int CTX_DI_CN_CITY_SCREEN_FOR_ONLINE = 84;
    public static final int CTX_DI_CN_CITY_SCREEN_FOR_REMOTE_HMI = 85;
    public static final int CTX_DI_CN_STREET_SCREEN_FOR_ONLINE = 86;
    public static final int CTX_DI_CN_STREET_SCREEN_FOR_REMOTE_HMI = 87;
    public static final int CTX_DI_NAR_STREET_SCREEN_HISTORY_SELECTED = 88;
    public static final int CTX_DI_JP_PREFECTURE_SCREEN_FOR_ONLINE = 89;
    public static final int CTX_DI_JP_PREFECTURE_SCREEN_FOR_REMOTE_HMI = 90;
    public static final int CTX_DI_JP_CITY_SCREEN_FOR_ONLINE = 91;
    public static final int CTX_DI_JP_CITY_SCREEN_FOR_REMOTE_HMI = 92;
    public static final int CTX_DI_JP_WARD_SCREEN_FOR_ONLINE = 93;
    public static final int CTX_DI_JP_WARD_SCREEN_FOR_REMOTE_HMI = 94;
    public static final int CTX_DI_JP_PLACENAME_SCREEN_FOR_ONLINE = 95;
    public static final int CTX_DI_JP_CHOME_SCREEN_FOR_ONLINE = 96;
    public static final int CTX_DI_KR_TOWNSTREET_SCREEN_FOR_ONLINE = 97;
    public static final int CTX_DI_KR_TOWNSTREET_SCREEN_FOR_REMOTE_HMI = 98;
    public static final int CTX_DI_NAR_COUNTRY_SCREEN_FOR_REMOTE_HMI = 99;
    public static final int CTX_DI_CN_STREET_FOLLOW_INTERSECTION_SCREEN = 101;
    public static final int CTX_DI_NAR_MAIN_SCREEN_FOR_REMOTE_HMI = 102;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN_FOR_REMOTE_HMI = 103;
    public static final int CTX_DI_EU_COUNTRY_SCREEN_FOR_REMOTE_HMI = 104;
    public static final int CTX_POI_MAIN_SCREEN_WITH_HIDDEN_SEARCH_AREA = 105;
    public static final int CTX_DI_NAR_CITY_ZIP_SCREEN_ELEMENT_SELECTED = 106;
    public static final int CTX_DI_NAR_INTERSECTION_SCREEN_ELEMENT_SELECTED = 107;
    public static final int CTX_DI_EU_CITY_ZIP_SCREEN_ELEMENT_SELECTED = 108;
    public static final int CTX_TPEG_POI_MAIN_SCREEN = 109;
    public static final int CTX_TPEG_POI_RESULT_LIST_SCREEN = 110;
    public static final int CTX_TPEG_POI_AVAILABILITY_CHECK = 122;
    public static final int CTX_POI_SDS_RESULT_DETAIL_SCREEN = 111;
    public static final int CTX_DI_SDS = 112;
    public static final int CTX_POI_SEARCH_AREA_ASIA_HYBRID_SEARCH = 113;
    public static final int CTX_PERSONALPOI_CATEGORY_SCREEN = 114;
    public static final int CTX_PERSONALPOI_RESULT_SCREEN_NO_SPELLER_ALL_RESULTS = 115;
    public static final int CTX_SDS_STARTED = 116;
    public static final int CTX_POI_FUEL_WARNING_ALONG_ROUTE = 117;
    public static final int CTX_POI_FUEL_WARNING_VICINITY = 118;
    public static final int CTX_POI_SEARCH_AT_ROUTE_STOPOVER = 119;
    public static final int CTX_PHONENUMBER_INPUT_DETAIL_SCREEN = 120;
    public static final int CTX_START_GUIDANCE = 121;
    private static final int FIRST_CTX = -2;
    private static final int LAST_CTX = 122;
    private static SpellerContext[] spellerContexts = new SpellerContext[123];

    public static SpellerContext getSpellerContext(int n) {
        SpellerContext spellerContext;
        if (n < -2 || 122 < n) {
            spellerContext = null;
        } else {
            spellerContext = spellerContexts[n];
            if (spellerContext == null) {
                switch (n) {
                    case 4: 
                    case 5: {
                        spellerContext = new POISpellerContext(n);
                        break;
                    }
                    default: {
                        spellerContext = new SpellerContext(n);
                    }
                }
                SpellerContextManager.spellerContexts[n] = spellerContext;
            }
        }
        return spellerContext;
    }

    public static String contextIDToString(int n) {
        switch (n) {
            case -2: {
                return "CTX_ERROR";
            }
            case -1: {
                return "CTX_NONE";
            }
            case 0: {
                return "CTX_DEFAULT";
            }
            case 1: {
                return "CTX_STREETFIRST";
            }
            case 2: {
                return "CTX_STREETREFINEMENT";
            }
            case 3: {
                return "CTX_ZIPCENTER";
            }
            case 4: {
                return "CTX_POI_SDS_RESULT_LIST_SCREEN";
            }
            case 5: {
                return "CTX_POIPARENTCHILD";
            }
            case 6: {
                return "CTX_HOUSENUMBER_FIRST";
            }
            case 7: {
                return "CTX_JUNCTION_FIRST";
            }
            case 8: {
                return "CTX_POI_MAIN_SCREEN";
            }
            case 105: {
                return "CTX_POI_MAIN_SCREEN_WITH_HIDDEN_SEARCH_AREA";
            }
            case 9: {
                return "CTX_POI_RESULT_SCREEN_WITH_SPELLER";
            }
            case 10: {
                return "CTX_POI_RESULT_SCREEN_NO_SPELLER";
            }
            case 115: {
                return "CTX_PERSONALPOI_RESULT_SCREEN_NO_SPELLER_ALL_RESULTS";
            }
            case 11: {
                return "CTX_POI_RESULT_SCREEN_WITH_MATCHSPELLER";
            }
            case 12: {
                return "CTX_POI_CLASS_SCREEN";
            }
            case 13: {
                return "CTX_POI_CATEGORY_SCREEN";
            }
            case 114: {
                return "CTX_PERSONALPOI_CATEGORY_SCREEN";
            }
            case 14: {
                return "CTX_POI_BRAND_SCREEN";
            }
            case 15: {
                return "CTX_POI_BRAND_RESULT_SCREEN_NO_SPELLER";
            }
            case 16: {
                return "CTX_POI_PARKING_NEAR_DESTINATION";
            }
            case 17: {
                return "CTX_POI_SEARCH_AREA_CITY_SCREEN";
            }
            case 18: {
                return "CTX_POI_DETAIL_SCREEN";
            }
            case 55: {
                return "CTX_POI_PARKING_ALONG_ROUTE";
            }
            case 56: {
                return "CTX_DI_EU_STREET_SCREEN_SELECTED";
            }
            case 57: {
                return "CTX_DI_NAR_MAIN_SCREEN";
            }
            case 58: {
                return "CTX_DI_NAR_COUNTRY_SCREEN";
            }
            case 59: {
                return "CTX_DI_NAR_CITY_SCREEN";
            }
            case 60: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_FOR_ONLINE";
            }
            case 103: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_FOR_REMOTE_HMI";
            }
            case 61: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_HISTORY_ELEMENT_SELECTED";
            }
            case 62: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_AUTOSELECT";
            }
            case 63: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_";
            }
            case 64: {
                return "CTX_DI_NAR_STREET_SCREEN";
            }
            case 65: {
                return "CTX_DI_NAR_STREET_FIRST_SCREEN";
            }
            case 66: {
                return "CTX_DI_NAR_STREET_SCREEN_SELECTED";
            }
            case 69: {
                return "CTX_DI_NAR_CITY_ZIP_REFINEMENT_SCREEN_SELECTED";
            }
            case 71: {
                return "CTX_DI_NAR_INTERSECTION_SCREEN";
            }
            case 70: {
                return "CTX_DI_NAR_HOUSENUMBER_SCREEN";
            }
            case 72: {
                return "CTX_DI_NAR_STREET_REFINEMENT_SCREEN_SELECTED";
            }
            case 73: {
                return "CTX_POI_FUEL_WARNING";
            }
            case 74: {
                return "CTX_DI_NAR_HOUSENUMBER_FIRST_SCREEN";
            }
            case 75: {
                return "CTX_DI_EU_MAIN_SCREEN_FOR_REMOTE_HMI";
            }
            case 76: {
                return "CTX_DI_NAR_MAIN_SCREEN_FOR_ONLINE";
            }
            case 102: {
                return "CTX_DI_NAR_MAIN_SCREEN_FOR_REMOTE_HMI";
            }
            case 77: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN_FOR_REMOTE_HMI";
            }
            case 88: {
                return "CTX_DI_NAR_STREET_SCREEN_HISTORY_SELECTED";
            }
            case 106: {
                return "CTX_DI_NAR_CITY_ZIP_SCREEN_ELEMENT_SELECTED";
            }
            case 107: {
                return "CTX_DI_NAR_INTERSECTION_SCREEN_ELEMENT_SELECTED";
            }
            case 112: {
                return "CTX_DI_SDS";
            }
            case 19: {
                return "CTX_DI_EU_MAIN_SCREEN";
            }
            case 20: {
                return "CTX_DI_EU_COUNTRY_SCREEN";
            }
            case 21: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN";
            }
            case 22: {
                return "CTX_DI_EU_STREET_SCREEN";
            }
            case 23: {
                return "CTX_DI_EU_HOUSENUMBER_SCREEN";
            }
            case 24: {
                return "CTX_DI_EU_JUNCTION_SCREEN";
            }
            case 25: {
                return "CTX_DI_EU_REFINEMENT_SCREEN";
            }
            case 48: {
                return "CTX_DI_EU_MAIN_SCREEN_FOR_ONLINE";
            }
            case 49: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN_FOR_ONLINE";
            }
            case 50: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN_HISTORY";
            }
            case 51: {
                return "CTX_DI_EU_AUTOSELECT_AFTER_CHAR_ADDED";
            }
            case 52: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN_AUTOSELECT";
            }
            case 53: {
                return "CTX_DI_EU_STREET_FOLLOW_INTERSECTION_SCREEN";
            }
            case 54: {
                return "CTX_POI_MAP_STACK";
            }
            case 26: {
                return "CTX_DI_CN_MAIN_SCREEN";
            }
            case 27: {
                return "CTX_DI_CN_CITY_ZIP_SCREEN";
            }
            case 28: {
                return "CTX_DI_CN_LOCATION_SCREEN";
            }
            case 29: {
                return "CTX_DI_CN_STREET_SCREEN";
            }
            case 30: {
                return "CTX_DI_CN_HOUSENUMBER_SCREEN";
            }
            case 31: {
                return "CTX_DI_CN_INTERSECTION_SCREEN";
            }
            case 32: {
                return "CTX_DI_JP_MAIN_SCREEN";
            }
            case 33: {
                return "CTX_DI_JP_PREFECTURE_SCREEN";
            }
            case 34: {
                return "CTX_DI_JP_CITY_SCREEN";
            }
            case 35: {
                return "CTX_DI_JP_FACILITY_SCREEN";
            }
            case 36: {
                return "CTX_DI_JP_PLACENAME_SCREEN";
            }
            case 37: {
                return "CTX_DI_JP_CHOME_SCREEN";
            }
            case 38: {
                return "CTX_DI_JP_HOUSENUMBER_SCREEN";
            }
            case 39: {
                return "CTX_DI_JP_WARD_SCREEN";
            }
            case 40: {
                return "CTX_DI_KR_MAIN_SCREEN";
            }
            case 41: {
                return "CTX_DI_KR_PROVINCE_SCREEN";
            }
            case 42: {
                return "CTX_DI_KR_CITY_SCREEN";
            }
            case 43: {
                return "CTX_DI_KR_WARD_SCREEN";
            }
            case 44: {
                return "CTX_DI_KR_FACILITY_SCREEN";
            }
            case 46: {
                return "CTX_DI_KR_TOWNSTREET_SCREEN";
            }
            case 47: {
                return "CTX_DI_KR_NUMBER_SCREEN";
            }
            case 45: {
                return "CTX_DI_KR_VILLAGESTREET_SCREEN";
            }
            case 116: {
                return "CTX_SDS_STARTED";
            }
            case 67: {
                return "CTX_DI_MAP_CODE_SCREEN";
            }
            case 68: {
                return "CTX_DI_TELEPHONE_NUMBER_SCREEN";
            }
            case 78: {
                return "CTX_DI_CN_MAIN_SCREEN_FOR_ONLINE";
            }
            case 79: {
                return "CTX_DI_JP_MAIN_SCREEN_FOR_ONLINE";
            }
            case 80: {
                return "CTX_DI_KR_MAIN_SCREEN_FOR_ONLINE";
            }
            case 81: {
                return "CTX_DI_CN_MAIN_SCREEN_FOR_REMOTE_HMI";
            }
            case 82: {
                return "CTX_DI_JP_MAIN_SCREEN_FOR_REMOTE_HMI";
            }
            case 83: {
                return "CTX_DI_KR_MAIN_SCREEN_FOR_REMOTE_HMI";
            }
            case 84: {
                return "CTX_DI_CN_CITY_SCREEN_FOR_ONLINE";
            }
            case 85: {
                return "CTX_DI_CN_CITY_SCREEN_FOR_REMOTE_HMI";
            }
            case 86: {
                return "CTX_DI_CN_STREET_SCREEN_FOR_ONLINE";
            }
            case 87: {
                return "CTX_DI_CN_STREET_SCREEN_FOR_REMOTE_HMI";
            }
            case 101: {
                return "CTX_DI_CN_STREET_FOLLOW_INTERSECTION_SCREEN";
            }
            case 89: {
                return "CTX_DI_JP_PREFECTURE_SCREEN_FOR_ONLINE";
            }
            case 90: {
                return "CTX_DI_JP_PREFECTURE_SCREEN_FOR_REMOTE_HMI";
            }
            case 91: {
                return "CTX_DI_JP_CITY_SCREEN_FOR_ONLINE";
            }
            case 92: {
                return "CTX_DI_JP_CITY_SCREEN_FOR_REMOTE_HMI";
            }
            case 93: {
                return "CTX_DI_JP_WARD_SCREEN_FOR_ONLINE";
            }
            case 94: {
                return "CTX_DI_JP_WARD_SCREEN_FOR_REMOTE_HMI";
            }
            case 95: {
                return "CTX_DI_JP_PLACENAME_SCREEN_FOR_ONLINE";
            }
            case 96: {
                return "CTX_DI_JP_CHOME_SCREEN_FOR_ONLINE";
            }
            case 108: {
                return "CTX_DI_EU_CITY_ZIP_SCREEN_ELEMENT_SELECTED";
            }
            case 109: {
                return "CTX_TPEG_POI_MAIN_SCREEN";
            }
            case 110: {
                return "CTX_TPEG_POI_RESULT_LIST_SCREEN";
            }
            case 97: {
                return "CTX_DI_KR_TOWNSTREET_SCREEN_FOR_ONLINE";
            }
            case 98: {
                return "CTX_DI_KR_TOWNSTREET_SCREEN_FOR_REMOTE_HMI";
            }
            case 104: {
                return "CTX_DI_EU_COUNTRY_SCREEN_FOR_REMOTE_HMI";
            }
            case 111: {
                return "CTX_POI_SDS_RESULT_DETAIL_SCREEN";
            }
            case 113: {
                return "CTX_POI_SEARCH_AREA_ASIA_HYBRID_SEARCH";
            }
            case 117: {
                return "CTX_POI_FUEL_WARNING_ALONG_ROUTE";
            }
            case 118: {
                return "CTX_POI_FUEL_WARNING_VICINITY";
            }
            case 119: {
                return "CTX_POI_SEARCH_AT_ROUTE_STOPOVER";
            }
            case 120: {
                return "CTX_PHONENUMBER_INPUT_DETAIL_SCREEN";
            }
            case 121: {
                return "CTX_START_GUIDANCE";
            }
            case 122: {
                return "CTX_TPEG_POI_AVAILABILITY_CHECK";
            }
        }
        return "CTX_UNKNOWN";
    }

    public static void reset() {
        for (int i2 = 0; i2 < spellerContexts.length; ++i2) {
            if (spellerContexts[i2] == null) continue;
            spellerContexts[i2].reset();
        }
    }

    public static String printStatus() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < spellerContexts.length; ++i2) {
            if (spellerContexts[i2] == null) continue;
            buffer.append(spellerContexts[i2].printStatus()).append('\n');
        }
        return buffer.toString();
    }
}

