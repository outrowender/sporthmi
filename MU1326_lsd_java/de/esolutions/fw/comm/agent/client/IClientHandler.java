/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.client;

import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.core.IProxyBackend;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IClientHandler
extends IProxyBackend {
    public void shutdown();

    public short getPeerAgentID();

    public short getPeerAgentEpoch();

    public short getMyAssignedAgentID();

    public short getMyAssignedAgentEpoch();

    public byte getProtocolVersion();

    public ServiceInstanceID getBrokerServiceInstanceID();

    public boolean connectProxy(Proxy var1);

    public void disconnectProxy(Proxy var1);

    public void dropStub(IStub var1);

    public boolean isAvailable();

    public boolean isConnected();

    public boolean isDeadOrError();

    public ClientInfo createInfo();
}

