/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.TVActivator;
import de.audi.tv.app.base.TVActivator$1;
import de.audi.tv.app.truffles.NullDSISearchDataProvider;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.search.DSISearchDataProvider;
import org.osgi.framework.ServiceReference;

class TVActivator$SearchDSITracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TVActivator this$0;

    private TVActivator$SearchDSITracker(TVActivator tVActivator) {
        this.this$0 = tVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("DEVICE_INSTANCE");
        Object object2 = TVActivator.access$700(this.this$0).getService(serviceReference);
        if (object2 instanceof DSISearchDataProvider && object != null && ((Integer)object).intValue() == TVActivator.access$400((TVActivator)this.this$0).searchHandler.getSearchId()) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.SearchDSITracker.addingService] %1", object2);
            TVActivator.access$400((TVActivator)this.this$0).searchHandler.getSearchDataProvider().setDeviceService((DSIBase)object2);
            return object2;
        }
        TVActivator.access$800(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.SearchDSITracker.removedService] %1", object);
        TVActivator.access$400((TVActivator)this.this$0).searchHandler.getSearchDataProvider().setDeviceService(new NullDSISearchDataProvider(this.this$0.env.lcTruffles));
        TVActivator.access$900(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TVActivator$SearchDSITracker(TVActivator tVActivator, TVActivator$1 tVActivator$1) {
        this(tVActivator);
    }
}

