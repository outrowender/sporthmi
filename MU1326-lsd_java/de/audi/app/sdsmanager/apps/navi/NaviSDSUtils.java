/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.navi;

import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.navi.NaviSDSHandler;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.nbest.IPicklist;
import de.audi.app.sdsmanager.nbest.IPicklistElement;
import de.audi.app.sdsmanager.nbest.IPicklistSlot;
import de.audi.app.sdsmanager.nbest.Picklist;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.i18n.ILanguageManager;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.interapp.NaviService$OneshotData;
import de.audi.atip.log.LogChannel;
import de.audi.atip.metrics.DateMetric;
import java.util.ArrayList;
import java.util.List;

public class NaviSDSUtils {
    public static final byte DESTINATION_TYPE_UNKNOWN;
    public static final byte DESTINATION_TYPE_CITY_ONESHOT;
    public static final byte DESTINATION_TYPE_CITY_STREET;
    public static final byte DESTINATION_TYPE_CITY_FOR_COUNTRY;
    public static final byte DESTINATION_TYPE_COUNTRY;
    public static final byte DESTINATION_TYPE_STATE;
    public static final byte DESTINATION_TYPE_CENTER;
    public static final byte DESTINATION_TYPE_HOUSENR;
    public static final byte DESTINATION_TYPE_JUNCTION;
    public static final byte DESTINATION_TYPE_LAST_DEST;
    public static final byte DESTINATION_TYPE_CITY_STREET_HOUSENUMBER;
    public static final byte DESTINATION_TYPE_POI;
    public static final byte DESTINATION_TYPE_CITY_FOR_STATE;
    public static final byte DESTINATION_TYPE_STREET_FOR_CITY;
    public static final byte DESTINATION_TYPE_STREET_FOR_CITY_REFINEMENT;
    public static final byte DESTINATION_TYPE_STREET;
    private static final byte DESTINATION_TYPE_STREET_FOR_COUNTRY;
    private static final byte DESTINATION_TYPE_STREET_FOR_VICINITY;
    public static final byte DESTINATION_TYPE_TOP_DEST;
    public static final byte DESTINATION_TYPE_ZIP_FOR_COUNTRY;
    public static final byte DESTINATION_TYPE_STATE_ONESHOT;
    public static final byte DESTINATION_TYPE_INTERSECTION;
    public static final byte DESTINATION_TYPE_CITY_FOR_STATE_ONESHOT;
    public static final byte DESTINATION_TYPE_POI_ONLINE;
    public static final byte DESTINATION_TYPE_POI_ONLINE_ONESHOT;
    public static final byte DESTINATION_TYPE_NAVIGATE_TO;
    public static final byte DESTINATION_TYPE_CITY_FOR_POI;
    public static final byte DESTINATION_TYPE_MY_AUDI_CONTACT;
    public static final byte DESTINATION_TYPE_STREET_HOUSENUMBER;
    public static final byte DESTINATION_TYPE_POI_CALL;
    public static final byte DESTINATION_TYPE_HN_PATTERNS_CNTW_PICKLIST;
    public static final byte DESTINATION_TYPE_HN_PATTERNS_CNTW_DIRECT;
    public static final byte DESTINATION_TYPE_PREFECTURE;
    public static final byte DESTINATION_TYPE_PLACENAME;
    public static final byte DESTINATION_TYPE_CHOME;
    public static final byte DESTINATION_TYPE_MAPCODE;
    public static final byte DESTINATION_TYPE_CONCIERGE_CALL;
    public static final byte DESTINATION_TYPE_PHONE_NUMBER;
    public static final byte DESTINATION_TYPE_PROVINCE_METRO;
    public static final byte DESTINATION_TYPE_WARD;
    public static final byte DESTINATION_TYPE_TOWN_STREET;
    public static final byte DESTINATION_TYPE_VILLAGE_STREET_FOR_SUBMUNICIPALTOWN;
    public static final byte DESTINATION_TYPE_MAP_CODE_SPECIAL_DEST;
    public static final byte DESTINATION_TYPE_PHONE_NUMBER_UNIQUE;
    public static final byte DESTINATION_TYPE_STREET_LAST_DEST;
    public static final byte DESTINATION_TYPE_POI_CALL_HISTORY_UNIQUE;
    public static final byte DESTINATION_TYPE_CITY_LAST_DEST;
    public static final byte DESTINATION_TYPE_PLACENAME_LAST_DEST;
    public static final byte DESTINATION_TYPE_GUI_TAKE_OVER;
    public static final byte DESTINATION_TYPE_ONESHOT_LEVEL_0;
    public static final byte DESTINATION_TYPE_ONESHOT_LEVEL_1;
    public static final byte DESTINATION_TYPE_ONESHOT_LEVEL_2;
    public static final byte DESTINATION_TYPE_ONESHOT_LEVEL_3;
    public static final byte DESTINATION_TYPE_ONESHOT_LEVEL_4;
    public static final byte DESTINATION_TYPE_ASIA_HN_INTERSECTION;
    public static final byte NAVI_LIST_MODE_NONE;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_FIRST_LEVEL;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_SECOND_LEVEL;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_THIRD_LEVEL;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_FOURTH_LEVEL;
    public static final byte NAVI_LIST_MODE_NAVI_CITY;
    public static final byte NAVI_LIST_MODE_NAVI_COUNTRY;
    public static final byte NAVI_LIST_MODE_NAVI_HOUSENUMBER;
    public static final byte NAVI_LIST_MODE_NAVI_INTERSECTION;
    public static final byte NAVI_LIST_MODE_NAVI_STREET;
    public static final int NAVI_LIST_MODE_NAVI_ZIP;
    public static final byte NAVI_LIST_MODE_NAVI_STATE;
    public static final byte NAVI_LIST_MODE_POI_PERSONAL_POI;
    public static final byte NAVI_LIST_MODE_NAVI_FAVORITES;
    public static final byte NAVI_LIST_MODE_POI;
    public static final byte NAVI_LIST_MODE_NAVI_LAST_DESTINATIONS;
    public static final int NAVI_LIST_MODE_POI_TYPE;
    public static final byte NAVI_LIST_MODE_NAVI_ALL_IN_ONESHOT;
    public static final byte NAVI_LIST_MODE_POI_ONESHOT_POI;
    public static final byte NAVI_LIST_MODE_POI_ONESHOT_CITY;
    public static final byte NAVI_LIST_MODE_MY_AUDI_CONTACTS;
    public static final byte NAVI_LIST_MODE_MY_AUDI_CONTACT_DETAILS;
    public static final byte NAVI_LIST_MODE_NAVI_MAP_SHOW_DETAILS_GENERIC_SDS_MAIN;
    public static final byte NAVI_LIST_MODE_NAVI_SEARCH_AREA_COUNTRY_CITY;
    public static final byte NAVI_LIST_MODE_NAVI_PP_ONE_DEST;
    public static final byte NAVI_LIST_MODE_NAVI_PP_TWO_DEST;
    public static final byte NAVI_LIST_MODE_POI_TYPE_ONESHOT;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_SECOND_LEVEL_ONLY;
    public static final byte NAVI_LIST_MODE_NAVI_PP_DEMOMODE;
    public static final byte NAVI_LIST_MODE_NAVI_HN_INTERSECTION_CNTW;
    public static final byte NAVI_LIST_MODE_NAVI_SEARCH_AREA_CITY_CNTW;
    public static final byte NAVI_LIST_MODE_POI_ONLINE;
    public static final byte NAVI_LIST_MODE_NAVI_STATE_ONESHOT;
    public static final byte NAVI_LIST_MODE_NAVI_HN_PATTERNS_CNTW;
    public static final byte NAVI_LIST_MODE_NAVI_PREFECTURE_JP;
    public static final byte NAVI_LIST_MODE_NAVI_PLACENAME_JP;
    public static final byte NAVI_LIST_MODE_NAVI_CHOME_JP;
    public static final byte NAVI_LIST_MODE_NAVI_ONESHOT_FIFTH_LEVEL;
    public static final byte NAVI_LIST_MODE_NAVI_SEARCH_AREA_CITY_JP;
    public static final byte NAVI_LIST_MODE_NAVI_MAP_CODE_JP;
    public static final byte NAVI_LIST_MODE_NAVI_PROVINCE_METRO_KR;
    public static final byte NAVI_LIST_MODE_NAVI_CITY_WARD_COUNTY_KR;
    public static final byte NAVI_LIST_MODE_NAVI_WARD_JP;
    public static final byte NAVI_LIST_MODE_NAVI_TOWN_STREET_KR;
    public static final byte NAVI_LIST_MODE_NAVI_GENERAL_WARD_KR;
    public static final byte NAVI_LIST_MODE_NAVI_VILLAGE_STREET_KR;
    public static final byte NAVI_LIST_MODE_NAVI_DEST_SDS_OPT_SEARCH_AREA_CITY_KR;
    public static final byte NAVI_TITLE_CITY;
    public static final byte NAVI_TITLE_COUNTRY;
    public static final byte NAVI_TITLE_STREET;
    public static final byte NAVI_TITLE_ZIP;
    public static final byte NAVI_TITLE_FAVORITES;
    public static final byte NAVI_TITLE_LAST_DESTINATIONS;
    public static final byte NAVI_TITLE_MY_AUDI;
    public static final byte NAVI_TITLE_HOUSENUMBER;
    public static final byte NAVI_TITLE_HN_INTERSECTION;
    public static final byte NAVI_TITLE_STATE;
    public static final byte NAVI_TITLE_HOUSENUMBER_PATTERNS;
    public static final byte NAVI_TITLE_PREFECTURE;
    public static final byte NAVI_TITLE_PLACENAME;
    public static final byte NAVI_TITLE_CHOME;
    public static final byte NAVI_TITLE_PROVINCE_METRO;
    public static final byte NAVI_TITLE_CITY_WARD_COUNTY;
    public static final byte NAVI_TITLE_WARD_JP;
    public static final byte NAVI_TITLE_TOWN_STREET;
    public static final byte NAVI_TITLE_GENERAL_WARD_KR;
    public static final byte NAVI_TITLE_VILLAGE_STREET_KR;
    public static final byte NAVI_TITLE_POI_TYPE;
    public static final byte NAVI_TITLE_POI_PERSONAL;
    public static final byte NAVI_TITLE_POI;
    public static final byte NAVI_TITLE_AI1;
    private static final byte POI_AREA_CURRENT_POSITION;
    private static final byte POI_AREA_ON_ROUTE;
    private static final byte POI_AREA_OTHER_COUNTRY;
    private static final byte POI_AREA_OTHER_TOWN;
    private static final byte POI_AREA_STOPOVER_POSITION;
    private static final byte POI_AREA_TARGET_POSITION;
    public static final byte NAVI_SOURCE_NBEST;
    public static final byte NAVI_SOURCE_LINE_SELECTION;
    public static final byte NAVI_SOURCE_PRIVATE_SELECTION;
    public static final byte NAVI_SOURCE_BUSINESS_SELECTION;
    public static final byte NAVI_INPUT_MODE_NONE;
    public static final byte NAVI_INPUT_MODE_ADDRESS;
    public static final byte NAVI_INPUT_MODE_LASTDEST;
    public static final byte NAVI_INPUT_MODE_FAVORITE;
    public static final byte NAVI_INPUT_MODE_NAVIGATETO;
    public static final byte NAVI_INPUT_MODE_HOME;
    public static final byte NAVI_INPUT_MODE_ONE_SHOT;
    public static final byte NAVI_INPUT_MODE_ADDRESS_ONLINE_POI;
    public static final byte NAVI_INPUT_MODE_INTELLIDEST;
    public static final byte NAVI_INPUT_MODE_OFFICE;
    public static final byte NAVI_STOPOVER_INDEX_NEXT_STOPOVER;
    public static final byte NAVI_STOPOVER_INDEX_BEFORE_DESTINATION;
    public static final byte OPERATORCALL_POI_CALL;
    public static final byte OPERATORCALL_POI_CALL_TRANSMIT;
    public static final byte OPERATORCALL_POI_CALL_PRIVACY;
    public static final byte OPERATORCALL_CONCIERGE_CALL;
    private static final byte[][] destTypeToNaviDestType;
    public static final byte[][] oneshotListModeToDataLevel;
    public static final int[][] listMode2PopupMappingID;
    public static final int[][] SDSStopoverIndexToNaviStopoverIndex;
    public static final int[][] operatorCallServiceType2dsiServiceType;
    private static final int[][] naviServiceToGenericSDSResult;
    private static final int[][] naviServiceToSDSResult;
    public static final byte[][] poiAreaToPOIOnlineSearchArea;
    public static final byte[][] poiAreaToPOISearchArea;
    private static final byte[][] destTypeToInputMode;

