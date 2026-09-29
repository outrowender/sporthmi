/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaDSIPlayerListener;

class MediaDSIPlayerListener$32
implements Runnable {
    private final /* synthetic */ long val$playlistEntryID;
    private final /* synthetic */ long val$fid;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$32(MediaDSIPlayerListener mediaDSIPlayerListener, long l, long l2) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$playlistEntryID = l;
        this.val$fid = l2;
    }

    @Override
    public void run() {
        MediaDSIPlayerListener.access$7400(this.this$0).log(1078071040, "[%1.responseFidForPlaylistEntryID] playlistEntryID='%2', entryID='%3'.", (Object)"MediaDSIPlayerListener", this.val$playlistEntryID, this.val$fid);
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().responseFidForPlaylistEntryID(this.val$playlistEntryID, this.val$fid);
    }
}

