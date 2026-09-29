/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.PhoneModelBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneConditionBank;
import de.audi.tghu.phone.hmi.evohighscale.PhoneScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private PhoneScreenFactory instance = null;
    private PhoneConditionBank conditionBank;

    public Activator() {
        super(3, "Phone", System.getProperty("variant.skin", "EvoHighScale"), new PhoneModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new PhoneScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new PhoneConditionBank((PhoneScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

