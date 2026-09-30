/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.admin;

import de.esolutions.fw.dsi.comm.IDSIServiceWorker;

public interface IProviderService {
    public boolean checkAndClearStopFlag(String var1, int var2);

    public void stopServiceWorker(IDSIServiceWorker var1);
}

