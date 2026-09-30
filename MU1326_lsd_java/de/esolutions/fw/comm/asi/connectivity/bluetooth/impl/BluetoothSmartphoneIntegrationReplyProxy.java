/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.bluetooth.impl;

import de.esolutions.fw.comm.asi.connectivity.bluetooth.BluetoothSmartphoneIntegrationReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class BluetoothSmartphoneIntegrationReplyProxy
implements BluetoothSmartphoneIntegrationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public BluetoothSmartphoneIntegrationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e89f426d-df36-46c9-b54d-712527c0309a", -1, "fa60e661-b204-58e6-937d-484b8a10b0e4", "asi.connectivity.bluetooth.BluetoothSmartphoneIntegration");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseLocalBluetoothAddress(final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void updateSpiBtState(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void responsePrepareConnect(final String string, final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void reportSharedSecret(final String string, final String string2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void reportParingSuccess(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void reportConnectionEstablished(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

