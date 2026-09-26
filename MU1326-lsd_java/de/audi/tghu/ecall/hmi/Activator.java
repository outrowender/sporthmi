/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.EcallModelBank;
import de.audi.tghu.ecall.hmi.evohighscale.EcallConditionBank;
import de.audi.tghu.ecall.hmi.evohighscale.EcallScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private EcallScreenFactory instance = null;
    private EcallConditionBank conditionBank;

    public Activator() {
        super(33, "Ecall", System.getProperty("variant.skin", "EvoHighScale"), new EcallModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new EcallScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new EcallConditionBank((EcallScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

