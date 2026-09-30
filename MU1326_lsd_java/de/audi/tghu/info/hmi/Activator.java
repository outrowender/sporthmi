/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.InfoModelBank;
import de.audi.tghu.info.hmi.evohighscale.InfoConditionBank;
import de.audi.tghu.info.hmi.evohighscale.InfoScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private InfoScreenFactory instance = null;
    private InfoConditionBank conditionBank;

    public Activator() {
        super(5, "Info", System.getProperty("variant.skin", "EvoHighScale"), new InfoModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new InfoScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new InfoConditionBank((InfoScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

