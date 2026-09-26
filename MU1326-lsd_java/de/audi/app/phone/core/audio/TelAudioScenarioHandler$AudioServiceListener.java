/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.core.audio.TelDefaultHMIAudioServiceListener;

class TelAudioScenarioHandler$AudioServiceListener
extends TelDefaultHMIAudioServiceListener {
    private final /* synthetic */ TelAudioScenarioHandler this$0;

    public TelAudioScenarioHandler$AudioServiceListener(TelAudioScenarioHandler telAudioScenarioHandler, ITelApplication iTelApplication) {
        this.this$0 = telAudioScenarioHandler;
        super(iTelApplication, "App.Phone.Audio");
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.log.log(1078071040, "[TelAudioScenarioHandler.AudioServiceListener#updateAMAvailable] currentAudioScenario=%2, available=%1", bl, (long)TelAudioScenarioHandler.access$000(this.this$0));
        boolean bl2 = !this.this$0.isAmAvailable() && bl && TelAudioScenarioHandler.access$000(this.this$0) != 0;
        this.this$0.setAmAvailable(bl);
        if (bl2) {
            TelAudioScenarioHandler.access$100(this.this$0, true);
        }
    }
}

