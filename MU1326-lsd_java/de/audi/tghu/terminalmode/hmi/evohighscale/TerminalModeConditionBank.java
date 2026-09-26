/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$1;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$10;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$11;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$12;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$13;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$14;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$15;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$16;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$2;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$3;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$4;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$5;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$6;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$7;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$8;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeConditionBank$9;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

public class TerminalModeConditionBank
implements HMIConditionBank {
    private TerminalModeScreenFactory screenFactory;

    public TerminalModeConditionBank(TerminalModeScreenFactory terminalModeScreenFactory) {
        this.screenFactory = terminalModeScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 3200000: {
                return new TerminalModeConditionBank$1(this);
            }
            case 3200001: {
                return new TerminalModeConditionBank$2(this);
            }
            case 3200002: {
                return new TerminalModeConditionBank$3(this);
            }
            case 3200003: {
                return new TerminalModeConditionBank$4(this);
            }
            case 3200004: {
                return new TerminalModeConditionBank$5(this);
            }
            case 3200006: {
                return new TerminalModeConditionBank$6(this);
            }
            case 3200007: {
                return new TerminalModeConditionBank$7(this);
            }
            case 3200014: {
                return new TerminalModeConditionBank$8(this);
            }
            case 3200015: {
                return new TerminalModeConditionBank$9(this);
            }
            case 3200016: {
                return new TerminalModeConditionBank$10(this);
            }
            case 3200017: {
                return new TerminalModeConditionBank$11(this);
            }
            case 3200018: {
                return new TerminalModeConditionBank$12(this);
            }
            case 3200019: {
                return new TerminalModeConditionBank$13(this);
            }
            case 3200020: {
                return new TerminalModeConditionBank$14(this);
            }
            case 3200037: {
                return new TerminalModeConditionBank$15(this);
            }
            case 3200038: {
                return new TerminalModeConditionBank$16(this);
            }
        }
        return null;
    }

    static /* synthetic */ TerminalModeScreenFactory access$000(TerminalModeConditionBank terminalModeConditionBank) {
        return terminalModeConditionBank.screenFactory;
    }
}

