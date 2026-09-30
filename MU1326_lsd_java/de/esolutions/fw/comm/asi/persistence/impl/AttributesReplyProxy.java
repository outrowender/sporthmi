/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.persistence.impl;

import de.esolutions.fw.comm.asi.persistence.AttributesReply;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class AttributesReplyProxy
implements AttributesReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.persistence.Attributes");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public AttributesReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f423654f-fed2-59d3-be18-59e9a9b2d05f", -1, "e5e426dc-4f2a-56e5-9b1b-8beaf406be7a", "asi.persistence.Attributes");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void unsubscribeResults(final long[] lArray, final long[] lArray2, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void stringValues(final long[] lArray, final long[] lArray2, final String[] stringArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalStringVarArray(stringArray);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void intValues(final long[] lArray, final long[] lArray2, final int[] nArray, final int[] nArray2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalInt32VarArray(nArray);
                iSerializer.putOptionalEnumVarArray(nArray2);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void blobValues(final long[] lArray, final long[] lArray2, final short[][] sArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                boolean bl = sArray != null;
                iSerializer.putBool(!bl);
                if (bl) {
                    iSerializer.putUInt32(sArray.length);
                    for (int i2 = 0; i2 < sArray.length; ++i2) {
                        iSerializer.putOptionalUInt8VarArray(sArray[i2]);
                    }
                }
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void putResults(final long[] lArray, final long[] lArray2, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }
}

