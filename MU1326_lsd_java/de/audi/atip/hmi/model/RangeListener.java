/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.ButtonListener;

public interface RangeListener
extends ButtonListener {
    public void decrement(int var1, int var2, int var3);

    public void increment(int var1, int var2, int var3);
}

