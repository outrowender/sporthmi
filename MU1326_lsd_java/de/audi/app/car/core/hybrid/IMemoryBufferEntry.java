/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import java.io.Serializable;

public interface IMemoryBufferEntry
extends Serializable {
    public void setDefaultValues();

    public IMemoryBufferEntry copy();

    public String[] getFields();

    public String[] getValuesAsString();
}

