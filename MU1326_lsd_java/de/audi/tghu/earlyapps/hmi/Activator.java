/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.EarlyAppsModelBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsConditionBank;
import de.audi.tghu.earlyapps.hmi.evohighscale.EarlyAppsScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private EarlyAppsScreenFactory instance = null;
    private EarlyAppsConditionBank conditionBank;

    public Activator() {
        super(21, "EarlyApps", System.getProperty("variant.skin", "EvoHighScale"), new EarlyAppsModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new EarlyAppsScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new EarlyAppsConditionBank((EarlyAppsScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

