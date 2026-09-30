/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;

public interface IBrokerServiceListener {
    public void serviceUpdate(BrokerServiceUpdate[] var1);

    public void agentUpdate(BrokerAgentUpdate[] var1);
}

