/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.system.hmi.evohighscale.SystemConditionBank;
import de.audi.tghu.system.hmi.evohighscale.SystemScreenFactory;

class SystemConditionBank$123
extends AbstractCondition {
    private final /* synthetic */ SystemConditionBank this$0;

    SystemConditionBank$123(SystemConditionBank systemConditionBank) {
        this.this$0 = systemConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{442, 3939, -1563881472};
    }

    @Override
    public boolean evaluate(int n) {
        return SystemScreenFactory.evalCond687(n);
    }
}

