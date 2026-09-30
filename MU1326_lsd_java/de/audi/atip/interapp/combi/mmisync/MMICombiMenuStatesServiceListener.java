/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.combi.mmisync;

public interface MMICombiMenuStatesServiceListener {
    public static final int MENUID_FAS = 0;
    public static final int MENUID_LOADING = 1;
    public static final int MENUID_FAVORITE = 2;
    public static final int MENUID_CARVIEWER = 3;
    public static final int MENUID_SERVICE = 4;
    public static final int MENUID_AUX_HEATER = 5;
    public static final int MENUID_AIR_CONDITION = 6;
    public static final int MENUID_VEHICLE_SETTINGS = 7;
    public static final int MENUID_RACE = 8;
    public static final int MENUID_STATISTIC = 9;
    public static final int MENUID_AUX_AC = 10;
    public static final int MENUID_CHARISMA = 11;
    public static final int MENUID_BORDBOOK = 12;
    public static final int MENUID_OFFICE = 13;
    public static final int MENUID_SYSTEM_SETTINGS = 14;
    public static final int MENUID_TONE = 15;
    public static final int MENUID_CONNECT = 16;
    public static final int MENUID_PROFILE = 17;
    public static final int MENUID_CONNECTIVITY_MANAGER = 18;
    public static final int MENUSTATE_INIT = 0;
    public static final int MENUSTATE_TEMP_NOT_AVAILABLE = 1;
    public static final int MENUSTATE_AVAILABLE = 2;
    public static final int MENUSTATE_NOT_EXISTING = 3;

    public void updateMenuState(int var1, int var2);
}

