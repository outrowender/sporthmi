/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.online.hmi.evohighscale.OnlineConditionBank;
import de.audi.tghu.online.hmi.evohighscale.OnlineScreenFactory;

class OnlineConditionBank$164
extends AbstractCondition {
    private final /* synthetic */ OnlineConditionBank this$0;

    OnlineConditionBank$164(OnlineConditionBank onlineConditionBank) {
        this.this$0 = onlineConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{335, -1592253696};
    }

    @Override
    public boolean evaluate(int n) {
        return OnlineScreenFactory.evalCond2300533(n);
    }
}

