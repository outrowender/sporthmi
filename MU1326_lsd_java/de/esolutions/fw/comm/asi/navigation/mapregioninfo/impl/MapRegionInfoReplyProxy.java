/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.ComponentInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.ComponentInfoSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class MapRegionInfoReplyProxy
implements MapRegionInfoReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.mapregioninfo.MapRegionInfo");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public MapRegionInfoReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("f6ed3bd2-c174-4a4c-a99f-5ca2e73a72e5", -1, "ea59591a-319c-5eba-8c59-1bc981eda986", "asi.navigation.mapregioninfo.MapRegionInfo");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void replyGetDatabaseInfo(final int n, final ComponentInfo componentInfo, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt16(n);
                ComponentInfoSerializer.putOptionalComponentInfo(iSerializer, componentInfo);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }

    public void replyGetMultipleDatabaseInfo(final int n, final ComponentInfo[] componentInfoArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt16(n);
                ComponentInfoSerializer.putOptionalComponentInfoVarArray(iSerializer, componentInfoArray);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void replyGetRegionsInVicinity(final int n, final ComponentInfo[] componentInfoArray, final int n2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putUInt16(n);
                ComponentInfoSerializer.putOptionalComponentInfoVarArray(iSerializer, componentInfoArray);
                iSerializer.putEnum(n2);
            }
        };
        this.proxy.remoteCallMethod((short)2, iSerializable);
    }
}

