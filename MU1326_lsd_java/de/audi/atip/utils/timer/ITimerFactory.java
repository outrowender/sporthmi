/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.timer;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public interface ITimerFactory {
    public Timer createTimer(String var1, int var2, LogChannel var3, TimerListener var4, long var5, boolean var7);

    public Timer createTimer(String var1, TimerListener var2, long var3, boolean var5);
}

