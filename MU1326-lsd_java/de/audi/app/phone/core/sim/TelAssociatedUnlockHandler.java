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
        super(iTelApplication, "TelAssociatedUnlockHandler", -1617492992, -1550384128, -1483275264, -1432943616, -1734933504, -1600715776, -1281948672, -1332280320, -1583938560, -1533606912, -1500052480, -1449720832, -1365834752, -1315503104, -1265171456, -1516829696, -1013513216);
    }

    @Override
    protected boolean processLockStateUpdate(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return (n == 0xF000200 || n == 0x3000200) && this.lockHandlingRequired();
    }

    protected boolean lockHandlingRequired() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        int n = iGlobalTelephoneStateStruct != null && iGlobalTelephoneStateStruct.getActivationStateAssociated() != null ? iGlobalTelephoneStateStruct.getActivationStateAssociated().getTelActivationState() : 0;
        return n == 5;
    }

    @Override
    protected boolean getAutomaticPinEntryActiveSetting() {
        IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct = this.getTelephoneState();
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.isAutomaticPinEntryActiveAssoicated() : false;
    }

    @Override
    protected LockStateStruct getLockStateStruct(IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        return iGlobalTelephoneStateStruct != null ? iGlobalTelephoneStateStruct.getLockStateAssociated() : null;
    }
}

