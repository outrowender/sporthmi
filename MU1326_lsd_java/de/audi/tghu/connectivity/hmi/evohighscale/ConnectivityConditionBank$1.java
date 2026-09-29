/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank;

class ConnectivityConditionBank$1
extends AbstractCondition {
    private final /* synthetic */ ConnectivityConditionBank this$0;

    ConnectivityConditionBank$1(ConnectivityConditionBank connectivityConditionBank) {
        this.this$0 = connectivityConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{505816576};
    }

    @Override
    public boolean evaluate(int n) {
        return ConnectivityConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusGreaterCondition(505816576, n, 0);
    }
}

