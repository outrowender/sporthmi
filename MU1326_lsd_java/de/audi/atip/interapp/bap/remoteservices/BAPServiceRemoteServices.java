/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.bap.remoteservices;

import de.audi.atip.interapp.bap.BAPService;

public interface BAPServiceRemoteServices
extends BAPService {
    default public void disableMobileDeviceKey() {
    }

    default public void enableMobileDeviceKey() {
    }

    default public void startVTANAuthData() {
    }

    default public void startVTANDecryption(String string) {
    }

    default public void triggerMobDevKeySetupUpdate() {
    }
}

