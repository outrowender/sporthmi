/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.trusted;

import org.dsi.ifc.bluetooth.TrustedDevice;

public interface ITrustedDeviceList {
    public boolean isConnected(String var1);

    public void removeAuthentication(String var1);

    public TrustedDevice get(String var1);
}

