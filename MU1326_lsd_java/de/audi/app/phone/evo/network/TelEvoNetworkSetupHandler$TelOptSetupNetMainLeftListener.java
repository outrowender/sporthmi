/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.network;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.network.TelEvoNetworkSetupHandler;
import java.util.Map;

class TelEvoNetworkSetupHandler$TelOptSetupNetMainLeftListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoNetworkSetupHandler this$0;

    public TelEvoNetworkSetupHandler$TelOptSetupNetMainLeftListener(TelEvoNetworkSetupHandler telEvoNetworkSetupHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoNetworkSetupHandler;
        super(iTelApplication, "App.Phone.Main", 35);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.log.log(1078071040, "[TelEvoNetworkSetupHandler.TelOptSetupNetMainLeftListener#actionProxyCalled]");
        TelEvoNetworkSetupHandler.access$000(this.this$0);
    }
}

