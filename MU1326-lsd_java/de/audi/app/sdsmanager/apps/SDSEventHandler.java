/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSHMIListener;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.apps.SDSAppFactory;
import de.audi.app.sdsmanager.apps.SDSTimeoutHandler;
import de.audi.app.sdsmanager.apps.system.SystemSDSHandler;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.atip.hmi.HMIService;
import de.audi.atip.hmi.event.DrawerEvent;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tghu.command.CommandList;

class SDSEventHandler
implements TimerListener {
    private LogChannel lc = Logger.getMainLog();
    private final SDSAdapter sdsAdapter;
    private final AppSDSManager sdsManager;
    private volatile int eventMappingID;
    private final Object eventMutex = new Object();
    private final Timer resumeTimer = new Timer("SDSResumeTimer", 5, this.lc, this, 0, true);
    private final Timer pauseStateAbortTimer = new Timer("SDSPauseStateAbortTimer", 5, this.lc, this, 0, true);
    private final Timer waitStateAbortTimer = new Timer("SDSWaitStateAbortTimer", 5, this.lc, this, 0, true);
    private boolean volumeSettingActive = false;
    private SDSAppFactory factory;
    private SDSTimeoutHandler sdsTimeout;
    private final HMIService hmiService;
    private SDSHMIListener hmiListener;
    private boolean parallelAbortTasksInProgress = false;

    SDSEventHandler(SDSAdapter sDSAdapter, AppSDSManager appSDSManager, SDSTimeoutHandler sDSTimeoutHandler, HMIService hMIService, SDSHMIListener sDSHMIListener) {
        this.sdsAdapter = sDSAdapter;
        this.sdsManager = appSDSManager;
        this.hmiService = hMIService;
        this.hmiListener = sDSHMIListener;
        this.sdsTimeout = sDSTimeoutHandler;
    }

    void sendSDSEvent(int n, boolean bl) {
        this.lc.log(-2137614336, "SDSEventHandler#sendSDSEvent: eventMappingID=%1!", (long)n);
        if (!this.checkSDSEvent(n)) {
            this.lc.log(-1601830656, "SDSEventHandler#sendSDSEvent: Rejecting event with ID %1!", (long)n);
            return;
        }
        boolean bl2 = bl ? false : SDSEventHandler.needsAborting(n);
        this.lc.log(-2137614336, "SDSEventHandler#sendSDSEvent: checkAbort=%1!", bl2);
        boolean bl3 = this.checkAbortingAndSendEvent(n, (byte)1, false, bl2);
        if (bl3 && (SDSEventHandler.isAborting(n) || SDSEventHandler.isCorrection(n))) {
            this.lc.log(-2137614336, "SDSEventHandler#sendSDSEvent: eventMappingID=%1, finish any running system calls!", (long)n);
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            if (abstractSystemCallCommand != null && !abstractSystemCallCommand.isSDSEndSequenceCommand()) {
                abstractSystemCallCommand.processingFinished();
                this.sdsTimeout.resetSysCallTimer();
            }
        }
        this.lc.log(-2137614336, "SDSEventHandler#sendSDSEvent: %1 mapping event %2!", (Object)(bl3 ? "Sent" : "DID NOT send"), (long)n);
    }

    void sendSpeechSMEvent(int n, boolean bl, boolean bl2) {
        this.lc.log(-2137614336, "SDSEventHandler#sendSpeechSMEvent: evID=%3, direct=%1, checkAbort=%2", (Object)bl, (Object)bl2, (long)n);
        boolean bl3 = this.checkAbortingAndSendEvent(n, (byte)3, bl, bl2);
        this.lc.log(-2137614336, "SDSEventHandler#sendSpeechSMEvent: %1 %2event %3!", (Object)(bl3 ? "Sent" : "DID NOT send"), (Object)(bl ? "" : "mapping "), (long)n);
    }

    private boolean checkActionDelayByAbortTask(boolean bl, boolean bl2) {
        if (bl || bl2) {
            this.parallelAbortTasksInProgress = bl && bl2;
            return true;
        }
        if (this.parallelAbortTasksInProgress) {
            this.lc.log(-2137614336, "SDSEventHandler#checkActionDelayByAbortTask: Omit execution of action from first abort task (recognizer or prompt)!");
            this.parallelAbortTasksInProgress = false;
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private boolean checkAbortingAndSendEvent(int n, byte by, boolean bl, boolean bl2) {
        CommandList commandList;
        this.lc.log(-2137614336, "SDSEventHandler#checkAbortingAndSendEvent: evID=%1, type=%2!", (long)n, (long)by);
        this.lc.log(-2137614336, "SDSEventHandler#checkAbortingAndSendEvent: direct=%1, checkAbort=%2!", bl, bl2);
        if (this.sdsManager.getWaitStateStatus() == 1) {
            if (SDSEventHandler.isAborting(n)) {
                this.sdsManager.setWaitStateStatus((byte)0);
            } else {
                this.lc.log(-1601830656, "SDSEventHandler#checkAbortingAndSendEvent: Drop event during wait state initialization!");
                return false;
            }
        }
        if ((commandList = SDSManagerBaseActivator.getDSICallCmdListManager().getActiveCommandList()) == null) {
            this.lc.log(-1601830656, "SDSEventHandler#checkAbortingAndSendEvent: No active DSI command list, syncing on eventMutex!");
        }
        Object object = commandList != null ? commandList : this.eventMutex;
        synchronized (object) {
            int n2 = this.eventMappingID = bl ? -1 : n;
            if (bl2) {
                SystemSDSHandler systemSDSHandler = this.factory.getSDSHandlerSystem();
                boolean bl3 = systemSDSHandler.abortCurrentRecognition(by, bl, n);
                boolean bl4 = systemSDSHandler.abortCurrentPrompt(by, bl, n);
                this.lc.log(-2137614336, "SDSEventHandler#checkAbortingAndSendEvent: Are aborting tasks in progress? - recognition=%1, prompt=%2!", bl3, bl4);
                if (this.checkActionDelayByAbortTask(bl3, bl4)) {
                    return false;
                }
            }
            this.parallelAbortTasksInProgress = false;
            if (SDSEventHandler.isVolumeSetting(n)) {
                this.sdsAdapter.setSDSVolumeSettingActive(true);
            }
            this.lc.log(-2137614336, "SDSEventHandler#checkAbortingAndSendEvent: Sending event %1!", (long)n);
            return this.sdsAdapter.getJavaSDS().sendEvent(n, bl);
        }
    }

    private static boolean needsAborting(int n) {
        return SDSEventHandler.isSelection(n) || SDSEventHandler.isPausing(n) || SDSEventHandler.isAborting(n) || SDSEventHandler.isPTT(n) || SDSEventHandler.isSDRemoving(n) || SDSEventHandler.isDictationStartEvent(n) || SDSEventHandler.isWaiting(n) || SDSEventHandler.isRemoteHMIHelp() || SDSEventHandler.isCorrection(n);
    }

    private boolean checkSDSEvent(int n) {
        this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: id=%1", (long)n);
        if (this.sdsManager.isPTTBlocked() && SDSEventHandler.isStarting(n)) {
            this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: PTT (and thus SDS) blocked, rejecting event %1!", (long)n);
            this.sdsTimeout.cancelPTTRunningTimer();
            return false;
        }
        if (this.sdsManager.isSDSAborting()) {
            if (SDSEventHandler.isStarting(n)) {
                this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: SDS aborting, rejecting starting event %1!", (long)n);
                this.sdsTimeout.cancelPTTRunningTimer();
                return false;
            }
            if (SDSEventHandler.isSelection(n)) {
                this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: SDS aborting, rejecting selection event %1!", (long)n);
                return false;
            }
        }
        if (n == 2) {
            if (this.isVolumeSettingActive()) {
                this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: Volume setting dialog is active, rejecting pause event!");
                return false;
            }
            if (!this.sdsAdapter.isSDSActive()) {
                this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: Dialog is not active, rejecting pause event!");
                return false;
            }
            if (this.sdsAdapter.isSDSAborting()) {
                this.lc.log(-2137614336, "SDSEventHandler#checkSDSEvent: Dialog is already aborting/ending, rejecting pause event!");
                return false;
            }
        }
        return true;
    }

    void sendSDSResumeEvent(boolean bl) {
        this.lc.log(-2137614336, "SDSEventHandler#sendSDSResumeEvent: context=%2, triggeredByUser=%1", bl);
        if (bl) {
            this.lc.log(-2137614336, "SDSEventHandler#sendSDSResumeEvent: PAUSE_RELEASE event was triggered by user, resuming SDS immediately!");
            this.resumeSDS();
            return;
        }
        this.lc.log(-2137614336, "sendSDSResumeEvent: PAUSE_RELEASE event was NOT triggered by user, waiting %1 ms before resuming SDS!", (long)0);
        if (!this.resumeTimer.isRunning()) {
            this.resumeTimer.start();
        }
    }

    private void resumeSDS() {
        this.lc.log(-2137614336, "SDSEventHandler#resumeSDS: called");
        this.hmiListener.updateSDSStatusPause(false);
        this.sendSDSEvent(1003, false);
    }

    boolean isSDSPauseEventSent() {
        return SDSEventHandler.isPausing(this.eventMappingID);
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer == this.resumeTimer) {
            this.lc.log(-2137614336, "SDSEventHandler#fireTimer: Timeout for resuming paused SDS occurred!");
            this.resumeSDS();
        } else if (timer == this.pauseStateAbortTimer) {
            this.lc.log(-2137614336, "SDSEventHandler#fireTimer: Timeout for aborting paused SDS occurred!");
            this.sdsManager.abortSDSSession(true);
        } else if (timer == this.waitStateAbortTimer) {
            this.lc.log(-2137614336, "SDSEventHandler#fireTimer: Timeout for aborting SDS during wait state occurred!");
            this.lc.log(-2137614336, "SDSEventHandler#fireTimer: -> close drawers if they are open!");
            this.hmiService.getEventDispatcher().postEvent(new DrawerEvent(this.hmiService.getRootWindow(0), 2));
            this.hmiService.getEventDispatcher().postEvent(new DrawerEvent(this.hmiService.getRootWindow(0), 1));
            this.sdsManager.abortSDSSession(true);
        } else {
            this.lc.log(10000, "SDSEventHandler#fireTimer: Unhandled timer %1!", (Object)timer);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.lc.log(-2137614336, "SDSEventHandler#cancelTimer: timer %1 canceled", (Object)timer);
    }

    void triggerPauseStateAbortTimer(boolean bl) {
        boolean bl2 = this.pauseStateAbortTimer.isRunning();
        this.lc.log(-2137614336, "SDSEventHandler#triggerPauseStateAbortTimer: start=%1, running=%2!", bl, bl2);
        if (bl && !bl2) {
            this.lc.log(-2137614336, "SDSEventHandler#triggerPauseStateAbortTimer: Starting pause state abort timer!");
            this.pauseStateAbortTimer.start();
        } else if (!bl && bl2) {
            this.lc.log(-2137614336, "SDSEventHandler#triggerPauseStateAbortTimer: Canceling pause state abort timer!");
            this.pauseStateAbortTimer.cancel();
        }
    }

    void triggerWaitStateAbortTimer(boolean bl) {
        boolean bl2 = this.waitStateAbortTimer.isRunning();
        this.lc.log(-2137614336, "SDSEventHandler#triggerWaitStateTimer: start=%1, running=%2!", bl, bl2);
        if (bl && !bl2) {
            this.lc.log(-2137614336, "SDSEventHandler#triggerWaitStateTimer: Starting wait state abort timer!");
            this.waitStateAbortTimer.start();
        } else if (!bl && bl2) {
            this.lc.log(-2137614336, "SDSEventHandler#triggerWaitStateTimer: Canceling wait state abort timer!");
            this.waitStateAbortTimer.cancel();
        }
    }

    private static boolean isPTT(int n) {
        return n == 1;
    }

    private static boolean isCorrection(int n) {
        return n == 1011;
    }

    private static boolean isPausing(int n) {
        return n == 2 || n == 1003 || n == 3002;
    }

    private static boolean isWaiting(int n) {
        return n == 1014 || n == 3011 || n == 3010 || n == 1013;
    }

    private static boolean isVolumeSetting(int n) {
        return n == 4;
    }

    private static boolean isStarting(int n) {
        return n == 1 || n == 3 || n == 5;
    }

    private static boolean isAborting(int n) {
        return n == 1001 || n == 1002 || n == 1004;
    }

    private static boolean isSelection(int n) {
        return n == 1000 || SDSEventHandler.isConnectionSelection(n) || SDSEventHandler.isFolderUpSelection(n);
    }

    private static boolean isConnectionSelection(int n) {
        return n == 1078071040 || n == 1094848256;
    }

    private static boolean isFolderUpSelection(int n) {
        return n == 1007;
    }

    private static boolean isSDRemoving(int n) {
        return n == 1006;
    }

    private static boolean isDictationStartEvent(int n) {
        return n == 1017;
    }

    private static boolean isRemoteHMIHelp() {
        return false;
    }

    int getEventMappingID() {
        return this.eventMappingID;
    }

    void setEventMappingID(int n) {
        this.eventMappingID = n;
    }

    boolean isVolumeSettingActive() {
        return this.volumeSettingActive;
    }

    void setVolumeSettingActive(boolean bl) {
        this.volumeSettingActive = bl;
        this.lc.log(-2137614336, "SDSEventHandler#setVolumeSettingActive: volumeSettingActive=%1!", this.volumeSettingActive);
    }

    void setFactory(SDSAppFactory sDSAppFactory) {
        this.factory = sDSAppFactory;
    }
}

