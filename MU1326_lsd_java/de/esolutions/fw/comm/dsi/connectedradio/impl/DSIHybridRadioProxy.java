/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.connectedradio.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadio;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioC;
import de.esolutions.fw.comm.dsi.connectedradio.DSIHybridRadioReply;
import de.esolutions.fw.comm.dsi.connectedradio.impl.DSIHybridRadioReplyService;
import de.esolutions.fw.comm.dsi.connectedradio.impl.RadioStationSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.connectedradio.RadioStation;

public class DSIHybridRadioProxy
implements DSIHybridRadio,
DSIHybridRadioC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.connectedradio.DSIHybridRadio");
    private Proxy proxy;

    public DSIHybridRadioProxy(int n, DSIHybridRadioReply dSIHybridRadioReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("bf0a0c09-9f7a-5d42-a5e3-a58d461ed435", n, "e36b89a2-7496-5acc-86ee-24b37288c8fc", "dsi.connectedradio.DSIHybridRadio");
        DSIHybridRadioReplyService dSIHybridRadioReplyService = new DSIHybridRadioReplyService(dSIHybridRadioReply);
        this.proxy = new Proxy(serviceInstanceID, dSIHybridRadioReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void getOnlineRadioAvailability(final int n, final RadioStation[] radioStationArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, radioStationArray);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void getRadioStationLogo(final int n, final RadioStation[] radioStationArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStationVarArray(iSerializer, radioStationArray);
                iSerializer.putInt32(n2);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void cancelGetRadioStationLogo(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    public void getStream(final int n, final RadioStation radioStation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStation(iSerializer, radioStation);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void startSlideshow(final int n, final RadioStation radioStation, final int n2, final int n3) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStation(iSerializer, radioStation);
                iSerializer.putInt32(n2);
                iSerializer.putInt32(n3);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void stopSlideshow(final int n, final RadioStation radioStation) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
                RadioStationSerializer.putOptionalRadioStation(iSerializer, radioStation);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void profileChange(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    public void profileCopy(int n, int n2) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    public void profileReset(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    public void profileResetAll() throws MethodException {
        this.proxy.remoteCallMethod((short)30, null);
    }

    public void setNotification(int[] nArray) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    public void setNotification(int n) throws MethodException {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    public void setNotification() throws MethodException {
        this.proxy.remoteCallMethod((short)13, null);
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
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }
}

