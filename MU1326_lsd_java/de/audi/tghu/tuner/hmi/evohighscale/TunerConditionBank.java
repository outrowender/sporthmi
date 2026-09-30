/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

public class TunerConditionBank
implements HMIConditionBank {
    private TunerScreenFactory screenFactory;

    public TunerConditionBank(TunerScreenFactory tunerScreenFactory) {
        this.screenFactory = tunerScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 100002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 5);
                    }
                };
            }
            case 100004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100230, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100004(n);
                    }
                };
            }
            case 100006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100398};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100398, n, 1);
                    }
                };
            }
            case 100007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 5);
                    }
                };
            }
            case 100009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100396};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100009(n);
                    }
                };
            }
            case 100010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327, 100423};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100010(n);
                    }
                };
            }
            case 100087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{367};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(367, n, 0);
                    }
                };
            }
            case 100088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100317};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100088(n);
                    }
                };
            }
            case 100194: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100194(n);
                    }
                };
            }
            case 100195: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100195(n);
                    }
                };
            }
            case 100196: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100196(n);
                    }
                };
            }
            case 100197: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100197(n);
                    }
                };
            }
            case 100198: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100198(n);
                    }
                };
            }
            case 100214: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 5);
                    }
                };
            }
            case 100220: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100220(n);
                    }
                };
            }
            case 100221: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100221(n);
                    }
                };
            }
            case 100290: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 7);
                    }
                };
            }
            case 100291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 7);
                    }
                };
            }
            case 100292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 7);
                    }
                };
            }
            case 100295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 100154};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100295(n);
                    }
                };
            }
            case 100296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100296(n);
                    }
                };
            }
            case 100297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100198};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100297(n);
                    }
                };
            }
            case 100298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(100354, n, 0);
                    }
                };
            }
            case 100500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100500(n);
                    }
                };
            }
            case 100501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100501(n);
                    }
                };
            }
            case 100502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100502(n);
                    }
                };
            }
            case 100503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100503(n);
                    }
                };
            }
            case 100655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100655(n);
                    }
                };
            }
            case 100656: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100656(n);
                    }
                };
            }
            case 100657: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100930};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100657(n);
                    }
                };
            }
            case 100658: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100658(n);
                    }
                };
            }
            case 100664: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(220, n, 1);
                    }
                };
            }
            case 100665: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100665(n);
                    }
                };
            }
            case 100666: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100354, n, 1);
                    }
                };
            }
            case 100668: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100668(n);
                    }
                };
            }
            case 100669: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100669(n);
                    }
                };
            }
            case 100671: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100671(n);
                    }
                };
            }
            case 100742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(220, n, 1);
                    }
                };
            }
            case 100743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100743(n);
                    }
                };
            }
            case 100745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100745(n);
                    }
                };
            }
            case 100747: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100747(n);
                    }
                };
            }
            case 100752: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100752(n);
                    }
                };
            }
            case 100753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100753(n);
                    }
                };
            }
            case 100754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100754(n);
                    }
                };
            }
            case 100755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100755(n);
                    }
                };
            }
            case 100756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100756(n);
                    }
                };
            }
            case 100757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100757(n);
                    }
                };
            }
            case 100758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100770(n);
                    }
                };
            }
            case 100772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{180, 442, 100509, 100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100772(n);
                    }
                };
            }
            case 100777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100198};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100198, n, 3);
                    }
                };
            }
            case 100778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100305};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100778(n);
                    }
                };
            }
            case 100779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376, 523, 100305};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100779(n);
                    }
                };
            }
            case 100780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100319};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(100319, n, 0);
                    }
                };
            }
            case 100781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100319};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100319, n, 3);
                    }
                };
            }
            case 100782: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100354};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100354, n, 3);
                    }
                };
            }
            case 100783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100387};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(100387, n, 0);
                    }
                };
            }
            case 100784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100387};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100387, n, 3);
                    }
                };
            }
            case 100785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100787(n);
                    }
                };
            }
            case 100788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100788(n);
                    }
                };
            }
            case 100789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 5);
                    }
                };
            }
            case 100790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100790(n);
                    }
                };
            }
            case 100791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100791(n);
                    }
                };
            }
            case 100792: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100327, n, 5);
                    }
                };
            }
            case 100801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100480};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100801(n);
                    }
                };
            }
            case 100883: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100883(n);
                    }
                };
            }
            case 100885: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100885(n);
                    }
                };
            }
            case 100886: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100930};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100886(n);
                    }
                };
            }
            case 100887: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100930};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100887(n);
                    }
                };
            }
            case 100888: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100888(n);
                    }
                };
            }
            case 100898: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100898(n);
                    }
                };
            }
            case 100899: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100466};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100899(n);
                    }
                };
            }
            case 100900: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100467};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100900(n);
                    }
                };
            }
            case 100963: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100963(n);
                    }
                };
            }
            case 100964: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100964(n);
                    }
                };
            }
            case 100965: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100965(n);
                    }
                };
            }
            case 100967: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100968: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100969: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100971: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100972: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 100973: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100652};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100973(n);
                    }
                };
            }
            case 100974: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100652};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100974(n);
                    }
                };
            }
            case 100977: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100977(n);
                    }
                };
            }
            case 100978: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100978(n);
                    }
                };
            }
            case 100979: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100979(n);
                    }
                };
            }
            case 100980: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100980(n);
                    }
                };
            }
            case 100981: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4033, 4237, 100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100981(n);
                    }
                };
            }
            case 100982: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100982(n);
                    }
                };
            }
            case 100983: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100303, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100983(n);
                    }
                };
            }
            case 100984: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100303, 100316, 100369, 100375, 100456, 100457, 100466, 100467, 100471, 100491, 100652, 100655};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100984(n);
                    }
                };
            }
            case 100985: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100466, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100985(n);
                    }
                };
            }
            case 100986: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100467, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100986(n);
                    }
                };
            }
            case 100987: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100471, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100987(n);
                    }
                };
            }
            case 100988: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100369, 100375, 100491, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100988(n);
                    }
                };
            }
            case 100989: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100457, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100989(n);
                    }
                };
            }
            case 100990: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100456, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100990(n);
                    }
                };
            }
            case 100992: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100375, 100491};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100992(n);
                    }
                };
            }
            case 100993: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100369, 100375};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100993(n);
                    }
                };
            }
            case 100994: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond100994(n);
                    }
                };
            }
            case 101063: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101063(n);
                    }
                };
            }
            case 101064: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101064(n);
                    }
                };
            }
            case 101067: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101067(n);
                    }
                };
            }
            case 101068: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101068(n);
                    }
                };
            }
            case 101069: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101069(n);
                    }
                };
            }
            case 101070: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101070(n);
                    }
                };
            }
            case 101072: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101072(n);
                    }
                };
            }
            case 101073: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 101074: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100146};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101074(n);
                    }
                };
            }
            case 101075: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101075(n);
                    }
                };
            }
            case 101076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101076(n);
                    }
                };
            }
            case 101079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101079(n);
                    }
                };
            }
            case 101080: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101080(n);
                    }
                };
            }
            case 101081: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101081(n);
                    }
                };
            }
            case 101082: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101082(n);
                    }
                };
            }
            case 101083: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101083(n);
                    }
                };
            }
            case 101084: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101084(n);
                    }
                };
            }
            case 101085: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101085(n);
                    }
                };
            }
            case 101086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101086(n);
                    }
                };
            }
            case 101087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101087(n);
                    }
                };
            }
            case 101088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101088(n);
                    }
                };
            }
            case 101162: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100374};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100374, n, 1);
                    }
                };
            }
            case 101166: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101166(n);
                    }
                };
            }
            case 101172: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101172(n);
                    }
                };
            }
            case 101174: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101174(n);
                    }
                };
            }
            case 101302: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101302(n);
                    }
                };
            }
            case 101303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101303(n);
                    }
                };
            }
            case 101304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101304(n);
                    }
                };
            }
            case 101305: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101305(n);
                    }
                };
            }
            case 101306: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100930};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101306(n);
                    }
                };
            }
            case 101307: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100541};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101307(n);
                    }
                };
            }
            case 101308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100541};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101308(n);
                    }
                };
            }
            case 101479: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100544};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101479(n);
                    }
                };
            }
            case 101538: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327, 100548};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101538(n);
                    }
                };
            }
            case 101540: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(220, n, 1);
                    }
                };
            }
            case 101605: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101605(n);
                    }
                };
            }
            case 101606: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101606(n);
                    }
                };
            }
            case 101607: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101607(n);
                    }
                };
            }
            case 101608: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101608(n);
                    }
                };
            }
            case 101879: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101879(n);
                    }
                };
            }
            case 101880: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442, 523};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101880(n);
                    }
                };
            }
            case 101881: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442, 523};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101881(n);
                    }
                };
            }
            case 101882: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442, 523};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101882(n);
                    }
                };
            }
            case 101883: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101883(n);
                    }
                };
            }
            case 101954: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101954(n);
                    }
                };
            }
            case 101955: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101955(n);
                    }
                };
            }
            case 101956: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond101956(n);
                    }
                };
            }
            case 102099: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102099(n);
                    }
                };
            }
            case 102100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102100(n);
                    }
                };
            }
            case 102101: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102101(n);
                    }
                };
            }
            case 102102: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102102(n);
                    }
                };
            }
            case 102103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102103(n);
                    }
                };
            }
            case 102104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102104(n);
                    }
                };
            }
            case 102105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100571};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102105(n);
                    }
                };
            }
            case 102106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327, 100423};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102106(n);
                    }
                };
            }
            case 102109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102109(n);
                    }
                };
            }
            case 102110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102110(n);
                    }
                };
            }
            case 102399: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100580};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102399(n);
                    }
                };
            }
            case 102544: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102544(n);
                    }
                };
            }
            case 102545: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102545(n);
                    }
                };
            }
            case 102546: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100303, 100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102546(n);
                    }
                };
            }
            case 102547: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100303, 100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102547(n);
                    }
                };
            }
            case 102548: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100369, 100375, 100442, 100491};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102548(n);
                    }
                };
            }
            case 102549: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100369, 100375, 100442, 100491};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102549(n);
                    }
                };
            }
            case 102550: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100467};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102550(n);
                    }
                };
            }
            case 102551: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100467};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102551(n);
                    }
                };
            }
            case 102552: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100456};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102552(n);
                    }
                };
            }
            case 102553: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100456};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102553(n);
                    }
                };
            }
            case 102554: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100466};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102554(n);
                    }
                };
            }
            case 102555: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100466};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102555(n);
                    }
                };
            }
            case 102556: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102556(n);
                    }
                };
            }
            case 102557: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102557(n);
                    }
                };
            }
            case 102601: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102601(n);
                    }
                };
            }
            case 102602: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102602(n);
                    }
                };
            }
            case 102603: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102603(n);
                    }
                };
            }
            case 102692: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102692(n);
                    }
                };
            }
            case 102693: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102693(n);
                    }
                };
            }
            case 102694: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102694(n);
                    }
                };
            }
            case 102695: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102695(n);
                    }
                };
            }
            case 102696: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100303, 100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102696(n);
                    }
                };
            }
            case 102697: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102697(n);
                    }
                };
            }
            case 102698: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102698(n);
                    }
                };
            }
            case 102699: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102699(n);
                    }
                };
            }
            case 102700: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102700(n);
                    }
                };
            }
            case 102701: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100375, 100442, 100491};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102701(n);
                    }
                };
            }
            case 102702: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100369, 100375, 100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102702(n);
                    }
                };
            }
            case 102703: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102703(n);
                    }
                };
            }
            case 102704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102704(n);
                    }
                };
            }
            case 102705: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102705(n);
                    }
                };
            }
            case 102706: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102706(n);
                    }
                };
            }
            case 102707: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100467};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102707(n);
                    }
                };
            }
            case 102708: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102708(n);
                    }
                };
            }
            case 102709: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102709(n);
                    }
                };
            }
            case 102710: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102710(n);
                    }
                };
            }
            case 102711: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100456};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102711(n);
                    }
                };
            }
            case 102712: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102712(n);
                    }
                };
            }
            case 102713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102713(n);
                    }
                };
            }
            case 102714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102714(n);
                    }
                };
            }
            case 102715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 523, 100442, 100466};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102715(n);
                    }
                };
            }
            case 102716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100466};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102716(n);
                    }
                };
            }
            case 102717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102717(n);
                    }
                };
            }
            case 102718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102718(n);
                    }
                };
            }
            case 102719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102719(n);
                    }
                };
            }
            case 102720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102720(n);
                    }
                };
            }
            case 102723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102723(n);
                    }
                };
            }
            case 102724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102724(n);
                    }
                };
            }
            case 102725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102725(n);
                    }
                };
            }
            case 102726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102726(n);
                    }
                };
            }
            case 102727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102727(n);
                    }
                };
            }
            case 102728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100267, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102728(n);
                    }
                };
            }
            case 102729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100267, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102729(n);
                    }
                };
            }
            case 102730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100267, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102730(n);
                    }
                };
            }
            case 102731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102731(n);
                    }
                };
            }
            case 102761: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102761(n);
                    }
                };
            }
            case 102821: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102821(n);
                    }
                };
            }
            case 102822: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102822(n);
                    }
                };
            }
            case 102823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327, 100528};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102823(n);
                    }
                };
            }
            case 102970: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100382};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102970(n);
                    }
                };
            }
            case 102971: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100382};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond102971(n);
                    }
                };
            }
            case 103147: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103147(n);
                    }
                };
            }
            case 103148: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103148(n);
                    }
                };
            }
            case 103149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103149(n);
                    }
                };
            }
            case 103150: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103150(n);
                    }
                };
            }
            case 103151: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103151(n);
                    }
                };
            }
            case 103184: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103184(n);
                    }
                };
            }
            case 103185: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100930};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103185(n);
                    }
                };
            }
            case 103250: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103250(n);
                    }
                };
            }
            case 103251: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103251(n);
                    }
                };
            }
            case 103360: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103360(n);
                    }
                };
            }
            case 103434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103434(n);
                    }
                };
            }
            case 103435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103435(n);
                    }
                };
            }
            case 103436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103436(n);
                    }
                };
            }
            case 103437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103437(n);
                    }
                };
            }
            case 103438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 5);
                    }
                };
            }
            case 103566: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103566(n);
                    }
                };
            }
            case 103567: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103567(n);
                    }
                };
            }
            case 103568: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103568(n);
                    }
                };
            }
            case 103569: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103569(n);
                    }
                };
            }
            case 103570: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103570(n);
                    }
                };
            }
            case 103571: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103571(n);
                    }
                };
            }
            case 103572: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103572(n);
                    }
                };
            }
            case 103573: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103573(n);
                    }
                };
            }
            case 103574: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103574(n);
                    }
                };
            }
            case 103575: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103575(n);
                    }
                };
            }
            case 103576: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103576(n);
                    }
                };
            }
            case 103577: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103577(n);
                    }
                };
            }
            case 103578: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103578(n);
                    }
                };
            }
            case 103579: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103579(n);
                    }
                };
            }
            case 103580: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103580(n);
                    }
                };
            }
            case 103581: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100320, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103581(n);
                    }
                };
            }
            case 103582: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100357, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103582(n);
                    }
                };
            }
            case 103583: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100628};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103583(n);
                    }
                };
            }
            case 103584: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100467, 100509, 100578};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103584(n);
                    }
                };
            }
            case 103585: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509, 100578};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103585(n);
                    }
                };
            }
            case 103586: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509, 100578};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103586(n);
                    }
                };
            }
            case 103587: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509, 100578};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103587(n);
                    }
                };
            }
            case 103588: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100327, 100609, 100610, 100611, 100613};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103588(n);
                    }
                };
            }
            case 103589: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100725};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103589(n);
                    }
                };
            }
            case 103590: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100724};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103590(n);
                    }
                };
            }
            case 103593: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 3939, 100267};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103593(n);
                    }
                };
            }
            case 103594: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 3939, 100267};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103594(n);
                    }
                };
            }
            case 103595: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100158, 100327, 100365, 100390, 100509, 100522};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103595(n);
                    }
                };
            }
            case 103596: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376, 3939, 100158, 100327, 100365, 100390, 100522};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103596(n);
                    }
                };
            }
            case 103597: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376, 3939, 100327, 100553, 100554};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103597(n);
                    }
                };
            }
            case 103598: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100267, 100509, 100696};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103598(n);
                    }
                };
            }
            case 103599: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103599(n);
                    }
                };
            }
            case 103600: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100267, 100509, 100696};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103600(n);
                    }
                };
            }
            case 103601: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103601(n);
                    }
                };
            }
            case 103602: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347, 100681};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103602(n);
                    }
                };
            }
            case 103603: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4347, 100509, 100681};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103603(n);
                    }
                };
            }
            case 103604: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347, 100420};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103604(n);
                    }
                };
            }
            case 103605: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100267};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103605(n);
                    }
                };
            }
            case 103606: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103606(n);
                    }
                };
            }
            case 103607: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4357, 100316, 100442, 100466, 100662};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103607(n);
                    }
                };
            }
            case 103608: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3913, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103608(n);
                    }
                };
            }
            case 103609: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103609(n);
                    }
                };
            }
            case 103610: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103610(n);
                    }
                };
            }
            case 103611: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103611(n);
                    }
                };
            }
            case 103613: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103613(n);
                    }
                };
            }
            case 103614: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103614(n);
                    }
                };
            }
            case 103615: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103615(n);
                    }
                };
            }
            case 103616: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103616(n);
                    }
                };
            }
            case 103617: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103617(n);
                    }
                };
            }
            case 103618: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{138};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(138, n, 5);
                    }
                };
            }
            case 103619: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{367};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(367, n, 0);
                    }
                };
            }
            case 103620: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100317};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103620(n);
                    }
                };
            }
            case 103621: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103621(n);
                    }
                };
            }
            case 103622: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100479};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103622(n);
                    }
                };
            }
            case 103623: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100479};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103623(n);
                    }
                };
            }
            case 103624: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103624(n);
                    }
                };
            }
            case 103629: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103629(n);
                    }
                };
            }
            case 103630: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103630(n);
                    }
                };
            }
            case 103631: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103631(n);
                    }
                };
            }
            case 103633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103633(n);
                    }
                };
            }
            case 103634: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103634(n);
                    }
                };
            }
            case 103636: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103636(n);
                    }
                };
            }
            case 103638: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103638(n);
                    }
                };
            }
            case 103640: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103640(n);
                    }
                };
            }
            case 103642: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103642(n);
                    }
                };
            }
            case 103643: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4347, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103643(n);
                    }
                };
            }
            case 103644: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4347, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103644(n);
                    }
                };
            }
            case 103645: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103645(n);
                    }
                };
            }
            case 103646: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103646(n);
                    }
                };
            }
            case 103647: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103647(n);
                    }
                };
            }
            case 103648: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4347};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103648(n);
                    }
                };
            }
            case 103649: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4347, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103649(n);
                    }
                };
            }
            case 103657: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103657(n);
                    }
                };
            }
            case 103658: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100641};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103658(n);
                    }
                };
            }
            case 103659: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4358};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103659(n);
                    }
                };
            }
            case 103661: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 103662: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103662(n);
                    }
                };
            }
            case 103663: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 100442, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103663(n);
                    }
                };
            }
            case 103665: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103665(n);
                    }
                };
            }
            case 103666: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 103667: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100481};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103667(n);
                    }
                };
            }
            case 103668: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100652};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103668(n);
                    }
                };
            }
            case 103676: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 100442, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103676(n);
                    }
                };
            }
            case 103677: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103677(n);
                    }
                };
            }
            case 103678: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103678(n);
                    }
                };
            }
            case 103679: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103679(n);
                    }
                };
            }
            case 103680: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100471};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103680(n);
                    }
                };
            }
            case 103681: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100655};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103681(n);
                    }
                };
            }
            case 103682: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100652, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103682(n);
                    }
                };
            }
            case 103683: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103683(n);
                    }
                };
            }
            case 103685: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103685(n);
                    }
                };
            }
            case 103687: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103687(n);
                    }
                };
            }
            case 103688: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103688(n);
                    }
                };
            }
            case 103689: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103689(n);
                    }
                };
            }
            case 103690: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103690(n);
                    }
                };
            }
            case 103691: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103691(n);
                    }
                };
            }
            case 103692: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103692(n);
                    }
                };
            }
            case 103693: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103693(n);
                    }
                };
            }
            case 103694: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 100442, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103694(n);
                    }
                };
            }
            case 103695: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103695(n);
                    }
                };
            }
            case 103696: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103696(n);
                    }
                };
            }
            case 103697: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103697(n);
                    }
                };
            }
            case 103700: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100671};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103700(n);
                    }
                };
            }
            case 103701: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103701(n);
                    }
                };
            }
            case 103702: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103702(n);
                    }
                };
            }
            case 103703: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103703(n);
                    }
                };
            }
            case 103704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103704(n);
                    }
                };
            }
            case 103705: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100509};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103705(n);
                    }
                };
            }
            case 103708: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100682};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103708(n);
                    }
                };
            }
            case 103709: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100682};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103709(n);
                    }
                };
            }
            case 103710: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100267, 100509, 100696};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103710(n);
                    }
                };
            }
            case 103711: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 100683};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103711(n);
                    }
                };
            }
            case 103712: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 100267, 100509, 100696};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103712(n);
                    }
                };
            }
            case 103713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103713(n);
                    }
                };
            }
            case 103714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100869};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103714(n);
                    }
                };
            }
            case 103715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100869};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103715(n);
                    }
                };
            }
            case 103716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103716(n);
                    }
                };
            }
            case 103717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103717(n);
                    }
                };
            }
            case 103718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103718(n);
                    }
                };
            }
            case 103719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100179};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103719(n);
                    }
                };
            }
            case 103720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457, 100705};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103720(n);
                    }
                };
            }
            case 103721: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100456, 100457, 100705};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103721(n);
                    }
                };
            }
            case 103722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103722(n);
                    }
                };
            }
            case 103724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327, 100833};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103724(n);
                    }
                };
            }
            case 103725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103725(n);
                    }
                };
            }
            case 103726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103726(n);
                    }
                };
            }
            case 103727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103727(n);
                    }
                };
            }
            case 103728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103728(n);
                    }
                };
            }
            case 103729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100459};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103729(n);
                    }
                };
            }
            case 103730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100459};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103730(n);
                    }
                };
            }
            case 103731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100891};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103731(n);
                    }
                };
            }
            case 103732: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100891};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103732(n);
                    }
                };
            }
            case 103733: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100878};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103733(n);
                    }
                };
            }
            case 103734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100878};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103734(n);
                    }
                };
            }
            case 103735: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 1100244};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103735(n);
                    }
                };
            }
            case 103736: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103736(n);
                    }
                };
            }
            case 103737: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103737(n);
                    }
                };
            }
            case 103738: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103738(n);
                    }
                };
            }
            case 103739: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103739(n);
                    }
                };
            }
            case 103740: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100728};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103740(n);
                    }
                };
            }
            case 103742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100327, 100529};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103742(n);
                    }
                };
            }
            case 103743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103743(n);
                    }
                };
            }
            case 103744: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103744(n);
                    }
                };
            }
            case 103745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103745(n);
                    }
                };
            }
            case 103746: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100872};
                    }

                    public boolean evaluate(int n) {
                        return TunerConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(100872, n, 1);
                    }
                };
            }
            case 103750: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103750(n);
                    }
                };
            }
            case 103751: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103751(n);
                    }
                };
            }
            case 103752: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100457, 100705};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103752(n);
                    }
                };
            }
            case 103753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103753(n);
                    }
                };
            }
            case 103754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460, 100705};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103754(n);
                    }
                };
            }
            case 103755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103755(n);
                    }
                };
            }
            case 103756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103756(n);
                    }
                };
            }
            case 103757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100457};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103757(n);
                    }
                };
            }
            case 103758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103758(n);
                    }
                };
            }
            case 103759: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103759(n);
                    }
                };
            }
            case 103760: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379, 100327, 100460};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103760(n);
                    }
                };
            }
            case 103761: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100327, 100655, 100933};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103761(n);
                    }
                };
            }
            case 103762: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103762(n);
                    }
                };
            }
            case 103763: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100154, 100316, 100460, 100655, 100711};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103763(n);
                    }
                };
            }
            case 103766: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103766(n);
                    }
                };
            }
            case 103767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103767(n);
                    }
                };
            }
            case 103768: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4033, 4237, 100432};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103768(n);
                    }
                };
            }
            case 103770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5572};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103770(n);
                    }
                };
            }
            case 103994: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103994(n);
                    }
                };
            }
            case 103995: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103995(n);
                    }
                };
            }
            case 103996: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103996(n);
                    }
                };
            }
            case 103997: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103997(n);
                    }
                };
            }
            case 103998: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103998(n);
                    }
                };
            }
            case 103999: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5584};
                    }

                    public boolean evaluate(int n) {
                        return TunerScreenFactory.evalCond103999(n);
                    }
                };
            }
        }
        return null;
    }
}

