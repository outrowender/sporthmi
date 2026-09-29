/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.atip.utils.timer.ITimerFactory;

public class DefaultTimerFactory
implements ITimerFactory {
    @Override
    public Timer createTimer(String string, int n, LogChannel logChannel, TimerListener timerListener, long l, boolean bl) {
        return new Timer(string, n, logChannel, timerListener, l, bl);
    }

    @Override
    public Timer createTimer(String string, TimerListener timerListener, long l, boolean bl) {
        return new Timer(string, l, bl, timerListener);
    }
}

