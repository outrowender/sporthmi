/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.agent;

import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.method.MethodException;

public interface IASICall {
    public void call(IProxyFrontend var1) throws MethodException;
}

