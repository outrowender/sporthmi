/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenFactory;

public class ConnectivityConditionBank
implements HMIConditionBank {
    private ConnectivityScreenFactory screenFactory;

    public ConnectivityConditionBank(ConnectivityScreenFactory connectivityScreenFactory) {
        this.screenFactory = connectivityScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 2500000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500126};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusGreaterCondition(2500126, n, 0);
                    }
                };
            }
            case 2500004: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500004(n);
                    }
                };
            }
            case 2500005: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500117, n, 2);
                    }
                };
            }
            case 2500009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500119};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500119, n, 0);
                    }
                };
            }
            case 2500010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500010(n);
                    }
                };
            }
            case 2500011: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500011(n);
                    }
                };
            }
            case 2500012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500012(n);
                    }
                };
            }
            case 2500014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500016};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500016, n, 0);
                    }
                };
            }
            case 2500015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500019};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500019, n, 0);
                    }
                };
            }
            case 2500019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500066};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500066, n, 0);
                    }
                };
            }
            case 2500020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500066};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500066, n, 2);
                    }
                };
            }
            case 2500023: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500045};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500045, n, 1);
                    }
                };
            }
            case 2500031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x262624};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(0x262624, n, 0);
                    }
                };
            }
            case 2500032: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x262632};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(0x262632, n, 0);
                    }
                };
            }
            case 2500033: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500157};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500157, n, 0);
                    }
                };
            }
            case 2500034: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500034(n);
                    }
                };
            }
            case 2500035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x26262C, 2500148, 2500319};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500035(n);
                    }
                };
            }
            case 2500036: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500148, n, 1);
                    }
                };
            }
            case 2500037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x26262C, 2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500037(n);
                    }
                };
            }
            case 2500039: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500148, n, 1);
                    }
                };
            }
            case 2500051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 2500231};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500051(n);
                    }
                };
            }
            case 2500052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 2500231};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500052(n);
                    }
                };
            }
            case 2500053: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500119};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500119, n, 0);
                    }
                };
            }
            case 2500079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500105};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500105, n, 3);
                    }
                };
            }
            case 2500080: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500105};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500105, n, 2);
                    }
                };
            }
            case 2500081: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500105};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500105, n, 1);
                    }
                };
            }
            case 0x262629: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500187, n, 2);
                    }
                };
            }
            case 0x26262A: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500187, n, 2);
                    }
                };
            }
            case 0x26262B: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500188};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500188, n, 2);
                    }
                };
            }
            case 0x26262C: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500188};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500188, n, 2);
                    }
                };
            }
            case 0x26262D: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500189};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500189, n, 2);
                    }
                };
            }
            case 0x26262E: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500189};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500189, n, 2);
                    }
                };
            }
            case 0x26262F: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500190};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500190, n, 2);
                    }
                };
            }
            case 2500144: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500190};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500190, n, 2);
                    }
                };
            }
            case 2500145: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500191, n, 2);
                    }
                };
            }
            case 0x262632: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500191, n, 2);
                    }
                };
            }
            case 0x262669: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300847};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500201(n);
                    }
                };
            }
            case 2500231: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500231(n);
                    }
                };
            }
            case 0x262688: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500232(n);
                    }
                };
            }
            case 2500234: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300847};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500234(n);
                    }
                };
            }
            case 2500289: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 516};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500289(n);
                    }
                };
            }
            case 0x2626C2: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 516};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500290(n);
                    }
                };
            }
            case 2500321: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500212};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500321(n);
                    }
                };
            }
            case 0x2626E2: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500212};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500322(n);
                    }
                };
            }
            case 2500324: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500212};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500324(n);
                    }
                };
            }
            case 2500381: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500211};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500211, n, 1);
                    }
                };
            }
            case 2500382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500209};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500209, n, 1);
                    }
                };
            }
            case 2500383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 2);
                    }
                };
            }
            case 2500384: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 1);
                    }
                };
            }
            case 2500385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 0);
                    }
                };
            }
            case 0x262722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 1);
                    }
                };
            }
            case 2500387: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 1);
                    }
                };
            }
            case 2500388: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 1);
                    }
                };
            }
            case 2500389: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 0);
                    }
                };
            }
            case 0x262726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 0);
                    }
                };
            }
            case 0x262727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500218};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500218, n, 0);
                    }
                };
            }
            case 2500420: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500420(n);
                    }
                };
            }
            case 2500422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500220};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500422(n);
                    }
                };
            }
            case 2500423: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500229};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500423(n);
                    }
                };
            }
            case 2500425: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3899, 2500316};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500425(n);
                    }
                };
            }
            case 2500426: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3897};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500426(n);
                    }
                };
            }
            case 2500427: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3897};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500427(n);
                    }
                };
            }
            case 0x262767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{492};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500455(n);
                    }
                };
            }
            case 2500456: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500221};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500456(n);
                    }
                };
            }
            case 2500457: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117, 2500222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500457(n);
                    }
                };
            }
            case 2500458: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117, 2500222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500458(n);
                    }
                };
            }
            case 2500459: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500459(n);
                    }
                };
            }
            case 2500460: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500460(n);
                    }
                };
            }
            case 2500516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500066, 2500223};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500516(n);
                    }
                };
            }
            case 2500543: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5619, 0x262696};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500543(n);
                    }
                };
            }
            case 2500544: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x262696};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(0x262696, n, 0);
                    }
                };
            }
            case 2500571: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x262696};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(0x262696, n, 0);
                    }
                };
            }
            case 2500629: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500629(n);
                    }
                };
            }
            case 2500630: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500630(n);
                    }
                };
            }
            case 2500633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4442};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500633(n);
                    }
                };
            }
            case 2500659: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500187, n, 2);
                    }
                };
            }
            case 2500660: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500187, n, 2);
                    }
                };
            }
            case 2500661: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500188};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500188, n, 2);
                    }
                };
            }
            case 2500662: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500188};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500188, n, 2);
                    }
                };
            }
            case 2500663: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500189};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500189, n, 2);
                    }
                };
            }
            case 2500664: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500189};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500189, n, 2);
                    }
                };
            }
            case 2500665: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500190};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500190, n, 2);
                    }
                };
            }
            case 2500666: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500190};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500190, n, 2);
                    }
                };
            }
            case 2500667: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500191, n, 2);
                    }
                };
            }
            case 2500668: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500191, n, 2);
                    }
                };
            }
            case 2500669: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500148, n, 1);
                    }
                };
            }
            case 2500671: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500148, n, 0);
                    }
                };
            }
            case 2500734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 4196};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500734(n);
                    }
                };
            }
            case 2500756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 2500066};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500756(n);
                    }
                };
            }
            case 2500758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500229};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500229, n, 0);
                    }
                };
            }
            case 2500829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 0);
                    }
                };
            }
            case 2500830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 1);
                    }
                };
            }
            case 2500831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 0);
                    }
                };
            }
            case 2500832: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 1);
                    }
                };
            }
            case 2500833: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 0);
                    }
                };
            }
            case 2500834: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 1);
                    }
                };
            }
            case 2500835: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117, 2500222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500835(n);
                    }
                };
            }
            case 2500861: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500066, 2500223};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500861(n);
                    }
                };
            }
            case 2500873: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 12);
                    }
                };
            }
            case 2500874: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 11);
                    }
                };
            }
            case 2500897: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500105};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500897(n);
                    }
                };
            }
            case 2500920: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187, 2500188, 2500189, 2500190, 2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500920(n);
                    }
                };
            }
            case 2500921: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500187, 2500188, 2500189, 2500190, 2500191};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500921(n);
                    }
                };
            }
            case 2500946: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 300222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500946(n);
                    }
                };
            }
            case 2500947: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 2500117};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500947(n);
                    }
                };
            }
            case 2500948: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500316};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500316, n, 1);
                    }
                };
            }
            case 2500949: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500316};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500316, n, 1);
                    }
                };
            }
            case 2500950: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500316, 2500353};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500950(n);
                    }
                };
            }
            case 2500951: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500316};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500316, n, 1);
                    }
                };
            }
            case 2500952: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 463, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500952(n);
                    }
                };
            }
            case 2500953: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500953(n);
                    }
                };
            }
            case 2500954: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 487, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500954(n);
                    }
                };
            }
            case 2500956: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{492, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500956(n);
                    }
                };
            }
            case 2500957: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500957(n);
                    }
                };
            }
            case 2500958: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500958(n);
                    }
                };
            }
            case 2500959: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500959(n);
                    }
                };
            }
            case 2500960: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500960(n);
                    }
                };
            }
            case 2500961: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500961(n);
                    }
                };
            }
            case 0x262962: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500962(n);
                    }
                };
            }
            case 2500963: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500963(n);
                    }
                };
            }
            case 2500964: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500964(n);
                    }
                };
            }
            case 2500965: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500965(n);
                    }
                };
            }
            case 0x262966: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500966(n);
                    }
                };
            }
            case 2500967: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500967(n);
                    }
                };
            }
            case 0x262969: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500117, 2500222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500969(n);
                    }
                };
            }
            case 2500970: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500066, 2500223};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500970(n);
                    }
                };
            }
            case 2500973: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500973(n);
                    }
                };
            }
            case 2500974: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500974(n);
                    }
                };
            }
            case 2500975: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500975(n);
                    }
                };
            }
            case 2500976: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500976(n);
                    }
                };
            }
            case 2500977: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{492};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500977(n);
                    }
                };
            }
            case 2500978: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 11);
                    }
                };
            }
            case 2500979: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 12);
                    }
                };
            }
            case 2500980: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 5583, 5588, 300227, 300370, 300612, 300614, 300664, 300847, 300952, 300953, 300975, 2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500980(n);
                    }
                };
            }
            case 2500981: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500981(n);
                    }
                };
            }
            case 2500983: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4451};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500983(n);
                    }
                };
            }
            case 2500984: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4451};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500984(n);
                    }
                };
            }
            case 2500985: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300222};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500985(n);
                    }
                };
            }
            case 2500986: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4239};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500986(n);
                    }
                };
            }
            case 2500987: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4239};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500987(n);
                    }
                };
            }
            case 2500988: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4367};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4367, n, 0);
                    }
                };
            }
            case 2500989: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4239};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500989(n);
                    }
                };
            }
            case 2500990: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500990(n);
                    }
                };
            }
            case 2500991: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500316, 2500353};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500991(n);
                    }
                };
            }
            case 2500992: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 0);
                    }
                };
            }
            case 2500993: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500285};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500285, n, 1);
                    }
                };
            }
            case 2500994: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500362};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500362, n, 0);
                    }
                };
            }
            case 2500995: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500995(n);
                    }
                };
            }
            case 2500996: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500366};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500366, n, 0);
                    }
                };
            }
            case 2500997: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2500997(n);
                    }
                };
            }
            case 2500998: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500359};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2500359, n, 0);
                    }
                };
            }
            case 2500999: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500368};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500368, n, 1);
                    }
                };
            }
            case 2501001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501001(n);
                    }
                };
            }
            case 2501002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501002(n);
                    }
                };
            }
            case 2501008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4442};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501008(n);
                    }
                };
            }
            case 2501009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500220, 2500229};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501009(n);
                    }
                };
            }
            case 2501012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501012(n);
                    }
                };
            }
            case 2501013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501013(n);
                    }
                };
            }
            case 2501018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500368};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500368, n, 1);
                    }
                };
            }
            case 2501019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4239, 5583, 5588, 300292};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501019(n);
                    }
                };
            }
            case 2501020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4451};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501020(n);
                    }
                };
            }
            case 2501022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{494, 5583, 5588, 300227, 300370, 300612, 300614, 300664, 300952, 300953, 300975, 2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501022(n);
                    }
                };
            }
            case 2501023: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501023(n);
                    }
                };
            }
            case 2501024: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501024(n);
                    }
                };
            }
            case 2501025: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501025(n);
                    }
                };
            }
            case 2501026: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501026(n);
                    }
                };
            }
            case 2501027: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501027(n);
                    }
                };
            }
            case 2501028: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501028(n);
                    }
                };
            }
            case 2501029: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501029(n);
                    }
                };
            }
            case 2501030: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501030(n);
                    }
                };
            }
            case 2501031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501031(n);
                    }
                };
            }
            case 2501032: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501032(n);
                    }
                };
            }
            case 2501033: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501033(n);
                    }
                };
            }
            case 2501034: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501034(n);
                    }
                };
            }
            case 2501035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501035(n);
                    }
                };
            }
            case 2501036: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501036(n);
                    }
                };
            }
            case 2501037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501037(n);
                    }
                };
            }
            case 2501038: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501038(n);
                    }
                };
            }
            case 2501039: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 1);
                    }
                };
            }
            case 2501040: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501040(n);
                    }
                };
            }
            case 2501045: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501046: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501047: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501048(n);
                    }
                };
            }
            case 2501049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 1);
                    }
                };
            }
            case 2501052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501052(n);
                    }
                };
            }
            case 2501054: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501055: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501056: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500151, n, 2);
                    }
                };
            }
            case 2501057: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500151};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501057(n);
                    }
                };
            }
            case 2501095: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5583, 5588, 5619};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501095(n);
                    }
                };
            }
            case 2501096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5583, 5588, 5619};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501096(n);
                    }
                };
            }
            case 2501097: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300292};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300292, n, 1);
                    }
                };
            }
            case 2501098: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501098(n);
                    }
                };
            }
            case 2501099: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501099(n);
                    }
                };
            }
            case 2501100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501100(n);
                    }
                };
            }
            case 2501101: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501101(n);
                    }
                };
            }
            case 2501102: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501102(n);
                    }
                };
            }
            case 2501103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501103(n);
                    }
                };
            }
            case 2501104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501104(n);
                    }
                };
            }
            case 2501105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501105(n);
                    }
                };
            }
            case 2501107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501107(n);
                    }
                };
            }
            case 2501108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501108(n);
                    }
                };
            }
            case 2501109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501109(n);
                    }
                };
            }
            case 2501110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501110(n);
                    }
                };
            }
            case 2501111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501111(n);
                    }
                };
            }
            case 2501112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501112(n);
                    }
                };
            }
            case 2501113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return ConnectivityScreenFactory.evalCond2501113(n);
                    }
                };
            }
        }
        return null;
    }
}

