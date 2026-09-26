/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.drawerfocus;

public class DrawerFocusUtil {
    public static final int FOCUS_LOST;
    public static final int FOCUS_GAINED;
    public static final int STATE_SELECTION_MENU;
    public static final int STATE_OPTION_MENU;
    public static final int STATE_MAIN_AREA;
    public static final int STATE_ENTERTAINMENT_MENU;
    public static final int STATE_ATLEAST_ONE_PARTIAL_POPUP_VISIBLE;
    public static final int STATE_NO_PARTIAL_POPUP_VISIBLE;
    public static final int STATE_DISCONNECT;
    public static final int STATE_MASK;
    public static final int DEFAULT_LISTENER_MASK;
    public static final int REASON_STATE_CHANGE;
    public static final int REASON_SCREEN_CHANGE;
    public static final int REASON_VIEWSIZE_CHANGE;
    public static final int REASON_REINIT_FLAG;
    public static final int REASON_DISCONNECT;
    public static final int REASON_MASK;

    private DrawerFocusUtil() {
    }

    public static boolean isFocusGained(int n) {
        return (n & 2) == 2;
    }

    public static boolean isFocusLost(int n) {
        return (n & 1) == 1;
    }

    public static boolean isSelectionMenuOpened(int n) {
        return (n & 4) == 4;
    }

    public static boolean isOptionMenuOpened(int n) {
        return (n & 8) == 8;
    }

    public static boolean isMainArea(int n) {
        return (n & 0x10) == 16;
    }

    public static boolean isEntertainmentMenuOpened(int n) {
        return (n & 0x20) == 32;
    }

    public static boolean isPartialPopupShown(int n) {
        return (n & 0x40) == 64;
    }

    public static boolean isPartialPopupHidden(int n) {
        return (n & 0x80) == 128;
    }

    public static boolean isConnectOpened(int n) {
        return (n & 0x100) == 256;
    }

    public static int calculateChoiceValue(int n, int n2, int n3) {
        return n2 | n | n3;
    }

    public static int getRawState(int n) {
        return n & 0x1FC;
    }

    public static boolean isReasonStateChange(int n) {
        return (n & 0x200) == 512;
    }

    public static boolean isReasonScreenChange(int n) {
        return (n & 0x400) == 1024;
    }

    public static boolean isReasonReInit(int n) {
        return (n & 0x1000) == 4096;
    }

    public static boolean isReasonViewsizeChange(int n) {
        return (n & 0x800) == 2048;
    }

    public static int getRawReason(int n) {
        return n & 0x3E00;
    }
}

