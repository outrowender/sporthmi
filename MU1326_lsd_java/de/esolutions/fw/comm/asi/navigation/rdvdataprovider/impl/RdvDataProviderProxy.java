/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl;

import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProvider;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderC;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RdvDataProviderReply;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.RouteProviderSetting;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RdvDataProviderReplyService;
import de.esolutions.fw.comm.asi.navigation.rdvdataprovider.impl.RouteProviderSettingSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class RdvDataProviderProxy
implements RdvDataProvider,
RdvDataProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.rdvdataprovider.RdvDataProvider");
    private Proxy proxy;

    public RdvDataProviderProxy(int n, RdvDataProviderReply rdvDataProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("1c1707c0-995c-4af9-98c2-afe3399d33b6", n, "791334e8-3d42-5162-9439-61521595702c", "asi.navigation.rdvdataprovider.RdvDataProvider");
        RdvDataProviderReplyService rdvDataProviderReplyService = new RdvDataProviderReplyService(rdvDataProviderReply);
        this.proxy = new Proxy(serviceInstanceID, rdvDataProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void registerForDataUpdate() throws MethodException {
        this.proxy.remoteCallMethod((short)2, null);
    }

    public void unregisterForDataUpdate() throws MethodException {
        this.proxy.remoteCallMethod((short)4, null);
    }

    public void setRouteProviderSetting(final RouteProviderSetting routeProviderSetting) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                RouteProviderSettingSerializer.putOptionalRouteProviderSetting(iSerializer, routeProviderSetting);
            }
        };
        this.proxy.remoteCallMethod((short)12, iSerializable);
    }

    public void getCurrentPosition() throws MethodException {
        this.proxy.remoteCallMethod((short)0, null);
    }
}

