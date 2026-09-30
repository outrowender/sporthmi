/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.cc.ComponentConditionManager;

public interface ModelInternals {
    public void addCondition(int var1, ComponentConditionManager var2);

    public void removeCondition(int var1);

    public boolean connected();
}

