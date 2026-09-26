/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;

class SettingsConditionBank$3
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$3(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3888};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(3888, n, 1);
    }
}

