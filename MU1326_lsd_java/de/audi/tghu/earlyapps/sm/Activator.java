/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.earlyapps.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMM;
import de.audi.tghu.earlyapps.sm.EarlyAppsSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new EarlyAppsSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new EarlyAppsSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new EarlyAppsSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new EarlyAppsSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new EarlyAppsSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = EarlyAppsSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

