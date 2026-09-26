/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenFactory;

class ConnectivityConditionBank$120
extends AbstractCondition {
    private final /* synthetic */ ConnectivityConditionBank this$0;

    ConnectivityConditionBank$120(ConnectivityConditionBank connectivityConditionBank) {
        this.this$0 = connectivityConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{442, 3939};
    }

    @Override
    public boolean evaluate(int n) {
        return ConnectivityScreenFactory.evalCond2500963(n);
    }
}

