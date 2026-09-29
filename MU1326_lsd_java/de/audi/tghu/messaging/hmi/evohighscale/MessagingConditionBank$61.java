/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;

class MessagingConditionBank$61
extends AbstractCondition {
    private final /* synthetic */ MessagingConditionBank this$0;

    MessagingConditionBank$61(MessagingConditionBank messagingConditionBank) {
        this.this$0 = messagingConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1100095744};
    }

    @Override
    public boolean evaluate(int n) {
        return MessagingConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(1100095744, n, 0);
    }
}

