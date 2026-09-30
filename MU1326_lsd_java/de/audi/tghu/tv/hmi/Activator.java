/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.TVModelBank;
import de.audi.tghu.tv.hmi.evohighscale.TVConditionBank;
import de.audi.tghu.tv.hmi.evohighscale.TVScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private TVScreenFactory instance = null;
    private TVConditionBank conditionBank;

    public Activator() {
        super(26, "TV", System.getProperty("variant.skin", "EvoHighScale"), new TVModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new TVScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new TVConditionBank((TVScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

