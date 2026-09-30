/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IMethod;
import de.esolutions.fw.comm.core.IService;

public interface IServiceWorker {
    public void registerService(IService var1);

    public void unregisterService(IService var1);

    public void stubCountChanged(IService var1, int var2);

    public void enqueueCall(IMethod var1);
}

