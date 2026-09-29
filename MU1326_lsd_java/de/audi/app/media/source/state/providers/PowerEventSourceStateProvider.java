/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.PowerEventSourceStateProvider$1;
import de.audi.app.media.source.state.providers.PowerEventSourceStateProvider$2;
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class PowerEventSourceStateProvider
implements PowerEventListener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final ISourceStateUpdater sourceStateUpdater;
    private final IDiagnosisManager diagManager;
    private final IServiceManager serviceManager;
    private final DispatcherBase dispatcher;
    private ServiceRegistration powerEventListenerRegistration;
    private Boolean lastClampS = null;
    static /* synthetic */ Class class$de$audi$atip$power$PowerEventListener;

    public PowerEventSourceStateProvider(LogChannel logChannel, IServiceManager iServiceManager, ISourceStateUpdater iSourceStateUpdater, IDiagnosisManager iDiagnosisManager, DispatcherBase dispatcherBase) {
        this.sourceStateUpdater = iSourceStateUpdater;
        this.serviceManager = iServiceManager;
        this.dispatcher = dispatcherBase;
        this.diagManager = iDiagnosisManager;
        this.logger = logChannel;
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"PowerEventSourceStateProvider");
        this.powerEventListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerEventSourceStateProvider.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, new PowerEventSourceStateProvider$1(this));
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"PowerEventSourceStateProvider");
        this.powerEventListenerRegistration.unregister();
    }

    @Override
    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        String string;
        Boolean bl5 = bl;
        String string2 = string = bl5 != false ? "ON" : "OFF";
        if (bl5.equals(this.lastClampS)) {
            this.logger.log(1078071040, "[%1.updateClampState] clampS='%2' (not changed)", (Object)"PowerEventSourceStateProvider", (Object)string);
            return;
        }
        this.lastClampS = bl5;
        this.logger.log(1078071040, "[%1.updateClampState] clampS='%2'", (Object)"PowerEventSourceStateProvider", (Object)string);
        this.dispatcher.execute(new PowerEventSourceStateProvider$2(this, new Buffer().append("updateClampState('").append(string).append("')").toString(), bl5));
    }

    @Override
    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    @Override
    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    @Override
    public void notifyPowerTriggerAction(int n, int n2) {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISourceStateUpdater access$000(PowerEventSourceStateProvider powerEventSourceStateProvider) {
        return powerEventSourceStateProvider.sourceStateUpdater;
    }
}

