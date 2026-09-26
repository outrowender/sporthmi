/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

class TunerConditionBank$400
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$400(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3939, 5583, 5584};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerScreenFactory.evalCond103994(n);
    }
}

