/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;

class NaviConditionBank$831
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$831(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{4436, 1780221440, 505349632};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviScreenFactory.evalCond413082(n);
    }
}

