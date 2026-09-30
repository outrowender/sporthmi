/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.Proxy;

public interface IStub {
    public static final short INVALID_ID = -1;

    public IService getService();

    public short getStubID();

    public short getRemoteProxyID();

    public short getRemoteAgentID();

    public IProxyFrontend getReplyProxyFrontend();

    public Proxy getReplyProxy();

    public Proxy getRequestProxy();
}

