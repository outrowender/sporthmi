/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.ListEntry;

class MediaDSIPlayerListener$24
extends AbstractDispatcherRunnable {
    private final /* synthetic */ ListEntry[] val$activePlayingFolder;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$24(MediaDSIPlayerListener mediaDSIPlayerListener, String string, ListEntry[] listEntryArray) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$activePlayingFolder = listEntryArray;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$activePlayingFolder == null) {
            MediaDSIPlayerListener.access$5300(this.this$0).log(-1601830656, "[%1.updatePlaybackFolder] [%2] Playback folder is null. Ignore.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (MediaDSIPlayerListener.access$5400(this.this$0).isInfo()) {
            MediaDSIPlayerListener.access$5500(this.this$0).log(1078071040, "[%1.updatePlaybackFolder] [%2] '%3'.", (Object)"MediaDSIPlayerListener", (Object)new Integer(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()), (Object)LogUtil.listEntryToStr(this.val$activePlayingFolder));
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlaybackFolder(MediaListEntry.convert(this.val$activePlayingFolder));
    }
}

