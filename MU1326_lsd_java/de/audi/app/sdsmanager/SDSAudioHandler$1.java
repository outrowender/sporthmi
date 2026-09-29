/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.sdsmanager;

import de.audi.app.sdsmanager.SDSAudioHandler;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext;
import de.audi.atip.interapp.audio.drawer.AudioDrawerContext$Source;

class SDSAudioHandler$1
implements Runnable {
    private final /* synthetic */ AudioDrawerContext$Source val$audioDrawerContext;
    private final /* synthetic */ SDSAudioHandler this$0;

    SDSAudioHandler$1(SDSAudioHandler sDSAudioHandler, AudioDrawerContext$Source audioDrawerContext$Source) {
        this.this$0 = sDSAudioHandler;
        this.val$audioDrawerContext = audioDrawerContext$Source;
    }

    @Override
    public void run() {
        if (SDSAudioHandler.access$300(this.this$0).equals(this.val$audioDrawerContext)) {
            SDSAudioHandler.access$000(this.this$0).log(-2137614336, "SDSAudioHandler#switchToSDSAudioDrawerContext: audio drawer context %1 is already active => NOP!", (Object)this.val$audioDrawerContext.toString());
            return;
        }
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "SDSAudioHandler#switchToSDSAudioDrawerContext: Enable new audio drawer context %1!", (Object)this.val$audioDrawerContext.toString());
        SDSAudioHandler.access$400(this.this$0).setContext(this.val$audioDrawerContext, AudioDrawerContext.SOURCE_AUDIO_STATE_ACTIVE);
        SDSAudioHandler.access$000(this.this$0).log(-2137614336, "SDSAudioHandler#switchToSDSAudioDrawerContext: Disable old audio drawer context %1!", (Object)SDSAudioHandler.access$300(this.this$0).toString());
        SDSAudioHandler.access$400(this.this$0).setContext(SDSAudioHandler.access$300(this.this$0), AudioDrawerContext.SOURCE_AUDIO_STATE_INACTIVE);
        SDSAudioHandler.access$302(this.this$0, this.val$audioDrawerContext);
    }
}

