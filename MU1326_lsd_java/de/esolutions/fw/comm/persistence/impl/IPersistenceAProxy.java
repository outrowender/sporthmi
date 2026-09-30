/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceA;
import de.esolutions.fw.comm.persistence.IPersistenceAC;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyService;
import de.esolutions.fw.comm.persistence.impl.PartitionHandleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IPersistenceAProxy
implements IPersistenceA,
IPersistenceAC {
    private static final CallContext context = CallContext.getContext("PROXY.persistence.IPersistenceA");
    private Proxy proxy;

    public IPersistenceAProxy(int n, IPersistenceAReply iPersistenceAReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("03171582-f255-4991-b8ae-83f90521c08b", n, "6e1d32e0-f75b-5b13-8215-fd985747e793", "persistence.IPersistenceA");
        IPersistenceAReplyService iPersistenceAReplyService = new IPersistenceAReplyService(iPersistenceAReply);
        this.proxy = new Proxy(serviceInstanceID, iPersistenceAReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void open(long l, String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    public void open(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void close(final PartitionHandle partitionHandle) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void version(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)44, genericSerializable);
    }

    public void version(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    public void purge(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    public void purge(String string) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void beginTransaction(final PartitionHandle partitionHandle) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void endTransaction(final PartitionHandle partitionHandle, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)51, iSerializable);
    }

    public void endTransaction(final PartitionHandle partitionHandle) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void flush(final PartitionHandle partitionHandle) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void exists(final PartitionHandle partitionHandle, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void remove(final PartitionHandle partitionHandle, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)32, iSerializable);
    }

    public void setInt(final PartitionHandle partitionHandle, final long l, final long l2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putUInt32(l2);
            }
        };
        this.proxy.remoteCallMethod((short)35, iSerializable);
    }

    public void getInt(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)64, iSerializable);
    }

    public void getInt(final PartitionHandle partitionHandle, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void getInts(final PartitionHandle partitionHandle, final long[] lArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)66, iSerializable);
    }

    public void getInts(final PartitionHandle partitionHandle, final long[] lArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void setString(final PartitionHandle partitionHandle, final long l, final String string) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putOptionalString(string);
            }
        };
        this.proxy.remoteCallMethod((short)37, iSerializable);
    }

    public void getString(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)68, iSerializable);
    }

    public void getString(final PartitionHandle partitionHandle, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void getStrings(final PartitionHandle partitionHandle, final long[] lArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)70, iSerializable);
    }

    public void getStrings(final PartitionHandle partitionHandle, final long[] lArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void setBlob(final PartitionHandle partitionHandle, final long l, final short[] sArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putOptionalUInt8VarArray(sArray);
            }
        };
        this.proxy.remoteCallMethod((short)34, iSerializable);
    }

    public void getBlob(final PartitionHandle partitionHandle, final long l, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)60, iSerializable);
    }

    public void getBlob(final PartitionHandle partitionHandle, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putUInt32(l);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void getBlobs(final PartitionHandle partitionHandle, final long[] lArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)62, iSerializable);
    }

    public void getBlobs(final PartitionHandle partitionHandle, final long[] lArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void subscribe(final PartitionHandle partitionHandle, final long[] lArray, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)80, iSerializable);
    }

    public void subscribe(final PartitionHandle partitionHandle, final long[] lArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
            }
        };
        this.proxy.remoteCallMethod((short)39, iSerializable);
    }

    public void unsubscribe(final PartitionHandle partitionHandle, final long[] lArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
                iSerializer.putOptionalUInt32VarArray(lArray);
            }
        };
        this.proxy.remoteCallMethod((short)40, iSerializable);
    }

    public void unsubscribeAll(final PartitionHandle partitionHandle) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PartitionHandleSerializer.putOptionalPartitionHandle(iSerializer, partitionHandle);
            }
        };
        this.proxy.remoteCallMethod((short)41, iSerializable);
    }

    public void convert(long l, String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    public void convert(String string, String string2, String string3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }
}

