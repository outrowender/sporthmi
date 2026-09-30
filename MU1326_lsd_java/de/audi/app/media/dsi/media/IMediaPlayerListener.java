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
    public void indicationDvdEvent(int var1);

    public void responseCmdBlocked(int var1);

    public void responseCoverArtURL(RequestParameterEntryID var1, long var2, ResourceLocator var4);

    public void responseDetailInfo(RequestParameterEntryID var1, EntryInfo var2);

    public void responsePlayView(RequestParameterList var1, MediaListEntry[] var2, int var3, int var4);

    public void updatePlayViewSize(int var1, int var2);

    public void playViewSizeInvalidated();

    public void responseFullyQualifiedName(long var1, String var3);

    public void responsePlaySimilarEntry(long var1, boolean var3);

    public void responseSetPlaySelection(int var1, boolean var2);

    public void responseSetPlaySelectionCoverflow(int var1, boolean var2);

    public void responseTempPMLRequest(int var1);

    public void updateActiveAudioStream(int var1);

    public void updateActiveSubtitle(int var1);

    public void updateActiveVideoAngle(int var1);

    public void updateAudioStreamList(AudioStream[] var1);

    public void updateCapabilities(Capabilities var1);

    public void updateCmdBlockingMask(int var1);

    public void updateNumVideoAngles(int var1);

    public void updatePlayPosition(long var1, int var3, int var4);

    public void playPositionInvalidated();

    public void responseSetPlaybackURL(String var1);

    public void updatePlaybackFolder(MediaListEntry[] var1);

    public void updatePlaybackMode(int var1);

    public void updatePlaybackModeList(PlaybackMode[] var1);

    public void updatePlaybackState(int var1);

    public void updateSubtitleList(int[] var1);

    public void updateVideoFormat(int var1);

    public void updateVideoNorm(int var1);

    public void responseFidForPlaylistEntryID(long var1, long var3);

    public void errorPlayViewListRequestAborted(int var1);

    public void error(int var1);
}

