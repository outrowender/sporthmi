/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

public class PopupPrioMapper {
    public static final int ZPM_SLOT_NONE = 0;
    public static final int ZPM_SLOT_PARKING = 1;
    public static final int ZPM_SLOT_ENGMENU = 2;
    public static final int ZPM_SLOT_SWDL = 3;
    public static final int ZPM_SLOT_MMI_MID_PRIO = 4;
    public static final int ZPM_SLOT_PHONE = 5;
    public static final int ZPM_SLOT_NAVI = 6;
    public static final int ZPM_SLOT_CONNECT_OFFICE = 7;
    public static final int ZPM_SLOT_APPS = 8;
    public static final int ZPM_SLOT_MEDIA = 9;
    public static final int ZPM_SLOT_MMI_LOW_PRIO = 10;
    public static final int ZPM_SLOT_NAVI_RG = 11;
    public static final int ZPM_SLOT_PHONE_INC_CALL = 12;

    public int getHMIInternalPopupPrio(int n, int n2) {
        int n3 = 0;
        switch (n) {
            case 1: {
                n3 = 10;
                break;
            }
            case 3: {
                n3 = 10;
                break;
            }
            case 2: {
                n3 = 10;
                break;
            }
            case 12: {
                n3 = 10;
                break;
            }
            case 4: {
                n3 = 10;
                break;
            }
            case 5: {
                n3 = 10;
                break;
            }
            case 6: {
                n3 = 10;
                break;
            }
            case 11: {
                n3 = 10;
                break;
            }
            case 7: {
                n3 = 10;
                break;
            }
            case 8: {
                n3 = 10;
                break;
            }
            case 9: {
                n3 = 10;
                break;
            }
            case 10: {
                n3 = 10;
                break;
            }
            case 0: {
                n3 = 10;
                break;
            }
            default: {
                n3 = 10;
            }
        }
        return n3 * 256 + (255 - n2);
    }
}

