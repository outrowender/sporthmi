/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.phone.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.phone.sm.PhoneSMM;
import de.audi.tghu.phone.sm.PhoneSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new PhoneSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new PhoneSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new PhoneSMM(this.framework, 2, "frontPassenger");
            }
        }
        this.reqActionProxies = PhoneSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

