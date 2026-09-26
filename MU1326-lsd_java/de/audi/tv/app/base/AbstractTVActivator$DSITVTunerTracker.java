/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import de.audi.tv.app.dsi.NullDSITVTuner;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$DSITVTunerTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$DSITVTunerTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractTVActivator.access$1700(this.this$0).getService(serviceReference);
        this.this$0.env.lcMain.log(1078071040, "[Activator.DSITVTunerTracker.addingService] %1", object);
        this.this$0.getApp().setDSI((DSITVTuner)object);
        return object;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.DSITVTunerTracker.removedService] %1", object);
        this.this$0.getApp().setDSI(new NullDSITVTuner(this.this$0.env.lcMain));
        AbstractTVActivator.access$1800(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$DSITVTunerTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

