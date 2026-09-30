/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

public class PhoneConditionBank
implements HMIConditionBank {
    private PhoneScreenFactory screenFactory;

    public PhoneConditionBank(PhoneScreenFactory phoneScreenFactory) {
        this.screenFactory = phoneScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 300001: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{15, 350, 300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300001(n);
                    }
                };
            }
            case 300002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300227, 300472, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300002(n);
                    }
                };
            }
            case 300091: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 300093: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{512, 300227, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300093(n);
                    }
                };
            }
            case 300095: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300095(n);
                    }
                };
            }
            case 300096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300096(n);
                    }
                };
            }
            case 300098: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{187};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(187, n, 2);
                    }
                };
            }
            case 300099: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{187};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300099(n);
                    }
                };
            }
            case 300100: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{187};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(187, n, 4);
                    }
                };
            }
            case 300101: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 300664, 301155};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300101(n);
                    }
                };
            }
            case 300103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 359, 442, 447, 523, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300103(n);
                    }
                };
            }
            case 300104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300104(n);
                    }
                };
            }
            case 300105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 263, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300105(n);
                    }
                };
            }
            case 300106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 259, 261, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300106(n);
                    }
                };
            }
            case 300107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442, 498};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300107(n);
                    }
                };
            }
            case 300108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300108(n);
                    }
                };
            }
            case 300111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300111(n);
                    }
                };
            }
            case 300112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300112(n);
                    }
                };
            }
            case 300113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300113(n);
                    }
                };
            }
            case 300114: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300114(n);
                    }
                };
            }
            case 300116: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300116(n);
                    }
                };
            }
            case 300248: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 300222, 300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300248(n);
                    }
                };
            }
            case 300382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300686};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300686, n, 1);
                    }
                };
            }
            case 300383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 300686};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300383(n);
                    }
                };
            }
            case 300384: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300384(n);
                    }
                };
            }
            case 300385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300385(n);
                    }
                };
            }
            case 300386: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 300887: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 447, 523, 549, 4004};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300887(n);
                    }
                };
            }
            case 300888: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 442, 447, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300888(n);
                    }
                };
            }
            case 300889: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 447, 459};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300889(n);
                    }
                };
            }
            case 300890: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(447, n, 17);
                    }
                };
            }
            case 300891: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300891(n);
                    }
                };
            }
            case 300892: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300892(n);
                    }
                };
            }
            case 300893: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 447, 459};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300893(n);
                    }
                };
            }
            case 300894: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447, 300680};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300894(n);
                    }
                };
            }
            case 300895: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447, 300680};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300895(n);
                    }
                };
            }
            case 300896: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(447, n, 11);
                    }
                };
            }
            case 300897: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond300897(n);
                    }
                };
            }
            case 300911: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300687};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300687, n, 0);
                    }
                };
            }
            case 301081: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301122};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301081(n);
                    }
                };
            }
            case 301082: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301082(n);
                    }
                };
            }
            case 301084: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301129};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301084(n);
                    }
                };
            }
            case 301085: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301117};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301085(n);
                    }
                };
            }
            case 301086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301123};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301086(n);
                    }
                };
            }
            case 301087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301128};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301087(n);
                    }
                };
            }
            case 301088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301124};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301124, n, 2);
                    }
                };
            }
            case 301089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301126};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301126, n, 2);
                    }
                };
            }
            case 301090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301121};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301121, n, 2);
                    }
                };
            }
            case 301091: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300462, 301118};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301091(n);
                    }
                };
            }
            case 301093: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 2200445};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301093(n);
                    }
                };
            }
            case 301587: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301587(n);
                    }
                };
            }
            case 301588: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301588(n);
                    }
                };
            }
            case 301597: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301597(n);
                    }
                };
            }
            case 301598: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{512};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301598(n);
                    }
                };
            }
            case 301601: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301601(n);
                    }
                };
            }
            case 301602: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301602(n);
                    }
                };
            }
            case 301603: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301603(n);
                    }
                };
            }
            case 301604: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301604(n);
                    }
                };
            }
            case 301605: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301605(n);
                    }
                };
            }
            case 301608: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301608(n);
                    }
                };
            }
            case 301613: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300441, 300669, 300687, 300698};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301613(n);
                    }
                };
            }
            case 301614: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705, 300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301614(n);
                    }
                };
            }
            case 301615: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300707, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301615(n);
                    }
                };
            }
            case 301616: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300707, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301616(n);
                    }
                };
            }
            case 301617: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300707, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301617(n);
                    }
                };
            }
            case 301618: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300707, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301618(n);
                    }
                };
            }
            case 301619: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300707, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301619(n);
                    }
                };
            }
            case 301794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300723, n, 1);
                    }
                };
            }
            case 301795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond301795(n);
                    }
                };
            }
            case 301964: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 302133: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4367};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302133(n);
                    }
                };
            }
            case 302134: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{513, 300292, 301035, 301043};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302134(n);
                    }
                };
            }
            case 302137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300731, 300830};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302137(n);
                    }
                };
            }
            case 302138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{513, 301035, 301043};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302138(n);
                    }
                };
            }
            case 302304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300735};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300735, n, 0);
                    }
                };
            }
            case 302479: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302479(n);
                    }
                };
            }
            case 302480: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 512};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302480(n);
                    }
                };
            }
            case 302483: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302483(n);
                    }
                };
            }
            case 302484: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300222};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302484(n);
                    }
                };
            }
            case 302485: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300222};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302485(n);
                    }
                };
            }
            case 302486: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302486(n);
                    }
                };
            }
            case 302652: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302652(n);
                    }
                };
            }
            case 302653: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302653(n);
                    }
                };
            }
            case 302654: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300227, 300664, 300952, 300953};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302654(n);
                    }
                };
            }
            case 302655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 300686};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302655(n);
                    }
                };
            }
            case 302656: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 302657: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 302824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300719, 300721, 300723};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302824(n);
                    }
                };
            }
            case 302825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 300398, 300686, 300718, 300748};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302825(n);
                    }
                };
            }
            case 302826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302826(n);
                    }
                };
            }
            case 302989: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300705, n, 0);
                    }
                };
            }
            case 302990: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300705, n, 0);
                    }
                };
            }
            case 302991: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705, 300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond302991(n);
                    }
                };
            }
            case 302992: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301131};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301131, n, 1);
                    }
                };
            }
            case 302993: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301131};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301131, n, 0);
                    }
                };
            }
            case 303155: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4043};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303155(n);
                    }
                };
            }
            case 303157: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300370};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300370, n, 0);
                    }
                };
            }
            case 303332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 300227};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303332(n);
                    }
                };
            }
            case 303333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300221};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303333(n);
                    }
                };
            }
            case 303334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5619, 300729};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303334(n);
                    }
                };
            }
            case 303335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 300221};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303335(n);
                    }
                };
            }
            case 303336: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5619, 300221, 300729};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303336(n);
                    }
                };
            }
            case 303338: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303338(n);
                    }
                };
            }
            case 303341: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303341(n);
                    }
                };
            }
            case 303342: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{494, 5583, 5588, 300370, 300664, 300729};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303342(n);
                    }
                };
            }
            case 303344: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 3848, 4091, 300370, 300382};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303344(n);
                    }
                };
            }
            case 303345: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303345(n);
                    }
                };
            }
            case 303346: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300331};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303346(n);
                    }
                };
            }
            case 303351: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303351(n);
                    }
                };
            }
            case 303353: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300402};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300402, n, 1);
                    }
                };
            }
            case 303354: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300764};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300764, n, 1);
                    }
                };
            }
            case 303355: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300764};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300764, n, 0);
                    }
                };
            }
            case 303356: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 300766, 300767, 300769};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303356(n);
                    }
                };
            }
            case 303357: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 300769};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303357(n);
                    }
                };
            }
            case 303358: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300769};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300769, n, 0);
                    }
                };
            }
            case 303359: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300770};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300770, n, 1);
                    }
                };
            }
            case 303684: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4515};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4515, n, 0);
                    }
                };
            }
            case 303685: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4515};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4515, n, 1);
                    }
                };
            }
            case 303844: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303844(n);
                    }
                };
            }
            case 303845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303845(n);
                    }
                };
            }
            case 303846: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303846(n);
                    }
                };
            }
            case 303847: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303847(n);
                    }
                };
            }
            case 303848: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303848(n);
                    }
                };
            }
            case 303849: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303849(n);
                    }
                };
            }
            case 303850: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303850(n);
                    }
                };
            }
            case 303851: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303851(n);
                    }
                };
            }
            case 303852: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303852(n);
                    }
                };
            }
            case 303853: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303853(n);
                    }
                };
            }
            case 303854: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300703};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303854(n);
                    }
                };
            }
            case 303855: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300703};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond303855(n);
                    }
                };
            }
            case 304166: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304166(n);
                    }
                };
            }
            case 304168: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304168(n);
                    }
                };
            }
            case 304169: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304169(n);
                    }
                };
            }
            case 304328: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300698, 300806};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304328(n);
                    }
                };
            }
            case 304494: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 442, 447, 459, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304494(n);
                    }
                };
            }
            case 304496: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304496(n);
                    }
                };
            }
            case 304499: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304499(n);
                    }
                };
            }
            case 304500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304500(n);
                    }
                };
            }
            case 304501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304501(n);
                    }
                };
            }
            case 304502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304502(n);
                    }
                };
            }
            case 304503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304503(n);
                    }
                };
            }
            case 304505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304505(n);
                    }
                };
            }
            case 304506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304506(n);
                    }
                };
            }
            case 304508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304508(n);
                    }
                };
            }
            case 304510: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304510(n);
                    }
                };
            }
            case 304512: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304512(n);
                    }
                };
            }
            case 304516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304516(n);
                    }
                };
            }
            case 304518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304518(n);
                    }
                };
            }
            case 304520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304520(n);
                    }
                };
            }
            case 304522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304522(n);
                    }
                };
            }
            case 304524: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304524(n);
                    }
                };
            }
            case 304525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304525(n);
                    }
                };
            }
            case 304527: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300418};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304527(n);
                    }
                };
            }
            case 304529: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304529(n);
                    }
                };
            }
            case 304531: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 0);
                    }
                };
            }
            case 304533: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304533(n);
                    }
                };
            }
            case 304534: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304534(n);
                    }
                };
            }
            case 304535: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 549, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304535(n);
                    }
                };
            }
            case 304690: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300418};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304690(n);
                    }
                };
            }
            case 304845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304845(n);
                    }
                };
            }
            case 304846: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond304846(n);
                    }
                };
            }
            case 305312: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 3848, 4091, 300370, 300382};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305312(n);
                    }
                };
            }
            case 305313: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4006};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(4006, n, 0);
                    }
                };
            }
            case 305466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300817, n, 1);
                    }
                };
            }
            case 305467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305467(n);
                    }
                };
            }
            case 305469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305469(n);
                    }
                };
            }
            case 305471: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305471(n);
                    }
                };
            }
            case 305473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305473(n);
                    }
                };
            }
            case 305475: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300817, n, 1);
                    }
                };
            }
            case 305842: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300865};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300865, n, 1);
                    }
                };
            }
            case 305844: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300865};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305844(n);
                    }
                };
            }
            case 305845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300865};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305845(n);
                    }
                };
            }
            case 305905: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300441};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond305905(n);
                    }
                };
            }
            case 305973: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300721};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300721, n, 1);
                    }
                };
            }
            case 305974: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300398};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300398, n, 1);
                    }
                };
            }
            case 305975: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300767};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300767, n, 1);
                    }
                };
            }
            case 306039: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306040: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306041: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306042: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306043: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306044: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306045: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306046: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306047: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306050: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond306051(n);
                    }
                };
            }
            case 306052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond306052(n);
                    }
                };
            }
            case 306054: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(509, n, 1);
                    }
                };
            }
            case 306055: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(509, n, 1);
                    }
                };
            }
            case 306120: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200353};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200353, n, 1);
                    }
                };
            }
            case 306121: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306124: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 306402: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{15, 350, 300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond306402(n);
                    }
                };
            }
            case 306753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300705, n, 0);
                    }
                };
            }
            case 306754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300705};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300705, n, 0);
                    }
                };
            }
            case 306756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300445};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300445, n, 0);
                    }
                };
            }
            case 306757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300446};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300446, n, 0);
                    }
                };
            }
            case 306758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300444};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300444, n, 0);
                    }
                };
            }
            case 307094: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{363, 300227, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307094(n);
                    }
                };
            }
            case 307095: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4153};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307095(n);
                    }
                };
            }
            case 307096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300927};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307096(n);
                    }
                };
            }
            case 307097: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300927};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307097(n);
                    }
                };
            }
            case 307170: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300927};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307170(n);
                    }
                };
            }
            case 307171: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300927};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307171(n);
                    }
                };
            }
            case 307172: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307172(n);
                    }
                };
            }
            case 307248: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200237};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200237, n, 1);
                    }
                };
            }
            case 307250: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307250(n);
                    }
                };
            }
            case 307251: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307251(n);
                    }
                };
            }
            case 307253: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307253(n);
                    }
                };
            }
            case 307254: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307254(n);
                    }
                };
            }
            case 307255: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307255(n);
                    }
                };
            }
            case 307333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(3915, n, 0);
                    }
                };
            }
            case 307412: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(3915, n, 0);
                    }
                };
            }
            case 307520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307520(n);
                    }
                };
            }
            case 307931: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301127};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond307931(n);
                    }
                };
            }
            case 308290: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300954};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308290(n);
                    }
                };
            }
            case 308291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300954};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308291(n);
                    }
                };
            }
            case 308295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300951, 301150};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308295(n);
                    }
                };
            }
            case 308296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300951, 301150};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308296(n);
                    }
                };
            }
            case 308297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3848, 4091, 4177, 4196, 4350, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308297(n);
                    }
                };
            }
            case 308298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4177, 4239};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308298(n);
                    }
                };
            }
            case 308299: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 4091, 4177, 4196, 4350, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308299(n);
                    }
                };
            }
            case 308300: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4177};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308300(n);
                    }
                };
            }
            case 308301: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308301(n);
                    }
                };
            }
            case 308302: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308302(n);
                    }
                };
            }
            case 308303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308303(n);
                    }
                };
            }
            case 308304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308304(n);
                    }
                };
            }
            case 308305: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308305(n);
                    }
                };
            }
            case 308306: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308306(n);
                    }
                };
            }
            case 308307: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308307(n);
                    }
                };
            }
            case 308308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308308(n);
                    }
                };
            }
            case 308309: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308309(n);
                    }
                };
            }
            case 308310: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308310(n);
                    }
                };
            }
            case 308311: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308311(n);
                    }
                };
            }
            case 308312: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308312(n);
                    }
                };
            }
            case 308313: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308313(n);
                    }
                };
            }
            case 308314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301035, 301150};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308314(n);
                    }
                };
            }
            case 308315: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301035, 301150};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308315(n);
                    }
                };
            }
            case 308316: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301027, 301028, 301035, 301036};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308316(n);
                    }
                };
            }
            case 308317: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301027, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308317(n);
                    }
                };
            }
            case 308318: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301027, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308318(n);
                    }
                };
            }
            case 308319: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301027, 301028, 301036};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308319(n);
                    }
                };
            }
            case 308320: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301026, 301028, 301037, 301038};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308320(n);
                    }
                };
            }
            case 308321: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 3939, 300227, 300370, 300664, 301025, 301026};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308321(n);
                    }
                };
            }
            case 308322: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301025, 301026, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308322(n);
                    }
                };
            }
            case 308323: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301025, 301026, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308323(n);
                    }
                };
            }
            case 308324: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301025, 301026, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308324(n);
                    }
                };
            }
            case 308325: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301025, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308325(n);
                    }
                };
            }
            case 308326: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300955, 301027};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308326(n);
                    }
                };
            }
            case 308327: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4367, 301027, 301028};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308327(n);
                    }
                };
            }
            case 308328: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4367, 300669, 301027, 301028};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308328(n);
                    }
                };
            }
            case 308329: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300669};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308329(n);
                    }
                };
            }
            case 308330: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300669};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308330(n);
                    }
                };
            }
            case 308331: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{155, 442, 3939, 4646};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308331(n);
                    }
                };
            }
            case 308332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{154, 155, 376, 442, 3939, 4646};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308332(n);
                    }
                };
            }
            case 308333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300686, 301026};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308333(n);
                    }
                };
            }
            case 308334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300686, 301026};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308334(n);
                    }
                };
            }
            case 308335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300686, 301026};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308335(n);
                    }
                };
            }
            case 308336: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300699};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308336(n);
                    }
                };
            }
            case 308337: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300872};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308337(n);
                    }
                };
            }
            case 308338: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300707, 300708, 300709, 300710, 300711, 300712, 300723, 300872};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308338(n);
                    }
                };
            }
            case 308339: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308339(n);
                    }
                };
            }
            case 308340: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4091};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308340(n);
                    }
                };
            }
            case 308341: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300699};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308341(n);
                    }
                };
            }
            case 308342: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308342(n);
                    }
                };
            }
            case 308343: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{155, 442, 523, 3939, 4646};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308343(n);
                    }
                };
            }
            case 308344: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{154, 442, 523, 3939, 4649};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308344(n);
                    }
                };
            }
            case 308345: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308345(n);
                    }
                };
            }
            case 308346: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 1000019, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308346(n);
                    }
                };
            }
            case 308347: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 3939, 4196, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308347(n);
                    }
                };
            }
            case 308348: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4263, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308348(n);
                    }
                };
            }
            case 308349: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4263, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308349(n);
                    }
                };
            }
            case 308350: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308350(n);
                    }
                };
            }
            case 308351: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4264, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308351(n);
                    }
                };
            }
            case 308352: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4264, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308352(n);
                    }
                };
            }
            case 308353: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 549, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308353(n);
                    }
                };
            }
            case 308354: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 549, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308354(n);
                    }
                };
            }
            case 308355: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308355(n);
                    }
                };
            }
            case 308356: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308356(n);
                    }
                };
            }
            case 308357: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 4062, 2200130, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308357(n);
                    }
                };
            }
            case 308358: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 4062, 2200130, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308358(n);
                    }
                };
            }
            case 308359: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308359(n);
                    }
                };
            }
            case 308360: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308360(n);
                    }
                };
            }
            case 308361: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308361(n);
                    }
                };
            }
            case 308362: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308362(n);
                    }
                };
            }
            case 308363: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308363(n);
                    }
                };
            }
            case 308366: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308366(n);
                    }
                };
            }
            case 308367: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308367(n);
                    }
                };
            }
            case 308368: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308368(n);
                    }
                };
            }
            case 308369: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308369(n);
                    }
                };
            }
            case 308370: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062, 2200130, 2200172, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308370(n);
                    }
                };
            }
            case 308371: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062, 2200130, 2200204};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308371(n);
                    }
                };
            }
            case 308372: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4062, 2200130, 2200172, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308372(n);
                    }
                };
            }
            case 308373: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4062, 2200130, 2200204};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308373(n);
                    }
                };
            }
            case 308374: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 461, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308374(n);
                    }
                };
            }
            case 308375: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308375(n);
                    }
                };
            }
            case 308377: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509, 3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308377(n);
                    }
                };
            }
            case 308378: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308378(n);
                    }
                };
            }
            case 308379: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308379(n);
                    }
                };
            }
            case 308381: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308381(n);
                    }
                };
            }
            case 308382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308382(n);
                    }
                };
            }
            case 308383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308383(n);
                    }
                };
            }
            case 308384: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308384(n);
                    }
                };
            }
            case 308385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308385(n);
                    }
                };
            }
            case 308386: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308386(n);
                    }
                };
            }
            case 308387: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 0);
                    }
                };
            }
            case 308388: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300723, 300872};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308388(n);
                    }
                };
            }
            case 308389: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300723, 300872};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308389(n);
                    }
                };
            }
            case 308390: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300723, 300872};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308390(n);
                    }
                };
            }
            case 308391: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4263};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308391(n);
                    }
                };
            }
            case 308392: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4263};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308392(n);
                    }
                };
            }
            case 308393: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4264};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308393(n);
                    }
                };
            }
            case 308394: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4264};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308394(n);
                    }
                };
            }
            case 308396: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308396(n);
                    }
                };
            }
            case 308397: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308397(n);
                    }
                };
            }
            case 308398: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308398(n);
                    }
                };
            }
            case 308400: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308400(n);
                    }
                };
            }
            case 308401: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308401(n);
                    }
                };
            }
            case 308402: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308402(n);
                    }
                };
            }
            case 308403: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300441, 300748};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308403(n);
                    }
                };
            }
            case 308407: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{510, 2200237};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308407(n);
                    }
                };
            }
            case 308408: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 523, 300441, 300748};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308408(n);
                    }
                };
            }
            case 308409: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300731};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300731, n, 0);
                    }
                };
            }
            case 308410: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{513, 300292, 301035, 301043};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308410(n);
                    }
                };
            }
            case 308411: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300960};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308411(n);
                    }
                };
            }
            case 308412: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300960, 300961};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308412(n);
                    }
                };
            }
            case 308413: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300961};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300961, n, 0);
                    }
                };
            }
            case 308414: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300960};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300960, n, 1);
                    }
                };
            }
            case 308415: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308415(n);
                    }
                };
            }
            case 308416: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308417: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300964};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300964, n, 0);
                    }
                };
            }
            case 308418: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308418(n);
                    }
                };
            }
            case 308419: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308420: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300441, 300748};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308420(n);
                    }
                };
            }
            case 308421: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308421(n);
                    }
                };
            }
            case 308422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308423: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300966};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300966, n, 0);
                    }
                };
            }
            case 308424: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308424(n);
                    }
                };
            }
            case 308425: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308426: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 300960};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308426(n);
                    }
                };
            }
            case 308427: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300960, 300969};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308427(n);
                    }
                };
            }
            case 308428: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300969};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300969, n, 0);
                    }
                };
            }
            case 308429: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300817};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(300817, n, 1);
                    }
                };
            }
            case 308430: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308430(n);
                    }
                };
            }
            case 308431: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308432: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308432(n);
                    }
                };
            }
            case 308433: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308434(n);
                    }
                };
            }
            case 308435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308436(n);
                    }
                };
            }
            case 308437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308438(n);
                    }
                };
            }
            case 308439: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308440: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308440(n);
                    }
                };
            }
            case 308441: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 3939, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308441(n);
                    }
                };
            }
            case 308442: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 3939, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308442(n);
                    }
                };
            }
            case 308443: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4062, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308443(n);
                    }
                };
            }
            case 308444: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4062, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308444(n);
                    }
                };
            }
            case 308449: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301119};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301119, n, 2);
                    }
                };
            }
            case 308450: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301120};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301120, n, 2);
                    }
                };
            }
            case 308451: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301125};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301125, n, 2);
                    }
                };
            }
            case 308453: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308453(n);
                    }
                };
            }
            case 308454: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308454(n);
                    }
                };
            }
            case 308456: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308456(n);
                    }
                };
            }
            case 308457: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509, 5583, 5588, 0x2626BB};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308457(n);
                    }
                };
            }
            case 308458: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509, 5583, 5588, 0x2626BB};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308458(n);
                    }
                };
            }
            case 308459: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308459(n);
                    }
                };
            }
            case 308460: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308460(n);
                    }
                };
            }
            case 308461: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308461(n);
                    }
                };
            }
            case 308462: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308462(n);
                    }
                };
            }
            case 308463: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308463(n);
                    }
                };
            }
            case 308464: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308464(n);
                    }
                };
            }
            case 308465: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4367, 301027, 301028};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308465(n);
                    }
                };
            }
            case 308466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5605, 300441};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308466(n);
                    }
                };
            }
            case 308467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308467(n);
                    }
                };
            }
            case 308468: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308468(n);
                    }
                };
            }
            case 308469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308469(n);
                    }
                };
            }
            case 308470: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300402};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300402, n, 1);
                    }
                };
            }
            case 308471: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308471(n);
                    }
                };
            }
            case 308472: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308472(n);
                    }
                };
            }
            case 308473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 442, 463, 492, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308473(n);
                    }
                };
            }
            case 308474: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 4196, 4475, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308474(n);
                    }
                };
            }
            case 308475: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4350};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308475(n);
                    }
                };
            }
            case 308476: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4350};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308476(n);
                    }
                };
            }
            case 308477: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301118};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(301118, n, 2);
                    }
                };
            }
            case 308478: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308478(n);
                    }
                };
            }
            case 308479: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308479(n);
                    }
                };
            }
            case 308480: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308480(n);
                    }
                };
            }
            case 308481: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308481(n);
                    }
                };
            }
            case 308482: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308482(n);
                    }
                };
            }
            case 308483: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301099};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(301099, n, 1);
                    }
                };
            }
            case 308484: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308484(n);
                    }
                };
            }
            case 308485: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643, 2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308485(n);
                    }
                };
            }
            case 308486: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643, 2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308486(n);
                    }
                };
            }
            case 308487: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643, 2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308487(n);
                    }
                };
            }
            case 308489: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308489(n);
                    }
                };
            }
            case 308490: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308490(n);
                    }
                };
            }
            case 308491: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308491(n);
                    }
                };
            }
            case 308492: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 300643};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308492(n);
                    }
                };
            }
            case 308493: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308493(n);
                    }
                };
            }
            case 308494: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308494(n);
                    }
                };
            }
            case 308495: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 301150};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308495(n);
                    }
                };
            }
            case 308500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 301035};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308500(n);
                    }
                };
            }
            case 308501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200237};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200237, n, 1);
                    }
                };
            }
            case 308502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200237};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200237, n, 1);
                    }
                };
            }
            case 308503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308503(n);
                    }
                };
            }
            case 308504: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308504(n);
                    }
                };
            }
            case 308505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200272, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308505(n);
                    }
                };
            }
            case 308506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308506(n);
                    }
                };
            }
            case 308507: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308507(n);
                    }
                };
            }
            case 308508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{461, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308508(n);
                    }
                };
            }
            case 308509: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{509, 3939, 4239, 5583, 5588, 300292};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308509(n);
                    }
                };
            }
            case 308513: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308513(n);
                    }
                };
            }
            case 308514: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308514(n);
                    }
                };
            }
            case 308515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308515(n);
                    }
                };
            }
            case 308516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{487, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308516(n);
                    }
                };
            }
            case 308517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 494, 3939, 5583, 5588, 300227, 300370, 300612, 300614, 300664, 300847, 300952, 300953, 300975, 2500148, 0x262663};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308517(n);
                    }
                };
            }
            case 308518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200130, 2200145, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308518(n);
                    }
                };
            }
            case 308519: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308519(n);
                    }
                };
            }
            case 308520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308520(n);
                    }
                };
            }
            case 308521: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308521(n);
                    }
                };
            }
            case 308522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308522(n);
                    }
                };
            }
            case 308525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4594, 5583, 5588, 5602};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308525(n);
                    }
                };
            }
            case 308526: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4594, 5583, 5588, 5602};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308526(n);
                    }
                };
            }
            case 308527: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308527(n);
                    }
                };
            }
            case 308528: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308528(n);
                    }
                };
            }
            case 308529: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308529(n);
                    }
                };
            }
            case 308530: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308530(n);
                    }
                };
            }
            case 308531: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308531(n);
                    }
                };
            }
            case 308532: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308532(n);
                    }
                };
            }
            case 308533: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308533(n);
                    }
                };
            }
            case 308542: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 447};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308542(n);
                    }
                };
            }
            case 308543: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308543(n);
                    }
                };
            }
            case 308544: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308544(n);
                    }
                };
            }
            case 308545: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308545(n);
                    }
                };
            }
            case 308546: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308546(n);
                    }
                };
            }
            case 308547: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308547(n);
                    }
                };
            }
            case 308548: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308548(n);
                    }
                };
            }
            case 308549: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308549(n);
                    }
                };
            }
            case 308550: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308550(n);
                    }
                };
            }
            case 308552: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308552(n);
                    }
                };
            }
            case 308553: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308553(n);
                    }
                };
            }
            case 308555: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 4196, 301085};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308555(n);
                    }
                };
            }
            case 308556: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3926};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3926, n, 1);
                    }
                };
            }
            case 308557: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 0);
                    }
                };
            }
            case 308558: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2500250};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2500250, n, 1);
                    }
                };
            }
            case 308559: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200231};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308559(n);
                    }
                };
            }
            case 308560: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200231};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308560(n);
                    }
                };
            }
            case 308563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5602};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308563(n);
                    }
                };
            }
            case 308564: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300944};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(300944, n, 1);
                    }
                };
            }
            case 308565: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5605, 300809};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308565(n);
                    }
                };
            }
            case 308566: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5605, 300810};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308566(n);
                    }
                };
            }
            case 308567: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5605, 300793};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308567(n);
                    }
                };
            }
            case 308574: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308574(n);
                    }
                };
            }
            case 308575: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308575(n);
                    }
                };
            }
            case 308576: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 700597};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308576(n);
                    }
                };
            }
            case 308577: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{300865};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308577(n);
                    }
                };
            }
            case 308578: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308578(n);
                    }
                };
            }
            case 308728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 5619};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308728(n);
                    }
                };
            }
            case 308729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4082};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308729(n);
                    }
                };
            }
            case 308730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4079};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308730(n);
                    }
                };
            }
            case 308731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308731(n);
                    }
                };
            }
            case 308732: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308732(n);
                    }
                };
            }
            case 308733: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308733(n);
                    }
                };
            }
            case 308734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308734(n);
                    }
                };
            }
            case 308735: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{301230};
                    }

                    public boolean evaluate(int n) {
                        return PhoneConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(301230, n, 1);
                    }
                };
            }
            case 308736: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308736(n);
                    }
                };
            }
            case 308737: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4082};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308737(n);
                    }
                };
            }
            case 308738: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4079};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308738(n);
                    }
                };
            }
            case 308739: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308739(n);
                    }
                };
            }
            case 308740: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308740(n);
                    }
                };
            }
            case 308741: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308741(n);
                    }
                };
            }
            case 308742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308742(n);
                    }
                };
            }
            case 308743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308743(n);
                    }
                };
            }
            case 308744: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308744(n);
                    }
                };
            }
            case 308745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308745(n);
                    }
                };
            }
            case 308746: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308746(n);
                    }
                };
            }
            case 308747: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308747(n);
                    }
                };
            }
            case 308748: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308748(n);
                    }
                };
            }
            case 308749: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308749(n);
                    }
                };
            }
            case 308750: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308750(n);
                    }
                };
            }
            case 308751: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308751(n);
                    }
                };
            }
            case 308752: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308752(n);
                    }
                };
            }
            case 308753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308753(n);
                    }
                };
            }
            case 308754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308754(n);
                    }
                };
            }
            case 308755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308755(n);
                    }
                };
            }
            case 308756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308756(n);
                    }
                };
            }
            case 308757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308757(n);
                    }
                };
            }
            case 308758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308758(n);
                    }
                };
            }
            case 308759: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308759(n);
                    }
                };
            }
            case 308761: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308761(n);
                    }
                };
            }
            case 308762: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308762(n);
                    }
                };
            }
            case 308763: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308763(n);
                    }
                };
            }
            case 308764: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308764(n);
                    }
                };
            }
            case 308765: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308765(n);
                    }
                };
            }
            case 308766: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308766(n);
                    }
                };
            }
            case 308767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308767(n);
                    }
                };
            }
            case 308768: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308768(n);
                    }
                };
            }
            case 308769: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308769(n);
                    }
                };
            }
            case 308770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308770(n);
                    }
                };
            }
            case 308771: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308771(n);
                    }
                };
            }
            case 308772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308772(n);
                    }
                };
            }
            case 308773: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308773(n);
                    }
                };
            }
            case 308774: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308774(n);
                    }
                };
            }
            case 308775: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308775(n);
                    }
                };
            }
            case 308776: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308776(n);
                    }
                };
            }
            case 308777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308777(n);
                    }
                };
            }
            case 308778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308778(n);
                    }
                };
            }
            case 308779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308779(n);
                    }
                };
            }
            case 308780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308780(n);
                    }
                };
            }
            case 308781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308781(n);
                    }
                };
            }
            case 308782: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308782(n);
                    }
                };
            }
            case 308783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308783(n);
                    }
                };
            }
            case 308784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308784(n);
                    }
                };
            }
            case 308785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308785(n);
                    }
                };
            }
            case 308786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308786(n);
                    }
                };
            }
            case 308787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308787(n);
                    }
                };
            }
            case 308788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308788(n);
                    }
                };
            }
            case 308789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308789(n);
                    }
                };
            }
            case 308790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308790(n);
                    }
                };
            }
            case 308791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308791(n);
                    }
                };
            }
            case 308792: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308792(n);
                    }
                };
            }
            case 308793: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308793(n);
                    }
                };
            }
            case 308794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308794(n);
                    }
                };
            }
            case 308795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308795(n);
                    }
                };
            }
            case 308796: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308796(n);
                    }
                };
            }
            case 308797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308797(n);
                    }
                };
            }
            case 308798: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308798(n);
                    }
                };
            }
            case 308799: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 0x2626BB};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308799(n);
                    }
                };
            }
            case 308800: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 0x2626BB};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308800(n);
                    }
                };
            }
            case 308801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308801(n);
                    }
                };
            }
            case 308802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308802(n);
                    }
                };
            }
            case 308803: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return PhoneScreenFactory.evalCond308803(n);
                    }
                };
            }
        }
        return null;
    }
}

