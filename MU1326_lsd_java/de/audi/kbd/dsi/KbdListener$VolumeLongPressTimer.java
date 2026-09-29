/*
 * Decompiled with CFR 0.152.
 */
package de.audi.kbd.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.kbd.KeyMap;
import de.audi.kbd.dsi.KbdListener;
import de.audi.kbd.dsi.KbdListener$1;

class KbdListener$VolumeLongPressTimer
extends DefaultTimerListener {
    private final Timer timer = new Timer("VolumeLongPressTimer", 0, false, this);
    private volatile int direction;
    private volatile int keyboardID;
    private final /* synthetic */ KbdListener this$0;

    private KbdListener$VolumeLongPressTimer(KbdListener kbdListener) {
        this.this$0 = kbdListener;
    }

    private void start(int n, int n2) {
        KbdListener.access$400(this.this$0).log(-2137614336, "KbdListener.VolumeLongPressTimer.start() direction=%1", (long)n);
        this.direction = n;
        this.keyboardID = n2;
        this.timer.restart();
    }

    private void cancel() {
        KbdListener.access$400(this.this$0).log(-2137614336, "KbdListener.VolumeLongPressTimer.cancel()");
        this.timer.cancel();
    }

    @Override
    public void fireTimer(Timer timer) {
        KbdListener.access$400(this.this$0).log(-2137614336, "KbdListener.VolumeLongPressTimer.fireTimer() direction=%1", (long)this.direction);
        KbdListener.access$500(this.this$0, 16, this.direction, 1, KeyMap.kbdID2termID(this.keyboardID));
    }

    /* synthetic */ KbdListener$VolumeLongPressTimer(KbdListener kbdListener, KbdListener$1 kbdListener$1) {
        this(kbdListener);
    }

    static /* synthetic */ void access$200(KbdListener$VolumeLongPressTimer kbdListener$VolumeLongPressTimer) {
        kbdListener$VolumeLongPressTimer.cancel();
    }

    static /* synthetic */ void access$300(KbdListener$VolumeLongPressTimer kbdListener$VolumeLongPressTimer, int n, int n2) {
        kbdListener$VolumeLongPressTimer.start(n, n2);
    }
}

