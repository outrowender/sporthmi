/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.apps.SDSServiceImpl;

public class VolumeSettingSessionCallback {
    private SDSServiceImpl sdsServiceImpl;

    public VolumeSettingSessionCallback(SDSServiceImpl sDSServiceImpl) {
        this.sdsServiceImpl = sDSServiceImpl;
    }

    public void callback() {
        this.sdsServiceImpl.startVolumeSettingSession();
    }
}

