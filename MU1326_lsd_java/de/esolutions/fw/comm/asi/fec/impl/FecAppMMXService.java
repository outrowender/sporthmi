/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec.impl;

import de.esolutions.fw.comm.asi.fec.FecAppMMXS;
import de.esolutions.fw.comm.asi.fec.impl.FecAppMMXReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class FecAppMMXService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.fec.FecAppMMX");
    private FecAppMMXS p_FecAppMMX;

    public FecAppMMXService(int n, FecAppMMXS fecAppMMXS) {
        super(new ServiceInstanceID("374197ca-caef-403f-a993-7e171899db9d", n, "44bd5e8c-c0a5-58f5-b4e5-8c4bb4689d0e", "asi.fec.FecAppMMX"));
        this.p_FecAppMMX = fecAppMMXS;
    }

    public IProxyFrontend createReplyProxy() {
        return new FecAppMMXReplyProxy();
    }

    public CallContext getCallContext() {
        return context;
    }

    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) throws MethodException {
        try {
            switch (s) {
                case 9: {
                    int n = iDeserializer.getEnum();
                    this.p_FecAppMMX.registerForFec(n, (FecAppMMXReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    String string = iDeserializer.getOptionalString();
                    short[] sArray = iDeserializer.getOptionalUInt8VarArray();
                    short[] sArray2 = iDeserializer.getOptionalUInt8VarArray();
                    this.p_FecAppMMX.checkPkgSignature(string, sArray, sArray2, (FecAppMMXReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException("Invalid Method Id " + s);
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException("Deserialization failed: method=" + s + ", error=" + serializerException.getMessage());
        }
    }
}

