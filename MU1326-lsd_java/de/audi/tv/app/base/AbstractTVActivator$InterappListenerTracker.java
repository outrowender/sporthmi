/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import de.audi.tv.app.interapp.ITVInterappListener;
import de.audi.tv.app.interapp.NullTVInterappListener;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$InterappListenerTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$InterappListenerTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        ITVInterappListener iTVInterappListener = (ITVInterappListener)AbstractTVActivator.access$2700(this.this$0).getService(serviceReference);
        if (iTVInterappListener != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.InterappListenerTracker.addingService] %1", (Object)iTVInterappListener);
            this.this$0.getApp().interappManager.registerService(iTVInterappListener);
        }
        return iTVInterappListener;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.InterappListenerTracker.removedService] %1", object);
        this.this$0.getApp().interappManager.registerService(new NullTVInterappListener());
        AbstractTVActivator.access$2800(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$InterappListenerTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

