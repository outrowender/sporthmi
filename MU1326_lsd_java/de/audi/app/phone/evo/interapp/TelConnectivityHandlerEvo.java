/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.ap.AbstractTelActionProxyListener;
import de.audi.app.phone.core.interapp.TelConnectivityHandler;
import de.audi.atip.interapp.IConnectivityPhoneStateListener;
import java.util.List;
import java.util.Map;

public class TelConnectivityHandlerEvo
extends TelConnectivityHandler {
    public TelConnectivityHandlerEvo(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.addSubPhoneComponent(new TelEnteredListener(iTelApplication));
        this.addSubPhoneComponent(new TelLeftListener(iTelApplication));
        this.addSubPhoneComponent(new TelUnlockEnteredListener(iTelApplication));
        this.addSubPhoneComponent(new TelUnlockLeftListener(iTelApplication));
    }

    private class TelLeftListener
    extends AbstractTelActionProxyListener {
        public TelLeftListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 8);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void actionProxyCalled(Map map) {
            List list = null;
            Object object = TelConnectivityHandlerEvo.this.connectivityListeners;
            synchronized (object) {
                list = (List)TelConnectivityHandlerEvo.this.connectivityListeners.clone();
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

    private class TelEnteredListener
    extends AbstractTelActionProxyListener {
        public TelEnteredListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 7);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void actionProxyCalled(Map map) {
            List list = null;
            Object object = TelConnectivityHandlerEvo.this.connectivityListeners;
            synchronized (object) {
                list = (List)TelConnectivityHandlerEvo.this.connectivityListeners.clone();
            }
            if (list != null) {
                object = list.iterator();
                while (object.hasNext()) {
                    IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)object.next();
                    if (iConnectivityPhoneStateListener == null) continue;
                    iConnectivityPhoneStateListener.telAppEntered();
                }
            }
        }
    }

    private class TelUnlockLeftListener
    extends AbstractTelActionProxyListener {
        public TelUnlockLeftListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 30);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void actionProxyCalled(Map map) {
            List list = null;
            Object object = TelConnectivityHandlerEvo.this.connectivityListeners;
            synchronized (object) {
                list = (List)TelConnectivityHandlerEvo.this.connectivityListeners.clone();
            }
            if (list != null) {
                object = list.iterator();
                while (object.hasNext()) {
                    IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)object.next();
                    if (iConnectivityPhoneStateListener == null) continue;
                    iConnectivityPhoneStateListener.telUnlockLeft();
                }
            }
        }
    }

    private class TelUnlockEnteredListener
    extends AbstractTelActionProxyListener {
        public TelUnlockEnteredListener(ITelApplication iTelApplication) {
            super(iTelApplication, "App.Phone.Main", 29);
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        protected void actionProxyCalled(Map map) {
            List list = null;
            Object object = TelConnectivityHandlerEvo.this.connectivityListeners;
            synchronized (object) {
                list = (List)TelConnectivityHandlerEvo.this.connectivityListeners.clone();
            }
            if (list != null) {
                object = list.iterator();
                while (object.hasNext()) {
                    IConnectivityPhoneStateListener iConnectivityPhoneStateListener = (IConnectivityPhoneStateListener)object.next();
                    if (iConnectivityPhoneStateListener == null) continue;
                    iConnectivityPhoneStateListener.telUnlockEntered();
                }
            }
        }
    }
}

