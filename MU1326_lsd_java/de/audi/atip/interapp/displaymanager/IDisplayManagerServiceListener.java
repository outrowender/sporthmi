/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

public interface IDisplayManagerServiceListener {
    public static final int RESULTCODE_OK = 1;
    public static final int RESULTCODE_NOK = 2;

    public void setCroppingResult(int var1);

    public void activeComponentChanged(int var1);
}

