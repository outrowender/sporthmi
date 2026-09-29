/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;
import org.dsi.ifc.global.ResourceLocator;

class MediaOnlineSessionPlayerImpl$5
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$trackID;
    private final /* synthetic */ String val$title;
    private final /* synthetic */ String val$album;
    private final /* synthetic */ String val$artist;
    private final /* synthetic */ ResourceLocator val$onlineCoverart;
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$5(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string, long l, String string2, String string3, String string4, ResourceLocator resourceLocator) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        this.val$trackID = l;
        this.val$title = string2;
        this.val$album = string3;
        this.val$artist = string4;
        this.val$onlineCoverart = resourceLocator;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.onUpdatePlayingTrack] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).updatePlayingTrack(this.val$trackID, this.val$title, this.val$album, this.val$artist, this.val$onlineCoverart);
    }
}

