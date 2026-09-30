/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.message.ICallMethodSerializeCallback;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.ISerializable;

public interface IProxyBackend {
    public void remoteCallMethod(short var1, short var2, ISerializable var3, ICallMethodSerializeCallback var4) throws MethodException;

    public void proxyAliveDone(Proxy var1);

    public short getPeerAgentID();
}

