/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.travelguide.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuide;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideC;
import de.esolutions.fw.comm.dsi.travelguide.DSITravelGuideReply;
import de.esolutions.fw.comm.dsi.travelguide.impl.DSITravelGuideReplyService;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSITravelGuideProxy
implements DSITravelGuide,
DSITravelGuideC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.travelguide.DSITravelGuide");
    private Proxy proxy;

    public DSITravelGuideProxy(int n, DSITravelGuideReply dSITravelGuideReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("375a0462-7d36-50c5-89ae-91e39a81851f", n, "cc5c2ccc-acd7-501a-a3c3-4347cd1c5255", "dsi.travelguide.DSITravelGuide");
        DSITravelGuideReplyService dSITravelGuideReplyService = new DSITravelGuideReplyService(dSITravelGuideReply);
        this.proxy = new Proxy(serviceInstanceID, dSITravelGuideReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void importTravelGuide(final ResourceLocator resourceLocator) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void deleteTravelGuide(long l) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }
}

