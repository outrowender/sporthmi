/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IExtendedReplyService;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public class AbstractReplyService
implements IExtendedReplyService {
    protected ServiceInstanceID instanceID;
    protected Boolean checkIK;

    public AbstractReplyService(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public void setInstanceID(ServiceInstanceID serviceInstanceID) {
        this.instanceID = serviceInstanceID;
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