    public static int getNaviDestType(byte by) {
        byte by2 = SDSUtils.translate(by, destTypeToNaviDestType);
        return by2 == -128 ? -1 : (int)by2;
    }

    public static boolean isPOIPicklistMode(byte by) {
        return by == 15 || by == 17 || by == 13;
    }

    public static boolean isOneshotPickListMode(byte by) {
        return by == 0 || by == 1 || by == 28 || by == 2 || by == 3 || by == 38;
    }

    public static boolean isPoiOnshotPickListMode(byte by) {
        return by == 19 || by == 20 || by == 27;
    }

    public static int getGenericSDSResult(byte by) {
        int n = SDSUtils.translate((int)by, naviServiceToGenericSDSResult);
        return n == 128 ? 3001 : n;
    }

    public static int getSDSResult(byte by) {
        int n = SDSUtils.translate((int)by, naviServiceToSDSResult);
        return n == 128 ? 1100742656 : n;
    }

    public static int getSDSResult(byte by, byte by2) {
        switch (by) {
            case 0: {
                switch (by2) {
                    case 0: {
                        return 3000;
                    }
                    case 1: {
                        return 3004;
                    }
                }
                return 3001;
            }
        }
        return 3001;
    }

    public static boolean isOneShotActive(byte by) {
        return by == 10 || by == 2 || by == 1 || by == 22 || by == 100 || by == 101 || by == 102 || by == 103 || by == 104;
    }

