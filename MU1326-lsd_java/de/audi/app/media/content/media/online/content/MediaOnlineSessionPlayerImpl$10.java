/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.content.media.online.content.MediaOnlineSessionPlayerImpl;
import org.dsi.ifc.global.ResourceLocator;

class MediaOnlineSessionPlayerImpl$10
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ResourceLocator val$pOnlineCoverart;
    private final /* synthetic */ MediaOnlineSessionPlayerImpl this$0;

    MediaOnlineSessionPlayerImpl$10(MediaOnlineSessionPlayerImpl mediaOnlineSessionPlayerImpl, String string, ResourceLocator resourceLocator) {
        this.this$0 = mediaOnlineSessionPlayerImpl;
        this.val$pOnlineCoverart = resourceLocator;
        super(string);
    }

    @Override
    public void run() {
        if (!MediaOnlineSessionPlayerImpl.access$100(this.this$0).equals(MediaOnlineSessionPlayerImpl.access$000(this.this$0).getState().getActiveSession())) {
            MediaOnlineSessionPlayerImpl.access$200(this.this$0).log(1078071040, "[%1.updateOnlineCoverart] [%2] Session not active.", (Object)"MediaOnlineSessionPlayerImpl", (Object)MediaOnlineSessionPlayerImpl.access$100(this.this$0));
            return;
        }
        MediaOnlineSessionPlayerImpl.access$000(this.this$0).updateOnlineCoverArt(this.val$pOnlineCoverart);
    }
}

