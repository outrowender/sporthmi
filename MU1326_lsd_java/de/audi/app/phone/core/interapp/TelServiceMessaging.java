/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.phone.IPhoneDiagComponent
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceProvider;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import de.mib.swdiagnosis.phone.IPhoneDiagComponent;
import java.util.Hashtable;

public class TelServiceMessaging
extends AbstractPhoneComponent
implements ITelServiceMessaging {
    private volatile PhoneServiceProvider messagingPhoneService;
    static /* synthetic */ Class class$de$audi$atip$interapp$phone$ITelServiceMessaging;

    public TelServiceMessaging(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
    }

    public void init() {
        this.registerPhoneServiceMessaging();
        this.getApplication().addDiagnosisComponent(new TelServiceMessagingDiag());
    }

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

    public void notifyNewMessagesAvailable(final boolean bl, final boolean bl2) {
        this.getApplication().enqueueEvent(new AbstractTelInterappEvent("TelServiceMessaging#notifyNewMessagesAvailable"){

            public void run() {
                TelServiceMessaging.this.getApplication().getGlobalTelephoneStateManager().updateNewMessagesAvailable(bl, bl2);
            }
        });
    }

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

    private class TelServiceMessagingDiag
    implements IPhoneDiagComponent {
        private TelServiceMessagingDiag() {
        }

        public void cmdUpdateNewMessagesAvailable(boolean bl, boolean bl2) {
            TelServiceMessaging.this.notifyNewMessagesAvailable(bl, bl2);
        }
    }
}

