/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.intercommunication;

import de.esolutions.fw.util.commons.Buffer;

public interface MixedListConstants {
    public static final int SHOW = 1;
    public static final int HIDE = 2;
    public static final int UPDATE_1 = 3;
    public static final int UPDATE_2 = 4;
    public static final int UPDATE_3 = 5;
    public static final int UPDATE_ALL = 6;
    public static final int REMOVE_1 = 7;
    public static final int REMOVE_2 = 8;
    public static final int REMOVE_3 = 9;
    public static final int INSERT_1 = 10;
    public static final int INSERT_2 = 11;
    public static final int INSERT_3 = 12;
    public static final int NO_CONTENT = -1;
    public static final int FORMAT_TURN = 0;
    public static final int FORMAT_POI = 1;
    public static final int FORMAT_TMC = 2;
    public static final int FORMAT_ROUTE_CALC = 3;
    public static final int FORMAT_LAST_EXIT_WARNING = 4;
    public static final int FORMAT_VZA_PREVIEW = 5;
    public static final int FORMAT_BORDER_PASSING_TOP = 6;
    public static final int FORMAT_BORDER_PASSING_BOTTOM = 7;
    public static final int FORMAT_BORDER_PASSING_SINGLE_BOX = 8;
    public static final int FORMAT_PICTURE_NAV_TOP = 9;
    public static final int FORMAT_PICTURE_NAV_BOTTOM = 10;
    public static final int FORMAT_ROAD_SEGMENT = 11;
    public static final int FORMAT_RCCI_ROUTE_CHANGE = 12;
    public static final int FORMAT_RCCI_ROUTE_CHANGE_EXPIRY = 13;
    public static final int FORMAT_RCCI_SAME_ROUTE = 14;
    public static final int FORMAT_RCCI_SAME_ROUTE_EXPIRY = 15;
    public static final int FORMAT_DESTINATION = 16;
    public static final int FORMAT_PICTURE_NAV_SINGLE = 17;
    public static final int FORMAT_TMC_CAR2X = 18;
    public static final int FORMAT_ADB_CONTACT_DESTINATION = 19;
    public static final int FORMAT_STOPOVER = 20;
    public static final int FORMAT_FLOW_TO_TEC = 21;
    public static final int FORMAT_TMC_ASIA = 22;
    public static final int FORMAT_LANE_GUIDANCE1 = 70;
    public static final int FORMAT_LANE_GUIDANCE2 = 71;
    public static final int FORMAT_GENERAL_EVENT1 = 73;
    public static final int FORMAT_GENERAL_EVENT2 = 74;
    public static final int FORMAT_PARKING_AREA = 75;
    public static final int FORMAT_ASIA_ROUTE_CRITERIA_VIOLATION = 80;
    public static final int FORMAT_ASIA_CLOSED_ROAD = 81;
    public static final int FORMAT_ASIA_DESTINATION1 = 82;
    public static final int FORMAT_ASIA_DESTINATION2 = 83;
    public static final int FORMAT_ASIA_FERRY = 84;
    public static final int FORMAT_ASIA_MANEUVER_MOTORWAY_ROAD = 88;
    public static final int FORMAT_ASIA_MANEUVER_NORMAL_ROAD = 0;
    public static final int FORMAT_ASIA_OFFROAD_WARNING = 89;
    public static final int FORMAT_ASIA_REST_AREA = 1;
    public static final int FORMAT_ASIA_SAIGARO = 90;
    public static final int FORMAT_ASIA_TIME_RESTRICTION = 91;
    public static final int FORMAT_ASIA_ETC_LANE_INFO = 92;
    public static final int FORMAT_ASIA_MOTORWAY_ENTRANCE_ARROW = 93;
    public static final int FORMAT_ASIA_MOTORWAY_IC_ARROW = 94;
    public static final int FORMAT_ASIA_MOTORWAY_SAPA_ARROW = 95;
    public static final int FORMAT_ASIA_MOTORWAY_JCT_ARROW = 96;
    public static final int FORMAT_ASIA_TOLL_PAYMENT_GATE = 97;
    public static final int POS_FORMAT = 0;
    public static final int POS_RCCI_EVENT_NR = 1;
    public static final int POS_RCCI_DISTANCE_TO_EVENT = 2;
    public static final int POS_RCCI_DIRECTION = 3;
    public static final int POS_RCCI_EVENT_TEXT = 4;
    public static final int POS_RCCI_DELTA_ETA_OLD_ROUTE = 5;
    public static final int POS_RCCI_DELTA_ETA_DISTANCE_NEW_ROUTE = 6;
    public static final int POS_RCCI_DELTA_ETA_DISTANCE_OLD_ROUTE = 7;
    public static final int POS_RCCI_NEW_ETA = 8;
    public static final int POS_RCCI_MAX_COLUMNS = 9;
    public static final int CELL_FORMAT = 0;
    public static final int CELL_TMC_EVENT_ICON = 1;
    public static final int CELL_TMC_ROAD_ICON = 2;
    public static final int CELL_TMC_EVENT_TEXT = 3;
    public static final int CELL_TMC_DISTANCE = 4;
    public static final int CELL_POI_ICON_1 = 5;
    public static final int CELL_POI_ICON_2 = 6;
    public static final int CELL_POI_ICON_3 = 7;
    public static final int CELL_POI_ICON_4 = 8;
    public static final int CELL_POI_ICON_5 = 9;
    public static final int CELL_POI_ICON_6 = 10;
    public static final int CELL_POI_NAME = 11;
    public static final int CELL_POI_DISTANCE = 12;
    public static final int CELL_POI_ETA = 13;
    public static final int CELL_TURN_ARROW_1 = 14;
    public static final int CELL_TURN_ROAD_ATTRIBUTE_1 = 15;
    public static final int CELL_TURN_ROAD_ATTRIBUTE_2 = 16;
    public static final int CELL_TURN_ROAD_ATTRIBUTE_3 = 17;
    public static final int CELL_TURN_ROAD_NAME = 18;
    public static final int CELL_TURN_DISTANCE = 19;
    public static final int CELL_TURN_ARROW = 20;
    public static final int CELL_TURN_ROAD_ICON = 21;
    public static final int CELL_CALCULATING = 22;
    public static final int CELL_TMC_EVENT_LENGTH = 23;
    public static final int CELL_EXIT_SIGN = 24;
    public static final int CELL_BORDER_CROSSING_TEXT_PASSING = 25;
    public static final int CELL_BORDER_CROSSING_DISTANCE = 26;
    public static final int CELL_BORDER_CROSSING_COUNTRY_FLAG = 27;
    public static final int CELL_BORDER_CROSSING_TEXT_ALLOWED_VELOCITY_1 = 28;
    public static final int CELL_BORDER_CROSSING_TEXT_ALLOWED_VELOCITY_2 = 29;
    public static final int CELL_BORDER_CROSSING_ROADCLASS_ICON_1 = 30;
    public static final int CELL_BORDER_CROSSING_ROADCLASS_ICON_2 = 31;
    public static final int CELL_BORDER_CROSSING_ROADCLASS_ICON_3 = 32;
    public static final int CELL_BORDER_CROSSING_ROADCLASS_ICON_4 = 33;
    public static final int CELL_BORDER_CROSSING_SPEED_ICON_1 = 34;
    public static final int CELL_BORDER_CROSSING_SPEED_ICON_2 = 35;
    public static final int CELL_BORDER_CROSSING_SPEED_ICON_3 = 36;
    public static final int CELL_BORDER_CROSSING_SPEED_ICON_4 = 37;
    public static final int CELL_BORDER_CROSSING_TEXT_SPEED_UNIT = 38;
    public static final int CELL_VZA_PREVIEW_DISTANCE = 39;
    public static final int CELL_VZA_PREVIEW_ICON = 40;
    public static final int CELL_LAST_EXIT_TEXT_LAST_EXIT = 41;
    public static final int CELL_LAST_EXIT_TEXT_TYPE = 42;
    public static final int CELL_LAST_EXIT_DISTANCE = 43;
    public static final int CELL_LAST_EXIT_TYPE_ICON = 44;
    public static final int CELL_DESTINATION_IMAGE = 45;
    public static final int CELL_TURN_REAL_TURN = 46;
    public static final int CELL_DISTANCE_TO_DEST = 47;
    public static final int CELL_UNIFIER_ID = 48;
    public static final int CELL_ROAD_DIRECTION_TEXT = 49;
    public static final int CELL_WIDGET_DATA = 50;
    public static final int CELL_DISTANCE_TEXT = 51;
    public static final int CELL_ETA_TEXT = 52;
    public static final int CELL_ADB_CONTACT_IMAGE = 53;
    public static final int CELL_PRIMARY_TEXT = 54;
    public static final int CELL_SECONDARY_TEXT = 55;
    public static final int CELL_KANBAN_IMAGE = 56;
    public static final int CELL_KANBAN_ROAD_ICON = 57;
    public static final int CELL_TURN_ROAD_NAME_2 = 58;
    public static final int CELL_KANBAN_BACKGROUND = 59;
    public static final int CELL_TOLL_GATE_INFO = 60;
    public static final int CELL_LANE_GUIDANCE = 61;
    public static final int CELL_DISTANCE = 62;
    public static final int CELL_ETA = 63;
    public static final int CELL_STOPOVER_NUM = 64;
    public static final int CELL_DELAY_ON_ROUTE = 65;
    public static final int CELL_TMC_EVENT_CAUSE = 66;
    public static final int CELL_TMC_ROAD_NAME = 67;
    public static final int CELL_TRAFFIC_LIGHT_ICON = 68;
    public static final int MIXEDLIST_LENGTH = 69;
    public static final int W140 = 0;
    public static final int W140_CONTENT0 = 1;
    public static final int W140_CONTENT1 = 2;
    public static final int W140_CONTENT2 = 3;
    public static final int W140_CONTENT3 = 4;
    public static final int W140_FOOTER_CONTENT = 5;
    public static final int POS0 = 0;
    public static final int POS1 = 1;
    public static final int POS2 = 2;
    public static final int POS3 = 3;
    public static final int LANE_TYPE_UNKNOWN = 0;
    public static final int LANE_TYPE_DEDICATED = 1;
    public static final int LANE_TYPE_ETC_AND_GENERAL_COMBINED = 2;
    public static final int LANE_TYPE_GENERAL_ONLY = 3;
    public static final int LANE_TYPE_LANE_OMIT = 4;
    public static final int LANE_TYPE_LANE_CLOSED = 5;
    public static final int LANE_TYPE_LANE_THROUGH = 6;

