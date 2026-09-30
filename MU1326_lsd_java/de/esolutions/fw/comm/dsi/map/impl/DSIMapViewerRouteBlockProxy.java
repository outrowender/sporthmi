/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlock;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlockC;
import de.esolutions.fw.comm.dsi.map.DSIMapViewerRouteBlockReply;
import de.esolutions.fw.comm.dsi.map.impl.DSIMapViewerRouteBlockReplyService;
import de.esolutions.fw.comm.dsi.map.impl.PointSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.map.Point;

public class DSIMapViewerRouteBlockProxy
implements DSIMapViewerRouteBlock,
DSIMapViewerRouteBlockC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.map.DSIMapViewerRouteBlock");
    private Proxy proxy;

    public DSIMapViewerRouteBlockProxy(int n, DSIMapViewerRouteBlockReply dSIMapViewerRouteBlockReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("44d50592-991b-517a-926e-e7513bf821ce", n, "a18091b4-6261-5e53-af9e-c31b1f36c4d0", "dsi.map.DSIMapViewerRouteBlock");
        DSIMapViewerRouteBlockReplyService dSIMapViewerRouteBlockReplyService = new DSIMapViewerRouteBlockReplyService(dSIMapViewerRouteBlockReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMapViewerRouteBlockReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void rBMarkNextSegment() throws MethodException {
        this.proxy.remoteCallMethod((short)8, null);
    }

    public void rBMarkPreviousSegment() throws MethodException {
        this.proxy.remoteCallMethod((short)10, null);
    }

    public void rBSetSegmentScales(long l, long l2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    public void rBStartOfSelection() throws MethodException {
        this.proxy.remoteCallMethod((short)13, null);
    }

    public void pickSegmentUidsInScreenSpace(final Point point, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                PointSerializer.putOptionalPoint(iSerializer, point);
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void highLightSegmentUidsInMap(long[] lArray, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putBool(bl);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)15, null);
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
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }
}

