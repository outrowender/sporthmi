/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.intellicall;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.intellicall.TelStdIntellicalSearchModelHanlder;
import java.util.Map;

class TelStdIntellicalSearchModelHanlder$ResetSearchResultListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelStdIntellicalSearchModelHanlder this$0;

    public TelStdIntellicalSearchModelHanlder$ResetSearchResultListener(TelStdIntellicalSearchModelHanlder telStdIntellicalSearchModelHanlder, ITelApplication iTelApplication) {
        this.this$0 = telStdIntellicalSearchModelHanlder;
        super(iTelApplication, "App.Phone.Search", 21);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.log.log(-2137614336, "TelStdIntellicalSearchModelHanlder.ResetSearchResultListener#actionProxyCalled(): called");
        this.this$0.clearSearchSpeller();
    }
}

