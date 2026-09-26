/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tv.hmi.evohighscale.TVConditionBank;

class TVConditionBank$125
extends AbstractCondition {
    private final /* synthetic */ TVConditionBank this$0;

    TVConditionBank$125(TVConditionBank tVConditionBank) {
        this.this$0 = tVConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-2119424256};
    }

    @Override
    public boolean evaluate(int n) {
        return TVConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-2119424256, n, 1);
    }
}

