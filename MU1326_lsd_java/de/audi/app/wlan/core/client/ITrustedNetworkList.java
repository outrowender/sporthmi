/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.wlan.core.client;

import de.audi.app.wlan.core.client.Network;

public interface ITrustedNetworkList {
    default public void deleteTrustedNetwork(String string) {
    }

    default public boolean isConnected(String string) {
    }

    default public boolean isConnected() {
    }

    default public boolean isTrusted(String string) {
    }

    default public Network getNetwork(String string) {
    }
}

