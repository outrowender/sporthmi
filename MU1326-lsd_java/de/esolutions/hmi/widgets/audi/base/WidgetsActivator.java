/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.activator.FrameworkException;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator$1;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator$2;
import de.esolutions.hmi.widgets.audi.base.WidgetsActivator$3;
import de.esolutions.hmi.widgets.audi.base.WordPredictionServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class WidgetsActivator
extends AbstractActivator {
    private static final boolean DEBUG;
    private static final String LOG_CH_BENCHMARK;
    private LogChannel logChBenchmark = null;
    protected KbdService[] kbdServices = new KbdService[8];
    private SDSService sdsService;
    private ServiceTracker serviceTracker;
    private WordPredictionServiceTracker wptracker;
    static /* synthetic */ Class class$de$audi$atip$hmi$KbdService;
    static /* synthetic */ Class class$de$audi$atip$interapp$tts$TTSService;
    static /* synthetic */ Class class$de$audi$atip$diag$sw$SwDiagnosisManager;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDSService;
    static /* synthetic */ Class class$de$audi$atip$hmi$HMIService;

    public void logTimestamp(String string) {
        if (this.logChBenchmark != null && this.logChBenchmark.getCurrentLogThreshold() >= 1078071040) {
            this.logChBenchmark.log(1078071040, "Bundle: %1 %2 Timestamp: %3 ", (Object)this.getName(), (Object)string, this.framework.getMonotonicTime());
        }
    }

    @Override
    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChBenchmark = this.framework.getLogChannel("Ext.Benchmark");
        AbstractWidget.widgetsActivator = this;
        AbstractWidget.setFrameworkAccess(this.framework);
        KbdService kbdService = null;
        ServiceReference serviceReference = bundleContext.getServiceReference((class$de$audi$atip$hmi$KbdService == null ? (class$de$audi$atip$hmi$KbdService = WidgetsActivator.class$("de.audi.atip.hmi.KbdService")) : class$de$audi$atip$hmi$KbdService).getName());
        if (serviceReference != null) {
            kbdService = (KbdService)bundleContext.getService(serviceReference);
        }
        if (kbdService == null) {
            throw new FrameworkException("No key board service available! Widget initialization has been aborted!");
        }
        this.initializeTracker(kbdService);
        this.registerTerminals(kbdService);
    }

    protected void initializeTracker(KbdService kbdService) {
        this.initializeHMIServiceTracker();
        this.initializeSDSServiceTracker();
        this.initializeTTSServiceTracker(kbdService);
        this.initializeWordPredictionTracker();
    }

    private void initializeWordPredictionTracker() {
        this.wptracker = new WordPredictionServiceTracker(this.getBundleContext(), IWidgetLogChannel.logWidgetStartup);
        this.wptracker.startTracking();
    }

    private void initializeTTSServiceTracker(KbdService kbdService) {
        this.serviceTracker = new ServiceTracker(this.getBundleContext(), new String[]{(class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = WidgetsActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = WidgetsActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, (ServiceTrackerCustomizer)new WidgetsActivator$1(this, kbdService));
        this.serviceTracker.open();
    }

    private void initializeSDSServiceTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = WidgetsActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), (ServiceTrackerCustomizer)new WidgetsActivator$2(this));
        serviceTracker.open();
    }

    private void initializeHMIServiceTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$hmi$HMIService == null ? (class$de$audi$atip$hmi$HMIService = WidgetsActivator.class$("de.audi.atip.hmi.HMIService")) : class$de$audi$atip$hmi$HMIService).getName(), (ServiceTrackerCustomizer)new WidgetsActivator$3(this));
        serviceTracker.open();
    }

    protected void hmiServiceAdded(IHMIServiceEvo iHMIServiceEvo) {
        AbstractWidget.setHMIService(iHMIServiceEvo);
    }

    protected void hmiServiceRemoved() {
        AbstractWidget.setHMIService(null);
    }

    @Override
    public void stop(BundleContext bundleContext) {
        this.sdsService = null;
        if (this.wptracker != null) {
            this.wptracker.stopTracking();
        }
        if (this.serviceTracker != null) {
            this.serviceTracker.close();
        }
        this.framework.getHMITerminalRegistry().setTTSService(null);
        this.logChBenchmark = null;
        super.stop(bundleContext);
    }

    protected abstract void registerTerminals(KbdService kbdService) {
    }

    protected abstract void registerDiagnosisGateways(SwDiagnosisManager swDiagnosisManager) {
    }

    protected abstract void unregisterDiagnosisGateways(SwDiagnosisManager swDiagnosisManager) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ IFrameworkAccess access$000(WidgetsActivator widgetsActivator) {
        return widgetsActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$100(WidgetsActivator widgetsActivator) {
        return widgetsActivator.framework;
    }

    static /* synthetic */ IFrameworkAccess access$200(WidgetsActivator widgetsActivator) {
        return widgetsActivator.framework;
    }

    static /* synthetic */ SDSService access$302(WidgetsActivator widgetsActivator, SDSService sDSService) {
        widgetsActivator.sdsService = sDSService;
        return widgetsActivator.sdsService;
    }

    static /* synthetic */ SDSService access$300(WidgetsActivator widgetsActivator) {
        return widgetsActivator.sdsService;
    }
}

