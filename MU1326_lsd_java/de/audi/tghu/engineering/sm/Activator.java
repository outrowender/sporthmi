/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.engineering.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.atip.statemachine.JointUseDummySMM;
import de.audi.tghu.engineering.sm.EngineeringSMM;
import de.audi.tghu.engineering.sm.EngineeringSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new EngineeringSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new EngineeringSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new EngineeringSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[5] = new EngineeringSMM(this.framework, 5, "rearSeatJoint");
            this.smmList[3] = new JointUseDummySMM(this.framework, 3, "rearSeatLeft", 17, "EngineeringSMM", "EngineeringTLS");
            this.smmList[4] = new JointUseDummySMM(this.framework, 4, "rearSeatRight", 17, "EngineeringSMM", "EngineeringTLS");
        }
        this.reqActionProxies = EngineeringSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

