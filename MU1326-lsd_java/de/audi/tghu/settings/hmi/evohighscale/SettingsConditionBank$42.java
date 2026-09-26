/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

class SettingsConditionBank$42
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$42(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{375, 390, 391, 392, 543, 4468, 384964864};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsScreenFactory.evalCond1100137(n);
    }
}

