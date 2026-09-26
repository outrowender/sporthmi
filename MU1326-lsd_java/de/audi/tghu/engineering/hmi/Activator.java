/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.EngineeringModelBank;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringConditionBank;
import de.audi.tghu.engineering.hmi.evohighscale.EngineeringScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private EngineeringScreenFactory instance = null;
    private EngineeringConditionBank conditionBank;

    public Activator() {
        super(13, "Engineering", System.getProperty("variant.skin", "EvoHighScale"), new EngineeringModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new EngineeringScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new EngineeringConditionBank((EngineeringScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

