/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall.search;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.intellicall.search.IntellicallSearchModelHandler;
import java.util.Map;

class IntellicallSearchModelHandler$ResetSearchResultListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ IntellicallSearchModelHandler this$0;

    public IntellicallSearchModelHandler$ResetSearchResultListener(IntellicallSearchModelHandler intellicallSearchModelHandler, ITelApplication iTelApplication) {
        this.this$0 = intellicallSearchModelHandler;
        super(iTelApplication, "App.Phone.Search", 21);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.this$0.clearSearchSpeller();
        IntellicallSearchModelHandler.access$000(this.this$0).cancelActiveSearchQuery();
    }
}

