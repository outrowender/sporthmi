/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.directory;

import de.esolutions.fw.comm.agent.diag.info.ServiceLocatorInfo;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IServiceDirectory {
    public void registerService(DirectoryEntry var1);

    public void unregisterService(DirectoryEntry var1);

    public DirectoryEntry[] locateService(ServiceInstanceID var1);

    public void addEmptyService(ServiceInstanceID var1);

    public DirectoryEntry[] getAllEntries();

    public ServiceInstanceID[] getAllEmptyEntries();

    public DirectoryEntry[] removeAllEntriesOfPeer(short var1);

    public void dumpDirectory(short var1);

    public ServiceLocatorInfo[] createServiceLocatorInfos();
}

