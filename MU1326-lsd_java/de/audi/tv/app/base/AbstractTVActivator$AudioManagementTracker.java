/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullHMIAudioService;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$AudioManagementTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$AudioManagementTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        HMIAudioService hMIAudioService = (HMIAudioService)AbstractTVActivator.access$2100(this.this$0).getService(serviceReference);
        if (HMIAudioService.CLIENT_TV.equals(serviceReference.getProperty("AUDIO_CLIENT_ID"))) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.AudioManagementTracker.addingService] %1", (Object)hMIAudioService);
            this.this$0.getApp().audioListener.setService(hMIAudioService);
            this.this$0.getApp().ewsBeep.setHMIAudioService(hMIAudioService);
        }
        return hMIAudioService;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.AudioManagementTracker.removedService] %1", object);
        this.this$0.getApp().audioListener.setService(new NullHMIAudioService(this.this$0.env.lcMain));
        AbstractTVActivator.access$2200(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$AudioManagementTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

