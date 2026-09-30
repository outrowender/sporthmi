/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tone.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.ToneModelBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneConditionBank;
import de.audi.tghu.tone.hmi.evohighscale.ToneScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private ToneScreenFactory instance = null;
    private ToneConditionBank conditionBank;

    public Activator() {
        super(10, "Tone", System.getProperty("variant.skin", "EvoHighScale"), new ToneModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new ToneScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new ToneConditionBank((ToneScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

