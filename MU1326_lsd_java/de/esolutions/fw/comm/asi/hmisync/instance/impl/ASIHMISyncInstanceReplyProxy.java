/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.instance.impl;

import de.esolutions.fw.comm.asi.hmisync.instance.ASIHMISyncInstanceReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncInstanceReplyProxy
implements ASIHMISyncInstanceReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.instance.ASIHMISyncInstance");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncInstanceReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("33835c21-9cd6-4b66-a078-9209b43a1b61", -1, "15181a2f-42ba-55da-a0d1-172a25018685", "asi.hmisync.instance.ASIHMISyncInstance");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void responseInstanceId(final String string, final String string2, final int n, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }
}

