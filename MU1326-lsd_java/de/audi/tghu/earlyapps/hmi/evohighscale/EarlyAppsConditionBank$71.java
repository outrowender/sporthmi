/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

class EarlyAppsConditionBank$71
extends AbstractCondition {
    private final /* synthetic */ EarlyAppsConditionBank this$0;

    EarlyAppsConditionBank$71(EarlyAppsConditionBank earlyAppsConditionBank) {
        this.this$0 = earlyAppsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-972349440, -787800064};
    }

    @Override
    public boolean evaluate(int n) {
        return EarlyAppsScreenFactory.evalCond2101442(n);
    }
}

