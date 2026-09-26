/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

class PhoneConditionBank$318
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$318(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3939, 1536368896};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneScreenFactory.evalCond308396(n);
    }
}

