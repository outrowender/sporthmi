/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.sdis;

import de.audi.app.navi.sdis.NaviSDISActivator;
import de.audi.app.navi.sdis.NaviSDISActivator$1;
import de.audi.tghu.navi.app.sdis.INaviTabletService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class NaviSDISActivator$MyServiceTracker
implements ServiceTrackerCustomizer {
    private final /* synthetic */ NaviSDISActivator this$0;

    private NaviSDISActivator$MyServiceTracker(NaviSDISActivator naviSDISActivator) {
        this.this$0 = naviSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        NaviSDISActivator.access$100(this.this$0).log(1078071040, "Adding service: %1", (Object)serviceReference);
        Object object = null;
        try {
            object = NaviSDISActivator.access$200(this.this$0).getService(serviceReference);
            if (object instanceof INaviTabletService) {
                NaviSDISActivator.access$100(this.this$0).log(1078071040, "Adding ASIHandler: %1", object);
                this.this$0.naviAsiProvider.setTabletService((INaviTabletService)object);
                return object;
            }
        }
        catch (Exception exception) {
            NaviSDISActivator.access$100(this.this$0).log(1078071040, "Adding Service failed: %1", (Object)serviceReference, (Throwable)exception);
        }
        if (object != null) {
            NaviSDISActivator.access$300(this.this$0).ungetService(serviceReference);
        }
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        NaviSDISActivator.access$100(this.this$0).log(1078071040, "Removed service: %1 %2", (Object)serviceReference, object);
        try {
            NaviSDISActivator.access$400(this.this$0).ungetService(serviceReference);
            if (object instanceof INaviTabletService) {
                NaviSDISActivator.access$100(this.this$0).log(1078071040, "Removed ASIHandler: %1", object);
                this.this$0.naviAsiProvider.setTabletService(null);
            }
        }
        catch (Exception exception) {
            NaviSDISActivator.access$100(this.this$0).log(1078071040, "Removed Service failed: %1", (Object)serviceReference, (Throwable)exception);
        }
    }

    /* synthetic */ NaviSDISActivator$MyServiceTracker(NaviSDISActivator naviSDISActivator, NaviSDISActivator$1 naviSDISActivator$1) {
        this(naviSDISActivator);
    }
}

