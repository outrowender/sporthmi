/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.system.hmi.evohighscale.SystemConditionBank;
import de.audi.tghu.system.hmi.evohighscale.SystemScreenFactory;

class SystemConditionBank$179
extends AbstractCondition {
    private final /* synthetic */ SystemConditionBank this$0;

    SystemConditionBank$179(SystemConditionBank systemConditionBank) {
        this.this$0 = systemConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{378, 522, 3919};
    }

    @Override
    public boolean evaluate(int n) {
        return SystemScreenFactory.evalCond749(n);
    }
}

