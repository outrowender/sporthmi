/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public interface ITimerFactory {
    default public Timer createTimer(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
    }

    default public Timer createTimer(String string, TimerListener timerListener, long l, boolean bl) {
    }
}

