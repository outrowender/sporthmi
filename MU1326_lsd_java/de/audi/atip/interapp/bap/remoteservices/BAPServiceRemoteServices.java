/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices;

import de.audi.atip.interapp.bap.BAPService;

public interface BAPServiceRemoteServices
extends BAPService {
    public void disableMobileDeviceKey();

    public void enableMobileDeviceKey();

    public void startVTANAuthData();

    public void startVTANDecryption(String var1);

    public void triggerMobDevKeySetupUpdate();
}

