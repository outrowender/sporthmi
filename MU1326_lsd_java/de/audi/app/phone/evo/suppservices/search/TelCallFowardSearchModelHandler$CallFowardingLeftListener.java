/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.suppservices.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.suppservices.search.TelCallFowardSearchModelHandler;
import java.util.Map;

class TelCallFowardSearchModelHandler$CallFowardingLeftListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelCallFowardSearchModelHandler this$0;

    public TelCallFowardSearchModelHandler$CallFowardingLeftListener(TelCallFowardSearchModelHandler telCallFowardSearchModelHandler, ITelApplication iTelApplication) {
        this.this$0 = telCallFowardSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", 16);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        TelCallFowardSearchModelHandler.access$000(this.this$0);
    }
}

