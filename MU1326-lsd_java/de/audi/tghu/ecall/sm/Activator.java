/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.ecall.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.ecall.sm.EcallSMM;
import de.audi.tghu.ecall.sm.EcallSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new EcallSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new EcallSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new EcallSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new EcallSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new EcallSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = EcallSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

