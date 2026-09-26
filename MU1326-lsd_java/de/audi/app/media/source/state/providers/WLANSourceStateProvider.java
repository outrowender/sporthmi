/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider$1;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider$2;
import de.audi.app.media.source.state.providers.WLANSourceStateProvider$3;
import de.audi.app.media.source.state.providers.WLANState;
import de.audi.atip.interapp.WlanServiceListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class WLANSourceStateProvider
implements WlanServiceListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IServiceManager serviceManager;
    private final IDiagnosisManager diagnosisManager;
    private final ISourceStateUpdater sourceStateUpdater;
    private final DispatcherBase dispatcher;
    private volatile ServiceRegistration wlanListenerServiceRegistration;
    private WLANState lastwlanState = null;
    static /* synthetic */ Class class$de$audi$atip$interapp$WlanServiceListener;

    public WLANSourceStateProvider(LogChannel logChannel, IServiceManager iServiceManager, ISourceStateUpdater iSourceStateUpdater, IDiagnosisManager iDiagnosisManager, DispatcherBase dispatcherBase) {
        this.sourceStateUpdater = iSourceStateUpdater;
        this.serviceManager = iServiceManager;
        this.diagnosisManager = iDiagnosisManager;
        this.dispatcher = dispatcherBase;
        this.logger = logChannel;
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"WLANSourceStateProvider");
        this.diagnosisManager.addCommandProvider(-1, new WLANSourceStateProvider$1(this));
        this.wlanListenerServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$WlanServiceListener == null ? (class$de$audi$atip$interapp$WlanServiceListener = WLANSourceStateProvider.class$("de.audi.atip.interapp.WlanServiceListener")) : class$de$audi$atip$interapp$WlanServiceListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit] Deinit.", (Object)"WLANSourceStateProvider");
        this.wlanListenerServiceRegistration.unregister();
    }

    @Override
    public void updateWlanState(boolean bl) {
        WLANState wLANState = new WLANState(bl);
        if (wLANState.equals(this.lastwlanState)) {
            this.logger.log(1078071040, "[%1.updateWlanState] '%2' (not changed)", (Object)"WLANSourceStateProvider", (Object)wLANState);
            return;
        }
        this.lastwlanState = wLANState;
        this.logger.log(1078071040, "[%1.updateWlanState] '%2'", (Object)"WLANSourceStateProvider", (Object)wLANState);
        this.dispatcher.execute(new WLANSourceStateProvider$2(this, new Buffer().append("updateWlanState('").append(wLANState).append("')").toString(), wLANState));
    }

    @Override
    public void updateNumberOfClients(int n) {
        this.logger.log(1078071040, "[%1.updateNumberOfClients] '%2'", (Object)"WLANSourceStateProvider", (Object)String.valueOf(n));
        this.dispatcher.execute(new WLANSourceStateProvider$3(this, "WLANSourceStateProvider.updateNumberOfClients", n));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISourceStateUpdater access$000(WLANSourceStateProvider wLANSourceStateProvider) {
        return wLANSourceStateProvider.sourceStateUpdater;
    }
}

