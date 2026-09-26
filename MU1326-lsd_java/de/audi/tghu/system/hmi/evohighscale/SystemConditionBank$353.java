/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.system.hmi.evohighscale.SystemConditionBank;

class SystemConditionBank$353
extends AbstractCondition {
    private final /* synthetic */ SystemConditionBank this$0;

    SystemConditionBank$353(SystemConditionBank systemConditionBank) {
        this.this$0 = systemConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1181540096};
    }

    @Override
    public boolean evaluate(int n) {
        return SystemConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1181540096, n, 1);
    }
}

