/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface BluetoothActionProxy
extends ActionProxy {
    default public void abortConnectByHkReturn(int n) {
    }

    default public void clearBtEntrySwitchModel(int n) {
    }

    default public void bluetoothInquiryLeft(int n) {
    }

    default public void abortPairingByHkReturnDuringInquiry(int n) {
    }

    default public void bluetoothAppEntered(int n) {
    }

    default public void bluetoothAppLeft(int n) {
    }
}

