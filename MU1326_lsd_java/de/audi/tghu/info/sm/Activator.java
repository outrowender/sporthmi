/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.info.sm.InfoSMM;
import de.audi.tghu.info.sm.InfoSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new InfoSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new InfoSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new InfoSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new InfoSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new InfoSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = InfoSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

