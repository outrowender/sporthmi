/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.tv.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.tv.sm.TVSMM;
import de.audi.tghu.tv.sm.TVSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new TVSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new TVSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new TVSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new TVSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new TVSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = TVSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

