/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.addressbook.core.common;

import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.ProfileInfo;

public interface ADBStateListener {
    default public void setAdbReady(boolean bl) {
    }

    default public void updateProfileInfo(ProfileInfo[] profileInfoArray, int n) {
    }

    default public void updateDownloadState(int n, int n2) {
    }

    default public void updateDownloadState2ndPhone(int n, int n2) {
    }

    default public void updateNewEntryAvailable(boolean bl) {
    }

    default public void updateNewPublicProfileEntryAvailable(boolean bl) {
    }

    default public void updateNewTopDestEntryAvailable(boolean bl) {
    }

    default public void updateNewPublicProfileTopDestEntryAvailable(boolean bl) {
    }

    default public void updateViewSizes(AdbViewSize adbViewSize) {
    }
}

