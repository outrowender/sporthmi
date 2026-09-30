/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.displaymanager;

import de.audi.atip.interapp.displaymanager.IDisplayManagerListener;

public interface IDSIDisplayManagerController {
    public void startDSI();

    public void stopDSI();

    public void startComponent(int var1, int var2, int var3);

    public void stopComponent(int var1, int var2, int var3);

    public void setCropping(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

    public void addListener(IDisplayManagerListener var1);
}

