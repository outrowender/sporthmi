/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.core.method.MethodException;

public interface AgentS {
    public void serviceUpdate(UpdateEvent[] var1) throws MethodException;

    public void agentUpdate(AgentUpdateEvent[] var1) throws MethodException;
}

