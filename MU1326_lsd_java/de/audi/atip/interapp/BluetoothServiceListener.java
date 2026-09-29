/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface BluetoothServiceListener {
    default public void updateBluetoothState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }

    default public void btActionStarted() {
    }

    default public void btActionFinished() {
    }
}

