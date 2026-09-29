/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.ChinaSOSCallSpellerHandler;
import java.util.Map;

class ChinaSOSCallSpellerHandler$ChinaClearNumberSpellerListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ ChinaSOSCallSpellerHandler this$0;

    public ChinaSOSCallSpellerHandler$ChinaClearNumberSpellerListener(ChinaSOSCallSpellerHandler chinaSOSCallSpellerHandler, ITelApplication iTelApplication) {
        this.this$0 = chinaSOSCallSpellerHandler;
        super(iTelApplication, "App.Phone.Main", 33);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.this$0.clearSpellerContent();
    }
}

