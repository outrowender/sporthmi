/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public interface IAdapterErrorLog {
    public void addDispatcherError(DispatcherInfo var1);

    public IInfoBase[] getDispatcherErrors();

    public int getNumDroppedDispatcherErrors();

    public int getAbsoluteDispatcherErrors();

    public void addProviderError(ProviderInfo var1);

    public IInfoBase[] getProviderErrors();

    public int getNumDroppedProviderErrors();

    public int getAbsoluteProviderErrors();
}

