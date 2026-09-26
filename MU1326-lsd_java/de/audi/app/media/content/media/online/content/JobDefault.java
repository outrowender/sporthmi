/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobDefault
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS;

    public JobDefault(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "", iOnlinePlayer);
    }

    @Override
    public void start() {
    }

    @Override
    public void onPlaybackStateChanged() {
        this.logger.log(14808325, "[%1.onPlaybackStateChanged]", (Object)"JobDefault");
        this.setSessionPlaybackState();
    }

    @Override
    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

