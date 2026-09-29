/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app;

import de.audi.atip.log.LogChannel;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.AbstractSwdlTextFactory;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.SwdlModels;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.hmiswitcher.HMISwitcher;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ILoggingManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.IProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.ISelectionManager;

public abstract class AbstractSwdlActionProxy {
    private final SwdlEnv swdlEnv;
    private final HMISwitcher hmiSwitcher;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    private final AbstractPopupManager popupManager;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;
    private final SwdlDSIHandlerProgress progressDSIHandler;
    private final AbstractSwdlTextFactory swdlTextFactory;

    public AbstractSwdlActionProxy(SwdlEnv swdlEnv, HMISwitcher hMISwitcher, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerProgress swdlDSIHandlerProgress, AbstractSwdlTextFactory abstractSwdlTextFactory) {
        this.swdlEnv = swdlEnv;
        this.hmiSwitcher = hMISwitcher;
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
        this.popupManager = abstractPopupManager;
        this.deviceInfoDSIHandler = swdlDSIHandlerDeviceInfo;
        this.progressDSIHandler = swdlDSIHandlerProgress;
        this.swdlTextFactory = abstractSwdlTextFactory;
    }

    private final AbstractSwdlTextFactory getSwdlTextFactory() {
        return this.swdlTextFactory;
    }

    private final AbstractPopupManager getPopupManager() {
        return this.popupManager;
    }

    private final SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    private final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    private final AbstractSwdlJoinedDownloadState getSwdlJoinedDownloadState() {
        return this.swdlJoinedDownloadState;
    }

    private final HMISwitcher getHmiSwitcher() {
        return this.hmiSwitcher;
    }

    private final SwdlEnv getSwdlEnv() {
        return this.swdlEnv;
    }

    private final LogChannel getLogMain() {
        return this.getSwdlEnv().getLogMain();
    }

    private final SwdlModels getSwdlModels() {
        return this.getSwdlEnv().getSwdlModels();
    }

    private final ISelectionManager getSelectionManager() {
        return this.getHmiSwitcher().getSelectionManager();
    }

    private final IDeviceInfoManager getDeviceManager() {
        return this.getHmiSwitcher().getDeviceInfoManager();
    }

    private final ILoggingManager getLoggingManager() {
        return this.getHmiSwitcher().getLoggingManager();
    }

    private final IProgressManager getProgressManager() {
        return this.getHmiSwitcher().getProgressManager();
    }

    public void swdlAbortReadingMetainfo(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlLeaveReadingMetainfo()");
        this.getProgressDSIHandler().stopReadMetadataProgressUpdate();
        this.getSelectionManager().leaveReadingMetainfo();
    }

    public void swdlAbortReadingReleases(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlLeaveReadingReleases()");
        this.getProgressDSIHandler().stopReadMetadataProgressUpdate();
        this.getSelectionManager().leaveReadingReleases();
    }

    public void swdlAppBlSelectLeft(int n) {
        this.getSwdlModels().getAppBlSelect().setValue(1);
    }

    public void swdlDeviceSelectEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlDeviceSelectEntered()");
        this.getDeviceManager().doGetDevices(1, null, true);
    }

    public void swdlDeviceSelectLeft(int n) {
        this.getSwdlModels().getDeviceStatusEnteredChoice().setStatus(0);
    }

    public void swdlEntered(int n) {
        this.getSwdlEnv().enterSwdl(n);
        this.getHmiSwitcher().switchToEngineeringHmi();
        this.getHmiSwitcher().initEngineeringHMI();
    }

    public void swdlExit(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlExit()");
        this.getHmiSwitcher().deinitEngineeringHMI();
        this.getSwdlEnv().exitSwdl();
    }

    public void swdlInterruptDownload(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlInterruptDownload()");
        if (!this.getSwdlJoinedDownloadState().isJoinedDownload()) {
            String string = this.getProgressManager().getSelectedDevice();
            this.getLogMain().log(-2137614336, "[AbstractSwdlActionProxy] swdlInterruptDownload() Currently selected device is: %1", (Object)string);
            this.getPopupManager().indicatePopUp(1, string, (byte)20, 0, 0, this.getSwdlTextFactory().getTextConstantInterruptDownload());
        } else {
            this.interruptRSUDownload(this.getSwdlEnv().getTerminalId());
        }
    }

    public void swdlLeavePopupByHKReturn(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlLeavePopupByHKReturn()");
        this.getPopupManager().handleHKReturn();
    }

    public void swdlLeaveSummaryChanged(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlLeaveSummaryChanged()");
        this.getDeviceManager().leaveSummaryChanged();
    }

    public void swdlLoggingEntered(int n) {
        this.getLogMain().log(-2137614336, "[AbstractSwdlActionProxy] swdlLoggingEntered: get update history");
        this.getLoggingManager().doGetHistory();
    }

    public void swdlModuleSelectEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlModuleSelectEntered()");
        this.getDeviceManager().doGetModules(this.getDeviceManager().getCurrentDeviceId());
    }

    public void swdlModuleSelectLeft(int n) {
        this.getSwdlModels().getModuleSelect().setValue(1);
    }

    public void swdlProgressDetailEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlProgressDetailEntered()");
        this.getProgressManager().swdlProgressDetailEntered();
    }

    public void swdlProgressDetailExit(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlProgressDetailExit()");
        this.getProgressManager().swdlProgressDetailExit();
    }

    public void swdlProgressEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlProgressEntered()");
        this.getProgressManager().swdlProgressEntered();
    }

    public void swdlProgressExit(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlProgressExit()");
        this.getProgressManager().swdlProgressExit();
    }

    public void swdlRebootEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlRebootEntered()");
    }

    public void swdlSelectOneRelease(int n) {
        this.getSelectionManager().doSelectRelease(0);
    }

    public void swdlStartWaitLostDevices(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlStartWaitLostDevices()");
        this.getProgressManager().swdlStartWaitLostDevices();
    }

    public void swdlStopWaitLostDevices(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlStopWaitLostDevices()");
        this.getProgressManager().swdlStopWaitLostDevices();
    }

    public void swdlSummaryEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlSummaryEntered()");
        this.getProgressManager().swdlSummaryEntered();
    }

    public void swdlSummaryExit(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlSummaryExit()");
        this.getDeviceInfoDSIHandler().stopSummaryChangedNotification();
        this.getProgressManager().swdlSummaryExit();
    }

    public void swdlTriggerEntered(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlTriggerEntered()");
        this.getProgressDSIHandler().startProgressUpdates();
    }

    public void swdlTriggerExit(int n) {
        this.getLogMain().log(1078071040, "[AbstractSwdlActionProxy] swdlTriggerExit()");
        this.getSwdlEnv().storeDummySwdlInfo();
        this.getSwdlEnv().cleanSwdlCopy();
    }

    public void swdlCustomerUpdateEntered(int n) {
    }

    public void swdlCustomerUpdateLeft(int n) {
    }

    protected abstract void interruptRSUDownload(int n) {
    }
}

