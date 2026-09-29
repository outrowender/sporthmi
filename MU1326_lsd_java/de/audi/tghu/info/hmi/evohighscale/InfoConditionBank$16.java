/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank;

class InfoConditionBank$16
extends AbstractCondition {
    private final /* synthetic */ InfoConditionBank this$0;

    InfoConditionBank$16(InfoConditionBank infoConditionBank) {
        this.this$0 = infoConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{93};
    }

    @Override
    public boolean evaluate(int n) {
        return InfoConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
    }
}

