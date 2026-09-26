/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.info.app.tmc.readout;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.interapp.tts.TTSListener;
import de.audi.atip.interapp.tts.TTSSingleSpeakService;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.info.app.InfoEnv;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutAllQueue;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutMessage;
import de.audi.tghu.info.app.tmc.readout.TMCReadOutQueueListener;
import org.dsi.ifc.tmc.TmcMessage;

public class ReadOutSync
implements TMCReadOutQueueListener,
Runnable,
TTSListener {
    static final int ANNOUNCEMENT_ON_CALL_OFF;
    static final long READ_OUT_DURATION;
    static final long REPEAT_SLOT;
    static final int GUIDANCE_SPEECH_MODE_OFF;
    private LogChannel logChMain;
    private TMCReadOutAllQueue tmcMsgQueue;
    private final IFrameworkAccess framework;
    private final InfoEnv env;
    private TTSSingleSpeakService ttsService;
    private TTSSingleSpeakService ttsServiceNoTel;
    private volatile boolean active = true;
    private boolean currentlySpeaking = false;
    private boolean currentlyRepeating = false;
    private TMCReadOutMessage msg;
    private long timeStamp;
    private long timespan;
    private long timeOfLastSpokenMessage;
    private boolean speakingAborted = false;
    private boolean speakingFailed = false;
    private boolean rgActive = false;

    public ReadOutSync(LogChannel logChannel, TMCReadOutAllQueue tMCReadOutAllQueue, InfoEnv infoEnv) {
        this.logChMain = logChannel;
        this.tmcMsgQueue = tMCReadOutAllQueue;
        this.env = infoEnv;
        this.framework = infoEnv.getFramework();
        logChannel.log(-2137614336, "[ReadOutSync#ReadOutSync] Called. ");
    }

    public synchronized void distanceToDestinationUpdated(long l) {
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[ReadOutSync#distanceToDestinationUpdated] Called. ");
        }
        this.tmcMsgQueue.setDistanceToTarget(l);
        super.notify();
    }

    synchronized int repeatOrAbortTmcMessageReadOutSince(long l) {
        this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] Called, timestamp: %1 ", l);
        if (this.msg == null) {
            this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] No message available. ");
            return 1;
        }
        if (this.currentlySpeaking) {
            this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] Abort reading out current message. ");
            try {
                if (this.ttsService != null) {
                    this.ttsService.abortSpeaking();
                }
                if (this.ttsServiceNoTel != null) {
                    this.ttsServiceNoTel.abortSpeaking();
                }
            }
            catch (Exception exception) {
                this.logChMain.log(10000, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] ERROR: %1 ", (Throwable)exception);
            }
            return 3;
        }
        if (this.timeOfLastSpokenMessage >= l) {
            this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] The timestamp of last spoken message is valid, time of last spoken message: %1 ", this.timeOfLastSpokenMessage);
            if (this.hasTimeForRepeating()) {
                this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] There is enough time for start the repeat, start repeat ");
                TTSSingleSpeakService tTSSingleSpeakService = this.getTTSService();
                if (tTSSingleSpeakService == null) {
                    this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] No TTS service. ");
                    return 0;
                }
                try {
                    tTSSingleSpeakService.speak(this.msg.getReadOutString());
                    this.currentlyRepeating = true;
                }
                catch (Exception exception) {
                    this.logChMain.log(10000, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] ERROR: %1 ", (Throwable)exception);
                }
                return 0;
            }
            this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] There is NOT enough time for start the repeat. ");
            return 2;
        }
        this.logChMain.log(-2137614336, "[ReadOutSync#repeatOrAbortTmcMessageReadOutSince] Last TMC message was spoken before timestamp, time of last message: %1, timestamp: %2 ", this.timeOfLastSpokenMessage, l);
        return 2;
    }

    synchronized boolean isCurrentlySpeaking() {
        this.logChMain.log(-2137614336, "[ReadOutSync#isCurrentlySpeaking] Called. ");
        return this.currentlySpeaking;
    }

    synchronized TMCReadOutMessage getCurrentMessage() {
        this.logChMain.log(-2137614336, "[ReadOutSync#getCurrentMessage] Called. ");
        return this.msg;
    }

    synchronized long getCurrentMessageId() {
        this.logChMain.log(-2137614336, "[ReadOutSync#getCurrentMessageId] Called. ");
        if (this.msg == null) {
            long l = -1L;
            return;
        }
        long l = this.msg.getMessageID();
    }

    public synchronized void setTimeForAnnouncement(long l) {
        this.logChMain.log(-2137614336, "[ReadOutSync#setTimeForAnnouncement] Called, remaining time: %1 ", l);
        this.timespan = l;
        this.timeStamp = this.framework.getMonotonicTime();
        super.notify();
    }

    @Override
    public synchronized void run() {
        this.logChMain.log(-2137614336, "[ReadOutSync#run] Called. ");
        Thread.currentThread().setName(new StringBuffer().append(Thread.currentThread().getName()).append("AppTMCReadOut").toString());
        while (this.active) {
            while (this.active && (this.getTTSService() == null || (this.msg = this.getTmcMessage()) == null || this.currentlySpeaking || !this.hasTimeForSpeaking() || this.currentlyRepeating || !this.checkSetupNavAnnouncementsEnabled())) {
                try {
                    if (this.logChMain.isDebug2()) {
                        this.logChMain.log(14808325, "[ReadOutSync#run] Waiting! Currently speaking: %1, message: %2 ", this.currentlySpeaking, (Object)this.msg);
                        this.logChMain.log(14808325, "[ReadOutSync#run] Time for speaking: %1", this.hasTimeForSpeaking());
                    }
                    super.wait();
                }
                catch (InterruptedException interruptedException) {
                    this.logChMain.log(10000, "[ReadOutSync#run] ERROR (InterruptedException): %1 ", (Throwable)interruptedException);
                }
            }
            if (!this.active) {
                this.logChMain.log(-2137614336, "[ReadOutSync#run] not active anymore, stopping. ");
                continue;
            }
            try {
                this.logChMain.log(-2137614336, "[ReadOutSync#run] After waiting, time limit is not reached, speak message: %1, message ID: %2 ", (Object)this.msg.getReadOutString(), this.msg.getMessageID());
                TTSSingleSpeakService tTSSingleSpeakService = this.getTTSService();
                if (tTSSingleSpeakService == null) continue;
                tTSSingleSpeakService.speak(this.msg.getReadOutString());
                this.currentlySpeaking = true;
            }
            catch (Exception exception) {
                this.logChMain.log(10000, "[ReadOutSync#run] ERROR (Exception): %1 ", (Throwable)exception);
            }
        }
        this.logChMain.log(-2137614336, "[ReadOutSync#run] end thread. ");
    }

    public synchronized void stop() {
        this.logChMain.log(-2137614336, "[ReadOutSync#stop] Stop read out sync thread. ");
        this.active = false;
        super.notify();
    }

    private boolean hasTimeForSpeaking() {
        long l;
        long l2;
        boolean bl;
        if (!this.rgActive) {
            this.logChMain.log(-2137614336, "[ReadOutSync#hasTimeForSpeaking] No route guidance active => we assume that there's engough time for speaking.");
            return true;
        }
        long l3 = this.framework.getMonotonicTime();
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[ReadOutSync#hasTimeForSpeaking] currentTime: %1, timeStamp: %2, timespan: %3 ", l3, this.timeStamp, this.timespan);
        }
        boolean bl2 = bl = (l2 = l3 - this.timeStamp) < (l = this.timespan - 0);
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[ReadOutSync#hasTimeForSpeaking] timeLag: %1, availableTime: %2, result: %3", l2, l, bl);
        }
        return bl;
    }

    private boolean hasTimeForRepeating() {
        long l;
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[ReadOutSync#hasTimeForRepeating] Called. ");
        }
        return (l = this.framework.getMonotonicTime()) - this.timeStamp < this.timespan - 0;
    }

    @Override
    public synchronized void sessionStopped() {
        if (this.msg == null) {
            this.logChMain.log(-2137614336, "[ReadOutSync#sessionStopped] Called, message: null ");
        } else {
            this.logChMain.log(-2137614336, "[ReadOutSync#sessionStopped] Called, message: %1, message ID: %2 ", (Object)this.msg.getReadOutString(), this.msg.getMessageID());
        }
        if (this.speakingAborted) {
            this.logChMain.log(-2137614336, "[ReadOutSync#sessionStopped] Speaking message was aborted.");
        }
        if (this.speakingFailed) {
            this.logChMain.log(-2137614336, "[ReadOutSync#sessionStopped] Speaking message has failed, notify message queue.");
            this.tmcMsgQueue.speakingFinished(this.msg);
        } else {
            this.logChMain.log(-2137614336, "[ReadOutSync#sessionStopped] Speaking message finished, notify message queue. ");
            this.tmcMsgQueue.speakingFinished(this.msg);
        }
        this.currentlySpeaking = false;
        this.currentlyRepeating = false;
        super.notify();
    }

    @Override
    public synchronized void speakingFinished() {
        if (this.msg == null) {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFinished] Speaking message finished, message: null ");
        } else {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFinished] Speaking message finished, message: %1, message ID: %2 ", (Object)this.msg.getReadOutString(), this.msg.getMessageID());
        }
        this.speakingAborted = false;
        this.speakingFailed = false;
        this.timeOfLastSpokenMessage = this.framework.getMonotonicTime();
    }

    @Override
    public synchronized void speakingAborted() {
        if (this.msg == null) {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFinished] Speaking message was aborted, message: null ");
        } else {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFinished] Speaking message was aborted, message: %1, message ID: %2 ", (Object)this.msg.getReadOutString(), this.msg.getMessageID());
        }
        this.speakingAborted = true;
    }

    @Override
    public synchronized void speakingFailed() {
        if (this.msg == null) {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFailed] Speaking message was aborted, message: null");
        } else {
            this.logChMain.log(-2137614336, "[ReadOutSync#speakingFailed] Speaking message was aborted, message: %1, message ID: %2", (Object)this.msg.getReadOutString(), this.msg.getMessageID());
        }
        this.speakingFailed = true;
    }

    @Override
    public synchronized void containsMessages() {
        this.logChMain.log(-2137614336, "[ReadOutSync#containsMessages] Queue contains messages and could be spoken. ");
        super.notify();
    }

    @Override
    public void sessionStarted() {
        this.logChMain.log(-2137614336, "[ReadOutSync#sessionStarted] Called.");
    }

    @Override
    public void sessionPaused() {
        this.logChMain.log(-2137614336, "[ReadOutSync#sessionPaused] Called.");
    }

    @Override
    public void sessionResumed() {
        this.logChMain.log(-2137614336, "[ReadOutSync#sessionResumed] Called.");
    }

    @Override
    public void audioAvailable(boolean bl) {
        this.logChMain.log(-2137614336, "[ReadOutSync#audioAvailable] Called.");
    }

    @Override
    public void speakingStarted() {
        this.logChMain.log(-2137614336, "[ReadOutSync#speakingStarted] Called.");
    }

    private synchronized TMCReadOutMessage getTmcMessage() {
        return this.tmcMsgQueue.getTmcMessage();
    }

    public synchronized void updateTmcUrgentMessages(TmcMessage[] tmcMessageArray) {
        String string = tmcMessageArray == null ? "null" : String.valueOf(tmcMessageArray.length);
        this.logChMain.log(-2137614336, "[ReadOutSync#updateTmcUrgentMessages] Called, forward to urgent queue, number of messages: %1 ", (Object)string);
        this.tmcMsgQueue.updateTmcUrgentMessages(tmcMessageArray);
    }

    public void setTTSService(TTSSingleSpeakService tTSSingleSpeakService) {
        this.logChMain.log(-2137614336, "[ReadOutSync#setTTSService] Called.");
        this.ttsService = tTSSingleSpeakService;
    }

    public void setTTSServiceNoTel(TTSSingleSpeakService tTSSingleSpeakService) {
        this.logChMain.log(-2137614336, "[ReadOutSync#setTTSServiceNoTel] Called.");
        this.ttsServiceNoTel = tTSSingleSpeakService;
    }

    public TTSSingleSpeakService getTTSService() {
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(3829);
        if (choiceModelApp == null || choiceModelApp.getValue() != 1) {
            if (this.logChMain.isDebug2()) {
                this.logChMain.log(14808325, "[AppTMCReadOut#setReadOutMode] Currently using ttsService ");
            }
            return this.ttsService;
        }
        if (this.logChMain.isDebug2()) {
            this.logChMain.log(14808325, "[AppTMCReadOut#setReadOutMode] Currently using ttsServiceNoTel ");
        }
        return this.ttsServiceNoTel;
    }

    public void setRgActive(boolean bl) {
        this.rgActive = bl;
    }

    protected boolean checkSetupNavAnnouncementsEnabled() {
        if (this.env.getFramework().isAsia()) {
            this.logChMain.log(-2137614336, "[AppTMCReadOut#checkSetupNavAnnouncementsEnabled] Nav announcements disabled for CLU3 - clear queue");
            return false;
        }
        ChoiceModelApp choiceModelApp = this.env.getChoiceModel(555);
        if (choiceModelApp == null || choiceModelApp.getValue() != 3) {
            return true;
        }
        this.logChMain.log(-2137614336, "[AppTMCReadOut#checkSetupNavAnnouncementsEnabled] Nav announcements disabled - clear queue");
        this.updateTmcUrgentMessages(null);
        return false;
    }

    @Override
    public void speakingPaused() {
    }
}

