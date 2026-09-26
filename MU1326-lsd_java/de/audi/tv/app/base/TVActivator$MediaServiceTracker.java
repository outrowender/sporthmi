/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.media.IMediaService;
import de.audi.tv.app.base.TVActivator;
import de.audi.tv.app.base.TVActivator$1;
import de.audi.tv.app.interapp.MediaSourceActivatorWrapper;
import org.osgi.framework.ServiceReference;

class TVActivator$MediaServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ TVActivator this$0;

    private TVActivator$MediaServiceTracker(TVActivator tVActivator) {
        this.this$0 = tVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = TVActivator.access$1000(this.this$0).getService(serviceReference);
        if (object instanceof IMediaService) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.MediaServiceTracker.addingService] %1", object);
            TVActivator.access$400((TVActivator)this.this$0).sourceActivatorAdapter.addSerivce(new MediaSourceActivatorWrapper((IMediaService)object));
            return object;
        }
        TVActivator.access$1100(this.this$0).ungetService(serviceReference);
        return null;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.MediaServiceTracker.removedService] %1", object);
        TVActivator.access$400((TVActivator)this.this$0).sourceActivatorAdapter.removeService();
        TVActivator.access$1200(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ TVActivator$MediaServiceTracker(TVActivator tVActivator, TVActivator$1 tVActivator$1) {
        this(tVActivator);
    }
}

