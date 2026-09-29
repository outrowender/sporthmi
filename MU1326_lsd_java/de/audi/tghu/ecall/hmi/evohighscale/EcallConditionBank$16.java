/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank;

class EcallConditionBank$16
extends AbstractCondition {
    private final /* synthetic */ EcallConditionBank this$0;

    EcallConditionBank$16(EcallConditionBank ecallConditionBank) {
        this.this$0 = ecallConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{363};
    }

    @Override
    public boolean evaluate(int n) {
        return EcallConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(363, n, 1);
    }
}