    public static int handlePOIOnlineReplyCode(LogChannel logChannel, byte by, String string) {
        logChannel.log(-2137614336, "[%1#handlePOIOnlineReplyCode] replyCode=%2", (Object)string, (long)by);
        switch (by) {
            case 0: {
                return 1083965440;
            }
            case 1: {
                return 1100742656;
            }
        }
        logChannel.log(-1601830656, "[%1#handlePOIOnlineReplyCode] Illegal replyCode %2, sending ERROR!", (Object)string, (long)by);
        return 1100742656;
    }

    public static int handlePOIOnlineReplyCodeSDS(LogChannel logChannel, byte by, String string) {
        logChannel.log(-2137614336, "%1#handlePOIOnlineReplyCode: replyCode=%2", (Object)string, (long)by);
        switch (by) {
            case 0: {
                return 1083965440;
            }
            case 1: {
                return 1100742656;
            }
            case 2: {
                return 1184628736;
            }
        }
        logChannel.log(-1601830656, "%1#handlePOIOnlineReplyCode: Illegal replyCode %2, sending ERROR!", (Object)string, (long)by);
        return 1100742656;
    }

    public static String formatTimeString(DateMetric dateMetric, ILanguageManager iLanguageManager, IFrameworkAccess iFrameworkAccess, LogChannel logChannel) {
        String string = iLanguageManager.getCurrentLanguage("LANG_COMPONENT_TTS").getLanguageCode();
        logChannel.log(-2137614336, "NaviSDSUtils#formatTimeString: langShortcut=%1!", (Object)string);
        boolean bl = false;
        bl = iFrameworkAccess.isAsia() ? DateMetric.timeFormat == 11 : "en_GB".equals(string) || "en_US".equals(string) || "es_ES".equals(string) || "es_MX".equals(string);
        logChannel.log(-2137614336, "NaviSDSUtils#formatTimeString: usesAMPMFormat=%1!", bl);
        return bl ? dateMetric.format(0, 11, 0, true) : dateMetric.format(1, 10, 0, true);
    }

