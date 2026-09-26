/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.TunerService;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullTunerService;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$TunerServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$TunerServiceTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TunerService tunerService = (TunerService)AbstractTVActivator.access$3100(this.this$0).getService(serviceReference);
        this.this$0.env.lcMain.log(-2137614336, "[Activator.TunerServiceTracker.addingService] '%1'", (Object)tunerService);
        this.this$0.getApp().taHandler.registerService(tunerService);
        return tunerService;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(-2137614336, "[Activator.TunerServiceTracker.removedService] %1", object);
        this.this$0.getApp().taHandler.registerService(new NullTunerService(this.this$0.env.lcAudio));
        AbstractTVActivator.access$3200(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$TunerServiceTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

