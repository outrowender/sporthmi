/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;

class SWDLConditionBank$34
extends AbstractCondition {
    private final /* synthetic */ SWDLConditionBank this$0;

    SWDLConditionBank$34(SWDLConditionBank sWDLConditionBank) {
        this.this$0 = sWDLConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{250681600, 267458816, 301013248, 334567680, 368122112};
    }

    @Override
    public boolean evaluate(int n) {
        return SWDLScreenFactory.evalCond1700072(n);
    }
}

