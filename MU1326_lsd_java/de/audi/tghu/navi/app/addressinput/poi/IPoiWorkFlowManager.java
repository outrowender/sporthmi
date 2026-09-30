/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;

public interface IPoiWorkFlowManager {
    public static final String SELECTED_ELEMENT = "CurrentSelection";
    public static final String NAVLOCATION = "NavLocation";
    public static final Integer IS_HISTORY_ENTRY_YES = new Integer(1);
    public static final Integer IS_HISTORY_ENTRY_NO = new Integer(0);
    public static final String IS_HISTORY_ENTRY = "Is the currentSelection a History Entry";
    public static final String POI_SDS_UID = "selected poi UID";
    public static final String PENDING_WARNING_CATEGORY = "Pending Warning Category";
    public static final int POI_MAIN_SCREEN_BEGIN = 1;
    public static final int POI_MAIN_SCREEN_END = 100;
    public static final int POI_MAIN_SCREEN_LIST_TOP_POI_SELECTED = 1;
    public static final int POI_MAIN_SCREEN_BUTTON_CLASSES = 2;
    public static final int POI_MAIN_SCREEN_BUTTON_PERSONAL_POI = 3;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AREA = 4;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_BY_NAME = 5;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_ALONG_ROUTE = 6;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_NEARBY = 7;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AT_DESTINATION = 8;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_IN_CITY = 9;
    public static final int POI_MAIN_SCREEN_START = 10;
    public static final int POI_HYBRID_SEARCH_ASIA = 11;
    public static final int POI_ADD_AS_STOPOVER_POPUP_LEFT_WITH_HK_BACK = 12;
    public static final int POI_MAIN_SCREEN_START_WITH_HIDDEN_SEARCH_AREA = 13;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AT_STOPOVER = 14;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_BEGIN = 101;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_END = 200;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_LIST_SELECTED = 101;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_BEGIN = 201;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_END = 300;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_SEARCH_BY_NAME = 201;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_BRANDS = 202;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_LIST_SELECTED = 203;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_BEGIN = 301;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_END = 400;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_LIST_SELECTED = 301;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_PARENT_SELECTED_ASIA = 302;
    public static final int POI_CLASS_SCREEN_BEGIN = 401;
    public static final int POI_CLASS_SCREEN_END = 500;
    public static final int POI_CLASS_SCREEN_LIST_SELECTED = 401;
    public static final int POI_CLASS_SCREEN_SEARCH_BY_NAME = 402;
    public static final int POI_CLASS_SCREEN_START_CLASSES_WITH_NAVLOCATION = 403;
    public static final int POI_CATEGORY_SCREEN_BEGIN = 501;
    public static final int POI_CATEGORY_SCREEN_END = 600;
    public static final int POI_CATEGORY_SCREEN_SEARCH_BY_NAME = 501;
    public static final int POI_CATEGORY_SCREEN_ALL_RESULTS = 502;
    public static final int POI_CATEGORY_SCREEN_LIST_SELECTED = 503;
    public static final int POI_BRAND_SCREEN_BEGIN = 601;
    public static final int POI_BRAND_SCREEN_END = 700;
    public static final int POI_BRAND_SCREEN_LIST_SELECTED = 601;
    public static final int POI_BRAND_RESULT_SCREEN_NO_SPELLER_BEGIN = 701;
    public static final int POI_BRAND_RESULT_SCREEN_NO_SPELLER_END = 800;
    public static final int POI_BRAND_RESULT_SCREEN_LIST_SELECTED = 701;
    public static final int POI_BRAND_RESULT_SCREEN_SEARCH_BY_NAME = 702;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_SPELLER_BEGIN = 801;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_SPELLER_END = 900;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_MATCH_SPELLER_BEGIN = 901;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_MATCH_SPELLER_END = 1000;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_BEGIN = 1001;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_END = 1100;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_LIST_SELECTED = 1002;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_PARENT_SELECTED = 1003;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_BEGIN = 1101;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_END = 1200;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_LIST_SELECTED = 1102;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_BEGIN = 1201;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_END = 1300;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_LIST_SELECTED = 1202;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_SEARCH_BY_NAME = 1203;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_START_FROM_RIGHT_DRAWER = 1204;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_ALONG_ROUTE_START_FROM_RIGHT_DRAWER = 1205;
    public static final int POI_NEAR_DESTINATION_LEFT = 1206;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_BEGIN = 1301;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_END = 1400;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_LIST_SELECTED = 1302;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_AUTOSELECT = 1303;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_JUMP_FIVE_BACK_EVENT = 1304;
    public static final int POI_HYBRID_SEARCH_AREA_CITY_SCREEN_JUMP_FIVE_BACK_EVENT = 1305;
    public static final int POI_DETAIL_SCREEN_BEGIN = 1401;
    public static final int POI_DETAIL_SCREEN_END = 1500;
    public static final int POI_DETAIL_SCREEN_START_GUIDANCE_BUTTON = 1402;
    public static final int POI_SDS_BEGIN = 1501;
    public static final int POI_SDS_END = 1600;
    public static final int POI_SDS_SELECT_TOP_POI_BY_UID = 1502;
    public static final int POI_SDS_SELECT_POI_BY_UID = 1503;
    public static final int POI_FUEL_WARNING_SCREEN_BEGIN = 1601;
    public static final int POI_FUEL_WARNING_SCREEN_END = 1700;
    public static final int POI_FUEL_WARNING_SCREEN_LIST_SELECTED = 1602;
    public static final int POI_FUEL_WARNING_SCREEN_START = 1603;

    public CommandList handleWorkFlow(CommandList var1, int var2, PoiSearchArea var3, NavigationEnv var4);

    public void setSpellerScreenBreadcrumb(NavigationEnv var1, int var2);

    public int getSpellerScreenBreadcrumb(NavigationEnv var1);
}

