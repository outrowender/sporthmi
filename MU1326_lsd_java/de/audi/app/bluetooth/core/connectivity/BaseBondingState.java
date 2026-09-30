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
    private final ChoiceModelApp bondingStateModel = this.getChoiceModel(2500106);
    private final ChoiceModelApp bondingResultModel = this.getChoiceModel(2500105);
    private volatile int bondingState;
    private volatile int bondingResult;
    private volatile String deviceAddress = "";
    private volatile String deviceName = "";

    public BaseBondingState(IBluetoothApplication iBluetoothApplication) {
        super(iBluetoothApplication);
    }

    protected final int[] getAttributeNotifications() {
        return ATTRIBUTE_NOTIFICATIONS;
    }

    public void updateBondingState(int n) {
        this.log.log(1000000, "BaseBondingState#updateBondingState(): BLUE_BONDING_STATE_CHOICE#value=%1", (long)n);
        this.bondingState = n;
        this.bondingStateModel.setValue(n);
    }

    public void updateBondingResult(int n) {
        this.log.log(1000000, "BaseBondingState#updateBondingResult(): BLUE_BONDING_RESULT_CHOICE#value=%1", (long)n);
        this.bondingResult = n;
        this.bondingResultModel.setValue(n);
    }

    public void updateDeviceAddress(String string) {
        this.deviceAddress = string;
    }

    public void updateDeviceName(String string) {
        this.deviceName = string;
    }

    public int getBondingState() {
        return this.bondingState;
    }

    public int getBondingResult() {
        return this.bondingResult;
    }

    public String getDeviceAddress() {
        return this.deviceAddress;
    }

    public String getDeviceName() {
        return this.deviceName;
    }
}

