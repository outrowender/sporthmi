/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.audio;

import de.audi.app.media.audio.AudioManager;
import de.audi.app.media.diagnosis.IDiagnosisDataProvider;
import de.esolutions.fw.util.commons.Buffer;

class AudioManager$6
implements IDiagnosisDataProvider {
    private final /* synthetic */ AudioManager this$0;

    AudioManager$6(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public String getDiagValue() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < 8; ++i2) {
            buffer.append("terminal='").append(i2).append("', focus='").append(AudioManager.access$2000(this.this$0)[i2]).append("'\n");
        }
        return buffer.toString();
    }

    @Override
    public String getDiagKey() {
        return "AudioManager.audioFocus";
    }
}

