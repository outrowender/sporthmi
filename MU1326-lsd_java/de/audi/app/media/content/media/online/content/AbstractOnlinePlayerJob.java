/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.OnlinePlayerSession;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.app.media.queue.AbstractQueueJob;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.Capabilities;
import org.dsi.ifc.media.EntryInfo;

public abstract class AbstractOnlinePlayerJob
extends AbstractQueueJob {
    protected final LogChannel logger;
    private final String name;
    private final IOnlinePlayer onlinePlayer;
    private static final String LOGCLASS;

    public AbstractOnlinePlayerJob(LogChannel logChannel, String string, IOnlinePlayer iOnlinePlayer) {
        this.logger = logChannel;
        this.name = string;
        this.onlinePlayer = iOnlinePlayer;
    }

    protected IOnlinePlayer getPlayer() {
        return this.onlinePlayer;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String toString() {
        return "";
    }

    @Override
    public int getType() {
        return 0;
    }

    @Override
    public void abort(boolean bl) {
    }

    protected void setSessionPlaybackState() {
        OnlinePlayerSession onlinePlayerSession = this.getPlayer().getState().getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 4: {
                onlinePlayerSession.updateState(5);
                break;
            }
            case 11: {
                onlinePlayerSession.updateState(6);
                break;
            }
            case 3: {
                onlinePlayerSession.updateState(2);
                break;
            }
            case 5: {
                onlinePlayerSession.updateState(3);
                break;
            }
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                onlinePlayerSession.updateState(4);
                break;
            }
        }
        this.updateVolumelockOnPlaybackState(this.getPlayer().getState().getPlaybackState(), this.getPlayer().getState().getBufferState());
    }

    private void updateVolumelockOnPlaybackState(int n, int n2) {
        boolean bl;
        if (n2 != 2) {
            this.logger.log(1078071040, "[%1.updateVolumelockOnPlaybackState] buffer not filled.", (Object)"AbstractOnlinePlayerJob");
            bl = false;
        } else {
            switch (n) {
                case 3: 
                case 5: 
                case 6: 
                case 7: 
                case 8: 
                case 9: 
                case 10: {
                    this.logger.log(1078071040, "[%1.updateVolumelockOnPlaybackState]  playbackState valid.", (Object)"AbstractOnlinePlayerJob");
                    bl = true;
                    break;
                }
                default: {
                    this.logger.log(1078071040, "[%1.updateVolumelockOnPlaybackState]  playbackState invalid.", (Object)"AbstractOnlinePlayerJob");
                    bl = false;
                }
            }
        }
        if (bl) {
            this.onlinePlayer.getAudioManager().releaseVolumelock("Player ready.");
        } else {
            this.onlinePlayer.getAudioManager().requestVolumelock(new StringBuffer().append("Player not ready (playbackState='").append(n).append("' bufferState='").append(n2).append("'").toString());
        }
    }

    public void onBufferStateChanged() {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        OnlinePlayerSession onlinePlayerSession = onlinePlayerState.getActiveSession();
        if (onlinePlayerSession == null) {
            this.logger.log(1078071040, "[%1.onBufferStateChanged] No active session.", (Object)"AbstractOnlinePlayerJob");
            return;
        }
        if (onlinePlayerSession.getOnState() != 1) {
            this.logger.log(1078071040, "[%1.onBufferStateChanged] Session not active.", (Object)"AbstractOnlinePlayerJob");
            return;
        }
        this.logger.log(1078071040, "[%1.onBufferStateChanged]", (Object)"AbstractOnlinePlayerJob");
        this.updateVolumelockOnPlaybackState(onlinePlayerState.getPlaybackState(), onlinePlayerState.getBufferState());
        onlinePlayerSession.updateBufferState(onlinePlayerState.getBufferState(), onlinePlayerState.getBufferFillInfoPrecent());
    }

    public void onPlaybackStateChanged() {
    }

    public void onCapabilitiesChanged(Capabilities capabilities) {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        onlinePlayerState.setCapabilities(capabilities);
        if (!capabilities.playbackModes) {
            onlinePlayerState.setPlaybackMode(-1);
            this.getPlayer().setHMIPlaybackMode();
        }
        if (onlinePlayerState.getActiveSession() != null) {
            onlinePlayerState.getActiveSession().updateCapabilities(onlinePlayerState.isSkipSupported(), onlinePlayerState.isSeekSupported(), onlinePlayerState.supportsPlaybackModes(), onlinePlayerState.supportsPlaybackModes(), onlinePlayerState.getCapabilitites().isPlayTime(), onlinePlayerState.getCapabilitites().isTotalPlaytime());
        }
    }

    public void onResponsePlaybackURL() {
    }

    public void onResponseDetailInfo(EntryInfo entryInfo) {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        if (onlinePlayerState.getActiveSession() != null) {
            if (entryInfo != null && entryInfo.getEntryID() == onlinePlayerState.getCurrentEntryId()) {
                onlinePlayerState.getActiveSession().responseDetailInfo(entryInfo.getFilename(), entryInfo.getTitle(), entryInfo.getAlbum(), entryInfo.getArtist());
            } else {
                this.logger.log(-2137614336, "[%1.onResponseDetailInfo] pEntryInfo %2; entryId %3", (Object)"AbstractOnlinePlayerJob", (Object)entryInfo, onlinePlayerState.getCurrentEntryId());
            }
        } else {
            this.logger.log(-2137614336, "[%1.onResponseDetailInfo] session is null.", (Object)"AbstractOnlinePlayerJob");
        }
    }

    public void onAudioStateChanged() {
    }

    public void onPlayerError(int n) {
    }

    public void onUpdatePlayPosition(long l, int n, int n2) {
        OnlinePlayerSession onlinePlayerSession = this.getPlayer().getState().getActiveSession();
        if (onlinePlayerSession == null) {
            return;
        }
        if (l != this.getPlayer().getState().getCurrentEntryId()) {
            onlinePlayerSession.trackChanged(l);
        }
        onlinePlayerSession.updatePlayPosition(n, n2);
    }

    public void onUpdatePlaybackMode() {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        boolean bl = onlinePlayerState.isRepeat();
        boolean bl2 = onlinePlayerState.isMix();
        onlinePlayerState.getActiveSession().updatePlaybackMode(bl, bl2);
        int n = bl ? 3 : 4;
        this.getPlayer().playbackModeChanged(n, bl2);
        this.getPlayer().setHMIPlaybackMode();
    }

    public void onAudioSettingsChanged() {
    }
}

