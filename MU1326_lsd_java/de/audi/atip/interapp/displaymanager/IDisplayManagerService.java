/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

import de.audi.atip.interapp.displaymanager.IDisplayManagerServiceListener;

public interface IDisplayManagerService {
    public static final int RATIO_4_3 = 0;
    public static final int RATIO_16_9 = 1;
    public static final int RATIO_15_9 = 2;
    public static final int RATIO_47_20 = 3;
    public static final int RATIO_ZOOM = 4;

    public void activateComponent(int var1, IDisplayManagerServiceListener var2);

    public void deactivateComponent(int var1, IDisplayManagerServiceListener var2);

    public void activateComponent(int var1);

    public void deactivateComponent(int var1);

    public void activateComponentRVC(int var1);

    public void deactivateComponentRVC(int var1);

    public void setCropping(int var1, int var2, int var3, int var4, IDisplayManagerServiceListener var5);

    public void setCropping(int var1, int var2, int var3, int var4, int var5, int var6, IDisplayManagerServiceListener var7);

    public int getCurrentDisplayable();
}

