/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core.method;

import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.IDeserializer;

public interface IMethodHandler {
    public void handleCallMethod(short var1, IDeserializer var2, IProxyFrontend var3) throws MethodException;
}

