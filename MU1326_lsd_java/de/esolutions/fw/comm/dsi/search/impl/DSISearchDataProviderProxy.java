/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProvider;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderC;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderReplyService;
import de.esolutions.fw.comm.dsi.search.impl.DataSetSerializer;
import de.esolutions.fw.comm.dsi.search.impl.RawDataSetSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public class DSISearchDataProviderProxy
implements DSISearchDataProvider,
DSISearchDataProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.search.DSISearchDataProvider");
    private Proxy proxy;

    public DSISearchDataProviderProxy(int n, DSISearchDataProviderReply dSISearchDataProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("609c2f54-403b-514e-a26b-497fb68562b8", n, "0bdb432e-00eb-5a56-a464-12a0e0e947b1", "dsi.search.DSISearchDataProvider");
        DSISearchDataProviderReplyService dSISearchDataProviderReplyService = new DSISearchDataProviderReplyService(dSISearchDataProviderReply);
        this.proxy = new Proxy(serviceInstanceID, dSISearchDataProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void registerProviderSource(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void sourceDataAvailabilityChanged(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void invalidateAllData(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void storeDataSets(final int n, final DataSet[] dataSetArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                DataSetSerializer.putOptionalDataSetVarArray(iSerializer, dataSetArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void storeRawDataSets(final int n, final RawDataSet[] rawDataSetArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RawDataSetSerializer.putOptionalRawDataSetVarArray(iSerializer, rawDataSetArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void deleteDataSet(int n, long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)12, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
    }

    public void yySet(String string, String string2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

