/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.callcontrol;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.callcontrol.TelEvoMFLKeyHandler;
import java.util.Map;

class TelEvoMFLKeyHandler$TelEnteredListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelEvoMFLKeyHandler this$0;

    public TelEvoMFLKeyHandler$TelEnteredListener(TelEvoMFLKeyHandler telEvoMFLKeyHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoMFLKeyHandler;
        super(iTelApplication, "App.Phone.Main", 15);
    }

    @Override
    protected void actionProxyCalled(Map map) {
        this.getApplication().getFrameworkAccess().getHmiServiceApp().removePopup(-208468992);
    }
}

