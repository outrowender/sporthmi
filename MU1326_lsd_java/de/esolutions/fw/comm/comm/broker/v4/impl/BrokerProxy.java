/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4.impl;

import de.esolutions.fw.comm.comm.broker.v4.Broker;
import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.comm.broker.v4.impl.InstanceIDSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BrokerProxy
implements Broker {
    private static final CallContext context = CallContext.getContext("PROXY.comm.broker.Broker");
    private Proxy proxy;

    public BrokerProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d4f7cec-be0c-49b7-b1b6-1e3e4c26b847", n, "8935d19b-313a-5d23-bf1f-64bc869ad5a7", "comm.broker.Broker");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void announce(final InstanceID instanceID) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceID);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void registerService(final InstanceID instanceID, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceID);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void unregisterService(final InstanceID instanceID, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceID);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void lookupService(final InstanceID instanceID, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                InstanceIDSerializer.putOptionalInstanceID(iSerializer, instanceID);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

