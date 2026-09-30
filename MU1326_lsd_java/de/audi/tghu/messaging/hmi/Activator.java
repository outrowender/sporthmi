/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.MessagingModelBank;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingConditionBank;
import de.audi.tghu.messaging.hmi.evohighscale.MessagingScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private MessagingScreenFactory instance = null;
    private MessagingConditionBank conditionBank;

    public Activator() {
        super(22, "Messaging", System.getProperty("variant.skin", "EvoHighScale"), new MessagingModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new MessagingScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new MessagingConditionBank((MessagingScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

