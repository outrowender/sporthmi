/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.connectivity.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.ConnectivityModelBank;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityConditionBank;
import de.audi.tghu.connectivity.hmi.evohighscale.ConnectivityScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private ConnectivityScreenFactory instance = null;
    private ConnectivityConditionBank conditionBank;

    public Activator() {
        super(25, "Connectivity", System.getProperty("variant.skin", "EvoHighScale"), new ConnectivityModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new ConnectivityScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new ConnectivityConditionBank((ConnectivityScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

