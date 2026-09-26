/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;

class CarConditionBank$348
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$348(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-282457856};
    }

    @Override
    public boolean evaluate(int n) {
        return CarConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-282457856, n, 0);
    }
}

