/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.system.hmi.evohighscale.SystemScreenFactory;

public class SystemConditionBank
implements HMIConditionBank {
    private SystemScreenFactory screenFactory;

    public SystemConditionBank(SystemScreenFactory systemScreenFactory) {
        this.screenFactory = systemScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 21: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{427, 429};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond21(n);
                    }
                };
            }
            case 22: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{427, 429};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond22(n);
                    }
                };
            }
            case 23: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 32: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100354};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(100354, n, 1);
                    }
                };
            }
            case 35: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 36: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{204, 442, 522, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond36(n);
                    }
                };
            }
            case 37: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond37(n);
                    }
                };
            }
            case 38: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond38(n);
                    }
                };
            }
            case 41: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 259, 261};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond41(n);
                    }
                };
            }
            case 43: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 498};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond43(n);
                    }
                };
            }
            case 44: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 263};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond44(n);
                    }
                };
            }
            case 45: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond45(n);
                    }
                };
            }
            case 46: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond46(n);
                    }
                };
            }
            case 47: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond47(n);
                    }
                };
            }
            case 48: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 523, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond48(n);
                    }
                };
            }
            case 52: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 3981};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond52(n);
                    }
                };
            }
            case 53: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 516, 550, 3981, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond53(n);
                    }
                };
            }
            case 54: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(359, n, 1);
                    }
                };
            }
            case 56: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond56(n);
                    }
                };
            }
            case 135: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond135(n);
                    }
                };
            }
            case 137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3992};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3992, n, 1);
                    }
                };
            }
            case 168: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{473, 522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond168(n);
                    }
                };
            }
            case 291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4004};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond291(n);
                    }
                };
            }
            case 293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond293(n);
                    }
                };
            }
            case 294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond294(n);
                    }
                };
            }
            case 341: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond341(n);
                    }
                };
            }
            case 380: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 447};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond380(n);
                    }
                };
            }
            case 381: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 447};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond381(n);
                    }
                };
            }
            case 384: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3981};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond384(n);
                    }
                };
            }
            case 385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3981};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond385(n);
                    }
                };
            }
            case 416: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{358};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond416(n);
                    }
                };
            }
            case 417: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond417(n);
                    }
                };
            }
            case 418: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{473};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond418(n);
                    }
                };
            }
            case 419: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{378};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(378, n, 1);
                    }
                };
            }
            case 420: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond420(n);
                    }
                };
            }
            case 421: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond421(n);
                    }
                };
            }
            case 422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond422(n);
                    }
                };
            }
            case 423: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond423(n);
                    }
                };
            }
            case 424: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond424(n);
                    }
                };
            }
            case 425: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond425(n);
                    }
                };
            }
            case 434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 516, 550, 3929, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond434(n);
                    }
                };
            }
            case 435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3929};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond435(n);
                    }
                };
            }
            case 436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3929};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond436(n);
                    }
                };
            }
            case 437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 3929};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond437(n);
                    }
                };
            }
            case 438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 3929};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond438(n);
                    }
                };
            }
            case 439: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 447, 3929, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond439(n);
                    }
                };
            }
            case 444: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{430};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond444(n);
                    }
                };
            }
            case 445: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{430};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond445(n);
                    }
                };
            }
            case 446: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3992};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3992, n, 0);
                    }
                };
            }
            case 447: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3992};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3992, n, 1);
                    }
                };
            }
            case 452: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 453: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 5624, 400490};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond453(n);
                    }
                };
            }
            case 454: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 455: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 400490};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond455(n);
                    }
                };
            }
            case 456: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3981, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond456(n);
                    }
                };
            }
            case 457: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3929, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond457(n);
                    }
                };
            }
            case 458: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3981};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond458(n);
                    }
                };
            }
            case 459: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 550, 3929};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond459(n);
                    }
                };
            }
            case 460: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4011};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond460(n);
                    }
                };
            }
            case 461: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4011};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond461(n);
                    }
                };
            }
            case 462: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300893};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300893, n, 1);
                    }
                };
            }
            case 463: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300894};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300894, n, 1);
                    }
                };
            }
            case 464: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300895};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300895, n, 1);
                    }
                };
            }
            case 465: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300896};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300896, n, 1);
                    }
                };
            }
            case 466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300897};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300897, n, 1);
                    }
                };
            }
            case 467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3839};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond467(n);
                    }
                };
            }
            case 468: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3839};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(3839, n, 0);
                    }
                };
            }
            case 469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond469(n);
                    }
                };
            }
            case 470: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3929, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond470(n);
                    }
                };
            }
            case 472: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{473};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond472(n);
                    }
                };
            }
            case 473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4155};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond473(n);
                    }
                };
            }
            case 474: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{363};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(363, n, 1);
                    }
                };
            }
            case 480: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300893};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300893, n, 1);
                    }
                };
            }
            case 482: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300894};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300894, n, 1);
                    }
                };
            }
            case 484: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300895};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300895, n, 1);
                    }
                };
            }
            case 486: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300896};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300896, n, 1);
                    }
                };
            }
            case 488: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300897};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300897, n, 1);
                    }
                };
            }
            case 490: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4091};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4091, n, 0);
                    }
                };
            }
            case 491: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4091};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4091, n, 0);
                    }
                };
            }
            case 492: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond492(n);
                    }
                };
            }
            case 494: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond494(n);
                    }
                };
            }
            case 495: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond495(n);
                    }
                };
            }
            case 592: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond592(n);
                    }
                };
            }
            case 593: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4011};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond593(n);
                    }
                };
            }
            case 595: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 4011};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond595(n);
                    }
                };
            }
            case 613: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond613(n);
                    }
                };
            }
            case 614: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond614(n);
                    }
                };
            }
            case 615: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond615(n);
                    }
                };
            }
            case 616: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond616(n);
                    }
                };
            }
            case 617: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond617(n);
                    }
                };
            }
            case 618: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond618(n);
                    }
                };
            }
            case 619: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 515, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond619(n);
                    }
                };
            }
            case 620: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond620(n);
                    }
                };
            }
            case 621: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond621(n);
                    }
                };
            }
            case 622: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond622(n);
                    }
                };
            }
            case 623: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond623(n);
                    }
                };
            }
            case 624: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond624(n);
                    }
                };
            }
            case 625: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond625(n);
                    }
                };
            }
            case 626: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond626(n);
                    }
                };
            }
            case 627: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond627(n);
                    }
                };
            }
            case 628: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond628(n);
                    }
                };
            }
            case 629: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond629(n);
                    }
                };
            }
            case 630: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond630(n);
                    }
                };
            }
            case 631: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond631(n);
                    }
                };
            }
            case 632: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond632(n);
                    }
                };
            }
            case 633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond633(n);
                    }
                };
            }
            case 634: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond634(n);
                    }
                };
            }
            case 635: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond635(n);
                    }
                };
            }
            case 636: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond636(n);
                    }
                };
            }
            case 651: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 516, 550, 3929, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond651(n);
                    }
                };
            }
            case 652: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{233, 335, 516, 550, 3981, 4008};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond652(n);
                    }
                };
            }
            case 653: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond653(n);
                    }
                };
            }
            case 654: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond654(n);
                    }
                };
            }
            case 655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond655(n);
                    }
                };
            }
            case 656: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond656(n);
                    }
                };
            }
            case 678: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{474, 4252};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond678(n);
                    }
                };
            }
            case 679: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond679(n);
                    }
                };
            }
            case 680: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 459, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond680(n);
                    }
                };
            }
            case 681: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond681(n);
                    }
                };
            }
            case 684: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond684(n);
                    }
                };
            }
            case 685: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond685(n);
                    }
                };
            }
            case 686: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond686(n);
                    }
                };
            }
            case 687: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond687(n);
                    }
                };
            }
            case 688: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond688(n);
                    }
                };
            }
            case 689: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond689(n);
                    }
                };
            }
            case 690: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond690(n);
                    }
                };
            }
            case 691: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond691(n);
                    }
                };
            }
            case 692: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond692(n);
                    }
                };
            }
            case 693: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond693(n);
                    }
                };
            }
            case 697: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 459, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond697(n);
                    }
                };
            }
            case 698: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{257, 258, 259, 260, 261, 498, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond698(n);
                    }
                };
            }
            case 699: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond699(n);
                    }
                };
            }
            case 700: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond700(n);
                    }
                };
            }
            case 701: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond701(n);
                    }
                };
            }
            case 702: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{498, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond702(n);
                    }
                };
            }
            case 703: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{258, 259, 260, 261, 498, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond703(n);
                    }
                };
            }
            case 704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{257, 258, 259, 260, 261, 498, 522, 523, 200529, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond704(n);
                    }
                };
            }
            case 705: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond705(n);
                    }
                };
            }
            case 706: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond706(n);
                    }
                };
            }
            case 707: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond707(n);
                    }
                };
            }
            case 708: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond708(n);
                    }
                };
            }
            case 709: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond709(n);
                    }
                };
            }
            case 713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 4044, 4237, 4239};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond713(n);
                    }
                };
            }
            case 714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 4044, 4238, 4239};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond714(n);
                    }
                };
            }
            case 715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond715(n);
                    }
                };
            }
            case 716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond716(n);
                    }
                };
            }
            case 717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond717(n);
                    }
                };
            }
            case 718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond718(n);
                    }
                };
            }
            case 719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond719(n);
                    }
                };
            }
            case 720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond720(n);
                    }
                };
            }
            case 721: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond721(n);
                    }
                };
            }
            case 722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond722(n);
                    }
                };
            }
            case 723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond723(n);
                    }
                };
            }
            case 724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond724(n);
                    }
                };
            }
            case 725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond725(n);
                    }
                };
            }
            case 726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond726(n);
                    }
                };
            }
            case 727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 220, 442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond727(n);
                    }
                };
            }
            case 728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond728(n);
                    }
                };
            }
            case 729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond729(n);
                    }
                };
            }
            case 730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 220, 442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond730(n);
                    }
                };
            }
            case 731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 442, 459};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond731(n);
                    }
                };
            }
            case 732: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond732(n);
                    }
                };
            }
            case 733: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond733(n);
                    }
                };
            }
            case 734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond734(n);
                    }
                };
            }
            case 735: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond735(n);
                    }
                };
            }
            case 736: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond736(n);
                    }
                };
            }
            case 737: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 463, 549, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond737(n);
                    }
                };
            }
            case 738: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 463, 549, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond738(n);
                    }
                };
            }
            case 739: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond739(n);
                    }
                };
            }
            case 740: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4358};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond740(n);
                    }
                };
            }
            case 741: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond741(n);
                    }
                };
            }
            case 742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond742(n);
                    }
                };
            }
            case 743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond743(n);
                    }
                };
            }
            case 744: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond744(n);
                    }
                };
            }
            case 745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3915};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond745(n);
                    }
                };
            }
            case 746: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4515};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4515, n, 1);
                    }
                };
            }
            case 747: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond747(n);
                    }
                };
            }
            case 748: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond748(n);
                    }
                };
            }
            case 749: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{378, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond749(n);
                    }
                };
            }
            case 750: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{358, 522, 3919};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond750(n);
                    }
                };
            }
            case 755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 0);
                    }
                };
            }
            case 756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 1);
                    }
                };
            }
            case 757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 0);
                    }
                };
            }
            case 758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 1);
                    }
                };
            }
            case 759: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond759(n);
                    }
                };
            }
            case 760: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447, 400871};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond760(n);
                    }
                };
            }
            case 761: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400871};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400871, n, 2);
                    }
                };
            }
            case 762: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond762(n);
                    }
                };
            }
            case 763: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447, 400871};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond763(n);
                    }
                };
            }
            case 764: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400871};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400871, n, 2);
                    }
                };
            }
            case 765: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(11, n, 0);
                    }
                };
            }
            case 766: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100466};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond766(n);
                    }
                };
            }
            case 767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100466};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond767(n);
                    }
                };
            }
            case 768: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond768(n);
                    }
                };
            }
            case 769: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond769(n);
                    }
                };
            }
            case 770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond770(n);
                    }
                };
            }
            case 771: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond771(n);
                    }
                };
            }
            case 772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond772(n);
                    }
                };
            }
            case 773: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond773(n);
                    }
                };
            }
            case 774: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond774(n);
                    }
                };
            }
            case 775: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond775(n);
                    }
                };
            }
            case 776: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond776(n);
                    }
                };
            }
            case 777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond777(n);
                    }
                };
            }
            case 778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond778(n);
                    }
                };
            }
            case 779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond779(n);
                    }
                };
            }
            case 780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond780(n);
                    }
                };
            }
            case 782: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond782(n);
                    }
                };
            }
            case 783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond783(n);
                    }
                };
            }
            case 784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond784(n);
                    }
                };
            }
            case 785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond785(n);
                    }
                };
            }
            case 786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(527, n, 1);
                    }
                };
            }
            case 793: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{257, 258, 259, 260, 261, 498, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond793(n);
                    }
                };
            }
            case 794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond794(n);
                    }
                };
            }
            case 795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond795(n);
                    }
                };
            }
            case 796: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond796(n);
                    }
                };
            }
            case 797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{498, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond797(n);
                    }
                };
            }
            case 798: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond798(n);
                    }
                };
            }
            case 799: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{257, 258, 259, 260, 261, 498, 522, 523, 200529, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond799(n);
                    }
                };
            }
            case 800: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond800(n);
                    }
                };
            }
            case 801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond801(n);
                    }
                };
            }
            case 802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond802(n);
                    }
                };
            }
            case 803: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond803(n);
                    }
                };
            }
            case 804: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 200530};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond804(n);
                    }
                };
            }
            case 805: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond805(n);
                    }
                };
            }
            case 806: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond806(n);
                    }
                };
            }
            case 807: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond807(n);
                    }
                };
            }
            case 808: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond808(n);
                    }
                };
            }
            case 809: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 459, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond809(n);
                    }
                };
            }
            case 810: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 459, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond810(n);
                    }
                };
            }
            case 811: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond811(n);
                    }
                };
            }
            case 812: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond812(n);
                    }
                };
            }
            case 813: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond813(n);
                    }
                };
            }
            case 814: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 463, 549, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond814(n);
                    }
                };
            }
            case 815: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 463, 549, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond815(n);
                    }
                };
            }
            case 816: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{463, 300370, 300664};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond816(n);
                    }
                };
            }
            case 817: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100466};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond817(n);
                    }
                };
            }
            case 818: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{100466};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond818(n);
                    }
                };
            }
            case 819: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442, 4347};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond819(n);
                    }
                };
            }
            case 820: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442, 4347};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond820(n);
                    }
                };
            }
            case 821: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442, 4347};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond821(n);
                    }
                };
            }
            case 822: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{220, 442, 4347};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond822(n);
                    }
                };
            }
            case 823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond823(n);
                    }
                };
            }
            case 824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond824(n);
                    }
                };
            }
            case 825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond825(n);
                    }
                };
            }
            case 826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond826(n);
                    }
                };
            }
            case 827: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond827(n);
                    }
                };
            }
            case 828: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond828(n);
                    }
                };
            }
            case 829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond829(n);
                    }
                };
            }
            case 830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond830(n);
                    }
                };
            }
            case 831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond831(n);
                    }
                };
            }
            case 832: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond832(n);
                    }
                };
            }
            case 833: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond833(n);
                    }
                };
            }
            case 834: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond834(n);
                    }
                };
            }
            case 835: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300893};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300893, n, 1);
                    }
                };
            }
            case 836: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300894};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300894, n, 1);
                    }
                };
            }
            case 837: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300895};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300895, n, 1);
                    }
                };
            }
            case 838: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300896};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300896, n, 1);
                    }
                };
            }
            case 839: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300897};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300897, n, 1);
                    }
                };
            }
            case 840: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300893};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300893, n, 1);
                    }
                };
            }
            case 841: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300894};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300894, n, 1);
                    }
                };
            }
            case 842: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300895};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300895, n, 1);
                    }
                };
            }
            case 843: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300896};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300896, n, 1);
                    }
                };
            }
            case 844: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2300897};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(2300897, n, 1);
                    }
                };
            }
            case 845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4177};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond845(n);
                    }
                };
            }
            case 846: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4177};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond846(n);
                    }
                };
            }
            case 847: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4177};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond847(n);
                    }
                };
            }
            case 848: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{8, 3915};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond848(n);
                    }
                };
            }
            case 849: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond849(n);
                    }
                };
            }
            case 850: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond850(n);
                    }
                };
            }
            case 851: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond851(n);
                    }
                };
            }
            case 852: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{527};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond852(n);
                    }
                };
            }
            case 853: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond853(n);
                    }
                };
            }
            case 854: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond854(n);
                    }
                };
            }
            case 855: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond855(n);
                    }
                };
            }
            case 856: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond856(n);
                    }
                };
            }
            case 857: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond857(n);
                    }
                };
            }
            case 858: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond858(n);
                    }
                };
            }
            case 863: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond863(n);
                    }
                };
            }
            case 864: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond864(n);
                    }
                };
            }
            case 865: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{358};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(358, n, 1);
                    }
                };
            }
            case 866: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{378};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(378, n, 1);
                    }
                };
            }
            case 867: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 868: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 869: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond869(n);
                    }
                };
            }
            case 870: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 871: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 872: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 873: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond873(n);
                    }
                };
            }
            case 874: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 875: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond875(n);
                    }
                };
            }
            case 876: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond876(n);
                    }
                };
            }
            case 877: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 878: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 879: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond879(n);
                    }
                };
            }
            case 880: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond880(n);
                    }
                };
            }
            case 881: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 882: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 883: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond883(n);
                    }
                };
            }
            case 884: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond884(n);
                    }
                };
            }
            case 885: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 886: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 887: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond887(n);
                    }
                };
            }
            case 888: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond888(n);
                    }
                };
            }
            case 889: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 890: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 891: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond891(n);
                    }
                };
            }
            case 892: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 893: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 894: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond894(n);
                    }
                };
            }
            case 895: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 896: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 897: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond897(n);
                    }
                };
            }
            case 898: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 899: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond899(n);
                    }
                };
            }
            case 900: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 901: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond901(n);
                    }
                };
            }
            case 902: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 903: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond903(n);
                    }
                };
            }
            case 904: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4337};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(4337, n, 1);
                    }
                };
            }
            case 907: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond907(n);
                    }
                };
            }
            case 908: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond908(n);
                    }
                };
            }
            case 909: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100194};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond909(n);
                    }
                };
            }
            case 910: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{1100194};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(1100194, n, 16);
                    }
                };
            }
            case 911: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond911(n);
                    }
                };
            }
            case 912: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond912(n);
                    }
                };
            }
            case 913: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{379};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond913(n);
                    }
                };
            }
            case 916: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond916(n);
                    }
                };
            }
            case 917: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond917(n);
                    }
                };
            }
            case 918: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond918(n);
                    }
                };
            }
            case 919: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond919(n);
                    }
                };
            }
            case 920: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond920(n);
                    }
                };
            }
            case 921: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond921(n);
                    }
                };
            }
            case 922: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond922(n);
                    }
                };
            }
            case 923: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond923(n);
                    }
                };
            }
            case 924: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond924(n);
                    }
                };
            }
            case 925: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond925(n);
                    }
                };
            }
            case 926: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond926(n);
                    }
                };
            }
            case 927: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond927(n);
                    }
                };
            }
            case 928: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond928(n);
                    }
                };
            }
            case 929: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond929(n);
                    }
                };
            }
            case 930: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{359, 549};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond930(n);
                    }
                };
            }
            case 931: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond931(n);
                    }
                };
            }
            case 932: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond932(n);
                    }
                };
            }
            case 933: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond933(n);
                    }
                };
            }
            case 934: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{498};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(498, n, 0);
                    }
                };
            }
            case 935: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{498};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(498, n, 0);
                    }
                };
            }
            case 936: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond936(n);
                    }
                };
            }
            case 937: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 1);
                    }
                };
            }
            case 938: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2200505};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2200505, n, 1);
                    }
                };
            }
            case 940: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{447};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(447, n, 0);
                    }
                };
            }
            case 942: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523, 4581};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond942(n);
                    }
                };
            }
            case 943: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 515, 4040};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond943(n);
                    }
                };
            }
            case 944: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3839};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond944(n);
                    }
                };
            }
            case 945: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond945(n);
                    }
                };
            }
            case 946: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3838};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(3838, n, 1);
                    }
                };
            }
            case 947: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3838};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(3838, n, 1);
                    }
                };
            }
            case 948: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 4044, 4237, 4238, 4239, 5571};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond948(n);
                    }
                };
            }
            case 949: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 4044, 4239, 5571};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond949(n);
                    }
                };
            }
            case 950: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3916};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond950(n);
                    }
                };
            }
            case 951: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3916};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond951(n);
                    }
                };
            }
            case 952: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3916};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond952(n);
                    }
                };
            }
            case 953: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3916};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond953(n);
                    }
                };
            }
            case 955: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond955(n);
                    }
                };
            }
            case 956: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond956(n);
                    }
                };
            }
            case 957: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond957(n);
                    }
                };
            }
            case 1094: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5600};
                    }

                    public boolean evaluate(int n) {
                        return SystemConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(5600, n, 1);
                    }
                };
            }
            case 1095: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond1095(n);
                    }
                };
            }
            case 1096: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 5624, 400490};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond1096(n);
                    }
                };
            }
            case 1097: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 5624, 400490};
                    }

                    public boolean evaluate(int n) {
                        return SystemScreenFactory.evalCond1097(n);
                    }
                };
            }
        }
        return null;
    }
}

