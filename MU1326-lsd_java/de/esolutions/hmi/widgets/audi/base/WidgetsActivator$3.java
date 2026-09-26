/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class WidgetsActivator$3
implements ServiceTrackerCustomizer {
    private final /* synthetic */ WidgetsActivator this$0;

    WidgetsActivator$3(WidgetsActivator widgetsActivator) {
        this.this$0 = widgetsActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IHMIServiceEvo iHMIServiceEvo = (IHMIServiceEvo)this.this$0.getBundleContext().getService(serviceReference);
        this.this$0.hmiServiceAdded(iHMIServiceEvo);
        return iHMIServiceEvo;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }
}

