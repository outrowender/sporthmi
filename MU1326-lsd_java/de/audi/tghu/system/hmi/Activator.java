/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.SystemModelBank;
import de.audi.tghu.system.hmi.evohighscale.SystemConditionBank;
import de.audi.tghu.system.hmi.evohighscale.SystemScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private SystemScreenFactory instance = null;
    private SystemConditionBank conditionBank;

    public Activator() {
        super(0, "System", System.getProperty("variant.skin", "EvoHighScale"), new SystemModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new SystemScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new SystemConditionBank((SystemScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

