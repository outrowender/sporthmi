/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecAppMMXReply;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecAppMMXReplyProxy
implements FecAppMMXReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecAppMMX");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public FecAppMMXReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3a7a576a-0b38-45fc-9ad4-1eab302e4f5b", -1, "25185772-f55e-575f-a737-9ae88d532512", "asi.fec.FecAppMMX");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void reportError(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void updateFECs(final SFecState[] sFecStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SFecStateSerializer.putOptionalSFecStateVarArray(iSerializer, sFecStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void checkPkgSignature(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

