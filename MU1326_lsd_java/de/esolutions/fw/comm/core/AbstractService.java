/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IExtendedService;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class AbstractService
implements IExtendedService {
    protected final ServiceInstanceID instanceID;
    protected Boolean checkIK;

    public AbstractService(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public IProxyFrontend createReplyProxy() {
        return null;
    }

    public CallContext getCallContext() {
        return null;
    }

    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) throws MethodException {
        throw new MethodException("Unknown method: " + s);
    }

    public void setCheckIK(Boolean bl) {
        this.checkIK = bl;
    }

    public Boolean getCheckIK() {
        return this.checkIK;
    }
}

