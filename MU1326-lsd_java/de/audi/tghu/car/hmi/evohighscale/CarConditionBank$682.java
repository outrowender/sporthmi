/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;

class CarConditionBank$682
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$682(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-600897280};
    }

    @Override
    public boolean evaluate(int n) {
        return CarConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-600897280, n, 0);
    }
}

