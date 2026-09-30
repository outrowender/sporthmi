/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.AbstractPhoneComponent;
import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.PhoneServiceTracker;
import de.audi.atip.interapp.IMessagingService;
import de.esolutions.fw.util.commons.Buffer;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TelMessagingServiceHandler
extends AbstractPhoneComponent {
    private final PhoneServiceTracker messagingServiceTracker;
    private volatile IMessagingService messagingService;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMessagingService;

    public TelMessagingServiceHandler(ITelApplication iTelApplication) {
        super(iTelApplication, "App.Phone.Main");
        this.messagingServiceTracker = new PhoneServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$IMessagingService == null ? (class$de$audi$atip$interapp$IMessagingService = TelMessagingServiceHandler.class$("de.audi.atip.interapp.IMessagingService")) : class$de$audi$atip$interapp$IMessagingService).getName(), new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof IMessagingService) {
                    TelMessagingServiceHandler.this.messagingService = null;
                    TelMessagingServiceHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                }
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                Object object = TelMessagingServiceHandler.this.getApplication().getBundleContext().getService(serviceReference);
                if (object instanceof IMessagingService) {
                    TelMessagingServiceHandler.this.messagingService = (IMessagingService)object;
                    return object;
                }
                TelMessagingServiceHandler.this.getApplication().getBundleContext().ungetService(serviceReference);
                return null;
            }
        }, this.log);
    }

    public void init() {
        super.init();
        this.messagingServiceTracker.openTracker();
    }

    public void deinit() {
        super.deinit();
        this.messagingServiceTracker.closeTracker();
    }

    public boolean prepareSendSMS(String string) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService != null) {
            this.log.log(1000000, "[TelMessagingServiceHandler#sendSMS] telephoneNumber=%1", (Object)string);
            iMessagingService.composeMsgPresetRecipient(0, string);
            return true;
        }
        this.log.log(100000, "[TelMessagingServiceHandler#sendSMS] messaging service is null --> NOP!");
        return false;
    }

    public boolean prepareSendSMS(String string, long l, int n) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService != null) {
            if (this.log.isInfo()) {
                Buffer buffer = new Buffer();
                buffer.append("telephoneNumber");
                buffer.append("=");
                buffer.append(string);
                buffer.append(", ");
                buffer.append("adbEntryId");
                buffer.append("=");
                buffer.append(l);
                buffer.append(", ");
                buffer.append("phoneNumberIndex");
                buffer.append("=");
                buffer.append(n);
                this.log.log(1000000, "[TelMessagingServiceHandler#sendSMS] %1", (Object)buffer);
            }
            iMessagingService.composeMsgPresetRecipient(0, l, n);
            return true;
        }
        this.log.log(100000, "[TelMessagingServiceHandler#sendSMS] messaging service is null --> NOP!");
        return false;
    }

    public boolean prepareSendEmail(long l) {
        IMessagingService iMessagingService = this.messagingService;
        if (iMessagingService != null) {
            this.log.log(1000000, "[TelMessagingServiceHandler#prepareSendEmail] preparing email for adbEntryId %1", l);
            iMessagingService.composeMsgPresetRecipient(1, l, -1);
            return true;
        }
        this.log.log(100000, "[TelMessagingServiceHandler#sendSMS] messaging service is null --> NOP!");
        return false;
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

