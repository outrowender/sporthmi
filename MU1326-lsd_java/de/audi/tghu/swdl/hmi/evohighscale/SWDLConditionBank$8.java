/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank;

class SWDLConditionBank$8
extends AbstractCondition {
    private final /* synthetic */ SWDLConditionBank this$0;

    SWDLConditionBank$8(SWDLConditionBank sWDLConditionBank) {
        this.this$0 = sWDLConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-739239680};
    }

    @Override
    public boolean evaluate(int n) {
        return SWDLConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-739239680, n, 1);
    }
}

