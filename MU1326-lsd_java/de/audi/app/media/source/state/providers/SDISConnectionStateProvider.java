/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.SDISConnectionStateProvider$1;
import de.audi.app.media.source.state.providers.SDISConnectionStateProvider$2;
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class SDISConnectionStateProvider
implements SDISConnectionStateListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IDiagnosisManager diagnosisManager;
    private final ISourceStateUpdater sourceStateUpdater;
    private final DispatcherBase dispatcher;
    private volatile ServiceRegistration sdisListenerServiceRegistration;
    private boolean lastSDISConnectedState = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$SDISConnectionStateListener;

    public SDISConnectionStateProvider(LogChannel logChannel, IServiceManager iServiceManager, ISourceStateUpdater iSourceStateUpdater, IDiagnosisManager iDiagnosisManager, DispatcherBase dispatcherBase) {
        this.sourceStateUpdater = iSourceStateUpdater;
        this.serviceManager = iServiceManager;
        this.diagnosisManager = iDiagnosisManager;
        this.dispatcher = dispatcherBase;
        this.logger = logChannel;
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"SDISConnectionStateProvider");
        this.diagnosisManager.addCommandProvider(-1, new SDISConnectionStateProvider$1(this));
        this.sdisListenerServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = SDISConnectionStateProvider.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"SDISConnectionStateProvider");
        this.sdisListenerServiceRegistration.unregister();
    }

    @Override
    public void updateSdisConnected(boolean bl) {
        boolean bl2 = bl;
        if (this.lastSDISConnectedState == bl2) {
            this.logger.log(1078071040, "[%1.updateSdisConnected] '%2' (not changed)", (Object)"SDISConnectionStateProvider", (Object)Boolean.toString(bl2));
            return;
        }
        this.lastSDISConnectedState = bl2;
        this.logger.log(1078071040, "[%1.updateSdisConnected] '%2'", (Object)"SDISConnectionStateProvider", (Object)Boolean.toString(bl2));
        this.dispatcher.execute(new SDISConnectionStateProvider$2(this, new Buffer().append("updateSdisConnected('").append(bl2).append("')").toString(), bl2));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISourceStateUpdater access$000(SDISConnectionStateProvider sDISConnectionStateProvider) {
        return sDISConnectionStateProvider.sourceStateUpdater;
    }
}

