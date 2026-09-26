/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.online.hmi.evohighscale.OnlineConditionBank;
import de.audi.tghu.online.hmi.evohighscale.OnlineScreenFactory;

class OnlineConditionBank$225
extends AbstractCondition {
    private final /* synthetic */ OnlineConditionBank this$0;

    OnlineConditionBank$225(OnlineConditionBank onlineConditionBank) {
        this.this$0 = onlineConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-82107648};
    }

    @Override
    public boolean evaluate(int n) {
        return OnlineScreenFactory.evalCond2300619(n);
    }
}

