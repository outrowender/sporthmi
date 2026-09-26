/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc;

public final class TMCConst {
    public static int INITIAL_ANCHOR_ID = -1;
    public static final long[] INITIAL_WINDOW = new long[]{INITIAL_ANCHOR_ID};
    public static int WINDOW_REQUEST_SIZE = 20;
    public static int OFFSET_OFF = 0;
    public static final int OFFSET_INIT;
    public static final int OFFSET_NORMAL;
    public static int UPPER_BARRIER;
    public static int LOWER_BARRIER;
    static final int LAST_ENTERED_VIEW_NONE;
    static final int LAST_ENTERED_VIEW_DETAIL;
    static final int LAST_ENTERED_VIEW_OVERVIEW;
    static final int LAST_ENTERED_VIEW_DETAIL_READOUT;
    static final int LAST_ENTERED_VIEW_OVERVIEW_READOUT;
    static final int LAST_ENTERED_VIEW_MAP;
    static final int LAST_ENTERED_VIEW_MAP_READOUT;
    static final int LAST_ENTERED_VIEW_MAP_BREAKFAST;
    private static final String SYSTEM_PROPERTY_TMC_WINDOW_SIZE;
    static final String SYSTEM_PROPERTY_USING_TWO_TMC_WINDOWS;
    static final String SYSTEM_PROPERTY_NO_TMC_READ_OUT;
    public static final long UPDATE_DISTANCE_TIMESPAN;
    public static final int ROWS_PER_SCREEN;
    public static final String LOGCH_MAIN;
    public static final String LOGCH_LIST;
    public static final String LOGCH_HMI;
    public static final String LOGCH_DSI;
    public static final String LOGCH_HELPER;
    public static final int WINDOW_OVERVIEW_LIST;
    public static final int WINDOW_RSE_TMC_LIST_LEFT;
    public static final int WINDOW_RSE_TMC_LIST_RIGHT;
    public static final int WINDOW_READ_OUT_LIST;
    public static final int WINDOW_MAX_SIZE;
    public static final String[] WINDOW_NAMES;
    public static final int INFO_SETTINGS_NAV_TMC;
    public static final int INFO_SETTINGS_DEC;
    public static final int INFO_SETTINGS_TP;
    public static final int ICON_ONE_DIRECTION;
    public static final int ICON_BI_DIRECTION;
    public static final int ICON_NONE;
    public static final int TMC_READ_OUT_ON;
    public static final int TMC_READ_OUT_OFF;
    public static final int TMC_READ_OUT_ON_ROUTE;
    static final int AUTOMATIC_REDIRECTION_OFF;
    static final int AUTOMATIC_REDIRECTION_ON;
    static final int ANNOUNCEMENT_DURING_TEL_ON;
    static final int ANNOUNCEMENT_DURING_TEL_OFF;
    static final int DISABLE_NEXT_BUTTON;
    static final int ENABLE_NEXT_BUTTON;
    static final int ENABLE_SK_IN_MAP;
    static final int DISABLE_SK_IN_MAP;
    static final int ENABLE_SK_READ_OUT;
    static final int DISABLE_SK_READ_OUT;
    public static final long POINT_LOCATION_FLAG;
    static final int COMBI_TMC_READ_OUT_ACTIVE;
    static final int COMBI_TMC_READ_OUT_INACTIVE;
    static final int FOLDER_STATE_TOPLEVEL;
    static final int FOLDER_STATE_CLOSED;
    static final int FOLDER_STATE_OPENED;
    static final int FOLDER_STATE_CHILD;

    static {
        UPPER_BARRIER = 18;
        LOWER_BARRIER = 12;
        String string = System.getProperty("TmcWindowSize");
        if (string != null) {
            try {
                int n;
                WINDOW_REQUEST_SIZE = n = Integer.parseInt(string);
                OFFSET_OFF = (WINDOW_REQUEST_SIZE - 2 * WINDOW_REQUEST_SIZE) / 2;
                LOWER_BARRIER = (int)((float)WINDOW_REQUEST_SIZE / 16448 * 2.0f);
                UPPER_BARRIER = (int)((float)WINDOW_REQUEST_SIZE / 16448 * 2.0f * 2.0f);
            }
            catch (NumberFormatException numberFormatException) {
                numberFormatException.printStackTrace();
            }
        }
        WINDOW_NAMES = new String[]{"Overview", "LeftRSE", "RightRSE", "ReadOut"};
    }
}

