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
import de.audi.app.media.content.media.NullPlayer$1;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.selection.ISelectionListener;
import de.audi.app.media.source.ISourceSlot;

public class NullPlayer
implements IPlayer {
    @Override
    public void init() {
    }

    @Override
    public void deinit() {
    }

    public ISourceSlot getActiveSlot() {
        return null;
    }

    @Override
    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    @Override
    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    @Override
    public void addPlayerListener(IPlayerListener iPlayerListener) {
    }

    @Override
    public void removePlayerListener(IPlayerListener iPlayerListener) {
    }

    @Override
    public boolean requestPlayViewListEntryBased(int n, long l, int n2) {
        return false;
    }

    @Override
    public boolean requestPlayViewListIndexBased(int n, int n2, int n3) {
        return false;
    }

    @Override
    public void discardPlayViewRequests(int n) {
    }

    @Override
    public void addViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    @Override
    public void removeViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    @Override
    public void setBrowserPlayerSelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
        iPlayerSelectionRequest.responseSetSelection(false);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void playEntry(long l) {
    }

    @Override
    public PlayingTrack getCurrentPlayingTrack() {
        return null;
    }

    @Override
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

    @Override
    public boolean supportsVideoPlayback() {
        return false;
    }

    public boolean supportsCoverflow() {
        return false;
    }

    @Override
    public boolean supportsDetailInfo() {
        return false;
    }

    @Override
    public boolean supportsTimeToSeek() {
        return false;
    }

    @Override
    public boolean supportsPlaytime() {
        return false;
    }

    public void requestDataFidForPlaylistEntryID(long l) {
    }

    @Override
    public void setPlayPosition(int n) {
    }

    @Override
    public boolean startSeek(boolean bl) {
        return false;
    }

    @Override
    public boolean stopSeek(boolean bl) {
        return false;
    }

    @Override
    public boolean skip(boolean bl, int n) {
        return false;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean supportsPlayListHandling() {
        return false;
    }

    @Override
    public boolean isPlaying() {
        return false;
    }

    @Override
    public boolean isReadyToPlay() {
        return false;
    }

    @Override
    public void touchEvent(int n, int n2, int n3) {
    }

    @Override
    public void executeMenuCommand(int n) {
    }

    @Override
    public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
    }

    @Override
    public boolean supportsPlayMoreOf() {
        return false;
    }

    @Override
    public IPlaybackModeHandler getPlaybackModeHandler() {
        return new NullPlayer$1(this);
    }

    @Override
    public boolean isPlayerStartupComplete() {
        return true;
    }

    @Override
    public boolean supportsExtendedPlayView() {
        return false;
    }

    @Override
    public boolean supportsPlaybackModeTakeOver() {
        return false;
    }

    @Override
    public boolean supportsPlaybackModeToggle() {
        return false;
    }
}

