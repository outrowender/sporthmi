/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface BluetoothActionProxy
extends ActionProxy {
    public void abortConnectByHkReturn(int var1);

    public void clearBtEntrySwitchModel(int var1);

    public void bluetoothInquiryLeft(int var1);

    public void abortPairingByHkReturnDuringInquiry(int var1);

    public void bluetoothAppEntered(int var1);

    public void bluetoothAppLeft(int var1);
}

