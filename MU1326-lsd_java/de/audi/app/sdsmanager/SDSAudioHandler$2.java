/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;

class SDSAudioHandler$2
implements Runnable {
    private final /* synthetic */ SDSAudioHandler this$0;

    SDSAudioHandler$2(SDSAudioHandler sDSAudioHandler) {
        this.this$0 = sDSAudioHandler;
    }

    @Override
    public void run() {
        if (SDSAudioHandler.access$300(this.this$0) == AudioDrawerContext.SOURCE_NONE) {
            SDSAudioHandler.access$000(this.this$0).log(-2137614336, "SDSAudioHandler#disableCurrentSDSAudioDrawerContext: current audio drawer context is already set back to SOURCE_NONE => NOP!");
            return;
        }
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "SDSAudioHandler#disableCurrentSDSAudioDrawerContext: Disable current audio drawer context %1!", (Object)SDSAudioHandler.access$300(this.this$0).toString());
        SDSAudioHandler.access$400(this.this$0).setContext(SDSAudioHandler.access$300(this.this$0), AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
        SDSAudioHandler.access$302(this.this$0, AudioDrawerContext.SOURCE_NONE);
    }
}

