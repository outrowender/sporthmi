/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.base;

import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.def.NullSystemTonePlayer;
import de.audi.tghu.waveplayer.SystemTonePlayer;
import de.audi.tghu.waveplayer.WavePlayer;
import de.audi.tv.app.base.AbstractTVActivator;
import de.audi.tv.app.base.AbstractTVActivator$1;
import org.osgi.framework.ServiceReference;

class AbstractTVActivator$WavePlayerTracker
extends DefaultServiceTrackerCustomizer {
    private final /* synthetic */ AbstractTVActivator this$0;

    private AbstractTVActivator$WavePlayerTracker(AbstractTVActivator abstractTVActivator) {
        this.this$0 = abstractTVActivator;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        WavePlayer wavePlayer = (WavePlayer)this.this$0.getBundleContext().getService(serviceReference);
        if (wavePlayer != null) {
            this.this$0.env.lcMain.log(1078071040, "[Activator.WavePlayerTracker.addingService] %1", (Object)wavePlayer);
            SystemTonePlayer systemTonePlayer = wavePlayer.getSystemTonePlayer();
            this.this$0.getApp().ewsBeep.setSystemTonePlayer(systemTonePlayer);
            systemTonePlayer.setListener(this.this$0.getApp().ewsBeep.playerListener);
        }
        return wavePlayer;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        this.this$0.env.lcMain.log(1078071040, "[Activator.WavePlayerTracker.removedService] %1", object);
        this.this$0.getApp().ewsBeep.setSystemTonePlayer(new NullSystemTonePlayer(this.this$0.env.lcMain));
        this.this$0.getBundleContext().ungetService(serviceReference);
    }

    /* synthetic */ AbstractTVActivator$WavePlayerTracker(AbstractTVActivator abstractTVActivator, AbstractTVActivator$1 abstractTVActivator$1) {
        this(abstractTVActivator);
    }
}

