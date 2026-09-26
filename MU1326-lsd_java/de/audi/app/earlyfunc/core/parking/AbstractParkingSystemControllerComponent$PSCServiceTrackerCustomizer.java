/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.earlyfunc.core.parking;

import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent;
import de.audi.app.earlyfunc.core.parking.AbstractParkingSystemControllerComponent$1;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class AbstractParkingSystemControllerComponent$PSCServiceTrackerCustomizer
implements ServiceTrackerCustomizer {
    private final /* synthetic */ AbstractParkingSystemControllerComponent this$0;

    private AbstractParkingSystemControllerComponent$PSCServiceTrackerCustomizer(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent) {
        this.this$0 = abstractParkingSystemControllerComponent;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractParkingSystemControllerComponent.access$300(this.this$0).getBundleContext().getService(serviceReference);
        if (object instanceof AudioDrawerContext) {
            AbstractParkingSystemControllerComponent.access$402(this.this$0, (AudioDrawerContext)object);
            return object;
        }
        AbstractParkingSystemControllerComponent.access$500(this.this$0).getBundleContext().ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof AudioDrawerContext) {
            AbstractParkingSystemControllerComponent.access$600(this.this$0).getBundleContext().ungetService(serviceReference);
            AbstractParkingSystemControllerComponent.access$402(this.this$0, null);
        }
    }

    /* synthetic */ AbstractParkingSystemControllerComponent$PSCServiceTrackerCustomizer(AbstractParkingSystemControllerComponent abstractParkingSystemControllerComponent, AbstractParkingSystemControllerComponent$1 abstractParkingSystemControllerComponent$1) {
        this(abstractParkingSystemControllerComponent);
    }
}

