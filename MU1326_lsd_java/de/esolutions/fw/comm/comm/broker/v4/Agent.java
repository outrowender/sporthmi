/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.AgentUpdateEvent;
import de.esolutions.fw.comm.comm.broker.v4.UpdateEvent;
import de.esolutions.fw.comm.core.method.MethodException;

public interface Agent {
    public static final String IPL_COMM_UUID = "78a07e56-255a-4309-8bde-b1e1c73bc71c";
    public static final String IPL_COMM_INTERFACE_KEY = "299585a3-5e89-5854-a716-dafd54af2e50";
    public static final String IPL_COMM_INTERFACE_VERSION = "4.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "4.0.1";

    public void serviceUpdate(UpdateEvent[] var1) throws MethodException;

    public void agentUpdate(AgentUpdateEvent[] var1) throws MethodException;

    public static interface Consts {
    }
}

