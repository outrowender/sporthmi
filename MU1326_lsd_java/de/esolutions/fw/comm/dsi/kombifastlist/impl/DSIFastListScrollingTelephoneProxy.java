/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephone;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneC;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneReplyService;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataCombinedNumbersSerializer;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataFavoriteListSerializer;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataInitialsSerializer;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataPhonebookSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public class DSIFastListScrollingTelephoneProxy
implements DSIFastListScrollingTelephone,
DSIFastListScrollingTelephoneC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombifastlist.DSIFastListScrollingTelephone");
    private Proxy proxy;

    public DSIFastListScrollingTelephoneProxy(int n, DSIFastListScrollingTelephoneReply dSIFastListScrollingTelephoneReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("75e6756d-c921-58e9-92cf-8f198f2a1ce7", n, "5e4b90d1-e0ae-5563-bc16-6c69162249eb", "dsi.kombifastlist.DSIFastListScrollingTelephone");
        DSIFastListScrollingTelephoneReplyService dSIFastListScrollingTelephoneReplyService = new DSIFastListScrollingTelephoneReplyService(dSIFastListScrollingTelephoneReply);
        this.proxy = new Proxy(serviceInstanceID, dSIFastListScrollingTelephoneReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void pushFunctionAvailabilityTelephone(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    public void pushMOSTOperationStateTelephone(short s) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n6);
            genericSerializable.putInt32(n7);
            genericSerializable.putInt32(n8);
            genericSerializable.putInt32(n9);
            genericSerializable.putInt32(n10);
            genericSerializable.putInt32(n11);
            genericSerializable.putInt32(n12);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void responsePhonebookArray(final int n, final int n2, final DataPhonebook[] dataPhonebookArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataPhonebookSerializer.putOptionalDataPhonebookVarArray(iSerializer, dataPhonebookArray);
            }
        };
        this.proxy.remoteCallMethod((short)20, iSerializable);
    }

    public void responseGetInitialsTelephone(final int n, final int n2, final int n3, final int n4, final DataInitials[] dataInitialsArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
                iSerializer.putInt32(n4);
                DataInitialsSerializer.putOptionalDataInitialsVarArray(iSerializer, dataInitialsArray);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void pushupdateFavoriteList(final int n, final int n2, final DataFavoriteList[] dataFavoriteListArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataFavoriteListSerializer.putOptionalDataFavoriteListVarArray(iSerializer, dataFavoriteListArray);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void pushCombinedNumbers(final int n, final int n2, final DataCombinedNumbers[] dataCombinedNumbersArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataCombinedNumbersSerializer.putOptionalDataCombinedNumbersVarArray(iSerializer, dataCombinedNumbersArray);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void pushCurrentListSizeTelephone(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void responsePhonebookJobs(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    public void responseNotifyCombinedNumbersPush(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void responseNotifyCurrentListSizes(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void responseNotifyFavoriteListPush(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)22, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

