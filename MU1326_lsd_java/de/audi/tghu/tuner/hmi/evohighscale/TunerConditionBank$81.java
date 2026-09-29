/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;

class TunerConditionBank$81
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$81(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{310};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
    }
}

