/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.CarModelBank;
import de.audi.tghu.car.hmi.evohighscale.CarConditionBank;
import de.audi.tghu.car.hmi.evohighscale.CarScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private CarScreenFactory instance = null;
    private CarConditionBank conditionBank;

    public Activator() {
        super(6, "Car", System.getProperty("variant.skin", "EvoHighScale"), new CarModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new CarScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new CarConditionBank((CarScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

