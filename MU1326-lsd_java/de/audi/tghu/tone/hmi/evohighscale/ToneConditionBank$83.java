/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

class ToneConditionBank$83
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$83(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{11, 12, 141};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneScreenFactory.evalCond1000128(n);
    }
}

