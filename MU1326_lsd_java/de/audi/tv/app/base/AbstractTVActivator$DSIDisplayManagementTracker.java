/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.util.osgi.NullDSIDisplayManagement;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.dsi.ifc.displaymanagement.DSIDisplayManagement;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$DSIDisplayManagementTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$DSIDisplayManagementTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = AbstractTVActivator.access$1300(this.this$0).getService(serviceReference);
        this.this$0.getApp().setDSI((DSIDisplayManagement)object);
        return object;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.getApp().setDSI(new NullDSIDisplayManagement(this.this$0.env.lcMain));
        AbstractTVActivator.access$1400(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$DSIDisplayManagementTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

