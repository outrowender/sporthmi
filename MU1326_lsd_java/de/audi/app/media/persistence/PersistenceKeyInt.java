/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.persistence;

import de.audi.app.media.persistence.MediaPersistenceKey;

public class PersistenceKeyInt
extends MediaPersistenceKey {
    private final int minValue;
    private final int maxValue;
    private final int defaultValue;

    public PersistenceKeyInt(int n, int n2, int n3, int n4) {
        super(n);
        this.minValue = n2;
        this.maxValue = n3;
        this.defaultValue = n4;
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public int getDefaultValue() {
        return this.defaultValue;
    }
}

