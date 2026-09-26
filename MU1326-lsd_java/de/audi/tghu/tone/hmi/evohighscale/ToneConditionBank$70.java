/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

class ToneConditionBank$70
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$70(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{11, 12, 30, 141, 4073, 4228, -1438511360};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneScreenFactory.evalCond1000114(n);
    }
}

