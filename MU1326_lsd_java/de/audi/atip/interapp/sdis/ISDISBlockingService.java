/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.sdis;

public interface ISDISBlockingService {
    public void setLockState(int var1);

    public void setBlockState(int var1);

    public void enterAppContext(int var1, String var2);
}

