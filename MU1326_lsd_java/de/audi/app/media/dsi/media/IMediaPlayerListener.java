/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.dsi.media;

import de.audi.app.media.dsi.media.MediaListEntry;
import de.audi.app.media.dsi.media.requests.RequestParameterEntryID;
import de.audi.app.media.dsi.media.requests.RequestParameterList;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.PlaybackMode;

public interface IMediaPlayerListener {
    default public void indicationDvdEvent(int n) {
    }

    default public void responseCmdBlocked(int n) {
    }

    default public void responseCoverArtURL(RequestParameterEntryID requestParameterEntryID, long l, ResourceLocator resourceLocator) {
    }

    default public void responseDetailInfo(RequestParameterEntryID requestParameterEntryID, EntryInfo entryInfo) {
    }

    default public void responsePlayView(RequestParameterList requestParameterList, MediaListEntry[] mediaListEntryArray, int n, int n2) {
    }

    default public void updatePlayViewSize(int n, int n2) {
    }

    default public void playViewSizeInvalidated() {
    }

    default public void responseFullyQualifiedName(long l, String string) {
    }

    default public void responsePlaySimilarEntry(long l, boolean bl) {
    }

    default public void responseSetPlaySelection(int n, boolean bl) {
    }

    default public void responseSetPlaySelectionCoverflow(int n, boolean bl) {
    }

    default public void responseTempPMLRequest(int n) {
    }

    default public void updateActiveAudioStream(int n) {
    }

    default public void updateActiveSubtitle(int n) {
    }

    default public void updateActiveVideoAngle(int n) {
    }

    default public void updateAudioStreamList(AudioStream[] audioStreamArray) {
    }

    default public void updateCapabilities(Capabilities capabilities) {
    }

    default public void updateCmdBlockingMask(int n) {
    }

    default public void updateNumVideoAngles(int n) {
    }

    default public void updatePlayPosition(long l, int n, int n2) {
    }

    default public void playPositionInvalidated() {
    }

    default public void responseSetPlaybackURL(String string) {
    }

    default public void updatePlaybackFolder(MediaListEntry[] mediaListEntryArray) {
    }

    default public void updatePlaybackMode(int n) {
    }

    default public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
    }

    default public void updatePlaybackState(int n) {
    }

    default public void updateSubtitleList(int[] nArray) {
    }

    default public void updateVideoFormat(int n) {
    }

    default public void updateVideoNorm(int n) {
    }

    default public void responseFidForPlaylistEntryID(long l, long l2) {
    }

    default public void errorPlayViewListRequestAborted(int n) {
    }

    default public void error(int n) {
    }
}

