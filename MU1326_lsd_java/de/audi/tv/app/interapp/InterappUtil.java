/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

public class InterappUtil {
    static final int MU_SEARCH_MODE = -1;
    static final int MU_MODE_UNDEFINED = -2;
    static final int MU_SRC_OFF = 0;
    static final int MU_SRC_TV = 1;
    static final int MU_SRC_AV = 2;

    static int getMUTerminalMode(byte by) {
        switch (by) {
            case 0: 
            case 1: 
            case 2: {
                return 0;
            }
            case 3: {
                return 13;
            }
            case 4: {
                return 1;
            }
            case 11: {
                return 7;
            }
            case 12: {
                return 8;
            }
            case 10: {
                return 6;
            }
            case 9: {
                return 5;
            }
            case 8: {
                return 4;
            }
            case 6: {
                return 2;
            }
            case 7: {
                return 3;
            }
            case 17: {
                return 14;
            }
            case 5: {
                return -1;
            }
        }
        return -2;
    }

    static byte getSDISTerminalMode(int n, int n2, boolean bl) {
        byte by = 127;
        by = n == -2 ? (byte)0 : (bl ? InterappUtil.getSDISTerminalModeInEsm(n2) : InterappUtil.getSDISTerminalModeNoEsm(n, n2));
        return by;
    }

    static byte getSDISTerminalModeInEsm(int n) {
        byte by = 127;
        switch (n) {
            case 0: {
                by = 1;
                break;
            }
            case 1: {
                by = 20;
                break;
            }
            case 2: {
                by = 21;
                break;
            }
            default: {
                by = 127;
            }
        }
        return by;
    }

    static byte getSDISTerminalModeNoEsm(int n, int n2) {
        byte by = 127;
        block0 : switch (n) {
            case -1: {
                by = 5;
                break;
            }
            case 0: {
                switch (n2) {
                    case 0: {
                        by = 1;
                        break block0;
                    }
                    case 1: {
                        by = 2;
                        break block0;
                    }
                }
                by = 19;
                break;
            }
            case 13: {
                by = 3;
                break;
            }
            case 1: {
                by = 4;
                break;
            }
            case 7: {
                by = 11;
                break;
            }
            case 8: {
                by = 12;
                break;
            }
            case 6: {
                by = 10;
                break;
            }
            case 5: {
                by = 9;
                break;
            }
            case 4: {
                by = 8;
                break;
            }
            case 2: {
                by = 6;
                break;
            }
            case 3: {
                by = 7;
                break;
            }
            case 14: {
                by = 17;
                break;
            }
            default: {
                by = 127;
            }
        }
        return by;
    }

    static int translateTvTunerFlag(int n) {
        switch (n) {
            case 2: {
                return 2;
            }
            case 1: {
                return 1;
            }
        }
        return 0;
    }

    static int translateMuteState(int n) {
        switch (n) {
            case 1: {
                return 1;
            }
            case 2: {
                return 2;
            }
            case 3: {
                return 3;
            }
        }
        return 0;
    }
}

