/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.method;

import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;

public interface IMethodCaller {
    public void remoteCallMethod(short var1, ISerializable var2) throws MethodException;
}