    public static class LaneArrow {
        public static final int COLOR_GRAY = 0;
        public static final int COLOR_BLUE = 1;
        public static final int STRAIGHT1 = 0;
        public static final int UTURN2 = 1;
        public static final int LEFT_ONLY2 = 2;
        public static final int LEFT_AND_RIGHT2 = 3;
        public static final int RIGHT_ONLY2 = 4;
        public static final int UTURN3 = 5;
        public static final int LEFT_ONLY3 = 6;
        public static final int LEFT_AND_RIGHT3 = 7;
        public static final int RIGHT_ONLY3 = 8;
        public static final int DIRECTION0_LEFT_HAND_TRAFFIC = 0;
        public static final int DIRECTION1 = 1;
        public static final int DIRECTION3 = 2;
        public static final int DIRECTION4 = 3;
        public static final int DIRECTION5 = 4;
        public static final int DIRECTION7 = 5;
        public static final int DIRECTION8_LEFT_HAND_TRAFFIC = 6;
        public static final int DIRECTION9 = 7;
        public static final int DIRECTION11 = 8;
        public static final int DIRECTION12 = 9;
        public static final int DIRECTION13 = 10;
        public static final int DIRECTION15 = 11;
        public static final int DIRECTION8_RIGHT_HAND_TRAFFIC = 12;
        public static final int DIRECTION0_RIGHT_HAND_TRAFFIC = 13;
        public int combinationOfCurve;
        public int directionOfArrow;
        public int color;

