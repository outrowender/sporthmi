/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IProxyConnector
extends IProxyListener {
    public void connectProxy(Proxy var1);

    public void disconnectProxy(Proxy var1);

    public void registerProxyListener(Proxy var1, IProxyListener var2, boolean var3);

    public void registerRemoteReplyService(ServiceInstanceID var1, short var2);

    public void unregisterRemoteReplyService(ServiceInstanceID var1, short var2);
}

