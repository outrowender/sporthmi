/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;

public interface ISelectionManager {
    public SwdlDSIHandlerSelection getSelectionDSIHandler();

    public void updateRingNotOk(boolean var1);

    public void updateUserSwdl(boolean var1);

    public void updateNfsIpAddress(String var1);

    public void updateNfsPath(String var1);

    public void updateFsPath(String var1);

    public void doGetSourceMedia();

    public void updateSourceMediaList(int[] var1);

    public void updateAvailableMedia(byte var1);

    public void doSelectSourceMedium(int var1);

    public void preSelectSourceMedium(int var1);

    public void setDefaultMedium(int var1);

    public void leaveReadingReleases();

    public void updateReleaseList(String[] var1, String var2, int var3);

    public void doSelectRelease(int var1);

    public void leaveReadingMetainfo();

    public void updateReleaseResult(String var1, int var2);

    public boolean isUserDefinedMode();

    public void updateUserDefinedAllowed(boolean var1);

    public void doCheckStartDownload();

    public void updateConsistency(int var1, boolean var2, String var3, int var4);

    public void updateIncompatibleDevices(String[] var1, String[] var2);

    public void doStartVersionUpload();

    public void versionUploadDone(boolean var1);

    public void enterComponentUpdateConfirmation();

    public void removeSwdlDataDir();
}

