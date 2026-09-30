/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.SettingsModelBank;
import de.audi.tghu.settings.hmi.evohighscale.SettingsConditionBank;
import de.audi.tghu.settings.hmi.evohighscale.SettingsScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private SettingsScreenFactory instance = null;
    private SettingsConditionBank conditionBank;

    public Activator() {
        super(11, "Settings", System.getProperty("variant.skin", "EvoHighScale"), new SettingsModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new SettingsScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new SettingsConditionBank((SettingsScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

