/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.core.model.TelDefaultChoiceListener;

class TelAudioScenarioHandler$RingtoneMuteChoiceListener
extends TelDefaultChoiceListener {
    private final /* synthetic */ TelAudioScenarioHandler this$0;

    public TelAudioScenarioHandler$RingtoneMuteChoiceListener(TelAudioScenarioHandler telAudioScenarioHandler, ITelApplication iTelApplication) {
        this.this$0 = telAudioScenarioHandler;
        super(iTelApplication, -1483406336);
    }

    @Override
    public void itemSelected(int n, int n2, int n3, int n4) {
        this.log.log(-2137614336, "[RingtoneMuteChoiceListener#itemSelected] modelID=%1, itemID=%2, column=%3", (long)n, (long)n2, (long)n3);
        if (n == -1483406336) {
            if (n2 == 1) {
                this.this$0.ringtoneMuteSettingEnabled();
            } else {
                this.this$0.ringtoneMuteSettingDisabled();
            }
        }
    }
}

