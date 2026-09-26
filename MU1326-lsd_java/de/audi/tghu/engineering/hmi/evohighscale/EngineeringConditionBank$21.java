/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenFactory;

class EngineeringConditionBank$21
extends AbstractCondition {
    private final /* synthetic */ EngineeringConditionBank this$0;

    EngineeringConditionBank$21(EngineeringConditionBank engineeringConditionBank) {
        this.this$0 = engineeringConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{523};
    }

    @Override
    public boolean evaluate(int n) {
        return EngineeringScreenFactory.evalCond1300030(n);
    }
}

