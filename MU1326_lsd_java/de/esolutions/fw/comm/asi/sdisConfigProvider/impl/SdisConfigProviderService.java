/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.sdisConfigProvider.impl;

import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderReply;
import de.esolutions.fw.comm.asi.sdisConfigProvider.SdisConfigProviderS;
import de.esolutions.fw.comm.asi.sdisConfigProvider.impl.SdisConfigProviderReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class SdisConfigProviderService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.sdisConfigProvider.SdisConfigProvider");
    private SdisConfigProviderS p_SdisConfigProvider;

    public SdisConfigProviderService(int n, SdisConfigProviderS sdisConfigProviderS) {
        super(new ServiceInstanceID("32a49c92-09f0-11e5-ab17-54ee7547f476", n, "55d7aa2c-01c8-521e-badb-7fa67d18f6b4", "asi.sdisConfigProvider.SdisConfigProvider"));
        this.p_SdisConfigProvider = sdisConfigProviderS;
    }

    public IProxyFrontend createReplyProxy() {
        return new SdisConfigProviderReplyProxy();
    }

    public CallContext getCallContext() {
        return context;
    }

    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) throws MethodException {
        try {
            switch (s) {
                case 3: {
                    this.p_SdisConfigProvider.setNotification((SdisConfigProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    long l = iDeserializer.getUInt32();
                    this.p_SdisConfigProvider.setNotification(l, (SdisConfigProviderReply)((SdisConfigProviderReplyProxy)iProxyFrontend));
                    break;
                }
                case 4: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_SdisConfigProvider.setNotification(lArray, (SdisConfigProviderReply)((SdisConfigProviderReplyProxy)iProxyFrontend));
                    break;
                }
                case 0: {
                    this.p_SdisConfigProvider.clearNotification((SdisConfigProviderReplyProxy)iProxyFrontend);
                    break;
                }
                case 2: {
                    long l = iDeserializer.getUInt32();
                    this.p_SdisConfigProvider.clearNotification(l, (SdisConfigProviderReply)((SdisConfigProviderReplyProxy)iProxyFrontend));
                    break;
                }
                case 1: {
                    long[] lArray = iDeserializer.getOptionalUInt32VarArray();
                    this.p_SdisConfigProvider.clearNotification(lArray, (SdisConfigProviderReply)((SdisConfigProviderReplyProxy)iProxyFrontend));
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

