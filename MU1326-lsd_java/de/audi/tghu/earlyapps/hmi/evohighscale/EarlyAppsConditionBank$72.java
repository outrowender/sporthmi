/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

class EarlyAppsConditionBank$72
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$72(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-972349440, -754245632, 1712070656};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsScreenFactory.evalCond2101443(n);
    }
}

