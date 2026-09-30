/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.AudioStream;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;
import org.dsi.ifc.media.ListEntry;
import org.dsi.ifc.media.PlaybackMode;

public interface DSIMediaPlayerReply {
    public static final String IPL_COMM_UUID = "0c182e4a-4267-577b-94ca-68dedb283139";
    public static final String IPL_COMM_INTERFACE_KEY = "22bc8a7b-fd79-5e25-aedc-0b80a7f97b2f";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateVideoFormat(int var1, int var2) throws MethodException;

    public void updateVideoNorm(int var1, int var2) throws MethodException;

    public void updateCmdBlockingMask(int var1, int var2) throws MethodException;

    public void updateNumVideoAngles(int var1, int var2) throws MethodException;

    public void updatePlaybackModeList(PlaybackMode[] var1, int var2) throws MethodException;

    public void updatePlaybackMode(int var1, int var2) throws MethodException;

    public void updatePlaybackState(int var1, int var2) throws MethodException;

    public void updateActiveMedia(long var1, long var3, int var5, int var6, int var7) throws MethodException;

    public void updatePlaybackFolder(ListEntry[] var1, int var2) throws MethodException;

    public void updateCapabilities(Capabilities var1, int var2) throws MethodException;

    public void updatePlayPosition(long var1, int var3, int var4, int var5) throws MethodException;

    public void updatePlayViewSize(int var1, int var2, int var3) throws MethodException;

    public void updateActiveVideoAngle(int var1, int var2) throws MethodException;

    public void updateAudioStreamList(AudioStream[] var1, int var2) throws MethodException;

    public void updateActiveAudioStream(int var1, int var2) throws MethodException;

    public void updateSubtitleList(int[] var1, int var2) throws MethodException;

    public void updateActiveSubtitle(int var1, int var2) throws MethodException;

    public void responseCmdBlocked(int var1) throws MethodException;

    public void responseRating(long var1, int var3) throws MethodException;

    public void responseFullyQualifiedName(long var1, String var3) throws MethodException;

    public void responseCoverArt(long var1, ResourceLocator var3) throws MethodException;

    public void responsePlayView(ListEntry[] var1, int var2, int var3, int var4) throws MethodException;

    public void responseDetailInfo(EntryInfo var1) throws MethodException;

    public void indicationDvdEvent(int var1) throws MethodException;

    public void responseSetPlaySelection(int var1, int var2) throws MethodException;

    public void responseSetPlaySelectionAB(int var1, boolean var2) throws MethodException;

    public void responseSetPlaybackURL(String var1) throws MethodException;

    public void responseSetVideoRect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) throws MethodException;

    public void responsePlaySimilarEntry(long var1, boolean var3) throws MethodException;

    public void tempPMLRequest(int var1) throws MethodException;

    public void updatePlaybackContentFolder(ListEntry[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

