/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.IPlayerListener;
import de.audi.app.media.content.media.IPlayerTrackListener;
import de.audi.app.media.content.media.MediaDetailInfo;
import de.audi.app.media.content.media.NullPlayer;
import de.audi.app.media.content.media.PlayTime;
import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.util.CopyOnWriteArrayList;
import de.audi.atip.log.LogChannel;
import java.util.Iterator;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.media.Capabilities;

public class OnlineMediaPlayerAdapterImpl
extends NullPlayer {
    private static final String LOGCLASS = "OnlineMediaPlayerAdapterImpl";
    private final LogChannel logger;
    private final IOnlinePlayer player;
    private final CopyOnWriteArrayList trackListeners;
    private final CopyOnWriteArrayList playerListeners;
    private volatile MediaDetailInfo currentDetailInfo;
    private static final MediaDetailInfo INVALID_DETAILINFO = new MediaDetailInfo();
    private volatile PlayTime currentPlaytime;
    private volatile ResourceLocator onlineCoverart;

    public OnlineMediaPlayerAdapterImpl(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        this.logger = logChannel;
        this.player = iOnlinePlayer;
        this.trackListeners = new CopyOnWriteArrayList();
        this.playerListeners = new CopyOnWriteArrayList();
    }

    public void activate() {
        this.logger.log(1000000, "[%1.activate]", (Object)LOGCLASS);
        this.currentDetailInfo = INVALID_DETAILINFO;
        this.currentPlaytime = null;
    }

    public void deactivate() {
        this.logger.log(1000000, "[%1.deactivate]", (Object)LOGCLASS);
        this.trackListeners.clear();
        this.playerListeners.clear();
    }

    public void updateDetailInfo(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(100000000, "[%1.updateDetailInfo]", (Object)LOGCLASS);
        this.currentDetailInfo = mediaDetailInfo;
        this.notifyDetailInfo();
    }

    public void updateCoverart(ResourceLocator resourceLocator) {
        this.logger.log(100000000, "[%1.updateCoverart]", (Object)LOGCLASS);
        this.onlineCoverart = resourceLocator;
        this.notifyCoverArt();
    }

    public void updatePlayPosition(long l, PlayTime playTime) {
        boolean bl = this.currentDetailInfo == null || l != this.currentDetailInfo.getEntryID();
        this.currentPlaytime = playTime;
        if (bl) {
            this.logger.log(10000000, "[%1.updatePlayPosition] New track ('%2') with play position: %3", (Object)LOGCLASS, (Object)String.valueOf(l), (Object)playTime);
        }
        this.notifyUpdatePlayPosition(bl, playTime);
    }

    public void playbackModeChanged(int n, boolean bl) {
        this.logger.log(1000000, "[%1.playbackModeChanged]", (Object)LOGCLASS);
        this.notifyPlaybackModeChanged(n, bl);
    }

    public void playbackStateChanged(int n) {
        this.notifyPlaybackStateChanged(n);
    }

    public void capabilitiesChanged(Capabilities capabilities) {
        this.notifyCapabilitesChanged(capabilities);
    }

    private void notifyCoverArt() {
        Iterator iterator = this.trackListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).coverArtChanged(this.onlineCoverart);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyCoverArt]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyDetailInfo() {
        Iterator iterator = this.trackListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).detailInfoChanged(this.currentDetailInfo);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyDetailInfo]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyUpdatePlayPosition(boolean bl, PlayTime playTime) {
        Iterator iterator = this.trackListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerTrackListener)iterator.next()).trackChanged(bl, false, this.currentDetailInfo.getPlayingTrack(), playTime);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.updatePlayPosition]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyPlaybackModeChanged(int n, boolean bl) {
        Iterator iterator = this.playerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).repeatScopeChanged(n, bl);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyPlaybackModeChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyPlaybackStateChanged(int n) {
        Iterator iterator = this.playerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).playbackStateChanged(n);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyPlaybackStateChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    private void notifyCapabilitesChanged(Capabilities capabilities) {
        Iterator iterator = this.playerListeners.iterator();
        while (iterator.hasNext()) {
            try {
                ((IPlayerListener)iterator.next()).capabilitiesChanged(capabilities);
            }
            catch (Exception exception) {
                this.logger.log(100000, "[%1.notifyCapabilitesChanged]", (Object)LOGCLASS, (Throwable)exception);
            }
        }
    }

    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1000000, "[%1.addTrackListener] '%2'", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.trackListeners.add(iPlayerTrackListener);
        if (this.currentDetailInfo != INVALID_DETAILINFO) {
            iPlayerTrackListener.detailInfoChanged(this.currentDetailInfo);
        }
        if (null != this.currentPlaytime && this.currentDetailInfo.getEntryID() != -1L) {
            iPlayerTrackListener.trackChanged(true, false, this.currentDetailInfo.getPlayingTrack(), this.currentPlaytime);
        }
    }

    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1000000, "[%1.removeTrackListener] '%2'", (Object)LOGCLASS, (Object)iPlayerTrackListener);
        this.trackListeners.remove(iPlayerTrackListener);
    }

    public void addPlayerListener(IPlayerListener iPlayerListener) {
        this.logger.log(1000000, "[%1.addPlayerListener] '%2'", (Object)LOGCLASS, (Object)iPlayerListener);
        this.playerListeners.add(iPlayerListener);
    }

    public void removePlayerListener(IPlayerListener iPlayerListener) {
        this.logger.log(1000000, "[%1.removePlayerListener] '%2'", (Object)LOGCLASS, (Object)iPlayerListener);
        this.trackListeners.remove(iPlayerListener);
    }

    private OnlinePlayerSession getActiveSession() {
        OnlinePlayerSession onlinePlayerSession = this.player.getState().getActiveSession();
        if (onlinePlayerSession == null || onlinePlayerSession.getOnState() != 1) {
            this.logger.log(1000000, "[%1.getActiveSession] No session active.", (Object)LOGCLASS);
            return null;
        }
        return onlinePlayerSession;
    }

    public void pause() {
        this.logger.log(1000000, "[%1.pause]", (Object)LOGCLASS);
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        onlinePlayerSession.getSessionPlayer().pause();
    }

    public void resume() {
        this.logger.log(1000000, "[%1.resume]", (Object)LOGCLASS);
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        onlinePlayerSession.getSessionPlayer().resume();
    }

    public boolean isPlaying() {
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        return onlinePlayerSession.getState() == 2;
    }

    public boolean startSeek(boolean bl) {
        this.logger.log(1000000, "[%1.startSeek]", (Object)LOGCLASS);
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        if (!this.player.getState().isOnPlayback()) {
            this.logger.log(1000000, "[%1.startSeek] Not on playback.", (Object)LOGCLASS);
            return false;
        }
        if (!this.player.getState().isSeekSupported()) {
            this.logger.log(1000000, "[%1.startSeek] Not supported.", (Object)LOGCLASS);
            return false;
        }
        onlinePlayerSession.getSessionPlayer().seek(bl);
        return true;
    }

    public boolean stopSeek(boolean bl) {
        this.logger.log(1000000, "[%1.stopSeek]", (Object)LOGCLASS);
        this.resume();
        return true;
    }

    public boolean isSeeking() {
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        return onlinePlayerSession.getState() == 4;
    }

    public boolean skip(boolean bl, int n) {
        this.logger.log(1000000, "[%1.skip]", (Object)LOGCLASS);
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        onlinePlayerSession.updateSkipCount(bl, n);
        return this.player.skip(bl ? n : -n);
    }
}

