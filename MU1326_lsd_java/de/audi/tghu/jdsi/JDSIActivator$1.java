/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.jdsi;

import de.audi.tghu.jdsi.JDSIActivator;
import org.dsi.ifc.base.ServiceAdmin;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class JDSIActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ JDSIActivator this$0;

    JDSIActivator$1(JDSIActivator jDSIActivator) {
        this.this$0 = jDSIActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = JDSIActivator.access$000(this.this$0).getService(serviceReference);
        if (object instanceof ServiceAdmin) {
            JDSIActivator.access$102(this.this$0, serviceReference);
            JDSIActivator.access$200(this.this$0).setServiceAdmin((ServiceAdmin)object);
            return object;
        }
        JDSIActivator.access$300(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        JDSIActivator.access$400(this.this$0).ungetService(serviceReference);
        JDSIActivator.access$102(this.this$0, null);
        JDSIActivator.access$200(this.this$0).setServiceAdmin(null);
    }
}

