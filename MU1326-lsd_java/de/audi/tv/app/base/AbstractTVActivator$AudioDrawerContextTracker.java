/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.NullAudioDrawerContext;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$AudioDrawerContextTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$AudioDrawerContextTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        AudioDrawerContext audioDrawerContext = (AudioDrawerContext)AbstractTVActivator.access$2500(this.this$0).getService(serviceReference);
        if (audioDrawerContext != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.AudioDrawerContextTracker.addingService] %1", (Object)audioDrawerContext);
            this.this$0.getApp().audioFocus.register(audioDrawerContext);
        }
        return audioDrawerContext;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.AudioDrawerContextTracker.removedService] %1", object);
        this.this$0.getApp().audioFocus.register(new NullAudioDrawerContext(this.this$0.env.lcAudio));
        AbstractTVActivator.access$2600(this.this$0).ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$AudioDrawerContextTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

