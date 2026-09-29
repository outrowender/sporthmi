/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.evo.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.model.TelDefaultButtonListener;
import de.audi.app.phone.evo.audio.TelEvoAudioScenarioHandler;

class TelEvoAudioScenarioHandler$MuteRingtoneEvoButtonListener
extends TelDefaultButtonListener {
    private final /* synthetic */ TelEvoAudioScenarioHandler this$0;

    public TelEvoAudioScenarioHandler$MuteRingtoneEvoButtonListener(TelEvoAudioScenarioHandler telEvoAudioScenarioHandler, ITelApplication iTelApplication) {
        this.this$0 = telEvoAudioScenarioHandler;
        super(iTelApplication, -1550515200);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[MuteRingtoneEvoButtonListener#keyTyped] muting ringtone!");
        this.this$0.muteRingtone(true);
        TelEvoAudioScenarioHandler.access$000(this.this$0).onIncomingCallMute();
    }
}

