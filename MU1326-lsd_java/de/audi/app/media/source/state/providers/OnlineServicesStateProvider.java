/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$1;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$2;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$3;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$4;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$5;
import de.audi.app.media.source.state.providers.OnlineServicesStateProvider$6;
import de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener;
import de.audi.atip.interapp.online.OnlineServiceProvider;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import java.util.List;
import org.osgi.framework.ServiceRegistration;

public class OnlineServicesStateProvider
implements IRemoteHMIMediaOnlineServiceListener {
    private static final String LOGCLASS;
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
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$online$OnlineServiceProvider == null ? (class$de$audi$atip$interapp$online$OnlineServiceProvider = OnlineServicesStateProvider.class$("de.audi.atip.interapp.online.OnlineServiceProvider")) : class$de$audi$atip$interapp$online$OnlineServiceProvider, new OnlineServicesStateProvider$1(this));
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"OnlineServicesStateProvider");
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener == null ? (class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener = OnlineServicesStateProvider.class$("de.audi.atip.interapp.online.IRemoteHMIMediaOnlineServiceListener")) : class$de$audi$atip$interapp$online$IRemoteHMIMediaOnlineServiceListener, this, new Hashtable(0));
        this.serviceTracker.open();
        this.diagnosisManager.addCommandProvider(-1, new OnlineServicesStateProvider$2(this));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"OnlineServicesStateProvider");
        this.serviceTracker.close();
        this.serviceManager.unregisterService(this.serviceRegistration);
    }

    private void updateRemoteHMIService(OnlineServiceProvider onlineServiceProvider) {
        this.dispatcher.execute(new OnlineServicesStateProvider$3(this, "OnlinePlayerSource.updateRemoteHMIService", onlineServiceProvider));
    }

    @Override
    public void updateOnlineServices(List list) {
        this.logger.log(1078071040, "[%1.updateOnlineServices] '%2'", (Object)"OnlineServicesStateProvider", (Object)list);
        this.dispatcher.execute(new OnlineServicesStateProvider$4(this, "OnlineServicesStateProvider.updateOnlineServices", list));
    }

    @Override
    public void updateLastActiveOnlineService(int n) {
        this.logger.log(1078071040, "[%1.updateLastActiveOnlineService] '%2'", (Object)"OnlineServicesStateProvider", (long)n);
        this.dispatcher.execute(new OnlineServicesStateProvider$5(this, "OnlineServicesStateProvider.updateLastActiveOnlineService", n));
    }

    @Override
    public void updateDeviceAppState(boolean bl) {
        this.logger.log(1078071040, "[%1.updateLastActiveOnlineService] '%2'", (Object)"OnlineServicesStateProvider", (Object)String.valueOf(bl));
        this.dispatcher.execute(new OnlineServicesStateProvider$6(this, "OnlineServicesStateProvider.updateDeviceAppState", bl));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ LogChannel access$000(OnlineServicesStateProvider onlineServicesStateProvider) {
        return onlineServicesStateProvider.logger;
    }

    static /* synthetic */ IServiceManager access$100(OnlineServicesStateProvider onlineServicesStateProvider) {
        return onlineServicesStateProvider.serviceManager;
    }

    static /* synthetic */ void access$200(OnlineServicesStateProvider onlineServicesStateProvider, OnlineServiceProvider onlineServiceProvider) {
        onlineServicesStateProvider.updateRemoteHMIService(onlineServiceProvider);
    }

    static /* synthetic */ ISourceStateUpdater access$300(OnlineServicesStateProvider onlineServicesStateProvider) {
        return onlineServicesStateProvider.updater;
    }
}

