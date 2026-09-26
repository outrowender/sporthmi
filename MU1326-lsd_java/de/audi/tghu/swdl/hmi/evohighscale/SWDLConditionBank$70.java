/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;

class SWDLConditionBank$70
extends AbstractCondition {
    private final /* synthetic */ SWDLConditionBank this$0;

    SWDLConditionBank$70(SWDLConditionBank sWDLConditionBank) {
        this.this$0 = sWDLConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{442};
    }

    @Override
    public boolean evaluate(int n) {
        return SWDLScreenFactory.evalCond1700130(n);
    }
}

