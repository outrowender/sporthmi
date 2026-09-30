/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.ProfileInfo;

public interface ADBStateListener {
    public void setAdbReady(boolean var1);

    public void updateProfileInfo(ProfileInfo[] var1, int var2);

    public void updateDownloadState(int var1, int var2);

    public void updateDownloadState2ndPhone(int var1, int var2);

    public void updateNewEntryAvailable(boolean var1);

    public void updateNewPublicProfileEntryAvailable(boolean var1);

    public void updateNewTopDestEntryAvailable(boolean var1);

    public void updateNewPublicProfileTopDestEntryAvailable(boolean var1);

    public void updateViewSizes(AdbViewSize var1);
}

