/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.audio;

import de.audi.app.phone.core.ITelApplication;
import de.audi.app.phone.core.audio.TelAudioScenarioHandler;
import de.audi.app.phone.core.msg.AbstractTelMessageListener;

class TelAudioScenarioHandler$FactoryResetHandler
extends AbstractTelMessageListener {
    private final /* synthetic */ TelAudioScenarioHandler this$0;

    public TelAudioScenarioHandler$FactoryResetHandler(TelAudioScenarioHandler telAudioScenarioHandler, ITelApplication iTelApplication) {
        this.this$0 = telAudioScenarioHandler;
        super(iTelApplication, "App.Phone.Main", 28);
    }

    @Override
    protected void messageReceived() {
        this.log.log(1078071040, "TelAudioScenarioHandler.FactoryResetHandler#messageRecieved(): called");
        this.this$0.ringtoneMuteSettingDisabled();
    }
}

