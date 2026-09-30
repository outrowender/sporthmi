/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.service;

import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IServiceHandlerListener {
    public void serviceStubAttached(IService var1, int var2, IStub var3, IServiceHandlerCallback var4);

    public void serviceStubDetached(IService var1, int var2, IStub var3, IServiceHandlerCallback var4);
}

