/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.audio;

import de.audi.app.ecall.core.audio.IAudioConnectionHandler;
import de.audi.app.ecall.core.audio.cmd.IEcallAudioCmdManager;

public class AudioConnectionHandlerImpl
implements IAudioConnectionHandler {
    private final IEcallAudioCmdManager ecallAudioCmdManager;

    public AudioConnectionHandlerImpl(IEcallAudioCmdManager iEcallAudioCmdManager) {
        this.ecallAudioCmdManager = iEcallAudioCmdManager;
    }

    @Override
    public void switchAudioSource() {
        this.ecallAudioCmdManager.schedulePhoneEcallAudioScenario(4, false);
    }

    @Override
    public void scheduleMutePinConnectionRequest() {
        this.ecallAudioCmdManager.scheduleMutePinAudioScenarioRequest();
    }
}

