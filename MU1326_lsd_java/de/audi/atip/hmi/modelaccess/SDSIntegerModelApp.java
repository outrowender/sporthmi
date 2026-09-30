/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIModel;

public interface SDSIntegerModelApp
extends HMIModel {
    public void setValue(int var1);

    public void incrementValue(int var1);

    public int getValue();
}

