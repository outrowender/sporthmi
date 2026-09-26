/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

class TerminalModeConditionBank$8
extends AbstractCondition {
    private final /* synthetic */ TerminalModeConditionBank this$0;

    TerminalModeConditionBank$8(TerminalModeConditionBank terminalModeConditionBank) {
        this.this$0 = terminalModeConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{1154756608};
    }

    @Override
    public boolean evaluate(int n) {
        return TerminalModeScreenFactory.evalCond3200014(n);
    }
}

