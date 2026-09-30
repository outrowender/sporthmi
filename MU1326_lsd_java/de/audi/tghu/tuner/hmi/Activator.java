/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.TunerModelBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerConditionBank;
import de.audi.tghu.tuner.hmi.evohighscale.TunerScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private TunerScreenFactory instance = null;
    private TunerConditionBank conditionBank;

    public Activator() {
        super(1, "Tuner", System.getProperty("variant.skin", "EvoHighScale"), new TunerModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new TunerScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new TunerConditionBank((TunerScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

