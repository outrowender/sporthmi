/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingScreenFactory;

class MessagingConditionBank$169
extends AbstractCondition {
    private final /* synthetic */ MessagingConditionBank this$0;

    MessagingConditionBank$169(MessagingConditionBank messagingConditionBank) {
        this.this$0 = messagingConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1955799296, 1989353728, -1701633792};
    }

    @Override
    public boolean evaluate(int n) {
        return MessagingScreenFactory.evalCond2204566(n);
    }
}

