/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenFactory;

class EcallConditionBank$10
extends AbstractCondition {
    private final /* synthetic */ EcallConditionBank this$0;

    EcallConditionBank$10(EcallConditionBank ecallConditionBank) {
        this.this$0 = ecallConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{167, 4181};
    }

    @Override
    public boolean evaluate(int n) {
        return EcallScreenFactory.evalCond3300009(n);
    }
}

