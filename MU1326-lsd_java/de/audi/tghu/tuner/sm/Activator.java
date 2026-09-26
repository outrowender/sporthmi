/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tuner.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.tuner.sm.TunerSMM;
import de.audi.tghu.tuner.sm.TunerSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new TunerSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new TunerSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new TunerSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new TunerSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new TunerSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = TunerSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

