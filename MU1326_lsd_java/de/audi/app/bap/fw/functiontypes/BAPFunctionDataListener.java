/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.functiontypes;

public interface BAPFunctionDataListener {
    default public void notifyDataValidChanged(int n, boolean bl) {
    }

    default public void notifyDataChanged(int n) {
    }

    default public void notifyDataUpdatedNoChange(int n) {
    }
}

