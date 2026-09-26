/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;

class NaviConditionBank$147
extends AbstractCondition {
    private final /* synthetic */ NaviConditionBank this$0;

    NaviConditionBank$147(NaviConditionBank naviConditionBank) {
        this.this$0 = naviConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1126172160};
    }

    @Override
    public boolean evaluate(int n) {
        return NaviConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(1126172160, n, 0);
    }
}

