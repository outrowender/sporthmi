/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager.apps;

import de.audi.app.sdsmanager.AppSDSManager;
import de.audi.app.sdsmanager.SDSManagerBaseActivator;
import de.audi.app.sdsmanager.SDSModelAccess;
import de.audi.app.sdsmanager.apps.AbstractSystemCallCommand;
import de.audi.app.sdsmanager.apps.SDSAdapter;
import de.audi.app.sdsmanager.common.ISDSPopupHelper;
import de.audi.app.sdsmanager.common.Logger;
import de.audi.app.sdsmanager.common.SDSUtils;
import de.audi.app.sdsmanager.dsi.SpeechRecognitionHandler;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;
import java.util.HashMap;
import java.util.Map;

public class SDSTimeoutHandler
implements TimerListener {
    private final LogChannel lc = Logger.getTimeoutLog();
    private final Timer sysCallTimer = new Timer("SDSSysCallTimer", 5, this.lc, this, 10000L, true);
    private final Timer eventTimer = new Timer("SDSSpeechEventResponseTimer", 5, this.lc, this, 5000L, true);
    private final Timer ttsTimer = new Timer("SDSTTSTimer", 5, this.lc, this, 25000L, true);
    private final Timer sdsSessionAbortingTTSTimer = new Timer("SDSSessionAbortingTTSTimer", 5, this.lc, this, 10000L, true);
    private final Timer initTimer = new Timer("SDSInitTimer", 5, this.lc, this, 90000L, true);
    private final Timer pttRunningTimer = new Timer("SDSPTTRunningTimer", 5, this.lc, this, 5000L, true);
    private final Timer progressIconTimer;
    private final Timer msgEditTimer = new Timer("SDSmsgEditTimer", 5, this.lc, this, 5000L, true);
    private final Timer recognizerProlongOnceTimer = new Timer("SDSrecognizerProlongOnceTimer", 5, this.lc, this, 1000L, true);
    private final Timer recognizerProlongLoopTimer = new Timer("SDSrecognizerProlongLoopTimer", 5, this.lc, this, 1000L, true);
    private final AppSDSManager sdsManager;
    private SDSAdapter sdsAdapter;
    private final SpeechRecognitionHandler srHandler;
    private final ISDSPopupHelper sdsPopupHelper;
    private int commandID;
    private int eventID;
    private long sysCallStartTime;
    private Map sysCallMaxTimes = new HashMap();

    public SDSTimeoutHandler(AppSDSManager appSDSManager, SpeechRecognitionHandler speechRecognitionHandler, ISDSPopupHelper iSDSPopupHelper) {
        this.sdsManager = appSDSManager;
        this.srHandler = speechRecognitionHandler;
        this.sdsPopupHelper = iSDSPopupHelper;
        this.progressIconTimer = new Timer("SDSProgressIconTimer", 5, this.lc, this, SDSManagerBaseActivator.getMapping().getProgressIconTimeout(), true);
    }

    private void showTimerErrors(String string, int n, long l) {
        this.lc.log(10000, "SDSTimeoutHandler#showTimerErrors: Timeout for %1 (ID %2) expired!", (Object)string, (long)n);
        System.err.println("Timeout for " + string + " (ID " + n + ") expired after " + l + " msecs!");
        this.sdsPopupHelper.showDebugPopup(string, new Buffer("timeout (").append(String.valueOf(l)).append(" ms)").toString(), "");
    }

    public void fireTimer(Timer timer) {
        this.lc.log(10000000, "SDSTimeoutHandler#fireTimer: timer=%1, delay=%2", (Object)timer, timer.getDelay());
        if (timer == this.initTimer) {
            this.showTimerErrors("INIT", -1, 90000L);
        } else if (timer == this.sysCallTimer) {
            AbstractSystemCallCommand abstractSystemCallCommand = SDSUtils.getActiveSystemCall();
            String string = SDSManagerBaseActivator.getSystemCallNames().getName(this.commandID);
            int n = this.commandID;
            if (abstractSystemCallCommand != null) {
                if (abstractSystemCallCommand.handleTimeout()) {
                    return;
                }
                this.showTimerErrors(string, n, timer.getDelay());
            } else {
                this.showTimerErrors(string, n, timer.getDelay());
                this.sdsAdapter.sendResult(3001);
            }
        } else if (timer == this.eventTimer) {
            this.lc.log(100000, "SDSTimeoutHandler#Timeout for event %1 occurred!", (long)this.eventID);
        } else if (timer == this.ttsTimer) {
            this.showTimerErrors("TTS", -1, 25000L);
            this.sdsManager.abortSDSSession(true);
        } else if (timer == this.sdsSessionAbortingTTSTimer) {
            this.showTimerErrors("SDSSessionAbortingTTSTimer", -1, 10000L);
            this.sdsAdapter.sendEvent(3001);
        } else if (timer != this.recognizerProlongOnceTimer) {
            if (timer == this.recognizerProlongLoopTimer) {
                this.restartRecognitionProlongLoopTimer();
            } else if (timer == this.pttRunningTimer) {
                this.showTimerErrors("PTT running", -1, 5000L);
                this.lc.log(10000000, "SDSTimeoutHandler#fireTimer: PTT running timeout expired, re-activating PTT!");
                this.sdsAdapter.setPttRunning(false);
            } else if (timer == this.progressIconTimer) {
                if (this.sdsManager.isSDSAborting() || !this.sdsManager.isSDSActive() || this.sdsManager.isSDSPauseStateActive() || this.sdsManager.isSDSWaitStateActive()) {
                    return;
                }
                this.lc.log(10000000, "SDSTimeoutHandler#fireTimer: Progress icon timeout expired, showing progress icon!");
                SDSModelAccess.setProgressIconVisible(1);
            } else if (timer == this.msgEditTimer) {
                this.lc.log(10000000, "SDSTimeoutHandler#fireTimer: Message editing timeout expired!");
                this.sdsAdapter.sendResult(75007);
            } else {
                this.lc.log(100000, "SDSTimeoutHandler#fireTimer: Unhandled timer %1!", (Object)timer);
            }
        }
    }

    public void cancelTimer(Timer timer) {
    }

    void restartSysCallTimer(int n) {
        this.sysCallStartTime = System.currentTimeMillis();
        this.commandID = n;
        if (SDSTimeoutHandler.isAlternativeRouteCommand(n)) {
            this.sysCallTimer.setDelay(60000L);
        } else if (SDSTimeoutHandler.isLongMessagingCommand(n)) {
            this.sysCallTimer.setDelay(240000L);
        } else if (this.isLongSyscallCommand(n)) {
            this.sysCallTimer.setDelay(20000L);
        } else if (SDSTimeoutHandler.isBlockRouteCommand(n)) {
            this.sysCallTimer.setDelay(40000L);
        } else if (SDSTimeoutHandler.isNaviTrufflesSearchCommand(n)) {
            this.sysCallTimer.setDelay(50000L);
        } else if (SDSTimeoutHandler.isRHMISearchCommand(n)) {
            this.sysCallTimer.setDelay(50000L);
        } else if (SDSTimeoutHandler.isTTSAbortCommand(n)) {
            this.sysCallTimer.setDelay(25000L);
        } else {
            this.sysCallTimer.setDelay(10000L);
        }
        if (!this.sysCallTimer.isRunning()) {
            this.sysCallTimer.restart();
        }
    }

    void resetSysCallTimer() {
        this.logSysCallTimes();
        this.commandID = -1;
        this.sysCallTimer.cancel();
    }

    private void logSysCallTimes() {
        String string = SDSManagerBaseActivator.getSystemCallNames().getName(this.commandID);
        long l = System.currentTimeMillis() - this.sysCallStartTime;
        if (this.sysCallMaxTimes.containsKey(string)) {
            long l2 = (Long)this.sysCallMaxTimes.get(string);
            if (l > l2) {
                this.lc.log(10000000, "SDSTimeoutHandler#logSysCallTimes: Overwriting maximal time %2 msecs for systemcall %1 (was %3 msecs)!", (Object)string, l, l2);
                this.sysCallMaxTimes.put(string, new Long(l));
            } else {
                this.lc.log(10000000, "SDSTimeoutHandler#logSysCallTimes: Leaving maximal time %3 msecs for systemcall %1 (got %2 msecs)!", (Object)string, l, l2);
            }
        } else {
            this.lc.log(10000000, "SDSTimeoutHandler#logSysCallTimes: Adding maximal time %2 msecs for systemcall %1!", (Object)string, l);
            this.sysCallMaxTimes.put(string, new Long(l));
        }
    }

    void restartPTTRunningTimer() {
        if (this.pttRunningTimer.isRunning()) {
            return;
        }
        this.sdsAdapter.setPttRunning(true);
        this.pttRunningTimer.restart();
    }

    public void cancelPTTRunningTimer() {
        this.sdsAdapter.setPttRunning(false);
        this.pttRunningTimer.cancel();
    }

    public void restartRecognizerProlongOnceTimer() {
        if (this.recognizerProlongOnceTimer.isRunning() || SDSModelAccess.getRecognizer() != 2) {
            return;
        }
        this.lc.log(10000000, "SDSTimeoutHandler#restartRecognizerProlongOnceTimer: Prolong open recognizer and (re-)start the prolong once timer!");
        this.srHandler.prolongRecognitionTimeout();
        this.recognizerProlongOnceTimer.restart();
    }

    public void restartRecognitionProlongLoopTimer() {
        if (this.recognizerProlongLoopTimer.isRunning() || SDSModelAccess.getRecognizer() != 2) {
            return;
        }
        if (this.recognizerProlongOnceTimer.isRunning()) {
            this.recognizerProlongOnceTimer.cancel();
        }
        this.srHandler.prolongRecognitionTimeout();
        this.recognizerProlongLoopTimer.restart();
    }

    public void cancelRecognitionProlongLoopTimer() {
        if (!this.recognizerProlongLoopTimer.isRunning()) {
            return;
        }
        this.lc.log(10000000, "SDSTimeoutHandler#cancelRecognitionProlongLoopTimer: Cancel the prolong loop timer!");
        this.recognizerProlongLoopTimer.cancel();
    }

    public void cancelEventTimer() {
        this.eventTimer.cancel();
    }

    public void restartEventTimer(int n) {
        this.eventTimer.restart();
        this.eventID = n;
    }

    public void cancelTTSTimer() {
        this.ttsTimer.cancel();
    }

    public void restartTTSTimer() {
        this.ttsTimer.restart();
    }

    public void cancelSDSSessionAbortingTTSTimer() {
        this.sdsSessionAbortingTTSTimer.cancel();
    }

    public void restartSDSSessionAbortingTTSTimer() {
        this.sdsSessionAbortingTTSTimer.restart();
    }

    public void restartMsgEditTimer() {
        this.msgEditTimer.restart();
    }

    public void cancelProgressIconTimer() {
        this.progressIconTimer.cancel();
    }

    public void restartProgressIconTimer() {
        this.progressIconTimer.restart();
    }

    public void startInitTimer() {
        if (this.initTimer.isRunning()) {
            this.lc.log(100000, "SDSTimeoutHandler#startInitTimer: Timer already running!");
        }
        this.initTimer.start();
    }

    public void cancelInitTimer() {
        this.initTimer.cancel();
    }

    private static boolean isAlternativeRouteCommand(int n) {
        return n == 40063 || n == 40015;
    }

    private static boolean isLongMessagingCommand(int n) {
        return n == 77000 || n == 77010;
    }

    protected boolean isLongSyscallCommand(int n) {
        return n == 40007 || n == 40024 || n == 40034 || n == 40040 || n == 40060 || n == 70003 || n == 70001;
    }

    private static boolean isBlockRouteCommand(int n) {
        return n == 40001;
    }

    protected static boolean isNaviTrufflesSearchCommand(int n) {
        return n == 40097;
    }

    private static boolean isRHMISearchCommand(int n) {
        return n == 230005;
    }

    private static boolean isTTSAbortCommand(int n) {
        return n == 1044;
    }

    public Map getSysCallMaxTimes() {
        return this.sysCallMaxTimes;
    }

    public void setSDSAdapter(SDSAdapter sDSAdapter) {
        this.sdsAdapter = sDSAdapter;
    }
}

