/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.system.hmi.evohighscale.SystemConditionBank;

class SystemConditionBank$75
extends AbstractCondition {
    private final /* synthetic */ SystemConditionBank this$0;

    SystemConditionBank$75(SystemConditionBank systemConditionBank) {
        this.this$0 = systemConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-551869696};
    }

    @Override
    public boolean evaluate(int n) {
        return SystemConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-551869696, n, 1);
    }
}

