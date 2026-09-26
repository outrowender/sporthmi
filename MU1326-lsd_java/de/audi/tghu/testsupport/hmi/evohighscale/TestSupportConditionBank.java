/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.testsupport.hmi.evohighscale.TestSupportScreenFactory;

public class TestSupportConditionBank
implements HMIConditionBank {
    private TestSupportScreenFactory screenFactory;

    public TestSupportConditionBank(TestSupportScreenFactory testSupportScreenFactory) {
        this.screenFactory = testSupportScreenFactory;
    }

    @Override
    public AbstractCondition getCondition(int n) {
        switch (n) {
            default: 
        }
        return null;
    }
}

