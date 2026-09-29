/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobSkip
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS;
    private final int count;

    public JobSkip(LogChannel logChannel, IOnlinePlayer iOnlinePlayer, int n) {
        super(logChannel, "SKIP", iOnlinePlayer);
        this.count = n;
    }

    @Override
    public void start() {
        if (!this.getPlayer().getState().isSkipSupported()) {
            this.logger.log(1078071040, "[%1.start] Skip not supported.", (Object)"JobSkip");
            this.getExecutionContext().jobFinished();
            return;
        }
        switch (this.getPlayer().getState().getPlaybackState()) {
            case 3: 
            case 5: 
            case 6: 
            case 7: 
            case 8: 
            case 9: {
                this.logger.log(1078071040, "[%1.start] Skip started.", (Object)"JobSkip");
                this.getPlayer().skip(this.count);
                this.getExecutionContext().jobFinished();
                break;
            }
            default: {
                this.logger.log(1078071040, "[%1.start] Wrong state.", (Object)"JobSkip");
                this.getExecutionContext().jobFinished();
            }
        }
    }

    @Override
    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

