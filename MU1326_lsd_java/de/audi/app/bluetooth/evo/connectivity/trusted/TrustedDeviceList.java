/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.trusted;

import de.audi.app.bluetooth.core.connectivity.trusted.AbstractTrustedDeviceList;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.app.bluetooth.evo.connectivity.trusted.IEvoTrustedDeviceList;
import de.audi.app.bluetooth.evo.connectivity.trusted.TrustedDeviceListRow;
import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import org.dsi.ifc.bluetooth.TrustedDevice;

public class TrustedDeviceList
extends AbstractTrustedDeviceList
implements IEvoTrustedDeviceList,
BaseListModelListener {
    private final IEvoBluetoothApplication bluetoothApplication;
    private final BaseListModelApp list;
    private TrustedDevice[] trustedDevices = new TrustedDevice[0];
    private volatile int services;
    private volatile boolean primary;

    public TrustedDeviceList(IEvoBluetoothApplication iEvoBluetoothApplication) {
        super(iEvoBluetoothApplication);
        this.bluetoothApplication = iEvoBluetoothApplication;
        this.list = this.getBaseListModel(0x2626BB);
    }

    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray, int n) {
        super.updateTrustedDevices(trustedDeviceArray, n);
        if (n == 1 && trustedDeviceArray != null) {
            this.trustedDevices = trustedDeviceArray;
            this.showTrustedDevices(this.services, this.primary);
        }
    }

    public void showTrustedDevices(int n, boolean bl) {
        this.services = n;
        this.primary = bl;
        this.list.removeAll();
        if (this.trustedDevices != null) {
            for (int i2 = 0; i2 < this.trustedDevices.length; ++i2) {
                TrustedDevice trustedDevice = this.trustedDevices[i2];
                if (trustedDevice == null || (trustedDevice.getOfferedServiceTypes() & n) <= 0) continue;
                this.list.append(new TrustedDeviceListRow(i2, trustedDevice.getDeviceName(), trustedDevice.getDeviceAddress(), (trustedDevice.getActiveServiceTypes() & n) > 0));
            }
        }
    }

    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.log.log(1000000, "TrustedDeviceList#itemSelected(): %1", (Object)evoListRow);
        TrustedDevice trustedDevice = this.get(((TrustedDeviceListRow)evoListRow).getAddress());
        if (trustedDevice != null) {
            this.bluetoothApplication.getConnection().connectService(trustedDevice.getDeviceAddress(), this.services & trustedDevice.getOfferedServiceTypes(), trustedDevice.getDeviceName(), this.primary);
            this.list.fireEvent(n4);
        }
    }

    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    public void init() {
        super.init();
        this.list.setListener(this);
    }

    public void deinit() {
        this.list.resetListener();
        super.deinit();
    }
}

