/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;

class AbstractMediaPlayer$2
implements Runnable {
    private final /* synthetic */ AbstractMediaPlayer this$0;

    AbstractMediaPlayer$2(AbstractMediaPlayer abstractMediaPlayer) {
        this.this$0 = abstractMediaPlayer;
    }

    @Override
    public void run() {
        AbstractMediaPlayer.access$000(this.this$0).main().log(1078071040, "[%1.updatePlayPosition] iPod playbackModes - Done: Disable playbackModes.", (Object)"AbstractMediaPlayer");
        this.this$0.playbackModeHandler.updatePlaymodesAvailable(false);
    }
}

