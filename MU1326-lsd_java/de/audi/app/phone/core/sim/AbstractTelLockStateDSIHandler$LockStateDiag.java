/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.sim.AbstractTelLockStateDSIHandler;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;

public class AbstractTelLockStateDSIHandler$LockStateDiag
implements IPhoneDiagComponent {
    private final /* synthetic */ AbstractTelLockStateDSIHandler this$0;

    public AbstractTelLockStateDSIHandler$LockStateDiag(AbstractTelLockStateDSIHandler abstractTelLockStateDSIHandler) {
        this.this$0 = abstractTelLockStateDSIHandler;
    }

    public void cmdUnlockSIMWithPIN(String string) {
        this.this$0.unlockSIMwithPIN(string, 0);
    }

    public void cmdUnlockSIMWithPUK(String string, String string2) {
        this.this$0.unlockSIMWithPUK(string, string2, 0);
    }
}