        public LaneArrow(int n, int n2, int n3) {
            this.combinationOfCurve = n;
            this.directionOfArrow = n2;
            this.color = n3;
        }

        public boolean equals(Object object) {
            if (object instanceof LaneArrow) {
                LaneArrow laneArrow = (LaneArrow)object;
                if (this.combinationOfCurve != laneArrow.combinationOfCurve) {
                    return false;
                }
                if (this.directionOfArrow != laneArrow.directionOfArrow) {
                    return false;
                }
                return this.color == laneArrow.color;
            }
            return false;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("combinationOfCurve = ");
            buffer.append(this.combinationOfCurve);
            buffer.append(", directionOfArrow = ");
            buffer.append(this.directionOfArrow);
            buffer.append(", color = ");
            buffer.append(this.color);
            return buffer.toString();
        }
    }

    public static class LaneGuidance {
        public static final int MAX_LANE_COUNT = 6;
        private LaneArrowCombined[] directionArrow = null;

        public LaneArrowCombined[] getDirectionArrow() {
            return this.directionArrow;
        }

        public void setDirectionArrow(LaneArrowCombined[] laneArrowCombinedArray) {
            this.directionArrow = laneArrowCombinedArray;
        }

        public boolean equals(Object object) {
            if (object instanceof LaneGuidance) {
                LaneGuidance laneGuidance = (LaneGuidance)object;
                LaneArrowCombined[] laneArrowCombinedArray = laneGuidance.getDirectionArrow();
                if (this.directionArrow != null && laneArrowCombinedArray != null) {
                    if (this.directionArrow.length != laneArrowCombinedArray.length) {
                        return false;
                    }
                    for (int i2 = 0; i2 < this.directionArrow.length; ++i2) {
                        if (this.directionArrow[i2].equals(laneArrowCombinedArray[i2])) continue;
                        return false;
                    }
                    return true;
                }
                return this.directionArrow == null && laneArrowCombinedArray == null;
            }
            return false;
        }

