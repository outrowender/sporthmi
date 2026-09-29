/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;

class EngineeringConditionBank$8
extends AbstractCondition {
    private final /* synthetic */ EngineeringConditionBank this$0;

    EngineeringConditionBank$8(EngineeringConditionBank engineeringConditionBank) {
        this.this$0 = engineeringConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{888215808};
    }

    @Override
    public boolean evaluate(int n) {
        return EngineeringConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(888215808, n, 1);
    }
}

