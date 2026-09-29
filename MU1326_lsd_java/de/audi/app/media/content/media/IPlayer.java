/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media;

import de.audi.app.media.content.media.IPlaybackModeHandler;
import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerSelectionRequest;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.IPlayerViewListener;
import de.audi.app.media.content.media.PlayingTrack;
import de.audi.app.media.selection.ISelectionListener;

public interface IPlayer {
    public static final int REPEAT_SCOPE_UNDEFINED;
    public static final int REPEAT_SCOPE_DEVICE;
    public static final int REPEAT_SCOPE_MEDIA;
    public static final int REPEAT_SCOPE_SUBFOLDER;
    public static final int REPEAT_SCOPE_TRACK;
    public static final int REPEAT_SCOPE_SELECTION;
    public static final int REPEAT_MODE_OFF;
    public static final int REPEAT_MODE_TITLE;
    public static final int REPEAT_MODE_LIST;
    public static final int MIXMODE_OFF;
    public static final int MIXMODE_ON;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_MAIN;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_MAIN_FASTSCROLL;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_COMBI;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_COMBI_FASTSCROLL;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_SDIS;
    public static final int PLAYBACKSTATE_UNDEFINED;
    public static final int PLAYBACKSTATE_PLAYING;
    public static final int PLAYBACKSTATE_PAUSED;
    public static final int PLAYBACKSTATE_SEEK_FORWARD;
    public static final int PLAYBACKSTATE_SEEK_BACKWARD;
    public static final int PLAYBACKSTATE_PLAYING_MENU;
    public static final int PLAYBACKSTATE_STOPPED;
    public static final int TOUCH_EVENT_CLICK;
    public static final int TOUCH_EVENT_CLICK_AND_ACTIVATE;

    default public void init() {
    }

    default public void deinit() {
    }

    default public boolean isActive() {
    }

    default public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    default public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
    }

    default public void addPlayerListener(IPlayerListener iPlayerListener) {
    }

    default public void removePlayerListener(IPlayerListener iPlayerListener) {
    }

    default public boolean requestPlayViewListEntryBased(int n, long l, int n2) {
    }

    default public boolean requestPlayViewListIndexBased(int n, int n2, int n3) {
    }

    default public void discardPlayViewRequests(int n) {
    }

    default public void addViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    default public void removeViewListener(IPlayerViewListener iPlayerViewListener) {
    }

    default public void setBrowserPlayerSelection(IPlayerSelectionRequest iPlayerSelectionRequest) {
    }

    default public void pause() {
    }

    default public void resume() {
    }

    default public boolean isPlaying() {
    }

    default public boolean isReadyToPlay() {
    }

    default public void playEntry(long l) {
    }

    default public void playMoreOf(long l, int n, ISelectionListener iSelectionListener) {
    }

    default public PlayingTrack getCurrentPlayingTrack() {
    }

    default public boolean startSeek(boolean bl) {
    }

    default public boolean stopSeek(boolean bl) {
    }

    default public boolean isSeeking() {
    }

    default public boolean supportsExtendedPlayView() {
    }

    default public boolean skip(boolean bl, int n) {
    }

    default public IPlaybackModeHandler getPlaybackModeHandler() {
    }

    default public void setPlayPosition(int n) {
    }

    default public void touchEvent(int n, int n2, int n3) {
    }

    default public void executeMenuCommand(int n) {
    }

    default public boolean supportsVideoPlayback() {
    }

    default public boolean supportsPlayListHandling() {
    }

    default public boolean supportsDetailInfo() {
    }

    default public boolean supportsTimeToSeek() {
    }

    default public boolean supportsPlaytime() {
    }

    default public boolean supportsPlayMoreOf() {
    }

    default public boolean supportsPlaybackModeTakeOver() {
    }

    default public boolean supportsPlaybackModeToggle() {
    }

    default public boolean isPlayerStartupComplete() {
    }
}

