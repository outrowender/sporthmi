/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank;

class SWDLConditionBank$20
extends AbstractCondition {
    private final /* synthetic */ SWDLConditionBank this$0;

    SWDLConditionBank$20(SWDLConditionBank sWDLConditionBank) {
        this.this$0 = sWDLConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1745807104};
    }

    @Override
    public boolean evaluate(int n) {
        return SWDLConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-1745807104, n, 0);
    }
}

