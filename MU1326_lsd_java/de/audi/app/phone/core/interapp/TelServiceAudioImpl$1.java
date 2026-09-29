/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.audi.app.phone.core.audio.ITelAudio;
import de.audi.app.phone.core.event.AbstractTelInterappEvent;
import de.audi.app.phone.core.interapp.TelServiceAudioImpl;

class TelServiceAudioImpl$1
extends AbstractTelInterappEvent {
    private final /* synthetic */ TelServiceAudioImpl this$0;

    TelServiceAudioImpl$1(TelServiceAudioImpl telServiceAudioImpl, String string) {
        this.this$0 = telServiceAudioImpl;
        super(string);
    }

    @Override
    public void run() {
        ITelAudio iTelAudio = TelServiceAudioImpl.access$000(this.this$0).getAudio();
        if (iTelAudio != null) {
            TelServiceAudioImpl.access$100(this.this$0).log(1078071040, "[TelServiceAudioImpl#muteIncomingCallRingtone] muting ringtone");
            iTelAudio.muteRingtone(true);
        } else {
            TelServiceAudioImpl.access$200(this.this$0).log(-1601830656, "[TelServiceAudioImpl#muteIncomingCallRingtone] audioCmp is null --> NOP!");
        }
    }
}