    static IPicklist thinOutHousenumberEntryPicklist(IPicklist iPicklist, String[] stringArray, int n, LogChannel logChannel) {
        Object[] objectArray;
        int n2;
        logChannel.log(-2137614336, "NaviSDSUtils#thinOutHousenumberEntryPicklist: filterStrings=%1", (Object)stringArray);
        ArrayList arrayList = new ArrayList();
        int n3 = iPicklist.getSize();
        int n4 = 0;
        for (n2 = 0; n2 < n3; ++n2) {
            objectArray = iPicklist.get(n2);
            if (objectArray == null) {
                logChannel.log(-1601830656, "NaviSDSUtils#thinOutHousenumberEntryPicklist: Empty curElement!");
                continue;
            }
            IPicklistSlot[] iPicklistSlotArray = objectArray.getSlots();
            boolean bl = SDSUtils.matchFilterStrings(stringArray, iPicklistSlotArray);
            logChannel.log(-2137614336, "NaviSDSUtils#thinOutHousenumberEntryPicklist: %1 entry #%2!", (Object)(bl ? "Matching" : "Mismatch for"), (long)n2);
            if (!bl) continue;
            n4 += NaviSDSUtils.storeMatchingHousenumberElement((IPicklistElement)objectArray, iPicklistSlotArray[n], arrayList, logChannel);
        }
        n2 = arrayList.size();
        if (n2 == 1 && n4 > 0) {
            logChannel.log(-2137614336, "NaviSDSUtils#thinOutHousenumberEntryPicklist: 1 matching entry, but it is empty -> return empty list!");
            return new Picklist(new IPicklistElement[0]);
        }
        objectArray = (IPicklistElement[])arrayList.toArray(new IPicklistElement[n2]);
        logChannel.log(-2137614336, "NaviSDSUtils#thinOutHousenumberEntryPicklist: matchingSize=%2, matchingElements=%3!", (Object)SDSUtils.toString(objectArray, false), (long)n2);
        return new Picklist((IPicklistElement[])objectArray);
    }

