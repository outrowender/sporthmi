/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.high;

import de.audi.atip.hmi.HMIBundle;
import de.audi.atip.hmi.event.RunnableEvent;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh;
import de.esolutions.hmi.widgets.audi.evo.high.DrawerManagerEvoHigh$2$1;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class DrawerManagerEvoHigh$2
implements ServiceTrackerCustomizer {
    private final /* synthetic */ DrawerManagerEvoHigh this$0;

    DrawerManagerEvoHigh$2(DrawerManagerEvoHigh drawerManagerEvoHigh) {
        this.this$0 = drawerManagerEvoHigh;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        HMIBundle hMIBundle = (HMIBundle)DrawerManagerEvoHigh.access$100(this.this$0).getService(serviceReference);
        AbstractWidget.hmiService.getEventDispatcher().postEvent(new RunnableEvent(true, new DrawerManagerEvoHigh$2$1(this, hMIBundle)));
        return hMIBundle;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
    }

    static /* synthetic */ DrawerManagerEvoHigh access$200(DrawerManagerEvoHigh$2 drawerManagerEvoHigh$2) {
        return drawerManagerEvoHigh$2.this$0;
    }
}

