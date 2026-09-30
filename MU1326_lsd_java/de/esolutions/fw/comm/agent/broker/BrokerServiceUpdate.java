/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.broker;

import de.esolutions.fw.comm.core.ServiceInstanceID;

public class BrokerServiceUpdate {
    public static final int SERVICE_REGISTERED = 0;
    public static final int SERVICE_UNREGISTERED = 1;
    public static final int SERVICE_NOT_REGISTERED = 2;
    public static final int NORMAL_OPERATION = 0;
    public static final int DUPLICATE_INSTANCED = 1;
    public static final int INVALID_INSTANCEID = 2;
    public static final int CONNECTION_LOST = 3;
    private final int action;
    private final int reason;
    private final ServiceInstanceID instanceID;
    private final short agent;
    public static final String[] actionNames = new String[]{"registered", "unregistered", "NOT FOUND"};
    public static final String[] reasonNames = new String[]{"normal", "duplicate", "invalid", "connection-lost"};

    public BrokerServiceUpdate(int n, int n2, ServiceInstanceID serviceInstanceID, short s) {
        this.action = n;
        this.reason = n2;
        this.instanceID = serviceInstanceID;
        this.agent = s;
    }

    public int getAction() {
        return this.action;
    }

    public int getReason() {
        return this.reason;
    }

    public ServiceInstanceID getInstanceID() {
        return this.instanceID;
    }

    public short getAgent() {
        return this.agent;
    }
}

