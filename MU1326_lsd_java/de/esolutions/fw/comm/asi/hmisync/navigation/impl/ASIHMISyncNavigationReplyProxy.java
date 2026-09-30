/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.navigation.impl;

import de.esolutions.fw.comm.asi.hmisync.navigation.ASIHMISyncNavigationReply;
import de.esolutions.fw.comm.asi.hmisync.navigation.CarPosition;
import de.esolutions.fw.comm.asi.hmisync.navigation.DestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.NextDestinationInfo;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.CarPositionSerializer;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.DestinationInfoSerializer;
import de.esolutions.fw.comm.asi.hmisync.navigation.impl.NextDestinationInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncNavigationReplyProxy
implements ASIHMISyncNavigationReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.navigation.ASIHMISyncNavigation");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public ASIHMISyncNavigationReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("8d39242f-638c-434c-a3c2-23fe7dad4907", -1, "85677657-50cb-53c6-b534-c27796d5fb16", "asi.hmisync.navigation.ASIHMISyncNavigation");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void startGuidanceToDestinationsResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putInt32(n);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateRequestIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }

    public void updateReplyIDs(final short[] sArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalInt16VarArray(sArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)18, iSerializable);
    }

    public void updateRouteGuidanceActive(final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)16, iSerializable);
    }

    public void updateCarPosition(final CarPosition carPosition, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                CarPositionSerializer.putOptionalCarPosition(iSerializer, carPosition);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void updateDestinationInfo(final DestinationInfo[] destinationInfoArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DestinationInfoSerializer.putOptionalDestinationInfoVarArray(iSerializer, destinationInfoArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void updateDestinationsForGuidance(final DestinationInfo[] destinationInfoArray, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                DestinationInfoSerializer.putOptionalDestinationInfoVarArray(iSerializer, destinationInfoArray);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void updateNextDestinationInfo(final NextDestinationInfo nextDestinationInfo, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NextDestinationInfoSerializer.putOptionalNextDestinationInfo(iSerializer, nextDestinationInfo);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)15, iSerializable);
    }

    public void updateNightDesignRequested(final boolean bl, final boolean bl2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                iSerializer.putBool(bl2);
            }
        };
        this.proxy.remoteCallMethod((short)17, iSerializable);
    }
}

