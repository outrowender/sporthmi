/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.util;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.util.AbstractLongPressButtonListener;

public abstract class AbstractDoublePressButtonListener
extends AbstractLongPressButtonListener
implements TimerListener {
    private Timer doublePressTimer;
    private long doublePressTimeOut;

    protected abstract void doublePressed();

    private void restartDoublePressTimer() {
        if (this.doublePressTimer == null) {
            this.doublePressTimer = new Timer("DoublePressTimer", this.doublePressTimeOut, true, this);
        }
        this.doublePressTimer.restart();
    }

    private void cancelDoublePressTimer() {
        if (this.doublePressTimer != null) {
            this.doublePressTimer.cancel();
        }
    }

    public void fireTimer(Timer timer) {
        if (timer.equals(this.doublePressTimer)) {
            this.shortPressed();
        } else {
            super.fireTimer(timer);
        }
    }

    public AbstractDoublePressButtonListener(LogChannel logChannel, long l) {
        super(logChannel);
        this.doublePressTimeOut = l;
    }

    public void keyPressed(int n, int n2, int n3) {
        if (this.doublePressTimer != null && this.doublePressTimer.isRunning()) {
            this.cancelDoublePressTimer();
            this.doublePressed();
        } else {
            this.restartDoublePressTimer();
        }
    }

    public void keyReleased(int n, int n2, int n3) {
        if (this.doublePressTimer == null || !this.doublePressTimer.isRunning()) {
            super.keyReleased(n, n2, n3);
        }
    }

    public void keyTyped(int n, int n2, int n3) {
        if (this.doublePressTimer == null || !this.doublePressTimer.isRunning()) {
            super.keyTyped(n, n2, n3);
        }
    }
}

