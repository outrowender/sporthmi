/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.core.model.TelDefaultButtonListener;

class TelAudioScenarioHandler$ToggleMicMuteButtonListner
extends TelDefaultButtonListener {
    private final /* synthetic */ TelAudioScenarioHandler this$0;

    public TelAudioScenarioHandler$ToggleMicMuteButtonListner(TelAudioScenarioHandler telAudioScenarioHandler, ITelApplication iTelApplication) {
        this.this$0 = telAudioScenarioHandler;
        super(iTelApplication, -1399323648);
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        this.log.log(1078071040, "[ToggleMicMuteButtonListner#keyTyped] modelID=%1, keyID=%2, terminalID=%3", (long)n, (long)n2, (long)n3);
        if (n == -1399323648) {
            this.this$0.toggelMicMuteState(n3);
        }
    }
}

