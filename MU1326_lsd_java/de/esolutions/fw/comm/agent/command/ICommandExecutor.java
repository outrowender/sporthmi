/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.command;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface ICommandExecutor {
    public boolean doRegisterService(IService var1, IServiceWorker var2, boolean var3);

    public boolean doBrokerProxyAlive();

    public boolean doRegisterRemoteService(ServiceInstanceID var1, short var2, boolean var3);

    public boolean doRegisterServiceInstanceListener(ServiceInstanceID var1, IServiceInstanceListener var2, boolean var3);

    public boolean doRegisterServiceListener(IService var1, IServiceListener var2, boolean var3);

    public boolean doRegisterProxyListener(Proxy var1, IProxyListener var2, boolean var3);

    public boolean doConnectProxy(Proxy var1);

    public boolean doSetupProxy(Proxy var1, IClientHandler var2);

    public boolean doDisconnectProxy(Proxy var1);

    public boolean doBrokerServiceUpdate(BrokerServiceUpdate[] var1);

    public boolean doBrokerAgentUpdate(BrokerAgentUpdate[] var1);

    public boolean doTimer();

    public boolean doLookupService(ServiceInstanceID var1);

    public boolean doQuit();

    public boolean doConnectBrokerLink();

    public boolean doSetupBrokerLink(IClientHandler var1);

    public void dropSetupBrokerLink(IClientHandler var1);

    public void dropSetupProxy(Proxy var1, boolean var2);

    public void dropConnectProxy(Proxy var1, boolean var2);

    public boolean doClientHandlerUpdate(IClientHandler var1, boolean var2);

    public boolean doForceDisconnect(short var1);

    public boolean doQueryService(ServiceInstanceID var1, IServiceQueryReply var2);

    public void dropQueryService(ServiceInstanceID var1, IServiceQueryReply var2, boolean var3);
}

