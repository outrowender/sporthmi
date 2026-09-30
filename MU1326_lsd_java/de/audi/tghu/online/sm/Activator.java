/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.online.sm.OnlineSMM;
import de.audi.tghu.online.sm.OnlineSMMActions;

public class Activator
extends AbstractSMMActivator {
    public void init() {
        this.smmList = new OnlineSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new OnlineSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new OnlineSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new OnlineSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new OnlineSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = OnlineSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

