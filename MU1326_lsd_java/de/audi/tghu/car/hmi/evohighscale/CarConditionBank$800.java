/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$800
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$800(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-785381120};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond605079(n);
    }
}

