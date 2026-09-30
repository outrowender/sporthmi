/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent.diag;

import de.esolutions.fw.comm.agent.diag.InfoEntry;
import de.esolutions.fw.comm.agent.diag.InfoStream;
import de.esolutions.fw.comm.core.ServiceInstanceID;

public interface IInfoBase {
    public int getID();

    public long getTimeStamp();

    public String getSimpleClassName();

    public InfoEntry[] getEntries();

    public InfoEntry[] getSortedEntries();

    public ServiceInstanceID getServiceInstanceID();

    public void write(InfoStream var1);
}

