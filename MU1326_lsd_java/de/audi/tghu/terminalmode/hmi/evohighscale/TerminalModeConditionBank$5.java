/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

class TerminalModeConditionBank$5
extends AbstractCondition {
    private final /* synthetic */ TerminalModeConditionBank this$0;

    TerminalModeConditionBank$5(TerminalModeConditionBank terminalModeConditionBank) {
        this.this$0 = terminalModeConditionBank;
    }

    @Override
    public int[] getModelIds() {
        return new int[]{379};
    }

    @Override
    public boolean evaluate(int n) {
        return TerminalModeScreenFactory.evalCond3200004(n);
    }
}

