/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

public class ADBSDSUtils {
    public static final int ADB_CATEGORY_PHONE_NONE = 0;
    public static final int ADB_CATEGORY_PHONE_FIX = 1;
    public static final int ADB_CATEGORY_PHONE_MOBILE = 2;
    public static final int ADB_CATEGORY_LOC_NONE = 0;
    public static final int ADB_CATEGORY_LOC_PRIVATE = 1;
    public static final int ADB_CATEGORY_LOC_WORK = 2;
    public static final int ADB_CATEGORY_LOC_DETAIL_LINE_SELECTION = 3;
    public static final int ADB_LIST_MODE_PHONE = 0;
    public static final int ADB_LIST_MODE_NAVI = 1;
    public static final int ADB_LIST_MODE_NUMBER = 2;
    public static final int ADB_LIST_MODE_DESTINATION = 3;
    public static final int ADB_LIST_MODE_DETAIL_SCREEN = 4;
    public static final int ADB_LIST_MODE_NUMBER_SMS = 5;
    public static final int ADB_LIST_MODE_MAIL = 6;
    public static final int TITLE_NUMBER = 0;
    public static final int TITLE_DICTATE = 2;
    public static int[][] detailedAddressTypes2EventId = new int[][]{{0, 70001}, {2, 70001}, {4, 70001}, {1, 70000}, {3, 70000}, {5, 70000}};

    public static boolean isWorkLocationAddressType(int n) {
        return n == 4 || n == 2 || n == 0;
    }

    public static boolean isPrivateLocationAddressType(int n) {
        return n == 5 || n == 3 || n == 1;
    }

    public static class TelNumberTypeToModelValueMapping {
        private static final int ADB_SELECTED_NUMBER_TYPE_FIX = 0;
        private static final int ADB_SELECTED_NUMBER_TYPE_FIX_PRIVATE = 1;
        private static final int ADB_SELECTED_NUMBER_TYPE_FIX_WORK = 2;
        private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE = 3;
        private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE_PRIVATE = 4;
        private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE_WORK = 5;
        private static final int ADB_SELECTED_NUMBER_TYPE_FAX = 6;
        private static final int ADB_SELECTED_NUMBER_TYPE_FAX_PRIVATE = 7;
        private static final int ADB_SELECTED_NUMBER_TYPE_FAX_WORK = 8;
        private static final int ADB_SELECTED_NUMBER_TYPE_NONE = 9;
        private static final int ADB_SELECTED_NUMBER_TYPE_PRIVATE = 10;
        private static final int ADB_SELECTED_NUMBER_TYPE_WORK = 11;
        private static final int PHONETYPES_ALL_CATS_PATTERN = 8184;
        private static final int PHONETYPES_ALL_TYPES_PATTERN = 6;

        public static int getModelValueForTelNumberType(int n) {
            int n2 = n & 0x1FF8;
            int n3 = n & 6;
            switch (n2) {
                case 64: 
                case 72: 
                case 1088: 
                case 1096: {
                    switch (n3) {
                        case 4: {
                            return 4;
                        }
                        case 2: {
                            return 5;
                        }
                    }
                    return 3;
                }
                case 8: 
                case 1032: 
                case 2048: 
                case 2056: {
                    switch (n3) {
                        case 4: {
                            return 1;
                        }
                        case 2: {
                            return 2;
                        }
                    }
                    return 0;
                }
                case 16: 
                case 24: 
                case 80: 
                case 1040: 
                case 1048: 
                case 1104: 
                case 2064: 
                case 2072: {
                    switch (n3) {
                        case 4: {
                            return 7;
                        }
                        case 2: {
                            return 8;
                        }
                    }
                    return 6;
                }
            }
            switch (n3) {
                case 4: {
                    return 10;
                }
                case 2: {
                    return 11;
                }
            }
            return 9;
        }
    }
}

