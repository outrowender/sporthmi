/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carstopwatch.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatch;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchC;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchReply;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchReplyService;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.StopWatchTimeSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carstopwatch.StopWatchTime;

public class DSICarStopWatchProxy
implements DSICarStopWatch,
DSICarStopWatchC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.carstopwatch.DSICarStopWatch");
    private Proxy proxy;

    public DSICarStopWatchProxy(int n, DSICarStopWatchReply dSICarStopWatchReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("584611ca-824a-5095-926b-c7c6c33c89aa", n, "0abc5c31-c9dc-54c0-ab3d-316f61979c15", "dsi.carstopwatch.DSICarStopWatch");
        DSICarStopWatchReplyService dSICarStopWatchReplyService = new DSICarStopWatchReplyService(dSICarStopWatchReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarStopWatchReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setStopWatchFastestLapTime(final StopWatchTime stopWatchTime) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StopWatchTimeSerializer.putOptionalStopWatchTime(iSerializer, stopWatchTime);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void setStopWatchLapRating(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    public void setStopWatchLapProgress(float f2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putFloat(f2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    public void setStopWatchLapGPSTrigger() throws MethodException {
        this.proxy.remoteCallMethod((short)9, null);
    }

    public void setStopWatchControl(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    public void setStopWatchSlowestLapTime(final StopWatchTime stopWatchTime) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StopWatchTimeSerializer.putOptionalStopWatchTime(iSerializer, stopWatchTime);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
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

