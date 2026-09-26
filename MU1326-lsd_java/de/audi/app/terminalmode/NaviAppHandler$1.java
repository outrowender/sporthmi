/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.NaviAppHandler;
import de.audi.atip.interapp.NaviService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class NaviAppHandler$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ NaviAppHandler this$0;

    NaviAppHandler$1(NaviAppHandler naviAppHandler) {
        this.this$0 = naviAppHandler;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        NaviAppHandler.access$002(this.this$0, null);
        NaviAppHandler.access$100(this.this$0).getServiceManager().releaseService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = NaviAppHandler.access$100(this.this$0).getServiceManager().getService(serviceReference);
        if (!(object instanceof NaviService)) {
            NaviAppHandler.access$200(this.this$0).log(1078071040, "[%1.addingService] unwanted service", (Object)"NaviAppHandler");
            NaviAppHandler.access$100(this.this$0).getServiceManager().releaseService(serviceReference);
            return object;
        }
        NaviAppHandler.access$002(this.this$0, (NaviService)object);
        NaviAppHandler.access$302(this.this$0, NaviAppHandler.access$000(this.this$0).getRgActiveStatus());
        return NaviAppHandler.access$000(this.this$0);
    }
}

