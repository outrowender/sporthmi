/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;

public interface ISelectionManager {
    default public SwdlDSIHandlerSelection getSelectionDSIHandler() {
    }

    default public void updateRingNotOk(boolean bl) {
    }

    default public void updateUserSwdl(boolean bl) {
    }

    default public void updateNfsIpAddress(String string) {
    }

    default public void updateNfsPath(String string) {
    }

    default public void updateFsPath(String string) {
    }

    default public void doGetSourceMedia() {
    }

    default public void updateSourceMediaList(int[] nArray) {
    }

    default public void updateAvailableMedia(byte by) {
    }

    default public void doSelectSourceMedium(int n) {
    }

    default public void preSelectSourceMedium(int n) {
    }

    default public void setDefaultMedium(int n) {
    }

    default public void leaveReadingReleases() {
    }

    default public void updateReleaseList(String[] stringArray, String string, int n) {
    }

    default public void doSelectRelease(int n) {
    }

    default public void leaveReadingMetainfo() {
    }

    default public void updateReleaseResult(String string, int n) {
    }

    default public boolean isUserDefinedMode() {
    }

    default public void updateUserDefinedAllowed(boolean bl) {
    }

    default public void doCheckStartDownload() {
    }

    default public void updateConsistency(int n, boolean bl, String string, int n2) {
    }

    default public void updateIncompatibleDevices(String[] stringArray, String[] stringArray2) {
    }

    default public void doStartVersionUpload() {
    }

    default public void versionUploadDone(boolean bl) {
    }

    default public void enterComponentUpdateConfirmation() {
    }

    default public void removeSwdlDataDir() {
    }
}

