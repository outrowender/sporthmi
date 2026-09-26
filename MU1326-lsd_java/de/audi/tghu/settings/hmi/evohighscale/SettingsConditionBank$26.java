/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;

class SettingsConditionBank$26
extends AbstractCondition {
    private final /* synthetic */ SettingsConditionBank this$0;

    SettingsConditionBank$26(SettingsConditionBank settingsConditionBank) {
        this.this$0 = settingsConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{-1748430848};
    }

    @Override
    public boolean evaluate(int n) {
        return SettingsConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(-1748430848, n, 2);
    }
}

