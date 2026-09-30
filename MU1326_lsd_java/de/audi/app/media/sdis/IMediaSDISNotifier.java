/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.sdis;

import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.source.ActiveSourceState;
import java.util.Map;
import org.dsi.ifc.media.Capabilities;

public interface IMediaSDISNotifier {
    public void updateSourceList(Map var1);

    public void updateActiveSourceState(ActiveSourceState var1);

    public void updatePlaybackState(int var1);

    public void updatePlayingPosition(PlayingTrack var1, PlayTime var2);

    public void updatePlayingTrack(MediaDetailInfo var1, String var2);

    public void updateMix(boolean var1);

    public void updateRepeatTitle(boolean var1);

    public void updateRepeatMode(int var1);

    public void updatePlayListState(boolean var1, long var2, int var4, int var5);

    public void updatePlayListInvalidState();

    public void updatePlaybackPossible(boolean var1);

    public void updatePlayerCapabilities(Capabilities var1);

    public void enableTemporalChildLock(boolean var1);
}

