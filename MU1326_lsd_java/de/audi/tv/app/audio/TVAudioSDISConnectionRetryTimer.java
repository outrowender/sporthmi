/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.audio;

import de.audi.atip.audio.HMIAudioServiceListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tv.app.audio.TVAudioService;

public class TVAudioSDISConnectionRetryTimer
implements HMIAudioServiceListener,
TimerListener {
    static final int AUDIO_TERMINAL_ID = 2;
    static final int CONNECTION_ID = 307;
    private static final int RETRY_TIMEOUT = 300;
    static final int MAX_RETRY_COUNT = 3;
    private final Timer retryTimer;
    private final TVAudioService tvAudioService;
    private final LogChannel logger;
    private volatile int retryCount = 0;

    TVAudioSDISConnectionRetryTimer(TVAudioService tVAudioService, LogChannel logChannel, Timer timer) {
        this.retryTimer = timer;
        this.tvAudioService = tVAudioService;
        this.logger = logChannel;
    }

    public TVAudioSDISConnectionRetryTimer(TVAudioService tVAudioService, LogChannel logChannel) {
        this.retryTimer = new Timer("SDISAudioConnectionRetryTimer", 300L, true, this);
        this.tvAudioService = tVAudioService;
        this.logger = logChannel;
    }

    public void fireTimer(Timer timer) {
        ++this.retryCount;
        this.logger.log(100000, "[SDISAudioConnectionRetryTimer.fireTimer] Retry to request connection (%1/%2).", (long)this.retryCount, 3L);
        this.tvAudioService.requestConnection(307, 2);
    }

    public void cancelTimer(Timer timer) {
        this.logger.log(1000000, "[SDISAudioConnectionRetryTimer.cancelTimer] Timer cancelled.");
    }

    private void resetTimer() {
        this.logger.log(1000000, "[SDISAudioConnectionRetryTimer.resetTimer]");
        this.retryCount = 0;
        this.retryTimer.cancel();
    }

    public void stopConnection(int n, int n2) {
        if (n == 307 && n2 == 2) {
            this.resetTimer();
        }
    }

    public void startConnection(int n, int n2) {
        if (n == 307 && n2 == 2) {
            this.resetTimer();
        }
    }

    public void errorConnection(int n, int n2, int n3) {
        if (n == 307 && n2 == 2 && n3 == 3) {
            this.logger.log(100000, "[SDISAudioConnectionRetryTimer.errorConnection] connection:'%1', terminal:'2', errorCode:'%3'.", (long)n, (long)n2, (long)n3);
            if (this.retryCount >= 3) {
                this.logger.log(10000, "[SDISAudioConnectionRetryTimer.errorConnection] Connection could not be started. No more retries.", (long)n, (long)n2, (long)n3);
                this.retryTimer.cancel();
            } else {
                this.logger.log(1000000, "[SDISAudioConnectionRetryTimer.errorConnection] Trigger next retry. Start the timer.", (long)n, (long)n2, (long)n3);
                this.retryTimer.start();
            }
        }
    }

    public void pauseConnection(int n, int n2) {
    }

    public void updateAMAvailable(boolean bl) {
    }

    public void fadedIn(int n, int n2) {
    }

    public void updateVolumeLock(int n, int n2, boolean bl) {
    }
}

