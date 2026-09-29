/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.interapp.TelServiceMessaging$1;
import de.audi.app.phone.core.interapp.TelServiceMessaging$TelServiceMessagingDiag;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import java.util.Hashtable;

public class TelServiceMessaging
extends AbstractPhoneComponent
implements ITelServiceMessaging {
    private volatile PhoneServiceProvider messagingPhoneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMessaging;

    public TelServiceMessaging(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    @Override
    public void init() {
        this.registerPhoneServiceMessaging();
        this.getApplication().addDiagnosisComponent(new TelServiceMessaging$TelServiceMessagingDiag(this, null));
    }

    @Override
    public void deinit() {
        if (this.messagingPhoneService != null) {
            this.messagingPhoneService.stopService();
        }
    }

    private void registerPhoneServiceMessaging() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("ApplicationName", "AppPhone");
        this.messagingPhoneService = new PhoneServiceProvider((class$de$audi$atip$interapp$phone$ITelServiceMessaging == null ? (class$de$audi$atip$interapp$phone$ITelServiceMessaging = TelServiceMessaging.class$("de.audi.atip.interapp.phone.ITelServiceMessaging")) : class$de$audi$atip$interapp$phone$ITelServiceMessaging).getName(), this, hashtable, this.getApplication().getBundleContext(), this.log);
        this.messagingPhoneService.startService();
    }

    @Override
    public void notifyNewMessagesAvailable(boolean bl, boolean bl2) {
        this.getApplication().enqueueEvent(new TelServiceMessaging$1(this, "TelServiceMessaging#notifyNewMessagesAvailable", bl, bl2));
    }

    @Override
    public void notifyActiveContextMessaging(int n) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ITelApplication access$100(TelServiceMessaging telServiceMessaging) {
        return telServiceMessaging.getApplication();
    }
}