    private static int storeMatchingHousenumberElement(IPicklistElement iPicklistElement, IPicklistSlot iPicklistSlot, List list, LogChannel logChannel) {
        logChannel.log(-2137614336, "NaviSDSUtils#storeMatchingHousenumberElement: called");
        int n = 0;
        if (iPicklistSlot == null || SDSUtils.isEmpty(iPicklistSlot.getText())) {
            logChannel.log(-2137614336, "NaviSDSUtils#storeMatchingHousenumberElement: Empty house number slot found!");
            ++n;
        }
        SDSUtils.addToMatchingEntries(iPicklistElement, iPicklistSlot, list, logChannel);
        return n;
    }

    public static void resetVDEData(int n, NaviSDSHandler naviSDSHandler) {
        SDSModelAccess.setNaviDestinationTypeModel(n);
        switch (n) {
            case 2: 
            case 13: 
            case 15: 
            case 19: {
                SDSModelAccess.setOneshotStreetLabel("");
            }
            case 7: {
                SDSModelAccess.setOneshotPoiLabel("");
                SDSModelAccess.setOneshotHouseNRLabel("");
                break;
            }
            default: {
                SDSModelAccess.setOneshotCityLabel("");
                SDSModelAccess.setOneshotPoiLabel("");
                SDSModelAccess.setOneshotStreetLabel("");
                SDSModelAccess.setOneshotHouseNRLabel("");
            }
        }
    }

    public static void setInputStartedMode(byte by, NaviSDSHandler naviSDSHandler, LogChannel logChannel) {
        byte by2 = SDSUtils.translate(by, destTypeToInputMode);
        if (by2 == -128) {
            logChannel.log(-2137614336, "[NaviSDSUtils#setInputStartedMode] DestinationTypeID %1 => assuming address or POI input!", (long)by);
            by2 = 1;
        }
        logChannel.log(-2137614336, "[NaviSDSUtils#setInputStartedMode] inputMode=%1!", (long)by2);
        naviSDSHandler.setSDSAddressInputMode(by2);
    }

    public static boolean storeOneshotData(LogChannel logChannel, IPicklistElement iPicklistElement, byte by, NaviSDSHandler naviSDSHandler) {
        logChannel.log(-2137614336, "NaviSDSUtils#storeOneshotData: picklistMode=%1", (long)by);
        byte by2 = SDSUtils.translate(by, oneshotListModeToDataLevel);
        logChannel.log(-2137614336, "NaviSDSUtils#storeOneshotData: oneshotLevel=%1!", (long)by2);
        if (by2 == -128) {
            logChannel.log(-2137614336, "NaviSDSUtils#storeOneshotData: Oneshot not active => NOP!");
            return true;
        }
        logChannel.log(-2137614336, "%1#storeOneshotData: element=%1, picklistMode=%2", (Object)iPicklistElement, (long)by);
        Object[] objectArray = iPicklistElement.getSlots();
        if (SDSUtils.isEmpty(objectArray)) {
            logChannel.log(-1601830656, "NaviSDSUtils#storeOneshotData: Empty slots!");
            return false;
        }
        Object object = objectArray[0];
        if (object == null) {
            logChannel.log(-1601830656, "NaviSDSUtils#storeOneshotData: Empty first slot!");
            return false;
        }
        String string = object.getText();
        long l = object.getObjID();
        String string2 = object.getObjectStringID();
        logChannel.log(-2137614336, "NaviSDSUtils#storeOneshotData: slotText=%1, stringID=%2, objID=%3!", (Object)string, (Object)string2, l);
        naviSDSHandler.setOneshotData(new NaviService$OneshotData(string, string2, l), by2);
        return true;
    }

