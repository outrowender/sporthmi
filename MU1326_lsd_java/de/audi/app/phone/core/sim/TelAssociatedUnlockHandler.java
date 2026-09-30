/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.sim.AbstractTelUnlockPresentationHandler;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import org.dsi.ifc.telephoneng.LockStateStruct;

public class TelAssociatedUnlockHandler
extends AbstractTelUnlockPresentationHandler {
    public TelAssociatedUnlockHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "TelAssociatedUnlockHandler", 300959, 300963, 300967, 300970, 300952, 300960, 300979, 300976, 300961, 300964, 300966, 300969, 300974, 300977, 300980, 300965, 300995);
    }

    protected boolean processLockStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return (n == 131087 || n == 131075) && this.lockHandlingRequired();
    }

    protected boolean lockHandlingRequired() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        int n = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationStateAssociated() != null ? iGlobalTelephoneStateStruct.getActivationStateAssociated().getTelActivationState() : 0;
        return n == 5;
    }

    protected boolean getAutomaticPinEntryActiveSetting() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isAutomaticPinEntryActiveAssoicated() : false;
    }

    protected LockStateStruct getLockStateStruct(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getLockStateAssociated() : null;
    }
}

