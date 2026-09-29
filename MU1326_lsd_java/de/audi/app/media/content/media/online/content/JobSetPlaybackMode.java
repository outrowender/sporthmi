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
    private static final String LOGCLASS;
    private final int playbackMode;

    public JobSetPlaybackMode(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, int n) {
        super(logChannel, "JobSetPlaybackMode", iOnlinePlayer);
        this.playbackMode = n;
    }

    @Override
    public void start() {
        OnlinePlayerState onlinePlayerState = this.getPlayer().getState();
        if (!onlinePlayerState.supportsPlaybackModes()) {
            this.logger.log(1078071040, "[%1.start] repeat Title not supported.", (Object)"JobSetRepeatMode");
            this.getExecutionContext().jobFinished();
            return;
        }
        if (this.playbackMode == -1) {
            this.logger.log(1078071040, "[%1.start] playbackMode not found.", (Object)"JobSetRepeatMode");
            this.getExecutionContext().jobFinished();
            return;
        }
        if (this.playbackMode == onlinePlayerState.getCurrentPlaymode()) {
            this.logger.log(1078071040, "[%1.start] playbackMode already set.", (Object)"JobSetRepeatMode");
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
                this.logger.log(1078071040, "[%1.start] set repeat mode started.", (Object)"JobSetRepeatMode");
                this.getPlayer().setPlaybackMode(this.playbackMode);
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Wrong state.", (Object)"JobSetRepeatMode");
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onCapabilitiesChanged(Capabilities capabilities) {
        super.onCapabilitiesChanged(capabilities);
        if (!capabilities.playbackModes) {
            this.logger.log(1078071040, "[%1.onCapabilitiesChanged] Capability PlayMode not available.", (Object)"JobSetRepeatMode");
            this.getExecutionContext().jobFinished();
        }
    }

    @Override
    public void onUpdatePlaybackMode() {
        this.logger.log(14808325, "[%1.onUpdatePlaybackMode] playback mode received.", (Object)"JobSetRepeatMode");
        this.getPlayer().setHMIPlaybackMode();
        super.onUpdatePlaybackMode();
        this.getExecutionContext().jobFinished();
    }

    @Override
    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

