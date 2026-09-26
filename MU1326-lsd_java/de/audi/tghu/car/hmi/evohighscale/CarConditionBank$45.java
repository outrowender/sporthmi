/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$45
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$45(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-2060908288, -2044131072, 321652992};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond600802(n);
    }
}

