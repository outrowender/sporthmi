/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

class TunerConditionBank$93
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$93(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{981926144, -813235968, -595132160, 0x11880100, 394789120, 1753743616, 1770520832, 1921515776, 1938292992, 2005401856, -1954021120, 747176192, 797507840};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerScreenFactory.evalCond100984(n);
    }
}

