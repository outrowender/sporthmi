/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

public interface Reason {
    public static final int NULL = -1;

    public static interface EnterMap {
        public static final int NONE = -1;
        public static final int HK_NAVI = 0;
        public static final int BTN_SHOW_IN_MAP = 1;
        public static final int BTN_SHOW_IN_MAP_FROM_ONLINE_SEARCH = 2;
        public static final int BTN_SHOW_IN_MAP_FROM_REMOTE_HMI = 3;
        public static final int BTN_ENTER_RUBBERBAND = 4;
        public static final int FROM_LEFT_DRAWER = 5;
        public static final int SHOW_TMC = 6;
        public static final int MOVE_PREVIEW_MAP = 7;
        public static final int BTN_SHOW_IN_MAP_FROM_OPERATOR_CALL = 8;
        public static final int BTN_SHOW_DESTINATION_FROM_TOUR = 9;
        public static final int BTN_SHOW_LOCATION_FROM_DEST = 10;
        public static final int BTN_PNAV_ROUTE_SELECTED = 11;
    }

    public static interface AdditionalInfo {
        public static final int NoReason = 0;
    }
}

