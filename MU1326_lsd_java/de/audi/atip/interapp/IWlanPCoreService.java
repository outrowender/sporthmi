/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.audi.atip.interapp.connectivity.wlan.TrustedNetwork;

public interface IWlanPCoreService {
    public void setRFActive(boolean var1);

    public void setRole(int var1);

    public void deleteTrustedNetwork(TrustedNetwork var1);
}

