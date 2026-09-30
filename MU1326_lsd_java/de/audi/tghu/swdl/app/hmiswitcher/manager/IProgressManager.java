/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager;

import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public interface IProgressManager {
    public void init();

    public void updateLostDevices(String[] var1);

    public void updateActiveDevices(String[] var1);

    public void updateOverviewStatus(int var1);

    public void updateGeneralProgress(GeneralProgress var1);

    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] var1);

    public void selectForDetails(String var1);

    public void updateStaticProgressDetails(int var1, int var2, short var3, String var4);

    public void updateDynamicProgressDetails(String var1, byte var2);

    public void triggerLatestPanel();

    public void triggerPanel(int var1);

    public void indicatePopUp(int var1, String var2, byte var3, int var4, int var5, String var6);

    public void indicateDismissPopUp(int var1, String var2);

    public String getSelectedDevice();

    public boolean swdlProgressEntered();

    public void swdlProgressExit();

    public void swdlProgressDetailEntered();

    public void swdlProgressDetailExit();

    public void swdlStartWaitLostDevices();

    public void swdlStopWaitLostDevices();

    public void swdlSummaryEntered();

    public void swdlSummaryExit();

    public void abortProgress(int var1);

    public void abortProgressError(int var1);

    public void abortProgressInterrupt(int var1);

    public void continueProgressInterrupt();

    public void showPopupMainSKSetupUpdateSummaryInterruptRestart();

    public void custDownloadLeaveProgress(int var1);

    public void showSummaryUota(boolean var1);

    public void switchUotaProgressState(boolean var1);

    public void showPopupUpdateSuccessful();

    public void versionUploadDone(boolean var1);
}

