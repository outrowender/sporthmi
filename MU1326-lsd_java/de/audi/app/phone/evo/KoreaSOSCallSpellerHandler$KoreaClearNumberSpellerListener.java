/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.KoreaSOSCallSpellerHandler;
import java.util.Map;

class KoreaSOSCallSpellerHandler$KoreaClearNumberSpellerListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ KoreaSOSCallSpellerHandler this$0;

    public KoreaSOSCallSpellerHandler$KoreaClearNumberSpellerListener(KoreaSOSCallSpellerHandler koreaSOSCallSpellerHandler, ITelApplication iTelApplication) {
        this.this$0 = koreaSOSCallSpellerHandler;
        super(iTelApplication, "App.Phone.Main", 33);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.this$0.clearSpellerContent();
    }
}

