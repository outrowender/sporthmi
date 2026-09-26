/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeSingleTrackStrategy;

public class PlaytimeSingleTrackStrategy$UpdateBufferPositionTask
extends AbstractRemoteHMITask {
    IOnlineMediaSession session;
    private final /* synthetic */ PlaytimeSingleTrackStrategy this$0;

    public PlaytimeSingleTrackStrategy$UpdateBufferPositionTask(PlaytimeSingleTrackStrategy playtimeSingleTrackStrategy, String string, IOnlineMediaSession iOnlineMediaSession) {
        this.this$0 = playtimeSingleTrackStrategy;
        super(string);
        this.session = iOnlineMediaSession;
    }

    @Override
    public boolean isCoalescable() {
        return true;
    }

    @Override
    public Long getDelayMillis() {
        return new Long(0);
    }

    @Override
    public void run() {
        PlaytimeSingleTrackStrategy.access$100(this.this$0, this.session);
    }
}

