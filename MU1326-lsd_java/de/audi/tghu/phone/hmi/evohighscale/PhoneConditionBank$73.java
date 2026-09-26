/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

class PhoneConditionBank$73
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$73(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1147796480, 513213440};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneScreenFactory.evalCond302137(n);
    }
}

