/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import java.util.List;
import java.util.Map;

class TelConnectivityHandlerEvo$TelLeftListener
extends AbstractTelActionProxyListener {
    private final /* synthetic */ TelConnectivityHandlerEvo this$0;

    public TelConnectivityHandlerEvo$TelLeftListener(TelConnectivityHandlerEvo telConnectivityHandlerEvo, ITelApplication iTelApplication) {
        this.this$0 = telConnectivityHandlerEvo;
        super(iTelApplication, "App.Phone.Main", 8);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    protected void actionProxyCalled(Map map) {
        List list = null;
        Object object = TelConnectivityHandlerEvo.access$200(this.this$0);
        synchronized (object) {
            list = (List)TelConnectivityHandlerEvo.access$300(this.this$0).clone();
        }
        if (list != null) {
            object = list.iterator();
            while (object.hasNext()) {
                IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)object.next();
                if (iConnectivityPhoneStateListener == null) continue;
                iConnectivityPhoneStateListener.telAppLeft();
            }
        }
    }
}

