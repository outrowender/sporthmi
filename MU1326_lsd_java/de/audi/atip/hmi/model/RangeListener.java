/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ButtonListener;

public interface RangeListener
extends ButtonListener {
    default public void decrement(int n, int n2, int n3) {
    }

    default public void increment(int n, int n2, int n3) {
    }
}

