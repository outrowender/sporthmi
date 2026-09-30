/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IStatistics {
    public static final int STATISTIC_MEMORY_USAGE = 0;
    public static final int STATISTIC_EVENT_QUEUE = 1;
    public static final int STATISTIC_ANIMATION = 2;
    public static final int STATISTIC_SCREEN_INFO = 3;
    public static final int STATISTIC_MIXED_LIST_ITEMS = 4;
    public static final int STATISTIC_MIXED_LIST_CONTROLLER = 5;
    public static final int STATISTIC_APPLICATION_1 = 6;
    public static final int STATISTIC_DRAW_TIME = 7;
    public static final int DIAG_JAR_WRONG_VERSION = 8;
    public static final int STATISTIC_SMI_GENERALL = 9;
    public static final int STATISTIC_SMI_MAIN = 10;
    public static final int STATISTIC_SMI_SDS = 11;
    public static final int STATISTIC_PARTIAL_POPUPS = 12;
    public static final int STATISTIC_INTEGRITY_CHECKER = 13;
    public static final int STATISTIC_SCREENSHOT_NOTIFY = 14;
    public static final int STATISTIC_SHOW_3D_FPS = 15;
    public static final int STATISTIC_TEST_SUPPORT = 16;
    public static final int STATISTIC_SCREEN_CHANGE_ANIMATION_INFO = 17;
    public static final int STATISTIC_MENU_WIDGET = 18;
    public static final int STATISTIC_DISPLAYMANAGER_CONTEXT = 19;
    public static final int STATISTIC_DISPLAYMANAGER_OPACITY = 20;
    public static final int STATISTIC_SPELLER_STATUS = 21;
    public static final int STATISTIC_VERSION_INFO = 22;
    public static final int MAX_STATISTIC_TYPES = 23;

    public void showStatistics(int var1, String[] var2, boolean var3);
}

