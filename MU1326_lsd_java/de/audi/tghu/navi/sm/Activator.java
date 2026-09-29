/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.atip.statemachine.JointUseDummySMM;
import de.audi.tghu.navi.sm.NaviSMM;
import de.audi.tghu.navi.sm.NaviSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new NaviSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new NaviSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new NaviSMM(this.framework, 2, "frontPassenger");
            }
        } else if (!Boolean.getBoolean("disableJointMode")) {
            this.smmList[3] = new JointUseDummySMM(this.framework, 3, "rearSeatLeft", 4, "DummyLeft", "NavigationTLS");
            this.smmList[4] = new JointUseDummySMM(this.framework, 4, "rearSeatRight", 4, "DummyRight", "NavigationTLS");
            this.smmList[5] = new NaviSMM(this.framework, 5, "rearSeatJoint");
        } else {
            this.smmList[3] = new NaviSMM(this.framework, 3, "rearSeatLeft");
        }
        this.reqActionProxies = NaviSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

