/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.uota;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.uota.PackageInfo;

public interface DSIUotAListener
extends DSIListener {
    public void updateDownloadState(int var1, int var2, int var3);

    public void updateDownloadProgress(int var1, int var2, int var3, String var4, int var5);

    public void getServerList(int var1, String[] var2);

    public void getUpdatePackages(int var1, int var2, PackageInfo[] var3, int[] var4);

    public void toggleSelection(int var1, int var2, int[] var3);

    public void startDownload(int var1, int var2);

    public void triggerAction(int var1, int var2, int var3, String var4);

    public void updatePackagesAvailable(int var1, int var2);

    public void featureResult(String var1, int var2, boolean var3);

    public void attributeResult(int var1, int var2, int var3, String var4);

    public void updateServcieReady(int var1, boolean var2, int var3);

    public void getUpdatePackagesForDestinations(int var1, int var2, PackageInfo[] var3, int[] var4);

    public void getUpdatePackagesViaApp(int var1, int var2, PackageInfo[] var3, int[] var4);

    public void abortDownload(int var1, int var2);

    public void customerDownloadFinished(int var1, int var2);
}

