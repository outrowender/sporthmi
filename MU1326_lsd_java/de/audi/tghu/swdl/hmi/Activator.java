/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.SWDLModelBank;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLConditionBank;
import de.audi.tghu.swdl.hmi.evohighscale.SWDLScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private SWDLScreenFactory instance = null;
    private SWDLConditionBank conditionBank;

    public Activator() {
        super(17, "SWDL", System.getProperty("variant.skin", "EvoHighScale"), new SWDLModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new SWDLScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new SWDLConditionBank((SWDLScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

