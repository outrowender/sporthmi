/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.interapp.IMediaBluetoothStateProvider;
import de.audi.atip.interapp.IMediaBluetoothStateListener;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.bluetooth.ReconnectInfo;
import org.dsi.ifc.bluetooth.TrustedDevice;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTracker;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class MediaBluetoothStateProvider
extends AbstractBluetoothComponent
implements IMediaBluetoothStateProvider {
    private final int[] attributeNotifications = new int[]{3, 16, 6, 10};
    private final ServiceTracker tracker = new ServiceTracker(this.bundleContext, new String[]{(class$de$audi$atip$interapp$IMediaBluetoothStateListener == null ? (class$de$audi$atip$interapp$IMediaBluetoothStateListener = MediaBluetoothStateProvider.class$("de.audi.atip.interapp.IMediaBluetoothStateListener")) : class$de$audi$atip$interapp$IMediaBluetoothStateListener).getName()}, (ServiceTrackerCustomizer)this);
    private IMediaBluetoothStateListener media;
    private boolean on;
    private boolean a2dp;
    private boolean connected;
    private boolean reconnecting;
    private boolean isActionOngoing = false;
    private boolean isConnectionOngoing = false;
    private boolean isInquriyOngoing = false;
    private boolean isServiceDiscoveryOngoing = false;
    static /* synthetic */ Class class$de$audi$atip$interapp$IMediaBluetoothStateListener;

    public MediaBluetoothStateProvider(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected int[] getAttributeNotifications() {
        return this.attributeNotifications;
    }

    public String toString() {
        Buffer buffer = new Buffer(500);
        buffer.append("\nBluetooth turned on? ").append(this.on);
        buffer.append("\nA2DP user setting active? ").append(this.a2dp);
        buffer.append("\nA2DP device connected? ").append(this.connected);
        buffer.append("\nA2DP device being reconnected? ").append(this.reconnecting);
        buffer.append("\nisActionOngoing = ").append(this.isActionOngoing);
        buffer.append("\nisInquriyOngoing = ").append(this.isInquriyOngoing);
        buffer.append("\nisServiceDiscoveryOngoing = ").append(this.isServiceDiscoveryOngoing);
        buffer.append("\nisConnectionOngoing = ").append(this.isConnectionOngoing);
        return buffer.toString();
    }

    public void updateBTState(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.on = n == 0;
        this.updateState();
    }

    public void updateA2DPUserSetting(boolean bl, int n) {
        if (n != 1) {
            return;
        }
        this.a2dp = bl;
        this.updateState();
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n != 1 || trustedDeviceArray == null) {
            return;
        }
        boolean bl = false;
        for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
            if ((trustedDeviceArray[i2].getActiveServiceTypes() & 0x10000) == 0) continue;
            bl = true;
        }
        this.connected = bl;
        this.updateState();
    }

    public void updateReconnectIndicator(ReconnectInfo reconnectInfo, int n) {
        if (n == 1 && reconnectInfo != null) {
            this.reconnecting = (reconnectInfo.getReconnectIndicator() & 0x10000) != 0;
            this.updateState();
        }
    }

    private void updateState() {
        if (this.media == null) {
            return;
        }
        int n = !this.on ? 0 : (!this.a2dp ? 1 : (this.connected ? 2 : (this.reconnecting ? 3 : 4)));
        this.log.log(10000000, "MediaBluetoothStateProvider#updateState(): New media state: %1", (long)n);
        this.media.updateBluetoothState(n);
    }

    public void connectionProcessStarted() {
        this.isConnectionOngoing = true;
        this.updateActionState();
    }

    public void connectionProcessStopped() {
        this.isConnectionOngoing = false;
        this.updateActionState();
    }

    public void inquiryStarted() {
        this.isInquriyOngoing = true;
        this.updateActionState();
    }

    public void inquiryStopped() {
        this.isInquriyOngoing = false;
        this.updateActionState();
    }

    public void serviceDiscoveryStarted() {
        this.isServiceDiscoveryOngoing = true;
        this.updateActionState();
    }

    public void serviceDiscoveryStopped() {
        this.isServiceDiscoveryOngoing = false;
        this.updateActionState();
    }

    private void updateActionState() {
        this.log.log(10000000, "MediaBluetoothStateProvider#updateActionState(): Current actions: connection=%1, inquiry=%2, service discovery=%3", this.isConnectionOngoing, this.isInquriyOngoing, this.isServiceDiscoveryOngoing);
        this.log.log(10000000, "MediaBluetoothStateProvider#updateActionState(): Current media state: action running=%1", this.isActionOngoing);
        if (this.media != null) {
            if (this.isConnectionOngoing || this.isInquriyOngoing || this.isServiceDiscoveryOngoing) {
                if (!this.isActionOngoing) {
                    this.media.actionStarted();
                    this.isActionOngoing = true;
                }
            } else if (this.isActionOngoing) {
                this.media.actionStopped();
                this.isActionOngoing = false;
            }
        }
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.bundleContext.getService(serviceReference);
        if (object instanceof IMediaBluetoothStateListener) {
            this.media = (IMediaBluetoothStateListener)object;
            this.updateState();
            return object;
        }
        return super.addingService(serviceReference);
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IMediaBluetoothStateListener) {
            this.media = null;
            this.bundleContext.ungetService(serviceReference);
        }
        super.removedService(serviceReference, object);
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IMediaBluetoothStateListener) {
            this.media = (IMediaBluetoothStateListener)object;
        }
        super.modifiedService(serviceReference, object);
    }

    public void init() {
        super.init();
        this.tracker.open();
    }

    public void deinit() {
        this.tracker.close();
        super.deinit();
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

