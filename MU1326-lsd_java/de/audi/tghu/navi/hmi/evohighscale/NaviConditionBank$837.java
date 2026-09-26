/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;

class NaviConditionBank$837
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$837(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3929, -467794432, -719387136};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviScreenFactory.evalCond413088(n);
    }
}

