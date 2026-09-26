/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;

class EarlyAppsConditionBank$135
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$135(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1207164928};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1207164928, n, 1);
    }
}

