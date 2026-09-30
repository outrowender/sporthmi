/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

public final class TMCConst {
    public static int INITIAL_ANCHOR_ID = -1;
    public static final long[] INITIAL_WINDOW = new long[]{INITIAL_ANCHOR_ID};
    public static int WINDOW_REQUEST_SIZE = 20;
    public static int OFFSET_OFF = 0;
    public static final int OFFSET_INIT = 0;
    public static final int OFFSET_NORMAL = 21;
    public static int UPPER_BARRIER = 18;
    public static int LOWER_BARRIER = 12;
    static final int LAST_ENTERED_VIEW_NONE = 0;
    static final int LAST_ENTERED_VIEW_DETAIL = 1;
    static final int LAST_ENTERED_VIEW_OVERVIEW = 2;
    static final int LAST_ENTERED_VIEW_DETAIL_READOUT = 3;
    static final int LAST_ENTERED_VIEW_OVERVIEW_READOUT = 4;
    static final int LAST_ENTERED_VIEW_MAP = 5;
    static final int LAST_ENTERED_VIEW_MAP_READOUT = 6;
    static final int LAST_ENTERED_VIEW_MAP_BREAKFAST = 7;
    private static final String SYSTEM_PROPERTY_TMC_WINDOW_SIZE = "TmcWindowSize";
    static final String SYSTEM_PROPERTY_USING_TWO_TMC_WINDOWS = "TwoTmcWindows";
    static final String SYSTEM_PROPERTY_NO_TMC_READ_OUT = "NoTmcReadOut";
    public static final long UPDATE_DISTANCE_TIMESPAN = 10000L;
    public static final int ROWS_PER_SCREEN = 6;
    public static final String LOGCH_MAIN = "App.TMC.Main";
    public static final String LOGCH_LIST = "App.TMC.List";
    public static final String LOGCH_HMI = "App.TMC.HMI";
    public static final String LOGCH_DSI = "App.TMC.DSI";
    public static final String LOGCH_HELPER = "App.TMC.Helper";
    public static final int WINDOW_OVERVIEW_LIST = 0;
    public static final int WINDOW_RSE_TMC_LIST_LEFT = 1;
    public static final int WINDOW_RSE_TMC_LIST_RIGHT = 2;
    public static final int WINDOW_READ_OUT_LIST = 3;
    public static final int WINDOW_MAX_SIZE = 4;
    public static final String[] WINDOW_NAMES;
    public static final int INFO_SETTINGS_NAV_TMC = 1;
    public static final int INFO_SETTINGS_DEC = 2;
    public static final int INFO_SETTINGS_TP = 3;
    public static final int ICON_ONE_DIRECTION = 0;
    public static final int ICON_BI_DIRECTION = 1;
    public static final int ICON_NONE = -1;
    public static final int TMC_READ_OUT_ON = 0;
    public static final int TMC_READ_OUT_OFF = 1;
    public static final int TMC_READ_OUT_ON_ROUTE = 2;
    static final int AUTOMATIC_REDIRECTION_OFF = 1;
    static final int AUTOMATIC_REDIRECTION_ON = 0;
    static final int ANNOUNCEMENT_DURING_TEL_ON = 0;
    static final int ANNOUNCEMENT_DURING_TEL_OFF = 1;
    static final int DISABLE_NEXT_BUTTON = 0;
    static final int ENABLE_NEXT_BUTTON = 1;
    static final int ENABLE_SK_IN_MAP = 0;
    static final int DISABLE_SK_IN_MAP = 1;
    static final int ENABLE_SK_READ_OUT = 0;
    static final int DISABLE_SK_READ_OUT = 1;
    public static final long POINT_LOCATION_FLAG = Long.MIN_VALUE;
    static final int COMBI_TMC_READ_OUT_ACTIVE = 1;
    static final int COMBI_TMC_READ_OUT_INACTIVE = 0;
    static final int FOLDER_STATE_TOPLEVEL = 0;
    static final int FOLDER_STATE_CLOSED = 1;
    static final int FOLDER_STATE_OPENED = 2;
    static final int FOLDER_STATE_CHILD = 3;

    static {
        String string = System.getProperty(SYSTEM_PROPERTY_TMC_WINDOW_SIZE);
        if (string != null) {
            try {
                int n;
                WINDOW_REQUEST_SIZE = n = Integer.parseInt(string);
                OFFSET_OFF = (WINDOW_REQUEST_SIZE - 2 * WINDOW_REQUEST_SIZE) / 2;
                LOWER_BARRIER = (int)((float)WINDOW_REQUEST_SIZE / 3.0f * 2.0f);
                UPPER_BARRIER = (int)((float)WINDOW_REQUEST_SIZE / 3.0f * 2.0f * 2.0f);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        WINDOW_NAMES = new String[]{"Overview", "LeftRSE", "RightRSE", "ReadOut"};
    }
}

