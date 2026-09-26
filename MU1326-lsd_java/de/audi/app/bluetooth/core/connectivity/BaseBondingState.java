/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity;

import de.audi.app.bluetooth.core.AbstractBluetoothComponent;
import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.bluetooth.core.connectivity.IBondingState;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

public class BaseBondingState
extends AbstractBluetoothComponent
implements IBondingState {
    private static final int[] ATTRIBUTE_NOTIFICATIONS = new int[0];
    private final ChoiceModelApp bondingStateModel = this.getChoiceModel(170272256);
    private final ChoiceModelApp bondingResultModel = this.getChoiceModel(153495040);
    private volatile int bondingState;
    private volatile int bondingResult;
    private volatile String deviceAddress = "";
    private volatile String deviceName = "";

    public BaseBondingState(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    @Override
    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    @Override
    public void updateBondingState(int n) {
        this.log.log(1078071040, "BaseBondingState#updateBondingState(): BLUE_BONDING_STATE_CHOICE#value=%1", (long)n);
        this.bondingState = n;
        this.bondingStateModel.setValue(n);
    }

    @Override
    public void updateBondingResult(int n) {
        this.log.log(1078071040, "BaseBondingState#updateBondingResult(): BLUE_BONDING_RESULT_CHOICE#value=%1", (long)n);
        this.bondingResult = n;
        this.bondingResultModel.setValue(n);
    }

    @Override
    public void updateDeviceAddress(String string) {
        this.deviceAddress = string;
    }

    @Override
    public void updateDeviceName(String string) {
        this.deviceName = string;
    }

    @Override
    public int getBondingState() {
        return this.bondingState;
    }

    @Override
    public int getBondingResult() {
        return this.bondingResult;
    }

    @Override
    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    @Override
    public String getDeviceName() {
        return this.deviceName;
    }
}

