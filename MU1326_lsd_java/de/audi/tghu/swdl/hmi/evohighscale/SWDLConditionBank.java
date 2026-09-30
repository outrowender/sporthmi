/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;

public class SWDLConditionBank
implements HMIConditionBank {
    private SWDLScreenFactory screenFactory;

    public SWDLConditionBank(SWDLScreenFactory sWDLScreenFactory) {
        this.screenFactory = sWDLScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 1700000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700110};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700110, n, 0);
                    }
                };
            }
            case 1700001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700111};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700111, n, 0);
                    }
                };
            }
            case 1700002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700112};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700112, n, 0);
                    }
                };
            }
            case 1700003: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x19F111};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(0x19F111, n, 0);
                    }
                };
            }
            case 1700004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700114};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700114, n, 0);
                    }
                };
            }
            case 1700005: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700115};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700115, n, 0);
                    }
                };
            }
            case 1700006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700117};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700117, n, 0);
                    }
                };
            }
            case 1700007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700051};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1700051, n, 1);
                    }
                };
            }
            case 1700009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700161};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700161, n, 1);
                    }
                };
            }
            case 1700017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700108};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700108, n, 1);
                    }
                };
            }
            case 1700018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700018(n);
                    }
                };
            }
            case 1700019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700019(n);
                    }
                };
            }
            case 1700020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700020(n);
                    }
                };
            }
            case 1700021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700021(n);
                    }
                };
            }
            case 1700022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700022(n);
                    }
                };
            }
            case 1700023: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700221};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700023(n);
                    }
                };
            }
            case 1700024: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700024(n);
                    }
                };
            }
            case 1700025: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700222};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700025(n);
                    }
                };
            }
            case 1700028: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700262};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1700262, n, 0);
                    }
                };
            }
            case 1700029: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700247};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1700247, n, 0);
                    }
                };
            }
            case 1700044: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700108};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700108, n, 1);
                    }
                };
            }
            case 1700045: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700051};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700045(n);
                    }
                };
            }
            case 1700048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700244};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusGreaterCondition(1700244, n, 1);
                    }
                };
            }
            case 1700049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700244};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700049(n);
                    }
                };
            }
            case 1700050: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700288};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1700288, n, 2);
                    }
                };
            }
            case 1700057: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700133};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700057(n);
                    }
                };
            }
            case 1700058: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700133};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700058(n);
                    }
                };
            }
            case 1700060: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3849, 1700259};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700060(n);
                    }
                };
            }
            case 1700061: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3849, 1700259};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700061(n);
                    }
                };
            }
            case 1700062: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700288};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(1700288, n, 2);
                    }
                };
            }
            case 1700063: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3969};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700063(n);
                    }
                };
            }
            case 1700068: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700280, 1700367};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700068(n);
                    }
                };
            }
            case 1700071: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700171};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700171, n, 1);
                    }
                };
            }
            case 1700072: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700110, 1700111, 0x19F111, 1700115, 1700117};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700072(n);
                    }
                };
            }
            case 1700073: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700110, 1700112, 0x19F111, 1700115, 1700117};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700073(n);
                    }
                };
            }
            case 1700074: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700110, 0x19F111, 1700114, 1700115, 1700117};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700074(n);
                    }
                };
            }
            case 1700075: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100305, 1700238};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700075(n);
                    }
                };
            }
            case 1700076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x19F1F9};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(0x19F1F9, n, 0);
                    }
                };
            }
            case 1700089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700346, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700089(n);
                    }
                };
            }
            case 1700090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700090(n);
                    }
                };
            }
            case 1700091: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700364, n, 1);
                    }
                };
            }
            case 1700093: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700093(n);
                    }
                };
            }
            case 1700094: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700094(n);
                    }
                };
            }
            case 1700095: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700095(n);
                    }
                };
            }
            case 1700096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700280, 1700367};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700096(n);
                    }
                };
            }
            case 1700097: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700235, 1700385};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700097(n);
                    }
                };
            }
            case 1700098: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700271, 1700365};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700098(n);
                    }
                };
            }
            case 1700100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700311};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(1700311, n, -1);
                    }
                };
            }
            case 1700101: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700311};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700101(n);
                    }
                };
            }
            case 1700102: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700235, 1700385};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700102(n);
                    }
                };
            }
            case 1700103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3849};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700103(n);
                    }
                };
            }
            case 1700106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700311};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700311, n, 0);
                    }
                };
            }
            case 1700107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700107(n);
                    }
                };
            }
            case 1700108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700108(n);
                    }
                };
            }
            case 1700109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3849};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700109(n);
                    }
                };
            }
            case 1700110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3849};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700110(n);
                    }
                };
            }
            case 1700116: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700116(n);
                    }
                };
            }
            case 1700117: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700117(n);
                    }
                };
            }
            case 1700118: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700346, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700118(n);
                    }
                };
            }
            case 1700119: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700119(n);
                    }
                };
            }
            case 1700120: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700120(n);
                    }
                };
            }
            case 1700122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700367};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700122(n);
                    }
                };
            }
            case 1700123: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700123(n);
                    }
                };
            }
            case 1700124: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700124(n);
                    }
                };
            }
            case 1700125: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700125(n);
                    }
                };
            }
            case 1700126: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700126(n);
                    }
                };
            }
            case 0x19F11F: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700127(n);
                    }
                };
            }
            case 1700128: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700128(n);
                    }
                };
            }
            case 1700129: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700129(n);
                    }
                };
            }
            case 1700130: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700130(n);
                    }
                };
            }
            case 1700135: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700135(n);
                    }
                };
            }
            case 1700136: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700136(n);
                    }
                };
            }
            case 1700137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 1700364};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700137(n);
                    }
                };
            }
            case 1700139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 4581, 1700387};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700139(n);
                    }
                };
            }
            case 1700140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700327};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700327, n, 6);
                    }
                };
            }
            case 1700142: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700386};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n, 1);
                    }
                };
            }
            case 1700143: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700386};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n, 0);
                    }
                };
            }
            case 1700144: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700386};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n, 1);
                    }
                };
            }
            case 1700145: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700386};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700386, n, 0);
                    }
                };
            }
            case 1700146: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700327};
                    }

                    public boolean evaluate(int n) {
                        return SWDLScreenFactory.evalCond1700146(n);
                    }
                };
            }
            case 1700149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1700327};
                    }

                    public boolean evaluate(int n) {
                        return SWDLConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1700327, n, 6);
                    }
                };
            }
        }
        return null;
    }
}

