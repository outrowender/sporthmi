/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.RdvRouteOptions;
import de.esolutions.fw.comm.asi.navigation.rdvtypes.impl.RdvRouteOptionsSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocationWgs84;

public class RdvDataProviderReplyProxy
implements RdvDataProviderReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.rdvdataprovider.RdvDataProvider");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public RdvDataProviderReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3ee92857-84ba-4dfa-9faf-1d67977f4b5d", -1, "0b921357-9ff8-587c-9c54-67ccfc58e880", "asi.navigation.rdvdataprovider.RdvDataProvider");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void registerForDataUpdateResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)3, iSerializable);
    }

    public void unregisterForDataUpdateResult(final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)5, iSerializable);
    }

    public void updateDemoModeStatus(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)8, iSerializable);
    }

    public void updateRouteGuidanceStatus(final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)9, iSerializable);
    }

    public void updateCurrentRouteOptions(final RdvRouteOptions rdvRouteOptions) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RdvRouteOptionsSerializer.putOptionalRdvRouteOptions(iSerializer, rdvRouteOptions);
            }
        };
        this.proxy.remoteCallMethod((short)10, iSerializable);
    }

    public void updateCurrentRoute(final NavLocationWgs84[] navLocationWgs84Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, navLocationWgs84Array);
            }
        };
        this.proxy.remoteCallMethod((short)6, iSerializable);
    }

    public void updateStopovers(final NavLocationWgs84[] navLocationWgs84Array) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84VarArray(iSerializer, navLocationWgs84Array);
            }
        };
        this.proxy.remoteCallMethod((short)11, iSerializable);
    }

    public void setRouteProviderSettingResult(final RouteProviderSetting routeProviderSetting, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteProviderSettingSerializer.putOptionalRouteProviderSetting(iSerializer, routeProviderSetting);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)13, iSerializable);
    }

    public void getCurrentPositionResult(final NavLocationWgs84 navLocationWgs84) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

