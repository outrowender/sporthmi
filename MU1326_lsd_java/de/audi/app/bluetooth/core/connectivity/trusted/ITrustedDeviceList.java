/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.trusted;

import org.dsi.ifc.bluetooth.TrustedDevice;

public interface ITrustedDeviceList {
    default public boolean isConnected(String string) {
    }

    default public void removeAuthentication(String string) {
    }

    default public TrustedDevice get(String string) {
    }
}

