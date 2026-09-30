/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.core.ILifecycleListener;

public interface IAgentLifecycleListener
extends ILifecycleListener {
    public void brokerLinkStateChanged(boolean var1);

    public void brokerConnectRetry(boolean var1);

    public void agentIdUpdate(short var1);

    public Short getAgentIdProposal();
}

