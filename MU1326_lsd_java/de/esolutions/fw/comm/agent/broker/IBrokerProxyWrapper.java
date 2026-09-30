/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.broker.IBrokerServiceListener;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;

public interface IBrokerProxyWrapper {
    public ServiceInstanceID getBrokerInstanceID();

    public AbstractService createAgentService(IBrokerServiceListener var1, short var2);

    public Proxy create();

    public void announce(short var1) throws MethodException;

    public void registerService(ServiceInstanceID var1, short var2) throws MethodException;

    public void unregisterService(ServiceInstanceID var1, short var2) throws MethodException;

    public void lookupService(ServiceInstanceID var1, short var2) throws MethodException;
}

