/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.system.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.atip.statemachine.JointUseDummySMM;
import de.audi.tghu.system.sm.JointUseSystemSMM;
import de.audi.tghu.system.sm.SystemSMM;
import de.audi.tghu.system.sm.SystemSMMActions;

public class Activator
extends AbstractSMMActivator {
    public void init() {
        this.smmList = new SystemSMM[9];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new SystemSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new SystemSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new SystemSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new SystemSMM(this.framework, 4, "rearSeatRight");
            if (!Boolean.getBoolean("disableJointMode")) {
                this.smmList[5] = new JointUseSystemSMM(this.framework);
                this.smmList[8] = new JointUseDummySMM(this.framework, 5, "rearSeatJoint", 23, "NotNaviSMM", "DummyTLS");
            }
        }
        this.reqActionProxies = SystemSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

