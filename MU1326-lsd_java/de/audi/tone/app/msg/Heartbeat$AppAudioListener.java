/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.msg;

import de.audi.tone.app.intra.AbstractAppListener;
import de.audi.tone.app.msg.Heartbeat;
import de.audi.tone.app.msg.Heartbeat$1;

class Heartbeat$AppAudioListener
extends AbstractAppListener {
    private final /* synthetic */ Heartbeat this$0;

    private Heartbeat$AppAudioListener(Heartbeat heartbeat) {
        this.this$0 = heartbeat;
    }

    @Override
    public void updateVolume(int n, int n2, int n3) {
        if (n2 == 82) {
            Heartbeat.access$200(this.this$0).log(1078071040, "[AppAudioListener.updateVolume] volume: %1", (long)n3);
            Heartbeat.access$302(this.this$0, n3);
        }
    }

    @Override
    public void updateConnectionStatus(int n, int n2, int n3) {
        if (Heartbeat.access$400(this.this$0)) {
            Heartbeat.access$200(this.this$0).log(1078071040, "[Heartbeat.playHeartbeat] readinessSound coded do not play heartbeat");
            return;
        }
        if (n == 48) {
            switch (n2) {
                case 2: {
                    Heartbeat.access$500(this.this$0).fadeToConnection(0, n);
                    break;
                }
                case 0: {
                    Heartbeat.access$600(this.this$0).play();
                    break;
                }
            }
        }
    }

    @Override
    public void menuVolumeRange(int n, int n2, int n3) {
        if (n == 82) {
            Heartbeat.access$200(this.this$0).log(1078071040, "[AppAudioListener.menuVolumeRange] min: %1", (long)n2);
            Heartbeat.access$702(this.this$0, n2);
        }
    }

    /* synthetic */ Heartbeat$AppAudioListener(Heartbeat heartbeat, Heartbeat$1 heartbeat$1) {
        this(heartbeat);
    }
}

