/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.NaviModelBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviConditionBank;
import de.audi.tghu.navi.hmi.evohighscale.NaviScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private NaviScreenFactory instance = null;
    private NaviConditionBank conditionBank;

    public Activator() {
        super(4, "Navi", System.getProperty("variant.skin", "EvoHighScale"), new NaviModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new NaviScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new NaviConditionBank((NaviScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