        public String toString() {
            return "LaneGuidance[" + (this.directionArrow != null ? String.valueOf(this.directionArrow.length) : "null") + "]";
        }
    }

    public static class TollGateInfo {
        public static final int MAX_LANE_COUNT = 12;
        private TollgateType_enum[] tollGateTypes;

        public TollgateType_enum[] getTollGateTypes() {
            return this.tollGateTypes;
        }

        public void setTollGateTypes(TollgateType_enum[] tollgateType_enumArray) {
            this.tollGateTypes = tollgateType_enumArray;
        }

        public boolean equals(Object object) {
            if (object instanceof TollGateInfo) {
                TollGateInfo tollGateInfo = (TollGateInfo)object;
                if (this.tollGateTypes != null && tollGateInfo.tollGateTypes != null && this.tollGateTypes.length == tollGateInfo.tollGateTypes.length) {
                    for (int i2 = 0; i2 < this.tollGateTypes.length; ++i2) {
                        if (this.tollGateTypes[i2].equals(tollGateInfo.tollGateTypes[i2])) continue;
                        return false;
                    }
                    return true;
                }
            }
            return false;
        }
    }

    public static class LaneArrowCombined {
        public static final int MAX_ARROWS = 3;
        public static final int ARROW_TYPE_DOTS = 0;
        public static final int ARROW_TYPE_ARROW = 1;
        public static final int BACKGROUND_4CORNER = 0;
        public static final int BACKGROUND_5CORNER_RIGHT = 1;
        public static final int BACKGROUND_5CORNER_LEFT = 2;
        public LaneArrow[] arrows;
        public int background = 0;
        public int arrowType = 1;
        public boolean hasBlueArrow = false;

        public LaneArrowCombined(int n, int n2) {
            this.arrowType = n;
            this.background = n2;
        }

        public boolean equals(Object object) {
            if (object instanceof LaneArrowCombined) {
                LaneArrowCombined laneArrowCombined = (LaneArrowCombined)object;
                if (this.arrowType != laneArrowCombined.arrowType) {
                    return false;
                }
                if (this.background != laneArrowCombined.background) {
                    return false;
                }
                LaneArrow[] laneArrowArray = laneArrowCombined.arrows;
                if (this.arrows != null && laneArrowArray != null) {
                    for (int i2 = 0; i2 < this.arrows.length; ++i2) {
                        if (this.arrows[i2].equals(laneArrowArray[i2])) continue;
                        return false;
                    }
                    return true;
                }
                return this.arrows == null && laneArrowArray == null;
            }
            return false;
        }

        public String toString() {
            Buffer buffer = new Buffer();
            buffer.append("arrowType = ");
            buffer.append(this.arrowType);
            buffer.append(", background = ");
            buffer.append(this.background);
            if (this.arrows != null) {
                buffer.append(", ");
                buffer.append(this.arrows.length);
                buffer.append(" arrows as follows:\n");
                int n = 0;
                while (n < this.arrows.length) {
                    buffer.append("  -");
                    buffer.append(this.arrows[n].toString());
                    if (++n >= this.arrows.length) continue;
                    buffer.append("\n");
                }
            } else {
                buffer.append(", no arrows");
            }
            return buffer.toString();
        }
    }

    public static class TollgateType_enum {
        private int type;
        public static final TollgateType_enum ETC_UNKNOWN = new TollgateType_enum(0);
        public static final TollgateType_enum ETC_DEDICATED = new TollgateType_enum(1);
        public static final TollgateType_enum ETC_AND_GENERAL_COMBINED = new TollgateType_enum(2);
        public static final TollgateType_enum ETC_GENERAL_ONLY = new TollgateType_enum(3);
        public static final TollgateType_enum ETC_LANE_OMIT = new TollgateType_enum(4);
        public static final TollgateType_enum ETC_LANE_CLOSED = new TollgateType_enum(5);
        public static final TollgateType_enum ETC_LANE_THROUGH = new TollgateType_enum(6);

        public int getType() {
            return this.type;
        }

        private TollgateType_enum(int n) {
            this.type = n;
        }
    }
}

