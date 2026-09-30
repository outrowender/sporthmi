/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.IAgentErrorLog;
import de.esolutions.fw.comm.agent.IAgentInfoProvider;
import de.esolutions.fw.comm.agent.IAgentSnapshot;

public interface IAgentDiagnosis {
    public IAgentSnapshot createSnapshot();

    public IAgentErrorLog getErrorLog();

    public void registerInfoProvider(IAgentInfoProvider var1);

    public void unregisterInfoProvider(IAgentInfoProvider var1);
}

