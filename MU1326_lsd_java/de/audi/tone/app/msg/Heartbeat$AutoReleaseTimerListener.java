/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tone.app.msg.Heartbeat;

public class Heartbeat$AutoReleaseTimerListener
extends DefaultTimerListener {
    private final /* synthetic */ Heartbeat this$0;

    public Heartbeat$AutoReleaseTimerListener(Heartbeat heartbeat) {
        this.this$0 = heartbeat;
    }

    @Override
    public void fireTimer(Timer timer) {
        if (timer != null && timer.equals(Heartbeat.access$900(this.this$0))) {
            Heartbeat.access$200(this.this$0).log(-2137614336, "[Heartbeat.AutoReleaseTimerListener.fireTimer] release heartbeat connection ");
            Heartbeat.access$500(this.this$0).releaseConnection(48);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
        Heartbeat.access$200(this.this$0).log(-2137614336, "[Heartbeat.AutoReleaseTimerListener.cancelTimer] called ");
    }
}

