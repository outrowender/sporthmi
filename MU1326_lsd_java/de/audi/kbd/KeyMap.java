/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd;

public final class KeyMap {
    public static final int COMBO_INVALID;
    public static final int COMBO_RED_ENGINEERING_MENU;
    public static final int COMBO_GREEN_ENGINEERING_MENU;
    public static final int COMBO_SCREEN_SHOT;
    public static final int COMBO_MENU_EXTENSIONS;
    public static final int COMBO_PTT;
    public static final int COMBO_ERROR_DUMP;
    public static final int COMBO_HMI_ENGINEERING_MENU;
    public static final int COMBO_OPTION;
    public static final int COMBO_MAP;
    public static final int COMBO_SOURCE;
    public static final int COMBO_BACK;
    public static final int COMBO_IRC_BACKUP;
    public static final int T_KEY_COMBO;
    private static final int T_KEY_COMBO_IMMEDIATE;
    private static final int T_KEY_COMBO_DELAY_5000;
    private static final int[][] tableDSI;
    private static final int[][] gestureDSI;
    private static final int[] tableComboIgnore;
    private static final int[][] tableCombo;
    private static final int[][] tableComboPorsche;
    private static final int[][] tableComboPGen2;
    private static final int[][] tableComboBentley;
    private static final int[][] softkeyTableDSI;
    private static final int[][] hkMUTableDSI;
    private static final int[][] virtualButtonTableHMI;

    public static void patchG24() {
        for (int i2 = 0; i2 < tableDSI.length; ++i2) {
            if (tableDSI[i2][0] != 41) continue;
            KeyMap.tableDSI[i2][1] = 15;
            break;
        }
    }

    public static void patchPorsche() {
        for (int i2 = 0; i2 < tableDSI.length; ++i2) {
            if (tableDSI[i2][0] != 7) continue;
            KeyMap.tableDSI[i2][1] = 84;
            break;
        }
    }

    public static void patchPGen2() {
        for (int i2 = 0; i2 < tableDSI.length; ++i2) {
            if (tableDSI[i2][0] != 7) continue;
            KeyMap.tableDSI[i2][1] = 84;
            break;
        }
    }

    public static void patchBentley() {
        block6: for (int i2 = 0; i2 < tableDSI.length; ++i2) {
            switch (tableDSI[i2][0]) {
                case 9: {
                    KeyMap.tableDSI[i2][1] = 50;
                    continue block6;
                }
                case 12: {
                    KeyMap.tableDSI[i2][1] = 30;
                    continue block6;
                }
                case 7: {
                    KeyMap.tableDSI[i2][1] = 84;
                    continue block6;
                }
                case 40: {
                    KeyMap.tableDSI[i2][1] = 20;
                    continue block6;
                }
            }
        }
    }

