/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.TVSDISActivator;
import de.audi.tv.app.TVSDISActivator$1;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.NullTVInterappService;
import org.osgi.framework.ServiceReference;

class TVSDISActivator$InterappServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TVSDISActivator this$0;

    private TVSDISActivator$InterappServiceTracker(TVSDISActivator tVSDISActivator) {
        this.this$0 = tVSDISActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TVSDISActivator.access$300(this.this$0).log(1078071040, "InterappServiceTracker#addingService( %1 )", (Object)serviceReference);
        boolean bl = false;
        Object object = TVSDISActivator.access$600(this.this$0).getService(serviceReference);
        if (object instanceof ITVInterappService) {
            TVSDISActivator.access$300(this.this$0).log(-2137614336, "[TVSDISActivator.InterappServiceTracker.addingService] TV interapp service registered.");
            TVSDISActivator.access$400(this.this$0).setTVInterappService((ITVInterappService)object);
            bl = true;
        }
        return bl ? serviceReference : null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        TVSDISActivator.access$300(this.this$0).log(1078071040, "InterappServiceTracker#removedService( %1, %2 )", (Object)serviceReference, object);
        if (object instanceof ITVInterappService) {
            TVSDISActivator.access$400(this.this$0).setTVInterappService(new NullTVInterappService());
        }
        TVSDISActivator.access$700(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TVSDISActivator$InterappServiceTracker(TVSDISActivator tVSDISActivator, TVSDISActivator$1 tVSDISActivator$1) {
        this(tVSDISActivator);
    }
}

