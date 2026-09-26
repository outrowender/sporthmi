/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.interapp.TelServiceEcallImpl$1;
import de.audi.atip.interapp.phone.ITelServiceEcall;
import de.audi.atip.interapp.phone.ITelServiceEcallListener;
import de.audi.atip.log.LogChannel;

public class TelServiceEcallImpl
extends AbstractPhoneComponent
implements ITelServiceEcall {
    private final PhoneServiceProvider phoneServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceEcall;

    public TelServiceEcallImpl(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.phoneServiceProvider = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceEcall == null ? (class$de$audi$atip$interapp$phone$ITelServiceEcall = TelServiceEcallImpl.class$("de.audi.atip.interapp.phone.ITelServiceEcall")) : class$de$audi$atip$interapp$phone$ITelServiceEcall).getName(), this, null, this.getApplication().getBundleContext(), this.log);
    }

    @Override
    public void init() {
        super.init();
        this.phoneServiceProvider.startService();
    }

    @Override
    public void deinit() {
        super.deinit();
        this.phoneServiceProvider.stopService();
    }

    @Override
    public void hangupAllCalls(ITelServiceEcallListener iTelServiceEcallListener) {
        this.getApplication().enqueueEvent(new TelServiceEcallImpl$1(this, "TelServiceEcallImpl#hangupAllCalls", iTelServiceEcallListener));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(TelServiceEcallImpl telServiceEcallImpl) {
        return telServiceEcallImpl.log;
    }

    static /* synthetic */ ITelApplication access$200(TelServiceEcallImpl telServiceEcallImpl) {
        return telServiceEcallImpl.getApplication();
    }
}

