/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;

class EngineeringConditionBank$6
extends AbstractCondition {
    private final /* synthetic */ EngineeringConditionBank this$0;

    EngineeringConditionBank$6(EngineeringConditionBank engineeringConditionBank) {
        this.this$0 = engineeringConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1607865088};
    }

    @Override
    public boolean evaluate(int n) {
        return EngineeringConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(1607865088, n, 1);
    }
}

