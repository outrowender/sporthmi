/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs.impl;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProvider;
import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderC;
import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.NCFSProviderReplyService;
import de.esolutions.fw.comm.asi.navigation.ncfs.impl.sBoundingBoxSerializer;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class NCFSProviderProxy
implements NCFSProvider,
NCFSProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.navigation.ncfs.NCFSProvider");
    private Proxy proxy;

    public NCFSProviderProxy(int n, NCFSProviderReply nCFSProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("93230d7c-f001-4f4e-b59b-75d947a01065", n, "6e1126d6-ac37-5862-92a7-b77a9a12ac7d", "asi.navigation.ncfs.NCFSProvider");
        NCFSProviderReplyService nCFSProviderReplyService = new NCFSProviderReplyService(nCFSProviderReply);
        this.proxy = new Proxy(serviceInstanceID, nCFSProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void requestVZORestrictions(final sBoundingBox sBoundingBox2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }

    public void requestLGI(final sBoundingBox sBoundingBox2) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                sBoundingBoxSerializer.putOptionalsBoundingBox(iSerializer, sBoundingBox2);
            }
        };
        this.proxy.remoteCallMethod((short)0, iSerializable);
    }
}

