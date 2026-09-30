/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public class NullSelectionManager
implements ISelectionManager {
    public SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return null;
    }

    public void updateRingNotOk(boolean bl) {
    }

    public void updateUserSwdl(boolean bl) {
    }

    public void updateNfsIpAddress(String string) {
    }

    public void updateNfsPath(String string) {
    }

    public void updateFsPath(String string) {
    }

    public void doGetSourceMedia() {
    }

    public void updateSourceMediaList(int[] nArray) {
    }

    public void updateAvailableMedia(byte by) {
    }

    public void doSelectSourceMedium(int n) {
    }

    public void preSelectSourceMedium(int n) {
    }

    public void setDefaultMedium(int n) {
    }

    public void leaveReadingReleases() {
    }

    public void updateReleaseList(String[] stringArray, String string, int n) {
    }

    public void doSelectRelease(int n) {
    }

    public void leaveReadingMetainfo() {
    }

    public void updateReleaseResult(String string, int n) {
    }

    public boolean isUserDefinedMode() {
        return false;
    }

    public void updateUserDefinedAllowed(boolean bl) {
    }

    public void updateSelectedLanguage(short s) {
    }

    public void doCheckStartDownload() {
    }

    public void updateConsistency(int n, boolean bl, String string, int n2) {
    }

    public void updateIncompatibleDevices(String[] stringArray, String[] stringArray2) {
    }

    public void doStartVersionUpload() {
    }

    public void versionUploadDone(boolean bl) {
    }

    public void removeSwdlDataDir() {
    }

    public void enterComponentUpdateConfirmation() {
    }
}

