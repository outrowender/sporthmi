/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.EcallAudioScenarioHandler;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdDefaultListener;

class EcallAudioScenarioHandler$AudioServiceListener
extends EcallAudioCmdDefaultListener {
    private final /* synthetic */ EcallAudioScenarioHandler this$0;

    public EcallAudioScenarioHandler$AudioServiceListener(EcallAudioScenarioHandler ecallAudioScenarioHandler, IEcallApplication iEcallApplication) {
        this.this$0 = ecallAudioScenarioHandler;
        super(iEcallApplication);
    }

    @Override
    public void updateAMAvailable(boolean bl) {
        this.log.log(1078071040, "EcallAudioScenarioHandler.AudioServiceListener#updateAMAvailable(): available=%1", bl);
        if (bl && EcallAudioScenarioHandler.access$000(this.this$0) != 0) {
            this.this$0.forceTriggerAudioSource(EcallAudioScenarioHandler.access$000(this.this$0));
        }
    }
}

