/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.statemachine.AbstractSMM;
import de.audi.atip.statemachine.ApplicationSMM;
import de.audi.atip.statemachine.SMServices;

public abstract class AbstractAppSMM
extends AbstractSMM
implements ApplicationSMM {
    public AbstractAppSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, String string2) {
        super(iFrameworkAccess, n, string, 0, n2, string2);
    }

    public AbstractAppSMM(IFrameworkAccess iFrameworkAccess, int n, String string, int n2, int n3, String string2) {
        super(iFrameworkAccess, n, string, n2, n3, string2);
    }

    protected abstract void init();

    public void setTopLevelSuperstate(int n) {
        int n2 = this.id2ArrayIdx(this.topLevelStateID);
        this.stateSuperstateList[n2] = n;
        this.logChannel.log(1000000, "[AbstractAppSMM#setTopLevelSuperstate] [%1] top-level superstate set to (STATEID#%1).", (Object)this.terminalName, (long)n);
    }

    public void execEnterAction(SMServices sMServices, int n) {
        this.execEnterAction(n);
    }

    public void execExitAction(SMServices sMServices, int n) {
        this.execExitAction(n);
    }

    public void execTransitionAction(SMServices sMServices, int n, int n2) {
        this.execTransitionAction(n, n2);
    }

    public void execEnterAction(int n) {
    }

    public void execExitAction(int n) {
    }

    public void execTransitionAction(int n, int n2) {
    }
}

