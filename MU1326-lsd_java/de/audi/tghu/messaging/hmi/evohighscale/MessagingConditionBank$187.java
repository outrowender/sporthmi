/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;

class MessagingConditionBank$187
extends AbstractCondition {
    private final /* synthetic */ MessagingConditionBank this$0;

    MessagingConditionBank$187(MessagingConditionBank messagingConditionBank) {
        this.this$0 = messagingConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1131273984};
    }

    @Override
    public boolean evaluate(int n) {
        return MessagingConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-1131273984, n, 0);
    }
}

