/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.hmi;

import de.audi.atip.activator.AbstractHMIActivator;
import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.view.AbstractScreenFactory;
import de.audi.atip.model.WirelessChargingModelBank;
import de.audi.tghu.wirelesscharging.hmi.evohighscale.WirelessChargingConditionBank;
import de.audi.tghu.wirelesscharging.hmi.evohighscale.WirelessChargingScreenFactory;

public class Activator
extends AbstractHMIActivator {
    private WirelessChargingScreenFactory instance = null;
    private WirelessChargingConditionBank conditionBank;

    public Activator() {
        super(34, "WirelessCharging", System.getProperty("variant.skin", "EvoHighScale"), new WirelessChargingModelBank());
    }

    protected synchronized AbstractScreenFactory getScreenFactory() {
        if (this.instance == null) {
            this.instance = new WirelessChargingScreenFactory(this.getFramework());
        }
        return this.instance;
    }

    public HMIConditionBank getConditionBank() {
        if (this.conditionBank == null) {
            this.conditionBank = new WirelessChargingConditionBank((WirelessChargingScreenFactory)this.getScreenFactory());
        }
        return this.conditionBank;
    }
}

