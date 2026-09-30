/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.client.Network;

public interface ITrustedNetworkList {
    public void deleteTrustedNetwork(String var1);

    public boolean isConnected(String var1);

    public boolean isConnected();

    public boolean isTrusted(String var1);

    public Network getNetwork(String var1);
}

