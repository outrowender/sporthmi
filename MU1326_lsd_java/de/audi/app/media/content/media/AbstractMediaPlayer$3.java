/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;

class AbstractMediaPlayer$3
implements Runnable {
    private final /* synthetic */ AbstractMediaPlayer this$0;

    AbstractMediaPlayer$3(AbstractMediaPlayer abstractMediaPlayer) {
        this.this$0 = abstractMediaPlayer;
    }

    @Override
    public void run() {
        AbstractMediaPlayer.access$100(this.this$0).main().log(1078071040, "[%1.updatePlayPosition] iPod playbackModes - Done: Reset playbackModes. playbackModes: %2", (Object)"AbstractMediaPlayer", (Object)this.this$0.capabilities.playbackModes);
        this.this$0.updatePlaybackModeList(AbstractMediaPlayer.access$200(this.this$0));
        this.this$0.updatePlaybackMode(AbstractMediaPlayer.access$300(this.this$0));
        this.this$0.playbackModeHandler.updatePlaymodesAvailable(true);
    }
}

