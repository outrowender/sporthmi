/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import java.io.Serializable;

public interface IMemoryBufferEntry
extends Serializable {
    default public void setDefaultValues() {
    }

    default public IMemoryBufferEntry copy() {
    }

    default public String[] getFields() {
    }

    default public String[] getValuesAsString() {
    }
}

