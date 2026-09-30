/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IASIProvider {
    public IService getService();

    public void attachStub(IStub var1);

    public void detachStub(IStub var1);
}

