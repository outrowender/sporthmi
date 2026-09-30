/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.core.hybrid;

import java.io.Serializable;

public interface IHybridStatisticsConfig
extends Serializable {
    public String[] getFields();

    public String[] getValuesAsString();
}

