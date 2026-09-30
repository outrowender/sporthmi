/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IProvider;

public interface IProviderStateListener {
    public void onConnecting(IProvider var1);

    public void onConnected(IProvider var1);

    public void onConnectionFailed(IProvider var1);

    public void onConnectionLost(IProvider var1);

    public void onDisconnected(IProvider var1);

    public void onDisconnecting(IProvider var1);
}

