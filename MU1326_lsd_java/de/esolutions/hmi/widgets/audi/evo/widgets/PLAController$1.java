/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets;

import de.audi.atip.interapp.earlyfunc.core.parking.pla.IPLAInterappService;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.evo.widgets.PLAController;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class PLAController$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ PLAController this$0;

    PLAController$1(PLAController pLAController) {
        this.this$0 = pLAController;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        PLAController.access$002(this.this$0, null);
        AbstractWidget.widgetsActivator.getBundleContext().ungetService(serviceReference);
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractWidget.widgetsActivator.getBundleContext().getService(serviceReference);
        if (object instanceof IPLAInterappService) {
            PLAController.access$002(this.this$0, (IPLAInterappService)object);
            PLAController.access$000(this.this$0).registerStatusListener(this.this$0);
        }
        return object;
    }
}

