/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;

class TerminalModeConditionBank$7
extends AbstractCondition {
    private final /* synthetic */ TerminalModeConditionBank this$0;

    TerminalModeConditionBank$7(TerminalModeConditionBank terminalModeConditionBank) {
        this.this$0 = terminalModeConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{768880640};
    }

    @Override
    public boolean evaluate(int n) {
        return TerminalModeConditionBank.access$000(this.this$0).evaluateSimpleChoiceModelValueGreaterCondition(768880640, n, 1);
    }
}

