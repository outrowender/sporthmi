/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.connectivity.manager.contents;

import de.audi.app.connectivity.manager.contents.AbstractCoMaDevice;
import de.audi.atip.hmi.model.PropertyListCell;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class CoMaDeviceBlue
extends AbstractCoMaDevice {
    private static final int BLUETOOTH_DEVICE;
    private static final int[] BLUETOOTH_PHONE;
    private static final int[] BLUETOOTH_STANDARD_PHONE;
    private static final int[] SAP_PHONE;
    private static final int[] SAP_STANDARD_PHONE;
    private static final int[] BLUETOOTH_PHONE_CALL;
    private static final int[] BLUETOOTH_STANDARD_PHONE_CALL;
    private static final int[] SAP_PHONE_CALL;
    private static final int[] SAP_STANDARD_PHONE_CALL;
    private final boolean isConnectedRsap;
    private final boolean isPrioReconnect;
    private final boolean hasActiveCall;

    public CoMaDeviceBlue(TrustedDevice trustedDevice, int n, int n2, int n3, boolean bl, boolean bl2) {
        super(1, n, n2, n3, trustedDevice.getDeviceAddress(), trustedDevice.getDeviceName(), 0);
        this.isConnectedRsap = (trustedDevice.getActiveServiceTypes() & 4) > 0;
        this.isPrioReconnect = bl;
        this.hasActiveCall = bl2;
    }

    @Override
    PropertyListCell getProperties() {
        if (this.isConnectedRsap) {
            return PropertyListCell.create(110539689, this.isPrioReconnect ? (this.hasActiveCall ? SAP_STANDARD_PHONE_CALL : SAP_STANDARD_PHONE) : (this.hasActiveCall ? SAP_PHONE_CALL : SAP_PHONE));
        }
        return PropertyListCell.create(110539689, this.supports(3) ? (this.isPrioReconnect ? (this.hasActiveCall ? BLUETOOTH_STANDARD_PHONE_CALL : BLUETOOTH_STANDARD_PHONE) : (this.hasActiveCall ? BLUETOOTH_PHONE_CALL : BLUETOOTH_PHONE)) : null);
    }

    boolean isPrioReconnect() {
        return this.isPrioReconnect;
    }

    static {
        BLUETOOTH_PHONE = new int[]{-1794683926};
        BLUETOOTH_STANDARD_PHONE = new int[]{0x3663D366};
        SAP_PHONE = new int[]{-1794683926, 87838446};
        SAP_STANDARD_PHONE = new int[]{0x3663D366, 87838446};
        BLUETOOTH_PHONE_CALL = new int[]{-1794683926, -1376557054};
        BLUETOOTH_STANDARD_PHONE_CALL = new int[]{0x3663D366, -1376557054};
        SAP_PHONE_CALL = new int[]{-1794683926, 87838446, -1376557054};
        SAP_STANDARD_PHONE_CALL = new int[]{0x3663D366, 87838446, -1376557054};
    }
}

