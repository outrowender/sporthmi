/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.PhoneNumberSpellerHandler;
import java.util.Map;

class PhoneNumberSpellerHandler$ClearNumberSpellerListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ PhoneNumberSpellerHandler this$0;

    public PhoneNumberSpellerHandler$ClearNumberSpellerListener(PhoneNumberSpellerHandler phoneNumberSpellerHandler, ITelApplication iTelApplication) {
        this.this$0 = phoneNumberSpellerHandler;
        super(iTelApplication, "App.Phone.Main", 33);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.this$0.clearSpellerContent();
    }
}

