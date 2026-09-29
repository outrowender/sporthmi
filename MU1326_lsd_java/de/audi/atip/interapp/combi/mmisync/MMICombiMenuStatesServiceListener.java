/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.mmisync;

public interface MMICombiMenuStatesServiceListener {
    public static final int MENUID_FAS;
    public static final int MENUID_LOADING;
    public static final int MENUID_FAVORITE;
    public static final int MENUID_CARVIEWER;
    public static final int MENUID_SERVICE;
    public static final int MENUID_AUX_HEATER;
    public static final int MENUID_AIR_CONDITION;
    public static final int MENUID_VEHICLE_SETTINGS;
    public static final int MENUID_RACE;
    public static final int MENUID_STATISTIC;
    public static final int MENUID_AUX_AC;
    public static final int MENUID_CHARISMA;
    public static final int MENUID_BORDBOOK;
    public static final int MENUID_OFFICE;
    public static final int MENUID_SYSTEM_SETTINGS;
    public static final int MENUID_TONE;
    public static final int MENUID_CONNECT;
    public static final int MENUID_PROFILE;
    public static final int MENUID_CONNECTIVITY_MANAGER;
    public static final int MENUSTATE_INIT;
    public static final int MENUSTATE_TEMP_NOT_AVAILABLE;
    public static final int MENUSTATE_AVAILABLE;
    public static final int MENUSTATE_NOT_EXISTING;

    default public void updateMenuState(int n, int n2) {
    }
}

