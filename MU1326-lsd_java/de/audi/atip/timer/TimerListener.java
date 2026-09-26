/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.Timer;

public interface TimerListener {
    default public void fireTimer(Timer timer) {
    }

    default public void cancelTimer(Timer timer) {
    }
}

