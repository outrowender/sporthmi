/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

import org.dsi.ifc.base.DSIListener;

public interface DSIOnlineTourImportListener
extends DSIListener {
    public void indicateToursAvailable(int var1);

    public void responseTourDownload(int var1);

    public void indicateTourDownloadFinished(int var1, String var2, String var3, int var4);
}

