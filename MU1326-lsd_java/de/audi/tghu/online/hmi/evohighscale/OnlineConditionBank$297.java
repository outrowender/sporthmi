/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.online.hmi.evohighscale.OnlineConditionBank;
import de.audi.tghu.online.hmi.evohighscale.OnlineScreenFactory;

class OnlineConditionBank$297
extends AbstractCondition {
    private final /* synthetic */ OnlineConditionBank this$0;

    OnlineConditionBank$297(OnlineConditionBank onlineConditionBank) {
        this.this$0 = onlineConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{556, -1591867904, 1562059520};
    }

    @Override
    public boolean evaluate(int n) {
        return OnlineScreenFactory.evalCond2300702(n);
    }
}

