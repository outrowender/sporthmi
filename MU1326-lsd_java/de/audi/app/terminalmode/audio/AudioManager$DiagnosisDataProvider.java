/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.audio.AudioManager$1;
import de.audi.app.terminalmode.diagnosis.IDiagnosisDataProvider;

final class AudioManager$DiagnosisDataProvider
implements IDiagnosisDataProvider {
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$DiagnosisDataProvider(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public String getDiagKey() {
        return "getActiveAudioConnections";
    }

    @Override
    public String getDiagValue() {
        return AudioManager.access$1700(this.this$0).toString();
    }

    /* synthetic */ AudioManager$DiagnosisDataProvider(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }
}

