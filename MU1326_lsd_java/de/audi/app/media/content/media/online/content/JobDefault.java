/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.online.content;

import de.audi.app.media.content.media.online.content.AbstractOnlinePlayerJob;
import de.audi.app.media.content.media.online.content.IOnlinePlayer;
import de.audi.atip.log.LogChannel;

public class JobDefault
extends AbstractOnlinePlayerJob {
    private static final String LOGCLASS = "JobDefault";

    public JobDefault(LogChannel logChannel, IOnlinePlayer iOnlinePlayer) {
        super(logChannel, "", iOnlinePlayer);
    }

    public void start() {
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        this.setSessionPlaybackState();
    }

    public void onAudioSettingsChanged() {
        this.getPlayer().notifyAudioSettings();
    }
}

