/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.AbstractMediaPlayer;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

class AbstractMediaPlayer$4
implements TimerListener {
    private final /* synthetic */ AbstractMediaPlayer this$0;

    AbstractMediaPlayer$4(AbstractMediaPlayer abstractMediaPlayer) {
        this.this$0 = abstractMediaPlayer;
    }

    @Override
    public void fireTimer(Timer timer) {
        AbstractMediaPlayer.access$400(this.this$0).main().log(1078071040, "[%1.fireTimer] Send delayed notification of detailInfo.", (Object)"AbstractMediaPlayer");
        AbstractMediaPlayer.access$600(this.this$0, AbstractMediaPlayer.access$500(this.this$0));
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

