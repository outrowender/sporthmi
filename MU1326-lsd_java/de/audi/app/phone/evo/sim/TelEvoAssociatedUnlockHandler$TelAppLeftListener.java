/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.sim;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.sim.TelEvoAssociatedUnlockHandler;
import java.util.Map;

class TelEvoAssociatedUnlockHandler$TelAppLeftListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoAssociatedUnlockHandler this$0;

    public TelEvoAssociatedUnlockHandler$TelAppLeftListener(TelEvoAssociatedUnlockHandler telEvoAssociatedUnlockHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoAssociatedUnlockHandler;
        super(iTelApplication, "App.Phone.LockState", 8);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.log.log(1078071040, "[TelEvoAssociatedUnlockHandler.TelAppLeftListener#actionProxyCalled]");
        TelEvoAssociatedUnlockHandler.access$002(this.this$0, false);
    }
}

