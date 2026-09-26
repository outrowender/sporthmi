/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

class EarlyAppsConditionBank$82
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$82(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3939, -771022848, -754245632, 1712070656};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsScreenFactory.evalCond2101522(n);
    }
}

