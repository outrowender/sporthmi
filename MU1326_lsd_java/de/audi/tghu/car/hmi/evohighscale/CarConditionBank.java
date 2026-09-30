/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

public class CarConditionBank
implements HMIConditionBank {
    private CarScreenFactory screenFactory;

    public CarConditionBank(CarScreenFactory carScreenFactory) {
        this.screenFactory = carScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 600076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600436};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600436, n, 3);
                    }
                };
            }
            case 600077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600436};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600436, n, 2);
                    }
                };
            }
            case 600078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600436};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600436, n, 1);
                    }
                };
            }
            case 600079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600436};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600436, n, 0);
                    }
                };
            }
            case 600157: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 8);
                    }
                };
            }
            case 600158: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 9);
                    }
                };
            }
            case 600159: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 7);
                    }
                };
            }
            case 600160: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 6);
                    }
                };
            }
            case 600161: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 5);
                    }
                };
            }
            case 600162: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 4);
                    }
                };
            }
            case 600163: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 3);
                    }
                };
            }
            case 600164: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 2);
                    }
                };
            }
            case 600165: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 1);
                    }
                };
            }
            case 600166: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 0);
                    }
                };
            }
            case 600172: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600752};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(600752, n, 0);
                    }
                };
            }
            case 600297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600297(n);
                    }
                };
            }
            case 600298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600298(n);
                    }
                };
            }
            case 600303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600588, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600303(n);
                    }
                };
            }
            case 600304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600588, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600304(n);
                    }
                };
            }
            case 600311: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 4);
                    }
                };
            }
            case 600313: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 2);
                    }
                };
            }
            case 600314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 1);
                    }
                };
            }
            case 600315: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 0);
                    }
                };
            }
            case 600319: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600612};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600612, n, 1);
                    }
                };
            }
            case 600320: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600612};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600612, n, 0);
                    }
                };
            }
            case 600326: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600326(n);
                    }
                };
            }
            case 600329: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 255};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600329(n);
                    }
                };
            }
            case 600330: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{11, 258, 259, 260, 261};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600330(n);
                    }
                };
            }
            case 600331: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600331(n);
                    }
                };
            }
            case 600332: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600332(n);
                    }
                };
            }
            case 600333: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600333(n);
                    }
                };
            }
            case 600334: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600334(n);
                    }
                };
            }
            case 600335: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600335(n);
                    }
                };
            }
            case 600336: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{361, 459, 527};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600336(n);
                    }
                };
            }
            case 600518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600752};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(600752, n, 0);
                    }
                };
            }
            case 600520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601105};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(601105, n, 0);
                    }
                };
            }
            case 600521: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601105};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(601105, n, 0);
                    }
                };
            }
            case 600522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 10);
                    }
                };
            }
            case 600523: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600342, n, 11);
                    }
                };
            }
            case 600533: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 600723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600723(n);
                    }
                };
            }
            case 600730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 3858};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600730(n);
                    }
                };
            }
            case 600797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4159};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600797(n);
                    }
                };
            }
            case 600801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600453, 600454, 601107};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600801(n);
                    }
                };
            }
            case 600802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600453, 600454, 601107};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600802(n);
                    }
                };
            }
            case 600808: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 2);
                    }
                };
            }
            case 600809: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 3);
                    }
                };
            }
            case 600810: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 1);
                    }
                };
            }
            case 600814: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600814(n);
                    }
                };
            }
            case 600815: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600342};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond600815(n);
                    }
                };
            }
            case 601020: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 601021: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 601031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601031(n);
                    }
                };
            }
            case 601107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 601108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601074};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601074, n, 1);
                    }
                };
            }
            case 601109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601074};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601109(n);
                    }
                };
            }
            case 601264: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601264(n);
                    }
                };
            }
            case 601269: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601269(n);
                    }
                };
            }
            case 601288: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601288(n);
                    }
                };
            }
            case 601329: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600353, 600467};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601329(n);
                    }
                };
            }
            case 601330: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600353, 600467};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601330(n);
                    }
                };
            }
            case 601372: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601372(n);
                    }
                };
            }
            case 601373: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601373(n);
                    }
                };
            }
            case 601374: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601374(n);
                    }
                };
            }
            case 601375: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601375(n);
                    }
                };
            }
            case 601376: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600588, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601376(n);
                    }
                };
            }
            case 601377: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600588, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601377(n);
                    }
                };
            }
            case 601388: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601157};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601388(n);
                    }
                };
            }
            case 601392: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601157};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601157, n, 3);
                    }
                };
            }
            case 601393: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601157};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(601157, n, 1);
                    }
                };
            }
            case 601400: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 1);
                    }
                };
            }
            case 601402: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 3);
                    }
                };
            }
            case 601404: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600710};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600710, n, 2);
                    }
                };
            }
            case 601406: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601158};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601406(n);
                    }
                };
            }
            case 601407: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601158};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601407(n);
                    }
                };
            }
            case 601408: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601158};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601158, n, 3);
                    }
                };
            }
            case 601417: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 601915};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601417(n);
                    }
                };
            }
            case 601418: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 601915};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601418(n);
                    }
                };
            }
            case 601419: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 600994, 601156};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601419(n);
                    }
                };
            }
            case 601420: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 600994, 601156};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601420(n);
                    }
                };
            }
            case 601421: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 600994, 601156};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601421(n);
                    }
                };
            }
            case 601422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{46, 600442, 600994, 601156};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601422(n);
                    }
                };
            }
            case 601424: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600994, 601156, 601915};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601424(n);
                    }
                };
            }
            case 601425: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600994, 601156, 601915};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601425(n);
                    }
                };
            }
            case 601426: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600396};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600396, n, 1);
                    }
                };
            }
            case 601427: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600396};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600396, n, 1);
                    }
                };
            }
            case 601428: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600402};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600402, n, 1);
                    }
                };
            }
            case 601429: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600402};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600402, n, 1);
                    }
                };
            }
            case 601433: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601915};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601915, n, 1);
                    }
                };
            }
            case 601704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 4073};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601704(n);
                    }
                };
            }
            case 601775: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600074);
                    }
                };
            }
            case 601776: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600073);
                    }
                };
            }
            case 601777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600045);
                    }
                };
            }
            case 601778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600044);
                    }
                };
            }
            case 601779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600164);
                    }
                };
            }
            case 601780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600029);
                    }
                };
            }
            case 601781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600030);
                    }
                };
            }
            case 601783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600033);
                    }
                };
            }
            case 601785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056, 602709};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601785(n);
                    }
                };
            }
            case 601786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600034);
                    }
                };
            }
            case 601788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600026);
                    }
                };
            }
            case 601789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600023);
                    }
                };
            }
            case 601790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600021);
                    }
                };
            }
            case 601791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600099);
                    }
                };
            }
            case 601792: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600112);
                    }
                };
            }
            case 601793: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600005);
                    }
                };
            }
            case 601794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600006);
                    }
                };
            }
            case 601795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600007);
                    }
                };
            }
            case 601797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600009);
                    }
                };
            }
            case 601798: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600010);
                    }
                };
            }
            case 601800: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600012);
                    }
                };
            }
            case 601801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600015);
                    }
                };
            }
            case 601802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600016);
                    }
                };
            }
            case 601803: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600017);
                    }
                };
            }
            case 601804: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600018);
                    }
                };
            }
            case 601805: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600019);
                    }
                };
            }
            case 601806: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600061);
                    }
                };
            }
            case 601807: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600062);
                    }
                };
            }
            case 601808: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601808(n);
                    }
                };
            }
            case 601809: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601809(n);
                    }
                };
            }
            case 601810: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601810(n);
                    }
                };
            }
            case 601811: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056, 602709};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601811(n);
                    }
                };
            }
            case 601812: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601812(n);
                    }
                };
            }
            case 601813: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601813(n);
                    }
                };
            }
            case 601814: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601814(n);
                    }
                };
            }
            case 601815: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601815(n);
                    }
                };
            }
            case 601816: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601816(n);
                    }
                };
            }
            case 601817: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601817(n);
                    }
                };
            }
            case 601818: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601818(n);
                    }
                };
            }
            case 601819: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601819(n);
                    }
                };
            }
            case 601820: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601820(n);
                    }
                };
            }
            case 601821: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601821(n);
                    }
                };
            }
            case 601822: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601822(n);
                    }
                };
            }
            case 601823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601823(n);
                    }
                };
            }
            case 601826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601826(n);
                    }
                };
            }
            case 601827: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601827(n);
                    }
                };
            }
            case 601828: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601828(n);
                    }
                };
            }
            case 601829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600097);
                    }
                };
            }
            case 601830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601830(n);
                    }
                };
            }
            case 601831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600025);
                    }
                };
            }
            case 601832: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600022);
                    }
                };
            }
            case 601833: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601833(n);
                    }
                };
            }
            case 601834: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600075);
                    }
                };
            }
            case 601835: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601835(n);
                    }
                };
            }
            case 601836: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600076);
                    }
                };
            }
            case 601838: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600553, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601838(n);
                    }
                };
            }
            case 601910: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601910(n);
                    }
                };
            }
            case 601911: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601911(n);
                    }
                };
            }
            case 601912: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601912(n);
                    }
                };
            }
            case 601913: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600013);
                    }
                };
            }
            case 601914: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601074};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601074, n, 1);
                    }
                };
            }
            case 601915: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601074};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601915(n);
                    }
                };
            }
            case 601916: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601240};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(601240, n, 1);
                    }
                };
            }
            case 601919: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600396, 600402};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601919(n);
                    }
                };
            }
            case 601989: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601989(n);
                    }
                };
            }
            case 601994: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601994(n);
                    }
                };
            }
            case 601995: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601995(n);
                    }
                };
            }
            case 601996: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond601996(n);
                    }
                };
            }
            case 601998: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 1);
                    }
                };
            }
            case 602000: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 2);
                    }
                };
            }
            case 602002: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 0);
                    }
                };
            }
            case 602139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600157);
                    }
                };
            }
            case 602140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600141);
                    }
                };
            }
            case 602141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600549};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600549, n, 1);
                    }
                };
            }
            case 602210: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602210(n);
                    }
                };
            }
            case 602211: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602211(n);
                    }
                };
            }
            case 602223: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600749};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600749, n, 1);
                    }
                };
            }
            case 602224: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600749};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600749, n, 0);
                    }
                };
            }
            case 602225: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 3);
                    }
                };
            }
            case 602286: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 5);
                    }
                };
            }
            case 602292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 600817, 601101, 601102};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602292(n);
                    }
                };
            }
            case 602293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602293(n);
                    }
                };
            }
            case 602294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601096};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602294(n);
                    }
                };
            }
            case 602295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601096};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602295(n);
                    }
                };
            }
            case 602303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 602304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 602305: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600817, 601101};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602305(n);
                    }
                };
            }
            case 602375: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602375(n);
                    }
                };
            }
            case 602376: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602376(n);
                    }
                };
            }
            case 602378: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602379};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602379, n, 0);
                    }
                };
            }
            case 602379: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601138};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601138, n, 0);
                    }
                };
            }
            case 602380: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602395};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602395, n, 0);
                    }
                };
            }
            case 602381: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601136};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601136, n, 0);
                    }
                };
            }
            case 602382: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601141};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601141, n, 0);
                    }
                };
            }
            case 602383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601135};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601135, n, 0);
                    }
                };
            }
            case 602385: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601137};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601137, n, 0);
                    }
                };
            }
            case 602500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602500(n);
                    }
                };
            }
            case 602501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602501(n);
                    }
                };
            }
            case 602502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4073};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602502(n);
                    }
                };
            }
            case 602503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600027);
                    }
                };
            }
            case 602504: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 602505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600003);
                    }
                };
            }
            case 602506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600004);
                    }
                };
            }
            case 602507: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{13, 15, 350, 361, 459};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602507(n);
                    }
                };
            }
            case 602508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602508(n);
                    }
                };
            }
            case 602509: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602509(n);
                    }
                };
            }
            case 602510: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602510(n);
                    }
                };
            }
            case 602511: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602511(n);
                    }
                };
            }
            case 602512: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602512(n);
                    }
                };
            }
            case 602515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602515(n);
                    }
                };
            }
            case 602516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602516(n);
                    }
                };
            }
            case 602517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602517(n);
                    }
                };
            }
            case 602518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602518(n);
                    }
                };
            }
            case 602521: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 602522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602522(n);
                    }
                };
            }
            case 602523: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602523(n);
                    }
                };
            }
            case 602524: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602524(n);
                    }
                };
            }
            case 602525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602525(n);
                    }
                };
            }
            case 602529: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602529(n);
                    }
                };
            }
            case 602530: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602530(n);
                    }
                };
            }
            case 602531: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602531(n);
                    }
                };
            }
            case 602532: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602532(n);
                    }
                };
            }
            case 602599: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602599(n);
                    }
                };
            }
            case 602600: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600157);
                    }
                };
            }
            case 602602: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602602(n);
                    }
                };
            }
            case 602603: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600027);
                    }
                };
            }
            case 602604: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602604(n);
                    }
                };
            }
            case 602605: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 602606: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 602607: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602607(n);
                    }
                };
            }
            case 602608: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600002);
                    }
                };
            }
            case 602609: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600183);
                    }
                };
            }
            case 602610: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602610(n);
                    }
                };
            }
            case 602611: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600003);
                    }
                };
            }
            case 602737: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond602737(n);
                    }
                };
            }
            case 602738: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600004);
                    }
                };
            }
            case 602988: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600686, n, 6);
                    }
                };
            }
            case 603056: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601035};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601035, n, 0);
                    }
                };
            }
            case 603223: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600072);
                    }
                };
            }
            case 603291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603291(n);
                    }
                };
            }
            case 603292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603292(n);
                    }
                };
            }
            case 603293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603293(n);
                    }
                };
            }
            case 603294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603294(n);
                    }
                };
            }
            case 603298: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 2);
                    }
                };
            }
            case 603299: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 1);
                    }
                };
            }
            case 603300: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 0);
                    }
                };
            }
            case 603305: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603305(n);
                    }
                };
            }
            case 603306: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 603307: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 603308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 603310: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 1);
                    }
                };
            }
            case 603312: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 2);
                    }
                };
            }
            case 603314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 0);
                    }
                };
            }
            case 603383: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603383(n);
                    }
                };
            }
            case 603391: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600396, 600402};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603391(n);
                    }
                };
            }
            case 603392: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600399};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603392(n);
                    }
                };
            }
            case 603393: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600396, 600402};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603393(n);
                    }
                };
            }
            case 603462: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603462(n);
                    }
                };
            }
            case 603463: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600157);
                    }
                };
            }
            case 603464: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603464(n);
                    }
                };
            }
            case 603465: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603465(n);
                    }
                };
            }
            case 603466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603466(n);
                    }
                };
            }
            case 603467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603467(n);
                    }
                };
            }
            case 603468: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603468(n);
                    }
                };
            }
            case 603713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600003);
                    }
                };
            }
            case 603776: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600027);
                    }
                };
            }
            case 603777: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 603778: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603778(n);
                    }
                };
            }
            case 603779: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond603779(n);
                    }
                };
            }
            case 603780: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600004);
                    }
                };
            }
            case 604109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604109(n);
                    }
                };
            }
            case 604110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604110(n);
                    }
                };
            }
            case 604111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604111(n);
                    }
                };
            }
            case 604112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4306};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604112(n);
                    }
                };
            }
            case 604113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604113(n);
                    }
                };
            }
            case 604114: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 1100194};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604114(n);
                    }
                };
            }
            case 604115: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604115(n);
                    }
                };
            }
            case 604116: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604116(n);
                    }
                };
            }
            case 604117: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604117(n);
                    }
                };
            }
            case 604118: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604118(n);
                    }
                };
            }
            case 604119: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4076, 4494};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604119(n);
                    }
                };
            }
            case 604120: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{377, 3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604120(n);
                    }
                };
            }
            case 604121: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 2100360};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604121(n);
                    }
                };
            }
            case 604122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 2100365};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604122(n);
                    }
                };
            }
            case 604123: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600830};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604123(n);
                    }
                };
            }
            case 604124: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600830};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604124(n);
                    }
                };
            }
            case 604125: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600832};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604125(n);
                    }
                };
            }
            case 604126: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600832};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604126(n);
                    }
                };
            }
            case 604127: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600823, 601130};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604127(n);
                    }
                };
            }
            case 604128: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600823};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604128(n);
                    }
                };
            }
            case 604129: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600823, 601130};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604129(n);
                    }
                };
            }
            case 604130: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600823};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604130(n);
                    }
                };
            }
            case 604131: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600828};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604131(n);
                    }
                };
            }
            case 604132: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600828};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604132(n);
                    }
                };
            }
            case 604133: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600836};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604133(n);
                    }
                };
            }
            case 604134: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600836};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604134(n);
                    }
                };
            }
            case 604135: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600844};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604135(n);
                    }
                };
            }
            case 604136: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600844};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604136(n);
                    }
                };
            }
            case 604137: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601597};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604137(n);
                    }
                };
            }
            case 604138: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601597};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604138(n);
                    }
                };
            }
            case 604139: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601134};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604139(n);
                    }
                };
            }
            case 604140: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 601134};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604140(n);
                    }
                };
            }
            case 604141: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601132};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604141(n);
                    }
                };
            }
            case 604142: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600842};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604142(n);
                    }
                };
            }
            case 604143: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600842};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604143(n);
                    }
                };
            }
            case 604144: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600838};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604144(n);
                    }
                };
            }
            case 604145: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600838};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604145(n);
                    }
                };
            }
            case 604146: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600819};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604146(n);
                    }
                };
            }
            case 604147: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600819};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604147(n);
                    }
                };
            }
            case 604148: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 3939, 600817, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604148(n);
                    }
                };
            }
            case 604149: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604149(n);
                    }
                };
            }
            case 604150: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601443};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604150(n);
                    }
                };
            }
            case 604151: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 601443};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604151(n);
                    }
                };
            }
            case 604154: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601138};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604154(n);
                    }
                };
            }
            case 604155: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601138};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604155(n);
                    }
                };
            }
            case 604156: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602395};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604156(n);
                    }
                };
            }
            case 604157: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 602395};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604157(n);
                    }
                };
            }
            case 604158: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601141};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604158(n);
                    }
                };
            }
            case 604159: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601141};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604159(n);
                    }
                };
            }
            case 604160: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601136};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604160(n);
                    }
                };
            }
            case 604161: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601136};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604161(n);
                    }
                };
            }
            case 604162: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 3939, 601135};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604162(n);
                    }
                };
            }
            case 604163: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601135};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604163(n);
                    }
                };
            }
            case 604164: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601137};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604164(n);
                    }
                };
            }
            case 604165: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601137};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604165(n);
                    }
                };
            }
            case 604166: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601106};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604166(n);
                    }
                };
            }
            case 604167: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 601106};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604167(n);
                    }
                };
            }
            case 604170: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601007};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604170(n);
                    }
                };
            }
            case 604171: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601007};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604171(n);
                    }
                };
            }
            case 604173: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 2100491};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604173(n);
                    }
                };
            }
            case 604187: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{4159};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604187(n);
                    }
                };
            }
            case 604203: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600553, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604203(n);
                    }
                };
            }
            case 604204: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600723};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600723, n, 1);
                    }
                };
            }
            case 604205: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600723};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600723, n, 0);
                    }
                };
            }
            case 604226: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604226(n);
                    }
                };
            }
            case 604227: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604227(n);
                    }
                };
            }
            case 604228: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604228(n);
                    }
                };
            }
            case 604229: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604229(n);
                    }
                };
            }
            case 604230: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604230(n);
                    }
                };
            }
            case 604231: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604231(n);
                    }
                };
            }
            case 604232: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604233: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604234: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604236: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604236(n);
                    }
                };
            }
            case 604237: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604237(n);
                    }
                };
            }
            case 604238: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604238(n);
                    }
                };
            }
            case 604239: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604239(n);
                    }
                };
            }
            case 604240: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604240(n);
                    }
                };
            }
            case 604241: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604242: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604243: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604246: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 601730};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604246(n);
                    }
                };
            }
            case 604252: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100401, n, 0);
                    }
                };
            }
            case 604253: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100401, n, 1);
                    }
                };
            }
            case 604256: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604256(n);
                    }
                };
            }
            case 604257: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600097);
                    }
                };
            }
            case 604258: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602121};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604258(n);
                    }
                };
            }
            case 604259: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600815};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600815, n, 0);
                    }
                };
            }
            case 604280: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604280(n);
                    }
                };
            }
            case 604281: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604281(n);
                    }
                };
            }
            case 604282: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604282(n);
                    }
                };
            }
            case 604283: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604283(n);
                    }
                };
            }
            case 604284: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604284(n);
                    }
                };
            }
            case 604285: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604286: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604287: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604291: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601915};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601915, n, 0);
                    }
                };
            }
            case 604292: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604292(n);
                    }
                };
            }
            case 604293: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604293(n);
                    }
                };
            }
            case 604294: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604294(n);
                    }
                };
            }
            case 604295: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604295(n);
                    }
                };
            }
            case 604296: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 600823};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604296(n);
                    }
                };
            }
            case 604297: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 600823, 600828, 601130};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604297(n);
                    }
                };
            }
            case 604302: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601129, 601135, 601136, 601137, 601138, 601141, 602379, 602395};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604302(n);
                    }
                };
            }
            case 604303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600200);
                    }
                };
            }
            case 604308: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601809};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604308(n);
                    }
                };
            }
            case 604309: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601809};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604309(n);
                    }
                };
            }
            case 604310: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604310(n);
                    }
                };
            }
            case 604314: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604314(n);
                    }
                };
            }
            case 604315: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604315(n);
                    }
                };
            }
            case 604316: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601129, 601135, 601136, 601137, 601138, 601141, 602379, 602395};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604316(n);
                    }
                };
            }
            case 604317: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601087, 601129, 601135, 601136, 601137, 601138, 601141, 602379, 602395};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604317(n);
                    }
                };
            }
            case 604320: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604320(n);
                    }
                };
            }
            case 604398: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604398(n);
                    }
                };
            }
            case 604401: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600038);
                    }
                };
            }
            case 604405: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600168);
                    }
                };
            }
            case 604406: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604406(n);
                    }
                };
            }
            case 604407: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604407(n);
                    }
                };
            }
            case 604408: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604408(n);
                    }
                };
            }
            case 604409: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604409(n);
                    }
                };
            }
            case 604410: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604410(n);
                    }
                };
            }
            case 604411: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604411(n);
                    }
                };
            }
            case 604412: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604412(n);
                    }
                };
            }
            case 604413: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604413(n);
                    }
                };
            }
            case 604414: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604414(n);
                    }
                };
            }
            case 604415: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604415(n);
                    }
                };
            }
            case 604416: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604416(n);
                    }
                };
            }
            case 604417: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604417(n);
                    }
                };
            }
            case 604418: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604418(n);
                    }
                };
            }
            case 604419: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604419(n);
                    }
                };
            }
            case 604420: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604420(n);
                    }
                };
            }
            case 604421: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604421(n);
                    }
                };
            }
            case 604422: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604422(n);
                    }
                };
            }
            case 604423: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604423(n);
                    }
                };
            }
            case 604424: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604424(n);
                    }
                };
            }
            case 604425: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604425(n);
                    }
                };
            }
            case 604426: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604426(n);
                    }
                };
            }
            case 604427: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604427(n);
                    }
                };
            }
            case 604428: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604428(n);
                    }
                };
            }
            case 604429: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604429(n);
                    }
                };
            }
            case 604430: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604430(n);
                    }
                };
            }
            case 604431: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604431(n);
                    }
                };
            }
            case 604432: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604432(n);
                    }
                };
            }
            case 604433: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604433(n);
                    }
                };
            }
            case 604434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604434(n);
                    }
                };
            }
            case 604435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604435(n);
                    }
                };
            }
            case 604436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604436(n);
                    }
                };
            }
            case 604437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604437(n);
                    }
                };
            }
            case 604438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604438(n);
                    }
                };
            }
            case 604439: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604439(n);
                    }
                };
            }
            case 604440: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604440(n);
                    }
                };
            }
            case 604441: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604441(n);
                    }
                };
            }
            case 604442: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604442(n);
                    }
                };
            }
            case 604443: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604443(n);
                    }
                };
            }
            case 604444: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604444(n);
                    }
                };
            }
            case 604445: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604445(n);
                    }
                };
            }
            case 604446: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604446(n);
                    }
                };
            }
            case 604447: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604447(n);
                    }
                };
            }
            case 604448: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604448(n);
                    }
                };
            }
            case 604449: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604449(n);
                    }
                };
            }
            case 604450: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604450(n);
                    }
                };
            }
            case 604451: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604451(n);
                    }
                };
            }
            case 604452: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604452(n);
                    }
                };
            }
            case 604453: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604453(n);
                    }
                };
            }
            case 604454: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604454(n);
                    }
                };
            }
            case 604455: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604455(n);
                    }
                };
            }
            case 604456: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604456(n);
                    }
                };
            }
            case 604457: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604457(n);
                    }
                };
            }
            case 604458: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604458(n);
                    }
                };
            }
            case 604459: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604459(n);
                    }
                };
            }
            case 604466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604466(n);
                    }
                };
            }
            case 604467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604467(n);
                    }
                };
            }
            case 604468: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604468(n);
                    }
                };
            }
            case 604469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604469(n);
                    }
                };
            }
            case 604470: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604470(n);
                    }
                };
            }
            case 604471: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604471(n);
                    }
                };
            }
            case 604472: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604472(n);
                    }
                };
            }
            case 604473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604473(n);
                    }
                };
            }
            case 604474: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604474(n);
                    }
                };
            }
            case 604475: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604475(n);
                    }
                };
            }
            case 604476: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604476(n);
                    }
                };
            }
            case 604477: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604477(n);
                    }
                };
            }
            case 604478: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604478(n);
                    }
                };
            }
            case 604479: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604479(n);
                    }
                };
            }
            case 604480: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604480(n);
                    }
                };
            }
            case 604483: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604483(n);
                    }
                };
            }
            case 604484: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604484(n);
                    }
                };
            }
            case 604485: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604485(n);
                    }
                };
            }
            case 604486: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604486(n);
                    }
                };
            }
            case 604489: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 2);
                    }
                };
            }
            case 604490: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 1);
                    }
                };
            }
            case 604492: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100477};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100477, n, 0);
                    }
                };
            }
            case 604493: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100401, n, 1);
                    }
                };
            }
            case 604494: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604494(n);
                    }
                };
            }
            case 604495: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604496: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604497: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604499: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 1);
                    }
                };
            }
            case 604501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 2);
                    }
                };
            }
            case 604503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100476};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100476, n, 0);
                    }
                };
            }
            case 604504: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100401};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100401, n, 0);
                    }
                };
            }
            case 604505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604139);
                    }
                };
            }
            case 604506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604506(n);
                    }
                };
            }
            case 604507: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604507(n);
                    }
                };
            }
            case 604508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604508(n);
                    }
                };
            }
            case 604509: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604509(n);
                    }
                };
            }
            case 604510: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604510(n);
                    }
                };
            }
            case 604511: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604512: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604513: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 601007};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604516(n);
                    }
                };
            }
            case 604517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 601007};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604517(n);
                    }
                };
            }
            case 604518: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 602379};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604518(n);
                    }
                };
            }
            case 604519: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100507};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604519(n);
                    }
                };
            }
            case 604520: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 2100507};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604520(n);
                    }
                };
            }
            case 604521: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100508};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604521(n);
                    }
                };
            }
            case 604522: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 2100508};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604522(n);
                    }
                };
            }
            case 604523: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602379};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604523(n);
                    }
                };
            }
            case 604524: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 1);
                    }
                };
            }
            case 604525: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 3);
                    }
                };
            }
            case 604526: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 2);
                    }
                };
            }
            case 604528: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 2);
                    }
                };
            }
            case 604530: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 3);
                    }
                };
            }
            case 604532: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 1);
                    }
                };
            }
            case 604549: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600714};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604549(n);
                    }
                };
            }
            case 604551: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 1);
                    }
                };
            }
            case 604553: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 2);
                    }
                };
            }
            case 604555: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601232, n, 0);
                    }
                };
            }
            case 604556: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100408, 2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604556(n);
                    }
                };
            }
            case 604557: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100410, 2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604557(n);
                    }
                };
            }
            case 604558: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100423};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604558(n);
                    }
                };
            }
            case 604559: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100417};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604559(n);
                    }
                };
            }
            case 604560: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 0x200CC0};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604560(n);
                    }
                };
            }
            case 604561: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100414};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604561(n);
                    }
                };
            }
            case 604562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412, 2100421};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604562(n);
                    }
                };
            }
            case 604563: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{0x200CC2, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604563(n);
                    }
                };
            }
            case 604564: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100422, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604564(n);
                    }
                };
            }
            case 604565: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100424, 2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604565(n);
                    }
                };
            }
            case 604566: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100431};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604566(n);
                    }
                };
            }
            case 604567: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100429};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604567(n);
                    }
                };
            }
            case 604568: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100434};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604568(n);
                    }
                };
            }
            case 604569: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426, 2100430};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604569(n);
                    }
                };
            }
            case 604585: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604585(n);
                    }
                };
            }
            case 604586: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604587: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604588: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604589: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604590: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604591: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604592: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 0);
                    }
                };
            }
            case 604593: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604594: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604595: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604596: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604597: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604598: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604599: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 0);
                    }
                };
            }
            case 604628: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(2100465, n, 0);
                    }
                };
            }
            case 604629: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3915};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(3915, n, 1);
                    }
                };
            }
            case 604630: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604630(n);
                    }
                };
            }
            case 604631: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604631(n);
                    }
                };
            }
            case 604632: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604632(n);
                    }
                };
            }
            case 604633: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600686};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604633(n);
                    }
                };
            }
            case 604648: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604648(n);
                    }
                };
            }
            case 604649: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604649(n);
                    }
                };
            }
            case 604650: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604140);
                    }
                };
            }
            case 604651: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100491};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604651(n);
                    }
                };
            }
            case 604652: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100492};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604652(n);
                    }
                };
            }
            case 604653: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 2100492};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604653(n);
                    }
                };
            }
            case 604654: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100490, 2100494};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604654(n);
                    }
                };
            }
            case 604655: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 2100494};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604655(n);
                    }
                };
            }
            case 604664: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604664(n);
                    }
                };
            }
            case 604665: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604665(n);
                    }
                };
            }
            case 604674: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604674(n);
                    }
                };
            }
            case 604675: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604675(n);
                    }
                };
            }
            case 604683: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604683(n);
                    }
                };
            }
            case 604684: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601443};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604684(n);
                    }
                };
            }
            case 604685: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604685(n);
                    }
                };
            }
            case 604686: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604686(n);
                    }
                };
            }
            case 604687: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601443};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604687(n);
                    }
                };
            }
            case 604688: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 1);
                    }
                };
            }
            case 604689: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 3);
                    }
                };
            }
            case 604690: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 2);
                    }
                };
            }
            case 604692: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 2);
                    }
                };
            }
            case 604694: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 3);
                    }
                };
            }
            case 604696: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100465, n, 1);
                    }
                };
            }
            case 604697: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(2100465, n, 0);
                    }
                };
            }
            case 604703: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604703(n);
                    }
                };
            }
            case 604704: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604704(n);
                    }
                };
            }
            case 604705: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604705(n);
                    }
                };
            }
            case 604706: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604706(n);
                    }
                };
            }
            case 604707: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604707(n);
                    }
                };
            }
            case 604708: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604708(n);
                    }
                };
            }
            case 604709: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604709(n);
                    }
                };
            }
            case 604710: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604710(n);
                    }
                };
            }
            case 604711: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604711(n);
                    }
                };
            }
            case 604712: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604712(n);
                    }
                };
            }
            case 604713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604713(n);
                    }
                };
            }
            case 604714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604714(n);
                    }
                };
            }
            case 604715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604715(n);
                    }
                };
            }
            case 604716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604716(n);
                    }
                };
            }
            case 604717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604717(n);
                    }
                };
            }
            case 604718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604718(n);
                    }
                };
            }
            case 604719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604719(n);
                    }
                };
            }
            case 604720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604720(n);
                    }
                };
            }
            case 604721: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604721(n);
                    }
                };
            }
            case 604722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604722(n);
                    }
                };
            }
            case 604723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604723(n);
                    }
                };
            }
            case 604724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604724(n);
                    }
                };
            }
            case 604725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604725(n);
                    }
                };
            }
            case 604726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604726(n);
                    }
                };
            }
            case 604727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604727(n);
                    }
                };
            }
            case 604728: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604728(n);
                    }
                };
            }
            case 604729: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604729(n);
                    }
                };
            }
            case 604730: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604730(n);
                    }
                };
            }
            case 604731: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604731(n);
                    }
                };
            }
            case 604732: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604732(n);
                    }
                };
            }
            case 604733: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604733(n);
                    }
                };
            }
            case 604734: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604734(n);
                    }
                };
            }
            case 604735: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604735(n);
                    }
                };
            }
            case 604736: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604736(n);
                    }
                };
            }
            case 604737: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604737(n);
                    }
                };
            }
            case 604738: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604738(n);
                    }
                };
            }
            case 604739: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604739(n);
                    }
                };
            }
            case 604740: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604740(n);
                    }
                };
            }
            case 604741: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604741(n);
                    }
                };
            }
            case 604742: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604742(n);
                    }
                };
            }
            case 604743: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604743(n);
                    }
                };
            }
            case 604744: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604744(n);
                    }
                };
            }
            case 604745: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604745(n);
                    }
                };
            }
            case 604746: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604746(n);
                    }
                };
            }
            case 604747: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604747(n);
                    }
                };
            }
            case 604748: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604748(n);
                    }
                };
            }
            case 604749: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604749(n);
                    }
                };
            }
            case 604750: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604750(n);
                    }
                };
            }
            case 604751: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604751(n);
                    }
                };
            }
            case 604752: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604752(n);
                    }
                };
            }
            case 604753: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604753(n);
                    }
                };
            }
            case 604754: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604754(n);
                    }
                };
            }
            case 604755: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604755(n);
                    }
                };
            }
            case 604756: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604756(n);
                    }
                };
            }
            case 604757: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604757(n);
                    }
                };
            }
            case 604758: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604758(n);
                    }
                };
            }
            case 604759: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604759(n);
                    }
                };
            }
            case 604760: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604760(n);
                    }
                };
            }
            case 604761: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604761(n);
                    }
                };
            }
            case 604762: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604762(n);
                    }
                };
            }
            case 604765: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604765(n);
                    }
                };
            }
            case 604767: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604767(n);
                    }
                };
            }
            case 604769: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604769(n);
                    }
                };
            }
            case 604770: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604770(n);
                    }
                };
            }
            case 604771: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604771(n);
                    }
                };
            }
            case 604772: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604772(n);
                    }
                };
            }
            case 604781: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 604782: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 604783: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 604784: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 604785: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100360};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100360, n, 2);
                    }
                };
            }
            case 604786: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100365};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100365, n, 2);
                    }
                };
            }
            case 604787: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100375};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100375, n, 2);
                    }
                };
            }
            case 604788: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100376};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100376, n, 2);
                    }
                };
            }
            case 604789: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100375};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100375, n, 2);
                    }
                };
            }
            case 604790: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100375};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100375, n, 2);
                    }
                };
            }
            case 604791: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100376};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100376, n, 2);
                    }
                };
            }
            case 604792: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100376};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueLesserCondition(2100376, n, 2);
                    }
                };
            }
            case 604794: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604794(n);
                    }
                };
            }
            case 604795: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604795(n);
                    }
                };
            }
            case 604796: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604139);
                    }
                };
            }
            case 604797: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604109);
                    }
                };
            }
            case 604798: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600199);
                    }
                };
            }
            case 604799: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604141);
                    }
                };
            }
            case 604800: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604137);
                    }
                };
            }
            case 604801: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604138);
                    }
                };
            }
            case 604802: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100360};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604802(n);
                    }
                };
            }
            case 604803: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 2100365};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604803(n);
                    }
                };
            }
            case 604804: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{372};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604804(n);
                    }
                };
            }
            case 604805: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604805(n);
                    }
                };
            }
            case 604806: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604806(n);
                    }
                };
            }
            case 604807: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600716};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604807(n);
                    }
                };
            }
            case 604808: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600716};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604808(n);
                    }
                };
            }
            case 604809: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600716};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604809(n);
                    }
                };
            }
            case 604811: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604811(n);
                    }
                };
            }
            case 604812: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604812(n);
                    }
                };
            }
            case 604813: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604813(n);
                    }
                };
            }
            case 604816: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600709};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600709, n, 1);
                    }
                };
            }
            case 604817: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600709};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600709, n, 3);
                    }
                };
            }
            case 604818: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600709};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600709, n, 2);
                    }
                };
            }
            case 604819: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604819(n);
                    }
                };
            }
            case 604820: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604820(n);
                    }
                };
            }
            case 604821: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604821(n);
                    }
                };
            }
            case 604822: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604822(n);
                    }
                };
            }
            case 604823: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604823(n);
                    }
                };
            }
            case 604824: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604824(n);
                    }
                };
            }
            case 604825: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604825(n);
                    }
                };
            }
            case 604826: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604826(n);
                    }
                };
            }
            case 604827: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604827(n);
                    }
                };
            }
            case 604828: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 600817, 601101, 601102};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604828(n);
                    }
                };
            }
            case 604829: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600817, 601101};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604829(n);
                    }
                };
            }
            case 604830: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601096};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604830(n);
                    }
                };
            }
            case 604831: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601096};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604831(n);
                    }
                };
            }
            case 604832: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601094};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604832(n);
                    }
                };
            }
            case 604833: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601094};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604833(n);
                    }
                };
            }
            case 604834: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601098};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604834(n);
                    }
                };
            }
            case 604835: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601098};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604835(n);
                    }
                };
            }
            case 604836: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604836(n);
                    }
                };
            }
            case 604837: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604837(n);
                    }
                };
            }
            case 604838: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604838(n);
                    }
                };
            }
            case 604839: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604839(n);
                    }
                };
            }
            case 604840: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604840(n);
                    }
                };
            }
            case 604841: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600817, 601100};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604841(n);
                    }
                };
            }
            case 604842: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604843: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604844: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604845: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604848: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604848(n);
                    }
                };
            }
            case 604849: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604849(n);
                    }
                };
            }
            case 604850: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604850(n);
                    }
                };
            }
            case 604851: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604851(n);
                    }
                };
            }
            case 604852: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604852(n);
                    }
                };
            }
            case 604853: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{600353};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(600353, n, 1);
                    }
                };
            }
            case 604854: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604854(n);
                    }
                };
            }
            case 604855: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602076};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602076, n, 0);
                    }
                };
            }
            case 604856: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604856(n);
                    }
                };
            }
            case 604857: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608, 602076};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604857(n);
                    }
                };
            }
            case 604858: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602076};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604858(n);
                    }
                };
            }
            case 604859: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602202};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604859(n);
                    }
                };
            }
            case 604860: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602201};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604860(n);
                    }
                };
            }
            case 604861: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604861(n);
                    }
                };
            }
            case 604862: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604862(n);
                    }
                };
            }
            case 604863: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604863(n);
                    }
                };
            }
            case 604864: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600006);
                    }
                };
            }
            case 604865: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604147);
                    }
                };
            }
            case 604866: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604866(n);
                    }
                };
            }
            case 604867: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604867(n);
                    }
                };
            }
            case 604868: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604868(n);
                    }
                };
            }
            case 604869: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600099);
                    }
                };
            }
            case 604872: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939, 5583, 5602, 5606};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604872(n);
                    }
                };
            }
            case 604873: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604873(n);
                    }
                };
            }
            case 604874: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602113};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602113, n, 1);
                    }
                };
            }
            case 604875: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602114};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602114, n, 1);
                    }
                };
            }
            case 604876: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602116};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602116, n, 1);
                    }
                };
            }
            case 604877: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602118};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602118, n, 1);
                    }
                };
            }
            case 604878: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602113};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602113, n, 1);
                    }
                };
            }
            case 604879: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604879(n);
                    }
                };
            }
            case 604880: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604880(n);
                    }
                };
            }
            case 604881: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 600815, 601056, 601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604881(n);
                    }
                };
            }
            case 604882: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604882(n);
                    }
                };
            }
            case 604883: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604151);
                    }
                };
            }
            case 604885: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604885(n);
                    }
                };
            }
            case 604886: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604887: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604888: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604889: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602231};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602231, n, 0);
                    }
                };
            }
            case 604890: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602232};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602232, n, 0);
                    }
                };
            }
            case 604891: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604112);
                    }
                };
            }
            case 604892: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604892(n);
                    }
                };
            }
            case 604893: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604893(n);
                    }
                };
            }
            case 604897: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604897(n);
                    }
                };
            }
            case 604898: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604898(n);
                    }
                };
            }
            case 604899: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602231};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602231, n, 0);
                    }
                };
            }
            case 604900: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604900(n);
                    }
                };
            }
            case 604901: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604901(n);
                    }
                };
            }
            case 604902: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604902(n);
                    }
                };
            }
            case 604903: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604903(n);
                    }
                };
            }
            case 604916: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100412};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100412, n, 1);
                    }
                };
            }
            case 604917: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100426};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(2100426, n, 1);
                    }
                };
            }
            case 604918: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602240};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602240, n, 0);
                    }
                };
            }
            case 604919: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604919(n);
                    }
                };
            }
            case 604921: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604921(n);
                    }
                };
            }
            case 604922: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 469, 522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604922(n);
                    }
                };
            }
            case 604923: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601888};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604923(n);
                    }
                };
            }
            case 604924: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601888, 602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604924(n);
                    }
                };
            }
            case 604925: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604925(n);
                    }
                };
            }
            case 604926: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601885, 602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604926(n);
                    }
                };
            }
            case 604927: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601888, 602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604927(n);
                    }
                };
            }
            case 604928: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601885, 601888};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604928(n);
                    }
                };
            }
            case 604929: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601885, 601888};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604929(n);
                    }
                };
            }
            case 604930: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604931: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 600039);
                    }
                };
            }
            case 604932: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604139);
                    }
                };
            }
            case 604933: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604139);
                    }
                };
            }
            case 604942: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604942(n);
                    }
                };
            }
            case 604943: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604943(n);
                    }
                };
            }
            case 604944: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604944(n);
                    }
                };
            }
            case 604951: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604952: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604953: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604954: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604955: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604956: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604957: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604957(n);
                    }
                };
            }
            case 604958: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604958(n);
                    }
                };
            }
            case 604959: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 600817, 601101, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604959(n);
                    }
                };
            }
            case 604966: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604967: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604968: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604969: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604970: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604971: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601102};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601102, n, 0);
                    }
                };
            }
            case 604972: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604972(n);
                    }
                };
            }
            case 604973: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{468, 522, 3939, 600817, 601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604973(n);
                    }
                };
            }
            case 604974: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(2100465, n, 0);
                    }
                };
            }
            case 604975: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100465};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(2100465, n, 0);
                    }
                };
            }
            case 604977: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601007};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604977(n);
                    }
                };
            }
            case 604978: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604978(n);
                    }
                };
            }
            case 604979: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601234};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond604979(n);
                    }
                };
            }
            case 605029: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{52, 3939, 5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605029(n);
                    }
                };
            }
            case 605030: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 3939, 601135};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605030(n);
                    }
                };
            }
            case 605031: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605031(n);
                    }
                };
            }
            case 605032: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605032(n);
                    }
                };
            }
            case 605034: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602202};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605034(n);
                    }
                };
            }
            case 605035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 602201};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605035(n);
                    }
                };
            }
            case 605036: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602201, 602202};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605036(n);
                    }
                };
            }
            case 605037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{372, 375, 5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605037(n);
                    }
                };
            }
            case 605038: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605038(n);
                    }
                };
            }
            case 605039: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601809};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601809, n, 0);
                    }
                };
            }
            case 605048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601756};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601756, n, 1);
                    }
                };
            }
            case 605049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602296};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602296, n, 1);
                    }
                };
            }
            case 605050: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601757};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601757, n, 1);
                    }
                };
            }
            case 605051: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602297};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602297, n, 1);
                    }
                };
            }
            case 605052: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602246};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(602246, n, 1);
                    }
                };
            }
            case 605053: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602246};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(602246, n, 1);
                    }
                };
            }
            case 605054: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602247};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(602247, n, 1);
                    }
                };
            }
            case 605061: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602297};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602297, n, 1);
                    }
                };
            }
            case 605062: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602296};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602296, n, 1);
                    }
                };
            }
            case 605063: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100494};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605063(n);
                    }
                };
            }
            case 605064: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{2100494};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605064(n);
                    }
                };
            }
            case 605065: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 601579, 602240};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605065(n);
                    }
                };
            }
            case 605066: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604151);
                    }
                };
            }
            case 605069: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601056, n, 604109);
                    }
                };
            }
            case 605070: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601056};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605070(n);
                    }
                };
            }
            case 605071: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605071(n);
                    }
                };
            }
            case 605072: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605072(n);
                    }
                };
            }
            case 605073: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605073(n);
                    }
                };
            }
            case 605074: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605074(n);
                    }
                };
            }
            case 605075: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605075(n);
                    }
                };
            }
            case 605076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605076(n);
                    }
                };
            }
            case 605077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605077(n);
                    }
                };
            }
            case 605078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605078(n);
                    }
                };
            }
            case 605079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605079(n);
                    }
                };
            }
            case 605080: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605080(n);
                    }
                };
            }
            case 605081: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605081(n);
                    }
                };
            }
            case 605082: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602321};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605082(n);
                    }
                };
            }
            case 605083: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605083(n);
                    }
                };
            }
            case 605084: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605084(n);
                    }
                };
            }
            case 605085: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605085(n);
                    }
                };
            }
            case 605086: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605086(n);
                    }
                };
            }
            case 605087: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605087(n);
                    }
                };
            }
            case 605088: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605088(n);
                    }
                };
            }
            case 605089: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605089(n);
                    }
                };
            }
            case 605090: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605090(n);
                    }
                };
            }
            case 605091: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605091(n);
                    }
                };
            }
            case 605092: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605092(n);
                    }
                };
            }
            case 605093: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605093(n);
                    }
                };
            }
            case 605103: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605103(n);
                    }
                };
            }
            case 605104: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605104(n);
                    }
                };
            }
            case 605105: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605105(n);
                    }
                };
            }
            case 605106: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605106(n);
                    }
                };
            }
            case 605107: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601207, n, 1);
                    }
                };
            }
            case 605108: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601206};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605108(n);
                    }
                };
            }
            case 605109: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{466, 467, 469, 522, 523, 600817, 601205};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605109(n);
                    }
                };
            }
            case 605110: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522, 523};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605110(n);
                    }
                };
            }
            case 605111: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605111(n);
                    }
                };
            }
            case 605112: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{601207};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(601207, n, 1);
                    }
                };
            }
            case 605113: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602709};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602709, n, 0);
                    }
                };
            }
            case 605114: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 602709};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605114(n);
                    }
                };
            }
            case 605122: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605122(n);
                    }
                };
            }
            case 605123: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5600};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605123(n);
                    }
                };
            }
            case 605125: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5608};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(5608, n, 1);
                    }
                };
            }
            case 605316: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602736};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602736, n, 1);
                    }
                };
            }
            case 605317: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{602736};
                    }

                    public boolean evaluate(int n) {
                        return CarConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(602736, n, 1);
                    }
                };
            }
            case 605321: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605321(n);
                    }
                };
            }
            case 605322: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605322(n);
                    }
                };
            }
            case 605323: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605323(n);
                    }
                };
            }
            case 605324: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605324(n);
                    }
                };
            }
            case 605325: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605325(n);
                    }
                };
            }
            case 605326: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5608};
                    }

                    public boolean evaluate(int n) {
                        return CarScreenFactory.evalCond605326(n);
                    }
                };
            }
        }
        return null;
    }
}

