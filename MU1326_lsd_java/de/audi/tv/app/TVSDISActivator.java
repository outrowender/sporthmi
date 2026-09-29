/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.tv.app.TVSDISActivator$BlockingServiceTracker;
import de.audi.tv.app.TVSDISActivator$InterappServiceTracker;
import de.audi.tv.app.sdis.TVASIProvider;
import org.osgi.framework.BundleContext;
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

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.TV.SDIS");
        this.asiProvider = new TVASIProvider(this.log, 0);
        this.trackerInterAppService = new ServiceTracker(bundleContext, (class$de$audi$tv$app$interapp$ITVInterappService == null ? (class$de$audi$tv$app$interapp$ITVInterappService = TVSDISActivator.class$("de.audi.tv.app.interapp.ITVInterappService")) : class$de$audi$tv$app$interapp$ITVInterappService).getName(), (ServiceTrackerCustomizer)new TVSDISActivator$InterappServiceTracker(this, null));
        this.trackerInterAppService.open();
        this.trackerBlockingService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = TVSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName(), (ServiceTrackerCustomizer)new TVSDISActivator$BlockingServiceTracker(this, null));
        this.trackerBlockingService.open();
        this.registerService((class$de$audi$tv$app$interapp$ITVInterappListener == null ? (class$de$audi$tv$app$interapp$ITVInterappListener = TVSDISActivator.class$("de.audi.tv.app.interapp.ITVInterappListener")) : class$de$audi$tv$app$interapp$ITVInterappListener).getName(), (Object)this.asiProvider.tvInterappListener, null);
        this.registerService((class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = TVSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (Object)this.asiProvider.blockingListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = TVSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiProvider, null);
        this.log.log(1078071040, "[TVSDISActivator.start] TV-SDIS package started");
    }

    @Override
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

    static /* synthetic */ BundleContext access$200(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.bundleContext;
    }

    static /* synthetic */ LogChannel access$300(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.log;
    }

    static /* synthetic */ TVASIProvider access$400(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.asiProvider;
    }

    static /* synthetic */ BundleContext access$500(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$600(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$700(TVSDISActivator tVSDISActivator) {
        return tVSDISActivator.bundleContext;
    }
}

