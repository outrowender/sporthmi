/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$80
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$80(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{46, 2049509632, -1574237952, 1143736576};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond601420(n);
    }
}

