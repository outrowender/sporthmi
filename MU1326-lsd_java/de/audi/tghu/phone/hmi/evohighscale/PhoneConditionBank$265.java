/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

class PhoneConditionBank$265
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$265(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3939, -1550449664, -1533672448, -1516895232, -1500118016, -1483340800, -1466563584, -1282014208, 1217856512};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneScreenFactory.evalCond308338(n);
    }
}

