/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl;

import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfo;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoC;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.MapRegionInfoReply;
import de.esolutions.fw.comm.asi.navigation.mapregioninfo.impl.MapRegionInfoReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.comm.dsi.global.impl.NavRectangleSerializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.global.NavRectangle;

public class MapRegionInfoProxy
implements MapRegionInfo,
MapRegionInfoC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.mapregioninfo.MapRegionInfo");
    private Proxy proxy;

    public MapRegionInfoProxy(int n, MapRegionInfoReply mapRegionInfoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3beb5497-ae2a-4128-9f05-6068d21ac40f", n, "f203c2e7-a0c6-56da-ae80-1a6f30666d1f", "asi.navigation.mapregioninfo.MapRegionInfo");
        MapRegionInfoReplyService mapRegionInfoReplyService = new MapRegionInfoReplyService(mapRegionInfoReply);
        this.proxy = new Proxy(serviceInstanceID, mapRegionInfoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestGetDatabaseInfo(final NavLocationWgs84 navLocationWgs84, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void requestGetMultipleDatabaseInfo(final NavLocationWgs84[] navLocationWgs84Array, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, navLocationWgs84Array);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)4, iSerializable);
    }

    public void requestGetRegionsInVicinity(final NavRectangle navRectangle, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavRectangleSerializer.putOptionalNavRectangle(iSerializer, navRectangle);
                iSerializer.putUInt16(n);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }
}

