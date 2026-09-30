/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.IMediaPlayerListener;
import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.PlaybackMode;

public abstract class AbstractMediaPlayerListener
implements IMediaPlayerListener {
    private final LogChannel logger;

    public AbstractMediaPlayerListener(LogChannel logChannel) {
        this.logger = logChannel;
    }

    public abstract String getLogClass();

    public void indicationDvdEvent(int n) {
        this.logger.log(1000000, "[%1.indicationDvdEvent]", (Object)this.getLogClass());
    }

    public void responseCmdBlocked(int n) {
        this.logger.log(1000000, "[%1.responseCmdBlocked]", (Object)this.getLogClass());
    }

    public void responseFullyQualifiedName(long l, String string) {
        this.logger.log(1000000, "[%1.responseFullyQualifiedName]", (Object)this.getLogClass());
    }

    public void responsePlaySimilarEntry(long l, boolean bl) {
        this.logger.log(1000000, "[%1.responsePlaySimilarEntry]", (Object)this.getLogClass());
    }

    public void responseSetPlaySelection(int n, boolean bl) {
        this.logger.log(1000000, "[%1.responseSetPlaySelection]", (Object)this.getLogClass());
    }

    public void responseTempPMLRequest(int n) {
        this.logger.log(1000000, "[%1.responseTempPMLRequest]", (Object)this.getLogClass());
    }

    public void updateActiveAudioStream(int n) {
        this.logger.log(1000000, "[%1.updateActiveAudioStream]", (Object)this.getLogClass());
    }

    public void updateActiveSubtitle(int n) {
        this.logger.log(1000000, "[%1.updateActiveSubtitle]", (Object)this.getLogClass());
    }

    public void updateActiveVideoAngle(int n) {
        this.logger.log(1000000, "[%1.updateActiveVideoAngle]", (Object)this.getLogClass());
    }

    public void updateAudioStreamList(AudioStream[] audioStreamArray) {
        this.logger.log(1000000, "[%1.updateAudioStreamList]", (Object)this.getLogClass());
    }

    public void updateCapabilities(Capabilities capabilities) {
        this.logger.log(1000000, "[%1.updateCapabilities]", (Object)this.getLogClass());
    }

    public void updateCmdBlockingMask(int n) {
        this.logger.log(1000000, "[%1.updateCmdBlockingMask]", (Object)this.getLogClass());
    }

    public void updateNumVideoAngles(int n) {
        this.logger.log(1000000, "[%1.updateNumVideoAngles]", (Object)this.getLogClass());
    }

    public void updatePlayPosition(long l, int n, int n2) {
        this.logger.log(1000000, "[%1.updatePlayPosition]", (Object)this.getLogClass());
    }

    public void updatePlaybackFolder(MediaListEntry[] mediaListEntryArray) {
        this.logger.log(1000000, "[%1.updatePlaybackFolder]", (Object)this.getLogClass());
    }

    public void updatePlaybackMode(int n) {
        this.logger.log(1000000, "[%1.updatePlaybackMode]", (Object)this.getLogClass());
    }

    public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
        this.logger.log(1000000, "[%1.updatePlaybackModeList]", (Object)this.getLogClass());
    }

    public void updatePlaybackState(int n) {
        this.logger.log(1000000, "[%1.updatePlaybackState]", (Object)this.getLogClass());
    }

    public void updateSubtitleList(int[] nArray) {
        this.logger.log(1000000, "[%1.updateSubtitleList]", (Object)this.getLogClass());
    }

    public void updateVideoFormat(int n) {
        this.logger.log(1000000, "[%1.updateVideoFormat]", (Object)this.getLogClass());
    }

    public void updateVideoNorm(int n) {
        this.logger.log(1000000, "[%1.updateVideoNorm]", (Object)this.getLogClass());
    }

    public void responseCoverArtURL(RequestParameterEntryID requestParameterEntryID, long l, String string) {
        this.logger.log(1000000, "[%1.responseCoverArtURL]", (Object)this.getLogClass());
    }

    public void responseDetailInfo(RequestParameterEntryID requestParameterEntryID, EntryInfo entryInfo) {
        this.logger.log(1000000, "[%1.responseDetailInfo]", (Object)this.getLogClass());
    }

    public void responsePlayView(RequestParameterList requestParameterList, MediaListEntry[] mediaListEntryArray, int n) {
        this.logger.log(1000000, "[%1.responsePlayView]", (Object)this.getLogClass());
    }

    public void updatePlayViewSize(int n, int n2) {
        this.logger.log(1000000, "[%1.updatePlayViewSize]", (Object)this.getLogClass());
    }

    public void playViewSizeInvalidated() {
        this.logger.log(1000000, "[%1.playViewSizeInvalidated]", (Object)this.getLogClass());
    }

    public void errorPlayViewListRequestAborted(int n) {
        this.logger.log(1000000, "[%1.errorPlayViewListRequestAborted]", (Object)this.getLogClass());
    }

    public void playPositionInvalidated() {
        this.logger.log(1000000, "[%1.playPositionInvalidated]", (Object)this.getLogClass());
    }

    public void responsePlayView(RequestParameterList requestParameterList, MediaListEntry[] mediaListEntryArray, int n, int n2) {
        this.logger.log(1000000, "[%1.responsePlayView]", (Object)this.getLogClass());
    }

    public void responseSetPlaySelectionCoverflow(int n, boolean bl) {
        this.logger.log(1000000, "[%1.responseSetPlaySelectionCoverflow]", (Object)this.getLogClass());
    }

    public void responseCoverArtURL(RequestParameterEntryID requestParameterEntryID, long l, ResourceLocator resourceLocator) {
        this.logger.log(1000000, "[%1.responseCoverArtURL]", (Object)this.getLogClass());
    }

    public void responseSetPlaybackURL(String string) {
        this.logger.log(1000000, "[%1.responseSetPlaybackURL]", (Object)this.getLogClass());
    }

    public void responseFidForPlaylistEntryID(long l, long l2) {
        this.logger.log(1000000, "[%1.responseFidForPlaylistEntryID]", (Object)this.getLogClass());
    }

    public void error(int n) {
        this.logger.log(1000000, "[%1.error]", (Object)this.getLogClass());
    }
}

