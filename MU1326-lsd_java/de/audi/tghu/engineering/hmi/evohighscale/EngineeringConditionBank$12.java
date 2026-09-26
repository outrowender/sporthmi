/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;

class EngineeringConditionBank$12
extends AbstractCondition {
    private final /* synthetic */ EngineeringConditionBank this$0;

    EngineeringConditionBank$12(EngineeringConditionBank engineeringConditionBank) {
        this.this$0 = engineeringConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{953553664};
    }

    @Override
    public boolean evaluate(int n) {
        return EngineeringConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(953553664, n, 1);
    }
}

