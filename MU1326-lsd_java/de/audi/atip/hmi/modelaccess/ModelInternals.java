/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.modelaccess;

import de.audi.atip.hmi.cc.ComponentConditionManager;

public interface ModelInternals {
    default public void addCondition(int n, ComponentConditionManager componentConditionManager) {
    }

    default public void removeCondition(int n) {
    }

    default public boolean connected() {
    }
}

