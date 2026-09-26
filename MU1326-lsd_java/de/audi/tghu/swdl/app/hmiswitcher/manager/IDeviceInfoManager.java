/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

public interface IDeviceInfoManager {
    public static final int ID_NONE;

    default public boolean checkAccessType(int n) {
    }

    default public boolean isStateView() {
    }

    default public boolean isStandardSelection() {
    }

    default public void doGetDevices(int n, String string, boolean bl) {
    }

    default public void doGetModules(int n) {
    }

    default public void updateDeviceList(String[] stringArray, int[] nArray, boolean bl) {
    }

    default public void updateInfoFilePath(String string, String string2) {
    }

    default public void updateModuleList(String[] stringArray, int[] nArray, short[] sArray) {
    }

    default public void setIsNoExclusiveBoloUpdate(boolean bl) {
    }

    default public void setIsDataModule(boolean bl) {
    }

    default public void updateFileList(String[] stringArray) {
    }

    default public void setTargetVersions(long[] lArray) {
    }

    default public void setVersions(long[] lArray) {
    }

    default public void doSelectFile(int n) {
    }

    default public void updateFileDetails(String string) {
    }

    default public void setAdditionalInfo(int[] nArray) {
    }

    default public void updateErrors(String string) {
    }

    default public void updateSummary(String string) {
    }

    default public void leaveSummaryChanged() {
    }

    default public int getCurrentDeviceId() {
    }

    default public int[] getAllDeviceIds() {
    }

    default public int getCurrentModuleId() {
    }

    default public void doSelectDevice(int n) {
    }

    default public void doSelectModule(int n) {
    }

    default public void doGetFileInfos() {
    }

    default public void doGetFileInfoPath(int n) {
    }

    default public void checkModulesDowngrade() {
    }
}

