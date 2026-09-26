/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.map.IAdditionalInfo$ChangeListener;

public interface IAdditionalInfo {
    public static final int AI_KDK;
    public static final int AI_RouteInfoBox;
    public static final int AI_Compass;
    public static final int ST_Inactive;
    public static final int ST_ShowKDK;
    public static final int ST_ShowRouteInfoBox;
    public static final int ST_ShowCompass;
    public static final int ST_RequestingKDK;

    default public void show(boolean bl, boolean bl2) {
    }

    default public void show(int n, boolean bl, boolean bl2) {
    }

    default public void refresh(int n) {
    }

    default public int getState() {
    }

    default public void addListener(ChangeListener changeListener) {
    }
}

