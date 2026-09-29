/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.settings.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.settings.sm.SettingsSMM;
import de.audi.tghu.settings.sm.SettingsSMMActions;

public class Activator
extends AbstractSMMActivator {
    @Override
    public void init() {
        this.smmList = new SettingsSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new SettingsSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new SettingsSMM(this.framework, 2, "frontPassenger");
            }
        }
        this.reqActionProxies = SettingsSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

