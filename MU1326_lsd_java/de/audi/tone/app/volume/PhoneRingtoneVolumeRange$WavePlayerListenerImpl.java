/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tone.app.volume;

import de.audi.tghu.waveplayer.WavePlayerListener;
import de.audi.tone.app.volume.PhoneRingtoneVolumeRange;
import de.audi.tone.app.volume.PhoneRingtoneVolumeRange$1;

class PhoneRingtoneVolumeRange$WavePlayerListenerImpl
implements WavePlayerListener {
    private final /* synthetic */ PhoneRingtoneVolumeRange this$0;

    private PhoneRingtoneVolumeRange$WavePlayerListenerImpl(PhoneRingtoneVolumeRange phoneRingtoneVolumeRange) {
        this.this$0 = phoneRingtoneVolumeRange;
    }

    @Override
    public void state(int n) {
        int n2 = this.this$0.getForegroundConnection();
        int n3 = this.this$0.audioService.getDSI().getStatus(n2);
        PhoneRingtoneVolumeRange.access$102(this.this$0, n);
        this.this$0.env.lcHMI.log(-2137614336, "[PhoneRingtoneVolumeRange.state]  waveplayer status:%1,  connection: %2 , connectionstate: %3", (long)n, (long)n2, (long)n3);
        if (n3 == 3) {
            this.this$0.env.lcHMI.log(-2137614336, "[PhoneRingtoneVolumeRange.state]  connection: %1 , connectionstate: %2 CONN_START_REQUESTED do not call fadeToConnectioin", (long)n2, (long)n3);
            return;
        }
        PhoneRingtoneVolumeRange.access$200(this.this$0);
    }

    @Override
    public void playToneInfo(int n) {
    }

    /* synthetic */ PhoneRingtoneVolumeRange$WavePlayerListenerImpl(PhoneRingtoneVolumeRange phoneRingtoneVolumeRange, PhoneRingtoneVolumeRange$1 phoneRingtoneVolumeRange$1) {
        this(phoneRingtoneVolumeRange);
    }
}

