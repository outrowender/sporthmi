/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.tone.app.msg.DefaultMsgListener;
import de.audi.tone.app.msg.Heartbeat;
import de.audi.tone.app.msg.Heartbeat$1;

class Heartbeat$MsgListener
extends DefaultMsgListener {
    private final /* synthetic */ Heartbeat this$0;

    private Heartbeat$MsgListener(Heartbeat heartbeat) {
        this.this$0 = heartbeat;
    }

    @Override
    protected void playHeartbeat() {
        if (Heartbeat.access$400(this.this$0)) {
            Heartbeat.access$200(this.this$0).log(1078071040, "[Heartbeat.playHeartbeat] readinessSound coded do not play heartbeat");
            return;
        }
        if (Heartbeat.access$300(this.this$0) > Heartbeat.access$700(this.this$0) && Heartbeat.access$800(this.this$0)) {
            Heartbeat.access$200(this.this$0).log(1078071040, "[Heartbeat.playHeartbeat]");
            Heartbeat.access$500(this.this$0).requestConnection(0, 48);
            Heartbeat.access$900(this.this$0).restart();
        } else {
            Heartbeat.access$200(this.this$0).log(1078071040, "[Heartbeat.playHeartbeat] waveplayerInitialized: %1", Heartbeat.access$800(this.this$0));
            Heartbeat.access$200(this.this$0).log(1078071040, "[Heartbeat.playHeartbeat] do not play heartbeat currentHeartbeatVolume: %1, minHeartbeatVolume: %2", (long)Heartbeat.access$300(this.this$0), (long)Heartbeat.access$700(this.this$0));
        }
    }

    /* synthetic */ Heartbeat$MsgListener(Heartbeat heartbeat, Heartbeat$1 heartbeat$1) {
        this(heartbeat);
    }
}

