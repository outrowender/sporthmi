/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.hmi.model.ButtonListener;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public abstract class AbstractLongPressButtonListener
implements TimerListener,
ButtonListener {
    public static final long LONG_PRESS_TIME = 1500L;
    protected LogChannel logCh;
    private Timer timer;

    public AbstractLongPressButtonListener(LogChannel logChannel) {
        this.logCh = logChannel;
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#ctor] Called.");
        this.timer = new Timer("LongPressButtonTimer", 1500L, true, this);
    }

    protected abstract void longPressedStarted();

    protected abstract void longPressedFinished();

    protected abstract void shortPressed();

    public void cancelTimer(Timer timer) {
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#cancelTimer] Called.");
    }

    public void fireTimer(Timer timer) {
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#fireTimer] Long press is started.");
        this.longPressedStarted();
    }

    public void keyReleased(int n, int n2, int n3) {
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#keyReleased] Called, modelID: %1, terminalID: %2", (long)n, (long)n3);
        if (this.timer.isRunning()) {
            this.logCh.log(10000000, "[AbstractLongPressButtonListener#keyReleased] Pressed button was a short press.");
            this.timer.cancel();
            this.shortPressed();
        } else {
            this.logCh.log(10000000, "[AbstractLongPressButtonListener#keyReleased] Long press is finished.");
            this.longPressedFinished();
        }
    }

    public void keyPressed(int n, int n2, int n3) {
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#keyPressed] Called, modelID: %1, terminalID: %2", (long)n, (long)n3);
        this.timer.restart();
    }

    public void keyTyped(int n, int n2, int n3) {
        this.logCh.log(10000000, "[AbstractLongPressButtonListener#keyTyped] Called, modelID: %1, terminalID: %2", (long)n, (long)n3);
    }
}

