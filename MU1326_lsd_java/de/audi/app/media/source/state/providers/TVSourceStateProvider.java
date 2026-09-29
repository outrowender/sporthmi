/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.osgi.IServiceTracker;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.TVSourceStateProvider$1;
import de.audi.app.media.source.state.providers.TVSourceStateProvider$2;
import de.audi.app.media.source.state.providers.TVSourceStateProvider$3;
import de.audi.app.media.source.state.providers.TVSourceStateProvider$4;
import de.audi.atip.interapp.tv.ITVService;
import de.audi.atip.interapp.tv.ITVStateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class TVSourceStateProvider
implements ITVStateListener,
IDiagnosisCommandProvider {
    private static final String LOGCLASS;
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
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$tv$ITVService == null ? (class$de$audi$atip$interapp$tv$ITVService = TVSourceStateProvider.class$("de.audi.atip.interapp.tv.ITVService")) : class$de$audi$atip$interapp$tv$ITVService, new TVSourceStateProvider$1(this));
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"TVSourceStateProvider");
        this.serviceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$tv$ITVStateListener == null ? (class$de$audi$atip$interapp$tv$ITVStateListener = TVSourceStateProvider.class$("de.audi.atip.interapp.tv.ITVStateListener")) : class$de$audi$atip$interapp$tv$ITVStateListener, this, new Hashtable(0));
        this.serviceTracker.open();
        this.diagnosisManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"TVSourceStateProvider");
        this.serviceTracker.close();
        this.serviceManager.unregisterService(this.serviceRegistration);
    }

    protected void updateTVService(ITVService iTVService) {
        this.dispatcher.execute(new TVSourceStateProvider$2(this, "TVSourceStateProvider.updateTVService", iTVService));
    }

    @Override
    public void updateState(int n, int[] nArray) {
        this.dispatcher.execute(new TVSourceStateProvider$3(this, "TVSourceStateProvider.updateState", n, nArray));
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"updateState", "updateTVService"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("updateState".equals(string)) {
            int[] nArray = stringArray.length > 2 ? new int[]{Integer.parseInt(stringArray[1]), Integer.parseInt(stringArray[2])} : new int[]{Integer.parseInt(stringArray[1])};
            this.updateState(Integer.parseInt(stringArray[0]), nArray);
        } else if ("updateTVService".equals(string)) {
            this.updateTVService(new TVSourceStateProvider$4(this));
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

    static /* synthetic */ LogChannel access$000(TVSourceStateProvider tVSourceStateProvider) {
        return tVSourceStateProvider.logger;
    }

    static /* synthetic */ IServiceManager access$100(TVSourceStateProvider tVSourceStateProvider) {
        return tVSourceStateProvider.serviceManager;
    }

    static /* synthetic */ ISourceStateUpdater access$200(TVSourceStateProvider tVSourceStateProvider) {
        return tVSourceStateProvider.updater;
    }
}

