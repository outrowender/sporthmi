/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;

class NaviConditionBank$470
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$470(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-702478848};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-702478848, n, 1);
    }
}

