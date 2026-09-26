/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.audio;

import de.audi.app.messaging.core.audio.AudioManager;
import de.audi.app.messaging.core.audio.AudioManager$1;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;

class AudioManager$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ AudioManager this$0;

    private AudioManager$NewMessageIndicationManagerObserver(AudioManager audioManager) {
        this.this$0 = audioManager;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        AudioManager.access$500(this.this$0).log(-2137614336, "[AudioManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
        if (n == 0) {
            AudioManager.access$600(this.this$0);
        }
    }

    /* synthetic */ AudioManager$NewMessageIndicationManagerObserver(AudioManager audioManager, AudioManager$1 audioManager$1) {
        this(audioManager);
    }
}

