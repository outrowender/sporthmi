/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;

class TunerConditionBank$381
extends AbstractCondition {
    private final /* synthetic */ TunerConditionBank this$0;

    TunerConditionBank$381(TunerConditionBank tunerConditionBank) {
        this.this$0 = tunerConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{143261952};
    }

    @Override
    public boolean evaluate(int n) {
        return TunerConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(143261952, n, 1);
    }
}

