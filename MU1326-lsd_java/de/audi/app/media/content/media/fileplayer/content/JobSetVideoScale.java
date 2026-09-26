/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.content.media.fileplayer.content;

import de.audi.app.media.content.media.fileplayer.content.AbstractFilePlayerJob;
import de.audi.app.media.content.media.fileplayer.content.IFilePlayer;
import de.audi.app.media.content.media.fileplayer.content.VideoScaling;
import de.audi.atip.log.LogChannel;

public class JobSetVideoScale
extends AbstractFilePlayerJob {
    private static final String LOGCLASS;
    private final VideoScaling videoScaling;

    public JobSetVideoScale(LogChannel logChannel, IFilePlayer iFilePlayer, int n, int n2, int n3, int n4) {
        super(logChannel, "VIDEOSCALING", iFilePlayer);
        this.videoScaling = new VideoScaling(n, n2, n3, n4);
    }

    @Override
    public void start() {
        this.logger.log(14808325, "[%1.start]", (Object)"JobSetVideoScale");
        this.getPlayer().getState().setVideoScaling(this.videoScaling);
        this.getExecutionContext().jobFinished();
    }
}

