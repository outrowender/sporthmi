/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public class NullSelectionManager
implements ISelectionManager {
    @Override
    public SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return null;
    }

    @Override
    public void updateRingNotOk(boolean bl) {
    }

    @Override
    public void updateUserSwdl(boolean bl) {
    }

    @Override
    public void updateNfsIpAddress(String string) {
    }

    @Override
    public void updateNfsPath(String string) {
    }

    @Override
    public void updateFsPath(String string) {
    }

    @Override
    public void doGetSourceMedia() {
    }

    @Override
    public void updateSourceMediaList(int[] nArray) {
    }

    @Override
    public void updateAvailableMedia(byte by) {
    }

    @Override
    public void doSelectSourceMedium(int n) {
    }

    @Override
    public void preSelectSourceMedium(int n) {
    }

    @Override
    public void setDefaultMedium(int n) {
    }

    @Override
    public void leaveReadingReleases() {
    }

    @Override
    public void updateReleaseList(String[] stringArray, String string, int n) {
    }

    @Override
    public void doSelectRelease(int n) {
    }

    @Override
    public void leaveReadingMetainfo() {
    }

    @Override
    public void updateReleaseResult(String string, int n) {
    }

    @Override
    public boolean isUserDefinedMode() {
        return false;
    }

    @Override
    public void updateUserDefinedAllowed(boolean bl) {
    }

    public void updateSelectedLanguage(short s) {
    }

    @Override
    public void doCheckStartDownload() {
    }

    @Override
    public void updateConsistency(int n, boolean bl, String string, int n2) {
    }

    @Override
    public void updateIncompatibleDevices(String[] stringArray, String[] stringArray2) {
    }

    @Override
    public void doStartVersionUpload() {
    }

    @Override
    public void versionUploadDone(boolean bl) {
    }

    @Override
    public void removeSwdlDataDir() {
    }

    @Override
    public void enterComponentUpdateConfirmation() {
    }
}

