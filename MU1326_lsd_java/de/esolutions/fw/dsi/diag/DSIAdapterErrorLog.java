/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.ErrorLog;
import de.esolutions.fw.comm.agent.diag.IInfoBase;
import de.esolutions.fw.dsi.diag.DispatcherInfo;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.ProviderInfo;

public class DSIAdapterErrorLog
implements IAdapterErrorLog {
    private final ErrorLog dispatcherErrors;
    private final ErrorLog providerErrors;

    public DSIAdapterErrorLog(int n) {
        this.dispatcherErrors = new ErrorLog(n);
        this.providerErrors = new ErrorLog(n);
    }

    public void addDispatcherError(DispatcherInfo dispatcherInfo) {
        this.dispatcherErrors.add(dispatcherInfo);
    }

    public IInfoBase[] getDispatcherErrors() {
        return this.dispatcherErrors.getAllEntries();
    }

    public int getNumDroppedDispatcherErrors() {
        return this.dispatcherErrors.getNumDropped();
    }

    public void addProviderError(ProviderInfo providerInfo) {
        this.providerErrors.add(providerInfo);
    }

    public IInfoBase[] getProviderErrors() {
        return this.providerErrors.getAllEntries();
    }

    public int getNumDroppedProviderErrors() {
        return this.providerErrors.getNumDropped();
    }

    public int getAbsoluteDispatcherErrors() {
        int n = 0;
        if (this.dispatcherErrors.getAllEntries() != null) {
            n = this.dispatcherErrors.getAllEntries().length;
        }
        return n += this.dispatcherErrors.getNumDropped();
    }

    public int getAbsoluteProviderErrors() {
        int n = 0;
        if (this.providerErrors.getAllEntries() != null) {
            n = this.providerErrors.getAllEntries().length;
        }
        return n += this.providerErrors.getNumDropped();
    }
}

