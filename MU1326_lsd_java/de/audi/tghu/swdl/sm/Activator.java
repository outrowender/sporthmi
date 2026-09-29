/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.atip.statemachine.JointUseDummySMM;
import de.audi.tghu.swdl.sm.SWDLSMM;
import de.audi.tghu.swdl.sm.SWDLSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new SWDLSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new SWDLSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new SWDLSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[5] = new SWDLSMM(this.framework, 5, "rearSeatJoint");
            this.smmList[3] = new JointUseDummySMM(this.framework, 3, "rearSeatLeft", 17, "SWDLSMM", "SwdlTLS");
            this.smmList[4] = new JointUseDummySMM(this.framework, 4, "rearSeatRight", 17, "SWDLSMM", "SwdlTLS");
        }
        this.reqActionProxies = SWDLSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

