/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;

class ToneConditionBank$16
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$16(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1665273600};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueGreaterCondition(1665273600, n, 3);
    }
}

