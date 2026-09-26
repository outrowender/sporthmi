/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

class TerminalModeConditionBank$10
extends AbstractCondition {
    private final /* synthetic */ TerminalModeConditionBank this$0;

    TerminalModeConditionBank$10(TerminalModeConditionBank terminalModeConditionBank) {
        this.this$0 = terminalModeConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{433336320};
    }

    @Override
    public boolean evaluate(int n) {
        return TerminalModeScreenFactory.evalCond3200016(n);
    }
}

