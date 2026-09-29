/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.audio.AudioState;
import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.app.media.diagnosis.IDiagnosisCommandProvider;

class AbstractMediaPlayer$1
implements IDiagnosisCommandProvider {
    private final /* synthetic */ AbstractMediaPlayer this$0;

    AbstractMediaPlayer$1(AbstractMediaPlayer abstractMediaPlayer) {
        this.this$0 = abstractMediaPlayer;
    }

    @Override
    public String[] getDiagKeys() {
        return new String[]{"AbstractMediaPlayer.audioStateChanged(connection:int state:int)"};
    }

    @Override
    public void executeDiagCommand(String string, String[] stringArray) {
        if ("AbstractMediaPlayer.audioStateChanged(connection:int state:int)".equals(string)) {
            this.this$0.audioStateChanged(new AudioState(Integer.parseInt(stringArray[0]), Integer.parseInt(stringArray[1])));
        }
    }
}

