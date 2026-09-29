/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler;
import java.util.Map;

class TelEvoAssociatedUnlockHandler$TelAppEnteredListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoAssociatedUnlockHandler this$0;

    public TelEvoAssociatedUnlockHandler$TelAppEnteredListener(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoAssociatedUnlockHandler;
        super(iTelApplication, "App.Phone.LockState", 7);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        TelEvoAssociatedUnlockHandler.access$002(this.this$0, true);
        if (TelEvoAssociatedUnlockHandler.access$100(this.this$0)) {
            this.log.log(1078071040, "[TelEvoAssociatedUnlockHandler.TelAppEnteredListener#actionProxyCalled] showing unlock popup");
            this.this$0.showUnlockPopup();
        }
    }
}

