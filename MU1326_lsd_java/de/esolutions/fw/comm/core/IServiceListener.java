/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IServiceListener {
    public void serviceStubCountChanged(IService var1, int var2);

    public void serviceStubAttached(IStub var1);

    public void serviceStubDetached(IStub var1);
}

