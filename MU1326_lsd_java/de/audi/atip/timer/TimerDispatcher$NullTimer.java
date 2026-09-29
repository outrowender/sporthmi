/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;

final class TimerDispatcher$NullTimer
extends Timer {
    TimerDispatcher$NullTimer() {
        super("NullTimer", 1L, true, new DefaultTimerListener());
    }
}

