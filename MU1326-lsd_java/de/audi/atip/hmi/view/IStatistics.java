/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.view;

public interface IStatistics {
    public static final int STATISTIC_MEMORY_USAGE;
    public static final int STATISTIC_EVENT_QUEUE;
    public static final int STATISTIC_ANIMATION;
    public static final int STATISTIC_SCREEN_INFO;
    public static final int STATISTIC_MIXED_LIST_ITEMS;
    public static final int STATISTIC_MIXED_LIST_CONTROLLER;
    public static final int STATISTIC_APPLICATION_1;
    public static final int STATISTIC_DRAW_TIME;
    public static final int DIAG_JAR_WRONG_VERSION;
    public static final int STATISTIC_SMI_GENERALL;
    public static final int STATISTIC_SMI_MAIN;
    public static final int STATISTIC_SMI_SDS;
    public static final int STATISTIC_PARTIAL_POPUPS;
    public static final int STATISTIC_INTEGRITY_CHECKER;
    public static final int STATISTIC_SCREENSHOT_NOTIFY;
    public static final int STATISTIC_SHOW_3D_FPS;
    public static final int STATISTIC_TEST_SUPPORT;
    public static final int STATISTIC_SCREEN_CHANGE_ANIMATION_INFO;
    public static final int STATISTIC_MENU_WIDGET;
    public static final int STATISTIC_DISPLAYMANAGER_CONTEXT;
    public static final int STATISTIC_DISPLAYMANAGER_OPACITY;
    public static final int STATISTIC_SPELLER_STATUS;
    public static final int STATISTIC_VERSION_INFO;
    public static final int MAX_STATISTIC_TYPES;

    default public void showStatistics(int n, String[] stringArray, boolean bl) {
    }
}

