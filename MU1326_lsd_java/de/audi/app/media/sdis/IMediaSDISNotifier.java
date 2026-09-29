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
    default public void updateSourceList(Map map) {
    }

    default public void updateActiveSourceState(ActiveSourceState activeSourceState) {
    }

    default public void updatePlaybackState(int n) {
    }

    default public void updatePlayingPosition(PlayingTrack playingTrack, PlayTime playTime) {
    }

    default public void updatePlayingTrack(MediaDetailInfo mediaDetailInfo, String string) {
    }

    default public void updateMix(boolean bl) {
    }

    default public void updateRepeatTitle(boolean bl) {
    }

    default public void updateRepeatMode(int n) {
    }

    default public void updatePlayListState(boolean bl, long l, int n, int n2) {
    }

    default public void updatePlayListInvalidState() {
    }

    default public void updatePlaybackPossible(boolean bl) {
    }

    default public void updatePlayerCapabilities(Capabilities capabilities) {
    }

    default public void enableTemporalChildLock(boolean bl) {
    }
}

