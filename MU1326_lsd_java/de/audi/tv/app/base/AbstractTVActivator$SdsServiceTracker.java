/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.TVServiceListener;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$SdsServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$SdsServiceTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        TVServiceListener tVServiceListener = (TVServiceListener)this.this$0.getBundleContext().getService(serviceReference);
        if (tVServiceListener != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.SdsServiceTracker.addingService] %1", (Object)tVServiceListener);
            this.this$0.getApp().sdsServiceHandler.addListener(tVServiceListener);
        }
        return tVServiceListener;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.SdsServiceTracker.removedService] %1", object);
        this.this$0.getApp().sdsServiceHandler.removeListener((TVServiceListener)object);
        this.this$0.getBundleContext().ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$SdsServiceTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

