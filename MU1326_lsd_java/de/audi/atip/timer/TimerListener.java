/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.Timer;

public interface TimerListener {
    public void fireTimer(Timer var1);

    public void cancelTimer(Timer var1);
}

