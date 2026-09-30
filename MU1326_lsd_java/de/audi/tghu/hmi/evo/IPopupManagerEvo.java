/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IPopupManager;

public interface IPopupManagerEvo {
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

    public int getHMIInternalPrio(int var1, int var2);

    public void setCombiSyncPopupManager(IPopupManager var1);
}

