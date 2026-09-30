/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.careco.DSICarEco;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoC;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoReply;
import de.esolutions.fw.comm.dsi.careco.impl.BCmEListUpdateInfoSerializer;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoReplyService;
import de.esolutions.fw.comm.dsi.careco.impl.StartStopListUpdateInfoSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public class DSICarEcoProxy
implements DSICarEco,
DSICarEcoC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.careco.DSICarEco");
    private Proxy proxy;

    public DSICarEcoProxy(int n, DSICarEcoReply dSICarEcoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("46a82947-5a7f-5551-83ad-a1637982beaa", n, "e465c6b3-358d-566f-a11e-bef47fad7aee", "dsi.careco.DSICarEco");
        DSICarEcoReplyService dSICarEcoReplyService = new DSICarEcoReplyService(dSICarEcoReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarEcoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestBCmEConsumerList(final BCmEListUpdateInfo bCmEListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCmEListUpdateInfoSerializer.putOptionalBCmEListUpdateInfo(iSerializer, bCmEListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)91, iSerializable);
    }

    public void setBCmELiveTip(int n, boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setBcmeSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)15, null);
    }

    public void requestStartStopProhibitList(final StartStopListUpdateInfo startStopListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StartStopListUpdateInfoSerializer.putOptionalStartStopListUpdateInfo(iSerializer, startStopListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)7, iSerializable);
    }

    public void requestStartStopRestartList(final StartStopListUpdateInfo startStopListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StartStopListUpdateInfoSerializer.putOptionalStartStopListUpdateInfo(iSerializer, startStopListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void requestStartStopRestartProhibitList(final StartStopListUpdateInfo startStopListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                StartStopListUpdateInfoSerializer.putOptionalStartStopListUpdateInfo(iSerializer, startStopListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void requestBCmEConsumerListConsumption(final BCmEListUpdateInfo bCmEListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCmEListUpdateInfoSerializer.putOptionalBCmEListUpdateInfo(iSerializer, bCmEListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)92, iSerializable);
    }

    public void requestBCmEConsumerListRange(final BCmEListUpdateInfo bCmEListUpdateInfo) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                BCmEListUpdateInfoSerializer.putOptionalBCmEListUpdateInfo(iSerializer, bCmEListUpdateInfo);
            }
        };
        this.proxy.remoteCallMethod((short)93, iSerializable);
    }

    public void setRDSetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)19, null);
    }

    public void setEASystem(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)79, genericSerializable);
    }

    public void setEAPedalJerk(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    public void setEASetFactoryDefault() throws MethodException {
        this.proxy.remoteCallMethod((short)78, null);
    }

    public void setEAFreeWheeling(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)86, genericSerializable);
    }

    public void setEAStartStop(boolean bl) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)87, genericSerializable);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)16, null);
    }

    public void clearNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    public void clearNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    public void clearNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)54, genericSerializable);
    }
}