    public static void updateMapCodeModels(NaviService naviService) {
        String string = naviService.getCurrentMapCode();
        String string2 = naviService.getLastValidMapCodeBlock();
        String string3 = "";
        int n = string.indexOf(42);
        if (n != -1) {
            string3 = string.substring(n + 1);
        }
        SDSModelAccess.setNaviMapCodeModel(string);
        SDSModelAccess.setNaviMapCodeLastSequenceModel(string2);
        SDSModelAccess.setNaviMapCodeAfterStarModel(string3);
    }

    public static void updateNaviPhoneNumberModels(NaviService naviService) {
        SDSModelAccess.setNaviPhoneNumberChoiceModel(naviService.getCurrentTelephoneNumber().length());
        SDSModelAccess.setNaviLastPhoneNumberSequenceLabelModel(naviService.getLastValidTelephoneNumberBlock());
    }

    static {
        destTypeToNaviDestType = new byte[][]{{3, 1}, {4, 0}, {5, 7}, {6, 4}, {7, 3}, {21, 5}, {13, 2}, {14, 2}, {16, 2}, {17, 2}, {15, 2}, {19, 6}, {10, 8}, {28, 2}, {1, 8}, {2, 8}, {9, 9}, {11, 10}, {12, 21}, {22, 21}, {20, 0}, {32, 17}, {33, 12}, {34, 13}, {35, 19}, {37, 20}, {38, 18}, {39, 14}, {40, 11}, {41, 15}, {42, 19}, {44, 2}, {46, 1}, {47, 12}};
        oneshotListModeToDataLevel = new byte[][]{{0, 0}, {1, 0}, {2, 1}, {3, 2}, {19, 0}, {27, 0}, {20, 1}};
        listMode2PopupMappingID = new int[][]{{4, 40}, {1, 40}, {6, 40}, {0, 40}, {7, 40}, {2, 40}, {3, 40}, {38, 40}, {8, 40}, {9, 40}, {11, 40}, {14, 40}, {16, 40}, {30, 40}, {13, 40}, {17, 41}, {15, 43}, {18, 42}, {19, 41}, {27, 41}, {20, 40}, {21, 40}, {22, 44}, {23, 45}, {24, 46}, {25, 47}, {26, 48}, {29, 49}, {31, 50}, {12, 40}, {33, 40}, {34, 40}, {35, 40}, {36, 40}, {37, 40}, {39, 51}, {41, 40}, {42, 40}, {43, 40}, {44, 40}, {45, 40}, {46, 40}, {47, 52}};
        SDSStopoverIndexToNaviStopoverIndex = new int[][]{{-1, -1}, {-2, -2}};
        operatorCallServiceType2dsiServiceType = new int[][]{{0, 2}, {1, 2}, {2, 2}, {3, 1}};
        naviServiceToGenericSDSResult = new int[][]{{0, 3000}, {1, 3001}, {2, 3005}, {3, 3004}};
        naviServiceToSDSResult = new int[][]{{0, 1083965440}, {1, 1100742656}, {3, 1184628736}};
        poiAreaToPOIOnlineSearchArea = new byte[][]{{0, 0}, {5, 1}, {3, 2}, {4, 6}};
        poiAreaToPOISearchArea = new byte[][]{{0, 1}, {5, 2}, {2, 5}, {1, 3}, {3, 4}, {4, 6}};
        destTypeToInputMode = new byte[][]{{9, 2}, {18, 3}, {10, 6}, {2, 6}, {1, 6}, {22, 6}, {23, 4}, {24, 4}, {27, 4}};
    }
}

