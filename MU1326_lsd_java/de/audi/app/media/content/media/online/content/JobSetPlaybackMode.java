/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.app.media.content.media.online.content.OnlinePlayerState;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.media.Capabilities;

public class JobSetPlaybackMode
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobSetRepeatMode";
    private final int playbackMode;

    public JobSetPlaybackMode(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, int n) {
        super(logChannel, "JobSetPlaybackMode", iOnlinePlayer);
        this.playbackMode = n;
    }

    public void start() {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        if (!onlinePlayerState.supportsPlaybackModes()) {
            this.logger.log(1000000, "[%1.start] repeat Title not supported.", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
            return;
        }
        if (this.playbackMode == -1) {
            this.logger.log(1000000, "[%1.start] playbackMode not found.", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
            return;
        }
        if (this.playbackMode == onlinePlayerState.getCurrentPlaymode()) {
            this.logger.log(1000000, "[%1.start] playbackMode already set.", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
            return;
        }
        switch (onlinePlayerState.getPlaybackState()) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                onlinePlayerState.setPlaybackMode(this.playbackMode);
                this.logger.log(1000000, "[%1.start] set repeat mode started.", (Object)LOGCLASS);
                this.getPlayer().setPlaybackMode(this.playbackMode);
                break;
            }
            default: {
                this.logger.log(1000000, "[%1.start] Wrong state.", (Object)LOGCLASS);
                this.getExecutionContext().jobFinished();
            }
        }
    }

    public void onCapabilitiesChanged(Capabilities capabilities) {
        super.onCapabilitiesChanged(capabilities);
        if (!capabilities.playbackModes) {
            this.logger.log(1000000, "[%1.onCapabilitiesChanged] Capability PlayMode not available.", (Object)LOGCLASS);
            this.getExecutionContext().jobFinished();
        }
    }

    public void onUpdatePlaybackMode() {
        this.logger.log(100000000, "[%1.onUpdatePlaybackMode] playback mode received.", (Object)LOGCLASS);
        this.getPlayer().setHMIPlaybackMode();
        super.onUpdatePlaybackMode();
        this.getExecutionContext().jobFinished();
    }

    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

