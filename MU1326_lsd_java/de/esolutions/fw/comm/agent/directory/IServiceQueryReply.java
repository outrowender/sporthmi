/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceQueryReply {
    public static final int OK = 0;
    public static final int SERVICE_NOT_FOUND = 1;
    public static final int QUERY_TIME_OUT = 2;

    public void serviceQueryResult(ServiceInstanceID var1, DirectoryEntry[] var2);

    public void serviceQueryFailed(ServiceInstanceID var1, int var2);
}

