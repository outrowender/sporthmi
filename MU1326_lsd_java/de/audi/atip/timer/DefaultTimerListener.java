/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.timer;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class DefaultTimerListener
implements TimerListener {
    public static final TimerListener DEFAULT_LISTENER = new DefaultTimerListener();

    public void fireTimer(Timer timer) {
    }

    public void cancelTimer(Timer timer) {
    }
}

