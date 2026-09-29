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
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final IOnlinePlayer player;
    private final CopyOnWriteArrayList trackListeners;
    private final CopyOnWriteArrayList playerListeners;
    private volatile MediaDetailInfo currentDetailInfo;
    private static final MediaDetailInfo INVALID_DETAILINFO;
    private volatile PlayTime currentPlaytime;
    private volatile ResourceLocator onlineCoverart;

    public OnlineMediaPlayerAdapterImpl(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        this.logger = logChannel;
        this.player = iOnlinePlayer;
        this.trackListeners = new CopyOnWriteArrayList();
        this.playerListeners = new CopyOnWriteArrayList();
    }

    public void activate() {
        this.logger.log(1078071040, "[%1.activate]", (Object)"OnlineMediaPlayerAdapterImpl");
        this.currentDetailInfo = INVALID_DETAILINFO;
        this.currentPlaytime = null;
    }

    public void deactivate() {
        this.logger.log(1078071040, "[%1.deactivate]", (Object)"OnlineMediaPlayerAdapterImpl");
        this.trackListeners.clear();
        this.playerListeners.clear();
    }

    public void updateDetailInfo(MediaDetailInfo mediaDetailInfo) {
        this.logger.log(14808325, "[%1.updateDetailInfo]", (Object)"OnlineMediaPlayerAdapterImpl");
        this.currentDetailInfo = mediaDetailInfo;
        this.notifyDetailInfo();
    }

    public void updateCoverart(ResourceLocator resourceLocator) {
        this.logger.log(14808325, "[%1.updateCoverart]", (Object)"OnlineMediaPlayerAdapterImpl");
        this.onlineCoverart = resourceLocator;
        this.notifyCoverArt();
    }

    public void updatePlayPosition(long l, PlayTime playTime) {
        boolean bl = this.currentDetailInfo == null || l != this.currentDetailInfo.getEntryID();
        this.currentPlaytime = playTime;
        if (bl) {
            this.logger.log(-2137614336, "[%1.updatePlayPosition] New track ('%2') with play position: %3", (Object)"OnlineMediaPlayerAdapterImpl", (Object)String.valueOf(l), (Object)playTime);
        }
        this.notifyUpdatePlayPosition(bl, playTime);
    }

    public void playbackModeChanged(int n, boolean bl) {
        this.logger.log(1078071040, "[%1.playbackModeChanged]", (Object)"OnlineMediaPlayerAdapterImpl");
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
                this.logger.log(-1601830656, "[%1.notifyCoverArt]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
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
                this.logger.log(-1601830656, "[%1.notifyDetailInfo]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
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
                this.logger.log(-1601830656, "[%1.updatePlayPosition]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
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
                this.logger.log(-1601830656, "[%1.notifyPlaybackModeChanged]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
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
                this.logger.log(-1601830656, "[%1.notifyPlaybackStateChanged]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
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
                this.logger.log(-1601830656, "[%1.notifyCapabilitesChanged]", (Object)"OnlineMediaPlayerAdapterImpl", (Throwable)exception);
            }
        }
    }

    @Override
    public void addTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1078071040, "[%1.addTrackListener] '%2'", (Object)"OnlineMediaPlayerAdapterImpl", (Object)iPlayerTrackListener);
        this.trackListeners.add(iPlayerTrackListener);
        if (this.currentDetailInfo != INVALID_DETAILINFO) {
            iPlayerTrackListener.detailInfoChanged(this.currentDetailInfo);
        }
        if (null != this.currentPlaytime && this.currentDetailInfo.getEntryID() != -1L) {
            iPlayerTrackListener.trackChanged(true, false, this.currentDetailInfo.getPlayingTrack(), this.currentPlaytime);
        }
    }

    @Override
    public void removeTrackListener(IPlayerTrackListener iPlayerTrackListener) {
        this.logger.log(1078071040, "[%1.removeTrackListener] '%2'", (Object)"OnlineMediaPlayerAdapterImpl", (Object)iPlayerTrackListener);
        this.trackListeners.remove(iPlayerTrackListener);
    }

    @Override
    public void addPlayerListener(IPlayerListener iPlayerListener) {
        this.logger.log(1078071040, "[%1.addPlayerListener] '%2'", (Object)"OnlineMediaPlayerAdapterImpl", (Object)iPlayerListener);
        this.playerListeners.add(iPlayerListener);
    }

    @Override
    public void removePlayerListener(IPlayerListener iPlayerListener) {
        this.logger.log(1078071040, "[%1.removePlayerListener] '%2'", (Object)"OnlineMediaPlayerAdapterImpl", (Object)iPlayerListener);
        this.trackListeners.remove(iPlayerListener);
    }

    private OnlinePlayerSession getActiveSession() {
        OnlinePlayerSession onlinePlayerSession = this.player.getState().getActiveSession();
        if (onlinePlayerSession == null || onlinePlayerSession.getOnState() != 1) {
            this.logger.log(1078071040, "[%1.getActiveSession] No session active.", (Object)"OnlineMediaPlayerAdapterImpl");
            return null;
        }
        return onlinePlayerSession;
    }

    @Override
    public void pause() {
        this.logger.log(1078071040, "[%1.pause]", (Object)"OnlineMediaPlayerAdapterImpl");
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        onlinePlayerSession.getSessionPlayer().pause();
    }

    @Override
    public void resume() {
        this.logger.log(1078071040, "[%1.resume]", (Object)"OnlineMediaPlayerAdapterImpl");
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        onlinePlayerSession.getSessionPlayer().resume();
    }

    @Override
    public boolean isPlaying() {
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        return onlinePlayerSession.getState() == 2;
    }

    @Override
    public boolean startSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.startSeek]", (Object)"OnlineMediaPlayerAdapterImpl");
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        if (!this.player.getState().isOnPlayback()) {
            this.logger.log(1078071040, "[%1.startSeek] Not on playback.", (Object)"OnlineMediaPlayerAdapterImpl");
            return false;
        }
        if (!this.player.getState().isSeekSupported()) {
            this.logger.log(1078071040, "[%1.startSeek] Not supported.", (Object)"OnlineMediaPlayerAdapterImpl");
            return false;
        }
        onlinePlayerSession.getSessionPlayer().seek(bl);
        return true;
    }

    @Override
    public boolean stopSeek(boolean bl) {
        this.logger.log(1078071040, "[%1.stopSeek]", (Object)"OnlineMediaPlayerAdapterImpl");
        this.resume();
        return true;
    }

    @Override
    public boolean isSeeking() {
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        return onlinePlayerSession.getState() == 4;
    }

    @Override
    public boolean skip(boolean bl, int n) {
        this.logger.log(1078071040, "[%1.skip]", (Object)"OnlineMediaPlayerAdapterImpl");
        OnlinePlayerSession onlinePlayerSession = this.getActiveSession();
        if (onlinePlayerSession == null) {
            return false;
        }
        onlinePlayerSession.updateSkipCount(bl, n);
        return this.player.skip(bl ? n : -n);
    }

    static {
        INVALID_DETAILINFO = new MediaDetailInfo();
    }
}

