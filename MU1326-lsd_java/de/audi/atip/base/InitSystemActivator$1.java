/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.base;

import de.audi.atip.audio.HMIAudioService;
import de.audi.atip.base.InitSystemActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class InitSystemActivator$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BundleContext val$context;
    private final /* synthetic */ InitSystemActivator this$0;

    InitSystemActivator$1(InitSystemActivator initSystemActivator, BundleContext bundleContext) {
        this.this$0 = initSystemActivator;
        this.val$context = bundleContext;
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        Object object = serviceReference.getProperty("AUDIO_CLIENT_ID");
        if (HMIAudioService.CLIENT_STARTUP.equals(object)) {
            Object object2 = this.val$context.getService(serviceReference);
            InitSystemActivator.access$000(this.this$0).log(1078071040, "[InitSystemActivator] addingService HMIAudioService %1, AudioClientID=%2", (Object)((HMIAudioService)object2).toString(), object);
            this.this$0.getFramework().getLastmodeHandler().setHMIAudioService((HMIAudioService)object2);
            return object2;
        }
        this.val$context.ungetService(serviceReference);
        return null;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        InitSystemActivator.access$000(this.this$0).log(1078071040, "[InitSystemActivator] removedService HMIAudioService %1", object);
        this.this$0.getFramework().getLastmodeHandler().setHMIAudioService(null);
        this.val$context.ungetService(serviceReference);
    }
}

