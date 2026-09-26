/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.messaging.devicerole;

import de.audi.atip.interapp.messaging.devicerole.DeviceRoleInfo;

public interface IDeviceRoleObserver {
    default public void updateDeviceRoleInfo(DeviceRoleInfo deviceRoleInfo) {
    }
}

