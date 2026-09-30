/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.swdldeviceinfo;

import org.dsi.ifc.base.DSIListener;

public interface DSISwdlDeviceInfoListener
extends DSIListener {
    public void updateSummaryChanged(String var1, int var2);

    public void getDevices(String[] var1, int[] var2);

    public void getModules(int var1, String[] var2, int[] var3, short[] var4);

    public void getLanguages(int var1, String[] var2, short var3, short var4, short var5);

    public void getErrors(int var1, int[] var2, short[] var3);

    public void isDataModule(int var1, int var2, boolean var3);

    public void isNoExclusiveBoloUpdate(int var1, int var2, boolean var3);

    public void getVersions(int var1, int var2, long[] var3);

    public void getTargetVersions(int var1, int var2, long[] var3);

    public void getAdditionalInfo(int var1, int var2, int[] var3);

    public void getFileNames(int var1, int var2, String[] var3);

    public void getFileDetails(int var1, int var2, int var3, long var4, long var6, long var8, boolean var10, boolean var11, String var12, String var13);

    public void getInfoFilePath(int var1, String var2, String var3);

    public void getNumberOfPopups(int var1);

    public void getPopup(int var1, int var2, String var3, int var4, int var5, int var6, String var7);
}

