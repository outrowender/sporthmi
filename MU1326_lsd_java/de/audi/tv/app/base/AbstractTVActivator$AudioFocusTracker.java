/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.audio.IAudioFocusManager;
import de.audi.atip.audio.NullAudioFocusManager;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$AudioFocusTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$AudioFocusTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IAudioFocusManager iAudioFocusManager = (IAudioFocusManager)AbstractTVActivator.access$2300(this.this$0).getService(serviceReference);
        if (iAudioFocusManager != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.AudioFocusTracker.addingService] %1", (Object)iAudioFocusManager);
            this.this$0.getApp().audioFocus.register(iAudioFocusManager);
        }
        return iAudioFocusManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.AudioFocusTracker.removedService] %1", object);
        this.this$0.getApp().audioFocus.register(new NullAudioFocusManager(this.this$0.env.lcHMI));
        AbstractTVActivator.access$2400(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$AudioFocusTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

