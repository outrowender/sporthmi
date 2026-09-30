/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayer;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerLandmarkPlayerReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerLandmarkPlayerReplyService;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Point;

public class DSIMapViewerLandmarkPlayerProxy
implements DSIMapViewerLandmarkPlayer,
DSIMapViewerLandmarkPlayerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerLandmarkPlayer");
    private Proxy proxy;

    public DSIMapViewerLandmarkPlayerProxy(int n, DSIMapViewerLandmarkPlayerReply dSIMapViewerLandmarkPlayerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1945ffac-113f-5ea3-a4be-edd3fa5eee39", n, "b04d0457-4466-56f6-b245-d20642571a45", "dsi.map.DSIMapViewerLandmarkPlayer");
        DSIMapViewerLandmarkPlayerReplyService dSIMapViewerLandmarkPlayerReplyService = new DSIMapViewerLandmarkPlayerReplyService(dSIMapViewerLandmarkPlayerReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerLandmarkPlayerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void hideLandmark() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void showLandmark(final Point point, final long l) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PointSerializer.putOptionalPoint(iSerializer, point);
                iSerializer.putInt64(l);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)5, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

