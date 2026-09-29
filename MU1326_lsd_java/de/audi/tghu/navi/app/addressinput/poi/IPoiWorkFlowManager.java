/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.NavigationEnv;
import de.audi.tghu.navi.app.addressinput.poi.searcharea.PoiSearchArea;

public interface IPoiWorkFlowManager {
    public static final String SELECTED_ELEMENT;
    public static final String NAVLOCATION;
    public static final Integer IS_HISTORY_ENTRY_YES;
    public static final Integer IS_HISTORY_ENTRY_NO;
    public static final String IS_HISTORY_ENTRY;
    public static final String POI_SDS_UID;
    public static final String PENDING_WARNING_CATEGORY;
    public static final int POI_MAIN_SCREEN_BEGIN;
    public static final int POI_MAIN_SCREEN_END;
    public static final int POI_MAIN_SCREEN_LIST_TOP_POI_SELECTED;
    public static final int POI_MAIN_SCREEN_BUTTON_CLASSES;
    public static final int POI_MAIN_SCREEN_BUTTON_PERSONAL_POI;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AREA;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_BY_NAME;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_ALONG_ROUTE;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_NEARBY;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AT_DESTINATION;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_IN_CITY;
    public static final int POI_MAIN_SCREEN_START;
    public static final int POI_HYBRID_SEARCH_ASIA;
    public static final int POI_ADD_AS_STOPOVER_POPUP_LEFT_WITH_HK_BACK;
    public static final int POI_MAIN_SCREEN_START_WITH_HIDDEN_SEARCH_AREA;
    public static final int POI_MAIN_SCREEN_BUTTON_SEARCH_AT_STOPOVER;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_BEGIN;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_END;
    public static final int POI_RESULT_SCREEN_WITH_SPELLER_LIST_SELECTED;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_BEGIN;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_END;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_SEARCH_BY_NAME;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_BRANDS;
    public static final int POI_RESULT_SCREEN_NO_SPELLER_LIST_SELECTED;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_BEGIN;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_END;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_LIST_SELECTED;
    public static final int POI_RESULT_SCREEN_WITH_MATCH_SPELLER_PARENT_SELECTED_ASIA;
    public static final int POI_CLASS_SCREEN_BEGIN;
    public static final int POI_CLASS_SCREEN_END;
    public static final int POI_CLASS_SCREEN_LIST_SELECTED;
    public static final int POI_CLASS_SCREEN_SEARCH_BY_NAME;
    public static final int POI_CLASS_SCREEN_START_CLASSES_WITH_NAVLOCATION;
    public static final int POI_CATEGORY_SCREEN_BEGIN;
    public static final int POI_CATEGORY_SCREEN_END;
    public static final int POI_CATEGORY_SCREEN_SEARCH_BY_NAME;
    public static final int POI_CATEGORY_SCREEN_ALL_RESULTS;
    public static final int POI_CATEGORY_SCREEN_LIST_SELECTED;
    public static final int POI_BRAND_SCREEN_BEGIN;
    public static final int POI_BRAND_SCREEN_END;
    public static final int POI_BRAND_SCREEN_LIST_SELECTED;
    public static final int POI_BRAND_RESULT_SCREEN_NO_SPELLER_BEGIN;
    public static final int POI_BRAND_RESULT_SCREEN_NO_SPELLER_END;
    public static final int POI_BRAND_RESULT_SCREEN_LIST_SELECTED;
    public static final int POI_BRAND_RESULT_SCREEN_SEARCH_BY_NAME;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_SPELLER_BEGIN;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_SPELLER_END;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_MATCH_SPELLER_BEGIN;
    public static final int POI_BRAND_RESULT_SCREEN_WITH_MATCH_SPELLER_END;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_BEGIN;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_END;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_LIST_SELECTED;
    public static final int POI_PARENT_CHILD_CATEGORY_SCREEN_PARENT_SELECTED;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_BEGIN;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_END;
    public static final int POI_PARENT_CHILD_RESULT_SCREEN_LIST_SELECTED;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_BEGIN;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_END;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_LIST_SELECTED;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_SEARCH_BY_NAME;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_START_FROM_RIGHT_DRAWER;
    public static final int POI_PARKING_NEAR_DESTINATION_SCREEN_ALONG_ROUTE_START_FROM_RIGHT_DRAWER;
    public static final int POI_NEAR_DESTINATION_LEFT;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_BEGIN;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_END;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_LIST_SELECTED;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_AUTOSELECT;
    public static final int POI_SEARCH_AREA_CITY_SCREEN_JUMP_FIVE_BACK_EVENT;
    public static final int POI_HYBRID_SEARCH_AREA_CITY_SCREEN_JUMP_FIVE_BACK_EVENT;
    public static final int POI_DETAIL_SCREEN_BEGIN;
    public static final int POI_DETAIL_SCREEN_END;
    public static final int POI_DETAIL_SCREEN_START_GUIDANCE_BUTTON;
    public static final int POI_SDS_BEGIN;
    public static final int POI_SDS_END;
    public static final int POI_SDS_SELECT_TOP_POI_BY_UID;
    public static final int POI_SDS_SELECT_POI_BY_UID;
    public static final int POI_FUEL_WARNING_SCREEN_BEGIN;
    public static final int POI_FUEL_WARNING_SCREEN_END;
    public static final int POI_FUEL_WARNING_SCREEN_LIST_SELECTED;
    public static final int POI_FUEL_WARNING_SCREEN_START;

    default public CommandList handleWorkFlow(CommandList commandList, int n, PoiSearchArea poiSearchArea, NavigationEnv navigationEnv) {
    }

    default public void setSpellerScreenBreadcrumb(NavigationEnv navigationEnv, int n) {
    }

    default public int getSpellerScreenBreadcrumb(NavigationEnv navigationEnv) {
    }

    static {
        IS_HISTORY_ENTRY_YES = new Integer(1);
        IS_HISTORY_ENTRY_NO = new Integer(0);
    }
}

