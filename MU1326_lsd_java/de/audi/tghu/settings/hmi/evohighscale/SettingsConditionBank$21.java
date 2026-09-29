/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;

class SettingsConditionBank$21
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$21(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1791561728};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(1791561728, n, 1);
    }
}

