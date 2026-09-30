/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carseat;

public interface DSICarSeat {
    public static final String IPL_COMM_UUID = "976ded31-4347-5c8a-b0f7-4d6039c98f40";
    public static final String IPL_COMM_INTERFACE_KEY = "6624341b-1b4d-57c4-90da-cc721454ffbb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.11";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.11";

    public static interface Consts {
        public static final String VERSION = "2.11.11";
        public static final int SEATSPECIALPOSITIONS_NONE = 0;
        public static final int SEATSPECIALPOSITIONS_COMFORTVIEW = 1;
        public static final int SEATSPECIALPOSITIONS_SEATSYMMETRY = 2;
        public static final int SEATSPECIALPOSITIONS_NORMALPOSITION = 3;
        public static final int SEATSPECIALPOSITIONS_RELAXPOSITION = 4;
        public static final int SEATSPECIALPOSITIONS_BUSINESSPOSITION = 5;
        public static final int MEMORYDETAIL_MEMORY_NONE = 0;
        public static final int MEMORYDETAIL_ON_OFF_MEMORY_BLOCKED = 1;
        public static final int MEMORYDETAIL_ON_OFF_MEMORY_NOT_BLOCKED = 2;
        public static final int MEMORYDETAIL_SET_PRESS_PROGRAM = 3;
        public static final int MEMORYDETAIL_SET_PRESS_ON_OFF = 4;
        public static final int MEMORYDETAIL_PROGRAM_PRESS_ON_OFF = 5;
        public static final int MEMORYDETAIL_PROGRAM_PRESS_SET = 6;
        public static final int MEMORYDETAIL_PROGRAM_PRESS_PROGRAM = 7;
        public static final int MEMORYDETAIL_RADIOKEY_PRESS_PROGRAM = 8;
        public static final int SEATPOSITION_NO_SEAT = 0;
        public static final int SEATPOSITION_SEAT_1RL = 1;
        public static final int SEATPOSITION_SEAT_1RR = 2;
        public static final int SEATPOSITION_SEAT_2RL = 3;
        public static final int SEATPOSITION_SEAT_2RR = 4;
        public static final int SEATPOSITION_SEAT_3RL = 5;
        public static final int SEATPOSITION_SEAT_3RR = 6;
        public static final int SEATCONTENT_NONE = 0;
        public static final int SEATCONTENT_GURTHOEHE = 1;
        public static final int SEATCONTENT_LEHNENKOPF = 2;
        public static final int SEATCONTENT_LORDOSE = 3;
        public static final int SEATCONTENT_SEITENWANGEN = 4;
        public static final int SEATCONTENT_SITZTIEFE = 5;
        public static final int SEATCONTENT_MASSAGE = 6;
        public static final int SEATCONTENT_MEMORY = 7;
        public static final int SEATCONTENT_LEHNENWANGEN = 8;
        public static final int SEATCONTENT_SITZWANGEN = 9;
        public static final int SEATCONTENT_MENU = 10;
        public static final int SEATPNEUMATICCONTENT_NONE = 0;
        public static final int SEATPNEUMATICCONTENT_GURTHOEHE = 1;
        public static final int SEATPNEUMATICCONTENT_LEHNENKOPF = 2;
        public static final int SEATPNEUMATICCONTENT_LORDOSE = 3;
        public static final int SEATPNEUMATICCONTENT_SEITENWANGEN = 4;
        public static final int SEATPNEUMATICCONTENT_SITZTIEFE = 5;
        public static final int SEATPNEUMATICCONTENT_MASSAGE = 6;
        public static final int SEATADJUSTMENTPOSITION_NONE = 0;
        public static final int SEATADJUSTMENTPOSITION_INCREASE = 1;
        public static final int SEATADJUSTMENTPOSITION_DECREASE = 2;
        public static final int RESTSEATSTATUSMESSAGE_NONE = 0;
        public static final int RESTSEATSTATUSMESSAGE_CODRIVERSEAT_AT_RESTSEAT_POSITION = 1;
        public static final int RESTSEATSTATUSMESSAGE_DISPLAY_DOWN = 2;
        public static final int RESTSEATSTATUSMESSAGE_DISPLAY_OR_RESTSEAT_MOVING = 3;
        public static final String DEVICE_NAME = "DEVICE_NAME";
        public static final String DEVICE_INSTANCE = "DEVICE_INSTANCE";
    }
}

