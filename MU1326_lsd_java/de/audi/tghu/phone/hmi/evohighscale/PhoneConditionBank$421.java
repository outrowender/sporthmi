/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

class PhoneConditionBank$421
extends AbstractCondition {
    private final /* synthetic */ PhoneConditionBank this$0;

    PhoneConditionBank$421(PhoneConditionBank phoneConditionBank) {
        this.this$0 = phoneConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{463, 494, 3939, 5583, 5588, -1013709824, 1385497600, 1150682112, 1184236544, 2023097344, 798426112, -1734933504, -1718156288, -1349057536, 874915328, 1663444480};
    }

    @Override
    public boolean evaluate(int n) {
        return PhoneScreenFactory.evalCond308517(n);
    }
}

