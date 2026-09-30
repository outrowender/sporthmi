/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigation;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationC;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationReplyService;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataAddressSerializer;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DataInitialsSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;

public class DSIFastListScrollingNavigationProxy
implements DSIFastListScrollingNavigation,
DSIFastListScrollingNavigationC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombifastlist.DSIFastListScrollingNavigation");
    private Proxy proxy;

    public DSIFastListScrollingNavigationProxy(int n, DSIFastListScrollingNavigationReply dSIFastListScrollingNavigationReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f2e88e8e-4a51-55c7-8960-fd77a08d2878", n, "7061a2de-13b6-5651-ae47-a77376db7ad2", "dsi.kombifastlist.DSIFastListScrollingNavigation");
        DSIFastListScrollingNavigationReplyService dSIFastListScrollingNavigationReplyService = new DSIFastListScrollingNavigationReplyService(dSIFastListScrollingNavigationReply);
        this.proxy = new Proxy(serviceInstanceID, dSIFastListScrollingNavigationReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void pushFunctionAvailabilityNavigation(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void pushMOSTOperationStateNavigation(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) throws MethodException {
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void responseNavBookArray(final int n, final int n2, final DataAddress[] dataAddressArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataAddressSerializer.putOptionalDataAddressVarArray(iSerializer, dataAddressArray);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }

    public void responseGetInitialsNavigation(final int n, final int n2, final int n3, final int n4, final DataInitials[] dataInitialsArray) throws MethodException {
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

    public void pushLastDestList(final int n, final int n2, final DataAddress[] dataAddressArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataAddressSerializer.putOptionalDataAddressVarArray(iSerializer, dataAddressArray);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void pushUpdateFavoriteDestList(final int n, final int n2, final DataAddress[] dataAddressArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                iSerializer.putInt32(n2);
                DataAddressSerializer.putOptionalDataAddressVarArray(iSerializer, dataAddressArray);
            }
        };
        this.proxy.remoteCallMethod((short)14, iSerializable);
    }

    public void pushCurrentListSizeNavigation(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void responseNavBookJobs(int n, int n2, int n3) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void responseNotifyCurrentListSizesNavigation(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    public void responseNotifyFavoriteDestList(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    public void responseNotifyLastDestList(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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

