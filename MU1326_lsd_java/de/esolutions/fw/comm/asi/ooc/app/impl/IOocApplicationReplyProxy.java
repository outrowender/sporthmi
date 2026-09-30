/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.ooc.app.impl;

import de.esolutions.fw.comm.asi.ooc.app.IOocApplicationReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IOocApplicationReplyProxy
implements IOocApplicationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.ooc.app.IOocApplication");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public IOocApplicationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("41a9d241-c39d-4427-aafb-b8d8cb9db3a5", -1, "60a20cee-c632-5bc3-8a99-ef22ee11b8a8", "asi.ooc.app.IOocApplication");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updatePowerState(final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void updateShutdownRequest(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void updateClampSignal(final boolean bl, final boolean bl2, final boolean bl3, final boolean bl4) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
                iSerializer.putBool(bl3);
                iSerializer.putBool(bl4);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void updateVoltageLevel(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void updateRunMode(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateCarLockSignal(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void updatePowerOnPinStatus(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }
}

