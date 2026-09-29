/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.wirelesscharging.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMM;
import de.audi.tghu.wirelesscharging.sm.WirelessChargingSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new WirelessChargingSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new WirelessChargingSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new WirelessChargingSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new WirelessChargingSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new WirelessChargingSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = WirelessChargingSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

