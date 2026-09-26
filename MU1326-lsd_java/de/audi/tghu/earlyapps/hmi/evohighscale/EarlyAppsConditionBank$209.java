/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

class EarlyAppsConditionBank$209
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$209(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-905175040, -838066176};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsScreenFactory.evalCond2101735(n);
    }
}

