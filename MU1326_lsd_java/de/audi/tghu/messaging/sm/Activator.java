/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.messaging.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.messaging.sm.MessagingSMM;
import de.audi.tghu.messaging.sm.MessagingSMMActions;

public class Activator
extends AbstractSMMActivator {
    public void init() {
        this.smmList = new MessagingSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new MessagingSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new MessagingSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new MessagingSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new MessagingSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = MessagingSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

