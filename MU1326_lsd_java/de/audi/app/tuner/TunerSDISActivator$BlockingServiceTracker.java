/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.TunerSDISActivator;
import de.audi.app.tuner.TunerSDISActivator$1;
import de.audi.app.tuner.sdis.NullSDISBlockingService;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import org.osgi.framework.ServiceReference;

class TunerSDISActivator$BlockingServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TunerSDISActivator this$0;

    private TunerSDISActivator$BlockingServiceTracker(TunerSDISActivator tunerSDISActivator) {
        this.this$0 = tunerSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ISDISBlockingService iSDISBlockingService = (ISDISBlockingService)TunerSDISActivator.access$200(this.this$0).getService(serviceReference);
        if (iSDISBlockingService != null) {
            this.this$0.asiProvider.parentalEnforcement.setService(iSDISBlockingService);
            return iSDISBlockingService;
        }
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.asiProvider.parentalEnforcement.setService(new NullSDISBlockingService());
        TunerSDISActivator.access$300(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TunerSDISActivator$BlockingServiceTracker(TunerSDISActivator tunerSDISActivator, TunerSDISActivator$1 tunerSDISActivator$1) {
        this(tunerSDISActivator);
    }
}

