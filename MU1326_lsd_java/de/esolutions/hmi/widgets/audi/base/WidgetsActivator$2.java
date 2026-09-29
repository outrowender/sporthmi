/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.interapp.SDSService;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class WidgetsActivator$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ WidgetsActivator this$0;

    WidgetsActivator$2(WidgetsActivator widgetsActivator) {
        this.this$0 = widgetsActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        WidgetsActivator.access$302(this.this$0, (SDSService)this.this$0.getBundleContext().getService(serviceReference));
        AbstractWidget.setSDSService(WidgetsActivator.access$300(this.this$0));
        return WidgetsActivator.access$300(this.this$0);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        WidgetsActivator.access$302(this.this$0, null);
        AbstractWidget.setSDSService(WidgetsActivator.access$300(this.this$0));
    }
}

