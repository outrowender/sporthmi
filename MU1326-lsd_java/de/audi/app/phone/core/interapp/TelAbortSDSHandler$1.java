/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelAbortSDSHandler;
import de.audi.atip.interapp.SDSService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TelAbortSDSHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TelAbortSDSHandler this$0;

    TelAbortSDSHandler$1(TelAbortSDSHandler telAbortSDSHandler) {
        this.this$0 = telAbortSDSHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof SDSService) {
            TelAbortSDSHandler.access$000(this.this$0).getBundleContext().ungetService(serviceReference);
            TelAbortSDSHandler.access$102(this.this$0, null);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TelAbortSDSHandler.access$200(this.this$0).getBundleContext().getService(serviceReference);
        if (object instanceof SDSService) {
            TelAbortSDSHandler.access$102(this.this$0, (SDSService)object);
            return object;
        }
        TelAbortSDSHandler.access$300(this.this$0).getBundleContext().ungetService(serviceReference);
        return null;
    }
}

