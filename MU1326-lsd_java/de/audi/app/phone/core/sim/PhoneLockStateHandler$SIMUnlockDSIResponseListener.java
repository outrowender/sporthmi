/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.sim;

import de.audi.app.phone.core.dsi.ITelDSIResponseListener;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.sim.PhoneLockStateHandler;
import org.dsi.ifc.telephoneng.LockStateStruct;

class PhoneLockStateHandler$SIMUnlockDSIResponseListener
extends TelDefaultDSIResponseListener {
    private final ITelDSIResponseListener responseListener;
    private final /* synthetic */ PhoneLockStateHandler this$0;

    public PhoneLockStateHandler$SIMUnlockDSIResponseListener(PhoneLockStateHandler phoneLockStateHandler, ITelDSIResponseListener iTelDSIResponseListener) {
        this.this$0 = phoneLockStateHandler;
        this.responseListener = iTelDSIResponseListener;
    }

    @Override
    public void responseUnlockSIM(int n, int n2, LockStateStruct lockStateStruct) {
        PhoneLockStateHandler.access$000(this.this$0, n, n2, lockStateStruct);
        if (this.responseListener != null) {
            this.responseListener.responseUnlockSIM(n, n2, lockStateStruct);
        }
    }
}

