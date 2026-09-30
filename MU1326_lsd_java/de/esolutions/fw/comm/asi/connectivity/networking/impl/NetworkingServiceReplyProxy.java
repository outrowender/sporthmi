/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking.impl;

import de.esolutions.fw.comm.asi.connectivity.networking.NetworkingServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NetworkingServiceReplyProxy
implements NetworkingServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.networking.NetworkingService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public NetworkingServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("54bd523b-eece-4101-9c88-53bb869c6b64", -1, "9d2b4f14-42b2-506b-aae0-1904af2be1f8", "asi.connectivity.networking.NetworkingService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateRoamingState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void updateOnlineState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void updateThrottlingState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void updateServiceIdentifier(final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void updateSimCardType(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void updateSim(final String string, final String string2, final String string3, final String string4) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putOptionalString(string3);
                iSerializer.putOptionalString(string4);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }
}

