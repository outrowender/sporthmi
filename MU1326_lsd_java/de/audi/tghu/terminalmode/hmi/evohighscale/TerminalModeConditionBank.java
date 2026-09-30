/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.terminalmode.hmi.evohighscale.TerminalModeScreenFactory;

public class TerminalModeConditionBank
implements HMIConditionBank {
    private TerminalModeScreenFactory screenFactory;

    public TerminalModeConditionBank(TerminalModeScreenFactory terminalModeScreenFactory) {
        this.screenFactory = terminalModeScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 3200000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200000(n);
                    }
                };
            }
            case 3200001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200001(n);
                    }
                };
            }
            case 3200002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200002(n);
                    }
                };
            }
            case 3200003: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200003(n);
                    }
                };
            }
            case 3200004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200004(n);
                    }
                };
            }
            case 3200006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200045};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200006(n);
                    }
                };
            }
            case 3200007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200045};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(3200045, n, 1);
                    }
                };
            }
            case 3200014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200068};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200014(n);
                    }
                };
            }
            case 3200015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200025};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200015(n);
                    }
                };
            }
            case 3200016: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200025};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200016(n);
                    }
                };
            }
            case 3200017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200027};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200017(n);
                    }
                };
            }
            case 3200018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200027};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200018(n);
                    }
                };
            }
            case 3200019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200029};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200019(n);
                    }
                };
            }
            case 3200020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200029};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200020(n);
                    }
                };
            }
            case 3200037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3200070};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeScreenFactory.evalCond3200037(n);
                    }
                };
            }
            case 3200038: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return TerminalModeConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3915, n, 1);
                    }
                };
            }
        }
        return null;
    }
}

