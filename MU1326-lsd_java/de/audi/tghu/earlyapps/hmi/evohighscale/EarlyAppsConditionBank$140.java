/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;

class EarlyAppsConditionBank$140
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$140(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-989061120};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-989061120, n, 1);
    }
}

