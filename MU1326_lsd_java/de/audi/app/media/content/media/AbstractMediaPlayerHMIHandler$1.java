/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.AbstractMediaPlayerHMIHandler;

class AbstractMediaPlayerHMIHandler$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ AbstractMediaPlayerHMIHandler this$0;

    AbstractMediaPlayerHMIHandler$1(AbstractMediaPlayerHMIHandler abstractMediaPlayerHMIHandler, String string) {
        this.this$0 = abstractMediaPlayerHMIHandler;
        super(string);
    }

    @Override
    public void run() {
        if (AbstractMediaPlayerHMIHandler.access$000(this.this$0).isPlaying() || AbstractMediaPlayerHMIHandler.access$000(this.this$0).isSeeking()) {
            AbstractMediaPlayerHMIHandler.access$100(this.this$0).hmi().log(-2137614336, "[%1.keyTyped] Player not paused. Mute it.", (Object)"AbstractMediaPlayerHMIHandler");
            this.this$0.getTerminal().getAudioManager().mute();
        } else {
            AbstractMediaPlayerHMIHandler.access$200(this.this$0).hmi().log(-2137614336, "[%1.keyTyped] Player paused.", (Object)"AbstractMediaPlayerHMIHandler");
            AbstractMediaPlayerHMIHandler.access$000(this.this$0).resume();
        }
    }
}

