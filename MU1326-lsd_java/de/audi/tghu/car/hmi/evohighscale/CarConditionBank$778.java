/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;

class CarConditionBank$778
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$778(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1204811520};
    }

    @Override
    public boolean evaluate(int n) {
        return CarConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1204811520, n, 1);
    }
}

