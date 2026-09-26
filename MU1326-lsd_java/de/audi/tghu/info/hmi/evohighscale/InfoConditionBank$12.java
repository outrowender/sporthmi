/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenFactory;

class InfoConditionBank$12
extends AbstractCondition {
    private final /* synthetic */ InfoConditionBank this$0;

    InfoConditionBank$12(InfoConditionBank infoConditionBank) {
        this.this$0 = infoConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{361, 656475648};
    }

    @Override
    public boolean evaluate(int n) {
        return InfoScreenFactory.evalCond500021(n);
    }
}

