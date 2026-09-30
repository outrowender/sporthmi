/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import de.audi.app.addressbook.core.common.ADBDbgUtils;
import de.audi.app.addressbook.core.common.ADBStateListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.ProfileInfo;

public class ADBStateHandler {
    private ADBStateListener adbStateListener;
    private LogChannel log;
    private boolean isAdbInstanceReady = false;
    private ProfileInfo[] profileInfo;
    private int activeProfileNum = -1;
    private boolean isNewEntryAvailable = false;
    private boolean isNewPublicProfileEntryAvailable = false;
    private boolean isNewTopDestEntryAvailable = false;
    private boolean isNewPublicProfileTopDestEntryAvailable = false;
    private AdbViewSize viewSizes = new AdbViewSize();

    public ADBStateHandler(ADBStateListener aDBStateListener, LogChannel logChannel) {
        this.adbStateListener = aDBStateListener;
        this.log = logChannel;
    }

    public void setAdbReady(boolean bl) {
        this.log.log(1000000, "ADBStateHandler#setAdbReady(): ready: %1", bl);
        this.isAdbInstanceReady = bl;
        this.adbStateListener.setAdbReady(this.isAdbInstanceReady);
    }

    public boolean isAdbReady() {
        return this.isAdbInstanceReady;
    }

    public void setProfileInfo(ProfileInfo[] profileInfoArray, int n) {
        if (profileInfoArray == null || profileInfoArray.length == 0 || n < 0 || n >= profileInfoArray.length) {
            this.log.log(10000, "ADBStateHandler#setProfileInfo(): invalid profileInfo/indexOfActiveProfile received! profileInfo: %1; indexOfActiveProfile: %2", (Object)ADBDbgUtils.dbg(profileInfoArray), (long)n);
            return;
        }
        this.profileInfo = profileInfoArray;
        this.activeProfileNum = profileInfoArray[n].num;
        this.adbStateListener.updateProfileInfo(profileInfoArray, n);
    }

    public ProfileInfo getActiveProfileInfo() {
        if (this.profileInfo == null || this.activeProfileNum < 0) {
            this.log.log(this.isAdbReady() ? 10000 : 1000000, "ADBStateHandler#getActiveProfileInfo(): invalid profile info: %1, activeProfile: %2", (Object)ADBDbgUtils.dbg(this.profileInfo), (long)this.activeProfileNum);
            return null;
        }
        for (int i2 = 0; i2 < this.profileInfo.length; ++i2) {
            if (this.profileInfo[i2] == null || this.profileInfo[i2].num != this.activeProfileNum) continue;
            this.log.log(10000000, "ADBStateHandler#getActiveProfileInfo(): returning active profile: %1", (Object)this.profileInfo[i2]);
            return this.profileInfo[i2];
        }
        this.log.log(10000, "ADBStateHandler#getActiveProfileInfo(): no matching profileInfo found for active profile!");
        return null;
    }

    public int getActiveProfile() {
        return this.activeProfileNum;
    }

    public ProfileInfo[] getProfileInfo() {
        return this.profileInfo;
    }

    public void setDownloadState(int n, int n2) {
        this.adbStateListener.updateDownloadState(n, n2);
    }

    public void setDownloadState2ndPhone(int n, int n2) {
        this.adbStateListener.updateDownloadState2ndPhone(n, n2);
    }

    public void setNewEntryAvailable(boolean bl) {
        this.isNewEntryAvailable = bl;
        this.adbStateListener.updateNewEntryAvailable(this.isNewEntryAvailable);
    }

    public boolean isNewEntryAvailable() {
        return this.isNewEntryAvailable;
    }

    public void setNewPublicProfileEntryAvailable(boolean bl) {
        this.isNewPublicProfileEntryAvailable = bl;
        this.adbStateListener.updateNewPublicProfileEntryAvailable(this.isNewPublicProfileEntryAvailable);
    }

    public boolean isNewPublicProfileEntryAvailable() {
        return this.isNewPublicProfileEntryAvailable;
    }

    public void setNewTopDestEntryAvailable(boolean bl) {
        this.isNewTopDestEntryAvailable = bl;
        this.adbStateListener.updateNewTopDestEntryAvailable(this.isNewTopDestEntryAvailable);
    }

    public boolean isNewTopDestEntryAvailable() {
        return this.isNewTopDestEntryAvailable;
    }

    public void setNewPublicProfileTopDestEntryAvailable(boolean bl) {
        this.isNewPublicProfileTopDestEntryAvailable = bl;
        this.adbStateListener.updateNewPublicProfileTopDestEntryAvailable(this.isNewPublicProfileTopDestEntryAvailable);
    }

    public boolean isNewPublicProfileTopDestEntryAvailable() {
        return this.isNewPublicProfileTopDestEntryAvailable;
    }

    public void setViewSize(AdbViewSize adbViewSize) {
        this.viewSizes = adbViewSize;
        this.adbStateListener.updateViewSizes(this.viewSizes);
    }

    public AdbViewSize getViewSizes() {
        return this.viewSizes;
    }
}

