/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank;

class ConnectivityConditionBank$90
extends AbstractCondition {
    private final /* synthetic */ ConnectivityConditionBank this$0;

    ConnectivityConditionBank$90(ConnectivityConditionBank connectivityConditionBank) {
        this.this$0 = connectivityConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-2061097472};
    }

    @Override
    public boolean evaluate(int n) {
        return ConnectivityConditionBank.access$000(this.this$0).evaluateSimpleAbstractModelStatusEqualsCondition(-2061097472, n, 0);
    }
}

