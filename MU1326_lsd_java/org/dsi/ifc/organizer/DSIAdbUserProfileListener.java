/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public interface DSIAdbUserProfileListener
extends DSIListener {
    public void updateProfileInfo(ProfileInfo[] var1, int var2, int var3);

    public void updateDeviceConnected(boolean var1, int var2);

    public void updateDownloadCountSim(DownloadInfo var1, int var2);

    public void updateDownloadCountMe(DownloadInfo var1, int var2);

    public void updateDownloadCountOpp(DownloadInfo var1, int var2);

    public void updateDownloadState(int var1, int var2, int var3);

    public void newDeviceConnected(String var1);

    public void downloadToProfileResult(int var1);

    public void restartDownloadResult(int var1);

    public void profileDeleted(int var1);

    public void setProfileNameResult(int var1);

    public void deleteProfilesResult(int var1);

    public void commonEntryCountResult(int var1, int var2);

    public void entryMeterResult(int var1, EntryMeter[] var2);

    public void setPairingCodeResult(int var1);

    public void setHomeIdResult(int var1);

    public void updateDownloadState2ndPhone(int var1, int var2, int var3);

    public void setSOSButtonResult(int var1);

    public void updateSOSButton(boolean var1, int var2);
}

