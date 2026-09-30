/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.IProviderStateListener;
import de.esolutions.fw.dsi.base.ProviderState;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public interface IProvider {
    public void addProviderStateListener(IProviderStateListener var1);

    public void removeProviderStateListener(IProviderStateListener var1);

    public ProviderState getProviderState();

    public void startProvider(boolean var1, IDSIServiceWorker var2);

    public IDSIServiceWorker stopProvider();

    public int getInstance();

    public ProviderInfo getProviderInfo(int var1);

    public IDispatcher getDispatcher();
}

