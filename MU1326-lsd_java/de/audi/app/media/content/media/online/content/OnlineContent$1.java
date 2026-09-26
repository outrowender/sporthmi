/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.content.media.online.content.OnlineContent;
import de.audi.app.media.dsi.media.AbstractMediaPlayerListener;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.PlaybackMode;

class OnlineContent$1
extends AbstractMediaPlayerListener {
    private int previousPlaybackState;
    private final /* synthetic */ OnlineContent this$0;

    OnlineContent$1(OnlineContent onlineContent, LogChannel logChannel) {
        this.this$0 = onlineContent;
        super(logChannel);
    }

    @Override
    public String getLogClass() {
        return "OnlineContent";
    }

    @Override
    public void updateCapabilities(Capabilities capabilities) {
        OnlineContent.access$000(this.this$0).main().log(1078071040, "[%1.updateCapabilities]", (Object)"OnlineContent");
        OnlineContent.access$100(this.this$0).onCapabilitiesChanged(capabilities);
        OnlineContent.access$200(this.this$0).setPlayTimeCapabilities(capabilities.isTotalPlaytime(), capabilities.isPlayTime());
        OnlineContent.access$300(this.this$0).capabilitiesChanged(capabilities);
    }

    private final boolean isSeeking(int n) {
        return n == 8 || n == 9 || n == 6 || n == 7;
    }

    @Override
    public void updatePlaybackState(int n) {
        OnlineContent.access$400(this.this$0).main().log(1078071040, "[%1.updatePlaybackState] newState='%2', previousState='%3'", (Object)"OnlineContent", (long)n, (long)this.previousPlaybackState);
        this.updateSeekStateOnPlaybackState(n);
        this.previousPlaybackState = n;
        OnlineContent.access$500(this.this$0).setPlaybackState(n);
        OnlineContent.access$100(this.this$0).onPlaybackStateChanged();
        OnlineContent.access$600(this.this$0);
        OnlineContent.access$300(this.this$0).playbackStateChanged(n);
        if (n == 3 && this.this$0.getTerminal().getAudioManager().isMuted()) {
            this.this$0.getTerminal().getAudioManager().demute();
        }
    }

    private void updateSeekStateOnPlaybackState(int n) {
        if (this.isSeeking(this.previousPlaybackState) && !this.isSeeking(n)) {
            OnlineContent.access$700(this.this$0).stop();
        }
    }

    @Override
    public void updatePlayPosition(long l, int n, int n2) {
        OnlineContent.access$100(this.this$0).onUpdatePlayPosition(l, n, n2);
        OnlineContent.access$800(this.this$0).main().log(14808325, "[%1.updatePlayPosition] %2 (%3)", (Object)"OnlineContent", (long)n, (long)n2);
        PlayTime playTime = new PlayTime(n, n2);
        this.this$0.getState().setCurrentPlayTime(playTime);
        boolean bl = this.this$0.getState().getCurrentEntryId() != l;
        this.this$0.getState().setCurrentEntryId(l);
        OnlineContent.access$200(this.this$0).setPlayTime(playTime.getRestrictedPlayTimeStr(), playTime.getRemainTimeStr(), playTime.getProgress());
        OnlineContent.access$300(this.this$0).updatePlayPosition(l, playTime);
        if ((bl || OnlineContent.access$900(this.this$0)) && this.this$0.getState().getCapabilitites().detailInfos && OnlineContent.access$500(this.this$0).isOnPlayback() && OnlineContent.access$500(this.this$0).getPlaybackState() != 1) {
            OnlineContent.access$1000(this.this$0).main().log(14808325, "[%1.updatePlayPosition] request detail info %2", (Object)"OnlineContent", l);
            OnlineContent.access$902(this.this$0, false);
            OnlineContent.access$1100(this.this$0).requestDetailInfo(l);
            return;
        }
        if (bl) {
            OnlineContent.access$902(this.this$0, true);
        }
    }

    @Override
    public void responseSetPlaybackURL(String string) {
        OnlineContent.access$1200(this.this$0).main().log(1078071040, "[%1.responseSetPlaybackURL]", (Object)"OnlineContent");
        OnlineContent.access$100(this.this$0).onResponsePlaybackURL();
    }

    @Override
    public void responseDetailInfo(RequestParameterEntryID requestParameterEntryID, EntryInfo entryInfo) {
        OnlineContent.access$1300(this.this$0).main().log(1078071040, "[%1.responseDetailInfo]", (Object)"OnlineContent");
        OnlineContent.access$100(this.this$0).onResponseDetailInfo(entryInfo);
        MediaDetailInfo mediaDetailInfo = new MediaDetailInfo(entryInfo, new PlayingTrack(this.this$0.getState().getCurrentEntryId(), PlayingTrack.EMPTY_PLAYBACK_FOLDER));
        OnlineContent.access$200(this.this$0).setTitleData(mediaDetailInfo.getTitle().getI18NString(), mediaDetailInfo.getAlbum().getI18NString(), mediaDetailInfo.getArtist().getI18NString());
        OnlineContent.access$300(this.this$0).updateDetailInfo(mediaDetailInfo);
        OnlineContent.access$100(this.this$0).onBufferStateChanged();
    }

    @Override
    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
        OnlineContent.access$1400(this.this$0).main().log(1078071040, "[%1.updatePlaybackModeList]", (Object)"OnlineContent");
        OnlineContent.access$500(this.this$0).setPlaybackModes(playbackModeArray);
    }

    @Override
    public void updatePlaybackMode(int n) {
        OnlineContent.access$1500(this.this$0).main().log(1078071040, "[%1.updatePlaybackMode] mode=%2", (Object)"OnlineContent", (Object)new Integer(n));
        OnlineContent.access$500(this.this$0).setPlaybackMode(n);
        OnlineContent.access$100(this.this$0).onUpdatePlaybackMode();
    }

    @Override
    public void error(int n) {
        OnlineContent.access$1600(this.this$0).main().log(1078071040, "[%1.error] '%2'", (Object)"OnlineContent", (long)n);
        OnlineContent.access$100(this.this$0).onPlayerError(n);
    }
}

