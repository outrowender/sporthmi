/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;

class ToneConditionBank$100
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$100(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{555};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(555, n, 3);
    }
}

