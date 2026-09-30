/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.diag.IInfoBase;

public interface IAgentErrorLog {
    public IInfoBase[] getProxyErrors();

    public int getNumDroppedProxyErrors();

    public IInfoBase[] getClientErrors();

    public int getNumDroppedClientErrors();

    public IInfoBase[] getStubErrors();

    public int getNumDroppedStubErrors();
}

