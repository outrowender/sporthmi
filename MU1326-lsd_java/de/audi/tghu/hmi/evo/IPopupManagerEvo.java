/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.view.IPopupManager;

public interface IPopupManagerEvo {
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

    default public int getHMIInternalPrio(int n, int n2) {
    }

    default public void setCombiSyncPopupManager(IPopupManager iPopupManager) {
    }
}

