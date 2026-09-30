/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.online;

import java.util.List;

public interface IRemoteHMIMediaOnlineServiceListener {
    public void updateLastActiveOnlineService(int var1);

    public void updateOnlineServices(List var1);

    public void updateDeviceAppState(boolean var1);
}

