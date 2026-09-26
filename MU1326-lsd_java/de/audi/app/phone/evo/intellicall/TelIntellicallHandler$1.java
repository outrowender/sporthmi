/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.state.IGlobalTelephoneStateListener;
import de.audi.app.phone.core.state.IGlobalTelephoneStateStruct;
import de.audi.app.phone.evo.intellicall.TelIntellicallHandler;

class TelIntellicallHandler$1
implements IGlobalTelephoneStateListener {
    private final /* synthetic */ TelIntellicallHandler this$0;

    TelIntellicallHandler$1(TelIntellicallHandler telIntellicallHandler) {
        this.this$0 = telIntellicallHandler;
    }

    @Override
    public void updateGlobalTelephoneStateProperty(int n, IGlobalTelephoneStateStruct iGlobalTelephoneStateStruct) {
        TelIntellicallHandler.access$400(this.this$0).getGlobalTelephoneStateManager().removeListener(this);
        TelIntellicallHandler.access$500(this.this$0).startService();
    }
}

