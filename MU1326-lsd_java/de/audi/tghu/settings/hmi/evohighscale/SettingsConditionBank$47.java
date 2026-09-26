/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

class SettingsConditionBank$47
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$47(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{30, 4073, 4228, -1438511360};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsScreenFactory.evalCond1100143(n);
    }
}

