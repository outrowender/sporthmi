/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public interface IProgressManager {
    default public void init() {
    }

    default public void updateLostDevices(String[] stringArray) {
    }

    default public void updateActiveDevices(String[] stringArray) {
    }

    default public void updateOverviewStatus(int n) {
    }

    default public void updateGeneralProgress(GeneralProgress generalProgress) {
    }

    default public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
    }

    default public void selectForDetails(String string) {
    }

    default public void updateStaticProgressDetails(int n, int n2, short s, String string) {
    }

    default public void updateDynamicProgressDetails(String string, byte by) {
    }

    default public void triggerLatestPanel() {
    }

    default public void triggerPanel(int n) {
    }

    default public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
    }

    default public void indicateDismissPopUp(int n, String string) {
    }

    default public String getSelectedDevice() {
    }

    default public boolean swdlProgressEntered() {
    }

    default public void swdlProgressExit() {
    }

    default public void swdlProgressDetailEntered() {
    }

    default public void swdlProgressDetailExit() {
    }

    default public void swdlStartWaitLostDevices() {
    }

    default public void swdlStopWaitLostDevices() {
    }

    default public void swdlSummaryEntered() {
    }

    default public void swdlSummaryExit() {
    }

    default public void abortProgress(int n) {
    }

    default public void abortProgressError(int n) {
    }

    default public void abortProgressInterrupt(int n) {
    }

    default public void continueProgressInterrupt() {
    }

    default public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    default public void custDownloadLeaveProgress(int n) {
    }

    default public void showSummaryUota(boolean bl) {
    }

    default public void switchUotaProgressState(boolean bl) {
    }

    default public void showPopupUpdateSuccessful() {
    }

    default public void versionUploadDone(boolean bl) {
    }
}

