/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.SourceStateUpdate;
import de.audi.app.media.source.state.providers.WLANState;
import de.audi.atip.interapp.WlanServiceListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class WLANSourceStateProvider
implements WlanServiceListener {
    private static final String LOGCLASS = "WLANSourceStateProvider";
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
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.diagnosisManager.addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"wlan.updateWLANState"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                WLANSourceStateProvider.this.updateWlanState(Boolean.valueOf(stringArray[0]));
            }
        });
        this.wlanListenerServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$WlanServiceListener == null ? (class$de$audi$atip$interapp$WlanServiceListener = WLANSourceStateProvider.class$("de.audi.atip.interapp.WlanServiceListener")) : class$de$audi$atip$interapp$WlanServiceListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.wlanListenerServiceRegistration.unregister();
    }

    public void updateWlanState(boolean bl) {
        final WLANState wLANState = new WLANState(bl);
        if (wLANState.equals(this.lastwlanState)) {
            this.logger.log(1000000, "[%1.updateWlanState] '%2' (not changed)", (Object)LOGCLASS, (Object)wLANState);
            return;
        }
        this.lastwlanState = wLANState;
        this.logger.log(1000000, "[%1.updateWlanState] '%2'", (Object)LOGCLASS, (Object)wLANState);
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append("updateWlanState('").append(wLANState).append("')").toString()){

            public void run() {
                WLANSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(4, wLANState));
            }
        });
    }

    public void updateNumberOfClients(final int n) {
        this.logger.log(1000000, "[%1.updateNumberOfClients] '%2'", (Object)LOGCLASS, (Object)String.valueOf(n));
        this.dispatcher.execute(new AbstractDispatcherRunnable("WLANSourceStateProvider.updateNumberOfClients"){

            public void run() {
                WLANSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(14, n > 0));
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

