/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.swdl.app.hmiswitcher.manager.engineering;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.hmi.model.SpellerListener;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.swdl.app.AbstractSwdlJoinedDownloadState;
import de.audi.tghu.swdl.app.PropertiesAccessor;
import de.audi.tghu.swdl.app.SwdlEnv;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerDeviceInfo;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerProgress;
import de.audi.tghu.swdl.app.dsi.SwdlDSIHandlerSelection;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractPopupManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.AbstractSelectionManager;
import de.audi.tghu.swdl.app.hmiswitcher.manager.engineering.AbstractEngineeringDeviceInfoManager;
import de.audi.tghu.swdl.app.list.SwdlListHandlerMedium;
import de.audi.tghu.swdl.app.list.SwdlListHandlerRelease;
import de.audi.tghu.swdl.app.list.SwdlListItemMedium;
import de.audi.tghu.swdl.app.list.SwdlListItemRelease;
import de.esolutions.fw.util.commons.Buffer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public abstract class AbstractEngineeringSelectionManager
extends AbstractSelectionManager
implements ButtonListener,
SpellerListener {
    private static final String[] EMPTYSTRINGARRAY = new String[0];
    private static final int MAX_NETWORK_PATH_LENGTH = 127;
    private static final long VERSION_UPLOAD_AUTO_RESTART_TIMEOUT = 3000L;
    SwdlListHandlerMedium swdlMediumList;
    SwdlListHandlerRelease swdlReleaseList;
    SwdlListItemMedium currentMedium = null;
    SwdlListItemRelease currentRelease = null;
    int defaultmedium = -1;
    private final SwdlDSIHandlerProgress progressDSIHandler;
    private final AbstractSwdlJoinedDownloadState swdlJoinedDownloadState;

    public AbstractEngineeringSelectionManager(SwdlEnv swdlEnv, AbstractSwdlJoinedDownloadState abstractSwdlJoinedDownloadState, AbstractPopupManager abstractPopupManager, AbstractEngineeringDeviceInfoManager abstractEngineeringDeviceInfoManager, SwdlDSIHandlerSelection swdlDSIHandlerSelection, SwdlDSIHandlerDeviceInfo swdlDSIHandlerDeviceInfo, SwdlDSIHandlerProgress swdlDSIHandlerProgress) {
        super(swdlEnv, abstractPopupManager, abstractEngineeringDeviceInfoManager, swdlDSIHandlerSelection, swdlDSIHandlerDeviceInfo);
        this.swdlJoinedDownloadState = abstractSwdlJoinedDownloadState;
        this.progressDSIHandler = swdlDSIHandlerProgress;
        this.getLogHMI().log(10000000, "new EngineeringSelectionManager()");
        this.swdlMediumList = new SwdlListHandlerMedium(this.getSwdlEnv(), this, this.getSwdlModels().getMediaList());
        this.swdlReleaseList = new SwdlListHandlerRelease(this.getSwdlEnv(), this, this.getSwdlModels().getReleaseList());
        this.getSwdlModels().getIgnoreBusyDeviceButton().setButtonListener(this);
        this.getSwdlModels().getAbortReadMetaInfoButton().setButtonListener(this);
        this.getSwdlModels().getAbortReadReleaseButton().setButtonListener(this);
        this.getSwdlModels().getSelectUpdateStandardButton().setButtonListener(this);
        this.getSwdlModels().getSelectUpdateUserDefinedButton().setButtonListener(this);
        this.getSwdlModels().getCheckStartDownloadButton().setButtonListener(this);
        this.getSwdlModels().getSwdlDowngradeContinueButtonModel().setButtonListener(this);
        this.getSwdlModels().getStartDownloadButton().setButtonListener(this);
        this.getSwdlModels().getAbortDownloadButton().setButtonListener(this);
        this.getSwdlModels().getAbortVersionComparisonButton().setButtonListener(this);
        this.getSwdlModels().getRestartVersionComparisonButton().setButtonListener(this);
        this.getSwdlModels().getRSUSelectDownloadMediaSelectButton().setButtonListener(this);
        this.getSwdlModels().getRSUSelectDownloadMediaAbortButton().setButtonListener(this);
        this.getSwdlModels().getMUAbortMediaSelectAtRSU().setButtonListener(this);
        this.getSwdlModels().getIpSpeller().setSpellerListener(this);
        this.getSwdlModels().getFsPathSpeller().setSpellerListener(this);
        this.getSwdlModels().getFsPathSpeller().setMaxLength(127);
        this.getSwdlModels().getStatusDeviceSelectButton().setButtonListener(this);
        this.getSwdlModels().getNetworkMediumAvailableChoice().setValue(0);
    }

    private final SwdlDSIHandlerProgress getProgressDSIHandler() {
        return this.progressDSIHandler;
    }

    public void updateSourceMediaList(int[] nArray) {
        this.getLogHMI().log(1000000, "<- updateMediaList(%1)", (Object)nArray);
        if (this.containsNetworkMedium(nArray)) {
            this.getSwdlModels().getNetworkMediumAvailableChoice().setValue(1);
        } else {
            this.getSwdlModels().getNetworkMediumAvailableChoice().setValue(0);
        }
        this.swdlMediumList.updateList(nArray);
        this.selectDefaultMedium();
    }

    public void updateAvailableMedia(byte by) {
        this.getLogHMI().log(1000000, "<- updateAvailableMedia( %1 ) ", (long)by);
        this.swdlMediumList.updateAvailableMedia(by);
    }

    private boolean containsNetworkMedium(int[] nArray) {
        boolean bl = false;
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            if (nArray[i2] != 6 && nArray[i2] != 1) continue;
            bl = true;
            break;
        }
        return bl;
    }

    private void selectDefaultMedium() {
        if (this.defaultmedium >= 0) {
            try {
                SwdlListItemMedium[] swdlListItemMediumArray = (SwdlListItemMedium[])this.swdlMediumList.getEntries();
                for (int i2 = 0; i2 < swdlListItemMediumArray.length; ++i2) {
                    if (swdlListItemMediumArray[i2] == null || swdlListItemMediumArray[i2].getId() != this.defaultmedium) continue;
                    this.getLogHMI().log(1000000, "setDefaultMedium(%1), select line %2", (long)this.defaultmedium, (long)i2);
                    this.swdlMediumList.getList().setSelected(i2);
                    return;
                }
                this.getLogHMI().log(10000000, "setDefaultMedium(%1), not found in media list", (long)this.defaultmedium);
            }
            catch (Exception exception) {
                this.getLogHMI().log(100000, "setDefaultMedium(%1), failed", (long)this.defaultmedium, (Throwable)exception);
            }
        }
    }

    public void setDefaultMedium(int n) {
        this.defaultmedium = n;
        this.selectDefaultMedium();
    }

    public void doSelectSourceMedium(int n) {
        this.getLogHMI().log(1000000, "-> doSelectMedium(%1)", (long)n);
        this.currentMedium = (SwdlListItemMedium)this.swdlMediumList.getEntry(n);
        this.getSwdlModels().getMediumChoice().setValue(this.currentMedium.getId());
        this.swdlReleaseList.setBase(this.currentMedium);
        this.updateReleaseList(EMPTYSTRINGARRAY, null, 0);
        if (this.swdlJoinedDownloadState.isJoinedDownload() && !this.getSwdlEnv().isFrontMU()) {
            this.getProgressDSIHandler().doHandleMediumSelection(12, "", (byte)this.currentMedium.getId(), 6);
            this.getPopupManager().indicateDismissPopUp(12, "");
            return;
        }
        this.getSelectionDSIHandler().doSetMedium(this.currentMedium.getId());
    }

    public void updateMediumResult(String string, int n) {
        if (n == 0) {
            this.getSwdlModels().getMessageLabel().setText(this.getTextFactory().getTextConstantWaiting());
            this.getSwdlModels().getSelectMediumStateChoice().setValue(0);
            this.getSwdlModels().getSelectMediumStateChoice().setStatus(0);
        } else if (n == 1) {
            this.getSwdlModels().getMessageLabel().setText(this.getTextFactory().getTextConstantOK());
            this.getSwdlModels().getSelectMediumStateChoice().setValue(1);
            this.getSwdlModels().getSelectMediumStateChoice().setStatus(1);
        } else {
            this.getSwdlModels().getMessageLabel().setText(string);
            this.getSwdlModels().getSelectMediumStateChoice().setValue(-1);
            this.getSwdlModels().getSelectMediumStateChoice().setStatus(1);
        }
    }

    public void updateReleaseList(String[] stringArray, String string, int n) {
        this.getLogHMI().log(1000000, "updateReleaseList(%1, %2, %3)", (Object)stringArray, (Object)string, (long)n);
        if (n == 1) {
            this.swdlReleaseList.updateList(stringArray);
        }
        this.updateMediumResult(string, n);
    }

    public void doSelectRelease(int n) {
        this.getLogHMI().log(1000000, "-> doSelectRelease(%1)", (long)n);
        this.currentRelease = (SwdlListItemRelease)this.swdlReleaseList.getEntry(n);
        this.getSwdlModels().getReleaseLabel().setText(this.currentRelease.getName());
        this.updateReleaseResult(null, 0);
        this.getSelectionDSIHandler().doSetRelease(this.currentRelease.getId());
        this.getProgressDSIHandler().startReadMetadataProgressUpdate();
    }

    public void updateReleaseResult(String string, int n) {
        this.getLogHMI().log(1000000, "<- updateReleaseResult(%1, %2)", (Object)string, (long)n);
        if (n == 0) {
            this.getSwdlModels().getMessageLabel().setText(this.getTextFactory().getTextConstantWaiting());
            this.getSwdlModels().getSelectReleaseStateChoice().setValue(0);
            this.getSwdlModels().getSelectReleaseStateChoice().setStatus(0);
        } else if (n < 0) {
            this.getSwdlModels().getMessageLabel().setText(string);
            this.getSwdlModels().getSelectReleaseStateChoice().setValue(-1);
            this.getSwdlModels().getSelectReleaseStateChoice().setStatus(1);
            this.getProgressDSIHandler().stopReadMetadataProgressUpdate();
        } else {
            this.getSwdlModels().getMessageLabel().setText(this.getTextFactory().getTextConstantOK());
            this.getSwdlModels().getSelectReleaseStateChoice().setValue(1);
            this.getSwdlModels().getSelectReleaseStateChoice().setStatus(1);
            this.getSwdlModels().getUserDefinedChoice().setValue(0);
            this.getSelectionDSIHandler().doGetUserDefindeAllowed();
            this.getProgressDSIHandler().stopReadMetadataProgressUpdate();
        }
    }

    public void updateConsistency(int n, boolean bl, String string, int n2) {
        if (this.getSwdlEnv().getLogDSI().isDebug()) {
            this.getSwdlEnv().getLogDSI().log(10000000, "updateConsistency(%1, %2, %3)", (Object)Integer.toString(n), (Object)Boolean.toString(bl), (Object)new StringBuffer().append(string).append(" ").append(n2).toString());
        }
        if (bl) {
            this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(0);
            this.getSelectionDSIHandler().doGetIncompatibleDevices();
        } else {
            String string2 = this.getSelectionDSIHandler().getConsistencyMessage(n, string, n2);
            if (string2 != null) {
                this.getSwdlEnv().getLogMain().log(10000000, "set consistency error text %1", (Object)string2);
                this.getSwdlModels().getInconsistentUpdateErrorLabel().setText(string2);
            } else {
                this.getSwdlModels().getInconsistentUpdateErrorLabel().setText(this.getTextFactory().getTextConstantUnexpectedResultFromConsistencyCheck());
                this.getSwdlEnv().getLogMain().log(100000, "checkConsistency returned an unexpected value %1", (long)n);
            }
            this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(2);
            this.getSwdlEnv().getLogMain().log(1000000, "doCheckStartDownload.fireEvent()");
            this.getSwdlModels().getCheckStartDownloadButton().setStatus(1);
        }
    }

    public void updateIncompatibleDevices(String[] stringArray, String[] stringArray2) {
        if (stringArray == null || stringArray.length == 0 || stringArray2 == null || stringArray2.length == 0) {
            this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(0);
        } else {
            this.getSwdlModels().getIncompatibleUpdatesChoice().setValue(1);
            String string = this.getTextFactory().getTextConstantRequires();
            Buffer buffer = new Buffer();
            int n = stringArray.length;
            if (stringArray2.length < n) {
                n = stringArray2.length;
                this.getSwdlEnv().getLogMain().log(100000, "Incompatible device lists are inkonsistent %1 %2", (Object)stringArray, (Object)stringArray2);
            }
            for (int i2 = 0; i2 < n; ++i2) {
                buffer.append(stringArray[i2]);
                buffer.append(' ');
                buffer.append(string);
                buffer.append(' ');
                buffer.append(stringArray2[i2]);
                buffer.append("\n");
            }
            this.getSwdlModels().getIncompDevLabel().setText(buffer.toString());
        }
        this.getLogHMI().log(1000000, "doStartDownload.fireEvent()");
        this.getSwdlModels().getCheckStartDownloadButton().setStatus(1);
    }

    public void doStartVersionUpload() {
        this.getLogHMI().log(1000000, "doStartVersionUpload()");
        this.getSwdlModels().getVersionUploadResultLabel().setText(this.getTextFactory().getTextConstantEngSelectManagerAbort());
        this.getSelectionDSIHandler().doStartVersionUpload();
    }

    public void versionUploadDone(boolean bl) {
        this.getLogHMI().log(1000000, "<- versionUploadDone(%1)", bl);
        if (bl) {
            this.getSwdlModels().getVersionUploadResultLabel().setText(this.getTextFactory().getTextConstantEngSelectManagerConfirmed());
        } else {
            this.getSwdlModels().getVersionUploadResultLabel().setText(this.getTextFactory().getTextConstantEngSelectManagerFailed());
        }
        this.getSwdlModels().getAbortVersionComparisonButton().fireEvent(this.getSwdlEnv().getTerminalId());
        this.getLogHMI().log(10000000, "[AbstractEngineeringSelectionManager]versionUploadDone: start reset timer %1 sec", 3L);
        new Timer("Version upload restart timer", 3000L, true, new TimerListener(){

            public void fireTimer(Timer timer) {
                try {
                    AbstractEngineeringSelectionManager.this.getSwdlModels().getRestartVersionComparisonButton().fireEvent(AbstractEngineeringSelectionManager.this.getSwdlEnv().getTerminalId());
                    AbstractEngineeringSelectionManager.this.rebootAfterUpload();
                    AbstractEngineeringSelectionManager.this.removeSwdlDataDir();
                }
                catch (Exception exception) {
                    AbstractEngineeringSelectionManager.this.getLogHMI().log(10000, "[AbstractEngineeringSelectionManager]versionUploadDone: unexpected timer exception", (Throwable)exception);
                }
            }

            public void cancelTimer(Timer timer) {
            }
        }).start();
    }

    void rebootAfterUpload() {
        this.getLogHMI().log(1000000, "rebootAfterUpload()");
        this.getSelectionDSIHandler().endVersionUpload();
        this.getProgressDSIHandler().updateTriggerPanel(1, 1);
    }

    public void enterComponentUpdateConfirmation() {
        if (this.getSwdlEnv().isSwdlSummaryEntered()) {
            this.getLogHMI().log(1000000, "AbstractEngineeringSelectionManager <- enterComponentUpdateConfirmation()");
            this.getSwdlModels().getSummaryContinueButton().fireEvent(0);
            this.getSelectionDSIHandler().enterComponentUpdateConfirmation(true);
            this.doStartVersionUpload();
        } else {
            this.getLogHMI().log(10000, "AbstractEngineeringSelectionManager::SwdlSummary is not active, skip this:  enterComponentUpdateConfirmation()");
            this.getSelectionDSIHandler().enterComponentUpdateConfirmation(false);
        }
    }

    public void keyPressed(int n, int n2, int n3) {
    }

    public void keyReleased(int n, int n2, int n3) {
    }

    private void createUpdateTxt() {
        String string = PropertiesAccessor.getSwdlDataDir();
        if (string != null) {
            System.out.println(new StringBuffer().append("==== SWDL Started ====, create ").append(string).append("update.txt").toString());
            try {
                new File(string).mkdirs();
                File file = new File(new StringBuffer().append(string).append("update.txt").toString());
                file.createNewFile();
                PrintStream printStream = new PrintStream(new FileOutputStream(file));
                printStream.print("MetafileCRC = skip\nUse DSIv2 = true\nSource = CD\nPath = /\nReleasePath =\n");
                printStream.close();
            }
            catch (IOException iOException) {
                this.getLogHMI().log(1000000, "IOException while creating download flag file!", (Throwable)iOException);
            }
        }
    }

    public void removeSwdlDataDir() {
        String string = PropertiesAccessor.getSwdlDataDir();
        if (string != null) {
            new File(new StringBuffer().append(string).append("update.txt").toString()).delete();
            System.out.println(new StringBuffer().append("==== SWDL Finished ====, deleted ").append(string).append("update.txt").toString());
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        this.getLogHMI().log(1000000, "KeyTyped(modelID=%1,terminalID=%2)", (long)n, (long)n3);
        switch (n) {
            case 1700067: {
                this.getSwdlModels().getIgnoreBusyDeviceButton().fireEvent(n3);
                break;
            }
            case 1700045: {
                this.getSwdlModels().getAbortReadReleaseButton().fireEvent(n3);
                break;
            }
            case 1700044: {
                this.getSwdlModels().getAbortReadMetaInfoButton().fireEvent(n3);
                break;
            }
            case 1700142: {
                this.doSetInstallationType(true);
                ((AbstractEngineeringDeviceInfoManager)this.getDeviceInfoManager()).resetCursorPosition();
                this.getSwdlModels().getSelectUpdateStandardButton().fireEvent(n3);
                break;
            }
            case 1700143: {
                this.doSetInstallationType(false);
                ((AbstractEngineeringDeviceInfoManager)this.getDeviceInfoManager()).resetCursorPosition();
                this.getSwdlModels().getSelectUpdateUserDefinedButton().fireEvent(n3);
                break;
            }
            case 1700051: {
                if (this.getDeviceInfoManager() instanceof AbstractEngineeringDeviceInfoManager) {
                    ((AbstractEngineeringDeviceInfoManager)this.getDeviceInfoManager()).clearSelectedEntry();
                }
                this.getSwdlModels().getCheckStartDownloadButton().setStatus(0);
                this.getSwdlModels().getCheckStartDownloadButton().fireEvent(n3);
                this.doCheckStartDownload();
                break;
            }
            case 1700314: {
                this.getSwdlModels().getSwdlDowngradeContinueButtonModel().fireEvent(n3);
                break;
            }
            case 1700157: {
                this.getSwdlModels().getDeviceStatusEnteredChoice().setStatus(1);
                this.getSwdlModels().getReleaseLabel().setText(this.getTextFactory().getTextConstantDeviceInfo1());
                this.getSwdlModels().getStatusDeviceSelectButton().fireEvent(n3);
                break;
            }
            case 1700155: {
                this.getSwdlModels().getSwdlDownloadStartedChoice().setValue(1);
                this.getSwdlEnv().storeSysConstsForSWDLReboot();
                if (this.currentMedium != null && this.currentRelease != null) {
                    this.getSwdlEnv().storeSwdlInfo(this.currentMedium.getId(), this.currentRelease.getName());
                }
                this.createUpdateTxt();
                this.getSelectionDSIHandler().startDownload();
                break;
            }
            case 1700043: {
                this.getSwdlModels().getAbortDownloadButton().fireEvent(n3);
                break;
            }
            case 1700156: {
                this.getProgressDSIHandler().updateTriggerPanel(1, 1);
                this.getSelectionDSIHandler().abortVersionUpload();
                this.removeSwdlDataDir();
                break;
            }
            case 1700172: {
                this.getSwdlModels().getRestartVersionComparisonButton().fireEvent(n3);
                this.getSwdlEnv().getHMISwitcher().getProgressManager().versionUploadDone(false);
                this.rebootAfterUpload();
                this.removeSwdlDataDir();
                break;
            }
            case 1700081: {
                this.getSelectionDSIHandler().doStoreNfsIpAddress(this.getSwdlModels().getIpSpeller().getText());
                this.getSwdlModels().getIpSpeller().fireEvent(n3);
                break;
            }
            case 1700107: {
                this.getSelectionDSIHandler().doStoreNfsPath(this.getSwdlModels().getFsPathSpeller().getText());
                this.getSwdlModels().getFsPathSpeller().fireEvent(n3);
                break;
            }
            case 1700129: {
                this.getSwdlModels().getRSUSelectDownloadMediaSelectButton().fireEvent(this.getSwdlEnv().getTerminalId());
                break;
            }
            case 0x19F11F: {
                this.getSwdlModels().getInterruptCountdownLabel().setText("\n.");
                if (this.getSwdlEnv().isFrontMU()) {
                    this.fireSMEventTriggerDownloadAborting(this.getSwdlEnv().getTerminalId());
                    break;
                }
                this.getPopupManager().indicatePopUp(15, "", (byte)20, 0, 0, "");
                break;
            }
            case 1700130: {
                this.fireSMEventTriggerDownloadAborting(this.getSwdlEnv().getTerminalId());
                this.getProgressDSIHandler().doHandleUserSelection(13, "", 4);
                break;
            }
            default: {
                this.getLogHMI().log(10000000, "ignore keyTyped( %1 ) Event!", (long)n);
            }
        }
    }

    public void keyLongTyped(int n, int n2, int n3) {
    }

    public void textChanged(int n, String string, char c2, int n2) {
    }

    public void commandPressed(int n, int n2, int n3) {
    }

    protected abstract void fireSMEventTriggerDownloadAborting(int var1);
}

