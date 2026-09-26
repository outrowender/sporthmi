/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

public class ADBSDSUtils {
    public static final int ADB_CATEGORY_PHONE_NONE;
    public static final int ADB_CATEGORY_PHONE_FIX;
    public static final int ADB_CATEGORY_PHONE_MOBILE;
    public static final int ADB_CATEGORY_LOC_NONE;
    public static final int ADB_CATEGORY_LOC_PRIVATE;
    public static final int ADB_CATEGORY_LOC_WORK;
    public static final int ADB_CATEGORY_LOC_DETAIL_LINE_SELECTION;
    public static final int ADB_LIST_MODE_PHONE;
    public static final int ADB_LIST_MODE_NAVI;
    public static final int ADB_LIST_MODE_NUMBER;
    public static final int ADB_LIST_MODE_DESTINATION;
    public static final int ADB_LIST_MODE_DETAIL_SCREEN;
    public static final int ADB_LIST_MODE_NUMBER_SMS;
    public static final int ADB_LIST_MODE_MAIL;
    public static final int TITLE_NUMBER;
    public static final int TITLE_DICTATE;
    public static int[][] detailedAddressTypes2EventId;

    public static boolean isWorkLocationAddressType(int n) {
        return n == 4 || n == 2 || n == 0;
    }

    public static boolean isPrivateLocationAddressType(int n) {
        return n == 5 || n == 3 || n == 1;
    }

    static {
        detailedAddressTypes2EventId = new int[][]{{0, 0x71110100}, {2, 0x71110100}, {4, 0x71110100}, {1, 0x70110100}, {3, 0x70110100}, {5, 0x70110100}};
    }
}

