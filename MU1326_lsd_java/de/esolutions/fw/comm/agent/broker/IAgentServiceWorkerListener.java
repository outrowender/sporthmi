/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

public interface IAgentServiceWorkerListener {
    public void brokerConnectedToAgentService();

    public void brokerDisconnectedFromAgentService();

    public void brokerCallFailed();
}

