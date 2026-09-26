/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;

class PhoneConditionBank$177
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$177(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1708775936};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1708775936, n, 1);
    }
}

