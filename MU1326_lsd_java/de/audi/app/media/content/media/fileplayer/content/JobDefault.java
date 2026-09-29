/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.FilePlayerSession;
import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.atip.log.LogChannel;

public class JobDefault
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;

    public JobDefault(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "", iFilePlayer);
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
    public void onUpdatePlayPosition(int n, int n2) {
        FilePlayerSession filePlayerSession = this.getPlayer().getState().getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.updatePlayPosition(n, n2);
    }
}

