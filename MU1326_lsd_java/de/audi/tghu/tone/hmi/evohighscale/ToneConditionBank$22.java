/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;

class ToneConditionBank$22
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$22(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3883};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
    }
}

