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
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineApplicationOtherContext;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.interapp.online.TransitionCallback;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import org.dsi.ifc.global.NavLocation;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class OnlineServicesStateProvider
implements IRemoteHMIMediaOnlineServiceListener {
    private static final String LOGCLASS = "OnlineServicesStateProvider";
    private final IServiceManager serviceManager;
    private final DispatcherBase dispatcher;
    private final LogChannel logger;
    private final ISourceStateUpdater updater;
    private final IDiagnosisManager diagnosisManager;
    private final IServiceTracker serviceTracker;
    private ServiceRegistration serviceRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$OnlineServiceProvider;
    static /* synthetic */ Class class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener;

    public OnlineServicesStateProvider(LogChannel logChannel, IServiceManager iServiceManager, ISourceStateUpdater iSourceStateUpdater, DispatcherBase dispatcherBase, IDiagnosisManager iDiagnosisManager) {
        this.logger = logChannel;
        this.serviceManager = iServiceManager;
        this.dispatcher = dispatcherBase;
        this.updater = iSourceStateUpdater;
        this.diagnosisManager = iDiagnosisManager;
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = OnlineServicesStateProvider.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider, new ServiceTrackerCustomizer(){

            public Object addingService(ServiceReference serviceReference) {
                OnlineServicesStateProvider.this.logger.log(1000000, "[%1.addingService]", (Object)OnlineServicesStateProvider.LOGCLASS);
                OnlineServiceProvider onlineServiceProvider = (OnlineServiceProvider)OnlineServicesStateProvider.this.serviceManager.getService(serviceReference);
                OnlineServicesStateProvider.this.updateRemoteHMIService(onlineServiceProvider);
                return onlineServiceProvider;
            }

            public void removedService(ServiceReference serviceReference, Object object) {
                OnlineServicesStateProvider.this.serviceManager.releaseService(serviceReference);
                OnlineServicesStateProvider.this.updateRemoteHMIService(null);
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }
        });
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener = OnlineServicesStateProvider.class$("de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener")) : class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener, this, new Hashtable(0));
        this.serviceTracker.open();
        this.diagnosisManager.addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"OnlineServiceStateProvider.updateOnlineServices", "OnlineServiceStateProvider.addRemoteHMIService", "OnlineServiceStateProvider.clearOnlineServiceList", "OnlineServiceStateProvider.removeRHMIDevice", "OnlineServiceStateProvider.updateLastIndex"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                if ("OnlineServiceStateProvider.updateOnlineServices".equals(string)) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new OnlineApplicationOtherContext(){

                        public String getAppName() {
                            return "Napster";
                        }

                        public String getAppContext() {
                            return "Napster";
                        }

                        public String getSourceListIconActive() {
                            return null;
                        }

                        public String getSourceListIconInactive() {
                            return null;
                        }

                        public String getSourceListIconReflection() {
                            return null;
                        }

                        public String getCaptionIcon() {
                            return null;
                        }

                        public String getLoadingIcon() {
                            return null;
                        }

                        public boolean isEnabled() {
                            return true;
                        }

                        public int getEntryPointId() {
                            return 12346;
                        }

                        public String getSubEntryPoint() {
                            return null;
                        }
                    });
                    arrayList.add(new OnlineApplicationOtherContext(){

                        public String getAppName() {
                            return "Pandora";
                        }

                        public String getAppContext() {
                            return "Pandora";
                        }

                        public String getSourceListIconActive() {
                            return null;
                        }

                        public String getSourceListIconInactive() {
                            return null;
                        }

                        public String getSourceListIconReflection() {
                            return null;
                        }

                        public String getCaptionIcon() {
                            return null;
                        }

                        public String getLoadingIcon() {
                            return null;
                        }

                        public boolean isEnabled() {
                            return false;
                        }

                        public int getEntryPointId() {
                            return 12345;
                        }

                        public String getSubEntryPoint() {
                            return null;
                        }
                    });
                    OnlineServicesStateProvider.this.updateOnlineServices(arrayList);
                } else if ("OnlineServiceStateProvider.addRemoteHMIService".equals(string)) {
                    OnlineServicesStateProvider.this.updateRemoteHMIService(new OnlineServiceProvider(){

                        public void startMediaApp(String string, boolean bl) {
                        }

                        public void stopMediaApp(String string) {
                        }

                        public void startDestinationApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
                        }

                        public void startMapApp(NavLocation navLocation, String string, TransitionCallback transitionCallback) {
                        }

                        public void downloadAppListForNavi() {
                        }

                        public void stopPhoneApp(String string) {
                        }

                        public void startPhoneApp(String string, boolean bl) {
                        }
                    });
                } else if ("OnlineServiceStateProvider.updateLastIndex".equals(string)) {
                    OnlineServicesStateProvider.this.updateLastActiveOnlineService(0);
                } else if ("OnlineServiceStateProvider.clearOnlineServiceList".equals(string)) {
                    OnlineServicesStateProvider.this.updateOnlineServices(new ArrayList(0));
                } else if ("OnlineServiceStateProvider.removeRHMIDevice".equals(string)) {
                    OnlineServicesStateProvider.this.updateOnlineServices(null);
                }
            }
        });
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.serviceTracker.close();
        this.serviceManager.unregisterService(this.serviceRegistration);
    }

    private void updateRemoteHMIService(final OnlineServiceProvider onlineServiceProvider) {
        this.dispatcher.execute(new AbstractDispatcherRunnable("OnlinePlayerSource.updateRemoteHMIService"){

            public void run() {
                OnlineServicesStateProvider.this.logger.log(1000000, "[%1.updateRemoteHMIService] '%2'", (Object)OnlineServicesStateProvider.LOGCLASS, (Object)onlineServiceProvider);
                OnlineServicesStateProvider.this.updater.updateSourceState(new SourceStateUpdate(9, onlineServiceProvider));
            }
        });
    }

    public void updateOnlineServices(final List list) {
        this.logger.log(1000000, "[%1.updateOnlineServices] '%2'", (Object)LOGCLASS, (Object)list);
        this.dispatcher.execute(new AbstractDispatcherRunnable("OnlineServicesStateProvider.updateOnlineServices"){

            public void run() {
                OnlineServicesStateProvider.this.updater.updateSourceState(new SourceStateUpdate(8, list));
            }
        });
    }

    public void updateLastActiveOnlineService(final int n) {
        this.logger.log(1000000, "[%1.updateLastActiveOnlineService] '%2'", (Object)LOGCLASS, (long)n);
        this.dispatcher.execute(new AbstractDispatcherRunnable("OnlineServicesStateProvider.updateLastActiveOnlineService"){

            public void run() {
                OnlineServicesStateProvider.this.updater.updateSourceState(new SourceStateUpdate(11, new Integer(n)));
            }
        });
    }

    public void updateDeviceAppState(final boolean bl) {
        this.logger.log(1000000, "[%1.updateLastActiveOnlineService] '%2'", (Object)LOGCLASS, (Object)String.valueOf(bl));
        this.dispatcher.execute(new AbstractDispatcherRunnable("OnlineServicesStateProvider.updateDeviceAppState"){

            public void run() {
                OnlineServicesStateProvider.this.updater.updateSourceState(new SourceStateUpdate(13, bl));
            }
        });
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

