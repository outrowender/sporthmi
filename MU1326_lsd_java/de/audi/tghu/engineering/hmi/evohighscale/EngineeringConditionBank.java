/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenFactory;

public class EngineeringConditionBank
implements HMIConditionBank {
    private EngineeringScreenFactory screenFactory;

    public EngineeringConditionBank(EngineeringScreenFactory engineeringScreenFactory) {
        this.screenFactory = engineeringScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1300009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{375, 392, 543, 3849};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringScreenFactory.evalCond1300009(n);
                    }
                };
            }
            case 1300010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300061};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n, 3);
                    }
                };
            }
            case 1300011: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300061};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n, 2);
                    }
                };
            }
            case 1300012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300061};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n, 1);
                    }
                };
            }
            case 1300013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300061};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300061, n, 0);
                    }
                };
            }
            case 1300014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300063};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n, 1);
                    }
                };
            }
            case 1300015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300063};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n, 0);
                    }
                };
            }
            case 1300016: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700148};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700148, n, 1);
                    }
                };
            }
            case 1300017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700148};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700148, n, 0);
                    }
                };
            }
            case 1300018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300063};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n, 1);
                    }
                };
            }
            case 1300019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300063};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300063, n, 0);
                    }
                };
            }
            case 1300020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 1);
                    }
                };
            }
            case 1300021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 0);
                    }
                };
            }
            case 1300022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 1);
                    }
                };
            }
            case 1300023: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 0);
                    }
                };
            }
            case 1300024: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 1);
                    }
                };
            }
            case 1300025: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 0);
                    }
                };
            }
            case 1300026: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 1);
                    }
                };
            }
            case 1300027: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300024};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1300024, n, 0);
                    }
                };
            }
            case 1300028: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1300028};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringScreenFactory.evalCond1300028(n);
                    }
                };
            }
            case 1300030: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringScreenFactory.evalCond1300030(n);
                    }
                };
            }
            case 1300031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3300026};
                    }

                    public boolean evaluate(int n) {
                        return EngineeringConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3300026, n, 1);
                    }
                };
            }
        }
        return null;
    }
}

