/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenFactory;

class ConnectivityConditionBank$74
extends AbstractCondition {
    private final /* synthetic */ ConnectivityConditionBank this$0;

    ConnectivityConditionBank$74(ConnectivityConditionBank connectivityConditionBank) {
        this.this$0 = connectivityConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{874915328, 1663444480};
    }

    @Override
    public boolean evaluate(int n) {
        return ConnectivityScreenFactory.evalCond2500630(n);
    }
}

