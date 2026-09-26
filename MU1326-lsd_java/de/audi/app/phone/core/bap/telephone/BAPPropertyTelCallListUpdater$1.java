/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap.telephone;

import de.audi.app.phone.core.bap.telephone.BAPPropertyTelCallListUpdater;
import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;

class BAPPropertyTelCallListUpdater$1
implements IGlobalTelephoneStateListener {
    private final /* synthetic */ BAPPropertyTelCallListUpdater this$0;

    BAPPropertyTelCallListUpdater$1(BAPPropertyTelCallListUpdater bAPPropertyTelCallListUpdater) {
        this.this$0 = bAPPropertyTelCallListUpdater;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        BAPPropertyTelCallListUpdater.access$100(this.this$0).getGlobalTelephoneStateManager().removeListener(this);
        BAPPropertyTelCallListUpdater.access$200(this.this$0).startService();
    }
}

