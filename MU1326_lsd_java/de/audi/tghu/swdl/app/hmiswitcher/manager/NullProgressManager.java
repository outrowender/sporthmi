/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class NullProgressManager
implements IProgressManager {
    public void init() {
    }

    public void updateLostDevices(String[] stringArray) {
    }

    public void updateActiveDevices(String[] stringArray) {
    }

    public void updateOverviewStatus(int n) {
    }

    public void updateGeneralProgress(GeneralProgress generalProgress) {
    }

    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
    }

    public void selectForDetails(String string) {
    }

    public void updateStaticProgressDetails(int n, int n2, short s, String string) {
    }

    public void updateDynamicProgressDetails(String string, byte by) {
    }

    public void triggerLatestPanel() {
    }

    public void triggerPanel(int n) {
    }

    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
    }

    public void indicateDismissPopUp(int n, String string) {
    }

    public String getSelectedDevice() {
        return null;
    }

    public boolean swdlProgressEntered() {
        return false;
    }

    public void swdlProgressExit() {
    }

    public void swdlProgressDetailEntered() {
    }

    public void swdlProgressDetailExit() {
    }

    public void swdlStartWaitLostDevices() {
    }

    public void swdlStopWaitLostDevices() {
    }

    public void swdlSummaryEntered() {
    }

    public void abortProgress(int n) {
    }

    public void abortProgressError(int n) {
    }

    public void abortProgressInterrupt(int n) {
    }

    public void continueProgressInterrupt() {
    }

    public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    public void custDownloadLeaveProgress(int n) {
    }

    public void swdlSummaryExit() {
    }

    public void showSummaryUota(boolean bl) {
    }

    public void switchUotaProgressState(boolean bl) {
    }

    public void showPopupUpdateSuccessful() {
    }

    public void versionUploadDone(boolean bl) {
    }
}

