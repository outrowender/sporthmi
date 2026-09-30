/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.client.IClientHandler;

public interface IConnectionRequestCallback {
    public void connectionEstablished(IClientHandler var1);

    public void connectionFailed(IClientHandler var1, String var2);
}

