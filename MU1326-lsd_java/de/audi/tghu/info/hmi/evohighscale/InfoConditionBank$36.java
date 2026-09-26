/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank;

class InfoConditionBank$36
extends AbstractCondition {
    private final /* synthetic */ InfoConditionBank this$0;

    InfoConditionBank$36(InfoConditionBank infoConditionBank) {
        this.this$0 = infoConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-526317824};
    }

    @Override
    public boolean evaluate(int n) {
        return InfoConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-526317824, n, 1);
    }
}

