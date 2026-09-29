/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.tv.app.base.TVActivator;
import de.audi.tv.app.base.TVActivator$1;
import org.osgi.framework.ServiceReference;

class TVActivator$MediaTVStateTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TVActivator this$0;

    private TVActivator$MediaTVStateTracker(TVActivator tVActivator) {
        this.this$0 = tVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TVActivator.access$300(this.this$0).getService(serviceReference);
        if (object instanceof ITVStateListener) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.MediaTVStateTracker.addingService] %1", object);
            TVActivator.access$400((TVActivator)this.this$0).tvStateProvider.addListener((ITVStateListener)object);
            return object;
        }
        TVActivator.access$500(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.MediaTVStateTracker.removedService] %1", object);
        TVActivator.access$400((TVActivator)this.this$0).tvStateProvider.removeListener((ITVStateListener)object);
        TVActivator.access$600(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TVActivator$MediaTVStateTracker(TVActivator tVActivator, TVActivator$1 tVActivator$1) {
        this(tVActivator);
    }
}

