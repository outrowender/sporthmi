/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.displaymanager;

public interface IDisplayManagerServiceListener {
    public static final int RESULTCODE_OK;
    public static final int RESULTCODE_NOK;

    default public void setCroppingResult(int n) {
    }

    default public void activeComponentChanged(int n) {
    }
}

