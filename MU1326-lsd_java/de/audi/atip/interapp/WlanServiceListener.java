/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public interface WlanServiceListener {
    default public void updateWlanState(boolean bl) {
    }

    default public void updateNumberOfClients(int n) {
    }
}

