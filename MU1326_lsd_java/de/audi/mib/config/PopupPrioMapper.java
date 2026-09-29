/*
 * Decompiled with CFR 0.152.
 */
package de.audi.mib.config;

public class PopupPrioMapper {
    public static final int ZPM_SLOT_NONE;
    public static final int ZPM_SLOT_PARKING;
    public static final int ZPM_SLOT_ENGMENU;
    public static final int ZPM_SLOT_SWDL;
    public static final int ZPM_SLOT_MMI_MID_PRIO;
    public static final int ZPM_SLOT_PHONE;
    public static final int ZPM_SLOT_NAVI;
    public static final int ZPM_SLOT_CONNECT_OFFICE;
    public static final int ZPM_SLOT_APPS;
    public static final int ZPM_SLOT_MEDIA;
    public static final int ZPM_SLOT_MMI_LOW_PRIO;
    public static final int ZPM_SLOT_NAVI_RG;
    public static final int ZPM_SLOT_PHONE_INC_CALL;

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

