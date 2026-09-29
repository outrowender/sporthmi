/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps.adb;

public class ADBSDSUtils$TelNumberTypeToModelValueMapping {
    private static final int ADB_SELECTED_NUMBER_TYPE_FIX;
    private static final int ADB_SELECTED_NUMBER_TYPE_FIX_PRIVATE;
    private static final int ADB_SELECTED_NUMBER_TYPE_FIX_WORK;
    private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE;
    private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE_PRIVATE;
    private static final int ADB_SELECTED_NUMBER_TYPE_MOBILE_WORK;
    private static final int ADB_SELECTED_NUMBER_TYPE_FAX;
    private static final int ADB_SELECTED_NUMBER_TYPE_FAX_PRIVATE;
    private static final int ADB_SELECTED_NUMBER_TYPE_FAX_WORK;
    private static final int ADB_SELECTED_NUMBER_TYPE_NONE;
    private static final int ADB_SELECTED_NUMBER_TYPE_PRIVATE;
    private static final int ADB_SELECTED_NUMBER_TYPE_WORK;
    private static final int PHONETYPES_ALL_CATS_PATTERN;
    private static final int PHONETYPES_ALL_TYPES_PATTERN;

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

