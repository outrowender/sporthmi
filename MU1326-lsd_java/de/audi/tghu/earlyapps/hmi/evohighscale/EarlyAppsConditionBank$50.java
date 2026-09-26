/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;

class EarlyAppsConditionBank$50
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$50(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1475665920};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1475665920, n, 0);
    }
}

