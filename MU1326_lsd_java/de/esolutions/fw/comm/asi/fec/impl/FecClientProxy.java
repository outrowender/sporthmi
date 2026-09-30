/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecClient;
import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.asi.fec.impl.SFecStateSerializer;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;
import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecClientProxy
implements FecClient {
    private static final CallContext context = CallContext.getContext("PROXY.asi.fec.FecClient");
    private Proxy proxy;

    public FecClientProxy(int n) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ff733e4d-6e39-49b8-b354-ee9c22f6cfc9", n, "41fc1271-3ffd-552d-a498-7d1f105d825a", "asi.fec.FecClient");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void updateFECs(final SFecState[] sFecStateArray) throws MethodException {
        ISerializable iSerializable = new ISerializable(){

            public void serialize(ISerializer iSerializer) throws SerializerException {
                SFecStateSerializer.putOptionalSFecStateVarArray(iSerializer, sFecStateArray);
            }
        };
        this.proxy.remoteCallMethod((short)1, iSerializable);
    }
}

