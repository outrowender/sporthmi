/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMetadataService;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceC;
import de.esolutions.fw.comm.dsi.media.DSIMetadataServiceReply;
import de.esolutions.fw.comm.dsi.media.impl.CoverartInfoSerializer;
import de.esolutions.fw.comm.dsi.media.impl.DSIMetadataServiceReplyService;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.CoverartInfo;

public class DSIMetadataServiceProxy
implements DSIMetadataService,
DSIMetadataServiceC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.media.DSIMetadataService");
    private Proxy proxy;

    public DSIMetadataServiceProxy(int n, DSIMetadataServiceReply dSIMetadataServiceReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("efe4731d-84ce-530f-a510-7f84abfd9ffa", n, "49b22f6f-2342-51d2-9b32-7e731b01148b", "dsi.media.DSIMetadataService");
        DSIMetadataServiceReplyService dSIMetadataServiceReplyService = new DSIMetadataServiceReplyService(dSIMetadataServiceReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMetadataServiceReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestCoverArt(final int n, final CoverartInfo coverartInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                CoverartInfoSerializer.putOptionalCoverartInfo(iSerializer, coverartInfo);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void disableOnlineLookup() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void enableOnlineLookup() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)8, null);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }
}

