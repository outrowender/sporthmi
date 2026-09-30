/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenFactory;

public class EcallConditionBank
implements HMIConditionBank {
    private EcallScreenFactory screenFactory;

    public EcallConditionBank(EcallScreenFactory ecallScreenFactory) {
        this.screenFactory = ecallScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 3300000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300000(n);
                    }
                };
            }
            case 3300001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300001(n);
                    }
                };
            }
            case 3300002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300002(n);
                    }
                };
            }
            case 3300003: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300003(n);
                    }
                };
            }
            case 3300004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300004(n);
                    }
                };
            }
            case 3300005: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300005(n);
                    }
                };
            }
            case 3300006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300006(n);
                    }
                };
            }
            case 3300007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300007(n);
                    }
                };
            }
            case 3300008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300008(n);
                    }
                };
            }
            case 3300009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300009(n);
                    }
                };
            }
            case 3300010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 442, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300010(n);
                    }
                };
            }
            case 3300011: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 442, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300011(n);
                    }
                };
            }
            case 3300012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 442, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300012(n);
                    }
                };
            }
            case 3300013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{167, 442, 4181};
                    }

                    public boolean evaluate(int n) {
                        return EcallScreenFactory.evalCond3300013(n);
                    }
                };
            }
            case 3300014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{363};
                    }

                    public boolean evaluate(int n) {
                        return EcallConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(363, n, 1);
                    }
                };
            }
            case 3300015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{363};
                    }

                    public boolean evaluate(int n) {
                        return EcallConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(363, n, 1);
                    }
                };
            }
        }
        return null;
    }
}

