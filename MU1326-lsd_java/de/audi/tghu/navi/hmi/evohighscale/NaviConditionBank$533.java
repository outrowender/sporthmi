/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;

class NaviConditionBank$533
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$533(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{154, 442, 523, 3939, 4649};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviScreenFactory.evalCond412742(n);
    }
}

