/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

public class EarlyAppsConditionBank
implements HMIConditionBank {
    private EarlyAppsScreenFactory screenFactory;

    public EarlyAppsConditionBank(EarlyAppsScreenFactory earlyAppsScreenFactory) {
        this.screenFactory = earlyAppsScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 2100005: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100106};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n, 0);
                    }
                };
            }
            case 2100006: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100108};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n, 0);
                    }
                };
            }
            case 2100007: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100110};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n, 0);
                    }
                };
            }
            case 2100008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100112};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n, 0);
                    }
                };
            }
            case 2100009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100114};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n, 0);
                    }
                };
            }
            case 2100010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100116};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n, 0);
                    }
                };
            }
            case 0x200B2B: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100118};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n, 0);
                    }
                };
            }
            case 2100012: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100120};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n, 0);
                    }
                };
            }
            case 2100013: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100122};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n, 0);
                    }
                };
            }
            case 2100014: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100124};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n, 0);
                    }
                };
            }
            case 2100015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100128};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n, 0);
                    }
                };
            }
            case 2100016: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100126};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n, 0);
                    }
                };
            }
            case 2100017: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100130};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n, 0);
                    }
                };
            }
            case 2100018: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100132};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n, 0);
                    }
                };
            }
            case 2100019: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100134};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n, 0);
                    }
                };
            }
            case 2100020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100136};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n, 0);
                    }
                };
            }
            case 2100077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 2100078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100166, n, 2);
                    }
                };
            }
            case 2100140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2100140(n);
                    }
                };
            }
            case 2100141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2100141(n);
                    }
                };
            }
            case 0x200BB2: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100174};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100174, n, 0);
                    }
                };
            }
            case 2100147: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100175};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100175, n, 0);
                    }
                };
            }
            case 2100148: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100176};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100176, n, 0);
                    }
                };
            }
            case 2100149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100177};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100177, n, 0);
                    }
                };
            }
            case 2100152: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 4);
                    }
                };
            }
            case 2100153: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 3);
                    }
                };
            }
            case 2100154: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 2);
                    }
                };
            }
            case 0x200BBB: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 0);
                    }
                };
            }
            case 2100332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 1);
                    }
                };
            }
            case 2100588: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100180};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2100588(n);
                    }
                };
            }
            case 2100653: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100196};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2100653(n);
                    }
                };
            }
            case 2100654: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100180};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2100654(n);
                    }
                };
            }
            case 2100655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100178};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100178, n, 0);
                    }
                };
            }
            case 2101279: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100196};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101279(n);
                    }
                };
            }
            case 0x201021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100106};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n, 0);
                    }
                };
            }
            case 0x201022: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100108};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n, 0);
                    }
                };
            }
            case 2101283: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100110};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n, 0);
                    }
                };
            }
            case 2101284: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100112};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n, 0);
                    }
                };
            }
            case 2101285: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100114};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n, 0);
                    }
                };
            }
            case 2101286: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100116};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n, 0);
                    }
                };
            }
            case 2101287: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100118};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n, 0);
                    }
                };
            }
            case 2101288: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100120};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n, 0);
                    }
                };
            }
            case 2101289: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100122};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n, 0);
                    }
                };
            }
            case 2101290: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100124};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n, 0);
                    }
                };
            }
            case 2101291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100126};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n, 0);
                    }
                };
            }
            case 2101292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100128};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n, 0);
                    }
                };
            }
            case 2101293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100130};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n, 0);
                    }
                };
            }
            case 2101294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100132};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n, 0);
                    }
                };
            }
            case 2101295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100134};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n, 0);
                    }
                };
            }
            case 2101296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100136};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n, 0);
                    }
                };
            }
            case 2101333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100106};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n, 0);
                    }
                };
            }
            case 2101334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100108};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n, 0);
                    }
                };
            }
            case 2101335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100110};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n, 0);
                    }
                };
            }
            case 2101336: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100112};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n, 0);
                    }
                };
            }
            case 2101337: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100114};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n, 0);
                    }
                };
            }
            case 2101338: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100116};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n, 0);
                    }
                };
            }
            case 2101339: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100118};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n, 0);
                    }
                };
            }
            case 2101340: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100120};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n, 0);
                    }
                };
            }
            case 2101341: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100122};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n, 0);
                    }
                };
            }
            case 2101342: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100124};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n, 0);
                    }
                };
            }
            case 2101343: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100126};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n, 0);
                    }
                };
            }
            case 2101344: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100128};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n, 0);
                    }
                };
            }
            case 2101345: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100130};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n, 0);
                    }
                };
            }
            case 2101346: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100132};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n, 0);
                    }
                };
            }
            case 2101347: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100134};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n, 0);
                    }
                };
            }
            case 2101348: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100136};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n, 0);
                    }
                };
            }
            case 2101403: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100196};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101403(n);
                    }
                };
            }
            case 2101438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100303};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101438(n);
                    }
                };
            }
            case 2101440: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100176, 2100178, 2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101440(n);
                    }
                };
            }
            case 2101441: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101441(n);
                    }
                };
            }
            case 2101442: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100177};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101442(n);
                    }
                };
            }
            case 2101443: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100179, 2100326};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101443(n);
                    }
                };
            }
            case 2101444: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 4073};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101444(n);
                    }
                };
            }
            case 2101445: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101445(n);
                    }
                };
            }
            case 2101446: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101446(n);
                    }
                };
            }
            case 2101515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100333};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101515(n);
                    }
                };
            }
            case 2101516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100333};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101516(n);
                    }
                };
            }
            case 2101517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100382};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101517(n);
                    }
                };
            }
            case 2101518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100507, 2100508};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101518(n);
                    }
                };
            }
            case 2101519: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100507};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101519(n);
                    }
                };
            }
            case 0x201110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100508};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101520(n);
                    }
                };
            }
            case 0x201112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100178, 2100179, 2100326};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101522(n);
                    }
                };
            }
            case 2101523: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100178, 2100406};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101523(n);
                    }
                };
            }
            case 2101524: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100166, 2100177};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101524(n);
                    }
                };
            }
            case 2101525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100156, 2100166, 2100176, 2100178};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101525(n);
                    }
                };
            }
            case 2101526: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100156};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101526(n);
                    }
                };
            }
            case 2101527: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915, 3939, 2100101};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101527(n);
                    }
                };
            }
            case 2101528: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4073, 2100101};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101528(n);
                    }
                };
            }
            case 2101529: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915, 3939, 2100708};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101529(n);
                    }
                };
            }
            case 2101530: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 4073, 2100708};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101530(n);
                    }
                };
            }
            case 2101531: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100382};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101531(n);
                    }
                };
            }
            case 2101532: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100196};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101532(n);
                    }
                };
            }
            case 2101533: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101533(n);
                    }
                };
            }
            case 2101534: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101534(n);
                    }
                };
            }
            case 2101535: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915, 3939, 2100099};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101535(n);
                    }
                };
            }
            case 0x201120: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4073, 2100099};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101536(n);
                    }
                };
            }
            case 0x201121: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101537(n);
                    }
                };
            }
            case 2101543: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100303};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100303, n, 2);
                    }
                };
            }
            case 2101549: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101549(n);
                    }
                };
            }
            case 2101550: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101550(n);
                    }
                };
            }
            case 2101553: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100106};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100106, n, 0);
                    }
                };
            }
            case 2101554: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100108};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100108, n, 0);
                    }
                };
            }
            case 2101555: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100110};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100110, n, 0);
                    }
                };
            }
            case 2101556: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100112};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100112, n, 0);
                    }
                };
            }
            case 2101557: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100114};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100114, n, 0);
                    }
                };
            }
            case 2101558: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100116};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100116, n, 0);
                    }
                };
            }
            case 2101559: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100118};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100118, n, 0);
                    }
                };
            }
            case 2101560: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100120};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100120, n, 0);
                    }
                };
            }
            case 2101561: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100122};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100122, n, 0);
                    }
                };
            }
            case 2101562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100124};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100124, n, 0);
                    }
                };
            }
            case 2101563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100126};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100126, n, 0);
                    }
                };
            }
            case 2101564: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100128};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100128, n, 0);
                    }
                };
            }
            case 2101565: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100130};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100130, n, 0);
                    }
                };
            }
            case 2101566: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100132};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100132, n, 0);
                    }
                };
            }
            case 2101567: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100134};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100134, n, 0);
                    }
                };
            }
            case 2101568: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100136};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100136, n, 0);
                    }
                };
            }
            case 2101569: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100179, n, 4);
                    }
                };
            }
            case 2101575: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100166, 2100179, 2100335};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101575(n);
                    }
                };
            }
            case 2101610: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101610(n);
                    }
                };
            }
            case 2101611: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604135);
                    }
                };
            }
            case 2101613: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101613(n);
                    }
                };
            }
            case 2101614: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101614(n);
                    }
                };
            }
            case 2101615: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604135);
                    }
                };
            }
            case 2101631: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100466};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101631(n);
                    }
                };
            }
            case 2101632: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100166, 2100466};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101632(n);
                    }
                };
            }
            case 2101633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100466};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100466, n, 0);
                    }
                };
            }
            case 2101634: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100166, 2100466};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101634(n);
                    }
                };
            }
            case 2101638: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x200CC2};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(0x200CC2, n, 1);
                    }
                };
            }
            case 2101639: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100422};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100422, n, 1);
                    }
                };
            }
            case 2101640: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100424};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100424, n, 1);
                    }
                };
            }
            case 2101641: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100429};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100429, n, 1);
                    }
                };
            }
            case 2101642: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100430};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100430, n, 1);
                    }
                };
            }
            case 2101643: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100431};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100431, n, 1);
                    }
                };
            }
            case 2101644: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100434};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100434, n, 1);
                    }
                };
            }
            case 2101645: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100408};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100408, n, 1);
                    }
                };
            }
            case 2101646: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100410};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100410, n, 1);
                    }
                };
            }
            case 2101647: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100414};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100414, n, 1);
                    }
                };
            }
            case 2101648: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x200CC0};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(0x200CC0, n, 1);
                    }
                };
            }
            case 2101649: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100417};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100417, n, 1);
                    }
                };
            }
            case 2101650: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100421};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100421, n, 1);
                    }
                };
            }
            case 2101651: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100423};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100423, n, 1);
                    }
                };
            }
            case 2101652: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 1);
                    }
                };
            }
            case 2101653: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 1);
                    }
                };
            }
            case 2101655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100466, 2100532};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101655(n);
                    }
                };
            }
            case 2101656: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100361, 2100368};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101656(n);
                    }
                };
            }
            case 2101660: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101660(n);
                    }
                };
            }
            case 2101661: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101661(n);
                    }
                };
            }
            case 2101662: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101662(n);
                    }
                };
            }
            case 2101663: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101663(n);
                    }
                };
            }
            case 2101667: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 2);
                    }
                };
            }
            case 2101668: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 1);
                    }
                };
            }
            case 2101669: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 0);
                    }
                };
            }
            case 2101670: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101670(n);
                    }
                };
            }
            case 2101671: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101672: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101673: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101675: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 1);
                    }
                };
            }
            case 2101677: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 2);
                    }
                };
            }
            case 2101679: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 0);
                    }
                };
            }
            case 2101680: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101680(n);
                    }
                };
            }
            case 2101681: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101681(n);
                    }
                };
            }
            case 2101682: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101682(n);
                    }
                };
            }
            case 2101683: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101683(n);
                    }
                };
            }
            case 2101687: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 2);
                    }
                };
            }
            case 2101688: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 1);
                    }
                };
            }
            case 2101689: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 0);
                    }
                };
            }
            case 2101690: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101690(n);
                    }
                };
            }
            case 2101691: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101692: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101693: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101695: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 1);
                    }
                };
            }
            case 2101697: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 2);
                    }
                };
            }
            case 2101699: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 0);
                    }
                };
            }
            case 2101700: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101700(n);
                    }
                };
            }
            case 2101701: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101701(n);
                    }
                };
            }
            case 2101702: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101702(n);
                    }
                };
            }
            case 2101703: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101703(n);
                    }
                };
            }
            case 2101704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101704(n);
                    }
                };
            }
            case 2101705: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101705(n);
                    }
                };
            }
            case 2101706: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101707: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101708: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 2101709: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100408, 2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101709(n);
                    }
                };
            }
            case 2101710: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101711: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100410, 2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101711(n);
                    }
                };
            }
            case 2101712: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100423};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101713(n);
                    }
                };
            }
            case 2101714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100417};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101715(n);
                    }
                };
            }
            case 2101716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 0x200CC0};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101717(n);
                    }
                };
            }
            case 2101718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100414};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101719(n);
                    }
                };
            }
            case 2101720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101721: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100421};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101721(n);
                    }
                };
            }
            case 2101722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 2101723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x200CC2, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101723(n);
                    }
                };
            }
            case 2101724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100422, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101725(n);
                    }
                };
            }
            case 2101726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100424, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101727(n);
                    }
                };
            }
            case 2101728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100431};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101729(n);
                    }
                };
            }
            case 2101730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100429};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101731(n);
                    }
                };
            }
            case 2101732: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101733: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100434};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101733(n);
                    }
                };
            }
            case 2101734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101735: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100430};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101735(n);
                    }
                };
            }
            case 2101736: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 2101741: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100362, 2100369};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101741(n);
                    }
                };
            }
            case 2101742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100491};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101742(n);
                    }
                };
            }
            case 2101743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100492};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101743(n);
                    }
                };
            }
            case 2101744: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100494};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101744(n);
                    }
                };
            }
            case 2101745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100491};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101745(n);
                    }
                };
            }
            case 2101746: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100492};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101746(n);
                    }
                };
            }
            case 2101747: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100494};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101747(n);
                    }
                };
            }
            case 2101750: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101751: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101752: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 2101754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 2101755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 2101756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101759: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 0x201200: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 0x201201: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100509};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101761(n);
                    }
                };
            }
            case 0x201202: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100509};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101762(n);
                    }
                };
            }
            case 2101763: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100376};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100376, n, 2);
                    }
                };
            }
            case 2101764: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100376};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100376, n, 2);
                    }
                };
            }
            case 2101765: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101765(n);
                    }
                };
            }
            case 2101766: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101766(n);
                    }
                };
            }
            case 2101767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100507};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101767(n);
                    }
                };
            }
            case 2101768: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100508};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101768(n);
                    }
                };
            }
            case 2101769: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n, 2);
                    }
                };
            }
            case 2101770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n, 3);
                    }
                };
            }
            case 2101771: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101771(n);
                    }
                };
            }
            case 2101772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101772(n);
                    }
                };
            }
            case 2101773: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100360, 2100365};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101773(n);
                    }
                };
            }
            case 2101779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101779(n);
                    }
                };
            }
            case 2101780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401, 2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101780(n);
                    }
                };
            }
            case 2101781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100510};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100510, n, 0);
                    }
                };
            }
            case 2101782: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 2101783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(601477, n, 2);
                    }
                };
            }
            case 2101784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 1);
                    }
                };
            }
            case 2101785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 1);
                    }
                };
            }
            case 2101786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100527};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101786(n);
                    }
                };
            }
            case 2101787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100527};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101787(n);
                    }
                };
            }
            case 2101788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100466, 2100532};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101788(n);
                    }
                };
            }
            case 2101789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100553, 2100562};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101789(n);
                    }
                };
            }
            case 2101790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100553};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101790(n);
                    }
                };
            }
            case 2101791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100179};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101791(n);
                    }
                };
            }
            case 0x201221: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101793(n);
                    }
                };
            }
            case 0x201222: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101794(n);
                    }
                };
            }
            case 2101795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101795(n);
                    }
                };
            }
            case 2101796: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101796(n);
                    }
                };
            }
            case 2101801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101801(n);
                    }
                };
            }
            case 2101802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101802(n);
                    }
                };
            }
            case 2101807: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 1);
                    }
                };
            }
            case 2101809: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 1);
                    }
                };
            }
            case 2101810: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100361, 2100368};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101810(n);
                    }
                };
            }
            case 2101811: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100362, 2100369};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101811(n);
                    }
                };
            }
            case 2101820: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n, 3);
                    }
                };
            }
            case 2101821: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100490};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100490, n, 2);
                    }
                };
            }
            case 2101823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100374};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100374, n, 1);
                    }
                };
            }
            case 2101824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100373};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100373, n, 1);
                    }
                };
            }
            case 2101825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100467};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100467, n, 1);
                    }
                };
            }
            case 2101826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100468};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100468, n, 1);
                    }
                };
            }
            case 2101827: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101827(n);
                    }
                };
            }
            case 2101829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101829(n);
                    }
                };
            }
            case 2101830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101830(n);
                    }
                };
            }
            case 2101831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3916};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3916, n, 5);
                    }
                };
            }
            case 2101832: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3916};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3916, n, 5);
                    }
                };
            }
            case 2101833: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101833(n);
                    }
                };
            }
            case 2101834: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101834(n);
                    }
                };
            }
            case 2101835: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101835(n);
                    }
                };
            }
            case 2101836: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100732};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100732, n, 1);
                    }
                };
            }
            case 2101837: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101837(n);
                    }
                };
            }
            case 2101838: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101838(n);
                    }
                };
            }
            case 2101839: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101839(n);
                    }
                };
            }
            case 2101840: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101840(n);
                    }
                };
            }
            case 2101841: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101841(n);
                    }
                };
            }
            case 2101842: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101842(n);
                    }
                };
            }
            case 2101843: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101843(n);
                    }
                };
            }
            case 2101844: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101844(n);
                    }
                };
            }
            case 2101845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101845(n);
                    }
                };
            }
            case 2101867: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100433, 2100472};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101867(n);
                    }
                };
            }
            case 2101868: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100433, 2100472};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101868(n);
                    }
                };
            }
            case 2101869: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100415, 2100481};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101869(n);
                    }
                };
            }
            case 2101870: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100415, 2100481};
                    }

                    public boolean evaluate(int n) {
                        return EarlyAppsScreenFactory.evalCond2101870(n);
                    }
                };
            }
        }
        return null;
    }
}

