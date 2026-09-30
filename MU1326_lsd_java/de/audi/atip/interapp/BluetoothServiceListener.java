/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface BluetoothServiceListener {
    public void updateBluetoothState(boolean var1, boolean var2, boolean var3, boolean var4);

    public void btActionStarted();

    public void btActionFinished();
}

