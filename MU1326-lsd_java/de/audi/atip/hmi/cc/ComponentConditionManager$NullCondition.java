/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.cc;

import de.audi.atip.hmi.model.AbstractCondition;

class ComponentConditionManager$NullCondition
extends AbstractCondition {
    public ComponentConditionManager$NullCondition(int n) {
    }

    @Override
    public int[] getModelIds() {
        return new int[0];
    }

    @Override
    public boolean evaluate(int n) {
        return false;
    }
}

