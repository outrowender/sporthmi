/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio;

import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.audio.EcallAudioScenarioHandler;
import de.audi.app.ecall.core.audio.cmd.EcallAudioCmdDefaultListener;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;

class EcallAudioScenarioHandler$MutePinListener
extends EcallAudioCmdDefaultListener {
    private final ChoiceModelApp mutePinActiveModel;
    private static final int MUTE_PIN_INACTIVE;
    private static final int MUTE_PIN_ACTIVE;
    private final /* synthetic */ EcallAudioScenarioHandler this$0;

    public EcallAudioScenarioHandler$MutePinListener(EcallAudioScenarioHandler ecallAudioScenarioHandler, IEcallApplication iEcallApplication, int n) {
        this.this$0 = ecallAudioScenarioHandler;
        super(iEcallApplication);
        this.mutePinActiveModel = iEcallApplication.getFrameworkAccess().getHMIService().getChoiceModel(n);
    }

    @Override
    public void updateMutePinState(boolean bl, int n) {
        this.log.log(1078071040, "EcallAudioScenarioHandler.MutePinListener#updateMutePinState(): mutePinState=%1", bl);
        if (n != 1) {
            return;
        }
        if (this.isECallAudioActive()) {
            this.log.log(1078071040, "EcallAudioScenarioHandler.MutePinListener#updateMutePinState(): ECALL active, do not release ECALL_MUTE!!!");
            return;
        }
        if (bl) {
            EcallAudioScenarioHandler.access$100(this.this$0).scheduleMutePinMuteRequest();
            this.mutePinActiveModel.setValue(1);
        } else {
            EcallAudioScenarioHandler.access$100(this.this$0).scheduleMutePinMuteRelease();
            this.mutePinActiveModel.setValue(0);
        }
    }

    private boolean isECallAudioActive() {
        return EcallAudioScenarioHandler.access$000(this.this$0) == 4 || EcallAudioScenarioHandler.access$000(this.this$0) == 3 || EcallAudioScenarioHandler.access$000(this.this$0) == 7;
    }
}

