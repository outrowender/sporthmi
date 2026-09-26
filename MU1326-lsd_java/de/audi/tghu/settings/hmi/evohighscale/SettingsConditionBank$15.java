/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

class SettingsConditionBank$15
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$15(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{473, 3852};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsScreenFactory.evalCond1100102(n);
    }
}

