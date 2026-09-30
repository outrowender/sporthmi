/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.addressbook.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.addressbook.hmi.evohighscale.AddressBookScreenFactory;

public class AddressBookConditionBank
implements HMIConditionBank {
    private AddressBookScreenFactory screenFactory;

    public AddressBookConditionBank(AddressBookScreenFactory addressBookScreenFactory) {
        this.screenFactory = addressBookScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            case 700048: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700427};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700427, n, 0);
                    }
                };
            }
            case 700049: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{360, 363, 367};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700049(n);
                    }
                };
            }
            case 700084: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700084(n);
                    }
                };
            }
            case 700228: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700453};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700453, n, 0);
                    }
                };
            }
            case 700229: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700454};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700454, n, 0);
                    }
                };
            }
            case 700230: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700455};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700455, n, 0);
                    }
                };
            }
            case 700231: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700461};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700461, n, 0);
                    }
                };
            }
            case 700232: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700474};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700474, n, 0);
                    }
                };
            }
            case 700233: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700475};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700475, n, 0);
                    }
                };
            }
            case 700234: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700476};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700476, n, 0);
                    }
                };
            }
            case 700235: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700236: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700485};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700485, n, 0);
                    }
                };
            }
            case 700237: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700451};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700237(n);
                    }
                };
            }
            case 700238: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700451};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700238(n);
                    }
                };
            }
            case 700239: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700463, 700473};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700239(n);
                    }
                };
            }
            case 700240: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700463};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700240(n);
                    }
                };
            }
            case 700303: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 523};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700303(n);
                    }
                };
            }
            case 700304: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{335, 523};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700304(n);
                    }
                };
            }
            case 700371: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700521};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700521, n, 0);
                    }
                };
            }
            case 700372: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700522};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleAbstractModelStatusEqualsCondition(700522, n, 0);
                    }
                };
            }
            case 700373: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700373(n);
                    }
                };
            }
            case 700375: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 700592};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700375(n);
                    }
                };
            }
            case 700376: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3853, 5583, 5588, 700489};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700376(n);
                    }
                };
            }
            case 700445: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523, 700592};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700445(n);
                    }
                };
            }
            case 700516: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 335};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700516(n);
                    }
                };
            }
            case 700517: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700441};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700517(n);
                    }
                };
            }
            case 700558: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700477};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700477, n, 1);
                    }
                };
            }
            case 700560: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700427};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700427, n, 0);
                    }
                };
            }
            case 700561: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700562: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700567: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700427};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700427, n, 0);
                    }
                };
            }
            case 700638: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700638(n);
                    }
                };
            }
            case 700643: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700643(n);
                    }
                };
            }
            case 700677: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588, 700451};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700677(n);
                    }
                };
            }
            case 700679: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700592, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700679(n);
                    }
                };
            }
            case 700713: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700713(n);
                    }
                };
            }
            case 700714: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700714(n);
                    }
                };
            }
            case 700715: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700715(n);
                    }
                };
            }
            case 700716: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 335};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700716(n);
                    }
                };
            }
            case 700717: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 523, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700717(n);
                    }
                };
            }
            case 700718: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700719: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700720: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700721: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700722: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700723: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700724: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700725: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700726: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 1);
                    }
                };
            }
            case 700727: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700470};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700470, n, 0);
                    }
                };
            }
            case 700857: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700525, 700526, 700527};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond700857(n);
                    }
                };
            }
            case 701008: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701008(n);
                    }
                };
            }
            case 701009: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701009(n);
                    }
                };
            }
            case 701010: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701010(n);
                    }
                };
            }
            case 701035: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701035(n);
                    }
                };
            }
            case 701036: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701036(n);
                    }
                };
            }
            case 701037: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{523};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701037(n);
                    }
                };
            }
            case 701074: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700452, n, 0);
                    }
                };
            }
            case 701075: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(700452, n, 0);
                    }
                };
            }
            case 701076: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700452, n, 0);
                    }
                };
            }
            case 701077: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(700452, n, 0);
                    }
                };
            }
            case 701078: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(700452, n, 0);
                    }
                };
            }
            case 701079: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700452};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(700452, n, 0);
                    }
                };
            }
            case 701152: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701152(n);
                    }
                };
            }
            case 701153: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701153(n);
                    }
                };
            }
            case 701154: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701154(n);
                    }
                };
            }
            case 701197: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueGreaterCondition(310, n, 0);
                    }
                };
            }
            case 701198: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 523, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701198(n);
                    }
                };
            }
            case 701199: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701199(n);
                    }
                };
            }
            case 701200: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701200(n);
                    }
                };
            }
            case 701201: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{310, 442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701201(n);
                    }
                };
            }
            case 701202: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701202(n);
                    }
                };
            }
            case 701203: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701203(n);
                    }
                };
            }
            case 701204: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701204(n);
                    }
                };
            }
            case 701205: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700441};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701205(n);
                    }
                };
            }
            case 701207: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700525, 700526, 700527};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701207(n);
                    }
                };
            }
            case 701209: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701209(n);
                    }
                };
            }
            case 701210: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 701211: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701211(n);
                    }
                };
            }
            case 701212: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 700560};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701212(n);
                    }
                };
            }
            case 701213: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{400441};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(400441, n, 1);
                    }
                };
            }
            case 701256: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(17, n, 0);
                    }
                };
            }
            case 701257: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(17, n, 1);
                    }
                };
            }
            case 701258: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{17};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(17, n, 2);
                    }
                };
            }
            case 701301: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 523, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701301(n);
                    }
                };
            }
            case 701358: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{14, 523, 700519, 700592, 700594, 700595};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701358(n);
                    }
                };
            }
            case 701434: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{186, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701434(n);
                    }
                };
            }
            case 701435: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701435(n);
                    }
                };
            }
            case 701436: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701436(n);
                    }
                };
            }
            case 701437: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701437(n);
                    }
                };
            }
            case 701438: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701438(n);
                    }
                };
            }
            case 701439: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 4091};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701439(n);
                    }
                };
            }
            case 701440: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 300699};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701440(n);
                    }
                };
            }
            case 701441: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{177, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701441(n);
                    }
                };
            }
            case 701442: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 401360};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701442(n);
                    }
                };
            }
            case 701443: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{155, 442, 523, 3939, 4646};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701443(n);
                    }
                };
            }
            case 701444: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{154, 442, 523, 3939, 4649};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701444(n);
                    }
                };
            }
            case 701446: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701446(n);
                    }
                };
            }
            case 701447: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701447(n);
                    }
                };
            }
            case 701448: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701448(n);
                    }
                };
            }
            case 701449: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{522};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701449(n);
                    }
                };
            }
            case 701450: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 5624, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701450(n);
                    }
                };
            }
            case 701451: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 701452: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701452(n);
                    }
                };
            }
            case 701453: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701453(n);
                    }
                };
            }
            case 701454: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701454(n);
                    }
                };
            }
            case 701455: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701455(n);
                    }
                };
            }
            case 701456: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701456(n);
                    }
                };
            }
            case 701457: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701457(n);
                    }
                };
            }
            case 701458: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701458(n);
                    }
                };
            }
            case 701459: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701459(n);
                    }
                };
            }
            case 701460: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 5624, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701460(n);
                    }
                };
            }
            case 701461: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{93};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookConditionBank.this.screenFactory.evaluateSimpleChoiceModelValueEqualsCondition(93, n, 1);
                    }
                };
            }
            case 701462: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701462(n);
                    }
                };
            }
            case 701463: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701463(n);
                    }
                };
            }
            case 701464: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701464(n);
                    }
                };
            }
            case 701465: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701465(n);
                    }
                };
            }
            case 701466: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701466(n);
                    }
                };
            }
            case 701467: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701467(n);
                    }
                };
            }
            case 701468: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701468(n);
                    }
                };
            }
            case 701469: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701469(n);
                    }
                };
            }
            case 701470: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{442, 3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701470(n);
                    }
                };
            }
            case 701471: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{556, 4078, 5583, 5605, 700508, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701471(n);
                    }
                };
            }
            case 701472: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701472(n);
                    }
                };
            }
            case 701473: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701473(n);
                    }
                };
            }
            case 701477: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 1000019};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701477(n);
                    }
                };
            }
            case 701499: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588, 5593};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701499(n);
                    }
                };
            }
            case 701500: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588, 5593};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701500(n);
                    }
                };
            }
            case 701501: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588, 5593};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701501(n);
                    }
                };
            }
            case 701502: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588, 5593};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701502(n);
                    }
                };
            }
            case 701503: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701503(n);
                    }
                };
            }
            case 701504: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701504(n);
                    }
                };
            }
            case 701505: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701505(n);
                    }
                };
            }
            case 701506: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701506(n);
                    }
                };
            }
            case 701507: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701507(n);
                    }
                };
            }
            case 701508: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701508(n);
                    }
                };
            }
            case 701509: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701509(n);
                    }
                };
            }
            case 701510: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701510(n);
                    }
                };
            }
            case 701511: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{3939, 5583, 5588};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701511(n);
                    }
                };
            }
            case 701514: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 5624, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701514(n);
                    }
                };
            }
            case 701515: {
                return new AbstractCondition(){

                    public int[] getModelIds() {
                        return new int[]{162, 556, 4078, 5624, 400490, 700539};
                    }

                    public boolean evaluate(int n) {
                        return AddressBookScreenFactory.evalCond701515(n);
                    }
                };
            }
        }
        return null;
    }
}

