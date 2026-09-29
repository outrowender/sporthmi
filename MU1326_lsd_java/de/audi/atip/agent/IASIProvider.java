/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IStub;

public interface IASIProvider {
    default public IService getService() {
    }

    default public void attachStub(IStub iStub) {
    }

    default public void detachStub(IStub iStub) {
    }
}

