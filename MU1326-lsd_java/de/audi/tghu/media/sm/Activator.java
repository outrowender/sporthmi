/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.media.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.media.sm.MediaSMM;
import de.audi.tghu.media.sm.MediaSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new MediaSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new MediaSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new MediaSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new MediaSMM(this.framework, 3, "rearSeatLeft");
            if ("enabled".equalsIgnoreCase(System.getProperty("media.mui.rightterminal", "enabled"))) {
                this.smmList[4] = new MediaSMM(this.framework, 4, "rearSeatRight");
            }
        }
        this.reqActionProxies = MediaSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

