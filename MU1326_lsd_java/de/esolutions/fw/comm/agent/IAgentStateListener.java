/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.Agent;

public interface IAgentStateListener {
    public void agentStarted(Agent var1);

    public void agentAboutToStop(Agent var1);
}

