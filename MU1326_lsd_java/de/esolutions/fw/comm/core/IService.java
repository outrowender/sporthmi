/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.IMethodHandler;

public interface IService
extends IMethodHandler {
    public ServiceInstanceID getInstanceID();

    public IProxyFrontend createReplyProxy();

    public CallContext getCallContext();
}

