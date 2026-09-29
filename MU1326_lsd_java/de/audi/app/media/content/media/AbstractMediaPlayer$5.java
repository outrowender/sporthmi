/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AbstractMediaPlayer$5
implements TimerListener {
    private final /* synthetic */ AbstractMediaPlayer this$0;

    AbstractMediaPlayer$5(AbstractMediaPlayer abstractMediaPlayer) {
        this.this$0 = abstractMediaPlayer;
    }

    @Override
    public void fireTimer(Timer timer) {
        AbstractMediaPlayer.access$700(this.this$0).main().log(1078071040, "[%1.dvdMenuTimer] DVD Menu left.", (Object)"AbstractMediaPlayer");
        if (AbstractMediaPlayer.access$800(this.this$0)) {
            AbstractMediaPlayer.access$900(this.this$0, this.this$0.currentPlaybackState);
            AbstractMediaPlayer.access$1000(this.this$0, this.this$0.currentPlaybackState);
            AbstractMediaPlayer.access$802(this.this$0, false);
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

