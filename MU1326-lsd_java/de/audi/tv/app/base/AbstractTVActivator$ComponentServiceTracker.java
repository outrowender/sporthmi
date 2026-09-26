/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.tv.ITVComponentListener;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$ComponentServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$ComponentServiceTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ITVComponentListener iTVComponentListener = (ITVComponentListener)this.this$0.getBundleContext().getService(serviceReference);
        if (iTVComponentListener != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.ComponentServiceTracker.addingService] %1", (Object)iTVComponentListener);
            this.this$0.getApp().componentCallListener.setListener(iTVComponentListener);
        }
        return iTVComponentListener;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.ComponentServiceTracker.removedService] %1", object);
        this.this$0.getApp().componentCallListener.setListener(null);
        this.this$0.getBundleContext().ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$ComponentServiceTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

