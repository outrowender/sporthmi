/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app.impl;

import de.esolutions.fw.comm.asi.diagnosis.mmx2app.MMX2BluetoothDiagServiceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MMX2BluetoothDiagServiceReplyProxy
implements MMX2BluetoothDiagServiceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MMX2BluetoothDiagServiceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a2aba5f9-4aae-436e-802a-26bbd44eec8e", -1, "53cec102-0ba4-570c-9109-ebc8f698e1cf", "asi.diagnosis.mmx2app.MMX2BluetoothDiagService");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestBluetoothState(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void requestBluetoothMAC(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }

    public void requestBluetoothDevices(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void requestLastPairedBtDevices(final long l, final short s) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putUInt8(s);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void requestPairedBtDevices(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void requestConnectedBtDevices(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void requestConnectedBtDevice(final long l, final short s) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putUInt8(s);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void requestAutoConnectBtHandset(final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void requestBtDeleteLinkKeys(final long l, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void requestBtDeviceSearch(final long l, final short s, final short s2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putUInt8(s);
                iSerializer.putUInt8(s2);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void requestConnectionToLastBtDevice(final long l, final short s, final short s2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putUInt8(s);
                iSerializer.putUInt8(s2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }
}

