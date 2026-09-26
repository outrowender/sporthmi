/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;

class TerminalModeConditionBank$16
extends AbstractCondition {
    private final /* synthetic */ TerminalModeConditionBank this$0;

    TerminalModeConditionBank$16(TerminalModeConditionBank terminalModeConditionBank) {
        this.this$0 = terminalModeConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{3915};
    }

    @Override
    public boolean evaluate(int n) {
        return TerminalModeConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueEqualsCondition(3915, n, 1);
    }
}

