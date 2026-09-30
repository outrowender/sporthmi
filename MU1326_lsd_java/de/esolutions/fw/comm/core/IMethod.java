/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.method.MethodException;

public interface IMethod {
    public void invoke() throws MethodException;

    public IService getService();

    public short getMethodID();
}

