/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.media;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public interface DSIMediaPlayerListener
extends DSIListener {
    public void updateVideoFormat(int var1, int var2);

    public void updateVideoNorm(int var1, int var2);

    public void updateCmdBlockingMask(int var1, int var2);

    public void updateNumVideoAngles(int var1, int var2);

    public void updatePlaybackModeList(PlaybackMode[] var1, int var2);

    public void updatePlaybackMode(int var1, int var2);

    public void updatePlaybackState(int var1, int var2);

    public void updateActiveMedia(long var1, long var3, int var5, int var6, int var7);

    public void updatePlaybackFolder(ListEntry[] var1, int var2);

    public void updateCapabilities(Capabilities var1, int var2);

    public void updatePlayPosition(long var1, int var3, int var4, int var5);

    public void updatePlayViewSize(int var1, int var2, int var3);

    public void updateActiveVideoAngle(int var1, int var2);

    public void updateAudioStreamList(AudioStream[] var1, int var2);

    public void updateActiveAudioStream(int var1, int var2);

    public void updateSubtitleList(int[] var1, int var2);

    public void updateActiveSubtitle(int var1, int var2);

    public void responseCmdBlocked(int var1);

    public void responseRating(long var1, int var3);

    public void responseFullyQualifiedName(long var1, String var3);

    public void responseCoverArt(long var1, ResourceLocator var3);

    public void responsePlayView(ListEntry[] var1, int var2, int var3, int var4);

    public void responseDetailInfo(EntryInfo var1);

    public void indicationDvdEvent(int var1);

    public void responseSetPlaySelection(int var1, int var2);

    public void responseSetPlaySelectionAB(int var1, boolean var2);

    public void responseSetPlaybackURL(String var1);

    public void responseSetVideoRect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

    public void responsePlaySimilarEntry(long var1, boolean var3);

    public void tempPMLRequest(int var1);

    public void updatePlaybackContentFolder(ListEntry[] var1, int var2);
}

