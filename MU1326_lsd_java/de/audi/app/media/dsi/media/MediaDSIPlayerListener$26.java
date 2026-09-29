/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.AbstractDispatcherRunnable;
import de.audi.app.media.dsi.media.MediaDSIPlayerListener;
import de.audi.app.media.logger.LogUtil;
import org.dsi.ifc.media.PlaybackMode;

class MediaDSIPlayerListener$26
extends AbstractDispatcherRunnable {
    private final /* synthetic */ PlaybackMode[] val$playbackModeList;
    private final /* synthetic */ MediaDSIPlayerListener this$0;

    MediaDSIPlayerListener$26(MediaDSIPlayerListener mediaDSIPlayerListener, String string, PlaybackMode[] playbackModeArray) {
        this.this$0 = mediaDSIPlayerListener;
        this.val$playbackModeList = playbackModeArray;
        super(string);
    }

    @Override
    public void run() {
        if (this.val$playbackModeList == null) {
            MediaDSIPlayerListener.access$5700(this.this$0).log(-1601830656, "[%1.updatePlaybackModeList] [%2] Playback mode list is null. Ignore.", (Object)"MediaDSIPlayerListener", (long)MediaDSIPlayerListener.access$000(this.this$0).getInstanceID());
            return;
        }
        if (MediaDSIPlayerListener.access$5800(this.this$0).isInfo()) {
            LogUtil.logPlaybackModeList(MediaDSIPlayerListener.access$5900(this.this$0), new StringBuffer().append("[MediaDSIPlayerListener.updatePlaybackModeList] [").append(MediaDSIPlayerListener.access$000(this.this$0).getInstanceID()).append("]").toString(), this.val$playbackModeList);
        }
        MediaDSIPlayerListener.access$000(this.this$0).getPlayerListener().updatePlaybackModeList(this.val$playbackModeList);
    }
}

