/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.interapp;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.interapp.TelConnectivityHandler;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo$TelEnteredListener;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo$TelLeftListener;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo$TelUnlockEnteredListener;
import de.audi.app.phone.evo.interapp.TelConnectivityHandlerEvo$TelUnlockLeftListener;
import java.util.ArrayList;

public class TelConnectivityHandlerEvo
extends TelConnectivityHandler {
    public TelConnectivityHandlerEvo(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.addSubPhoneComponent(new TelConnectivityHandlerEvo$TelEnteredListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelConnectivityHandlerEvo$TelLeftListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelConnectivityHandlerEvo$TelUnlockEnteredListener(this, iTelApplication));
        this.addSubPhoneComponent(new TelConnectivityHandlerEvo$TelUnlockLeftListener(this, iTelApplication));
    }

    static /* synthetic */ ArrayList access$000(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$100(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$200(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$300(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$400(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$500(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$600(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }

    static /* synthetic */ ArrayList access$700(TelConnectivityHandlerEvo telConnectivityHandlerEvo) {
        return telConnectivityHandlerEvo.connectivityListeners;
    }
}

