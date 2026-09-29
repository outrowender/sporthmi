/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.JobSetPlaybackMode;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;

class MediaOnlineSessionPlayerImpl$8
extends AbstractDispatcherRunnable {
    private final /* synthetic */ boolean val$repeatTitle;
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$8(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string, boolean bl) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        this.val$repeatTitle = bl;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.setRepeatTitle] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).getPlayerQueue().enqueue(new JobSetPlaybackMode(MediaOnlineSessionPlayerImpl.access$200(this.this$0), MediaOnlineSessionPlayerImpl.access$000(this.this$0), MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getPlayModeForRepeatMode(this.val$repeatTitle)));
    }
}

