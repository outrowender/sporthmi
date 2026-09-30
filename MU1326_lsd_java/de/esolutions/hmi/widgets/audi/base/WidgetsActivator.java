/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base;

import de.audi.atip.activator.AbstractActivator;
import de.audi.atip.activator.FrameworkException;
import de.audi.atip.diag.sw.SwDiagnosisManager;
import de.audi.atip.hmi.KbdService;
import de.audi.atip.interapp.SDSService;
import de.audi.atip.interapp.tts.TTSService;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.hmi.evo.IHMIServiceEvo;
import de.esolutions.hmi.widgets.audi.base.AbstractWidget;
import de.esolutions.hmi.widgets.audi.base.IWidgetLogChannel;
import de.esolutions.hmi.widgets.audi.base.WordPredictionServiceTracker;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public abstract class WidgetsActivator
extends AbstractActivator {
    private static final boolean DEBUG = false;
    private static final String LOG_CH_BENCHMARK = "Ext.Benchmark";
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
        if (this.logChBenchmark != null && this.logChBenchmark.getCurrentLogThreshold() >= 1000000) {
            this.logChBenchmark.log(1000000, "Bundle: %1 %2 Timestamp: %3 ", (Object)this.getName(), (Object)string, this.framework.getMonotonicTime());
        }
    }

    public void start(BundleContext bundleContext) {
        super.start(bundleContext);
        this.logChBenchmark = this.framework.getLogChannel(LOG_CH_BENCHMARK);
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

    private void initializeTTSServiceTracker(final KbdService kbdService) {
        this.serviceTracker = new ServiceTracker(this.getBundleContext(), new String[]{(class$de$audi$atip$interapp$tts$TTSService == null ? (class$de$audi$atip$interapp$tts$TTSService = WidgetsActivator.class$("de.audi.atip.interapp.tts.TTSService")) : class$de$audi$atip$interapp$tts$TTSService).getName(), (class$de$audi$atip$diag$sw$SwDiagnosisManager == null ? (class$de$audi$atip$diag$sw$SwDiagnosisManager = WidgetsActivator.class$("de.audi.atip.diag.sw.SwDiagnosisManager")) : class$de$audi$atip$diag$sw$SwDiagnosisManager).getName()}, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                Object object = WidgetsActivator.this.getBundleContext().getService(serviceReference);
                if (object instanceof TTSService) {
                    if (kbdService != null && kbdService.isTouchKeypanel()) {
                        Integer n = (Integer)serviceReference.getProperty("TTS_CLIENT_ID");
                        if (n == 0) {
                            TTSSessionBasedService tTSSessionBasedService = (TTSSessionBasedService)object;
                            WidgetsActivator.this.framework.getHMITerminalRegistry().setTTSService(tTSSessionBasedService);
                            return object;
                        }
                    } else {
                        WidgetsActivator.this.framework.getLogChannel("Fw.Widgets.TouchPad.Keypanel").log(1000000, "WidgetsActivator#initializeTTSServiceTracker#addingService keypanel is no touch keypanel - ignore tts service registration");
                    }
                } else if (object instanceof SwDiagnosisManager) {
                    WidgetsActivator.this.registerDiagnosisGateways((SwDiagnosisManager)object);
                    return object;
                }
                WidgetsActivator.this.getBundleContext().ungetService(serviceReference);
                return object;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                if (object instanceof TTSService) {
                    if (object instanceof TTSSessionBasedService) {
                        ((TTSSessionBasedService)object).stopSession();
                    }
                    WidgetsActivator.this.framework.getHMITerminalRegistry().setTTSService(null);
                } else if (object instanceof SwDiagnosisManager) {
                    WidgetsActivator.this.unregisterDiagnosisGateways((SwDiagnosisManager)object);
                }
            }
        });
        this.serviceTracker.open();
    }

    private void initializeSDSServiceTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$interapp$SDSService == null ? (class$de$audi$atip$interapp$SDSService = WidgetsActivator.class$("de.audi.atip.interapp.SDSService")) : class$de$audi$atip$interapp$SDSService).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                WidgetsActivator.this.sdsService = (SDSService)WidgetsActivator.this.getBundleContext().getService(serviceReference);
                AbstractWidget.setSDSService(WidgetsActivator.this.sdsService);
                return WidgetsActivator.this.sdsService;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                WidgetsActivator.this.sdsService = null;
                AbstractWidget.setSDSService(WidgetsActivator.this.sdsService);
            }
        });
        serviceTracker.open();
    }

    private void initializeHMIServiceTracker() {
        ServiceTracker serviceTracker = new ServiceTracker(this.getBundleContext(), (class$de$audi$atip$hmi$HMIService == null ? (class$de$audi$atip$hmi$HMIService = WidgetsActivator.class$("de.audi.atip.hmi.HMIService")) : class$de$audi$atip$hmi$HMIService).getName(), new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                IHMIServiceEvo iHMIServiceEvo = (IHMIServiceEvo)WidgetsActivator.this.getBundleContext().getService(serviceReference);
                WidgetsActivator.this.hmiServiceAdded(iHMIServiceEvo);
                return iHMIServiceEvo;
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public void removedService(ServiceReference serviceReference, Object object) {
            }
        });
        serviceTracker.open();
    }

    protected void hmiServiceAdded(IHMIServiceEvo iHMIServiceEvo) {
        AbstractWidget.setHMIService(iHMIServiceEvo);
    }

    protected void hmiServiceRemoved() {
        AbstractWidget.setHMIService(null);
    }

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

    protected abstract void registerTerminals(KbdService var1);

    protected abstract void registerDiagnosisGateways(SwDiagnosisManager var1);

    protected abstract void unregisterDiagnosisGateways(SwDiagnosisManager var1);

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

