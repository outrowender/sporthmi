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
    public static final int REPEAT_SCOPE_UNDEFINED = -1;
    public static final int REPEAT_SCOPE_DEVICE = 0;
    public static final int REPEAT_SCOPE_MEDIA = 1;
    public static final int REPEAT_SCOPE_SUBFOLDER = 2;
    public static final int REPEAT_SCOPE_TRACK = 3;
    public static final int REPEAT_SCOPE_SELECTION = 4;
    public static final int REPEAT_MODE_OFF = 0;
    public static final int REPEAT_MODE_TITLE = 1;
    public static final int REPEAT_MODE_LIST = 2;
    public static final int MIXMODE_OFF = 0;
    public static final int MIXMODE_ON = 1;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_MAIN = 1;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_MAIN_FASTSCROLL = 2;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_COMBI = 3;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_COMBI_FASTSCROLL = 4;
    public static final int PLAYVIEW_LIST_REQUEST_CLIENTID_SDIS = 5;
    public static final int PLAYBACKSTATE_UNDEFINED = 0;
    public static final int PLAYBACKSTATE_PLAYING = 1;
    public static final int PLAYBACKSTATE_PAUSED = 2;
    public static final int PLAYBACKSTATE_SEEK_FORWARD = 3;
    public static final int PLAYBACKSTATE_SEEK_BACKWARD = 4;
    public static final int PLAYBACKSTATE_PLAYING_MENU = 5;
    public static final int PLAYBACKSTATE_STOPPED = 6;
    public static final int TOUCH_EVENT_CLICK = 0;
    public static final int TOUCH_EVENT_CLICK_AND_ACTIVATE = 1;

    public void init();

    public void deinit();

    public boolean isActive();

    public void addTrackListener(IPlayerTrackListener var1);

    public void removeTrackListener(IPlayerTrackListener var1);

    public void addPlayerListener(IPlayerListener var1);

    public void removePlayerListener(IPlayerListener var1);

    public boolean requestPlayViewListEntryBased(int var1, long var2, int var4);

    public boolean requestPlayViewListIndexBased(int var1, int var2, int var3);

    public void discardPlayViewRequests(int var1);

    public void addViewListener(IPlayerViewListener var1);

    public void removeViewListener(IPlayerViewListener var1);

    public void setBrowserPlayerSelection(IPlayerSelectionRequest var1);

    public void pause();

    public void resume();

    public boolean isPlaying();

    public boolean isReadyToPlay();

    public void playEntry(long var1);

    public void playMoreOf(long var1, int var3, ISelectionListener var4);

    public PlayingTrack getCurrentPlayingTrack();

    public boolean startSeek(boolean var1);

    public boolean stopSeek(boolean var1);

    public boolean isSeeking();

    public boolean supportsExtendedPlayView();

    public boolean skip(boolean var1, int var2);

    public IPlaybackModeHandler getPlaybackModeHandler();

    public void setPlayPosition(int var1);

    public void touchEvent(int var1, int var2, int var3);

    public void executeMenuCommand(int var1);

    public boolean supportsVideoPlayback();

    public boolean supportsPlayListHandling();

    public boolean supportsDetailInfo();

    public boolean supportsTimeToSeek();

    public boolean supportsPlaytime();

    public boolean supportsPlayMoreOf();

    public boolean supportsPlaybackModeTakeOver();

    public boolean supportsPlaybackModeToggle();

    public boolean isPlayerStartupComplete();
}

