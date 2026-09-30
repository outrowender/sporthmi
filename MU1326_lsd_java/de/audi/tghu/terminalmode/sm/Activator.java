/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.terminalmode.sm;

import de.audi.atip.activator.AbstractSMMActivator;
import de.audi.tghu.terminalmode.sm.TerminalModeSMM;
import de.audi.tghu.terminalmode.sm.TerminalModeSMMActions;

public class Activator
extends AbstractSMMActivator {
    public void init() {
        this.smmList = new TerminalModeSMM[8];
        if (this.framework.isFrontMU()) {
            this.smmList[0] = new TerminalModeSMM(this.framework, 0, "main");
            if (this.framework.isDualView()) {
                this.smmList[2] = new TerminalModeSMM(this.framework, 2, "frontPassenger");
            }
        } else {
            this.smmList[3] = new TerminalModeSMM(this.framework, 3, "rearSeatLeft");
            this.smmList[4] = new TerminalModeSMM(this.framework, 4, "rearSeatRight");
        }
        this.reqActionProxies = TerminalModeSMMActions.REQUIRED_ACTION_PROXY_MODULE_IDS;
    }
}

