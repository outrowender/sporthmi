/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenFactory;

public class TVConditionBank
implements HMIConditionBank {
    private TVScreenFactory screenFactory;

    public TVConditionBank(TVScreenFactory tVScreenFactory) {
        this.screenFactory = tVScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 2600000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600000(n);
                    }
                };
            }
            case 2600002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600124};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n, 0);
                    }
                };
            }
            case 2600035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600035(n);
                    }
                };
            }
            case 2600103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600057};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600103(n);
                    }
                };
            }
            case 2600104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600084};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600104(n);
                    }
                };
            }
            case 2600105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 2600000, 2600040, 2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600105(n);
                    }
                };
            }
            case 2600106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 2600000, 2600040, 2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600106(n);
                    }
                };
            }
            case 2600107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600040};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600107(n);
                    }
                };
            }
            case 2600108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600040};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600108(n);
                    }
                };
            }
            case 2600109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600109(n);
                    }
                };
            }
            case 2600110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600110(n);
                    }
                };
            }
            case 2600111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600040};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600111(n);
                    }
                };
            }
            case 2600112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600040};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600112(n);
                    }
                };
            }
            case 2600113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600113(n);
                    }
                };
            }
            case 2600114: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600114(n);
                    }
                };
            }
            case 2600151: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600054};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600151(n);
                    }
                };
            }
            case 2600152: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026, 2600062};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600152(n);
                    }
                };
            }
            case 2600347: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600042};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600347(n);
                    }
                };
            }
            case 2600348: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600042};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600348(n);
                    }
                };
            }
            case 2600349: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600056};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600349(n);
                    }
                };
            }
            case 2600351: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5618, 2600016};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600351(n);
                    }
                };
            }
            case 2600352: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5618, 2600016};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600352(n);
                    }
                };
            }
            case 2600353: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5618, 2600016};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600353(n);
                    }
                };
            }
            case 2600354: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600031};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600354(n);
                    }
                };
            }
            case 2600355: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600031};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600355(n);
                    }
                };
            }
            case 2600426: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600031, 2600053};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600426(n);
                    }
                };
            }
            case 2600427: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600031, 2600053};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600427(n);
                    }
                };
            }
            case 2600428: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600059};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600428(n);
                    }
                };
            }
            case 2600429: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600060};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600429(n);
                    }
                };
            }
            case 2600430: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600061};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600430(n);
                    }
                };
            }
            case 2600431: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600063};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600431(n);
                    }
                };
            }
            case 2600434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5618, 2600016, 2600080, 2600101, 2600183};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600434(n);
                    }
                };
            }
            case 2600435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600101};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600435(n);
                    }
                };
            }
            case 2600436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600436(n);
                    }
                };
            }
            case 2600437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600437(n);
                    }
                };
            }
            case 2600438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600438(n);
                    }
                };
            }
            case 2600439: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600439(n);
                    }
                };
            }
            case 2600440: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 2600114, 2600116};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600440(n);
                    }
                };
            }
            case 2600517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600121};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600517(n);
                    }
                };
            }
            case 2600518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600121};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600518(n);
                    }
                };
            }
            case 2600562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600108, 2600109};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600562(n);
                    }
                };
            }
            case 2600563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600108, 2600109};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600563(n);
                    }
                };
            }
            case 2600564: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600108, 2600109};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600564(n);
                    }
                };
            }
            case 2600565: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600108, 2600109};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600565(n);
                    }
                };
            }
            case 2600756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600124};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n, 0);
                    }
                };
            }
            case 2600757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600124};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2600124, n, 0);
                    }
                };
            }
            case 2600818: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600101};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600818(n);
                    }
                };
            }
            case 2600926: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600160};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600926(n);
                    }
                };
            }
            case 2600997: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600997(n);
                    }
                };
            }
            case 2600998: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600998(n);
                    }
                };
            }
            case 2600999: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2600999(n);
                    }
                };
            }
            case 2601000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601000(n);
                    }
                };
            }
            case 2601021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600166};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601021(n);
                    }
                };
            }
            case 2601040: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601040(n);
                    }
                };
            }
            case 2601041: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601041(n);
                    }
                };
            }
            case 2601042: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601042(n);
                    }
                };
            }
            case 2601043: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601043(n);
                    }
                };
            }
            case 2601044: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601044(n);
                    }
                };
            }
            case 2601045: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601045(n);
                    }
                };
            }
            case 2601046: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601046(n);
                    }
                };
            }
            case 2601048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601048(n);
                    }
                };
            }
            case 2601049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601049(n);
                    }
                };
            }
            case 2601050: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601050(n);
                    }
                };
            }
            case 2601051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600000, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601051(n);
                    }
                };
            }
            case 2601052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601052(n);
                    }
                };
            }
            case 2601053: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601053(n);
                    }
                };
            }
            case 2601054: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601054(n);
                    }
                };
            }
            case 2601055: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600045, 2600114};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601055(n);
                    }
                };
            }
            case 2601136: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600101};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601136(n);
                    }
                };
            }
            case 2601181: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600101, 2600176};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601181(n);
                    }
                };
            }
            case 2601276: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601276(n);
                    }
                };
            }
            case 2601278: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601278(n);
                    }
                };
            }
            case 2601279: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601279(n);
                    }
                };
            }
            case 2601280: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601280(n);
                    }
                };
            }
            case 2601281: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601281(n);
                    }
                };
            }
            case 2601282: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601282(n);
                    }
                };
            }
            case 2601283: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601283(n);
                    }
                };
            }
            case 2601284: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601284(n);
                    }
                };
            }
            case 2601285: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601285(n);
                    }
                };
            }
            case 2601286: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601286(n);
                    }
                };
            }
            case 2601287: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601287(n);
                    }
                };
            }
            case 2601288: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601288(n);
                    }
                };
            }
            case 2601289: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601289(n);
                    }
                };
            }
            case 2601290: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601290(n);
                    }
                };
            }
            case 2601291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600045, 2600159};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601291(n);
                    }
                };
            }
            case 2601292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600040, 2600159};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601292(n);
                    }
                };
            }
            case 2601293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600040, 2600159};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601293(n);
                    }
                };
            }
            case 2601294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600040, 2600159};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601294(n);
                    }
                };
            }
            case 2601295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3913, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601295(n);
                    }
                };
            }
            case 2601296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592, 2600080};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601296(n);
                    }
                };
            }
            case 2601297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600068};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601297(n);
                    }
                };
            }
            case 2601298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600070};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601298(n);
                    }
                };
            }
            case 2601299: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600066};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601299(n);
                    }
                };
            }
            case 2601300: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600083};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601300(n);
                    }
                };
            }
            case 2601301: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600058};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601301(n);
                    }
                };
            }
            case 2601302: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2600055};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601302(n);
                    }
                };
            }
            case 2601306: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600108, 2600109};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601306(n);
                    }
                };
            }
            case 2601307: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600122};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601307(n);
                    }
                };
            }
            case 2601308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600032};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601308(n);
                    }
                };
            }
            case 2601309: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600033};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601309(n);
                    }
                };
            }
            case 2601310: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600037};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601310(n);
                    }
                };
            }
            case 2601311: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600088};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601311(n);
                    }
                };
            }
            case 2601312: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600166};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601312(n);
                    }
                };
            }
            case 2601313: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601313(n);
                    }
                };
            }
            case 2601314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601314(n);
                    }
                };
            }
            case 2601315: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601315(n);
                    }
                };
            }
            case 2601316: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601316(n);
                    }
                };
            }
            case 2601317: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 2600000, 2600040, 2600045};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601317(n);
                    }
                };
            }
            case 2601318: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601318(n);
                    }
                };
            }
            case 2601319: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601319(n);
                    }
                };
            }
            case 2601320: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601320(n);
                    }
                };
            }
            case 2601321: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601321(n);
                    }
                };
            }
            case 2601323: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3915, n, 1);
                    }
                };
            }
            case 2601324: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3915, n, 1);
                    }
                };
            }
            case 2601327: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601327(n);
                    }
                };
            }
            case 2601328: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600026};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601328(n);
                    }
                };
            }
            case 2601329: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 1100244};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601329(n);
                    }
                };
            }
            case 2601332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601332(n);
                    }
                };
            }
            case 2601333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601333(n);
                    }
                };
            }
            case 2601334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600122};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601334(n);
                    }
                };
            }
            case 2601335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600069};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2600069, n, 1);
                    }
                };
            }
            case 2601337: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601337(n);
                    }
                };
            }
            case 2601341: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 2600065};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601341(n);
                    }
                };
            }
            case 2601342: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 2600065};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601342(n);
                    }
                };
            }
            case 2601343: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600065};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2600065, n, 1);
                    }
                };
            }
            case 2601344: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2600065};
                    }

                    public boolean evaluate(int n) {
                        return TVConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2600065, n, 0);
                    }
                };
            }
            case 2601382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601382(n);
                    }
                };
            }
            case 2601383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601383(n);
                    }
                };
            }
            case 2601384: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601384(n);
                    }
                };
            }
            case 2601385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601385(n);
                    }
                };
            }
            case 2601386: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601386(n);
                    }
                };
            }
            case 2601396: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601396(n);
                    }
                };
            }
            case 2601397: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601397(n);
                    }
                };
            }
            case 2601398: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601398(n);
                    }
                };
            }
            case 2601399: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5592};
                    }

                    public boolean evaluate(int n) {
                        return TVScreenFactory.evalCond2601399(n);
                    }
                };
            }
        }
        return null;
    }
}

