/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$21
extends AbstractDispatcherRunnable {
    private final /* synthetic */ long val$pEntryID;
    private final /* synthetic */ int val$timePosInSecs;
    private final /* synthetic */ int val$totalTimeInSecs;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$21(MediaDSIPlayerListener mediaDSIPlayerListener, String string, long l, int n, int n2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$pEntryID = l;
        this.val$timePosInSecs = n;
        this.val$totalTimeInSecs = n2;
        super(string);
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlayPosition(this.val$pEntryID, this.val$timePosInSecs, this.val$totalTimeInSecs);
    }
}

