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
import de.audi.app.media.source.state.providers.BluetoothState;
import de.audi.atip.interapp.IMediaBluetoothStateListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import java.util.Hashtable;
import org.osgi.framework.ServiceRegistration;

public class BluetoothSourceStateProvider
implements IMediaBluetoothStateListener,
IDiagnosisCommandProvider,
TimerListener {
    private static final String LOGCLASS = "BluetoothSourceStateProvider";
    private static final long RECONNECT_TIMEOUT = 60000L;
    private final LogChannel logger;
    private final ISourceStateUpdater sourceStateUpdater;
    private final IServiceManager serviceManager;
    private final IDiagnosisManager diagManager;
    private final DispatcherBase mediaDispatcher;
    private final Object btStateMutex = new Object();
    private boolean btReconnectReceived = false;
    private final Timer reconnectTimer;
    private BluetoothState lastBtState = null;
    private ServiceRegistration bluetoothListenerRegistration;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMediaBluetoothStateListener;

    public BluetoothSourceStateProvider(LogChannel logChannel, IServiceManager iServiceManager, ISourceStateUpdater iSourceStateUpdater, IDiagnosisManager iDiagnosisManager, DispatcherBase dispatcherBase) {
        this.sourceStateUpdater = iSourceStateUpdater;
        this.mediaDispatcher = dispatcherBase;
        this.diagManager = iDiagnosisManager;
        this.serviceManager = iServiceManager;
        this.logger = logChannel;
        this.reconnectTimer = new Timer("BT_ReconnectTimer", 60000L, true, this);
    }

    public void init() {
        this.logger.log(1000000, "[%1.init]", (Object)LOGCLASS);
        this.bluetoothListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$IMediaBluetoothStateListener == null ? (class$de$audi$atip$interapp$IMediaBluetoothStateListener = BluetoothSourceStateProvider.class$("de.audi.atip.interapp.IMediaBluetoothStateListener")) : class$de$audi$atip$interapp$IMediaBluetoothStateListener, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1000000, "[%1.deinit]", (Object)LOGCLASS);
        this.reconnectTimer.cancel();
        this.bluetoothListenerRegistration.unregister();
    }

    public String[] getDiagKeys() {
        return new String[]{"bt.updateBluetoothState"};
    }

    public void executeDiagCommand(String string, String[] stringArray) {
        if (stringArray.length != 1) {
            return;
        }
        int n = Integer.parseInt(stringArray[0]);
        this.updateBluetoothState(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void updateBluetoothState(int n) {
        BluetoothState bluetoothState;
        Object object = this.btStateMutex;
        synchronized (object) {
            bluetoothState = new BluetoothState(n);
            this.logger.log(1000000, "[%1.updateBluetoothState] '%2'", (Object)LOGCLASS, (Object)bluetoothState);
            if (bluetoothState.equals(this.lastBtState)) {
                this.logger.log(1000000, "[%1.updateBluetoothState] not changed", (Object)LOGCLASS);
                if (bluetoothState.getState() != 3) {
                    this.btReconnectReceived = false;
                }
                return;
            }
            if (bluetoothState.getState() == 3) {
                if (this.btReconnectReceived) {
                    this.logger.log(1000000, "[%1.updateBluetoothState] reconnect timer already running", (Object)LOGCLASS);
                    return;
                }
                this.logger.log(1000000, "[%1.updateBluetoothState] start reconnect timer", (Object)LOGCLASS);
                this.reconnectTimer.restart();
                this.btReconnectReceived = true;
            } else if (this.btReconnectReceived) {
                this.logger.log(1000000, "[%1.updateBluetoothState] reconnect timer canceled", (Object)LOGCLASS);
                this.reconnectTimer.cancel();
                this.btReconnectReceived = false;
            }
            this.lastBtState = bluetoothState;
        }
        this.executeUpdate(bluetoothState);
    }

    public void actionStarted() {
        this.logger.log(1000000, "[%1.btActionStarted]", (Object)LOGCLASS);
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("btActionStarted"){

            public void run() {
                BluetoothSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(7, null));
            }
        });
    }

    public void actionStopped() {
        this.logger.log(1000000, "[%1.btActionFinished]", (Object)LOGCLASS);
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable("btActionFinished"){

            public void run() {
                BluetoothSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(6, null));
            }
        });
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void fireTimer(Timer timer) {
        Object object = this.btStateMutex;
        synchronized (object) {
            if (this.btReconnectReceived) {
                this.logger.log(1000000, "[%1.fireTimer]  Reconnect timeout.", (Object)LOGCLASS);
                this.lastBtState = new BluetoothState(4);
                this.executeUpdate(this.lastBtState);
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    private void executeUpdate(final BluetoothState bluetoothState) {
        this.mediaDispatcher.execute(new AbstractDispatcherRunnable(new Buffer().append("updateBluetoothState('").append(bluetoothState).append("')").toString()){

            public void run() {
                BluetoothSourceStateProvider.this.sourceStateUpdater.updateSourceState(new SourceStateUpdate(5, bluetoothState));
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

