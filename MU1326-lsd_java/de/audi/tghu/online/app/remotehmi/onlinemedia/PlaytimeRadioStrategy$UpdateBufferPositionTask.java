/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.remotehmi.onlinemedia;

import de.audi.remotehmi.media.IOnlineMediaSession;
import de.audi.tghu.online.app.remotehmi.AbstractRemoteHMITask;
import de.audi.tghu.online.app.remotehmi.onlinemedia.PlaytimeRadioStrategy;

public class PlaytimeRadioStrategy$UpdateBufferPositionTask
extends AbstractRemoteHMITask {
    IOnlineMediaSession session;
    private final /* synthetic */ PlaytimeRadioStrategy this$0;

    public PlaytimeRadioStrategy$UpdateBufferPositionTask(PlaytimeRadioStrategy playtimeRadioStrategy, String string, IOnlineMediaSession iOnlineMediaSession) {
        this.this$0 = playtimeRadioStrategy;
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
        PlaytimeRadioStrategy.access$000(this.this$0, this.session);
    }
}

