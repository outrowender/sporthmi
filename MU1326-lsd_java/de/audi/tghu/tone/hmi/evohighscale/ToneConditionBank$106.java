/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

class ToneConditionBank$106
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$106(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{30, 3848, 4073, 4228, -1013709824, 2023097344, -1438511360};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneScreenFactory.evalCond1000156(n);
    }
}

