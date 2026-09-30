/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

public class SettingsConditionBank
implements HMIConditionBank {
    private SettingsScreenFactory screenFactory;

    public SettingsConditionBank(SettingsScreenFactory settingsScreenFactory) {
        this.screenFactory = settingsScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1100000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100087};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1100087, n, 0);
                    }
                };
            }
            case 1100007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{107, 375, 543, 3849};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100007(n);
                    }
                };
            }
            case 1100081: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3888};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3888, n, 1);
                    }
                };
            }
            case 1100082: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3892};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100082(n);
                    }
                };
            }
            case 1100083: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100083(n);
                    }
                };
            }
            case 1100084: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{323, 460, 4088};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100084(n);
                    }
                };
            }
            case 1100085: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{461, 509};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100085(n);
                    }
                };
            }
            case 1100086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{343, 361, 442};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100086(n);
                    }
                };
            }
            case 1100087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100087(n);
                    }
                };
            }
            case 1100088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4108};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100088(n);
                    }
                };
            }
            case 1100089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{375, 390, 391, 392, 543, 3969, 4468, 1700231};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100089(n);
                    }
                };
            }
            case 1100090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100090(n);
                    }
                };
            }
            case 1100099: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100099(n);
                    }
                };
            }
            case 1100100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3847};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(3847, n, 0);
                    }
                };
            }
            case 1100102: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{473, 3852};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100102(n);
                    }
                };
            }
            case 1100103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 3969, 4581};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100103(n);
                    }
                };
            }
            case 1100104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{107, 375, 543, 3849, 4074};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100104(n);
                    }
                };
            }
            case 1100105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100189};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100189, n, 1);
                    }
                };
            }
            case 1100106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100189};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100106(n);
                    }
                };
            }
            case 1100107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100138};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100138, n, 2);
                    }
                };
            }
            case 1100108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100138};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100138, n, 1);
                    }
                };
            }
            case 1100109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100142};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100142, n, 2);
                    }
                };
            }
            case 1100110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100142};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100142, n, 1);
                    }
                };
            }
            case 1100111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100111(n);
                    }
                };
            }
            case 1100112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 1100256};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100112(n);
                    }
                };
            }
            case 1100119: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100183};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100183, n, 2);
                    }
                };
            }
            case 1100120: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100183};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100183, n, 1);
                    }
                };
            }
            case 1100121: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{263, 361, 363, 459, 523};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100121(n);
                    }
                };
            }
            case 1100122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 363, 459};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100122(n);
                    }
                };
            }
            case 1100123: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 363, 459};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100123(n);
                    }
                };
            }
            case 1100124: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{263, 361, 363, 459};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100124(n);
                    }
                };
            }
            case 1100125: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{263, 361, 363, 459};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100125(n);
                    }
                };
            }
            case 1100127: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 1100225};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100127(n);
                    }
                };
            }
            case 1100129: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 1100130: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 1100131: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{460};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100131(n);
                    }
                };
            }
            case 1100132: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4162};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100132(n);
                    }
                };
            }
            case 1100133: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100133(n);
                    }
                };
            }
            case 1100134: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000102, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100134(n);
                    }
                };
            }
            case 1100135: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000102};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000102, n, 0);
                    }
                };
            }
            case 1100136: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100189};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100189, n, 3);
                    }
                };
            }
            case 1100137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{375, 390, 391, 392, 543, 4468, 1700374};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100137(n);
                    }
                };
            }
            case 1100138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4468};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4468, n, 1);
                    }
                };
            }
            case 1100139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100139, 1100189};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100139(n);
                    }
                };
            }
            case 1100140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100139, 1100189};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100140(n);
                    }
                };
            }
            case 1100141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100180, 1100241};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100141(n);
                    }
                };
            }
            case 1100143: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100143(n);
                    }
                };
            }
            case 1100144: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100144(n);
                    }
                };
            }
            case 1100148: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100148(n);
                    }
                };
            }
            case 1100149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4468};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4468, n, 1);
                    }
                };
            }
            case 1100153: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 1100162: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100276, 1100319};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100162(n);
                    }
                };
            }
            case 1100163: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100319};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n, 0);
                    }
                };
            }
            case 1100164: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100319};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n, 0);
                    }
                };
            }
            case 1100165: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100319};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1100319, n, 0);
                    }
                };
            }
            case 1100166: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4603};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100166(n);
                    }
                };
            }
            case 1100167: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100167(n);
                    }
                };
            }
            case 1100168: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100168(n);
                    }
                };
            }
            case 1100169: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442};
                    }

                    public boolean evaluate(int n) {
                        return SettingsScreenFactory.evalCond1100169(n);
                    }
                };
            }
            case 1100170: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000019};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000019, n, 1);
                    }
                };
            }
            case 1100171: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000019};
                    }

                    public boolean evaluate(int n) {
                        return SettingsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000019, n, 1);
                    }
                };
            }
        }
        return null;
    }
}

