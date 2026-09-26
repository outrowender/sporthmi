/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;

class PhoneConditionBank$7
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$7(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{187};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(187, n, 2);
    }
}

