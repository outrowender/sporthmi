/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.favorite.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.favorite.search.TelFavoriteSearchModelHandler;
import java.util.Map;

class TelFavoriteSearchModelHandler$ResetFavoriteSearchListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelFavoriteSearchModelHandler this$0;

    public TelFavoriteSearchModelHandler$ResetFavoriteSearchListener(TelFavoriteSearchModelHandler telFavoriteSearchModelHandler, ITelApplication iTelApplication) {
        this.this$0 = telFavoriteSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", 25);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.this$0.clearSearchSpeller();
    }
}

