/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.online.hmi.evohighscale.OnlineConditionBank;

class OnlineConditionBank$87
extends AbstractCondition {
    private final /* synthetic */ OnlineConditionBank this$0;

    OnlineConditionBank$87(OnlineConditionBank onlineConditionBank) {
        this.this$0 = onlineConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-736484608};
    }

    @Override
    public boolean evaluate(int n) {
        return OnlineConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-736484608, n, 1);
    }
}

