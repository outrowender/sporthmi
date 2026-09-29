/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public class NullProgressManager
implements IProgressManager {
    @Override
    public void init() {
    }

    @Override
    public void updateLostDevices(String[] stringArray) {
    }

    @Override
    public void updateActiveDevices(String[] stringArray) {
    }

    @Override
    public void updateOverviewStatus(int n) {
    }

    @Override
    public void updateGeneralProgress(GeneralProgress generalProgress) {
    }

    @Override
    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
    }

    @Override
    public void selectForDetails(String string) {
    }

    @Override
    public void updateStaticProgressDetails(int n, int n2, short s, String string) {
    }

    @Override
    public void updateDynamicProgressDetails(String string, byte by) {
    }

    @Override
    public void triggerLatestPanel() {
    }

    @Override
    public void triggerPanel(int n) {
    }

    @Override
    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
    }

    @Override
    public void indicateDismissPopUp(int n, String string) {
    }

    @Override
    public String getSelectedDevice() {
        return null;
    }

    @Override
    public boolean swdlProgressEntered() {
        return false;
    }

    @Override
    public void swdlProgressExit() {
    }

    @Override
    public void swdlProgressDetailEntered() {
    }

    @Override
    public void swdlProgressDetailExit() {
    }

    @Override
    public void swdlStartWaitLostDevices() {
    }

    @Override
    public void swdlStopWaitLostDevices() {
    }

    @Override
    public void swdlSummaryEntered() {
    }

    @Override
    public void abortProgress(int n) {
    }

    @Override
    public void abortProgressError(int n) {
    }

    @Override
    public void abortProgressInterrupt(int n) {
    }

    @Override
    public void continueProgressInterrupt() {
    }

    @Override
    public void showPopupMainSKSetupUpdateSummaryInterruptRestart() {
    }

    @Override
    public void custDownloadLeaveProgress(int n) {
    }

    @Override
    public void swdlSummaryExit() {
    }

    @Override
    public void showSummaryUota(boolean bl) {
    }

    @Override
    public void switchUotaProgressState(boolean bl) {
    }

    @Override
    public void showPopupUpdateSuccessful() {
    }

    @Override
    public void versionUploadDone(boolean bl) {
    }
}

