/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.core;

import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceInstanceListener {
    public void serviceRegistered(ServiceInstanceID var1, short var2);

    public void serviceUnregistered(ServiceInstanceID var1, short var2);
}

