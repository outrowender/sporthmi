/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.model.HMIModel;

public interface SDSStringModelApp
extends HMIModel {
    public void setValue(String var1);

    public String getValue();
}

