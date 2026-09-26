/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tv.hmi.evohighscale.TVConditionBank;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenFactory;

class TVConditionBank$82
extends AbstractCondition {
    private final /* synthetic */ TVConditionBank this$0;

    TVConditionBank$82(TVConditionBank tVConditionBank) {
        this.this$0 = tVConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{377, 3939, 1396838144};
    }

    @Override
    public boolean evaluate(int n) {
        return TVScreenFactory.evalCond2601288(n);
    }
}

