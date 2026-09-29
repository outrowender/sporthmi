/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;

class TunerConditionBank$34
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$34(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{42467584};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(42467584, n, 1);
    }
}

