/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.base.InitSystemActivator$1;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class InitSystemActivator
extends AbstractActivator {
    private LogChannel log;
    private volatile ServiceTracker audioServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.getFramework().getStartupMgr().initSystem();
        this.log = this.getFramework().getLogChannel("Fw.Startup");
        this.audioServiceTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = InitSystemActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), (ServiceTrackerCustomizer)new InitSystemActivator$1(this, bundleContext));
        this.audioServiceTracker.open();
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.log.log(10000, "InitSystem service can't be stopped!");
        if (this.audioServiceTracker != null) {
            this.audioServiceTracker.close();
            this.audioServiceTracker = null;
        }
        super.stop(bundleContext);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(InitSystemActivator initSystemActivator) {
        return initSystemActivator.log;
    }
}

