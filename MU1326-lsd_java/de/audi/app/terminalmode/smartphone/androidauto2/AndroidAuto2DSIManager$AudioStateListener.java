/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.audio.AudioConnectionState;
import de.audi.app.terminalmode.audio.IAudioStateListener;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager;
import de.audi.app.terminalmode.smartphone.androidauto2.AndroidAuto2DSIManager$1;

class AndroidAuto2DSIManager$AudioStateListener
implements IAudioStateListener {
    private final /* synthetic */ AndroidAuto2DSIManager this$0;

    private AndroidAuto2DSIManager$AudioStateListener(AndroidAuto2DSIManager androidAuto2DSIManager) {
        this.this$0 = androidAuto2DSIManager;
    }

    @Override
    public void audioStateChanged(AudioConnectionState audioConnectionState) {
    }

    @Override
    public void audioFocusChanged(boolean bl) {
        AndroidAuto2DSIManager.access$300(this.this$0).log(1078071040, "[%1.audioFocusChanged]", (Object)"AndroidAuto2DSIManager");
        if (!bl) {
            this.this$0.mediaState = AndroidAuto2DSIManager.access$400(this.this$0);
        }
    }

    /* synthetic */ AndroidAuto2DSIManager$AudioStateListener(AndroidAuto2DSIManager androidAuto2DSIManager, AndroidAuto2DSIManager$1 androidAuto2DSIManager$1) {
        this(androidAuto2DSIManager);
    }
}

