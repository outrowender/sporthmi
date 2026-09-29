/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;

class EarlyAppsConditionBank$60
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$60(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1676992512};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1676992512, n, 0);
    }
}

