/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

class ToneConditionBank$77
extends AbstractCondition {
    private final /* synthetic */ ToneConditionBank this$0;

    ToneConditionBank$77(ToneConditionBank toneConditionBank) {
        this.this$0 = toneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1535574272, -1534656256, 0x880100};
    }

    @Override
    public boolean evaluate(int n) {
        return ToneScreenFactory.evalCond1000122(n);
    }
}

