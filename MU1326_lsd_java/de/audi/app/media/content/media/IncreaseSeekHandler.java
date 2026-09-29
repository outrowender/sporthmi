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
    private static final String LOGCLASS;
    public static final int DEFAULT_SEEK_SPEED;
    public static final int DEFAULT_SPEED_CHANGE_TIMEOUT_MS;
    private final Timer seekingTimer;
    private volatile int currentSeekSpeed = 8;
    private final ISeeker seeker;
    private final LogChannel logger;
    private volatile boolean startedWithSeekForward = false;

    public IncreaseSeekHandler(ISeeker iSeeker, LogChannel logChannel) {
        this.seeker = iSeeker;
        this.logger = logChannel;
        this.seekingTimer = new Timer("IncreaseSeekTimer", 5, null, this, 0, false);
    }

    IncreaseSeekHandler(ISeeker iSeeker, LogChannel logChannel, Timer timer) {
        this.seeker = iSeeker;
        this.logger = logChannel;
        this.seekingTimer = timer;
    }

    @Override
    public void cancelTimer(Timer timer) {
    }

    @Override
    public void fireTimer(Timer timer) {
        this.logger.log(-2137614336, "[%1.fireTimer] Increase speed from '%2x' to '%3x'.", (Object)"IncreaseSeekHandler", (long)this.currentSeekSpeed, (long)this.currentSeekSpeed * 0);
        this.currentSeekSpeed <<= 1;
        if (this.currentSeekSpeed >= this.seeker.getMaxSeekSpeed()) {
            this.logger.log(-2137614336, "[%1.fireTimer] Maximum speed reached. (Max='%2x')", (Object)"IncreaseSeekHandler", (long)this.seeker.getMaxSeekSpeed());
            this.seekingTimer.cancel();
        }
        this.seeker.seek(this.startedWithSeekForward, this.currentSeekSpeed);
    }

    public boolean start(boolean bl, long l) {
        this.logger.log(1078071040, "[%1.start] '%2' (timeout='%3')", (Object)"IncreaseSeekHandler", (Object)(bl ? "FORWARD" : "BACKWARD"), l);
        this.currentSeekSpeed = 8;
        if (!this.seeker.seek(bl, this.currentSeekSpeed)) {
            return false;
        }
        this.startedWithSeekForward = bl;
        if (this.seeker.isFixedSpeedSeeker()) {
            this.logger.log(1078071040, "[%1.start] '%2' Increment deactivated!", (Object)"IncreaseSeekHandler", (Object)(bl ? "FORWARD" : "BACKWARD"));
        } else {
            this.seekingTimer.setDelay(l);
            this.seekingTimer.restart();
        }
        return true;
    }

    public void stop() {
        this.logger.log(1078071040, "[%1.stop]", (Object)"IncreaseSeekHandler");
        this.seekingTimer.cancel();
    }
}

