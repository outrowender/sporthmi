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
import de.audi.atip.interapp.SDISConnectionStateListener;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class SDISConnectionStateProvider
implements SDISConnectionStateListener {
    private static final String LOGCLASS = "SDISConnectionStateProvider";
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
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.diagnosisManager.addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"sdis.updateSdisConnected"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                SDISConnectionStateProvider.this.updateSdisConnected(Boolean.valueOf(stringArray[0]));
            }
        });
        this.sdisListenerServiceRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$SDISConnectionStateListener == null ? (class$de$audi$atip$interapp$SDISConnectionStateListener = SDISConnectionStateProvider.class$("de.audi.atip.interapp.SDISConnectionStateListener")) : class$de$audi$atip$interapp$SDISConnectionStateListener, this, new Hashtable(0));
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit] Deinit.", (Object)LOGCLASS);
        this.sdisListenerServiceRegistration.unregister();
    }

    public void updateSdisConnected(boolean bl) {
        final boolean bl2 = bl;
        if (this.lastSDISConnectedState == bl2) {
            this.logger.log(1000000, "[%1.updateSdisConnected] '%2' (not changed)", (Object)LOGCLASS, (Object)Boolean.toString(bl2));
            return;
        }
        this.lastSDISConnectedState = bl2;
        this.logger.log(1000000, "[%1.updateSdisConnected] '%2'", (Object)LOGCLASS, (Object)Boolean.toString(bl2));
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append("updateSdisConnected('").append(bl2).append("')").toString()){

            public void run() {
                SDISConnectionStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(16, bl2));
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

