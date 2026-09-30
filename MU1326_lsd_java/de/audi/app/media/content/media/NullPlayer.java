/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlaybackModeHandler;
import de.audi.app.media.content.media.IPlayer;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.IActivationContext;
import de.audi.app.media.source.ISourceSlot;
import org.dsi.ifc.media.PlaybackMode;

public class NullPlayer
implements IPlayer {
    public void init() {
    }

    public void deinit() {
    }

    public ISourceSlot getActiveSlot() {
        return null;
    }

    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    public void addPlayerListener(IPlayerListener iPlayerListener) {
    }

    public void removePlayerListener(IPlayerListener iPlayerListener) {
    }

    public boolean requestPlayViewListEntryBased(int n, long l, int n2) {
        return false;
    }

    public boolean requestPlayViewListIndexBased(int n, int n2, int n3) {
        return false;
    }

    public void discardPlayViewRequests(int n) {
    }

    public void addViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    public void removeViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    public void setBrowserPlayerSelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        iPlayerSelectionRequest.responseSetSelection(false);
    }

    public void pause() {
    }

    public void resume() {
    }

    public void playEntry(long l) {
    }

    public PlayingTrack getCurrentPlayingTrack() {
        return null;
    }

    public boolean isSeeking() {
        return false;
    }

    public boolean setRepeatScope(int n, boolean bl) {
        return false;
    }

    public boolean isMixing() {
        return false;
    }

    public int getRepeatScope() {
        return 0;
    }

    public boolean supportsVideoPlayback() {
        return false;
    }

    public boolean supportsCoverflow() {
        return false;
    }

    public boolean supportsDetailInfo() {
        return false;
    }

    public boolean supportsTimeToSeek() {
        return false;
    }

    public boolean supportsPlaytime() {
        return false;
    }

    public void requestDataFidForPlaylistEntryID(long l) {
    }

    public void setPlayPosition(int n) {
    }

    public boolean startSeek(boolean bl) {
        return false;
    }

    public boolean stopSeek(boolean bl) {
        return false;
    }

    public boolean skip(boolean bl, int n) {
        return false;
    }

    public boolean isActive() {
        return false;
    }

    public boolean supportsPlayListHandling() {
        return false;
    }

    public boolean isPlaying() {
        return false;
    }

    public boolean isReadyToPlay() {
        return false;
    }

    public void touchEvent(int n, int n2, int n3) {
    }

    public void executeMenuCommand(int n) {
    }

    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
    }

    public boolean supportsPlayMoreOf() {
        return false;
    }

    public IPlaybackModeHandler getPlaybackModeHandler() {
        return new IPlaybackModeHandler(){

            public void updatePlaymodesAvailable(boolean bl) {
            }

            public void updatePlaybackModeList(PlaybackMode[] playbackModeArray) {
            }

            public void updateActivePlaybackMode(int n) {
            }

            public void trackChanged() {
            }

            public int setRepeatTitle(boolean bl) {
                return 0;
            }

            public int setRepeatScope(int n, boolean bl) {
                return 0;
            }

            public boolean sendCurrentPlaybackMode() {
                return false;
            }

            public void resetPlaybackMode() {
            }

            public boolean isRepeatTrack() {
                return false;
            }

            public boolean isRepeatSelection() {
                return false;
            }

            public boolean isRepeatMedium() {
                return false;
            }

            public boolean isRepeatDevice() {
                return false;
            }

            public boolean isMix() {
                return false;
            }

            public int getActiveRepeatScope() {
                return 0;
            }

            public void deactivate() {
            }

            public void activate(IActivationContext iActivationContext) {
            }

            public boolean isRepeatOff() {
                return false;
            }

            public void sendRepeatPlayview() {
            }

            public void toggleRepeatMode() {
            }

            public void toggleMixMode() {
            }

            public void setResetRepeatTitleOnTrackChange(boolean bl) {
            }
        };
    }

    public boolean isPlayerStartupComplete() {
        return true;
    }

    public boolean supportsExtendedPlayView() {
        return false;
    }

    public boolean supportsPlaybackModeTakeOver() {
        return false;
    }

    public boolean supportsPlaybackModeToggle() {
        return false;
    }
}

