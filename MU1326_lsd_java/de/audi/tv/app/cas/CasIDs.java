/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.cas;

public final class CasIDs {
    public static final int CAS_OK = 0;
    public static final int CAS_OK_AND_ACTIVE = 1;
    private static final int CAS_NO_SMARTCARD = 2;
    public static final int CAS_CONFIRMATION_VIA_TM = 5;
    public static final int CAS_SYSTEM_LOCKED = 11;
    public static final int HMI_CAS_OK = -1;
    public static final int HMI_CAS_CARD_ERROR_ICON_ID = 2;
    public static final int HMI_CAS_CARD_MISSING_ICON_ID = 3;
    public static final int HMI_CAS_LOCKED_ICON_ID = 4;

    public static int getIconID(int n) {
        int n2 = -1;
        switch (n) {
            case 0: 
            case 1: {
                n2 = -1;
                break;
            }
            case 2: {
                n2 = 3;
                break;
            }
            case 11: {
                n2 = 4;
                break;
            }
            default: {
                n2 = 2;
            }
        }
        return n2;
    }

    public static boolean isOK(int n) {
        return n == 0 || n == 1;
    }

    public static boolean isNOK(int n) {
        return !CasIDs.isOK(n);
    }

    private CasIDs() {
    }
}

