/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.JobStop;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;

class MediaOnlineSessionPlayerImpl$3
extends AbstractDispatcherRunnable {
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$3(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onSeek] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).getPlayerQueue().enqueue(new JobStop(MediaOnlineSessionPlayerImpl.access$200(this.this$0), MediaOnlineSessionPlayerImpl.access$000(this.this$0)));
    }
}

