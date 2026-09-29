/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;

class EarlyAppsConditionBank$232
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$232(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1744035840};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueLesserCondition(-1744035840, n, 2);
    }
}

