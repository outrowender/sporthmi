/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.model;

import de.audi.atip.hmi.model.RangeListener;

public interface FastScrollingListener
extends RangeListener {
    default public void valueHit(int n, int n2, int n3) {
    }
}

