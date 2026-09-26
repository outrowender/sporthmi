/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$811
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$811(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{466, 467, 469, 522, 523, -248903424, 1982597376};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond605090(n);
    }
}

