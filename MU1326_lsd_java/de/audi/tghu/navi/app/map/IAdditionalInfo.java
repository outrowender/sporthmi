/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

public interface IAdditionalInfo {
    public static final int AI_KDK = 0;
    public static final int AI_RouteInfoBox = 1;
    public static final int AI_Compass = 2;
    public static final int ST_Inactive = 0;
    public static final int ST_ShowKDK = 1;
    public static final int ST_ShowRouteInfoBox = 2;
    public static final int ST_ShowCompass = 3;
    public static final int ST_RequestingKDK = 4;

    public void show(boolean var1, boolean var2);

    public void show(int var1, boolean var2, boolean var3);

    public void refresh(int var1);

    public int getState();

    public void addListener(ChangeListener var1);

    public static interface ChangeListener {
        public void onChangedAdditionalInfo(int var1);
    }
}

