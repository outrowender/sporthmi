/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.TMDevice;

public interface IActiveDeviceStateListener {
    default public void updateActiveDeviceState(TMDevice tMDevice) {
    }
}

