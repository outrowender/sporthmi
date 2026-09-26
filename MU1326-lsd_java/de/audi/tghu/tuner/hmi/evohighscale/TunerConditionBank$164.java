/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

class TunerConditionBank$164
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$164(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{523, -813235968, 1518862592};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerScreenFactory.evalCond102547(n);
    }
}

