/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.generated.navi;

import de.audi.app.bap.utils.IFunctionIDs;
import de.esolutions.fw.util.commons.Buffer;

public final class FunctionIDsNavi
implements IFunctionIDs {
    private static final String DESCRIPTION_BAP_CONFIG = "0x2 (BAP_CONFIG)";
    private static final String DESCRIPTION_FUNCTION_LIST = "0x3 (FUNCTION_LIST)";
    private static final String DESCRIPTION_FSG_OPERATION_STATE = "0xf (FSG_OPERATION_STATE)";
    private static final String DESCRIPTION_COMPASS_INFO = "0x10 (COMPASS_INFO)";
    private static final String DESCRIPTION_RG_STATUS = "0x11 (RG_STATUS)";
    private static final String DESCRIPTION_DISTANCE_TO_NEXT_MANEUVER = "0x12 (DISTANCE_TO_NEXT_MANEUVER)";
    private static final String DESCRIPTION_CURRENT_POSITION_INFO = "0x13 (CURRENT_POSITION_INFO)";
    private static final String DESCRIPTION_TURN_TO_INFO = "0x14 (TURN_TO_INFO)";
    private static final String DESCRIPTION_DISTANCE_TO_DESTINATION = "0x15 (DISTANCE_TO_DESTINATION)";
    private static final String DESCRIPTION_TIME_TO_DESTINATION = "0x16 (TIME_TO_DESTINATION)";
    private static final String DESCRIPTION_MANEUVER_DESCRIPTOR = "0x17 (MANEUVER_DESCRIPTOR)";
    private static final String DESCRIPTION_LANE_GUIDANCE = "0x18 (LANE_GUIDANCE)";
    private static final String DESCRIPTION_TM_CINFO = "0x19 (TM_CINFO)";
    private static final String DESCRIPTION_MAGNET_FIELD_ZONE = "0x1a (MAGNET_FIELD_ZONE)";
    private static final String DESCRIPTION_CALIBRATION = "0x1b (CALIBRATION)";
    private static final String DESCRIPTION_ASG_CAPABILITIES = "0x1c (ASG_CAPABILITIES)";
    private static final String DESCRIPTION_LAST_DEST_LIST = "0x1d (LAST_DEST_LIST)";
    private static final String DESCRIPTION_FAVORITE_DEST_LIST = "0x1e (FAVORITE_DEST_LIST)";
    private static final String DESCRIPTION_PREFERRED_DEST_LIST = "0x1f (PREFERRED_DEST_LIST)";
    private static final String DESCRIPTION_NAV_BOOK = "0x20 (NAV_BOOK)";
    private static final String DESCRIPTION_ADDRESS_LIST = "0x21 (ADDRESS_LIST)";
    private static final String DESCRIPTION_RG_ACT_DEACT = "0x22 (RG_ACT_DEACT)";
    private static final String DESCRIPTION_REPEAT_LAST_NAV_ANNOUNCEMENT = "0x23 (REPEAT_LAST_NAV_ANNOUNCEMENT)";
    private static final String DESCRIPTION_VOICE_GUIDANCE = "0x24 (VOICE_GUIDANCE)";
    private static final String DESCRIPTION_FUNCTION_SYNCHRONISATION = "0x25 (FUNCTION_SYNCHRONISATION)";
    private static final String DESCRIPTION_INFO_STATES = "0x26 (INFO_STATES)";
    private static final String DESCRIPTION_ACTIVE_RG_TYPE = "0x27 (ACTIVE_RG_TYPE)";
    private static final String DESCRIPTION_TRAFFIC_BLOCK_INDICATION = "0x28 (TRAFFIC_BLOCK_INDICATION)";
    private static final String DESCRIPTION_GET_NEXT_LIST_POS = "0x29 (GET_NEXT_LIST_POS)";
    private static final String DESCRIPTION_NB_SPELLER = "0x2a (NB_SPELLER)";
    private static final String DESCRIPTION_MAP_COLOR_AND_TYPE = "0x2b (MAP_COLOR_AND_TYPE)";
    private static final String DESCRIPTION_MAP_VIEW_AND_ORIENTATION = "0x2c (MAP_VIEW_AND_ORIENTATION)";
    private static final String DESCRIPTION_MAP_SCALE = "0x2d (MAP_SCALE)";
    private static final String DESCRIPTION_DESTINATION_INFO = "0x2e (DESTINATION_INFO)";
    private static final String DESCRIPTION_ALTITUDE = "0x2f (ALTITUDE)";
    private static final String DESCRIPTION_ONLINE_NAVIGATION_STATE = "0x30 (ONLINE_NAVIGATION_STATE)";
    private static final String DESCRIPTION_EXITVIEW = "0x31 (EXITVIEW)";
    private static final String DESCRIPTION_SEMIDYNAMIC_ROUTE_GUIDANCE = "0x32 (SEMIDYNAMIC_ROUTE_GUIDANCE)";
    private static final String DESCRIPTION_POI_SEARCH = "0x33 (POI_SEARCH)";
    private static final String DESCRIPTION_POI_LIST = "0x34 (POI_LIST)";
    private static final String DESCRIPTION_FSG_SETUP = "0x35 (FSG_SETUP)";
    private static final String DESCRIPTION_MAP_PRESENTATION = "0x36 (MAP_PRESENTATION)";
    private static final String DESCRIPTION_MANEUVER_STATE = "0x37 (MANEUVER_STATE)";
    private static final String DESCRIPTION_ETC_STATUS = "0x38 (ETC_STATUS)";
    private static final String FCT_ID_UNKNOWN = " (UNKNOWN)";

    public String getDescription(int n) {
        switch (n) {
            case 2: {
                return DESCRIPTION_BAP_CONFIG;
            }
            case 3: {
                return DESCRIPTION_FUNCTION_LIST;
            }
            case 15: {
                return DESCRIPTION_FSG_OPERATION_STATE;
            }
            case 16: {
                return DESCRIPTION_COMPASS_INFO;
            }
            case 17: {
                return DESCRIPTION_RG_STATUS;
            }
            case 18: {
                return DESCRIPTION_DISTANCE_TO_NEXT_MANEUVER;
            }
            case 19: {
                return DESCRIPTION_CURRENT_POSITION_INFO;
            }
            case 20: {
                return DESCRIPTION_TURN_TO_INFO;
            }
            case 21: {
                return DESCRIPTION_DISTANCE_TO_DESTINATION;
            }
            case 22: {
                return DESCRIPTION_TIME_TO_DESTINATION;
            }
            case 23: {
                return DESCRIPTION_MANEUVER_DESCRIPTOR;
            }
            case 24: {
                return DESCRIPTION_LANE_GUIDANCE;
            }
            case 25: {
                return DESCRIPTION_TM_CINFO;
            }
            case 26: {
                return DESCRIPTION_MAGNET_FIELD_ZONE;
            }
            case 27: {
                return DESCRIPTION_CALIBRATION;
            }
            case 28: {
                return DESCRIPTION_ASG_CAPABILITIES;
            }
            case 29: {
                return DESCRIPTION_LAST_DEST_LIST;
            }
            case 30: {
                return DESCRIPTION_FAVORITE_DEST_LIST;
            }
            case 31: {
                return DESCRIPTION_PREFERRED_DEST_LIST;
            }
            case 32: {
                return DESCRIPTION_NAV_BOOK;
            }
            case 33: {
                return DESCRIPTION_ADDRESS_LIST;
            }
            case 34: {
                return DESCRIPTION_RG_ACT_DEACT;
            }
            case 35: {
                return DESCRIPTION_REPEAT_LAST_NAV_ANNOUNCEMENT;
            }
            case 36: {
                return DESCRIPTION_VOICE_GUIDANCE;
            }
            case 37: {
                return DESCRIPTION_FUNCTION_SYNCHRONISATION;
            }
            case 38: {
                return DESCRIPTION_INFO_STATES;
            }
            case 39: {
                return DESCRIPTION_ACTIVE_RG_TYPE;
            }
            case 40: {
                return DESCRIPTION_TRAFFIC_BLOCK_INDICATION;
            }
            case 41: {
                return DESCRIPTION_GET_NEXT_LIST_POS;
            }
            case 42: {
                return DESCRIPTION_NB_SPELLER;
            }
            case 43: {
                return DESCRIPTION_MAP_COLOR_AND_TYPE;
            }
            case 44: {
                return DESCRIPTION_MAP_VIEW_AND_ORIENTATION;
            }
            case 45: {
                return DESCRIPTION_MAP_SCALE;
            }
            case 46: {
                return DESCRIPTION_DESTINATION_INFO;
            }
            case 47: {
                return DESCRIPTION_ALTITUDE;
            }
            case 48: {
                return DESCRIPTION_ONLINE_NAVIGATION_STATE;
            }
            case 49: {
                return DESCRIPTION_EXITVIEW;
            }
            case 50: {
                return DESCRIPTION_SEMIDYNAMIC_ROUTE_GUIDANCE;
            }
            case 51: {
                return DESCRIPTION_POI_SEARCH;
            }
            case 52: {
                return DESCRIPTION_POI_LIST;
            }
            case 53: {
                return DESCRIPTION_FSG_SETUP;
            }
            case 54: {
                return DESCRIPTION_MAP_PRESENTATION;
            }
            case 55: {
                return DESCRIPTION_MANEUVER_STATE;
            }
            case 56: {
                return DESCRIPTION_ETC_STATUS;
            }
        }
        Buffer buffer = new Buffer();
        buffer.append("0x");
        buffer.append(Integer.toHexString(n));
        buffer.append(FCT_ID_UNKNOWN);
        return buffer.toString();
    }
}

