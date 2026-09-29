/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.interapp.TelMessagingDeviceRoleServiceHandler;
import de.audi.atip.interapp.messaging.devicerole.IDeviceRoleObserver;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class TelMessagingDeviceRoleServiceHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ TelMessagingDeviceRoleServiceHandler this$0;

    TelMessagingDeviceRoleServiceHandler$1(TelMessagingDeviceRoleServiceHandler telMessagingDeviceRoleServiceHandler) {
        this.this$0 = telMessagingDeviceRoleServiceHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IDeviceRoleObserver && TelMessagingDeviceRoleServiceHandler.access$000(this.this$0).contains(object)) {
            TelMessagingDeviceRoleServiceHandler.access$000(this.this$0).remove(object);
            object = null;
            TelMessagingDeviceRoleServiceHandler.access$100(this.this$0).getBundleContext().ungetService(serviceReference);
        }
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TelMessagingDeviceRoleServiceHandler.access$200(this.this$0).getBundleContext().getService(serviceReference);
        if (object instanceof IDeviceRoleObserver && !TelMessagingDeviceRoleServiceHandler.access$000(this.this$0).contains(object)) {
            TelMessagingDeviceRoleServiceHandler.access$000(this.this$0).add(object);
            TelMessagingDeviceRoleServiceHandler.access$600(this.this$0, TelMessagingDeviceRoleServiceHandler.access$300(this.this$0), TelMessagingDeviceRoleServiceHandler.access$400(this.this$0), TelMessagingDeviceRoleServiceHandler.access$500(this.this$0));
            return object;
        }
        TelMessagingDeviceRoleServiceHandler.access$700(this.this$0).getBundleContext().ungetService(serviceReference);
        return null;
    }
}