    public static int hkCode2DSIEvent(int n) {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < hkMUTableDSI.length; ++n2) {
            if (hkMUTableDSI[n2][1] != n) continue;
            n3 = hkMUTableDSI[n2][0];
            break;
        }
        if (n2 == hkMUTableDSI.length) {
            return 0;
        }
        return n3;
    }

    public static int skCode2DSIEvent(int n) {
        int n2;
        int n3 = 0;
        for (n2 = 0; n2 < softkeyTableDSI.length; ++n2) {
            if (softkeyTableDSI[n2][1] != n) continue;
            n3 = softkeyTableDSI[n2][0];
            break;
        }
        if (n2 == softkeyTableDSI.length) {
            return 0;
        }
        return n3;
    }

    public static int kbdID2termID(int n) {
        int n2;
        switch (n) {
            case 1: 
            case 4: 
            case 5: 
            case 8: 
            case 9: 
            case 10: 
            case 13: {
                n2 = 0;
                break;
            }
            case 2: 
            case 6: 
            case 11: {
                n2 = 3;
                break;
            }
            case 3: 
            case 7: 
            case 12: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 0;
            }
        }
        return n2;
    }

    public static int joystickKey2EventID(int n) {
        int n2;
        switch (n) {
            case 31: {
                n2 = 1;
                break;
            }
            case 24: {
                n2 = 2;
                break;
            }
            case 25: {
                n2 = 3;
                break;
            }
            case 26: {
                n2 = 4;
                break;
            }
            case 27: {
                n2 = 5;
                break;
            }
            case 28: {
                n2 = 6;
                break;
            }
            case 29: {
                n2 = 7;
                break;
            }
            case 30: {
                n2 = 8;
                break;
            }
            case 23: {
                n2 = 0;
                break;
            }
            default: {
                n2 = n;
            }
        }
        return n2;
    }

    public static int getHmiKeyCode(int n) {
        int n2 = 0;
        for (int i2 = 0; i2 < tableDSI.length; ++i2) {
            if (tableDSI[i2][0] != n) continue;
            n2 = tableDSI[i2][1];
            break;
        }
        return n2;
    }

    public static int getHmiGestureKeyCode(int n) {
        int n2 = 10901;
        for (int i2 = 0; i2 < gestureDSI.length; ++i2) {
            if (gestureDSI[i2][0] != n) continue;
            n2 = gestureDSI[i2][1];
            break;
        }
        return n2;
    }

    public static boolean isComboIgnoreKey(int n) {
        for (int i2 = 0; i2 < tableComboIgnore.length; ++i2) {
            if (tableComboIgnore[i2] != n) continue;
            return true;
        }
        return false;
    }

    public static int[][] getComboTableEvo() {
        return tableCombo;
    }

    public static int[][] getComboTablePorsche() {
        return tableComboPorsche;
    }

    public static int[][] getComboTablePGen2() {
        return tableComboPGen2;
    }

    public static int[][] getComboTableBentley() {
        return tableComboBentley;
    }

    public static int getVirtualButtonId(int n) {
        int n2 = -1;
        for (int i2 = 0; i2 < virtualButtonTableHMI.length; ++i2) {
            if (virtualButtonTableHMI[i2][0] != n) continue;
            n2 = virtualButtonTableHMI[i2][1];
            break;
        }
        return n2;
    }

    public static boolean isVolumeKey(int n) {
        return n == 17 || n == 88;
    }

    public static boolean isAppChangeHardkey(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 35 || n == 34 || n == 36 || n == 55 || n == 30 || n == 82 || n == 84 || n == 83 || n == 92 || n == 93 || n == 94 || n == 95;
    }

    public static boolean isStationHardkey(int n) {
        return n == 43 || n == 44 || n == 45 || n == 46 || n == 47 || n == 48 || n == 79 || n == 80;
    }

    public static boolean isPopUpRemovalKey(int n) {
        return KeyMap.isAppChangeHardkey(n) || n == 67 || n == 66;
    }

    public static boolean isPartialPopUpRemovalKey(int n) {
        return KeyMap.isAppChangeHardkey(n) || KeyMap.isSoftkey(n) || n == 67 || n == 66 || n == 15;
    }

    public static boolean isHardkey(int n) {
        return KeyMap.isAppChangeHardkey(n) || KeyMap.isStationHardkey(n) || n == 24 || n == 25 || n == 18 || n == 23 || n == 28 || n == 19 || n == 49 || n == 53 || n == 54 || n == 21 || n == 26 || n == 13 || n == 14 || n == 16 || n == 50 || n == 51 || n == 81 || n == 58 || n == 59 || n == 60 || n == 62 || n == 63 || n == 61 || n == 87;
    }

    public static boolean isSoftkey(int n) {
        return n == 9 || n == 11 || n == 12 || n == 10 || n == 56 || n == 57;
    }

    public static boolean isCombiOnlyKey(int n, boolean bl) {
        return !bl && n == 20 || n == 19;
    }

    public static boolean isSdsAbortKey(int n) {
        return n == 1 || n == 2 || n == 3 || n == 4 || n == 5 || n == 6 || n == 7 || n == 35 || n == 13 || n == 14 || n == 34 || n == 30 || n == 15 || n == 82 || n == 84 || n == 83;
    }

    static {
        tableDSI = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 35}, {8, 9}, {9, 10}, {10, 13}, {11, 11}, {12, 12}, {13, 15}, {14, 14}, {15, 1}, {16, 17}, {17, 16}, {88, 16}, {23, 76}, {24, 69}, {25, 70}, {26, 71}, {27, 72}, {28, 73}, {29, 74}, {30, 75}, {31, 68}, {33, 66}, {35, 19}, {36, 32}, {37, 31}, {40, 17}, {44, 21}, {46, 14}, {47, 13}, {48, 56}, {49, 57}, {50, 18}, {51, 29}, {52, 49}, {53, 58}, {54, 59}, {55, 58}, {57, 21}, {58, 50}, {59, 51}, {60, 52}, {43, 96}, {42, 97}, {61, 43}, {62, 44}, {63, 45}, {64, 46}, {65, 47}, {66, 48}, {101, 79}, {102, 80}, {67, 66}, {68, 34}, {69, 53}, {70, 54}, {78, 30}, {79, 55}, {80, 61}, {81, 63}, {82, 62}, {86, 35}, {98, 9}, {97, 11}, {99, 9}, {100, 11}, {41, 0}, {104, 82}, {103, 83}, {83, 86}, {105, 85}, {106, 84}, {87, 87}, {109, 91}, {110, 92}, {111, 93}, {107, 94}, {113, 95}};
        gestureDSI = new int[][]{{3, 10903}, {6, 10905}, {4, 10902}, {1, 10906}, {5, 10904}, {7, 10908}, {11, 10907}, {8, 10909}, {10, 10911}, {9, 10912}, {2, 10901}, {0, 10901}, {12, 10901}};
        tableComboIgnore = new int[]{105};
        tableCombo = new int[][]{{13, 8, 1, 5000}, {13, 98, 1, 5000}, {13, 9, 2, 5000}, {9, 12, 4, 2500}, {9, 8, 6, 2500}, {9, 13, 7, 2500}, {4, 1, 1, 5000}, {4, 15, 2, 5000}, {4, 16, 4, 2500}, {4, 98, 4, 2500}, {4, 8, 4, 2500}, {4, 97, 13, 2500}, {4, 11, 13, 2500}, {3, 16, 6, 2500}, {3, 97, 8, 2500}, {3, 11, 8, 2500}, {3, 98, 7, 2500}, {3, 8, 7, 2500}, {6, 1, 1, 5000}, {6, 15, 2, 5000}, {6, 16, 4, 2500}, {6, 98, 4, 2500}, {6, 8, 4, 2500}, {6, 97, 13, 2500}, {6, 11, 13, 2500}, {86, 16, 6, 2500}, {86, 97, 8, 2500}, {86, 11, 8, 2500}, {86, 98, 7, 2500}, {86, 8, 7, 2500}};
        tableComboPorsche = new int[][]{{6, 4, 10, 2500}, {6, 78, 9, 100}, {6, 5, 11, 100}, {6, 1, 1, 2500}, {6, 15, 2, 2500}, {6, 3, 6, 100}, {15, 1, 4, 100}, {15, 3, 7, 2500}, {15, 4, 12, 100}, {15, 16, 8, 2500}, {15, 78, 8, 2500}};
        tableComboPGen2 = new int[][]{{4, 1, 1, 5000}, {4, 15, 2, 5000}, {4, 16, 4, 2500}, {4, 98, 4, 2500}, {4, 8, 4, 2500}, {3, 97, 8, 2500}, {3, 11, 8, 2500}, {3, 98, 7, 2500}, {3, 8, 7, 2500}, {6, 1, 1, 5000}, {6, 15, 2, 5000}, {6, 16, 4, 2500}, {6, 98, 4, 2500}, {6, 8, 4, 2500}, {86, 97, 8, 2500}, {86, 11, 8, 2500}, {86, 98, 7, 2500}, {86, 8, 7, 2500}, {16, 1, 1, 2500}, {16, 103, 2, 2500}, {16, 3, 6, 100}, {16, 4, 4, 100}, {16, 106, 7, 2500}, {16, 7, 7, 2500}, {16, 6, 8, 2500}, {16, 110, 4, 100}, {88, 88, 4, 100}, {17, 17, 4, 100}};
        tableComboBentley = new int[][]{{13, 1, 1, 2500}, {13, 11, 2, 2500}, {13, 16, 6, 100}, {13, 3, 7, 2500}, {13, 4, 11, 100}, {13, 8, 9, 100}, {13, 15, 10, 100}, {15, 8, 4, 100}, {15, 1, 8, 2500}};
        softkeyTableDSI = new int[][]{{98, 77}, {97, 78}, {8, 9}, {9, 10}, {11, 11}, {12, 12}};
        hkMUTableDSI = new int[][]{{15, 1}, {1, 2}, {3, 4}, {4, 5}, {78, 30}, {6, 7}, {86, 35}, {68, 34}, {79, 55}, {109, 91}, {110, 92}, {111, 93}, {107, 94}, {113, 95}, {103, 83}};
        virtualButtonTableHMI = new int[][]{{1, 19}, {2, 20}, {3, 21}, {4, 22}, {5, 23}, {6, 24}, {7, 25}, {35, 26}, {19, 27}, {24, 28}, {25, 29}, {26, 30}, {34, 31}, {55, 32}, {30, 33}, {16, 2}, {18, 34}, {23, 35}, {28, 36}, {13, 0}, {14, 1}, {29, 3}, {43, 4}, {44, 5}, {45, 6}, {46, 7}, {47, 8}, {48, 9}, {79, 37}, {80, 38}, {53, 10}, {54, 11}, {49, 12}, {50, 13}, {81, 39}, {51, 54}, {58, 14}, {59, 44}, {60, 15}, {62, 17}, {63, 18}, {61, 16}, {82, 40}, {84, 41}, {83, 42}, {87, 43}, {91, 45}, {92, 46}, {93, 47}, {94, 48}, {95, 49}, {96, 50}, {97, 51}, {9, 52}, {11, 53}};
    }
}

