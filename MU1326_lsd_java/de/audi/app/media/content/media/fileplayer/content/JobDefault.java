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
    private static final String LOGCLASS = "JobDefault";

    public JobDefault(LogChannel logChannel, IFilePlayer iFilePlayer) {
        super(logChannel, "", iFilePlayer);
    }

    public void start() {
    }

    public void onPlaybackStateChanged() {
        this.logger.log(100000000, "[%1.onPlaybackStateChanged]", (Object)LOGCLASS);
        this.setSessionPlaybackState();
    }

    public void onUpdatePlayPosition(int n, int n2) {
        FilePlayerSession filePlayerSession = this.getPlayer().getState().getActiveSession();
        if (filePlayerSession == null) {
            return;
        }
        filePlayerSession.updatePlayPosition(n, n2);
    }
}

