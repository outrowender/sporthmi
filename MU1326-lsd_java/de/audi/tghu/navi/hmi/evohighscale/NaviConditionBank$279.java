/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;

class NaviConditionBank$279
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$279(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1545340416};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(1545340416, n, 5);
    }
}

