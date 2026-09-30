/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

import de.esolutions.fw.comm.comm.broker.v4.InstanceID;
import de.esolutions.fw.comm.core.method.MethodException;

public interface BrokerS {
    public void announce(InstanceID var1) throws MethodException;

    public void registerService(InstanceID var1, int var2) throws MethodException;

    public void unregisterService(InstanceID var1, int var2) throws MethodException;

    public void lookupService(InstanceID var1, int var2) throws MethodException;
}

