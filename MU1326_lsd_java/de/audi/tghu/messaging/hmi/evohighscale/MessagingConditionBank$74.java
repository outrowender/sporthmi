/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;

class MessagingConditionBank$74
extends AbstractCondition {
    private final /* synthetic */ MessagingConditionBank this$0;

    MessagingConditionBank$74(MessagingConditionBank messagingConditionBank) {
        this.this$0 = messagingConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{361963776};
    }

    @Override
    public boolean evaluate(int n) {
        return MessagingConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueLesserCondition(361963776, n, 1);
    }
}

