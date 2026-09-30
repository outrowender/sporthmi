/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.security;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import org.dsi.ifc.bluetooth.PasskeyStateStruct;
import org.dsi.ifc.bluetooth.TrustedDevice;

public abstract class AbstractPostPairingHandler
extends AbstractBluetoothComponent {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{7, 6};
    private boolean pairing;
    private String device;
    private TrustedDevice[] trustedDevices = new TrustedDevice[0];
    private TrustedDevice[] newTrustedDevices = new TrustedDevice[0];

    public AbstractPostPairingHandler(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updatePasskeyState(PasskeyStateStruct passkeyStateStruct, int n) {
        if (n != 1 || passkeyStateStruct == null) {
            return;
        }
        int n2 = passkeyStateStruct.getBtPasskeyState();
        boolean bl = false;
        switch (n2) {
            case 1: 
            case 2: 
            case 6: 
            case 7: 
            case 8: {
                this.pairing = true;
                this.device = passkeyStateStruct.getBtDeviceAddress();
                break;
            }
            case 0: {
                if (this.pairing) {
                    bl = true;
                } else {
                    this.device = null;
                }
            }
            default: {
                this.pairing = false;
            }
        }
        this.log.log(1000000, "AbstractPostPairingHandler#updatePasskeyState(): Pairing active=%1", this.pairing);
        if (bl) {
            this.checkNewDevices();
        } else {
            this.cleanupAfterPairing();
        }
    }

    private void checkNewDevices() {
        this.log.log(1000000, "AbstractPostPairingHandler#checkNewDevices()");
        for (int i2 = 0; i2 < this.newTrustedDevices.length; ++i2) {
            TrustedDevice trustedDevice = this.newTrustedDevices[i2];
            if (!trustedDevice.getDeviceAddress().equals(this.device)) continue;
            this.log.log(10000000, "AbstractPostPairingHandler#checkNewDevices(): New Bluetooth device connected: %1", (Object)this.device);
            this.handleNewDevice(trustedDevice);
            break;
        }
        this.device = null;
        this.pairing = false;
        this.trustedDevices = this.newTrustedDevices;
    }

    protected abstract void handleNewDevice(TrustedDevice var1);

    protected abstract void cleanupAfterPairing();

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        if (n != 1) {
            return;
        }
        if (this.pairing) {
            this.newTrustedDevices = trustedDeviceArray;
        } else {
            this.trustedDevices = trustedDeviceArray;
        }
    }
}

