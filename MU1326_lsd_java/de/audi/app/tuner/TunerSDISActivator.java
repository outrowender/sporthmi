/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.mib.swdiagnosis.sdis.TunerSDISDiag
 */
package de.audi.app.tuner;

import de.audi.app.tuner.sdis.NullSDISBlockingService;
import de.audi.app.tuner.sdis.TunerASIProvider;
import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.diag.sw.AbstractSwDiagnosis;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.interapp.def.DefaultServiceTrackerCustomizer;
import de.audi.atip.interapp.sdis.ISDISBlockingService;
import de.audi.atip.log.LogChannel;
import de.audi.atip.log.NullLogChannel;
import de.audi.tuner.ifc.IRadioInterappService;
import de.audi.tuner.ifc.NullRadioInterappService;
import de.mib.swdiagnosis.sdis.TunerSDISDiag;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
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

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.log = this.getFramework().getLogChannel("App.Tuner.SDIS");
        this.asiProvider = new TunerASIProvider(this.log, 0);
        this.trackerInterAppService = new ServiceTracker(bundleContext, new String[]{(class$de$audi$tuner$ifc$IRadioInterappService == null ? (class$de$audi$tuner$ifc$IRadioInterappService = TunerSDISActivator.class$("de.audi.tuner.ifc.IRadioInterappService")) : class$de$audi$tuner$ifc$IRadioInterappService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = TunerSDISActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)new MyServiceTracker());
        this.trackerInterAppService.open();
        this.trackerBlockingService = new ServiceTracker(this.bundleContext, (class$de$audi$atip$interapp$sdis$ISDISBlockingService == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingService = TunerSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingService")) : class$de$audi$atip$interapp$sdis$ISDISBlockingService).getName(), (ServiceTrackerCustomizer)new BlockingServiceTracker());
        this.trackerBlockingService.open();
        this.registerService((class$de$audi$tuner$ifc$IRadioInterappListener == null ? (class$de$audi$tuner$ifc$IRadioInterappListener = TunerSDISActivator.class$("de.audi.tuner.ifc.IRadioInterappListener")) : class$de$audi$tuner$ifc$IRadioInterappListener).getName(), (Object)this.asiProvider.radioInterappListener, null);
        this.registerService((class$de$audi$atip$interapp$sdis$ISDISBlockingListener == null ? (class$de$audi$atip$interapp$sdis$ISDISBlockingListener = TunerSDISActivator.class$("de.audi.atip.interapp.sdis.ISDISBlockingListener")) : class$de$audi$atip$interapp$sdis$ISDISBlockingListener).getName(), (Object)this.asiProvider.blockingListener, null);
        this.registerService((class$de$audi$atip$agent$IASIProvider == null ? (class$de$audi$atip$agent$IASIProvider = TunerSDISActivator.class$("de.audi.atip.agent.IASIProvider")) : class$de$audi$atip$agent$IASIProvider).getName(), (Object)this.asiProvider, null);
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

    private class MyServiceTracker
    implements ServiceTrackerCustomizer {
        private MyServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            TunerSDISActivator.this.log.log(1000000, "MyServiceTracker#addingService( %1 )", (Object)serviceReference);
            boolean bl = false;
            Object object = TunerSDISActivator.this.bundleContext.getService(serviceReference);
            if (object instanceof IRadioInterappService) {
                TunerSDISActivator.this.asiProvider.setRadioInterappService((IRadioInterappService)object);
                bl = true;
            } else if (object instanceof SwDiagnosisManager) {
                ((SwDiagnosisManager)object).addDiagGateway((AbstractSwDiagnosis)new TunerSDISDiag(TunerSDISActivator.this.asiProvider));
                bl = true;
            }
            return bl ? serviceReference : null;
        }

        public void modifiedService(ServiceReference serviceReference, Object object) {
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TunerSDISActivator.this.log.log(1000000, "MyServiceTracker#removedService( %1, %2 )", (Object)serviceReference, object);
            if (object instanceof IRadioInterappService) {
                TunerSDISActivator.this.asiProvider.setRadioInterappService(new NullRadioInterappService(TunerSDISActivator.this.log));
            }
        }
    }

    private class BlockingServiceTracker
    extends DefaultServiceTrackerCustomizer {
        private BlockingServiceTracker() {
        }

        public Object addingService(ServiceReference serviceReference) {
            ISDISBlockingService iSDISBlockingService = (ISDISBlockingService)TunerSDISActivator.this.bundleContext.getService(serviceReference);
            if (iSDISBlockingService != null) {
                TunerSDISActivator.this.asiProvider.parentalEnforcement.setService(iSDISBlockingService);
                return iSDISBlockingService;
            }
            return null;
        }

        public void removedService(ServiceReference serviceReference, Object object) {
            TunerSDISActivator.this.asiProvider.parentalEnforcement.setService(new NullSDISBlockingService());
            TunerSDISActivator.this.bundleContext.ungetService(serviceReference);
        }
    }
}

