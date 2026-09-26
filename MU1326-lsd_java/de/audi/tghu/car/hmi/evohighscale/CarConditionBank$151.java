/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;

class CarConditionBank$151
extends AbstractCondition {
    private final /* synthetic */ CarConditionBank this$0;

    CarConditionBank$151(CarConditionBank carConditionBank) {
        this.this$0 = carConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-232060672};
    }

    @Override
    public boolean evaluate(int n) {
        return CarConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-232060672, n, 1);
    }
}

