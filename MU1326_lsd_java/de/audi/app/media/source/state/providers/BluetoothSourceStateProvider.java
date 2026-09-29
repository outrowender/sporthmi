/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.state.providers;

import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;
import de.audi.app.media.diagnosis.IDiagnosisManager;
import de.audi.app.media.osgi.IServiceManager;
import de.audi.app.media.source.state.ISourceStateUpdater;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider$1;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider$2;
import de.audi.app.media.source.state.providers.BluetoothSourceStateProvider$3;
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
    private static final String LOGCLASS;
    private static final long RECONNECT_TIMEOUT;
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
        this.reconnectTimer = new Timer("BT_ReconnectTimer", 0, true, this);
    }

    public void init() {
        this.logger.log(1078071040, "[%1.init]", (Object)"BluetoothSourceStateProvider");
        this.bluetoothListenerRegistration = this.serviceManager.registerService(class$de$audi$atip$interapp$IMediaBluetoothStateListener == null ? (class$de$audi$atip$interapp$IMediaBluetoothStateListener = BluetoothSourceStateProvider.class$("de.audi.atip.interapp.IMediaBluetoothStateListener")) : class$de$audi$atip$interapp$IMediaBluetoothStateListener, this, new Hashtable(0));
        this.diagManager.addCommandProvider(-1, this);
    }

    public void deinit() {
        this.logger.log(1078071040, "[%1.deinit]", (Object)"BluetoothSourceStateProvider");
        this.reconnectTimer.cancel();
        this.bluetoothListenerRegistration.unregister();
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"bt.updateBluetoothState"};
    }

    @Override
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
    @Override
    public void updateBluetoothState(int n) {
        BluetoothState bluetoothState;
        Object object = this.btStateMutex;
        synchronized (object) {
            bluetoothState = new BluetoothState(n);
            this.logger.log(1078071040, "[%1.updateBluetoothState] '%2'", (Object)"BluetoothSourceStateProvider", (Object)bluetoothState);
            if (bluetoothState.equals(this.lastBtState)) {
                this.logger.log(1078071040, "[%1.updateBluetoothState] not changed", (Object)"BluetoothSourceStateProvider");
                if (bluetoothState.getState() != 3) {
                    this.btReconnectReceived = false;
                }
                return;
            }
            if (bluetoothState.getState() == 3) {
                if (this.btReconnectReceived) {
                    this.logger.log(1078071040, "[%1.updateBluetoothState] reconnect timer already running", (Object)"BluetoothSourceStateProvider");
                    return;
                }
                this.logger.log(1078071040, "[%1.updateBluetoothState] start reconnect timer", (Object)"BluetoothSourceStateProvider");
                this.reconnectTimer.restart();
                this.btReconnectReceived = true;
            } else if (this.btReconnectReceived) {
                this.logger.log(1078071040, "[%1.updateBluetoothState] reconnect timer canceled", (Object)"BluetoothSourceStateProvider");
                this.reconnectTimer.cancel();
                this.btReconnectReceived = false;
            }
            this.lastBtState = bluetoothState;
        }
        this.executeUpdate(bluetoothState);
    }

    @Override
    public void actionStarted() {
        this.logger.log(1078071040, "[%1.btActionStarted]", (Object)"BluetoothSourceStateProvider");
        this.mediaDispatcher.execute(new BluetoothSourceStateProvider$1(this, "btActionStarted"));
    }

    @Override
    public void actionStopped() {
        this.logger.log(1078071040, "[%1.btActionFinished]", (Object)"BluetoothSourceStateProvider");
        this.mediaDispatcher.execute(new BluetoothSourceStateProvider$2(this, "btActionFinished"));
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = this.btStateMutex;
        synchronized (object) {
            if (this.btReconnectReceived) {
                this.logger.log(1078071040, "[%1.fireTimer]  Reconnect timeout.", (Object)"BluetoothSourceStateProvider");
                this.lastBtState = new BluetoothState(4);
                this.executeUpdate(this.lastBtState);
            }
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    private void executeUpdate(BluetoothState bluetoothState) {
        this.mediaDispatcher.execute(new BluetoothSourceStateProvider$3(this, new Buffer().append("updateBluetoothState('").append(bluetoothState).append("')").toString(), bluetoothState));
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static /* synthetic */ ISourceStateUpdater access$000(BluetoothSourceStateProvider bluetoothSourceStateProvider) {
        return bluetoothSourceStateProvider.sourceStateUpdater;
    }
}

