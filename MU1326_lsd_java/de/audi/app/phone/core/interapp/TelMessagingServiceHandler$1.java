/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelMessagingServiceHandler;
import de.audi.atip.interapp.IMessagingService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TelMessagingServiceHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TelMessagingServiceHandler this$0;

    TelMessagingServiceHandler$1(TelMessagingServiceHandler telMessagingServiceHandler) {
        this.this$0 = telMessagingServiceHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IMessagingService) {
            TelMessagingServiceHandler.access$002(this.this$0, null);
            TelMessagingServiceHandler.access$100(this.this$0).getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TelMessagingServiceHandler.access$200(this.this$0).getBundleContext().getService(serviceReference);
        if (object instanceof IMessagingService) {
            TelMessagingServiceHandler.access$002(this.this$0, (IMessagingService)object);
            return object;
        }
        TelMessagingServiceHandler.access$300(this.this$0).getBundleContext().ungetService(serviceReference);
        return null;
    }
}

