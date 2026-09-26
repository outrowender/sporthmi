/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;

class NaviConditionBank$1001
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$1001(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{375, 390, 391, 392, 543, 3939, 5583, 5593};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviScreenFactory.evalCond413316(n);
    }
}

