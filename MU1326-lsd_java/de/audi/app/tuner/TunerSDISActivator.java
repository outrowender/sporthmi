/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.tuner;

import de.audi.app.tuner.TunerSDISActivator$BlockingServiceTracker;
import de.audi.app.tuner.TunerSDISActivator$MyServiceTracker;
import de.audi.app.tuner.sdis.TunerASIProvider;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TunerSDISActivator
extends AbstractActivator {
    private ServiceTracker trackerInterAppService;
    private ServiceTracker trackerBlockingService;
    TunerASIProvider asiProvider;
    private LogChannel log = NullLogChannel.getInstance();
    static /* synthetic */ Class class$de$audi$tuner$ifc$IRadioInterappService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingService;
    static /* synthetic */ Class class$de$audi$tuner$ifc$IRadioInterappListener;
    static /* synthetic */ Class class$de$audi$atip$interapp$sdis$ISDISBlockingListener;
    static /* synthetic */ Class class$de$audi$atip$agent$IASIProvider;

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.Tuner.SDIS");
        this.asiProvider = new TunerASIProvider(this.log, 0);
        this.trackerInterAppService = new ServiceTracker(bundleContext, new String[]{(class$de$audi$tuner$ifc$IRadioInterappService == null ? (class$de$audi$tuner$ifc$IRadioInterappService = TunerSDISActivator.class$("de.audi.tuner.ifc.IRadioInterappService")) : class$de$audi$tuner$ifc$IRadioInterappService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = TunerSDISActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)new TunerSDISActivator$MyServiceTracker(this, null));
        this.trackerInterAppService.open();
        this.trackerBlockingService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = TunerSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName(), (ServiceTrackerCustomizer)new TunerSDISActivator$BlockingServiceTracker(this, null));
        this.trackerBlockingService.open();
        this.registerService((class$de$audi$tuner$ifc$IRadioInterappListener == null ? (class$de$audi$tuner$ifc$IRadioInterappListener = TunerSDISActivator.class$("de.audi.tuner.ifc.IRadioInterappListener")) : class$de$audi$tuner$ifc$IRadioInterappListener).getName(), (Object)this.asiProvider.radioInterappListener, null);
        this.registerService((class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = TunerSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (Object)this.asiProvider.blockingListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = TunerSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiProvider, null);
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

    static /* synthetic */ BundleContext access$200(TunerSDISActivator tunerSDISActivator) {
        return tunerSDISActivator.bundleContext;
    }

    static /* synthetic */ BundleContext access$300(TunerSDISActivator tunerSDISActivator) {
        return tunerSDISActivator.bundleContext;
    }

    static /* synthetic */ LogChannel access$400(TunerSDISActivator tunerSDISActivator) {
        return tunerSDISActivator.log;
    }

    static /* synthetic */ BundleContext access$500(TunerSDISActivator tunerSDISActivator) {
        return tunerSDISActivator.bundleContext;
    }
}

