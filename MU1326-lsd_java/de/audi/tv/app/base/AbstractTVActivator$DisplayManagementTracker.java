/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.displaymanager.IDisplayManagerService;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import de.audi.tv.app.dsi.NullDisplayManager;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$DisplayManagementTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$DisplayManagementTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractTVActivator.access$1500(this.this$0).getService(serviceReference);
        this.this$0.getApp().setDSI((IDisplayManagerService)object);
        return object;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.getApp().setDSI(new NullDisplayManager());
        AbstractTVActivator.access$1600(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$DisplayManagementTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

