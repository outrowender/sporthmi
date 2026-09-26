/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$262
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$262(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{335, 3939};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond604110(n);
    }
}

