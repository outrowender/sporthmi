/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.hmi.evohighscale;

import de.audi.atip.hmi.HMIConditionBank;
import de.audi.atip.hmi.model.AbstractCondition;
import de.audi.tghu.wirelesscharging.hmi.evohighscale.WirelessChargingScreenFactory;

public class WirelessChargingConditionBank
implements HMIConditionBank {
    private WirelessChargingScreenFactory screenFactory;

    public WirelessChargingConditionBank(WirelessChargingScreenFactory wirelessChargingScreenFactory) {
        this.screenFactory = wirelessChargingScreenFactory;
    }

    public AbstractCondition getCondition(int n) {
        switch (n) {
            default: 
        }
        return null;
    }
}

