/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.connectivity.wlan.TrustedNetwork;

public interface IWlanPCoreService {
    default public void setRFActive(boolean bl) {
    }

    default public void setRole(int n) {
    }

    default public void deleteTrustedNetwork(TrustedNetwork trustedNetwork) {
    }
}

