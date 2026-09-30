/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.diag.ErrorLog;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.comm.agent.diag.info.ClientInfo;
import de.esolutions.fw.comm.agent.diag.info.ProxyInfo;
import de.esolutions.fw.comm.agent.diag.info.StubInfo;

public class AgentErrorLog
implements IAgentErrorLog {
    private final ErrorLog proxyErrors;
    private final ErrorLog clientErrors;
    private final ErrorLog stubErrors;

    public AgentErrorLog(int n) {
        this.proxyErrors = new ErrorLog(n);
        this.clientErrors = new ErrorLog(n);
        this.stubErrors = new ErrorLog(n);
    }

    public void addProxyError(ProxyInfo proxyInfo) {
        this.proxyErrors.add(proxyInfo);
    }

    public IInfoBase[] getProxyErrors() {
        return this.proxyErrors.getAllEntries();
    }

    public int getNumDroppedProxyErrors() {
        return this.proxyErrors.getNumDropped();
    }

    public void addClientError(ClientInfo clientInfo) {
        this.clientErrors.add(clientInfo);
    }

    public IInfoBase[] getClientErrors() {
        return this.clientErrors.getAllEntries();
    }

    public int getNumDroppedClientErrors() {
        return this.clientErrors.getNumDropped();
    }

    public void addStubError(StubInfo stubInfo) {
        this.stubErrors.add(stubInfo);
    }

    public IInfoBase[] getStubErrors() {
        return this.stubErrors.getAllEntries();
    }

    public int getNumDroppedStubErrors() {
        return this.stubErrors.getNumDropped();
    }
}

