/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceListListener;
import de.audi.app.terminalmode.device.IDeviceManager$IDeviceManagerProperties;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceID;

public interface IDeviceManager {
    default public void addDeviceListListener(IDeviceListListener iDeviceListListener) {
    }

    default public void removeDeviceListListener(IDeviceListListener iDeviceListListener) {
    }

    default public void addActiveDeviceListener(IActiveDeviceStateListener iActiveDeviceStateListener) {
    }

    default public void removeActiveDeviceListener(IActiveDeviceStateListener iActiveDeviceStateListener) {
    }

    default public TMDeviceControl control(TMDeviceID tMDeviceID) {
    }

    default public TMDeviceControl control(TMDevice tMDevice) {
    }

    default public TMDevice getActiveDevice() {
    }

    default public IDeviceManager$IDeviceManagerProperties getProperties() {
    }
}

