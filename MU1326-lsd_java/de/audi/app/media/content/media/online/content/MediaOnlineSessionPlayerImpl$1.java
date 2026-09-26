/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.JobResume;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;

class MediaOnlineSessionPlayerImpl$1
extends AbstractDispatcherRunnable {
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$1(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onResume] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        if (MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getAudioState().isAudible()) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onResume] [%2] Already hearable.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            if (MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().isOnSeeking()) {
                MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onResume] [%2] On seeking. Resume playback.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
                MediaOnlineSessionPlayerImpl.access$000(this.this$0).getPlayerQueue().enqueue(new JobResume(MediaOnlineSessionPlayerImpl.access$200(this.this$0), MediaOnlineSessionPlayerImpl.access$000(this.this$0)));
            }
        }
        MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onResume] [%2] Try to resume audio.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).getAudioManager().resumeAudio(false);
    }
}

