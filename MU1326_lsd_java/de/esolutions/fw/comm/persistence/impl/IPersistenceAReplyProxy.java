/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IPersistenceAReplyProxy
implements IPersistenceAReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.persistence.IPersistenceA");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public IPersistenceAReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f4ac6df9-a35a-4f1c-a334-9c2890a41c09", -1, "21034d62-3469-5d3a-b904-de8a9709a4ed", "persistence.IPersistenceA");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void openResult(final long l, final String string, final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putOptionalString(string);
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)74, iSerializable);
    }

    public void openResult(final String string, final String string2, final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)73, iSerializable);
    }

    public void closeResult(final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)54, iSerializable);
    }

    public void versionResult(final long l, final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putOptionalString(string);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)83, iSerializable);
    }

    public void versionResult(final String string, final String string2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)82, iSerializable);
    }

    public void purgeResult(final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)76, iSerializable);
    }

    public void purgeResult(final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)75, iSerializable);
    }

    public void beginTransactionResult(final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)52, iSerializable);
    }

    public void endTransactionResult(final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)57, iSerializable);
    }

    public void flushResult(final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)59, iSerializable);
    }

    public void existsResult(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)58, iSerializable);
    }

    public void removeResult(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)77, iSerializable);
    }

    public void getIntResult(final PartitionHandle partitionHandle, final long l, final long l2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putUInt32(l2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)65, iSerializable);
    }

    public void getIntsResult(final PartitionHandle partitionHandle, final long[] lArray, final long[] lArray2, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)67, iSerializable);
    }

    public void getStringResult(final PartitionHandle partitionHandle, final long l, final String string, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putOptionalString(string);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)69, iSerializable);
    }

    public void getStringsResult(final PartitionHandle partitionHandle, final long[] lArray, final String[] stringArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalStringVarArray(stringArray);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)71, iSerializable);
    }

    public void getBlobResult(final PartitionHandle partitionHandle, final long l, final short[] sArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putOptionalUInt8VarArray(sArray);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)61, iSerializable);
    }

    public void getBlobsResult(final PartitionHandle partitionHandle, final long[] lArray, final short[][] sArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
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
        this.proxy.remoteCallMethod((short)63, iSerializable);
    }

    public void setResult(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)78, iSerializable);
    }

    public void unsubscribeResult(final PartitionHandle partitionHandle, final long[] lArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)81, iSerializable);
    }

    public void stringValues(final PartitionHandle partitionHandle, final long[] lArray, final String[] stringArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalStringVarArray(stringArray);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)79, iSerializable);
    }

    public void intValues(final PartitionHandle partitionHandle, final long[] lArray, final long[] lArray2, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putOptionalUInt32VarArray(lArray2);
                iSerializer.putOptionalEnumVarArray(nArray);
            }
        };
        this.proxy.remoteCallMethod((short)72, iSerializable);
    }

    public void blobValues(final PartitionHandle partitionHandle, final long[] lArray, final short[][] sArray, final int[] nArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
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
        this.proxy.remoteCallMethod((short)53, iSerializable);
    }

    public void convertResult(final long l, final String string, final String string2, final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt32(l);
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)56, iSerializable);
    }

    public void convertResult(final String string, final String string2, final String string3, final PartitionHandle partitionHandle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putOptionalString(string2);
                iSerializer.putOptionalString(string3);
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)55, iSerializable);
    }
}

