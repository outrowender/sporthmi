/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.atip.interapp.media.IMediaDrawerContext;
import de.audi.atip.interapp.tv.ITVService;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.util.Util;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.HashMap;
import java.util.Hashtable;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class TVSourceStateProvider
implements ITVStateListener,
IDiagnosisCommandProvider {
    private static final String LOGCLASS = "TVSourceStateProvider";
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final DispatcherBase dispatcher;
    private final ISourceStateUpdater updater;
    private final IDiagnosisManager diagnosisManager;
    private final IServiceTracker serviceTracker;
    private ServiceRegistration serviceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVService;
    static /* synthetic */ Class class$de$audi$atip$interapp$tv$ITVStateListener;

    public TVSourceStateProvider(LogChannel logChannel, ISourceStateUpdater iSourceStateUpdater, IServiceManager iServiceManager, DispatcherBase dispatcherBase, IDiagnosisManager iDiagnosisManager) {
        this.serviceManager = iServiceManager;
        this.dispatcher = dispatcherBase;
        this.logger = logChannel;
        this.diagnosisManager = iDiagnosisManager;
        this.updater = iSourceStateUpdater;
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$tv$ITVService == null ? (class$de$audi$atip$interapp$tv$ITVService = TVSourceStateProvider.class$("de.audi.atip.interapp.tv.ITVService")) : class$de$audi$atip$interapp$tv$ITVService, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                TVSourceStateProvider.this.logger.log(1000000, "[%1.addingService]", (Object)TVSourceStateProvider.LOGCLASS);
                ITVService iTVService = (ITVService)TVSourceStateProvider.this.serviceManager.getService(serviceReference);
                TVSourceStateProvider.this.updateTVService(iTVService);
                return iTVService;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                TVSourceStateProvider.this.logger.log(1000000, "[%1.removedService]", (Object)TVSourceStateProvider.LOGCLASS);
                TVSourceStateProvider.this.serviceManager.releaseService(serviceReference);
                TVSourceStateProvider.this.updateTVService(null);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = TVSourceStateProvider.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener, this, new Hashtable(0));
        this.serviceTracker.open();
        this.diagnosisManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceTracker.close();
        this.serviceManager.unregisterService(this.serviceRegistration);
    }

    protected void updateTVService(final ITVService iTVService) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TVSourceStateProvider.updateTVService"){

            public void run() {
                TVSourceStateProvider.this.logger.log(1000000, "[%1.updateTVService]", (Object)TVSourceStateProvider.LOGCLASS);
                TVSourceStateProvider.this.updater.updateSourceState(new SourceStateUpdate(10, iTVService));
            }
        });
    }

    public void updateState(final int n, final int[] nArray) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("TVSourceStateProvider.updateState"){

            public void run() {
                TVSourceStateProvider.this.logger.log(1000000, "[%1.updateState] %2", (Object)TVSourceStateProvider.LOGCLASS, (Object)(0 == n ? "READY" : "NOT READY"));
                if (nArray != null) {
                    HashMap hashMap = new HashMap(nArray.length);
                    block4: for (int i2 = 0; i2 < nArray.length; ++i2) {
                        switch (nArray[i2]) {
                            case 1: {
                                hashMap.put(Util.createInteger(8), 0 == n ? Boolean.TRUE : Boolean.FALSE);
                                continue block4;
                            }
                            case 0: {
                                hashMap.put(Util.createInteger(7), 0 == n ? Boolean.TRUE : Boolean.FALSE);
                                continue block4;
                            }
                            default: {
                                TVSourceStateProvider.this.logger.log(1000000, "[%1.updateState] Unknown source '%2'", (Object)TVSourceStateProvider.LOGCLASS, (long)n);
                            }
                        }
                    }
                    if (!hashMap.isEmpty()) {
                        TVSourceStateProvider.this.updater.updateSourceAvailability(12, hashMap);
                    }
                }
            }
        });
    }

    public String[] getDiagKeys() {
        return new String[]{"updateState", "updateTVService"};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if ("updateState".equals(string)) {
            int[] nArray = stringArray.length > 2 ? new int[]{Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2])} : new int[]{Integer.parseInt(stringArray[1])};
            this.updateState(Integer.parseInt(stringArray[0]), nArray);
        } else if ("updateTVService".equals(string)) {
            this.updateTVService(new ITVService(){

                public void deactivate() {
                    TVSourceStateProvider.this.logger.log(1000000, "[ITVService.deactivate]");
                }

                public void activate(int n, IMediaDrawerContext iMediaDrawerContext) {
                    TVSourceStateProvider.this.logger.log(1000000, "[ITVService.activate]");
                }
            });
        }
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

