/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Agent;
import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.impl.AgentUpdateEventSerializer;
import de.esolutions.fw.comm.comm.broker.v4.impl.UpdateEventSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AgentProxy
implements Agent {
    private static final CallContext context = CallContext.getContext("PROXY.comm.broker.Agent");
    private Proxy proxy;

    public AgentProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("78a07e56-255a-4309-8bde-b1e1c73bc71c", n, "299585a3-5e89-5854-a716-dafd54af2e50", "comm.broker.Agent");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void serviceUpdate(final UpdateEvent[] updateEventArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                UpdateEventSerializer.putOptionalUpdateEventVarArray(iSerializer, updateEventArray);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void agentUpdate(final AgentUpdateEvent[] agentUpdateEventArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                AgentUpdateEventSerializer.putOptionalAgentUpdateEventVarArray(iSerializer, agentUpdateEventArray);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

