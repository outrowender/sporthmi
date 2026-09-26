/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$60
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$60(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{556337408, -1826027264};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond601329(n);
    }
}

