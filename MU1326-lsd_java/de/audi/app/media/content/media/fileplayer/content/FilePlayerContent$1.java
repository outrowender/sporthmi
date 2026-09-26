/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.FilePlayerContent;
import de.audi.app.media.dsi.media.AbstractMediaPlayerListener;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.PlaybackMode;

class FilePlayerContent$1
extends AbstractMediaPlayerListener {
    private final /* synthetic */ FilePlayerContent this$0;

    FilePlayerContent$1(FilePlayerContent filePlayerContent, LogChannel logChannel) {
        this.this$0 = filePlayerContent;
        super(logChannel);
    }

    @Override
    public String getLogClass() {
        return "FilePlayerContent";
    }

    @Override
    public void updateCapabilities(Capabilities capabilities) {
        FilePlayerContent.access$000(this.this$0).main().log(1078071040, "[%1.updateCapabilities]", (Object)"FilePlayerContent");
        FilePlayerContent.access$100(this.this$0).setCapabilities(capabilities);
        FilePlayerContent.access$200(this.this$0).onCapabilitiesChanged();
    }

    @Override
    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
        int n = -1;
        int n2 = -1;
        for (int i2 = 0; i2 < playbackModeArray.length; ++i2) {
            PlaybackMode playbackMode = playbackModeArray[i2];
            if (playbackMode.getScope() != 1) continue;
            if ((playbackMode.getModeFlag() & 1) == 1) {
                n2 = playbackMode.getModeID();
                continue;
            }
            n = playbackMode.getModeID();
        }
        FilePlayerContent.access$300(this.this$0).main().log(1078071040, "[%1.updatePlaybackModeList] normalMode='%2',repeatMode='%3'", (Object)"FilePlayerContent", (long)n, (long)n2);
        FilePlayerContent.access$100(this.this$0).setPlaymodes(n, n2);
        FilePlayerContent.access$200(this.this$0).onPlaybackModeListChanged();
    }

    @Override
    public void updatePlaybackMode(int n) {
        FilePlayerContent.access$400(this.this$0).main().log(1078071040, "[%1.updatePlaybackMode] '%2'", (Object)"FilePlayerContent", (long)n);
        FilePlayerContent.access$100(this.this$0).setPlaybackMode(n);
        FilePlayerContent.access$200(this.this$0).onPlaybackModeChanged();
    }

    @Override
    public void updatePlaybackState(int n) {
        FilePlayerContent.access$500(this.this$0).main().log(1078071040, "[%1.updatePlaybackState]", (Object)"FilePlayerContent");
        FilePlayerContent.access$100(this.this$0).setPlaybackState(n);
        FilePlayerContent.access$200(this.this$0).onPlaybackStateChanged();
    }

    @Override
    public void updatePlayPosition(long l, int n, int n2) {
        FilePlayerContent.access$200(this.this$0).onUpdatePlayPosition(n, n2);
    }

    @Override
    public void responseSetPlaybackURL(String string) {
        FilePlayerContent.access$600(this.this$0).main().log(1078071040, "[%1.responseSetPlaybackURL]", (Object)"FilePlayerContent");
        FilePlayerContent.access$200(this.this$0).onResponsePlaybackURL();
    }

    @Override
    public void error(int n) {
        FilePlayerContent.access$700(this.this$0).main().log(1078071040, "[%1.error] '%2'", (Object)"FilePlayerContent", (long)n);
        FilePlayerContent.access$200(this.this$0).onPlayerError(n);
    }
}

