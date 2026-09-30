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
import de.audi.atip.log.LogChannel;
import de.audi.atip.power.PowerEventListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class PowerEventSourceStateProvider
implements PowerEventListener {
    private static final String LOGCLASS = "PowerEventSourceStateProvider";
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
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.powerEventListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$power$PowerEventListener == null ? (class$de$audi$atip$power$PowerEventListener = PowerEventSourceStateProvider.class$("de.audi.atip.power.PowerEventListener")) : class$de$audi$atip$power$PowerEventListener, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, new IDiagnosisCommandProvider(){

            public String[] getDiagKeys() {
                return new String[]{"power.updateClampS"};
            }

            public void executeDiagCommand(String string, String[] stringArray) {
                if (stringArray.length != 1) {
                    return;
                }
                boolean bl = Boolean.valueOf(stringArray[0]);
                PowerEventSourceStateProvider.this.updateClampState(bl, false, false, false);
            }
        });
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.powerEventListenerRegistration.unregister();
    }

    public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        String string;
        final Boolean bl5 = bl;
        String string2 = string = bl5 != false ? "ON" : "OFF";
        if (bl5.equals(this.lastClampS)) {
            this.logger.log(1000000, "[%1.updateClampState] clampS='%2' (not changed)", (Object)LOGCLASS, (Object)string);
            return;
        }
        this.lastClampS = bl5;
        this.logger.log(1000000, "[%1.updateClampState] clampS='%2'", (Object)LOGCLASS, (Object)string);
        this.dispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append("updateClampState('").append(string).append("')").toString()){

            public void run() {
                PowerEventSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(3, bl5));
            }
        });
    }

    public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    public void notifyPowerListenerOnExitState(int n, int n2) {
    }

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
}

