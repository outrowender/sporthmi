/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;

class EngineeringConditionBank$3
extends AbstractCondition {
    private final /* synthetic */ EngineeringConditionBank this$0;

    EngineeringConditionBank$3(EngineeringConditionBank engineeringConditionBank) {
        this.this$0 = engineeringConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1574310656};
    }

    @Override
    public boolean evaluate(int n) {
        return EngineeringConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(1574310656, n, 2);
    }
}

