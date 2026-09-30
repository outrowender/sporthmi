/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.ISeeker;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class IncreaseSeekHandler
implements TimerListener {
    private static final String LOGCLASS = "IncreaseSeekHandler";
    public static final int DEFAULT_SEEK_SPEED = 8;
    public static final int DEFAULT_SPEED_CHANGE_TIMEOUT_MS = 5000;
    private final Timer seekingTimer;
    private volatile int currentSeekSpeed = 8;
    private final ISeeker seeker;
    private final LogChannel logger;
    private volatile boolean startedWithSeekForward = false;

    public IncreaseSeekHandler(ISeeker iSeeker, LogChannel logChannel) {
        this.seeker = iSeeker;
        this.logger = logChannel;
        this.seekingTimer = new Timer("IncreaseSeekTimer", 5, null, this, 5000L, false);
    }

    IncreaseSeekHandler(ISeeker iSeeker, LogChannel logChannel, Timer timer) {
        this.seeker = iSeeker;
        this.logger = logChannel;
        this.seekingTimer = timer;
    }

    public void cancelTimer(Timer timer) {
    }

    public void fireTimer(Timer timer) {
        this.logger.log(10000000, "[%1.fireTimer] Increase speed from '%2x' to '%3x'.", (Object)LOGCLASS, (long)this.currentSeekSpeed, (long)this.currentSeekSpeed * 2L);
        this.currentSeekSpeed <<= 1;
        if (this.currentSeekSpeed >= this.seeker.getMaxSeekSpeed()) {
            this.logger.log(10000000, "[%1.fireTimer] Maximum speed reached. (Max='%2x')", (Object)LOGCLASS, (long)this.seeker.getMaxSeekSpeed());
            this.seekingTimer.cancel();
        }
        this.seeker.seek(this.startedWithSeekForward, this.currentSeekSpeed);
    }

    public boolean start(boolean bl, long l) {
        this.logger.log(1000000, "[%1.start] '%2' (timeout='%3')", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"), l);
        this.currentSeekSpeed = 8;
        if (!this.seeker.seek(bl, this.currentSeekSpeed)) {
            return false;
        }
        this.startedWithSeekForward = bl;
        if (this.seeker.isFixedSpeedSeeker()) {
            this.logger.log(1000000, "[%1.start] '%2' Increment deactivated!", (Object)LOGCLASS, (Object)(bl ? "FORWARD" : "BACKWARD"));
        } else {
            this.seekingTimer.setDelay(l);
            this.seekingTimer.restart();
        }
        return true;
    }

    public void stop() {
        this.logger.log(1000000, "[%1.stop]", (Object)LOGCLASS);
        this.seekingTimer.cancel();
    }
}

