/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import java.util.List;

public interface IRemoteHMIMediaOnlineServiceListener {
    default public void updateLastActiveOnlineService(int n) {
    }

    default public void updateOnlineServices(List list) {
    }

    default public void updateDeviceAppState(boolean bl) {
    }
}

