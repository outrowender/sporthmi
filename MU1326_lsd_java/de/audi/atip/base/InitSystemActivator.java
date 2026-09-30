/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class InitSystemActivator
extends AbstractActivator {
    private LogChannel log;
    private volatile ServiceTracker audioServiceTracker;
    static /* synthetic */ Class class$de$audi$atip$audio$HMIAudioService;

    public void start(final BundleContext bundleContext) {
        super.start(bundleContext);
        this.getFramework().getStartupMgr().initSystem();
        this.log = this.getFramework().getLogChannel("Fw.Startup");
        this.audioServiceTracker = new ServiceTracker(bundleContext, (class$de$audi$atip$audio$HMIAudioService == null ? (class$de$audi$atip$audio$HMIAudioService = InitSystemActivator.class$("de.audi.atip.audio.HMIAudioService")) : class$de$audi$atip$audio$HMIAudioService).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
                if (HMIAudioService.CLIENT_STARTUP.equals(object)) {
                    Object object2 = bundleContext.getService(serviceReference);
                    InitSystemActivator.this.log.log(1000000, "[InitSystemActivator] addingService HMIAudioService %1, AudioClientID=%2", (Object)((HMIAudioService)object2).toString(), object);
                    InitSystemActivator.this.getFramework().getLastmodeHandler().setHMIAudioService((HMIAudioService)object2);
                    return object2;
                }
                bundleContext.ungetService(serviceReference);
                return null;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                InitSystemActivator.this.log.log(1000000, "[InitSystemActivator] removedService HMIAudioService %1", object);
                InitSystemActivator.this.getFramework().getLastmodeHandler().setHMIAudioService(null);
                bundleContext.ungetService(serviceReference);
            }
        });
        this.audioServiceTracker.open();
    }

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
}

