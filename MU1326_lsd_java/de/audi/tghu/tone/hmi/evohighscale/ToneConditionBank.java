/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

public class ToneConditionBank
implements HMIConditionBank {
    private ToneScreenFactory screenFactory;

    public ToneConditionBank(ToneScreenFactory toneScreenFactory) {
        this.screenFactory = toneScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1000000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 100187, 100260, 100352, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000000(n);
                    }
                };
            }
            case 1000001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100352};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(100352, n, 1);
                    }
                };
            }
            case 1000002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100305, 100354, 100387};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000002(n);
                    }
                };
            }
            case 1000003: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100354, 100387};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000003(n);
                    }
                };
            }
            case 1000004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 522, 4228, 4606, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000004(n);
                    }
                };
            }
            case 1000005: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 3848, 4073, 4196, 4228, 300227, 300329, 300455, 300664, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000005(n);
                    }
                };
            }
            case 1000008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000008(n);
                    }
                };
            }
            case 1000009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000009(n);
                    }
                };
            }
            case 1000010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000036, 1000043};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000010(n);
                    }
                };
            }
            case 1000011: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1000035, n, 0);
                    }
                };
            }
            case 1000012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1000035, n, 0);
                    }
                };
            }
            case 1000013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000144};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000144, n, 1);
                    }
                };
            }
            case 1000014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1000035, n, 3);
                    }
                };
            }
            case 1000017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000035, n, 4);
                    }
                };
            }
            case 1000018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1000035, n, 2);
                    }
                };
            }
            case 1000020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1000035, n, 3);
                    }
                };
            }
            case 1000021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000035, n, 5);
                    }
                };
            }
            case 1000022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000022(n);
                    }
                };
            }
            case 1000023: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000023(n);
                    }
                };
            }
            case 1000024: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000035};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000024(n);
                    }
                };
            }
            case 1000026: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000027: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000028: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000029: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000030: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000032: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000033: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000034: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000015};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000034(n);
                    }
                };
            }
            case 1000041: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{460};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000041(n);
                    }
                };
            }
            case 1000042: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{473};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000042(n);
                    }
                };
            }
            case 1000047: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000050: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000053: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000054: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000055: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000056: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000057: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 601253, 1000106, 2100708};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000077(n);
                    }
                };
            }
            case 1000078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 601253, 1000106, 2100101};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000078(n);
                    }
                };
            }
            case 1000079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 601253, 1000106, 2100099};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000079(n);
                    }
                };
            }
            case 1000080: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000080(n);
                    }
                };
            }
            case 1000086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000086(n);
                    }
                };
            }
            case 1000088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000088(n);
                    }
                };
            }
            case 1000089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000089(n);
                    }
                };
            }
            case 1000090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000090(n);
                    }
                };
            }
            case 1000091: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000091(n);
                    }
                };
            }
            case 1000092: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000092(n);
                    }
                };
            }
            case 1000094: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 323, 460, 4073, 4088, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000094(n);
                    }
                };
            }
            case 1000096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 100327};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000096(n);
                    }
                };
            }
            case 1000097: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000098: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 177, 555, 4073, 4228, 1000061, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000098(n);
                    }
                };
            }
            case 1000099: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 177, 555, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000099(n);
                    }
                };
            }
            case 1000100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 177, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000100(n);
                    }
                };
            }
            case 1000101: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000101(n);
                    }
                };
            }
            case 1000102: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000102(n);
                    }
                };
            }
            case 1000103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 4073, 100327};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000104(n);
                    }
                };
            }
            case 1000105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141, 4073, 100327};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000105(n);
                    }
                };
            }
            case 1000106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141, 4073, 100327};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000106(n);
                    }
                };
            }
            case 1000107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141, 4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000107(n);
                    }
                };
            }
            case 1000108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 100327, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000109(n);
                    }
                };
            }
            case 1000110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000110(n);
                    }
                };
            }
            case 1000111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000111(n);
                    }
                };
            }
            case 1000112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000112(n);
                    }
                };
            }
            case 1000113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000113(n);
                    }
                };
            }
            case 1000114: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000114(n);
                    }
                };
            }
            case 1000115: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000116: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000117: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 3848, 4073, 4196, 4228, 300227, 300329, 300455, 300664, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000117(n);
                    }
                };
            }
            case 1000118: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 300730, 300957, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000118(n);
                    }
                };
            }
            case 1000119: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4170, 4171, 4228, 300227, 300455, 300664, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000119(n);
                    }
                };
            }
            case 1000121: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000121(n);
                    }
                };
            }
            case 1000122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100187, 100260, 100352};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000122(n);
                    }
                };
            }
            case 1000123: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300730};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000123(n);
                    }
                };
            }
            case 1000124: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 177, 361, 555, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000124(n);
                    }
                };
            }
            case 1000125: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{555};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(555, n, 3);
                    }
                };
            }
            case 1000126: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000126(n);
                    }
                };
            }
            case 1000127: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000127(n);
                    }
                };
            }
            case 1000128: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000128(n);
                    }
                };
            }
            case 1000129: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000129(n);
                    }
                };
            }
            case 1000130: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000130(n);
                    }
                };
            }
            case 1000131: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000131(n);
                    }
                };
            }
            case 1000132: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000132(n);
                    }
                };
            }
            case 1000133: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300455};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300455, n, 1);
                    }
                };
            }
            case 1000135: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000135(n);
                    }
                };
            }
            case 1000136: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000136(n);
                    }
                };
            }
            case 1000137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300455};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300455, n, 1);
                    }
                };
            }
            case 1000138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000138(n);
                    }
                };
            }
            case 1000139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300455};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000139(n);
                    }
                };
            }
            case 1000143: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000143(n);
                    }
                };
            }
            case 1000145: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000036, 1000043};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000145(n);
                    }
                };
            }
            case 1000146: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000146(n);
                    }
                };
            }
            case 1000147: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000147(n);
                    }
                };
            }
            case 1000148: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300455};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300455, n, 1);
                    }
                };
            }
            case 1000149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4228, 4367, 4395, 300227, 300664, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000149(n);
                    }
                };
            }
            case 1000150: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{555};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(555, n, 3);
                    }
                };
            }
            case 1000151: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000151(n);
                    }
                };
            }
            case 1000152: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{555};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(555, n, 3);
                    }
                };
            }
            case 1000153: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000061, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000153(n);
                    }
                };
            }
            case 1000154: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000155: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000155(n);
                    }
                };
            }
            case 1000156: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 3848, 4073, 4228, 300227, 300664, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000156(n);
                    }
                };
            }
            case 1000157: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300329, 300455};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000157(n);
                    }
                };
            }
            case 1000158: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 30, 141, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000158(n);
                    }
                };
            }
            case 1000159: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000159(n);
                    }
                };
            }
            case 1000160: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4076};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000160(n);
                    }
                };
            }
            case 1000161: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000161(n);
                    }
                };
            }
            case 1000162: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000162(n);
                    }
                };
            }
            case 1000168: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000168(n);
                    }
                };
            }
            case 1000169: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000169(n);
                    }
                };
            }
            case 1000182: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073, 5617};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000182(n);
                    }
                };
            }
            case 1000187: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{323, 460, 4088};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000187(n);
                    }
                };
            }
            case 1000188: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000188(n);
                    }
                };
            }
            case 1000189: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100324};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100324, n, 1);
                    }
                };
            }
            case 1000190: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000191: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 4);
                    }
                };
            }
            case 1000192: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 5);
                    }
                };
            }
            case 1000193: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000194: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000195: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000196: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 3);
                    }
                };
            }
            case 1000197: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000197(n);
                    }
                };
            }
            case 1000206: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000206(n);
                    }
                };
            }
            case 1000207: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000208: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000208(n);
                    }
                };
            }
            case 1000209: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000210: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000210(n);
                    }
                };
            }
            case 1000211: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000212: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000212(n);
                    }
                };
            }
            case 1000213: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000214: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000214(n);
                    }
                };
            }
            case 1000215: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100099};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100099, n, 1);
                    }
                };
            }
            case 1000216: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100101};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100101, n, 1);
                    }
                };
            }
            case 1000217: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100708};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100708, n, 1);
                    }
                };
            }
            case 1000218: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000219: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000219(n);
                    }
                };
            }
            case 1000230: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4115};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4115, n, 1);
                    }
                };
            }
            case 1000231: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000232: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000233: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000233(n);
                    }
                };
            }
            case 1000234: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4162, 1000057};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000234(n);
                    }
                };
            }
            case 1000235: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000236: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 4);
                    }
                };
            }
            case 1000237: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 5);
                    }
                };
            }
            case 1000238: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000102, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000238(n);
                    }
                };
            }
            case 1000239: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1000102};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1000102, n, 0);
                    }
                };
            }
            case 1000240: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000240(n);
                    }
                };
            }
            case 1000241: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000241(n);
                    }
                };
            }
            case 1000242: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000242(n);
                    }
                };
            }
            case 1000243: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 12, 141, 100327};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000243(n);
                    }
                };
            }
            case 1000244: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000244(n);
                    }
                };
            }
            case 1000245: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 177, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000245(n);
                    }
                };
            }
            case 1000246: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 4073, 4228, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000246(n);
                    }
                };
            }
            case 1000248: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1000057};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000248(n);
                    }
                };
            }
            case 1000249: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000249(n);
                    }
                };
            }
            case 1000250: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000250(n);
                    }
                };
            }
            case 1000251: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000251(n);
                    }
                };
            }
            case 1000256: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000257: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000257(n);
                    }
                };
            }
            case 1000258: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000259: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000259(n);
                    }
                };
            }
            case 1000260: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000261: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000261(n);
                    }
                };
            }
            case 1000264: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000265: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000265(n);
                    }
                };
            }
            case 1000266: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000267: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000267(n);
                    }
                };
            }
            case 1000268: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000269: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000269(n);
                    }
                };
            }
            case 1000270: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 8);
                    }
                };
            }
            case 1000271: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000271(n);
                    }
                };
            }
            case 1000272: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{472};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000272(n);
                    }
                };
            }
            case 1000273: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000274: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000277: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000277(n);
                    }
                };
            }
            case 1000278: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000278(n);
                    }
                };
            }
            case 1000279: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{503, 523, 301048};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000279(n);
                    }
                };
            }
            case 1000280: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000280(n);
                    }
                };
            }
            case 1000283: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000283(n);
                    }
                };
            }
            case 1000284: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000284(n);
                    }
                };
            }
            case 1000285: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000285(n);
                    }
                };
            }
            case 1000286: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000287: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{30, 522, 4228, 4596, 1000106};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000287(n);
                    }
                };
            }
            case 1000288: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000288(n);
                    }
                };
            }
            case 1000289: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000289(n);
                    }
                };
            }
            case 1000290: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000290(n);
                    }
                };
            }
            case 1000291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000291(n);
                    }
                };
            }
            case 1000292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000292(n);
                    }
                };
            }
            case 1000293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000293(n);
                    }
                };
            }
            case 1000294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000294(n);
                    }
                };
            }
            case 1000295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000295(n);
                    }
                };
            }
            case 1000296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000296(n);
                    }
                };
            }
            case 1000297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000297(n);
                    }
                };
            }
            case 1000298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000298(n);
                    }
                };
            }
            case 1000299: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000299(n);
                    }
                };
            }
            case 1000300: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000300(n);
                    }
                };
            }
            case 1000301: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000301(n);
                    }
                };
            }
            case 1000304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000304(n);
                    }
                };
            }
            case 1000305: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000305(n);
                    }
                };
            }
            case 1000306: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000306(n);
                    }
                };
            }
            case 1000307: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000307(n);
                    }
                };
            }
            case 1000308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000308(n);
                    }
                };
            }
            case 1000309: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000309(n);
                    }
                };
            }
            case 1000310: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000310(n);
                    }
                };
            }
            case 1000311: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000311(n);
                    }
                };
            }
            case 1000312: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000312(n);
                    }
                };
            }
            case 1000313: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000313(n);
                    }
                };
            }
            case 1000314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000314(n);
                    }
                };
            }
            case 1000315: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000315(n);
                    }
                };
            }
            case 1000316: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000316(n);
                    }
                };
            }
            case 1000317: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000317(n);
                    }
                };
            }
            case 1000320: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3883};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3883, n, 1);
                    }
                };
            }
            case 1000321: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4073, n, 0);
                    }
                };
            }
            case 1000322: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000322(n);
                    }
                };
            }
            case 1000323: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000323(n);
                    }
                };
            }
            case 1000324: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000324(n);
                    }
                };
            }
            case 1000325: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000325(n);
                    }
                };
            }
            case 1000326: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000326(n);
                    }
                };
            }
            case 1000327: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000327(n);
                    }
                };
            }
            case 1000328: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000328(n);
                    }
                };
            }
            case 1000329: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000329(n);
                    }
                };
            }
            case 1000330: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000330(n);
                    }
                };
            }
            case 1000331: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000331(n);
                    }
                };
            }
            case 1000332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000332(n);
                    }
                };
            }
            case 1000333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000333(n);
                    }
                };
            }
            case 1000334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000334(n);
                    }
                };
            }
            case 1000335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000335(n);
                    }
                };
            }
            case 1000336: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5617};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(5617, n, 0);
                    }
                };
            }
            case 1000337: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5617};
                    }

                    public boolean evaluate(int n) {
                        return ToneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(5617, n, 0);
                    }
                };
            }
            case 1000338: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4162, 1000019, 1000057};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000338(n);
                    }
                };
            }
            case 1000339: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{323, 460, 4088};
                    }

                    public boolean evaluate(int n) {
                        return ToneScreenFactory.evalCond1000339(n);
                    }
                };
            }
        }
        return null;
    }
}

