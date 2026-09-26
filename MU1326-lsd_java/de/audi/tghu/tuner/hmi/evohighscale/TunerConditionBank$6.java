/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

class TunerConditionBank$6
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$6(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-410582784, 1200095488};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerScreenFactory.evalCond100010(n);
    }
}

