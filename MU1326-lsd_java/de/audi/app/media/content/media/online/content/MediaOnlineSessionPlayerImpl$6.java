/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.JobSkip;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;

class MediaOnlineSessionPlayerImpl$6
extends AbstractDispatcherRunnable {
    private final /* synthetic */ int val$count;
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$6(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string, int n) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        this.val$count = n;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onSkip] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).getPlayerQueue().enqueue(new JobSkip(MediaOnlineSessionPlayerImpl.access$200(this.this$0), MediaOnlineSessionPlayerImpl.access$000(this.this$0), this.val$count));
    }
}

