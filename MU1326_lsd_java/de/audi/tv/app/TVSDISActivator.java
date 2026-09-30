/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.tv.app.interapp.ITVInterappService;
import de.audi.tv.app.interapp.NullTVInterappService;
import de.audi.tv.app.sdis.NullSDISBlockingService;
import de.audi.tv.app.sdis.TVASIProvider;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TVSDISActivator
extends AbstractActivator {
    private ServiceTracker trackerInterAppService;
    private ServiceTracker trackerBlockingService;
    private TVASIProvider asiProvider;
    private LogChannel log = NullLogChannel.getInstance();
    static /* synthetic */ Class class$de$audi$tv$app$interapp$ITVInterappService;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingService;
    static /* synthetic */ Class class$de$audi$tv$app$interapp$ITVInterappListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.TV.SDIS");
        this.asiProvider = new TVASIProvider(this.log, 0);
        this.trackerInterAppService = new ServiceTracker(bundleContext, (class$de$audi$tv$app$interapp$ITVInterappService == null ? (class$de$audi$tv$app$interapp$ITVInterappService = TVSDISActivator.class$("de.audi.tv.app.interapp.ITVInterappService")) : class$de$audi$tv$app$interapp$ITVInterappService).getName(), (ServiceTrackerCustomizer)new InterappServiceTracker());
        this.trackerInterAppService.open();
        this.trackerBlockingService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = TVSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName(), (ServiceTrackerCustomizer)new BlockingServiceTracker());
        this.trackerBlockingService.open();
        this.registerService((class$de$audi$tv$app$interapp$ITVInterappListener == null ? (class$de$audi$tv$app$interapp$ITVInterappListener = TVSDISActivator.class$("de.audi.tv.app.interapp.ITVInterappListener")) : class$de$audi$tv$app$interapp$ITVInterappListener).getName(), (Object)this.asiProvider.tvInterappListener, null);
        this.registerService((class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = TVSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (Object)this.asiProvider.blockingListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = TVSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiProvider, null);
        this.log.log(1000000, "[TVSDISActivator.start] TV-SDIS package started");
    }

    public void stop(BundleContext bundleContext) {
        if (this.trackerInterAppService != null) {
            this.trackerInterAppService.close();
            this.trackerInterAppService = null;
        }
        if (this.trackerBlockingService != null) {
            this.trackerBlockingService.close();
            this.trackerBlockingService = null;
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

    private class BlockingServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private BlockingServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            ISDISBlockingService iSDISBlockingService = (ISDISBlockingService)TVSDISActivator.this.bundleContext.getService(serviceReference);
            if (iSDISBlockingService != null) {
                TVSDISActivator.this.log.log(10000000, "[TVSDISActivator.BlockingServiceTracker.addingService] Blocking service registered.");
                ((TVSDISActivator)TVSDISActivator.this).asiProvider.parentalEnforcement.setService(iSDISBlockingService);
                return iSDISBlockingService;
            }
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            ((TVSDISActivator)TVSDISActivator.this).asiProvider.parentalEnforcement.setService(new NullSDISBlockingService());
            TVSDISActivator.this.bundleContext.ungetService(serviceReference);
        }
    }

    private class InterappServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private InterappServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            TVSDISActivator.this.log.log(1000000, "InterappServiceTracker#addingService( %1 )", (Object)serviceReference);
            boolean bl = false;
            Object object = TVSDISActivator.this.bundleContext.getService(serviceReference);
            if (object instanceof ITVInterappService) {
                TVSDISActivator.this.log.log(10000000, "[TVSDISActivator.InterappServiceTracker.addingService] TV interapp service registered.");
                TVSDISActivator.this.asiProvider.setTVInterappService((ITVInterappService)object);
                bl = true;
            }
            return bl ? serviceReference : null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TVSDISActivator.this.log.log(1000000, "InterappServiceTracker#removedService( %1, %2 )", (Object)serviceReference, object);
            if (object instanceof ITVInterappService) {
                TVSDISActivator.this.asiProvider.setTVInterappService(new NullTVInterappService());
            }
            TVSDISActivator.this.bundleContext.ungetService(serviceReference);
        }
    }
}

