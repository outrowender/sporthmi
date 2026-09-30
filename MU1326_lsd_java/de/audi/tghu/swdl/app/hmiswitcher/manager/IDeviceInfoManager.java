/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

public interface IDeviceInfoManager {
    public static final int ID_NONE = -1;

    public boolean checkAccessType(int var1);

    public boolean isStateView();

    public boolean isStandardSelection();

    public void doGetDevices(int var1, String var2, boolean var3);

    public void doGetModules(int var1);

    public void updateDeviceList(String[] var1, int[] var2, boolean var3);

    public void updateInfoFilePath(String var1, String var2);

    public void updateModuleList(String[] var1, int[] var2, short[] var3);

    public void setIsNoExclusiveBoloUpdate(boolean var1);

    public void setIsDataModule(boolean var1);

    public void updateFileList(String[] var1);

    public void setTargetVersions(long[] var1);

    public void setVersions(long[] var1);

    public void doSelectFile(int var1);

    public void updateFileDetails(String var1);

    public void setAdditionalInfo(int[] var1);

    public void updateErrors(String var1);

    public void updateSummary(String var1);

    public void leaveSummaryChanged();

    public int getCurrentDeviceId();

    public int[] getAllDeviceIds();

    public int getCurrentModuleId();

    public void doSelectDevice(int var1);

    public void doSelectModule(int var1);

    public void doGetFileInfos();

    public void doGetFileInfoPath(int var1);

    public void checkModulesDowngrade();
}

