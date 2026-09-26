/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.car.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.car.sm.CarSMM;
import de.audi.tghu.car.sm.CarSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new CarSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new CarSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new CarSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new CarSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new CarSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = CarSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

