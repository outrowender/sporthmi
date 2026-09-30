/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceHandlerInfo;
import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;
import de.esolutions.fw.comm.agent.diag.info.WorkerInfo;

public interface IAgentSnapshot {
    public ProxyInfo[] getAllProxies();

    public StubInfo[] getAllStubs();

    public ClientInfo[] getAllClients();

    public WorkerInfo getWorker();

    public ServiceHandlerInfo[] getAllServiceHandlers();

    public ServiceLocatorInfo[] getAllServiceLocators();

    public String[] getAllInfoProviderNames();

    public IInfoBase[] getInfoProviderData(String var1);

    public long getTimeStamp();
}

