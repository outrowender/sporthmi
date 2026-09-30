/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.engineering;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.util.StringUtilities;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractProgressManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringDeviceInfoManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringSelectionManager;
import de.audi.tghu.swdl.app.list.SwdlListHandlerProgress;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;
import org.dsi.ifc.swdlprogress.GeneralProgress;

public abstract class AbstractEngineeringProgressManager
extends AbstractProgressManager
implements ButtonListener {
    SwdlListHandlerProgress swdlProgressList;
    boolean readingMetainfo = false;
    volatile boolean changedToProgress = false;
    boolean swdlInProgress = false;
    String selectedProgressDetail = "";
    String selectedProgressDetailTextWithProgress = "";
    String selectedProgressDetailTextWithoutProgress = "";
    private final AbstractEngineeringDeviceInfoManager engineeringDeviceInfoManager;
    private final AbstractEngineeringSelectionManager engineeringSelectionManager;
    private final SwdlDSIHandlerDeviceInfo deviceInfoDSIHandler;
    private final SwdlDSIHandlerSelection selectionDSIHandler;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;
    private volatile boolean isVersionUploadDone = false;

    public AbstractEngineeringProgressManager(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, AbstractEngineeringSelectionManager abstractEngineeringSelectionManager, SwdlDSIHandlerProgress swdlDSIHandlerProgress, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerSelection swdlDSIHandlerSelection) {
        super(swdlEnv, abstractPopupManager, swdlDSIHandlerProgress);
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
        this.deviceInfoDSIHandler = swdlDSIHandlerDeviceInfo;
        this.selectionDSIHandler = swdlDSIHandlerSelection;
        this.engineeringDeviceInfoManager = abstractEngineeringDeviceInfoManager;
        this.engineeringSelectionManager = abstractEngineeringSelectionManager;
        this.swdlProgressList = new SwdlListHandlerProgress(this.getSwdlEnv(), this, this.getSwdlModels().getProgressList());
        this.getSwdlModels().getSummaryRetryButton().setButtonListener(this);
        this.getSwdlModels().getSummaryContinueButton().setButtonListener(this);
        this.getSwdlModels().getRsuUserAbortButton().setButtonListener(this);
        this.getSwdlModels().getInterruptCountdownLabel().setText("\n.");
    }

    private final SwdlDSIHandlerSelection getSelectionDSIHandler() {
        return this.selectionDSIHandler;
    }

    private final SwdlDSIHandlerDeviceInfo getDeviceInfoDSIHandler() {
        return this.deviceInfoDSIHandler;
    }

    private final AbstractEngineeringDeviceInfoManager getEngineeringDeviceInfoManager() {
        return this.engineeringDeviceInfoManager;
    }

    private final AbstractEngineeringSelectionManager getEngineeringSelectionManager() {
        return this.engineeringSelectionManager;
    }

    private boolean isDetailSelected() {
        return this.selectedProgressDetail != null && !"".equals(this.selectedProgressDetail);
    }

    public void updateGeneralProgress(GeneralProgress generalProgress) {
        this.getLogHMI().log(1000000, "SwdlDownloadManager.updateGeneralProgress: %1", (Object)generalProgress);
        String string = this.getTextFactory().getUpdateGeneralProgressText(generalProgress);
        this.getSwdlModels().getProgressLabel().setText(string);
        if (!this.changedToProgress) {
            this.getLogHMI().log(1000000, "Changing to main progress screen generalProgress = %1", (Object)generalProgress);
            this.showProgressScreen();
            this.showProgress(this.getSwdlEnv().getTerminalId());
            this.changedToProgress = true;
        }
    }

    public void updateDevicesOverviewProgress(DeviceOverviewProgress[] deviceOverviewProgressArray) {
        this.swdlProgressList.updateList(deviceOverviewProgressArray);
    }

    public String getSelectedDevice() {
        if (this.swdlInProgress) {
            return this.swdlProgressList.getSelectedDevice();
        }
        return "";
    }

    public void selectForDetails(String string) {
        this.selectedProgressDetail = string;
    }

    public void triggerPanel(int n) {
        this.getLogHMI().log(1000000, "EngineeringProgressManager.triggerPanel(%1)", (long)n);
        if (this.getSwdlEnv().isSwdlHMIActive() || this.getSwdlEnv().isRebootToDownload()) {
            switch (n) {
                case 0: {
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): No trigger panel to activate!");
                    break;
                }
                case 1: {
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): Trigger reboot panel");
                    if (!this.isVersionUploadDone) {
                        this.getSwdlEnv().getHMISwitcher().getProgressManager().swdlProgressExit();
                        this.getSwdlModels().getRebootCountdown().setText("");
                        this.showTriggerReboot(this.getSwdlEnv().getTerminalId());
                        this.getPopupManager().disablePopups();
                        this.getPopupManager().removeAllPopups();
                        this.startRebootCountdown();
                        break;
                    }
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): ignore reboot trigger because version upload is done!");
                    break;
                }
                case 2: {
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): Trigger summary panel");
                    if (this.readingMetainfo) {
                        this.getProgressDSIHandler().stopReadMetadataProgressUpdate();
                        this.readingMetainfo = false;
                    }
                    this.changedToProgress = true;
                    this.getPopupManager().removeAllPopups();
                    this.showSummary(this.getSwdlEnv().getTerminalId());
                    break;
                }
                case 3: {
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): Trigger reading Meta Info panel");
                    if (!this.changedToProgress) {
                        this.readingMetainfo = true;
                        this.getProgressDSIHandler().startReadMetadataProgressUpdate();
                        this.getSwdlEnv().readSwdlInfo();
                        this.showReadMetaInfo(this.getSwdlEnv().getTerminalId());
                        this.getPopupManager().indicateDismissPopUp(15, "");
                        break;
                    }
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): Already switched to main progress. Do not show reading metainfo screen!");
                    break;
                }
                default: {
                    this.getLogHMI().log(10000000, "EngineeringProgressManager.triggerPanel(): ignore triggerPanel( %1 ) Event!", (long)n);
                    break;
                }
            }
        } else if (!this.getSwdlEnv().isRebootToDownload() && !this.getSwdlEnv().isFrontMU() && n == 3) {
            this.getLogHMI().log(100000, "SwdlProgress.updateTriggerPanel: %1, enter joined download!", (long)n);
            this.swdlJoinedDownloadState.startJoinedDownload();
        } else {
            this.getLogHMI().log(100000, "SwdlProgress.updateTriggerPanel: %1, ignore this, no swdl active", (long)n);
            switch (n) {
                case 1: {
                    this.getSwdlModels().getRebootCountdown().setText("");
                    this.showPopupSwdlReboot();
                    this.getPopupManager().disablePopups();
                    this.getPopupManager().removeAllPopups();
                    this.startRebootCountdown();
                    break;
                }
            }
        }
    }

    public void updateLostDevices(String[] stringArray) {
        this.getLogHMI().log(1000000, "SwdlProgress.updateLostDevices: %1", (Object)stringArray);
        String string = this.getTextFactory().getUpdateLostDevicesText(stringArray);
        this.getSwdlModels().getLostDevicesLabel().setText(string);
    }

    public void updateActiveDevices(String[] stringArray) {
        this.getLogHMI().log(1000000, "SwdlProgress.updateActiveDevices: %1", (Object)stringArray);
        if (this.isDetailSelected()) {
            this.getLogHMI().log(1000000, "SwdlProgress.updateActiveDevices: [detailDevice=%1]", (Object)this.selectedProgressDetail);
            String string = this.selectedProgressDetail;
            int n = string.indexOf(47);
            if (n > 0) {
                string = string.substring(0, n - 1);
            }
            for (int i2 = 0; i2 < stringArray.length; ++i2) {
                String string2 = stringArray[i2];
                int n2 = stringArray[i2].lastIndexOf(58);
                if (n2 > 0 && n2 >= stringArray[i2].length() - 3) {
                    string2 = string2.substring(0, n2);
                }
                if (!string.equals(string2)) continue;
                return;
            }
            this.fireSMEventHKReturn(this.getSwdlEnv().getTerminalId());
            this.resetPreviousProgressDetails();
        }
    }

    public void updateStaticProgressDetails(int n, int n2, short s, String string) {
        this.getLogHMI().log(1000000, "SwdlProgress.updateStaticProgressDetails: %1 %2 %3 %4", (Object)string, (Object)Integer.toString(n), (Object)Integer.toString(n2), (Object)new Short(s));
        this.selectedProgressDetailTextWithProgress = this.getTextFactory().getUpdateStaticProgressDetailsWithProgressText(n, n2, s, string);
        this.selectedProgressDetailTextWithoutProgress = this.getTextFactory().getUpdateStaticProgressDetailsWithoutProgressText(n, n2, s, string);
        this.updateDynamicProgressDetails("", (byte)0);
    }

    public void resetPreviousProgressDetails() {
        this.selectedProgressDetailTextWithProgress = "";
        this.selectedProgressDetailTextWithoutProgress = "";
        this.updateDynamicProgressDetails("", (byte)0);
    }

    public void updateDynamicProgressDetails(String string, byte by) {
        this.getLogHMI().log(1000000, "SwdlProgress.updateDynamicProgressDetails: %1 %2", (Object)string, (long)by);
        if (by >= 0) {
            this.getSwdlModels().getProgressDetailLabel().setText(StringUtilities.formatMessage(this.selectedProgressDetailTextWithProgress, new String[]{string, Byte.toString(by)}));
        } else {
            this.getSwdlModels().getProgressDetailLabel().setText(StringUtilities.formatMessage(this.selectedProgressDetailTextWithoutProgress, new String[]{string}));
        }
    }

    public void indicatePopUp(int n, String string, byte by, int n2, int n3, String string2) {
        this.getPopupManager().indicatePopUp(n, string, by, n2, n3, string2);
    }

    public void indicateDismissPopUp(int n, String string) {
        this.getPopupManager().indicateDismissPopUp(n, string);
    }

    public boolean swdlProgressEntered() {
        if (!this.swdlInProgress) {
            this.getSwdlEnv().getLogMain().log(1000000, "swdlProgressEntered(): changedToProgress=%1", this.changedToProgress);
            this.getProgressDSIHandler().startProgressUpdates();
            this.swdlInProgress = true;
        }
        return false;
    }

    public void swdlProgressExit() {
        this.getSwdlEnv().getLogMain().log(1000000, "swdlProgressExit()");
        this.getProgressDSIHandler().stopProgressUpdates();
        this.swdlInProgress = false;
    }

    public void swdlProgressDetailEntered() {
        this.getProgressDSIHandler().notifyForUpdateDetails(this.selectedProgressDetail);
    }

    public void swdlProgressDetailExit() {
        this.selectedProgressDetail = "";
        this.getProgressDSIHandler().notifyForUpdateDetails("");
    }

    public void swdlStartWaitLostDevices() {
        this.getLogHMI().log(1000000, "swdlStartWaitLostDevices()");
        this.getProgressDSIHandler().startLostDeviceNotification();
        this.getProgressDSIHandler().startProgressUpdates();
        this.getSwdlModels().getLostDevicesLabel().setText(this.getTextFactory().getTextConstantProgress3());
    }

    public void swdlStopWaitLostDevices() {
        this.getLogHMI().log(1000000, "swdlStopWaitLostDevices()");
        this.getProgressDSIHandler().stopLostDeviceNotification();
    }

    public void swdlSummaryEntered() {
        this.getLogHMI().log(1000000, "swdlSummaryEntered()");
        this.getDeviceInfoDSIHandler().startSummaryChangedNotification();
        this.getEngineeringDeviceInfoManager().doGetDevices(2, null, true);
        this.getSwdlEnv().setSwdlSummaryEntered(true);
    }

    public void swdlSummaryExit() {
        this.getLogHMI().log(1000000, "swdlSummaryExit()");
        this.getSwdlEnv().setSwdlSummaryEntered(false);
    }

    public void versionUploadDone(boolean bl) {
        this.isVersionUploadDone = bl;
    }

    public void keyPressed(int n, int n2, int n3) {
        this.getLogHMI().log(100000000, "ignore keyPressed(%1) Event!", (long)n);
    }

    public void keyReleased(int n, int n2, int n3) {
        this.getLogHMI().log(100000000, "ignore keyReleased(%1) Event!", (long)n);
    }

    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1000000, "Key Typed: %1", (long)n);
        switch (n) {
            case 1700162: {
                this.getEngineeringDeviceInfoManager().doGetDevices(1, this.getTextFactory().getTextConstantRetryDownload(), true);
                this.getSwdlModels().getSummaryRetryButton().fireEvent(n3);
                break;
            }
            case 1700159: {
                if (this.getSwdlEnv().isFrontMU()) {
                    this.getEngineeringSelectionManager().doStartVersionUpload();
                    this.getSwdlModels().getSummaryContinueButton().fireEvent(n3);
                    break;
                }
                this.getSelectionDSIHandler().abortVersionUpload();
                this.getEngineeringSelectionManager().removeSwdlDataDir();
                break;
            }
            case 1700131: {
                this.getProgressDSIHandler().doHandleUserSelection(1, null, 4);
                this.getSwdlModels().getRsuUserAbortButton().fireEvent(-1);
                break;
            }
            default: {
                this.getLogHMI().log(10000000, "ignore keyTyped(%1) Event!", (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    protected abstract void showProgress(int var1);

    protected abstract void showTriggerReboot(int var1);

    protected abstract void showSummary(int var1);

    protected abstract void showReadMetaInfo(int var1);

    protected abstract void fireSMEventHKReturn(int var1);

    protected abstract void showPopupSwdlReboot();

    protected abstract void showProgressScreen();
}

