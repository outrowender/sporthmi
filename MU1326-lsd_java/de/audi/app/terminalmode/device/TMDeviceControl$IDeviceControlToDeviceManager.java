/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;

public interface TMDeviceControl$IDeviceControlToDeviceManager {
    default public void notifyAboutChange(TMDevice tMDevice, String string) {
    }

    default public void requestActivation(TMDeviceControl tMDeviceControl) {
    }

    default public void requestOtherModeActivation(TMDeviceControl tMDeviceControl) {
    }

    default public void deleteMe(TMDeviceControl tMDeviceControl) {
    }

    default public void requestDeactivation(TMDeviceControl tMDeviceControl) {
    }
}

