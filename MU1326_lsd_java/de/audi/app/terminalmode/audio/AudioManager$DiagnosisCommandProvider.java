/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.audio;

import de.audi.app.terminalmode.audio.AudioManager;
import de.audi.app.terminalmode.diagnosis.IDiagnosisCommandProvider;
import de.audi.atip.audio.HMIAudioServiceListener;

final class AudioManager$DiagnosisCommandProvider
implements IDiagnosisCommandProvider {
    private final String PAUSE_AC;
    private final String START_AC;
    private final HMIAudioServiceListener hmiAudioServiceListener;
    private final /* synthetic */ AudioManager this$0;

    public AudioManager$DiagnosisCommandProvider(AudioManager audioManager, HMIAudioServiceListener hMIAudioServiceListener) {
        this.this$0 = audioManager;
        this.PAUSE_AC = "pauseConnection(AC)";
        this.START_AC = "startConnection(AC)";
        this.hmiAudioServiceListener = hMIAudioServiceListener;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"pauseConnection(AC)", "startConnection(AC)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("pauseConnection(AC)".equals(string)) {
            this.hmiAudioServiceListener.pauseConnection(Integer.parseInt(stringArray[0]), 0);
        } else if ("startConnection(AC)".equals(string)) {
            this.hmiAudioServiceListener.startConnection(Integer.parseInt(stringArray[0]), 0);
        }
    }
}

