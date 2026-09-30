/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

public interface IDisplayManagerListener {
    public void startComponentResult(int var1, int var2, int var3, int var4);

    public void stopComponentResult(int var1, int var2, int var3, int var4);

    public void setCroppingResult(int var1);

    public void error();
}

