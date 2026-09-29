/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tv.hmi.evohighscale.TVConditionBank;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenFactory;

class TVConditionBank$32
extends AbstractCondition {
    private final /* synthetic */ TVConditionBank this$0;

    TVConditionBank$32(TVConditionBank tVConditionBank) {
        this.this$0 = tVConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{5583, 5618, 1353459456, -1867766016, -1515444480, -139712768};
    }

    @Override
    public boolean evaluate(int n) {
        return TVScreenFactory.evalCond2600434(n);
    }
}

