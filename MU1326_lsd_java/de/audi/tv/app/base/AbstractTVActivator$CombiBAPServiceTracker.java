/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.combi.bap.audio.CombiBAPServiceTV;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import de.audi.tv.app.combi.NullCombiBAPServiceTV;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$CombiBAPServiceTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$CombiBAPServiceTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        CombiBAPServiceTV combiBAPServiceTV = (CombiBAPServiceTV)AbstractTVActivator.access$2900(this.this$0).getService(serviceReference);
        if (combiBAPServiceTV != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.CombiBAPServiceTracker.addingService] %1", (Object)combiBAPServiceTV);
            this.this$0.getApp().combiBAPHandler.registerService(combiBAPServiceTV);
        }
        return combiBAPServiceTV;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.CombiBAPServiceTracker.removedService] %1", object);
        this.this$0.getApp().combiBAPHandler.registerService(new NullCombiBAPServiceTV());
        AbstractTVActivator.access$3000(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$CombiBAPServiceTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

