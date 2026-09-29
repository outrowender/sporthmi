/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

class CarConditionBank$364
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$364(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{690751744, 791415040, 808192256, 824969472, 841746688, 892078336, 187762944, 456198400};
    }

    @Override
    public boolean evaluate(int n) {
        return CarScreenFactory.evalCond604302(n);
    }
}

