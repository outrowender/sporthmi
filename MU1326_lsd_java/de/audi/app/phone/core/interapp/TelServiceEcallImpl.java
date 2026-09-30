/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.dsi.TelDefaultDSIResponseListener;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.atip.interapp.phone.ITelServiceEcall;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;

public class TelServiceEcallImpl
extends AbstractPhoneComponent
implements ITelServiceEcall {
    private final PhoneServiceProvider phoneServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceEcall;

    public TelServiceEcallImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.phoneServiceProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceEcall == null ? (class$de$audi$atip$interapp$phone$ITelServiceEcall = TelServiceEcallImpl.class$("de.audi.atip.interapp.phone.ITelServiceEcall")) : class$de$audi$atip$interapp$phone$ITelServiceEcall).getName(), this, null, this.getApplication().getBundleContext(), this.log);
    }

    public void init() {
        super.init();
        this.phoneServiceProvider.startService();
    }

    public void deinit() {
        super.deinit();
        this.phoneServiceProvider.stopService();
    }

    public void hangupAllCalls(final ITelServiceEcallListener iTelServiceEcallListener) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceEcallImpl#hangupAllCalls"){

            public void run() {
                TelServiceEcallImpl.this.log.log(10000000, "TelServiceEcallImpl#hangupAllCalls(): called.");
                TelServiceEcallImpl.this.getApplication().getTelephoneDSIAccess().hangupCall(255, 0, false, new TelDefaultDSIResponseListener(){

                    public void responseHangupCall(int n, int n2) {
                        iTelServiceEcallListener.responseHangupAllCalls(n);
                    }
                });
            }
        });
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

