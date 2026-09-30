/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.security.AbstractPostPairingHandler;
import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class BaseSapUpgradeHandler
extends AbstractPostPairingHandler
implements ButtonListener {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[]{7, 6, 12};
    private final ButtonModelApp sapUpgradeButton = this.getButtonModel(2500321);
    private volatile TrustedDevice device;
    private volatile boolean connectionRequestOngoing;
    private volatile boolean sapSupported;

    public BaseSapUpgradeHandler(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    private void activateSapUpgrade() {
        this.sapUpgradeButton.setStatus(1);
    }

    private void disableSapUpgrade() {
        this.sapUpgradeButton.setStatus(0);
    }

    void updateConnectionActive(boolean bl) {
        this.log.log(10000000, "BaseSapUpgradeHandler#updateConnectionActive(): %1", bl);
        this.connectionRequestOngoing = bl;
        if (bl) {
            this.disableSapUpgrade();
        }
    }

    public void updateSupportedBTProfiles(int n, int n2) {
        if (n2 != 1) {
            return;
        }
        this.log.log(10000000, "BaseSapUpgradeHandler#updateSupportedBTProfiles(): %1", (long)n);
        this.sapSupported = (n & 4) > 0;
        this.log.log(10000000, "BaseSapUpgradeHandler#updateSupportedBTProfiles(): SAP supported: %1", this.sapSupported);
        if (!this.sapSupported) {
            this.disableSapUpgrade();
        }
    }

    protected void handleNewDevice(TrustedDevice trustedDevice) {
        this.log.log(10000000, "BaseSapUpgradeHandler#handleNewDevice(): %1", (Object)trustedDevice);
        if (this.sapSupported && !this.connectionRequestOngoing) {
            this.log.log(1000000, "BaseSapUpgradeHandler#handleNewDevice(): Activating SAP upgrade");
            this.device = trustedDevice;
            this.activateSapUpgrade();
        }
    }

    protected void cleanupAfterPairing() {
        this.log.log(10000000, "BaseSapUpgradeHandler#cleanupAfterPairing()");
        this.device = null;
    }

    public void keyTyped(int n, int n2, int n3) {
        if (n == this.sapUpgradeButton.getID()) {
            if (this.device == null) {
                this.log.log(100000, "BaseSapUpgradeHandler#keyTyped(): device is null, can't upgrade");
            } else {
                this.log.log(1000000, "BaseSapUpgradeHandler#keyTyped(): Initiating SAP upgrade");
                this.bluetoothApplication.getConnection().connectService(this.device.getDeviceAddress(), 4, this.device.getDeviceName(), this.device.getDeviceRole() == 1);
            }
            this.sapUpgradeButton.fireEvent(n3);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void init() {
        super.init();
        this.sapUpgradeButton.setButtonListener(this);
    }

    public void deinit() {
        this.sapUpgradeButton.resetListener();
        super.deinit();
    }
}

