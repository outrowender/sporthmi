/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.testsupport.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.TestSupportModelBank;
import de.audi.tghu.testsupport.hmi.evohighscale.TestSupportConditionBank;
import de.audi.tghu.testsupport.hmi.evohighscale.TestSupportScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private TestSupportScreenFactory instance = null;
    private TestSupportConditionBank conditionBank;

    public Activator() {
        super(24, "TestSupport", System.getProperty("variant.skin", "EvoHighScale"), new TestSupportModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new TestSupportScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new TestSupportConditionBank((TestSupportScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

