/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenFactory;

public class InfoConditionBank
implements HMIConditionBank {
    private InfoScreenFactory screenFactory;

    public InfoConditionBank(InfoScreenFactory infoScreenFactory) {
        this.screenFactory = infoScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 500003: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500003(n);
                    }
                };
            }
            case 500006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 500007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500007(n);
                    }
                };
            }
            case 500008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500008(n);
                    }
                };
            }
            case 500009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500009(n);
                    }
                };
            }
            case 500012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500012(n);
                    }
                };
            }
            case 500013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500013(n);
                    }
                };
            }
            case 500016: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500016(n);
                    }
                };
            }
            case 500017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 500019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500176};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500019(n);
                    }
                };
            }
            case 500020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 401703};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500020(n);
                    }
                };
            }
            case 500021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 401703};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500021(n);
                    }
                };
            }
            case 500022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 401703};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500022(n);
                    }
                };
            }
            case 500025: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500144};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500025(n);
                    }
                };
            }
            case 500026: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500026(n);
                    }
                };
            }
            case 500027: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 500028: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500028(n);
                    }
                };
            }
            case 500029: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500029(n);
                    }
                };
            }
            case 500030: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 500031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500031(n);
                    }
                };
            }
            case 500032: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500182};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500032(n);
                    }
                };
            }
            case 500035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500192};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500035(n);
                    }
                };
            }
            case 500036: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{376};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500036(n);
                    }
                };
            }
            case 500037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500037(n);
                    }
                };
            }
            case 500038: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 500039: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500039(n);
                    }
                };
            }
            case 500041: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500041(n);
                    }
                };
            }
            case 500042: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 500045: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500045(n);
                    }
                };
            }
            case 500046: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 500047: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500047(n);
                    }
                };
            }
            case 500048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500048(n);
                    }
                };
            }
            case 500049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500049(n);
                    }
                };
            }
            case 500051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500051(n);
                    }
                };
            }
            case 500052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 500055: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{500192};
                    }

                    public boolean evaluate(int n) {
                        return InfoConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(500192, n, 1);
                    }
                };
            }
            case 500056: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500056(n);
                    }
                };
            }
            case 500057: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500057(n);
                    }
                };
            }
            case 500058: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500058(n);
                    }
                };
            }
            case 500059: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500059(n);
                    }
                };
            }
            case 500060: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500060(n);
                    }
                };
            }
            case 500061: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500061(n);
                    }
                };
            }
            case 500062: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500062(n);
                    }
                };
            }
            case 500063: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500063(n);
                    }
                };
            }
            case 500064: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500064(n);
                    }
                };
            }
            case 500065: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500065(n);
                    }
                };
            }
            case 500066: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500066(n);
                    }
                };
            }
            case 500067: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500067(n);
                    }
                };
            }
            case 500068: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500068(n);
                    }
                };
            }
            case 500069: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500069(n);
                    }
                };
            }
            case 500070: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500070(n);
                    }
                };
            }
            case 500071: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500071(n);
                    }
                };
            }
            case 500072: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500072(n);
                    }
                };
            }
            case 500073: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500073(n);
                    }
                };
            }
            case 500074: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500074(n);
                    }
                };
            }
            case 500075: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500075(n);
                    }
                };
            }
            case 500076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500076(n);
                    }
                };
            }
            case 500077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500077(n);
                    }
                };
            }
            case 500078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500078(n);
                    }
                };
            }
            case 500079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500079(n);
                    }
                };
            }
            case 500080: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500080(n);
                    }
                };
            }
            case 500085: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500085(n);
                    }
                };
            }
            case 500086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500086(n);
                    }
                };
            }
            case 500087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500087(n);
                    }
                };
            }
            case 500088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 5624, 400490, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500088(n);
                    }
                };
            }
            case 500089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500089(n);
                    }
                };
            }
            case 500090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 401057};
                    }

                    public boolean evaluate(int n) {
                        return InfoScreenFactory.evalCond500090(n);
                    }
                };
            }
        }
        return null;
    }
}

