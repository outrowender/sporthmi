/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.MediaModelBank;
import de.audi.tghu.media.hmi.evohighscale.MediaConditionBank;
import de.audi.tghu.media.hmi.evohighscale.MediaScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private MediaScreenFactory instance = null;
    private MediaConditionBank conditionBank;

    public Activator() {
        super(2, "Media", System.getProperty("variant.skin", "EvoHighScale"), new MediaModelBank());
    }

    @Override
    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new MediaScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    @Override
    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new MediaConditionBank((MediaScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

