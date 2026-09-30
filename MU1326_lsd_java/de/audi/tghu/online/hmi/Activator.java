/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.OnlineModelBank;
import de.audi.tghu.online.hmi.evohighscale.OnlineConditionBank;
import de.audi.tghu.online.hmi.evohighscale.OnlineScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private OnlineScreenFactory instance = null;
    private OnlineConditionBank conditionBank;

    public Activator() {
        super(23, "Online", System.getProperty("variant.skin", "EvoHighScale"), new OnlineModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new OnlineScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new OnlineConditionBank((OnlineScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

