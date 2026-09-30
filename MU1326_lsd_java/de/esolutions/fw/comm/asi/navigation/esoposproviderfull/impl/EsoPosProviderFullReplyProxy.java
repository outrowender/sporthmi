/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl;

import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.EsoPosProviderFullReply;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sConfigSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sMapPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.impl.sPositionSerializer;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sConfig;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sMapPosition;
import de.esolutions.fw.comm.asi.navigation.esoposproviderfull.sPosition;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class EsoPosProviderFullReplyProxy
implements EsoPosProviderFullReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.esoposproviderfull.EsoPosProviderFull");
    private static final int INVALID_HANDLE = -1;
    private Proxy proxy;

    public EsoPosProviderFullReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("4325a74a-4251-11e3-9bb9-000c29e68a4a", -1, "995a4140-c7f3-5205-8335-d13059867b08", "asi.navigation.esoposproviderfull.EsoPosProviderFull");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateState(final boolean bl, final sConfig sConfig2, final int n) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putBool(bl);
                sConfigSerializer.putOptionalsConfig(iSerializer, sConfig2);
                iSerializer.putEnum(n);
            }
        };
        this.proxy.remoteCallMethod((short)21, iSerializable);
    }

    public void updatePosition(final String[] stringArray, final sMapPosition sMapPosition2, final sPosition[] sPositionArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalStringVarArray(stringArray);
                sMapPositionSerializer.putOptionalsMapPosition(iSerializer, sMapPosition2);
                sPositionSerializer.putOptionalsPositionVarArray(iSerializer, sPositionArray);
            }
        };
        this.proxy.remoteCallMethod((short)25, iSerializable);
    }

    public void updateASIVersion(final String string, final boolean bl) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                iSerializer.putOptionalString(string);
                iSerializer.putBool(bl);
            }
        };
        this.proxy.remoteCallMethod((short)19, iSerializable);
    }
}

