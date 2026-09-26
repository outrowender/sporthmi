/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.evo.connectivity.connect;

import de.audi.app.bluetooth.core.connectivity.connect.BaseBluetoothConnection;
import de.audi.app.bluetooth.evo.IEvoBluetoothApplication;
import de.audi.atip.hmi.modelaccess.ButtonModelApp;

public class BluetoothConnection
extends BaseBluetoothConnection {
    private final IEvoBluetoothApplication bluetoothApplication;
    private final ButtonModelApp hfpDowngradButton;

    public BluetoothConnection(IEvoBluetoothApplication iEvoBluetoothApplication) {
        super(iEvoBluetoothApplication);
        this.bluetoothApplication = iEvoBluetoothApplication;
        this.hfpDowngradButton = this.getButtonModel(-685365760);
    }

    @Override
    protected void propagateBondingResult(String string, int n, int n2, int n3) {
        this.bluetoothApplication.getConnectivity().getConnectivityManager().responseConnectService(n2, n3);
        super.propagateBondingResult(string, n, n2, n3);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == this.hfpDowngradButton.getID()) {
            this.log.log(1078071040, "BluetoothConnection#keyTyped(): HFP downgrade!");
            this.connectionRequest.service = 2;
            this.bluetoothApplication.getBondingState().updateBondingState(1);
            this.connectService(this.connectionRequest);
            this.hfpDowngradButton.fireEvent(n3);
        } else {
            super.keyTyped(n, n2, n3);
        }
    }

    @Override
    public void init() {
        super.init();
        this.hfpDowngradButton.setButtonListener(this);
    }

    @Override
    public void deinit() {
        this.hfpDowngradButton.resetListener();
        super.deinit();
    }
}

