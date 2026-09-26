/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingScreenFactory;

class MessagingConditionBank$27
extends AbstractCondition {
    private final /* synthetic */ MessagingConditionBank this$0;

    MessagingConditionBank$27(MessagingConditionBank messagingConditionBank) {
        this.this$0 = messagingConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{335, -191749888};
    }

    @Override
    public boolean evaluate(int n) {
        return MessagingScreenFactory.evalCond2201516(n);
    }
}

