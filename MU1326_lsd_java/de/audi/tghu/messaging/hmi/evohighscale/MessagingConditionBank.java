/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingScreenFactory;

public class MessagingConditionBank
implements HMIConditionBank {
    private MessagingScreenFactory screenFactory;

    public MessagingConditionBank(MessagingScreenFactory messagingScreenFactory) {
        this.screenFactory = messagingScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 2200617: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200617(n);
                    }
                };
            }
            case 2200618: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200618(n);
                    }
                };
            }
            case 2200619: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200619(n);
                    }
                };
            }
            case 2200620: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 442, 447, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200620(n);
                    }
                };
            }
            case 2200621: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 442, 447, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200621(n);
                    }
                };
            }
            case 2200622: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 447};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200622(n);
                    }
                };
            }
            case 2200624: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 442, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200624(n);
                    }
                };
            }
            case 2200625: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(447, n, 43);
                    }
                };
            }
            case 2200626: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 447, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200626(n);
                    }
                };
            }
            case 2200627: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 447, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200627(n);
                    }
                };
            }
            case 2200630: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200630(n);
                    }
                };
            }
            case 2200631: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200631(n);
                    }
                };
            }
            case 2200632: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200632(n);
                    }
                };
            }
            case 2200633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200633(n);
                    }
                };
            }
            case 2200634: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 263};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200634(n);
                    }
                };
            }
            case 2200635: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 259, 261};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200635(n);
                    }
                };
            }
            case 2200636: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 498};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2200636(n);
                    }
                };
            }
            case 2200745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 2200954: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200231};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200231, n, 1);
                    }
                };
            }
            case 2200955: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200231};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200231, n, 1);
                    }
                };
            }
            case 2201184: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200279};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200279, n, 1);
                    }
                };
            }
            case 2201185: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200279};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200279, n, 1);
                    }
                };
            }
            case 2201511: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200309};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200309, n, 0);
                    }
                };
            }
            case 2201512: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200308};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200308, n, 1);
                    }
                };
            }
            case 2201513: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200309};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200309, n, 0);
                    }
                };
            }
            case 2201515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200309};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200309, n, 0);
                    }
                };
            }
            case 2201516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 2200308};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201516(n);
                    }
                };
            }
            case 2201517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200309};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200309, n, 0);
                    }
                };
            }
            case 2201518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201518(n);
                    }
                };
            }
            case 2201520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201520(n);
                    }
                };
            }
            case 2201823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201823(n);
                    }
                };
            }
            case 2201824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201824(n);
                    }
                };
            }
            case 2201825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201825(n);
                    }
                };
            }
            case 2201826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201826(n);
                    }
                };
            }
            case 2201827: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201827(n);
                    }
                };
            }
            case 2201828: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201828(n);
                    }
                };
            }
            case 2201829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201829(n);
                    }
                };
            }
            case 2201830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201830(n);
                    }
                };
            }
            case 2201831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201831(n);
                    }
                };
            }
            case 2201926: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200307};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201926(n);
                    }
                };
            }
            case 2201927: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266, 2200267};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201927(n);
                    }
                };
            }
            case 2201928: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266, 2200267};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2201928(n);
                    }
                };
            }
            case 2202138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202138(n);
                    }
                };
            }
            case 2202139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202139(n);
                    }
                };
            }
            case 2202141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200194};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202141(n);
                    }
                };
            }
            case 2202142: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200194};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202142(n);
                    }
                };
            }
            case 2202562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202562(n);
                    }
                };
            }
            case 2202563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341, 2200343};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202563(n);
                    }
                };
            }
            case 2202666: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341, 2200343};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202666(n);
                    }
                };
            }
            case 2202667: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202667(n);
                    }
                };
            }
            case 2202668: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200251};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202668(n);
                    }
                };
            }
            case 2202669: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200251};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202669(n);
                    }
                };
            }
            case 2202882: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202882(n);
                    }
                };
            }
            case 2202883: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2202883(n);
                    }
                };
            }
            case 2203052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203052(n);
                    }
                };
            }
            case 2203053: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203053(n);
                    }
                };
            }
            case 2203137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266, 2200267, 2200268};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203137(n);
                    }
                };
            }
            case 2203138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200266, 2200267, 2200268};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203138(n);
                    }
                };
            }
            case 2203139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4062};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203139(n);
                    }
                };
            }
            case 2203140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4062};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203140(n);
                    }
                };
            }
            case 2203141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200129};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200129, n, 0);
                    }
                };
            }
            case 2203380: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200308, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203380(n);
                    }
                };
            }
            case 2203381: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200308, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203381(n);
                    }
                };
            }
            case 2203496: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200306, 2200307, 2200309, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203496(n);
                    }
                };
            }
            case 2203573: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200306, 2200307, 2200309, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203573(n);
                    }
                };
            }
            case 2203579: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 2200306, 2200307, 2200309, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203579(n);
                    }
                };
            }
            case 2203580: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203580(n);
                    }
                };
            }
            case 2203619: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203619(n);
                    }
                };
            }
            case 2203623: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 2200266};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203623(n);
                    }
                };
            }
            case 2203824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 2200130, 2200164};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203824(n);
                    }
                };
            }
            case 2203825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 2200130, 2200164};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203825(n);
                    }
                };
            }
            case 2203826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203826(n);
                    }
                };
            }
            case 2203865: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{323, 442, 460, 523, 549, 4088, 2200130, 2200164};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203865(n);
                    }
                };
            }
            case 2203868: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2200341, n, 1);
                    }
                };
            }
            case 2203948: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2203948(n);
                    }
                };
            }
            case 2204015: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 2204016: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{268, 310};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204016(n);
                    }
                };
            }
            case 2204382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{323, 442, 460, 523, 549, 4088, 2200130, 2200164};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204382(n);
                    }
                };
            }
            case 2204422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204422(n);
                    }
                };
            }
            case 2204423: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204423(n);
                    }
                };
            }
            case 2204469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204469(n);
                    }
                };
            }
            case 2204470: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204470(n);
                    }
                };
            }
            case 2204471: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341, 2200343};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204471(n);
                    }
                };
            }
            case 2204472: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341, 2200343};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204472(n);
                    }
                };
            }
            case 2204473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2200341, n, 1);
                    }
                };
            }
            case 2204474: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204474(n);
                    }
                };
            }
            case 2204475: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200341};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204475(n);
                    }
                };
            }
            case 2204476: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204476(n);
                    }
                };
            }
            case 2204478: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204478(n);
                    }
                };
            }
            case 2204479: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204479(n);
                    }
                };
            }
            case 2204480: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204480(n);
                    }
                };
            }
            case 2204481: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204481(n);
                    }
                };
            }
            case 2204482: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204482(n);
                    }
                };
            }
            case 2204483: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204483(n);
                    }
                };
            }
            case 2204484: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204484(n);
                    }
                };
            }
            case 2204485: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204485(n);
                    }
                };
            }
            case 2204486: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204486(n);
                    }
                };
            }
            case 2204487: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204487(n);
                    }
                };
            }
            case 2204488: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204488(n);
                    }
                };
            }
            case 2204489: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 1000019, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204489(n);
                    }
                };
            }
            case 2204490: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3848, 3939, 4196, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204490(n);
                    }
                };
            }
            case 2204491: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4263, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204491(n);
                    }
                };
            }
            case 2204492: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4263, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204492(n);
                    }
                };
            }
            case 2204493: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204493(n);
                    }
                };
            }
            case 2204494: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4264, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204494(n);
                    }
                };
            }
            case 2204495: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4264, 2200317};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204495(n);
                    }
                };
            }
            case 2204496: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 549, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204496(n);
                    }
                };
            }
            case 2204497: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 549, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204497(n);
                    }
                };
            }
            case 2204498: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204498(n);
                    }
                };
            }
            case 2204499: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204499(n);
                    }
                };
            }
            case 2204500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 4062, 2200130, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204500(n);
                    }
                };
            }
            case 2204501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 4062, 2200130, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204501(n);
                    }
                };
            }
            case 2204502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204502(n);
                    }
                };
            }
            case 2204503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204503(n);
                    }
                };
            }
            case 2204504: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204504(n);
                    }
                };
            }
            case 2204505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204505(n);
                    }
                };
            }
            case 2204506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204506(n);
                    }
                };
            }
            case 2204507: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204507(n);
                    }
                };
            }
            case 2204508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204508(n);
                    }
                };
            }
            case 2204509: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204509(n);
                    }
                };
            }
            case 2204510: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204510(n);
                    }
                };
            }
            case 2204511: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204511(n);
                    }
                };
            }
            case 2204512: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204512(n);
                    }
                };
            }
            case 2204513: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062, 2200130, 2200172, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204513(n);
                    }
                };
            }
            case 2204514: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062, 2200130, 2200204};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204514(n);
                    }
                };
            }
            case 2204515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4062, 2200130, 2200172, 2200186};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204515(n);
                    }
                };
            }
            case 2204516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4062, 2200130, 2200204};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204516(n);
                    }
                };
            }
            case 2204517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204517(n);
                    }
                };
            }
            case 2204518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204518(n);
                    }
                };
            }
            case 2204519: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{155, 442, 523, 3939, 4646};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204519(n);
                    }
                };
            }
            case 2204520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204520(n);
                    }
                };
            }
            case 2204521: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4263};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204521(n);
                    }
                };
            }
            case 2204522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4263};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204522(n);
                    }
                };
            }
            case 2204523: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4264};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204523(n);
                    }
                };
            }
            case 2204524: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4264};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204524(n);
                    }
                };
            }
            case 2204525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204525(n);
                    }
                };
            }
            case 2204526: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204526(n);
                    }
                };
            }
            case 2204527: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200411};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204527(n);
                    }
                };
            }
            case 2204528: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200410};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200410, n, 1);
                    }
                };
            }
            case 2204529: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200410};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200410, n, 0);
                    }
                };
            }
            case 2204530: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 2204532: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 2200266};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204532(n);
                    }
                };
            }
            case 2204533: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200129};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200129, n, 0);
                    }
                };
            }
            case 2204534: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 2204535: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200237};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200237, n, 1);
                    }
                };
            }
            case 2204536: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200237};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200237, n, 1);
                    }
                };
            }
            case 2204539: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200166};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusGreaterCondition(2200166, n, -100);
                    }
                };
            }
            case 2204541: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200166};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusGreaterCondition(2200166, n, -100);
                    }
                };
            }
            case 2204542: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 3939, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204542(n);
                    }
                };
            }
            case 2204543: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 3939, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204543(n);
                    }
                };
            }
            case 2204544: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204544(n);
                    }
                };
            }
            case 2204545: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204545(n);
                    }
                };
            }
            case 2204546: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4062, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204546(n);
                    }
                };
            }
            case 2204547: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4062, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204547(n);
                    }
                };
            }
            case 2204552: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204552(n);
                    }
                };
            }
            case 2204553: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{549, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204553(n);
                    }
                };
            }
            case 2204554: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{549, 2200130};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204554(n);
                    }
                };
            }
            case 2204555: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{241, 3848, 4196, 5583, 5588, 301085};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204555(n);
                    }
                };
            }
            case 2204556: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204556(n);
                    }
                };
            }
            case 2204557: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939, 4062};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204557(n);
                    }
                };
            }
            case 2204558: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 442, 498};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204558(n);
                    }
                };
            }
            case 2204559: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 259, 261, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204559(n);
                    }
                };
            }
            case 2204560: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 263, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204560(n);
                    }
                };
            }
            case 2204561: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204561(n);
                    }
                };
            }
            case 2204562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204562(n);
                    }
                };
            }
            case 2204563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200308, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204563(n);
                    }
                };
            }
            case 2204564: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200164, 2200308, 2200493};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204564(n);
                    }
                };
            }
            case 2204565: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200438};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204565(n);
                    }
                };
            }
            case 2204566: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200436, 2200438, 2200474};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204566(n);
                    }
                };
            }
            case 2204568: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204568(n);
                    }
                };
            }
            case 2204569: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204569(n);
                    }
                };
            }
            case 2204570: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204570(n);
                    }
                };
            }
            case 2204571: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 3939, 2200475};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204571(n);
                    }
                };
            }
            case 2204572: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204572(n);
                    }
                };
            }
            case 2204573: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204573(n);
                    }
                };
            }
            case 2204576: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204576(n);
                    }
                };
            }
            case 2204577: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204577(n);
                    }
                };
            }
            case 2204584: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204584(n);
                    }
                };
            }
            case 2204585: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 220, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204585(n);
                    }
                };
            }
            case 2204586: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 220, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204586(n);
                    }
                };
            }
            case 2204587: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204587(n);
                    }
                };
            }
            case 2204588: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204588(n);
                    }
                };
            }
            case 2204589: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204589(n);
                    }
                };
            }
            case 2204590: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204590(n);
                    }
                };
            }
            case 2204591: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204591(n);
                    }
                };
            }
            case 2204592: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4358};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204592(n);
                    }
                };
            }
            case 2204593: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200252};
                    }

                    public boolean evaluate(int n) {
                        return MessagingConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2200252, n, 0);
                    }
                };
            }
            case 2204594: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204594(n);
                    }
                };
            }
            case 2204595: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204595(n);
                    }
                };
            }
            case 2204597: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204597(n);
                    }
                };
            }
            case 2204769: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204769(n);
                    }
                };
            }
            case 2204770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204770(n);
                    }
                };
            }
            case 2204771: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204771(n);
                    }
                };
            }
            case 2204772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204772(n);
                    }
                };
            }
            case 2204773: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204773(n);
                    }
                };
            }
            case 2204774: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204774(n);
                    }
                };
            }
            case 2204775: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204775(n);
                    }
                };
            }
            case 2204776: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204776(n);
                    }
                };
            }
            case 2204777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204777(n);
                    }
                };
            }
            case 2204778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204778(n);
                    }
                };
            }
            case 2204779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204779(n);
                    }
                };
            }
            case 2204780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204780(n);
                    }
                };
            }
            case 2204781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204781(n);
                    }
                };
            }
            case 2204783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204783(n);
                    }
                };
            }
            case 2204784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204784(n);
                    }
                };
            }
            case 2204785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204785(n);
                    }
                };
            }
            case 2204786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204786(n);
                    }
                };
            }
            case 2204787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204787(n);
                    }
                };
            }
            case 2204788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204788(n);
                    }
                };
            }
            case 2204789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204789(n);
                    }
                };
            }
            case 2204790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204790(n);
                    }
                };
            }
            case 2204791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204791(n);
                    }
                };
            }
            case 2204792: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204792(n);
                    }
                };
            }
            case 2204793: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204793(n);
                    }
                };
            }
            case 2204794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204794(n);
                    }
                };
            }
            case 2204795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204795(n);
                    }
                };
            }
            case 2204796: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204796(n);
                    }
                };
            }
            case 2204797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204797(n);
                    }
                };
            }
            case 2204798: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204798(n);
                    }
                };
            }
            case 2204799: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204799(n);
                    }
                };
            }
            case 2204800: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204800(n);
                    }
                };
            }
            case 2204801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204801(n);
                    }
                };
            }
            case 2204802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204802(n);
                    }
                };
            }
            case 2204803: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204803(n);
                    }
                };
            }
            case 2204804: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204804(n);
                    }
                };
            }
            case 2204805: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return MessagingScreenFactory.evalCond2204805(n);
                    }
                };
            }
        }
        return null;
    }
}

